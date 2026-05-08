package tests;

import base.BaseTest;
import pages.FormInteractionPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormInteractionTest extends BaseTest {
    FormInteractionPage formPage;

    @Test
    public void verifyInputFields() {
        formPage = new FormInteractionPage(driver);
        formPage.openInputsPage();
        formPage.enterNumber("12345");
        formPage.enterTextField("I am Anbarasi");
        formPage.enterPassword("Test123");
        formPage.enterDate("2026-05-08");
        Assert.assertEquals(formPage.getEnteredNumber(), "12345");
        Assert.assertEquals(formPage.getEnteredText(), "I am Anbarasi");
    }

    @Test
    public void verifyDropdown() {
        formPage = new FormInteractionPage(driver);
        formPage.openDropdownPage();
        formPage.selectOption1();
        Assert.assertEquals(formPage.getSelectedOption(), "Option 1");
    }

    @Test
    public void verifyCheckboxes() {
        formPage = new FormInteractionPage(driver);
        formPage.openCheckboxPage();
        formPage.clickCheckbox1();
        Assert.assertTrue(formPage.isCheckbox1Selected());
        formPage.clickCheckbox2();
        Assert.assertFalse(formPage.isCheckbox2Selected());
    }

    @Test
    public void verifyRadioButtons() {
        formPage = new FormInteractionPage(driver);
        formPage.openRadioButtonPage();
        formPage.clickRedRadio();
        Assert.assertTrue(formPage.isRedSelected());
        Assert.assertFalse(formPage.isBlueSelected());
        formPage.clickFootballRadio();
        Assert.assertTrue(formPage.isFootballSelected());
        Assert.assertFalse(formPage.isTennisSelected());
    }
}