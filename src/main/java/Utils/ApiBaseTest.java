package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class ApiBaseTest {
    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeSuite
    public void setupExtentReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/extentReport.html");
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void setupTest(Method method) {
        test = extent.createTest(method.getName());
    }

    @AfterSuite
    public void flushExtentReport() {
        extent.flush();
    }
}

