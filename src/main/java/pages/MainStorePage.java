package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainStorePage {
    private static final String WEB_STORE_URL = "https://www.1a.lv/lv";

    private static final By ACCEPT_COOKIES = By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");

    private WebDriver driver;

    public MainStorePage(WebDriver driver) {
        this.driver = driver;
    }

    public MainStorePage open() {
        driver.get(WEB_STORE_URL);
        return null;
    }

    String expectedTitle = "Lielākais interneta veikals Latvijā | 1a.lv";
    String expectedWebStoreUrl = WEB_STORE_URL;

    public void pressAcceptCookies() {
        driver.findElement(ACCEPT_COOKIES).click();
    }
}
