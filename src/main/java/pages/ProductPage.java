package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private static final By CART_ITEM_NAME = By.xpath("//a[@class='detailed-cart-item__name-link']");
    private static final By TOTAL_PRICE = By.xpath("//span[@class='checkout-order-summary-total__price']");
    private static final By GET_PRODUCT_NAME = By.xpath("//div[@class='product-righter google-rich-snippet']/h1");
    private static final By GET_PRODUCT_PRICE = By.xpath("//span[@class='price']/span");

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartItemName() {
        return driver.findElement(CART_ITEM_NAME).getText();
    }

    public String getItemTotalPrice() {
        return driver.findElement(TOTAL_PRICE).getText();
    }

    public String expectedItemName() {
        return driver.findElement(GET_PRODUCT_NAME).getText();
    }

    public String expectedTotalPrice() {
        return driver.findElement(GET_PRODUCT_PRICE).getText();
    }
}
