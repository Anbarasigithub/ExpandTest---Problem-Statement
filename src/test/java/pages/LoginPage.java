package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//button[contains(text(),'Login')]");
    By message = By.id("flash");
    By logoutButton = By.linkText("Logout");

    public void login(String username, String password) {
        enterText(usernameField, username);
        enterText(passwordField, password);
        clickElement(loginButton);
    }
    public String getMessage() {
        return getText(message);
    }
    public void clickLogout() {
        clickElement(logoutButton);
    }
}