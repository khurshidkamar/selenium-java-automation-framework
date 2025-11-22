package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

    @Test
    public void inventoryPageTest() {
        driver().get("https://www.saucedemo.com");

        LoginPage login = new LoginPage(driver());
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        InventoryPage inv = new InventoryPage(driver());
        Assert.assertTrue(inv.isPageDisplayed(), "Inventory page not displayed");
        inv.addFirstItemToCart();
        inv.goToCart();
    }
}
