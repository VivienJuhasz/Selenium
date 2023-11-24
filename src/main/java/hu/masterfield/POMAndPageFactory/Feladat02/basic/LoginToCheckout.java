package hu.masterfield.POMAndPageFactory.Feladat02.basic;

import hu.masterfield.browser.WebBrowser;
import hu.masterfield.browser.WebBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginToCheckout {
    private WebDriver driver;
    private String baseURL;

    @BeforeEach
    public void setup() {
        driver = WebBrowser.createDriver(WebBrowserType.Chrome);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        baseURL = "https://www.saucedemo.com/";
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLoginOK() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(5000);

        String userName = "standard_user";
        String password = "secret_sauce";

        setTextbox(By.id("user-name"), userName);
        setTextbox(By.id("password"), password);

        driver.findElement(By.id("login-button")).click();

        assertEquals("Products", driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText());
        Thread.sleep(3000);

        // Minden terméket kosárba rakunk
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        Thread.sleep(2000);

        // Kosárra klikkelünk
        driver.findElement(By.id("shopping_cart_container")).click();

        assertEquals("Your Cart", driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText());

        driver.findElement(By.id("checkout")).click();

        assertEquals("Checkout: Your Information", driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText());

        setTextbox(By.id("first-name"), "Peter");
        setTextbox(By.id("last-name"), "Racz");
        setTextbox(By.id("postal-code"), "1213");

        driver.findElement(By.id("continue")).click();

        assertEquals("Checkout: Overview", driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText());

        driver.findElement(By.id("finish")).click();

        assertEquals("Checkout: Complete!", driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText());

        driver.findElement(By.id("back-to-products")).click();

        assertEquals("Products", driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText());

        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();


        assertTrue(driver.findElement(By.id("login-button")).isDisplayed());
        Thread.sleep(3000);
    }

    public void setTextbox(By by, String text) {
        WebElement textboxWebElement = driver.findElement(by);
        textboxWebElement.clear();
        textboxWebElement.sendKeys(text);
    }

}
