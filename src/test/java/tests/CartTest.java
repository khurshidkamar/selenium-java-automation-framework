package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void cartPageTest() {
        driver().get("https://www.saucedemo.com");

        LoginPage login = new LoginPage(driver());
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        InventoryPage inv = new InventoryPage(driver());
        inv.addFirstItemToCart();
        inv.goToCart();

        CartPage cart = new CartPage(driver());
        Assert.assertTrue(cart.isCartDisplayed(), "Cart not displayed");
        cart.clickCheckout();
    }
}
