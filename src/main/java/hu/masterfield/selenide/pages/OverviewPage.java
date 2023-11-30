package hu.masterfield.selenide.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class OverviewPage {
    public void validatePage() {
        $("title").innerText().equals("Checkout: Overview");
        $(byId("finish")).shouldBe(Condition.visible);
    }
    public CompletePage finish() {
        $(byId("finish")).click();
        return new CompletePage();
    }
}
