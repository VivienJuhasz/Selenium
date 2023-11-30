package hu.masterfield.selenide.pages;

import com.codeborne.selenide.Condition;


import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public void validatePage() {
        $("title").innerText().equals("Your Cart");
        $(byTagAndText("button", "Checkout")).shouldBe(Condition.visible);
    }
    public YourInformationPage checkout() {
        $(byTagAndText("button", "Checkout"))
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled)
                .click();
        return new YourInformationPage();
    }
}
