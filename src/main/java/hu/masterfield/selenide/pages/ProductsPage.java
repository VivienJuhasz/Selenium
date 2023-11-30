package hu.masterfield.selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;


public class ProductsPage {
    private SelenideElement dropdownSorting = $(byXpath("//select[@class='product_sort_container']"));
    private SelenideElement linkFirst = $(byXpath("(//div[@class='inventory_item_name '])[1]"));
    public String selectSortingOrder(String sortingType) {
        dropdownSorting.selectOptionByValue(sortingType);
        return linkFirst.shouldBe(Condition.exist).shouldBe(Condition.visible).getText();
    }
    public boolean validatePage() {
        boolean isValid = false;
        $(byId("shopping_cart_container")).shouldBe(Condition.visible).shouldBe(Condition.enabled);
        if (url().contains("inventory")) {
            isValid = true;
        }
        return isValid;
    }
    public void addToCart(String product) {
        SelenideElement card = $(byText(product)).ancestor(".inventory_item_description");
        SelenideElement button = card.$(byTagName("button"));
        button.click();
        button.shouldHave(Condition.exactText("Remove"));
    }
    public CartPage goToCartPage() {
        $(byId("shopping_cart_container")).click();
        return new CartPage();
    }
}
