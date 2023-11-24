package hu.masterfield.POMAndPageFactory.Feladat01.basic;

import hu.masterfield.browser.WebBrowser;
import hu.masterfield.browser.WebBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Feladat01 {
    private WebDriver driver;
    private String baseURL;

    @BeforeEach
    public void setup() {
        driver = WebBrowser.createDriver(WebBrowserType.Chrome);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        baseURL = "https://masterfield.hu/hu";
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFeladat01() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(5000);

        // Cookiek Megértettem gomb
        WebElement cookieAcceptWebElement = driver.findElement(By.xpath("//a[text()='Megértettem']"));
        cookieAcceptWebElement.click();

        // Banner Bezárás gomb
        WebElement bannerCloseWebElement = driver.findElement(By.xpath("//button[text()='Bezárás']"));
        bannerCloseWebElement.click();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            if (!link.getText().equals("")) {
                System.out.println(link.getText());
            }
        }

        // Search textbox
        WebElement searchTextboxWebElement = driver.findElement(By.xpath("//div[@class='menu-search-container']//input[@name='searchword']"));
        searchTextboxWebElement.clear();
        searchTextboxWebElement.sendKeys("java");

        // Search ikon
        WebElement searchIconWebElement = driver.findElement(By.xpath("//div[@class='menu-search-container']//button[text()='Keresés']"));
        searchIconWebElement.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Tanfolyam találatok']")));
        WebElement checkWebElement = driver.findElement(By.xpath("//h2[text()='Tanfolyam találatok']"));
        assertTrue(checkWebElement.isDisplayed());
        Thread.sleep(5000);
    }

}
