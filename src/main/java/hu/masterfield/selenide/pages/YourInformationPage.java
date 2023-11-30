package hu.masterfield.selenide.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class YourInformationPage {
    public void validatePage() {
        $("title").innerText().equals("Checkout: Your Information");
        $(byId("continue")).shouldBe(Condition.visible);
    }
    public OverviewPage continueToOverview(String firstName, String lastName, String postalCode) {
        $(byId("first-name")).setValue(firstName);
        $(byId("last-name")).setValue(lastName);
        $(byId("postal-code")).setValue(postalCode);
        $(byId("continue")).click();
        return new OverviewPage();
    }
}
