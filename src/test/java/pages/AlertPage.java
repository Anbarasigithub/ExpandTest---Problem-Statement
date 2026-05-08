package pages;

import base.BasePage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    By jsAlertButton = By.cssSelector("button[onclick='jsAlert()']");
    By jsConfirmButton = By.cssSelector("button[onclick='jsConfirm()']");
    By jsPromptButton = By.cssSelector("button[onclick='jsPrompt()']");
    By resultText = By.id("dialog-response");

    public void openAlertsPage() {
        driver.get("https://practice.expandtesting.com/js-dialogs");
    }
    public void clickJsAlert() {
        clickElement(jsAlertButton);
    }
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void clickJsConfirm() {
        clickElement(jsConfirmButton);
    }
    public void dismissConfirm() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public void clickJsPrompt() {
        clickElement(jsPromptButton);
    }
    public void enterPromptText(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }
    public String getResultText() {
        return getText(resultText);
    }
}