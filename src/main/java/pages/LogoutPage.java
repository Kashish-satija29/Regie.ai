package pages;

import com.automation.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {

    WebDriver driver;


    private By logoutLink = By.xpath("//a[text()=' Logout']");
    private By signupLoginLink = By.xpath("//a[text()=' Signup / Login']");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickLogout(ExtentTest test) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
        test.info(" Clicked on Logout");
       ScreenshotUtil.takeScreenshot(driver, "afterLogoutClick");

    }


    public boolean isLoginLinkVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(signupLoginLink));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void capturePostLogoutScreen(ExtentTest test) {
        String postLogout = ScreenshotUtil.takeScreenshot(driver, "postLogoutVerification");
        test.info("Verified that 'Signup / Login' is visible after logout.");
        test.addScreenCaptureFromPath(postLogout);
    }
}
