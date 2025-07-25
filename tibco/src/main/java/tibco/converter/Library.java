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

enum Library {
    HTTP("ballerina", "http"),
    XSLT("ballerina", "xslt"),
    XML_DATA("ballerina", "data.xmldata"),
    JSON_DATA("ballerina", "data.jsondata"),
    JMS("ballerinax", "java.jms"),
    JDBC("ballerinax", "java.jdbc"),
    RUNTIME("ballerina", "lang.runtime"),
    IO("ballerina", "io"),
    REGEX("ballerina", "regex"),
    LOG("ballerina", "log"),
    FILE("ballerina", "file"),
    SOAP("ballerina", "soap.soap11"),
    SQL("ballerina", "sql");

    public final String moduleName;
    public final String orgName;

    Library(String orgName, String moduleName) {
        this.moduleName = moduleName;
        this.orgName = orgName;
    }
}
