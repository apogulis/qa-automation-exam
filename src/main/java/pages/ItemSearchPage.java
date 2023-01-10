package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ItemSearchPage {
    private static final By COMPUTER_EQUIPMENT_BUTTON = By.xpath("(//li[@class='submenu-lvl1__list-item color-theme-17 submenu-lvl1__list-item--has-child']/a)[2]");

    private static final By DATA_CARRIERS_BUTTON = By.xpath("(//ul[@class='menu product-categories-menu'] /li)[6]");

    private static final By EXTERNAL_HARD_DRIVES_BUTTON = By.xpath("(//ul[@class='din-list new-cat-list'] /li)[3]");

    private static final By HARD_DRIVE_CAPACITY_BUTTON = By.xpath("(//span[@class='catalog-taxons-visual-filter-slider__title'])[4]");

    private static final By HARD_DRIVE_BRAND_BUTTON = By.xpath("//a[@data-value='2p3']");

    private static final By CLICK_ON_ITEM_BUTTON = By.xpath("//a[@class='catalog-taxons-product__name' and @data-gtm-link='446045']");

    private static final By ADD_TO_CART_BUTTON = By.xpath("//button[@id='add_to_cart_btn']");


    private WebDriver driver;

    public ItemSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pressComputerEquipmentButton() {
        driver.findElement(COMPUTER_EQUIPMENT_BUTTON).click();
    }

    public void pressDataCarriersButton() {
        driver.findElement(DATA_CARRIERS_BUTTON).click();
    }

    public void pressExternalHardDrivesButton() { driver.findElement(EXTERNAL_HARD_DRIVES_BUTTON).click();}

    public void chooseHardDriveCapacity() { driver.findElement(HARD_DRIVE_CAPACITY_BUTTON).click();}

    public void chooseHardDriveBrand() { driver.findElement(HARD_DRIVE_BRAND_BUTTON).sendKeys(Keys.RETURN);}

    public void clickOnItemButton() { driver.findElement(CLICK_ON_ITEM_BUTTON).sendKeys(Keys.RETURN);}

    public void pressAddToCartButton() { driver.findElement(ADD_TO_CART_BUTTON).click();}
}
