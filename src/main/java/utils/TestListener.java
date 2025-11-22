package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TestListener.onTestFailure - test failed: " + result.getName());

        try {
            Object instance = result.getInstance();
            if (instance instanceof BaseTest) {
                WebDriver driver = ((BaseTest) instance).driver();
                if (driver != null) {
                    String path = ScreenshotUtils.takeScreenshot(driver, result.getName());
                    System.out.println("Screenshot saved: " + path);
                } else {
                    System.out.println("TestListener: driver() returned null for test: " + result.getName());
                }
            } else {
                System.out.println("TestListener: test instance is not BaseTest. instance class: " + (instance == null ? "null" : instance.getClass().getName()));
            }
        } catch (Exception e) {
            System.out.println("TestListener: error while taking screenshot: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            e.printStackTrace();
        }
    }
}