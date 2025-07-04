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
package mule.v3.report;

import mule.v3.Context;
import mule.v3.dataweave.converter.DWConversionStats;
import mule.v3.model.MuleXMLTag;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;

import static mule.v3.MuleMigrationExecutor.logger;

public class MigrationReportWriter {

    public static final double BEST_CASE_COMP_TIME = 1;
    public static final double AVG_CASE_COMP_TIME = 2;
    public static final double WORST_CASE_COMP_TIME = 3;

    public static final double BEST_DW_EXPR_TIME = 0.0625; // 30min
    public static final double AVG_CASE_DW_EXPR_TIME = 0.125; // 1 hour
    public static final double WORST_CASE_DW_EXPR_TIME = 0.25; // 2 hours

    public static final String MIGRATION_REPORT_NAME = "migration_report.html";
    public static final String MIGRATION_SUMMARY_TITLE = "Migration Summary";
    public static final String MIGRATION_ASSESSMENT_TITLE = "Migration Assessment";

    public static void genAndWriteMigrationReport(ProjectMigrationSummary projSummary) {
        String reportTitle = projSummary.dryRun() ? MIGRATION_ASSESSMENT_TITLE : MIGRATION_SUMMARY_TITLE;
        try {
            String reportContent = generateReport(projSummary, reportTitle);
            Files.writeString(projSummary.reportFilePath(), reportContent);
            logger().info("'%s' report written to %s".formatted(reportTitle, projSummary.reportFilePath()));
        } catch (IOException e) {
            logger().severe("Error writing report to file: " + e.getMessage());
        }
    }

    private static String generateReport(ProjectMigrationSummary pms, String reportTitle) {
        logger().info("Generating migration assessment report...");
        String unsupportedElementsTable = generateUnsupportedElementsTable(pms.failedXMLTags());
        String unsupportedBlocksHtml = generateUnsupportedBlocksHtml(pms.failedBlocks());
        String dataweaveExpressionsHtml = generateDataweaveExpressionsHtml(pms.dwConversionStats());

        return String.format(
                MigrationReportTemplate.getHtmlTemplate(),
                reportTitle,
                reportTitle,
                pms.migrationCoverage(),
                pms.bestCaseDays(), (int) Math.ceil(pms.bestCaseDays() / 5.0),
                pms.averageCaseDays(), (int) Math.ceil(pms.averageCaseDays() / 5.0),
                pms.worstCaseDays(), (int) Math.ceil(pms.worstCaseDays() / 5.0),
                BEST_CASE_COMP_TIME, BEST_DW_EXPR_TIME,
                AVG_CASE_COMP_TIME, AVG_CASE_DW_EXPR_TIME,
                WORST_CASE_COMP_TIME, WORST_CASE_DW_EXPR_TIME,
                pms.failedXMLTags().size(),
                pms.failedDWExprCount(),
                unsupportedElementsTable,
                unsupportedBlocksHtml,
                dataweaveExpressionsHtml
        );
    }

    public static ProjectMigrationSummary getProjectMigrationSummary(String sourceProjectName,
                                                                     String balPackageName,
                                                                     Path balPackageDir,
                                                                     boolean dryRun,
                                                                     Context.MigrationMetrics metrics) {
        int distinctUnsupportedElementCount = countDistinctUnsupportedElements(metrics.failedXMLTags);
        int failedDWExprCount = countUnsupportedDWExpressions(metrics.dwConversionStats);

        // Calculate implementation times
        double bestCaseDays = calculateBestCaseEstimate(distinctUnsupportedElementCount, failedDWExprCount);
        double avgCaseDays = calculateAverageCaseEstimate(distinctUnsupportedElementCount, failedDWExprCount);
        double worstCaseDays = calculateWorstCaseEstimate(distinctUnsupportedElementCount, failedDWExprCount);

        int migrationCoverage = calculateMigrationCoverage(metrics);
        Path reportFilePath = balPackageDir.resolve(MIGRATION_REPORT_NAME);

        return new ProjectMigrationSummary(sourceProjectName, balPackageName, reportFilePath, dryRun,
                metrics.failedXMLTags, metrics.failedBlocks, metrics.dwConversionStats,
                migrationCoverage, bestCaseDays, avgCaseDays, worstCaseDays,
                metrics.failedXMLTags.size(), failedDWExprCount);
    }

    private static int calculateMigrationCoverage(Context.MigrationMetrics metrics) {
        int totalPassedWeight = calculateTotalWeight(metrics.passedXMLTags);
        int totalFailedWeight = calculateTotalWeight(metrics.failedXMLTags);
        int dwTotalWeight = metrics.dwConversionStats.getTotalWeight();
        int dwConvertedWeight = metrics.dwConversionStats.getConvertedWeight();

        int combinedTotalWeight = totalPassedWeight + totalFailedWeight + dwTotalWeight;
        int combinedConvertedWeight = totalPassedWeight + dwConvertedWeight;

        return combinedTotalWeight == 0 ? 0 : (combinedConvertedWeight * 100) / combinedTotalWeight;
    }

    private static int calculateTotalWeight(LinkedHashMap<String, Integer> tagMap) {
        return tagMap.entrySet().stream()
                .mapToInt(entry -> MuleXMLTag.getWeightFromTag(entry.getKey()) * entry.getValue())
                .sum();
    }

    private static String generateUnsupportedElementsTable(LinkedHashMap<String, Integer> failedTags) {
        StringBuilder sb = new StringBuilder();
        failedTags.forEach((tag, frequency) ->
            sb.append(String.format("<tr><td><code>%s</code></td><td>%d</td></tr>\n", tag, frequency))
        );
        return sb.toString();
    }

    private static String generateUnsupportedBlocksHtml(List<String> failedBlocks) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < failedBlocks.size(); i++) {
            sb.append(String.format("""
                <div class="block-item">
                    <div class="block-header">
                        <span class="block-number">Block #%d</span>
                        <span class="block-type">%s</span>
                    </div>
                    <pre class="block-code"><code>%s</code></pre>
                </div>
                """,
                i + 1,
                getBlockType(failedBlocks.get(i)),
                failedBlocks.get(i)));
        }
        return sb.toString();
    }

    private static String generateDataweaveExpressionsHtml(DWConversionStats dwStats) {
        StringBuilder sb = new StringBuilder();
        int expressionCount = 1;
        for (String dwExpr : dwStats.getFailedDWExpressions()) {
            sb.append("<div class=\"block-item\"><div class=\"block-header\">");
            sb.append("<span class=\"block-number\">Expression #").append(expressionCount++).append("</span>");
            sb.append("<span class=\"block-type\">").append("Dataweave Expression").append("</span>");
            sb.append("</div><pre class=\"block-code\">").append(dwExpr).append("</pre></div>");
        }
        return sb.toString();
    }

    private static String getBlockType(String block) {
        if (block.contains("<")) {
            int start = block.indexOf("<") + 1;
            int end = block.indexOf(" ", start);
            if (end == -1) {
                end = block.indexOf(">", start);
            }
            return end != -1 ? block.substring(start, end) : "Unknown";
        }
        return "Unknown";
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

    private static int countUnsupportedDWExpressions(DWConversionStats dwStats) {
        return dwStats.getFailedDWExpressions().size();
    }
}
