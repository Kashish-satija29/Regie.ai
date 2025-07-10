package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

import com.automation.utils.ExtentReportManager;
public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;



    @BeforeSuite
    public void setupExtentReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/extentReport.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser", "Chrome");
    }

    @BeforeMethod
    public void setUp(Method method) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // EXTENT TEST INIT PER METHOD
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
