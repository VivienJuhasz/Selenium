package hu.masterfield.test;

import hu.masterfield.browser.WebBrowser;
import hu.masterfield.browser.WebBrowserSetting;
import hu.masterfield.browser.WebBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Feladat15 {
    private WebDriver driver;
    private String baseURL;

    @BeforeEach
    public void setup() {
        driver = WebBrowser.createDriver(WebBrowserType.Chrome);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        baseURL = WebBrowserSetting.getBaseURL();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFeladat15() throws InterruptedException {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        driver.get(baseURL);
        Thread.sleep(3000);

        driver.findElement(By.linkText("CHAPTER4")).click();
        Thread.sleep(3000);

        WebElement dateInputboxWebElement = driver.findElement(By.id("dateInput"));
        if ((dateInputboxWebElement.isDisplayed()) && (dateInputboxWebElement.isEnabled())) {
            if (dateInputboxWebElement.getText().isEmpty()) {
                //To DO NOTHING
            } else {
                dateInputboxWebElement.clear();
            }
            dateInputboxWebElement.sendKeys(currentDate);
        }
        Thread.sleep(3000);

        assertEquals(currentDate, dateInputboxWebElement.getAttribute("value"));

        WebElement auctionWebElement = driver.findElement(By.id("auction"));
        String textOfAuctionWebElement = auctionWebElement.getText();
        System.out.println("Text of the auction div: " + textOfAuctionWebElement);
        assertTrue((textOfAuctionWebElement.contains("The highest bid is")) && textOfAuctionWebElement.contains("50."));
        assertEquals("The highest bid is \u00a350.", textOfAuctionWebElement);
    }

    public void showInfos(WebElement webElement, String elementName) {
        System.out.println("Tag name of " + elementName + " : " + webElement.getTagName());
        System.out.println("Location of " + elementName + " : " + webElement.getLocation());
        System.out.println("Text of " + elementName + " : " + webElement.getText());
    }
}