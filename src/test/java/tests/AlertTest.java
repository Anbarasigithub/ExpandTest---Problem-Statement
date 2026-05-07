package tests;

import pages.AlertPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

    WebDriver driver;
    AlertPage alertPage;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        alertPage = new AlertPage(driver);
    }

    @Test
    public void verifyJsAlert() {
        alertPage.openAlertsPage();
        alertPage.clickJsAlert();
        alertPage.acceptAlert();
        Assert.assertTrue(alertPage.getResultText().contains("OK"));
    }

    @Test
    public void verifyJsConfirm() {
        alertPage.openAlertsPage();
        alertPage.clickJsConfirm();
        alertPage.dismissConfirm();
        Assert.assertTrue(alertPage.getResultText().contains("Cancel"));
    }

    @Test
    public void verifyJsPrompt() {
        alertPage.openAlertsPage();
        alertPage.clickJsPrompt();
        alertPage.enterPromptText("I am a Js Alert");
        Assert.assertTrue(alertPage.getResultText().contains("I am a Js Alert"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}