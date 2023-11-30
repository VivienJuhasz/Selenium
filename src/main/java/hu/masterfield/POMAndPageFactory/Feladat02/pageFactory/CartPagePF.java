package hu.masterfield.POMAndPageFactory.Feladat02.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPagePF extends BasePage {

    @FindBy(xpath="//div[@class='cart_item']")
    private List<WebElement> checkCartItemsCountWebElement;

    @FindBy(id="checkout")
    private WebElement goToCheckoutYourInformationWebElement;

    @FindBy(xpath="//div[@id='header_container']//span[@class='title']")
    WebElement checkWebElement;

    public CartPagePF(WebDriver driver) {
        super(driver);
    }

    public boolean checkCartItemsNumber(int count) {
        return (checkCartItemsCountWebElement.size() == count) ? true : false;
    }
    public void goToCheckoutYourInformation() {
        goToCheckoutYourInformationWebElement.click();
    }

    public boolean checkGoToCheckoutYourInformationSuccess() {
        return checkWebElement.getText().equals("Checkout: Your Information");
    }
}
