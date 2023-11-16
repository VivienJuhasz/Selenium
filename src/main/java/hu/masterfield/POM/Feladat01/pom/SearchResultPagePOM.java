package hu.masterfield.POM.Feladat01.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPagePOM {
    WebDriver driver;
    WebDriverWait wait;

    private final By checkWebElement = By.xpath("//h2[text()='Tanfolyam találatok']");
    public SearchResultPagePOM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public boolean isLoaded(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
    public boolean isLoaded() {
        return isLoaded(driver.findElement(checkWebElement));
    }
}