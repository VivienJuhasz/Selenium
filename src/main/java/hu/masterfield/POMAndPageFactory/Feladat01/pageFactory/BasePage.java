package hu.masterfield.POMAndPageFactory.Feladat01.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        BasePage.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded(WebElement webelement) {
        return wait.until(ExpectedConditions.visibilityOf(webelement)).isDisplayed();
    }
    public boolean isInteractable(WebElement webelement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webelement)).isEnabled();
    }

}
