package hu.masterfield.POMAndPageFactory.Feladat02.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPagePOM {
    WebDriver driver;
    WebDriverWait wait;

    private final By userNameWebElement = By.id("user-name");
    private final By userPasswordWebElement = By.id("password");
    private final By loginButtonWebElement = By.id("login-button");
    private final By checkWebElement = By.xpath("//div[@id='header_container']//span[@class='title']");

    public LoginPagePOM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isLoaded(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
    public void setTextbox(By by, String text) {
        WebElement textboxWebElement = driver.findElement(by);
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
        driver.findElement(loginButtonWebElement).click();
    }

    public boolean checkLoginSuccess() {
        return driver.findElement(checkWebElement).getText().equals("Products") ? true : false;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }
}
