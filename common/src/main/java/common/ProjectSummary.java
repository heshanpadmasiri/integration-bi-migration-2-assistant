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

package common;

/**
 * Record to hold project summary data for combined reporting.
 */
public record ProjectSummary(
        String projectName,
        String projectPath,
        String reportPath,
        int totalElementCount,
        int unhandledElementCount,
        double successfulConversionPercentage,
        TimeEstimation timeEstimation
) {
    /**
     * Record to hold time estimation data.
     */
    public record TimeEstimation(
            int bestCaseDays,
            int averageCaseDays,
            int worstCaseDays,
            int bestCaseWeeks,
            int averageCaseWeeks,
            int worstCaseWeeks
    ) {
    }

    /**
     * Calculate the successful conversion percentage.
     *
     * @return The percentage of successful conversions (0-100)
     */
    public double getSuccessfulConversionPercentage() {
        return successfulConversionPercentage;
    }

    /**
     * Get the number of unique unhandled element types for time estimation.
     *
     * @return The number of unique unhandled element types
     */
    public int getUniqueUnhandledElementCount() {
        return unhandledElementCount;
    }
}