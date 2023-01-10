package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    private static final By OPEN_SHOPPING_CART_BUTTON = By.xpath("//a[@class='main-button']");

    private static final By CONTINUE_BUTTON = By.xpath("//input[@class='main-button cart-main-button']");

    private static final By EMAIL_INPUT = By.xpath("//form[@id='new_user_guest']//input[@type='email']");

    private static final By SUBMIT_EMAIL_BUTTON = By.xpath("//input[@type='submit' and @value='Turpināt']");

    private static final By RECEIVE_ITEM_IN_STORE_BUTTON = By.xpath("//input[@name='shipping_unused' and @value='2']");

    private static final By CHOOSE_STORE_ADDRESS_BUTTON = By.xpath("//input[@name='pickup_point_id' and @value='3543']");

    private static final By FIRST_NAME_INPUT = By.xpath("//input[@id='address_first_name']");

    private static final By LAST_NAME_INPUT = By.xpath("//input[@id='address_last_name']");

    private static final By PHONE_NUMBER_INPUT = By.xpath("//input[@id='address_phone_number']");

    private static final By SAVE_INFORMATION_BUTTON = By.xpath("//button[@class='main-button upcase button-min-width']");

    private static final By CONTINUE_TO_PAYMENT_BUTTON = By.xpath("//button[@class='main-button upcase fr small-radius button-min-width checkout-shipping-continue-button']");

    private static final By PAY_IN_STORE_BUTTON = By.xpath("//input[@id='payment_unused_22']");

    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openShoppingCart() { driver.findElement(OPEN_SHOPPING_CART_BUTTON).click();}

    public void pressContinueButton() { driver.findElement(CONTINUE_BUTTON).click();}

    public void pressSubmitEmail() { driver.findElement(SUBMIT_EMAIL_BUTTON).click();}

    public void pickReceiveItemInStoreOption() { driver.findElement(RECEIVE_ITEM_IN_STORE_BUTTON).click();}

    public void chooseStoreAddress() { driver.findElement(CHOOSE_STORE_ADDRESS_BUTTON).click();}

    public void pressSaveInformationButton() { driver.findElement(SAVE_INFORMATION_BUTTON).sendKeys(Keys.RETURN);}

    public void pressContinueToPaymentButton() { driver.findElement(CONTINUE_TO_PAYMENT_BUTTON).click();}

    public void choosePayInStoreOption() { driver.findElement(PAY_IN_STORE_BUTTON).click();}

    public ShoppingCartPage enterFirstName(String firstName) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        return null;
    }

    public ShoppingCartPage enterLastName(String lastName) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        return null;
    }

    public ShoppingCartPage enterPhoneNumber(String phoneNumber) {
        driver.findElement(PHONE_NUMBER_INPUT).sendKeys(phoneNumber);
        return null;
    }

    public ShoppingCartPage enterEmailAddress(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        return null;
    }
}
