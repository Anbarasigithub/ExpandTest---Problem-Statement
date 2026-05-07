package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FormInteractionPage {

    WebDriver driver;

    public FormInteractionPage(WebDriver driver) {
        this.driver = driver;
    }

    By numberInput = By.id("input-number");
    By textInput = By.id("input-text");
    By passwordInput = By.id("input-password");
    By dateInput = By.id("input-date");
    By dropdown = By.id("dropdown");
    By checkbox1 = By.id("checkbox1");
    By checkbox2 = By.id("checkbox2");
    By redRadio = By.id("red");
    By blueRadio = By.id("blue");
    By footballRadio = By.id("football");
    By tennisRadio = By.id("tennis");
    By columnA = By.id("column-a");
    By columnB = By.id("column-b");

    public void openInputsPage() {
        driver.get("https://practice.expandtesting.com/inputs");
    }

    public void enterNumber(String number) {
        driver.findElement(numberInput).sendKeys(number);
    }

    public void enterText(String text) {
        driver.findElement(textInput).sendKeys(text);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void enterDate(String date) {
        driver.findElement(dateInput).sendKeys(date);
    }

    public String getEnteredNumber() {
        return driver.findElement(numberInput).getAttribute("value");
    }

    public String getEnteredText() {
        return driver.findElement(textInput).getAttribute("value");
    }

    public String getEnteredPassword() {
        return driver.findElement(passwordInput).getAttribute("value");
    }

    public void openDropdownPage() {
        driver.get("https://practice.expandtesting.com/dropdown");
    }

    public void selectOption1() {
        WebElement dropdownElement = driver.findElement(dropdown);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText("Option 1");
    }
    public String getSelectedOption() {
        WebElement dropdownElement = driver.findElement(dropdown);
        Select select = new Select(dropdownElement);
        return select.getFirstSelectedOption().getText();
    }
    public void openCheckboxPage() {
        driver.get("https://practice.expandtesting.com/checkboxes");
    }
    public void checkCheckbox1() {
        driver.findElement(checkbox1).click();
    }
    public void uncheckCheckbox2() {
        driver.findElement(checkbox2).click();
    }
    public boolean isCheckbox1Selected() {
        return driver.findElement(checkbox1).isSelected();
    }
    public boolean isCheckbox2Selected() {
        return driver.findElement(checkbox2).isSelected();
    }
    public void openRadioButtonPage() {
        driver.get("https://practice.expandtesting.com/radio-buttons");
    }
    public void clickRedRadio() {
        driver.findElement(redRadio).click();
    }
    public void clickFootballRadio() {
        driver.findElement(footballRadio).click();
    }
    public boolean isRedSelected() {
        return driver.findElement(redRadio).isSelected();
    }
    public boolean isBlueSelected() {
        return driver.findElement(blueRadio).isSelected();
    }
    public boolean isFootballSelected() {
        return driver.findElement(footballRadio).isSelected();
    }
    public boolean isTennisSelected() {
        return driver.findElement(tennisRadio).isSelected();
    }

    public void openDragDropPage() {
        driver.get("https://practice.expandtesting.com/drag-and-drop");
    }
    public void dragColumnAtoB() {
        WebElement source = driver.findElement(columnA);
        WebElement target = driver.findElement(columnB);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }
}