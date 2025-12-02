package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    private static ExtentReports extentReports;

    public static ExtentReports getInstance() {    // 👈 Este método lo pedía BaseTest
        if (extentReports == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/TestReport.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(reporter);
        }
        return extentReports;
    }
} 