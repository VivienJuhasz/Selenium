package hu.masterfield.selenide;

import hu.masterfield.browser.WebBrowserSetting;
import hu.masterfield.selenide.pages.*;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Configuration.browserBinary;
import static com.codeborne.selenide.Screenshots.takeScreenShotAsFile;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SauceLabsTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private YourInformationPage yourInformationPage;
    private CompletePage completePage;
    private OverviewPage overViewPage;
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "c:\\Masterfield\\WebBrowsers\\ChromePortableDriver_117\\chromedriver.exe");
        browserBinary = "c:\\Masterfield\\WebBrowsers\\ChromePortableBin_117\\chrome.exe";
    }
    @AfterEach
    public void tearDown(){
    }
    @Test
    public void testLogin() throws IOException {
        loginPage = open("https://www.saucedemo.com", LoginPage.class);
        assertEquals("Swag Labs", loginPage.getTitle());
        loginPage.validateUIComponents();

        File screenshot = takeScreenShotAsFile();
        FileUtils.copyFile(screenshot, new File(WebBrowserSetting.getPathToScreenshots() + "selenide.png"));

        productsPage = loginPage.loginAccount("standard_user", "secret_sauce");
        assertTrue(productsPage.validatePage());
        assertEquals("Sauce Labs Onesie", productsPage.selectSortingOrder("lohi"));
        productsPage.addToCart("Sauce Labs Backpack");

        cartPage = productsPage.goToCartPage();
        cartPage.validatePage();
        yourInformationPage = cartPage.checkout();
        yourInformationPage.validatePage();
        overViewPage = yourInformationPage.continueToOverview("Peter", "Racz", "1156");
        overViewPage.validatePage();
        completePage = overViewPage.finish();
        completePage.validatePage();
    }
}
