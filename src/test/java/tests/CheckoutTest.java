package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutFlowTest() {
        driver().get("https://www.saucedemo.com");

        LoginPage login = new LoginPage(driver());
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        InventoryPage inv = new InventoryPage(driver());
        inv.addFirstItemToCart();
        inv.goToCart();

        CartPage cart = new CartPage(driver());
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver());
        checkout.enterCheckoutInfo("Khurshid", "K", "400001");
        checkout.clickContinue();
        checkout.clickFinish();

        Assert.assertTrue(checkout.isComplete(), "Checkout not complete");
    }
}
