package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.WebStoreUser;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ItemSearchPage;
import pages.MainStorePage;
import pages.ShoppingCartPage;

public class CheckoutStepdefs {
    private final WebDriver driver = new ChromeDriver();

    @Before
    public void setUpDriver() {
        driver.manage().window().maximize();
    }

    WebStoreUser user = new WebStoreUser("Andris","Pogulis","apogulis@gmail.com","28333333");
    MainStorePage mainStore = new MainStorePage(driver);
    ItemSearchPage searchPage = new ItemSearchPage(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

    @Given("web store page is open")
    public void web_store_page_is_open () {
        mainStore.open();
        System.setProperty("timeout", String.valueOf(5000));
        mainStore.pressAcceptCookies();
        System.setProperty("timeout", String.valueOf(2500));
    }
    @Given("item is added to the cart")
    public void item_is_added_to_the_cart () {
        searchPage.pressComputerEquipmentButton();
        searchPage.pressDataCarriersButton();

        System.out.println(driver.getPageSource());

        searchPage.pressExternalHardDrivesButton(); //i have error in here, 'element is not attached to the page document'
        System.setProperty("timeout", String.valueOf(5000));
        searchPage.chooseHardDriveCapacity();
        searchPage.chooseHardDriveBrand();
        searchPage.clickOnItemButton();
        searchPage.pressAddToCartButton();
    }
    @Given("payment option had been chosen")
    public void payment_option_had_been_chosen () {
        shoppingCartPage.openShoppingCart();
        shoppingCartPage.pressContinueButton();
        shoppingCartPage.enterEmailAddress(user.getEmail());
        shoppingCartPage.pressSubmitEmail();
        shoppingCartPage.pickReceiveItemInStoreOption();
        shoppingCartPage.chooseStoreAddress();
    }
    @Given("customer information had been entered")
    public void customer_information_had_been_entered () {
        shoppingCartPage.enterFirstName(user.getFirstName());
        shoppingCartPage.enterLastName(user.getLastName());
        shoppingCartPage.enterPhoneNumber(user.getPhoneNumber());
        shoppingCartPage.pressSaveInformationButton();
        shoppingCartPage.pressContinueToPaymentButton();
        shoppingCartPage.choosePayInStoreOption();
    }
    @Then("verify that added item and price is correct")
    public void verify_that_added_item_and_price_is_correct () {

    }
    @After
    public void tearDownDriver() {
        driver.close();
        driver.quit();
    }
}
