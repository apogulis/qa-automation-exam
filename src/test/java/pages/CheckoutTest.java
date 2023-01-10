package pages;

import drivers.DriverFactory;
import model.WebStoreUser;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CheckoutTest {
    private WebDriver driver;

    @Before
    public void setUpDriver() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addItemToCartAndCheckoutTest() throws InterruptedException {

        WebStoreUser user = new WebStoreUser("Andris","Pogulis","apogulis@gmail.com","28333333");

        MainStorePage mainStore = new MainStorePage(driver);
        mainStore.open();
        Thread.sleep(2500);

        driver.get(mainStore.expectedWebStoreUrl);
        if(driver.getTitle() != null && driver.getTitle().contains(mainStore.expectedTitle)){
            System.out.println("Web store has opened successfully!");
        }
        else{
            System.out.println("Web store could not open.");
        }

        mainStore.pressAcceptCookies();
        Thread.sleep(2500);

        ItemSearchPage searchPage = new ItemSearchPage(driver);
        searchPage.pressComputerEquipmentButton();
        searchPage.pressDataCarriersButton();
        Thread.sleep(2500);
        searchPage.pressExternalHardDrivesButton();
        Thread.sleep(2500);
        searchPage.chooseHardDriveCapacity();
        Thread.sleep(4000);
        searchPage.chooseHardDriveBrand();
        Thread.sleep(4000);
        searchPage.clickOnItemButton();
        Thread.sleep(4000);

        ProductPage productPage = new ProductPage(driver);
        String expectedItemName = productPage.expectedItemName();
        String expectedTotalPrice = productPage.expectedTotalPrice();

        searchPage.pressAddToCartButton();
        Thread.sleep(2500);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.openShoppingCart();

        String actualItemName = productPage.getCartItemName();
        Assertions.assertThat(actualItemName).isEqualTo(expectedItemName);

        shoppingCartPage.pressContinueButton();
        Thread.sleep(2500);
        shoppingCartPage.enterEmailAddress(user.getEmail());
        shoppingCartPage.pressSubmitEmail();
        Thread.sleep(2500);
        shoppingCartPage.pickReceiveItemInStoreOption();
        Thread.sleep(2500);
        shoppingCartPage.chooseStoreAddress();
        Thread.sleep(2500);

        shoppingCartPage.enterFirstName(user.getFirstName());
        shoppingCartPage.enterLastName(user.getLastName());
        shoppingCartPage.enterPhoneNumber(user.getPhoneNumber());
        Thread.sleep(2500);

        shoppingCartPage.pressSaveInformationButton();
        Thread.sleep(2500);
        shoppingCartPage.pressContinueToPaymentButton();
        Thread.sleep(2500);
        shoppingCartPage.choosePayInStoreOption();
        Thread.sleep(6000);

        String actualTotalPrice = productPage.getItemTotalPrice();
        Assertions.assertThat(actualTotalPrice).isEqualTo(expectedTotalPrice + " €");

        System.out.println("Item name: " + actualItemName);
        System.out.println("Total price: " + actualTotalPrice);

        Thread.sleep(6000);
    }
    @After
    public void tearDownDriver() {
        driver.close();
        driver.quit();
    }
}
