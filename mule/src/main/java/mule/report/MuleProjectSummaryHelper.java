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
package mule.report;

import common.ProjectSummary;
import mule.Context;
import mule.model.MuleXMLTag;

import java.util.LinkedHashMap;

import static mule.report.HtmlReportWriter.AVG_CASE_COMP_TIME;
import static mule.report.HtmlReportWriter.AVG_CASE_DW_EXPR_TIME;
import static mule.report.HtmlReportWriter.BEST_CASE_COMP_TIME;
import static mule.report.HtmlReportWriter.BEST_DW_EXPR_TIME;
import static mule.report.HtmlReportWriter.WORST_CASE_COMP_TIME;
import static mule.report.HtmlReportWriter.WORST_CASE_DW_EXPR_TIME;

/**
 * Helper class to create ProjectSummary from MigrationMetrics for Mule projects.
 */
public class MuleProjectSummaryHelper {

    /**
     * Creates a ProjectSummary from MigrationMetrics.
     *
     * @param metrics      The migration metrics
     * @param projectName  The name of the project
     * @param projectPath  The path to the project
     * @param reportPath   The path to the individual report file
     * @return A ProjectSummary instance
     */
    public static ProjectSummary createProjectSummary(Context.MigrationMetrics metrics, String projectName, 
                                                      String projectPath, String reportPath) {
        int totalElements = countTotalElements(metrics);
        int unhandledElements = countUnhandledElements(metrics);
        int totalDWExpressions = countUnsupportedDWExpressions(metrics);
        
        // Calculate conversion percentage
        double conversionPercentage = calculateConversionPercentage(metrics);
        
        // Calculate time estimation
        double bestCaseDays = calculateBestCaseEstimate(unhandledElements, totalDWExpressions);
        double averageCaseDays = calculateAverageCaseEstimate(unhandledElements, totalDWExpressions);
        double worstCaseDays = calculateWorstCaseEstimate(unhandledElements, totalDWExpressions);
        
        int bestCaseWeeks = (int) Math.ceil(bestCaseDays / 5.0);
        int averageCaseWeeks = (int) Math.ceil(averageCaseDays / 5.0);
        int worstCaseWeeks = (int) Math.ceil(worstCaseDays / 5.0);
        
        ProjectSummary.TimeEstimation timeEstimation = new ProjectSummary.TimeEstimation(
                (int) bestCaseDays, (int) averageCaseDays, (int) worstCaseDays,
                bestCaseWeeks, averageCaseWeeks, worstCaseWeeks
        );
        
        return new ProjectSummary(
                projectName,
                projectPath,
                reportPath,
                totalElements,
                unhandledElements,
                conversionPercentage,
                timeEstimation
        );
    }

    private static int countTotalElements(Context.MigrationMetrics metrics) {
        int totalPassed = calculateTotalWeight(metrics.passedXMLTags);
        int totalFailed = calculateTotalWeight(metrics.failedXMLTags);
        int totalDW = metrics.dwConversionStats.getTotalWeight();
        return totalPassed + totalFailed + totalDW;
    }

    private static int countUnhandledElements(Context.MigrationMetrics metrics) {
        int failedElements = countDistinctUnsupportedElements(metrics.failedXMLTags);
        int failedDWExpressions = countUnsupportedDWExpressions(metrics);
        return failedElements + failedDWExpressions;
    }

    private static double calculateConversionPercentage(Context.MigrationMetrics metrics) {
        int totalPassedWeight = calculateTotalWeight(metrics.passedXMLTags);
        int totalFailedWeight = calculateTotalWeight(metrics.failedXMLTags);
        int dwTotalWeight = metrics.dwConversionStats.getTotalWeight();
        int dwConvertedWeight = metrics.dwConversionStats.getConvertedWeight();

        int combinedTotalWeight = totalPassedWeight + totalFailedWeight + dwTotalWeight;
        int combinedConvertedWeight = totalPassedWeight + dwConvertedWeight;

        return combinedTotalWeight == 0 ? 0.0 : (double) (combinedConvertedWeight * 100) / combinedTotalWeight;
    }

    private static int calculateTotalWeight(LinkedHashMap<String, Integer> tagMap) {
        return tagMap.entrySet().stream()
                .mapToInt(entry -> MuleXMLTag.getWeightFromTag(entry.getKey()) * entry.getValue())
                .sum();
    }

    private static double calculateBestCaseEstimate(int elements, int dwExpressions) {
        return elements * BEST_CASE_COMP_TIME + dwExpressions * BEST_DW_EXPR_TIME;
    }

    private static double calculateAverageCaseEstimate(int elements, int dwExpressions) {
        return elements * AVG_CASE_COMP_TIME + dwExpressions * AVG_CASE_DW_EXPR_TIME;
    }

    private static double calculateWorstCaseEstimate(int elements, int dwExpressions) {
        return elements * WORST_CASE_COMP_TIME + dwExpressions * WORST_CASE_DW_EXPR_TIME;
    }

    private static int countDistinctUnsupportedElements(LinkedHashMap<String, Integer> failedTags) {
        return failedTags.size();
    }

    private static int countUnsupportedDWExpressions(Context.MigrationMetrics metrics) {
        return metrics.dwConversionStats.getFailedDWExpressions().size();
    }
}