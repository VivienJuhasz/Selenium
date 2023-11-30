package hu.masterfield.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginPage {
    private SelenideElement txtBoxUserName = $(By.id("user-name"));
    private SelenideElement txtBoxPassword = $(By.id("password"));
    //private SelenideElement txtBoxPassword = $("password");
    private SelenideElement btnLogin = $(By.id("login-button"));
    public void validateUIComponents() {
        txtBoxUserName.shouldBe(visible).shouldBe(enabled);
        txtBoxPassword.shouldBe(visible).shouldBe(enabled);
        btnLogin.shouldBe(visible).shouldBe(enabled);
    }

    public String getUrl() {
        return url();
    }
    public String getTitle() {
        return title();
    }

    public ProductsPage loginAccount(String userName, String password) {
        txtBoxUserName.setValue(userName);
        txtBoxPassword.setValue(password);
        btnLogin.click();
        return new ProductsPage();
    }
}
