package hu.masterfield.POMAndPageFactory.Feladat02.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPagePOM {

    WebDriver driver;
    WebDriverWait wait;

    private final By goToCheckoutYourInformationWebElement = By.id("checkout");
    private final By checkWebElement = By.xpath("//div[@id='header_container']//span[@class='title']");

    public CartPagePOM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public boolean checkGoToCheckoutYourInformationSuccess() {
        return driver.findElement(checkWebElement).getText().equals("Checkout: Your Information") ? true : false;
    }

    public void goToCheckoutYourInformation() {
        driver.findElement(goToCheckoutYourInformationWebElement).click();
    }


}
