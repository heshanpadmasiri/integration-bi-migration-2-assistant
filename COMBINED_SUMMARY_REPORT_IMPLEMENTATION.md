# Combined Summary Report Implementation

## Overview
This implementation changes the current combined report approach from appending each report per project to creating a combined summary report with project summaries and links to individual project reports.

## Changes Made

### 1. Common Components Created

#### `ProjectSummary` Record (`common/src/main/java/common/ProjectSummary.java`)
- New record type to hold project summary data
- Contains:
  - Project name, path, and report path
  - Total and unhandled element counts  
  - Successful conversion percentage
  - Time estimation (best/average/worst case in days and weeks)

#### `CombinedSummaryReport` Class (`common/src/main/java/common/CombinedSummaryReport.java`)
- Generates HTML combined summary reports
- Features:
  - Overall statistics across all projects
  - Project summaries table with links to individual reports
  - Overall time estimation aggregated from all projects
  - Modern, responsive UI similar to existing reports

### 2. TIBCO Changes

#### `TibcoAnalysisReport` Updates (`tibco/src/main/java/tibco/analyzer/TibcoAnalysisReport.java`)
- Added `toProjectSummary()` method to create ProjectSummary from analysis results
- Calculates conversion percentage and time estimation based on unique unhandled activity types

#### `TibcoConverter` Updates (`tibco/src/main/java/tibco/converter/TibcoConverter.java`)
- Modified `migrateTibcoMultiRoot()` method to:
  - Generate individual reports for each project
  - Collect project summaries
  - Create combined summary report instead of aggregated report
- Added `writeCombinedSummaryReport()` method

### 3. Mule Changes

#### `MuleProjectSummaryHelper` Class (`mule/src/main/java/mule/report/MuleProjectSummaryHelper.java`)
- Helper class to create ProjectSummary from MigrationMetrics
- Calculates conversion percentage and time estimation for Mule projects
- Handles both XML components and DataWeave expressions

#### `MuleMigrationExecutor` Updates (`mule/src/main/java/mule/MuleMigrationExecutor.java`)
- Added multi-root support with `migrateMuleMultiRoot()` method
- Refactored existing methods to support Context parameter passing
- Added `writeCombinedSummaryReport()` method
- Updated public API to include `multiRoot` parameter

#### `MigrateMuleCommand` Updates (`cli-mule/src/main/java/baltool/mule/commands/MigrateMuleCommand.java`)
- Added `--multi-root` / `-m` command line option
- Updated usage documentation and help text
- Added validation (multi-root requires dry-run mode)

### 4. Report Structure

#### Individual Reports
- Each project generates its own detailed report as before
- Saved in `{project_name}_converted/report.html`

#### Combined Summary Report
- Created at the root level as `combined_summary_report.html`
- Contains:
  - Overall statistics (total projects, elements, conversion percentage)
  - Project summaries table with links to individual reports
  - Aggregated time estimation across all projects
  - Modern, responsive UI

## Usage Examples

### TIBCO Multi-Root Processing
```bash
# Existing command (already supported)
bal migrate-tibco /path/to/projects-directory --multi-root --dry-run
```

### Mule Multi-Root Processing
```bash
# New command 
bal migrate-mule /path/to/projects-directory --multi-root --dry-run
```

## Key Benefits

1. **Better Organization**: Individual project reports are preserved while providing a high-level overview
2. **Improved Navigation**: Links between summary and detailed reports
3. **Enhanced Usability**: Summary view for quick assessment, detailed view for deep analysis
4. **Consistency**: Both TIBCO and Mule systems now support the same approach
5. **Scalability**: Better suited for processing multiple projects

## Technical Details

- **Multi-root processing**: Only available in dry-run mode for safety
- **Report linking**: Uses relative paths for portability
- **Time estimation**: Aggregated from individual project estimates
- **Responsive design**: Modern CSS with hover effects and mobile-friendly layout
- **Error handling**: Graceful handling of invalid projects and missing dependencies

## Migration Notes

- Existing single-project functionality remains unchanged
- Multi-root behavior for TIBCO has been updated to use the new approach
- All existing CLI options and APIs remain backward compatible
- The change only affects the multi-root combined report generation