package hu.masterfield.POMAndPageFactory.Feladat01.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class HomePagePF extends BasePage{
    // Cookiek Megértettem gomb
    @FindBy(xpath="//a[text()='Megértettem']")
    WebElement cookieAcceptWebElement;

    // Banner Bezárás gomb
    @FindBy(xpath="//button[text()='Bezárás']")
    WebElement bannerCloseWebElement;

    // Search textbox
    @FindBy(xpath="//div[@class='menu-search-container']//input[@name='searchword']")
    WebElement searchTextboxWebElement;

    // Search ikon
    @FindBy(xpath="//div[@class='menu-search-container']//button[text()='Keresés']")
    WebElement searchIconWebElement;

    //linkek
    @FindBy(tagName="a")
    List<WebElement> links;

    public HomePagePF(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://masterfield.hu/hu");
    }

    public boolean isLoaded() {
        return (isLoaded(cookieAcceptWebElement)
                && isLoaded(bannerCloseWebElement)
                && isLoaded(searchIconWebElement)
                && isLoaded(searchTextboxWebElement));
    }

    public SearchResultPagePF search (String word) {
        searchTextboxWebElement.sendKeys(word);
        isLoaded(searchIconWebElement);
        isInteractable(searchIconWebElement);
        searchIconWebElement.click();
        return new SearchResultPagePF(driver);
    }
    public void closeCookieAndPopup() {
        cookieAcceptWebElement.click();
        bannerCloseWebElement.click();
    }

    public boolean isLoaded(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
    public boolean isInteractable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
    }
}
