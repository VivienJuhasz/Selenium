package hu.masterfield.POMAndPageFactory.Feladat02.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPagePOM {

    WebDriver driver;
    WebDriverWait wait;

    private final By addToCartBackPackWebElement = By.id("add-to-cart-sauce-labs-backpack");
    private final By addToCartBoltTShirtWebElement = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By addToCartOnesieWebElement = By.id("add-to-cart-sauce-labs-onesie");
    private final By addToCartJacketWebElement = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By addToCartTShirtWebElement = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private final By addToCartBikeLightWebElement = By.id("add-to-cart-sauce-labs-bike-light");
    private final By goToShoppingCartWebElement = By.id("shopping_cart_container");
    private final By checkWebElement = By.xpath("//div[@id='header_container']//span[@class='title']");

    public ProductPagePOM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addToCartBackPack() throws InterruptedException {
        driver.findElement(addToCartBackPackWebElement).click();
        Thread.sleep(2000);
    }
    public void addToCartBoltTShirt() throws InterruptedException {
        driver.findElement(addToCartBoltTShirtWebElement).click();
        Thread.sleep(2000);
    }

    public void addToCartOnesie() throws InterruptedException {
        driver.findElement(addToCartOnesieWebElement).click();
        Thread.sleep(2000);
    }
    public void addToCartJacket() throws InterruptedException {
        driver.findElement(addToCartJacketWebElement).click();
        Thread.sleep(2000);
    }
    public void addToCartTShirt() throws InterruptedException {
        driver.findElement(addToCartTShirtWebElement).click();
        Thread.sleep(2000);
    }
    public void addToCartBikeLight() throws InterruptedException {
        driver.findElement(addToCartBikeLightWebElement).click();
        Thread.sleep(2000);
    }




    public void addToCartAllProducts() throws InterruptedException {
        driver.findElement(addToCartBackPackWebElement).click();
        Thread.sleep(2000);
        driver.findElement(addToCartBoltTShirtWebElement).click();
        Thread.sleep(2000);
        driver.findElement(addToCartOnesieWebElement).click();
        Thread.sleep(2000);
        driver.findElement(addToCartJacketWebElement).click();
        Thread.sleep(2000);
        driver.findElement(addToCartTShirtWebElement).click();
        Thread.sleep(2000);
        driver.findElement(addToCartBikeLightWebElement).click();
        Thread.sleep(2000);
    }

    public boolean checkGoToCartSuccess() {
        return driver.findElement(checkWebElement).getText().equals("Your Cart") ? true : false;
    }

    public void goToShoppingCart() {
        driver.findElement(goToShoppingCartWebElement).click();
    }


}
