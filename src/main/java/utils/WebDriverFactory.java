package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.UnexpectedAlertBehaviour;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.time.Duration;

public class WebDriverFactory {

    private static final ThreadLocal<WebDriver> tl = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return tl.get();
    }

    public static void setDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            tl.set(createChrome(false));   // normal Chrome
        }
        else if (browser.equalsIgnoreCase("chrome-incognito")) {
            tl.set(createChrome(true));    // incognito mode
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tl.set(new FirefoxDriver());
        }
        else {
            // default
            tl.set(createChrome(false));
        }

        // maximize AFTER driver is created
        try {
            getDriver().manage().window().maximize();
        } catch (Exception ignored) {}

        // optional: small implicit wait
        try {
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } catch (Exception ignored) {}
    }

    public static void quitDriver() {
        try {
            getDriver().quit();
        } catch (Exception ignored) {}
        tl.remove();
    }

    /* -------------------------
       INTERNAL - Chrome creator
       ------------------------- */
    private static WebDriver createChrome(boolean incognito) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // run in incognito if required
//        if (!incognito) {
//            options.addArguments("--incognito");
//        }

        // high stability options
        options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");

        // reduce Selenium automation fingerprint
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features=AutomationControlled");

        // FIX: disable password manager popup
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // accept unexpected alerts automatically
        options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);

        return new ChromeDriver(options);
    }
}