package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutSelenideTest {
    @Test
    public void webCheckoutTest() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Selenide.open("https://www.1a.lv/");
        Thread.sleep(2500);

        $(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        Thread.sleep(2500);

        $(By.xpath("(//li[@class='submenu-lvl1__list-item color-theme-17 submenu-lvl1__list-item--has-child']/a)[2]")).click();
        $(By.xpath("(//ul[@class='menu product-categories-menu'] /li)[6]")).click();
        $(By.xpath("(//ul[@class='din-list new-cat-list'] /li)[3]")).click();
        $(By.xpath("(//span[@class='catalog-taxons-visual-filter-slider__title'])[4]")).click();
        $(By.xpath("//a[@data-value='2p3']")).click();
        Thread.sleep(2500);

        $(By.xpath("//a[@class='catalog-taxons-product__name' and @data-gtm-link='446045']")).click();
        $(By.xpath("//a[@class='main-button']")).click();
        $(By.xpath("//input[@class='main-button cart-main-button']")).click();
        $(By.xpath("//form[@id='new_user_guest']//input[@type='email']")).sendKeys("apogulis@gmail.com");
        $(By.xpath("//input[@type='submit' and @value='Turpināt']")).click();
        $(By.xpath("//input[@name='shipping_unused' and @value='2']")).click();
        $(By.xpath("//input[@name='pickup_point_id' and @value='3543']")).click();

        $(By.xpath("//input[@id='address_first_name']")).sendKeys("Andris");
        $(By.xpath("//input[@id='address_last_name']")).sendKeys("Pogulis");
        $(By.xpath("//input[@id='address_phone_number']")).sendKeys("28333333");

        $(By.xpath("//button[@class='main-button upcase button-min-width']")).click();
        $(By.xpath("//button[@class='main-button upcase fr small-radius button-min-width checkout-shipping-continue-button']")).click();
        $(By.xpath("//input[@id='payment_unused_22']")).click();

        Thread.sleep(6000);
    }
}
