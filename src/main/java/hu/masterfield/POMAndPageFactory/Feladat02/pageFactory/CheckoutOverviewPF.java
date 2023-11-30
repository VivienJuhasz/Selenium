package hu.masterfield.POMAndPageFactory.Feladat02.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckoutOverviewPF extends BasePage {

    public CheckoutOverviewPF(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@class='summary_subtotal_label']")
    private WebElement subPriceWebElement;

    @FindBy(xpath="//div[@class='summary_tax_label']")
    private WebElement taxPriceWebElement;

    @FindBy(xpath="//div[@class='summary_info_label summary_total_label']")
    private WebElement totalPriceWebElement;

    @FindBy(id="finish")
    private WebElement finishButtonWebElement;

    @FindBy(xpath="//div[@class='inventory_item_price']")
    private List<WebElement> elemenbtsPriceWebElement;

    @FindBy(xpath="//div[@class='inventory_item_name']")
    private List<WebElement> itemsInCartWebElement;

    @FindBy(xpath="//div[@id='header_container']//span[@class='title']")
    WebElement checkWebElement;

    public boolean checkItems(String[] items) {
        List<String> actualItems = new ArrayList<>();
        for (WebElement item : itemsInCartWebElement) {
            actualItems.add(item.getText());
        }
        System.out.println(actualItems);
        boolean check = (Arrays.equals(items, actualItems.toArray())) ? true : false;
        System.out.println(check);
        return check;
    }

    public boolean checkTax(double tax) {
        double taxOnPage = Double.parseDouble(taxPriceWebElement.getText().replace("$", "").replace("Tax:", "").trim());
        return (tax==taxOnPage) ? true : false;
    }

    public double checkSubPrice() {
        return Double.parseDouble(subPriceWebElement.getText().replace("$", "").replace("Item total:", "").trim());
    }

    public double checkFullPrice() {
        double fullPrice = 0.0;
        for (WebElement item : elemenbtsPriceWebElement) {
            fullPrice += Double.parseDouble(item.getText().replace("$", "").trim());;
        }
        return fullPrice;
    }


    public void goToCheckoutComplete() {
        finishButtonWebElement.click();
    }

    public boolean checkGoToCheckoutComplete() {
        return checkWebElement.getText().equals("Checkout: Complete!") ? true : false;
    }




}
