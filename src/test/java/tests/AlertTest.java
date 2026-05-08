package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;

public class AlertTest extends BaseTest {
    AlertPage alertPage;
    @Test
    public void verifyJsAlert() {
        alertPage = new AlertPage(driver);
        alertPage.openAlertsPage();
        alertPage.clickJsAlert();
        alertPage.acceptAlert();
        Assert.assertTrue(alertPage.getResultText().contains("OK"));
    }

    @Test
    public void verifyJsConfirm() {
        alertPage = new AlertPage(driver);
        alertPage.openAlertsPage();
        alertPage.clickJsConfirm();
        alertPage.dismissConfirm();
        Assert.assertTrue(alertPage.getResultText().contains("Cancel"));
    }

    @Test
    public void verifyJsPrompt() {
        alertPage = new AlertPage(driver);
        alertPage.openAlertsPage();
        alertPage.clickJsPrompt();
        alertPage.enterPromptText("I am a Js Alert");
        Assert.assertTrue(alertPage.getResultText().contains("I am a Js Alert"));
    }
}