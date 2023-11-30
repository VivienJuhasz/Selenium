package hu.masterfield.POMAndPageFactory.Feladat02.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductPagePF extends BasePage{

    @FindBy(xpath="//div[@class='inventory_item_label']//div[@class='inventory_item_name ']")
    private List<WebElement> itemsWebElement;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBackpackWebElement;

    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addToCartSauceLabsBoltTShirtWebElement;

    @FindBy(id="add-to-cart-sauce-labs-onesie")
    private WebElement addToCartSauceLabsOnesieWebElement;

    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    private WebElement addToCartSauceLabsBikeLightWebElement;

    @FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addToCartSauceLabsFleeceJacketWebElement;

    @FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
    private WebElement addToCartTShirtRedWebElement;

    @FindBy(id="shopping_cart_container")
    private WebElement goToShoppingCartWebElement;

    @FindBy(xpath="//div[@id='header_container']//span[@class='title']")
    WebElement checkWebElement;


    public boolean checkItems(String[] items) {
        List<String> actualItems = new ArrayList<>();
        for (WebElement item : itemsWebElement) {
            actualItems.add(item.getText());
        }
        System.out.println("");
        for (String item : items) {
            System.out.print(item + ", ");
        }
        System.out.println("ACTUAL:" + actualItems);
/*        if (items.equals(actualItems.toArray())) {
            return true;
        } else {
            return false;
        }*/
        boolean check = (Arrays.equals(items, actualItems.toArray())) ? true : false;
        System.out.println(check);
        return check;
    }

    public void addToCartBackpack() throws InterruptedException {
        addToCartBackpackWebElement.click();
        Thread.sleep(2000);
    }
    public void addToCartBoltTShirt() throws InterruptedException {
        addToCartSauceLabsBoltTShirtWebElement.click();
        Thread.sleep(2000);
    }

    public void addToCartLabsOnesie() throws InterruptedException {
        addToCartSauceLabsOnesieWebElement.click();
        Thread.sleep(2000);
    }

    public void addToCartBikeLight() throws InterruptedException {
        addToCartSauceLabsBikeLightWebElement.click();
        Thread.sleep(2000);
    }

    public void addToCartFleeceJacket() throws InterruptedException {
        addToCartSauceLabsFleeceJacketWebElement.click();
        Thread.sleep(2000);
    }

    public void addToCartTShirtRed() throws InterruptedException {
        addToCartTShirtRedWebElement.click();
        Thread.sleep(2000);
    }

    public void goToShoppingCart() {
        goToShoppingCartWebElement.click();
    }

    public ProductPagePF(WebDriver driver) {
        super(driver);
    }

    public void addToCartAllProducts() throws InterruptedException {
        addToCartBackpackWebElement.click();
        Thread.sleep(2000);
        addToCartSauceLabsBoltTShirtWebElement.click();
        Thread.sleep(2000);
        addToCartSauceLabsOnesieWebElement.click();
        Thread.sleep(2000);
        addToCartSauceLabsBikeLightWebElement.click();
        Thread.sleep(2000);
        addToCartSauceLabsFleeceJacketWebElement.click();
        Thread.sleep(2000);
        addToCartTShirtRedWebElement.click();
        Thread.sleep(2000);
    }

    public boolean checkGoToCartSuccess() {
        return checkWebElement.getText().equals("Your Cart") ? true : false;
    }



}
