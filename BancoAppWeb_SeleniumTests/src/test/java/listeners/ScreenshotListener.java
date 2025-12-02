package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;
import utils.ScreenshotUtils;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        takeScreenshot(result);
    }

    private void takeScreenshot(ITestResult result) {
        Object testClass = result.getInstance();

        if (testClass instanceof BaseTest) {
            WebDriver driver = ((BaseTest) testClass).driver;

            if (driver != null) {
                ScreenshotUtils.takeScreenshot(driver, result.getName());
            }
        }
    }
} 