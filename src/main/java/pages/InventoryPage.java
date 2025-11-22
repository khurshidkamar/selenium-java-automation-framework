package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage {

    private By inventoryContainer = By.cssSelector("div.inventory_list");
    private By itemNames = By.cssSelector("div.inventory_item_name");
    private By addToCartButtons = By.cssSelector("button.btn_inventory");
    private By shoppingCart = By.cssSelector("a.shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageDisplayed() {
        return isDisplayed(inventoryContainer);
    }

    public List<WebElement> getAllItems() {
        return driver.findElements(itemNames);
    }

    public void addFirstItemToCart() {
        driver.findElements(addToCartButtons).get(0).click();
    }

    public void goToCart() {
        click(shoppingCart);
    }
}
