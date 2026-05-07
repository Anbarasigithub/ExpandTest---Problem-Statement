package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class RegisterPage extends BasePage {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("confirmPassword");
    By registerButton = By.xpath("//button[@type='submit']");
    By message = By.id("flash");

    public void openRegisterPage() {
        driver.get(ConfigReader.getProperty("registerUrl"));
    }

    public void registerUser(String username, String password, String confirmPassword) {
        enterText(usernameField, username);
        enterText(passwordField, password);
        enterText(confirmPasswordField, confirmPassword);
        clickElement(registerButton);
    }
    public String getMessage() {
        return getText(message);
    }
}