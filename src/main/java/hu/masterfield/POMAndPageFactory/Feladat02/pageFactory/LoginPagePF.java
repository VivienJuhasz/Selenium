package hu.masterfield.POMAndPageFactory.Feladat02.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPagePF extends BasePage{

    @FindBy(id="user-name")
    WebElement userNameWebElement;
    @FindBy(id="password")
    WebElement userPasswordWebElement;
    @FindBy(id="login-button")
    WebElement loginButtonWebElement;

    @FindBy(xpath="//div[@id='header_container']//span[@class='title']")
    WebElement checkWebElement;

    public LoginPagePF(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
    public void setTextbox(By by, String text) {
        WebElement textboxWebElement = driver.findElement(by);
        textboxWebElement.clear();
        textboxWebElement.sendKeys(text);
    }
    public void setTextbox(WebElement textboxWebElement, String text) {
        textboxWebElement.clear();
        textboxWebElement.sendKeys(text);
    }

    public void setUserName(String userName) {
        setTextbox(userNameWebElement, userName);
    }

    public void setUserPassword(String userPassword) {
        setTextbox(userPasswordWebElement, userPassword);
    }

    public void clickLoginButton() {
        loginButtonWebElement.click();
    }

    public boolean checkLoginSuccess() {
        return checkWebElement.getText().equals("Products") ? true : false;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }
}
