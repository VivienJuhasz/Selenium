package hu.masterfield.POMAndPageFactory.Feladat02.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPF extends BasePage{

    public CheckoutPF(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="first-name")
    private WebElement firstNameWebElement;

    @FindBy(id="last-name")
    private WebElement lastNameWebElement;

    @FindBy(id="postal-code")
    private WebElement postalCodeWebElement;

    @FindBy(id="continue")
    private WebElement goToCheckoutOverviewWebElement;

    @FindBy(xpath="//div[@id='header_container']//span[@class='title']")
    WebElement checkWebElement;

    public void fillFirstName(String firstName) {
        firstNameWebElement.clear();
        firstNameWebElement.sendKeys(firstName);;
    }

    public void fillLastName(String lastName) {
        lastNameWebElement.clear();
        lastNameWebElement.sendKeys(lastName);
    }

    public void fillPostalCode(String postalCode) {
        postalCodeWebElement.clear();
        postalCodeWebElement.sendKeys(postalCode);
    }

    public void goToCheckoutOverview() {
        goToCheckoutOverviewWebElement.click();
    }

    public boolean checkGoToCheckoutOverviewSuccess() {
        return checkWebElement.getText().equals("Checkout: Overview") ? true : false;
    }

}
