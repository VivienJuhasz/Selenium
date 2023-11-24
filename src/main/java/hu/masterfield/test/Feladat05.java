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

public class Feladat05 {
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
    public void testFeladat05() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(5000);
//        driver.findElement(By.xpath("//a[text()='Chapter2']")).click();
        driver.findElement(By.linkText("CHAPTER2")).click();

        WebElement verifyButtonWebElement = driver.findElement(By.name("verifybutton"));
        verifyButtonWebElement.click();
        showInfos(verifyButtonWebElement, "verifyButton");

        WebElement buttonWebElement = driver.findElement(By.id("but1"));
        buttonWebElement.click();
        showInfos(buttonWebElement, "buttonWithID");

    }

    public void showInfos(WebElement webElement, String elementName) {
        System.out.println("Tag name of " + elementName + " : " + webElement.getTagName());
        System.out.println("Location of " + elementName + " : " + webElement.getLocation());

    }

}
