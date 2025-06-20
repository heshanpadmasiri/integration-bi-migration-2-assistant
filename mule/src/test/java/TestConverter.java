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
import io.ballerina.compiler.syntax.tree.SyntaxTree;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import static mule.MuleMigrationExecutor.testConvertMuleProject;
import static mule.MuleToBalConverter.convertStandaloneXMLFileToBallerina;

public class TestConverter {

    private static final PrintStream OUT = System.out;

    @Test(description = "Test converting standalone mule xml file")
    public void convertAndPrintMuleXMLFile() {
        OUT.println("Generating Ballerina code...");
        SyntaxTree syntaxTree = convertStandaloneXMLFileToBallerina("src/test/resources/test_converter.xml");
        OUT.println("________________________________________________________________");
        OUT.println(syntaxTree.toSourceCode());
        OUT.println("________________________________________________________________");
    }

    @Test(description = "Test converting mule project")
    public void testMuleProjectConversionWithBiStructure() {
        Path balProjectDir = Path.of("src/test/resources/projects/demo_project_bi/demo_project_bi_ballerina");
        if (Files.exists(balProjectDir)) {
            try {
                deleteDirectory(balProjectDir);
            } catch (IOException e) {
                throw new RuntimeException("Issue deleting directory: " + balProjectDir, e);
            }
        }

        OUT.println("Generating Ballerina package...");
        testConvertMuleProject("src/test/resources/projects/demo_project_bi", null, false, false, false);
        OUT.println("________________________________________________________________");
        OUT.println("Conversion completed. Output written to " +
                "src/test/resources/demo_project_bi/demo_project_bi_ballerina");
        OUT.println("________________________________________________________________");
    }

    @Test(description = "Test converting mule project")
    public void testMuleProjectConversionWithKeepStructure() {
        Path balProjectDir = Path.of("src/test/resources/projects/demo_project_classic/demo_project_classic_ballerina");
        if (Files.exists(balProjectDir)) {
            try {
                deleteDirectory(balProjectDir);
            } catch (IOException e) {
                throw new RuntimeException("Issue deleting directory: " + balProjectDir, e);
            }
        }

        OUT.println("Generating Ballerina package...");
        testConvertMuleProject("src/test/resources/projects/demo_project_classic", null, false, false, true);
        OUT.println("________________________________________________________________");
        OUT.println("Conversion completed. Output written to " +
                "src/test/resources/demo_project_classic/demo_project_classic_ballerina");
        OUT.println("________________________________________________________________");
    }

    private void deleteDirectory(Path path) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
