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
package mule.v4.blocks;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HttpListenerTest extends AbstractBlockTest {

    @Test
    public void testBasicHttpListener() {
        testMule4ToBal("http-listener/basic_http_listener.xml", "http-listener/basic_http_listener.bal");
    }

    @Test
    public void testEmptyAbsolutePath() {
        testMule4ToBal("http-listener/empty_absolute_path.xml", "http-listener/empty_absolute_path.bal");
    }

    @Test
    public void testEmptyResourcePath() {
        testMule4ToBal("http-listener/empty_resource_path.xml", "http-listener/empty_resource_path.bal");
    }

    @Test
    public void testEmptyAbsoluteAndResourcePaths() {
        testMule4ToBal("http-listener/empty_absolute_and_resource_paths.xml",
                "http-listener/empty_absolute_and_resource_paths.bal");
    }

    @Test
    public void testSpecialCharactersInResourcePath() {
        testMule4ToBal("http-listener/special_characters_in_resource_path.xml",
                "http-listener/special_characters_in_resource_path.bal");
    }

    @Test
    public void testResourceUriParams() {
        testMule4ToBal("http-listener/resource_uri_params.xml", "http-listener/resource_uri_params.bal");
    }

    @Test
    public void testQueryParams() {
        testMule4ToBal("http-listener/query_params.xml", "http-listener/query_params.bal");
    }

    @Test(dataProvider = "httpMethodsTestData")
    public void testAllowedResourceMethods(String inputFile, String outputFile) {
        testMule4ToBal(inputFile, outputFile);
    }

    @DataProvider(name = "httpMethodsTestData")
    public Object[][] httpMethodsTestData() {
        return new Object[][] {
                // test POST
                {"http-listener/allowed_resource_post_method.xml", "http-listener/allowed_resource_post_method.bal"},
                // test GET, POST, DELETE
                {"http-listener/allowed_resource_multiple_methods.xml",
                        "http-listener/allowed_resource_multiple_methods.bal"},
                // test default
                {"http-listener/allowed_resource_default_methods.xml",
                        "http-listener/allowed_resource_default_methods.bal"}
        };
    }

    @Test
    public void testListenerWithLocalhost() {
        testMule4ToBal("http-listener/http_listener_with_localhost.xml",
                "http-listener/http_listener_with_localhost.bal");
    }

    @Test
    public void testListenerAttributes() {
        testMule4ToBal("http-listener/http_listener_attributes.xml", "http-listener/http_listener_attributes.bal");
    }
}
