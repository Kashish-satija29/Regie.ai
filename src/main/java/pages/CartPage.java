package pages;

import com.automation.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    WebDriver driver;

    private By cartButton = By.xpath("//a[contains(@href, '/view_cart') and contains(text(), 'Cart')]");
    private By checkoutBtn = By.xpath("//a[text()='Proceed To Checkout']");
    private By emptyCartMsg = By.xpath("//*[contains(text(),'empty')]");
    private By logoutLink = By.xpath("//a[text()=' Logout']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }

    public void handleCartCheckoutAndLogout(WebDriver driver, ExtentTest test) {

            test.info("Cart has items. Proceeding to checkout...");
             ScreenshotUtil.takeScreenshot(driver, "cartWithItems");



            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement proceedBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Proceed To Checkout')]")));
            proceedBtn.click();

            test.info("Clicked on 'Proceed To Checkout'");
            ScreenshotUtil.takeScreenshot(driver, "afterCheckoutClick");




        WebElement logoutBtn = driver.findElement(By.xpath("//a[text()=' Logout']"));
        logoutBtn.click();

        test.info("Logged out successfully!");
        ScreenshotUtil.takeScreenshot(driver, "afterLogout");

    }


}
