package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By cartList = By.cssSelector("div.cart_list");
    private By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartDisplayed() {
        return isDisplayed(cartList);
    }

    public void clickCheckout() {
        click(checkoutBtn);
    }
}
