package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.TimeZone;

public class ExtentReportManager {
    public static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {


            System.setProperty("user.timezone", "Asia/Kolkata");
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));

            String reportPath = System.getProperty("user.dir") + "/reports/extentReport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);


            reporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");
            reporter.config().setReportName("UI Automation Report");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Kashish Satija");
        }
        return extent;
    }
}
