/*
 *  Copyright (c) 2025, WSO2 LLC. (http://www.wso2.com).
 *
 *  WSO2 LLC. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package tibco.converter;

import common.LoggingUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tibco.ConversionContext;
import tibco.ProjectConversionContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class TibcoProjectConversionTest {

    @Test(groups = {"tibco", "converter"}, dataProvider = "projectTestCaseProvider")
    public void testProjectConversion(Path tibcoProject, Path expectedBallerinaProject) throws IOException {
        // Create a temporary directory for the output
        Path tempDir = Files.createTempDirectory("tibco-conversion-test");
        // Create a ProjectConversionContext with verbose logger for test
        Logger logger = TibcoConverter.createVerboseLogger("test");
        var stateCallback = LoggingUtils.wrapLoggerForStateCallback(logger);
        var logCallback = LoggingUtils.wrapLoggerForStateCallback(logger);
        ConversionContext conversionContext = new ConversionContext(
                "testOrg", false, false, stateCallback, logCallback);
        ProjectConversionContext cx =
                new ProjectConversionContext(conversionContext, expectedBallerinaProject.getFileName().toString());
        try {
            if ("true".equalsIgnoreCase(System.getenv("BLESS"))) {
                TibcoConverter.migrateTibcoProject(cx, tibcoProject.toString(), expectedBallerinaProject.toString()
                );
            }
            // Run the conversion
            TibcoConverter.migrateTibcoProject(cx, tibcoProject.toString(), tempDir.toString());

            // Compare the directories
            compareDirectories(tempDir, expectedBallerinaProject);
        } finally {
            // Clean up temporary directory
            deleteDirectory(tempDir);
        }
    }

    @Test(groups = {"tibco", "converter"}, dataProvider = "projectTestCaseProvider")
    public void testProjectConversionByAPI(Path tibcoProject, Path expectedBallerinaProject) throws IOException {
        // Create parameter map for the API
        java.util.Map<String, Object> parameters = java.util.Map.of(
                "orgName", "testOrg",
                "projectName", expectedBallerinaProject.getFileName().toString(),
                "sourcePath", tibcoProject.toString(),
                "stateCallback", (java.util.function.Consumer<String>) s -> {
                },
                "logCallback", (java.util.function.Consumer<String>) s -> {
                }
        );
        
        // Run the conversion using the new public API
        var result = tibco.TibcoToBalConverter.migrateTIBCO(parameters);
        Assert.assertNotNull(result, "migrateTIBCO returned null");
        Assert.assertFalse(result.containsKey("error"), "Conversion failed with error: " + result.get("error"));
        Assert.assertTrue(result.containsKey("textEdits"), "Result does not contain 'textEdits'");
        @SuppressWarnings("unchecked")
        var textEdits = (java.util.Map<String, String>) result.get("textEdits");
        Assert.assertNotNull(textEdits, "textEdits is null");

        // Collect expected .bal files (except types.bal)
        try (Stream<Path> expectedFiles = Files.walk(expectedBallerinaProject)) {
            var expectedPaths = expectedFiles
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".bal") || path.toString().endsWith(".toml"))
                    .map(expectedBallerinaProject::relativize)
                    .toList();

            // Check all expected .bal files exist in textEdits and match content
            for (Path relativePath : expectedPaths) {
                if (relativePath.endsWith("types.bal")) {
                    continue;
                }
                String key = relativePath.toString().replace('\\', '/');
                Assert.assertTrue(textEdits.containsKey(key), "Missing .bal file in textEdits: " + key);
                String actualContent = textEdits.get(key);
                String expectedContent = Files.readString(expectedBallerinaProject.resolve(relativePath));
                Assert.assertEquals(actualContent, expectedContent,
                        "File contents do not match for: " + key);
            }

            // Check for extra .bal files in textEdits
            for (String key : textEdits.keySet()) {
                if (key.endsWith("types.bal")) {
                    continue;
                }
                Path relPath = Path.of(key);
                if (!expectedPaths.contains(relPath)) {
                    Assert.fail("Extra .bal file in textEdits: " + key);
                }
            }
        }
    }

    private void compareDirectories(Path actual, Path expected) throws IOException {
        // First check if both directories exist
        Assert.assertTrue(Files.isDirectory(actual), "Actual path is not a directory: " + actual);
        Assert.assertTrue(Files.isDirectory(expected), "Expected path is not a directory: " + expected);

        // Compare directory contents
        try (Stream<Path> expectedFiles = Files.walk(expected);
             Stream<Path> actualFiles = Files.walk(actual)) {

            // Get relative paths for comparison, filtering only .bal files
            var expectedPaths = expectedFiles
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".bal"))
                    .map(expected::relativize)
                    .toList();

            var actualPaths = actualFiles
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".bal"))
                    .map(actual::relativize)
                    .toList();

            // Check if all expected .bal files exist
            for (Path relativePath : expectedPaths) {
                if (relativePath.endsWith("types.bal")) {
                    // Skip types.bal as it is generated and may differ
                    continue;
                }
                Assert.assertTrue(actualPaths.contains(relativePath),
                        "Missing .bal file in actual directory: " + relativePath);

                // Compare file contents
                Path expectedFile = expected.resolve(relativePath);
                Path actualFile = actual.resolve(relativePath);
                compareFiles(actualFile, expectedFile);
            }

            // Check for extra .bal files
            for (Path relativePath : actualPaths) {
                if (relativePath.endsWith("types.bal")) {
                    // Skip types.bal as it is generated and may differ
                    continue;
                }
                Assert.assertTrue(expectedPaths.contains(relativePath),
                        "Extra .bal file in actual directory: " + relativePath);
            }
        }
    }

    private void compareFiles(Path actual, Path expected) throws IOException {
        if (actual.toString().contains("types") || actual.toString().contains(".html")) {
            // These are generated by XSD core and change from run to run
            return;
        }
        String actualContent = Files.readString(actual);
        String expectedContent = Files.readString(expected);
        Assert.assertEquals(actualContent, expectedContent,
                "File contents do not match for: " + actual.getFileName());
    }

    private void deleteDirectory(Path directory) throws IOException {
        if (Files.exists(directory)) {
            Files.walk(directory)
                    .sorted((a, b) -> -a.compareTo(b)) // Reverse order to delete files before directories
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                        } catch (IOException e) {
                            throw new RuntimeException("Failed to delete: " + path, e);
                        }
                    });
        }
    }

    @Test(groups = {"tibco", "converter"})
    public void testMigrateTIBCOAPIErrorHandling() {
        // Test missing parameter
        Map<String, Object> emptyParams = new HashMap<>();
        var result1 = tibco.TibcoToBalConverter.migrateTIBCO(emptyParams);
        Assert.assertTrue(result1.containsKey("error"), "Should return error for missing parameters");
        Assert.assertTrue(result1.get("error").toString().contains("Missing required parameter"),
                "Error message should mention missing parameter");

        // Test wrong type parameter
        Map<String, Object> wrongTypeParams = new HashMap<>();
        wrongTypeParams.put("orgName", 123); // Should be String, not Integer
        var result2 = tibco.TibcoToBalConverter.migrateTIBCO(wrongTypeParams);
        Assert.assertTrue(result2.containsKey("error"), "Should return error for wrong parameter type");
        Assert.assertTrue(result2.get("error").toString().contains("must be a String"),
                "Error message should mention type mismatch");

        // Test missing some parameters
        Map<String, Object> partialParams = new HashMap<>();
        partialParams.put("orgName", "testOrg");
        partialParams.put("projectName", "testProject");
        // Missing sourcePath, stateCallback, logCallback
        var result3 = tibco.TibcoToBalConverter.migrateTIBCO(partialParams);
        Assert.assertTrue(result3.containsKey("error"), "Should return error for missing parameters");
    }

    @DataProvider
    public Object[][] projectTestCaseProvider() throws IOException {
        Path projectTestCaseDir = Path.of("src", "test", "resources", "tibco.projects");
        Path expectedConvertedResultsDir = Path.of("src", "test", "resources", "tibco.projects.converted");

        // Get only the immediate directories (non-recursive)
        return Files.list(projectTestCaseDir)
                .filter(Files::isDirectory)
                .map(dir -> new Object[]{
                        dir,
                        expectedConvertedResultsDir.resolve(dir.getFileName())
                })
                .toArray(Object[][]::new);
    }
}
