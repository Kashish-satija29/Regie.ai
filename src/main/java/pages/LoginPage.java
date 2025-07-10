package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;


    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[text()='Login']");
    private By errorMsg = By.xpath("//p[text()=\"Your email or password is incorrect!\"]");
    private By loggedInLabel = By.xpath("//a[@href='/logout']");
    private By logoutLink = By.xpath("//a[text()=' Logout']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By signupLoginLink = By.xpath("//a[text()=' Signup / Login']");

    public void navigateToLogin() {
        driver.findElement(signupLoginLink).click();
    }



    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }


    public boolean isLoggedIn() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInLabel));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


    public boolean isLoginErrorDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }


    public boolean isLoginButtonVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(signupLoginLink));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}

