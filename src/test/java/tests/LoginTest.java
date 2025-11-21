package tests;

import base.BaseTest;
import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        driver().get("https://the-internet.herokuapp.com/login");

        LoginPage login = new LoginPage(driver());
        login.enterUsername("tomsmith");
        login.enterPassword("SuperSecretPassword!");
        login.clickLogin();
    }
}
