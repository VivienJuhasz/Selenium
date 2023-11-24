package hu.masterfield.POMAndPageFactory.Feladat01.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPagePF extends BasePage {

    @FindBy(xpath="//h2[text()='Tanfolyam találatok']")
    WebElement checkWebElement;
    public SearchResultPagePF(WebDriver driver) {
        super(driver);
    }
    public boolean isLoaded() {
        return isLoaded(checkWebElement);
    }
}
