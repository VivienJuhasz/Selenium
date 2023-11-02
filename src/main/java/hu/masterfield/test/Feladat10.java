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

public class Feladat10 {
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
    public void testFeladat10() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

//      WebElement chapterWebElement = driver.findElement(By.xpath("//a[text()='Chapter1']"));
        WebElement chapterWebElement = driver.findElement(By.linkText("CHAPTER1"));
        showInfos(chapterWebElement, "Chapter1");
    }

    public void showInfos(WebElement webElement, String elementName) {
        System.out.println("Tag name of " + elementName + " : " + webElement.getTagName());
        System.out.println("Location of " + elementName + " : " + webElement.getLocation());
        System.out.println("Text of " + elementName + " : " + webElement.getText());
    }
}