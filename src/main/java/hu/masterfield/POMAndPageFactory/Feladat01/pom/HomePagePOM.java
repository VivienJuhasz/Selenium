package hu.masterfield.POMAndPageFactory.Feladat01.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePagePOM {
    WebDriver driver;
    WebDriverWait wait;

    // Cookiek Megértettem gomb
    private final By cookieAcceptWebElement = By.xpath("//a[text()='Megértettem']");

    // Banner Bezárás gomb
    private final By bannerCloseWebElement = By.xpath("//button[text()='Bezárás']");

    // Search textbox
    private final By searchTextboxWebElement = By.xpath("//div[@class='menu-search-container']//input[@name='searchword']");

    // Search ikon
    private final By searchIconWebElement = By.xpath("//div[@class='menu-search-container']//button[text()='Keresés']");

    //linkek
    private final By links = By.tagName("//a");

    public HomePagePOM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void open() {
        driver.get("https://masterfield.hu/hu");
    }

    public boolean isLoaded() {
        return (isLoaded(driver.findElement(cookieAcceptWebElement))
                && isLoaded(driver.findElement(bannerCloseWebElement))
                && isLoaded(driver.findElement(searchIconWebElement))
                && isLoaded(driver.findElement(searchTextboxWebElement)));
    }

    public SearchResultPagePOM search (String word) {
        driver.findElement(searchTextboxWebElement).sendKeys(word);
        isLoaded(driver.findElement(searchIconWebElement));
        isInteractable(driver.findElement(searchIconWebElement));
        driver.findElement(searchIconWebElement).click();
        return new SearchResultPagePOM(driver);
    }
    public void closeCookieAndPopup() {
        driver.findElement(cookieAcceptWebElement).click();
        driver.findElement(bannerCloseWebElement).click();
    }

    public boolean isLoaded(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
    public boolean isInteractable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
    }
}
