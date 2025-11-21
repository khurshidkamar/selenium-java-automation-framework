package base;

import org.testng.annotations.*;
import utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        WebDriverFactory.setDriver(browser);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }

    public WebDriver driver() {
        return WebDriverFactory.getDriver();
    }
}
