package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By completeHeader = By.cssSelector("h2.complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterCheckoutInfo(String fn, String ln, String postal) {
        type(firstName, fn);
        type(lastName, ln);
        type(postalCode, postal);
    }

    public void clickContinue() {
        click(continueBtn);
    }

    public void clickFinish() {
        click(finishBtn);
    }

    public boolean isComplete() {
        return isDisplayed(completeHeader);
    }
}
