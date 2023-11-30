package hu.masterfield.selenide.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class CompletePage {
    public void validatePage() {
        $("title").innerText().equals("Checkout: Complete");
    }
}
