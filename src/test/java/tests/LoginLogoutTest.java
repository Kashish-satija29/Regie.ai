package tests;

import Utils.BaseTest;
import Utils.ConfigReader;
import com.automation.utils.ScreenshotUtil;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

public class LoginLogoutTest extends BaseTest {

    @Test
    public void testLoginAndLogoutFlow() {

        String url = ConfigReader.get("baseUrl");
        test.info("Navigating to URL: " + url);
        driver.get(url);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLogin();
        loginPage.login("kaishsatija@gmail.com", "12345678");




        boolean loggedIn = loginPage.isLoggedIn();
        ScreenshotUtil.takeScreenshot(driver, "afterLogin");


        Assert.assertTrue(loggedIn, "Login should be successful");
        test.pass(" Login Successful");

        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.clickLogout(test);

        boolean loginLinkVisible = logoutPage.isLoginLinkVisible();
        ScreenshotUtil.takeScreenshot(driver, "afterLogout");


        Assert.assertTrue(loginLinkVisible, "Signup/Login link should be visible after logout");
        test.pass(" Logout Successful and Signup/Login link visible");
    }
}
