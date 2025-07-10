package tests;

import Utils.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import Utils.ConfigReader;

public class CartTest extends BaseTest {

    @Test
    public void testCartAfterLogin() {
        test = extent.createTest("Cart Test After Login");


        String url = ConfigReader.get("baseUrl");
        test.info("Navigating to URL: " + url);
        driver.get(url);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLogin();
        loginPage.login("kaishsatija@gmail.com", "12345678");

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCartButton();
        cartPage.handleCartCheckoutAndLogout(driver, test);
    }
}
