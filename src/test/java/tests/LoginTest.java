package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import Utils.BaseTest;
import Utils.ConfigReader;
import utils.JsonDataReader;
import com.automation.utils.ScreenshotUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;




public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testValidLogin() {


        String url = ConfigReader.get("baseUrl");
        test.info("Navigating to: " + url);

        String email = JsonDataReader.get("validLogin", "email");
        String password = JsonDataReader.get("validLogin", "password");
        test.info("Using email: " + email);

        driver.get(url);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        Assert.assertTrue(loginPage.isLoggedIn(), "User should be logged in with valid credentials.");
        test.pass("Login successful");
    }



    @Test(priority = 2)
    public void testInvalidPassword() {

        String url = ConfigReader.get("baseUrl");
        String email = JsonDataReader.get("invalidPassword", "email");
        String password = JsonDataReader.get("invalidPassword", "password");

        driver.get(url);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        Assert.assertTrue(loginPage.isLoginErrorDisplayed(), "Error message should be displayed for invalid password.");
        test.pass("Proper error shown for invalid password");
    }

    @Test(priority = 3)
    public void testInvalidEmail() {

        String url = ConfigReader.get("baseUrl");
        String email = JsonDataReader.get("invalidEmail", "email");
        String password = JsonDataReader.get("invalidEmail", "password");

        driver.get(url);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        Assert.assertTrue(loginPage.isLoginErrorDisplayed(), "Error message should be displayed for invalid email.");
        test.pass("Proper error shown for invalid email");
    }
    @AfterMethod
    public void tearDown(ITestResult result) {

        ScreenshotUtil.takeScreenshot(driver, result.getName());

        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test Failed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Test Passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            System.out.println("Test Skipped: " + result.getName());
        }

        if (driver != null) {
            driver.quit();
        }
    }



}
