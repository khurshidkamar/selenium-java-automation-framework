package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

    private static final ThreadLocal<WebDriver> tl = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return tl.get();
    }

    public static void setDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            tl.set(new ChromeDriver());
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tl.set(new FirefoxDriver());
        }

        getDriver().manage().window().maximize();
    }

    public static void quitDriver() {
        getDriver().quit();
        tl.remove();
    }
}
