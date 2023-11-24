package hu.masterfield.POMAndPageFactory.Feladat02.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutInformationPOM {

    WebDriver driver;
    WebDriverWait wait;

    private final By firstNameWebElement = By.id("first-name");
    private final By lastNameWebElement = By.id("last-name");
    private final By postalCodeWebElement = By.id("postal-code");
    private final By goToCheckoutOverwievWebElement = By.id("continue");
    private final By checkWebElement = By.xpath("//div[@id='header_container']//span[@class='title']");


    public CheckoutInformationPOM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setFirstName(String firstName) {
        setTextbox(firstNameWebElement, firstName);
    }
    public void setLastName(String lastName) {
        setTextbox(lastNameWebElement, lastName);
    }
    public void setPostalCode(String postalCode) {
        setTextbox(postalCodeWebElement, postalCode);
    }

    public boolean checkGoToCheckoutOverwievSuccess() {
        return driver.findElement(checkWebElement).getText().equals("Checkout: Overview") ? true : false;
    }

    public void goToCheckoutOverwiev() {
        driver.findElement(goToCheckoutOverwievWebElement).click();
    }

    public void setTextbox(By by, String text) {
        WebElement textboxWebElement = driver.findElement(by);
        textboxWebElement.clear();
        textboxWebElement.sendKeys(text);
    }

}
