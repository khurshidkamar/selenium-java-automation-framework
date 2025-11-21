package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("button.radius");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String user) {
        type(username, user);
    }

    public void enterPassword(String pass) {
        type(password, pass);
    }

    public void clickLogin() {
        click(loginBtn);
    }
}
