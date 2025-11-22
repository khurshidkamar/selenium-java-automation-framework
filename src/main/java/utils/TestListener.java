package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ((BaseTest) result.getInstance()).driver();
        String path = ScreenshotUtils.takeScreenshot(driver, result.getName());
        System.out.println("Screenshot saved: " + path);
    }
}
