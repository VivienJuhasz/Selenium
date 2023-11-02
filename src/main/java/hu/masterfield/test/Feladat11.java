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

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Feladat11 {
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
    public void testFeladat11() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

        driver.findElement(By.linkText("CHAPTER1")).click();
        Thread.sleep(3000);

        WebElement homePageWebElement = driver.findElement(By.partialLinkText("Home"));
        showInfos(homePageWebElement, "Home Page");
        homePageWebElement.click();
        Thread.sleep(3000);

        List<WebElement> chapters = driver.findElements(By.partialLinkText("CHAPTER"));
        System.out.println("Number of chapters: " + chapters.size());
        assertEquals(16, chapters.size());
        for (WebElement chapter : chapters) {
            showInfos(chapter, chapter.getText());
        }
    }

    public void showInfos(WebElement webElement, String elementName) {
        System.out.println("Tag name of " + elementName + " : " + webElement.getTagName());
        System.out.println("Location of " + elementName + " : " + webElement.getLocation());
        System.out.println("Text of " + elementName + " : " + webElement.getText());
    }
}