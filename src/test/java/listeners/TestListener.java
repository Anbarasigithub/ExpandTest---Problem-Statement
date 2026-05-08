package listeners;

import base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).driver;
        ScreenshotUtils.captureScreenshot(driver, result.getName());
        System.out.println("Screenshot captured for failed test");
    }
}