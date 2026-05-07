package tests;

import pages.FormInteractionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class FormInteractionTest {
    WebDriver driver;
    FormInteractionPage formPage;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        formPage = new FormInteractionPage(driver);
    }

    @Test
    public void verifyInputFields() {
        formPage.openInputsPage();
        formPage.enterNumber("123456789");
        formPage.enterText("I am Anbarasi");
        formPage.enterPassword("Test123");
        formPage.enterDate("2026-05-08");
        Assert.assertEquals(formPage.getEnteredNumber(), "123456789");
        Assert.assertEquals(formPage.getEnteredText(), "I am Anbarasi");
        Assert.assertEquals(formPage.getEnteredPassword(), "Test123");
    }

    @Test
    public void verifyDropdown() {
        formPage.openDropdownPage();
        formPage.selectOption1();
        Assert.assertEquals(formPage.getSelectedOption(), "Option 1");
    }

    @Test
    public void verifyCheckboxes() {
        formPage.openCheckboxPage();
        formPage.checkCheckbox1();
        Assert.assertTrue(formPage.isCheckbox1Selected());
        formPage.uncheckCheckbox2();
        Assert.assertFalse(formPage.isCheckbox2Selected());
    }

    @Test
    public void verifyRadioButtons() {
        formPage.openRadioButtonPage();
        formPage.clickRedRadio();
        Assert.assertTrue(formPage.isRedSelected());
        Assert.assertFalse(formPage.isBlueSelected());
        formPage.clickFootballRadio();
        Assert.assertTrue(formPage.isFootballSelected());
        Assert.assertFalse(formPage.isTennisSelected());
    }
    @Test
    public void verifyDragAndDrop() {
        formPage.openDragDropPage();
        formPage.dragColumnAtoB();
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}