package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifySuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("practice", "SuperSecretPassword!");
        String message = loginPage.getMessage();
        Assert.assertTrue(message.contains("You logged into"), "Login Failed");
    }

    @Test(priority = 2)
    public void verifyInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("practice", "WrongPassword");
        String message = loginPage.getMessage();
        Assert.assertTrue(message.contains("Your password is invalid!"), "Invalid login");
    }

    @Test(priority = 3)
    public void verifyLogoutFunctionality() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("practice", "SuperSecretPassword!");
        loginPage.clickLogout();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        Assert.assertTrue(loginPage.getMessage().contains("logged out"));
    }

    @Test(priority = 4)
    public void verifyEmptyLoginValidation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"), "Validation failed");
    }
}