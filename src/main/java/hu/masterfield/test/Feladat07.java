package hu.masterfield.test;

import hu.masterfield.browser.WebBrowser;
import hu.masterfield.browser.WebBrowserSetting;
import hu.masterfield.browser.WebBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Feladat07 {
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
    public void testFeladat07() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);
        driver.findElement(By.linkText("CHAPTER1")).click();

//        WebElement textboxElement = driver.findElement(By.xpath("//*[@class='belowcenter']"))
//        WebElement textboxElement = driver.findElement(By.cssSelector("[class='belowcenter']"))

        WebElement textboxWebElement = driver.findElement(By.className("belowcenter"));
        Thread.sleep(3000);
        System.out.println("Firstly text of the textbox: " + textboxWebElement.getText());
        if (textboxWebElement.getText().isEmpty()) {
            // TO DO NOTHING
        } else {
            try {
            textboxWebElement.clear();
            System.out.println("Clear finished...");
        } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        Thread.sleep(3000);
        textboxWebElement.sendKeys("szöveg");
        System.out.println("After sendKeys textbox's text is: " + textboxWebElement.getText());
        int round = textboxWebElement.getText().length();
        System.out.println("Length of the text: " + round);

        for (int i=0; i < round; i++) {
            Thread.sleep(2000);
            textboxWebElement.sendKeys(Keys.HOME);
            textboxWebElement.sendKeys(Keys.DELETE);
            System.out.println(i + ": textboxWebELement's text is: " + textboxWebElement.getText());
        }
    }

    public void showInfos(WebElement webElement, String elementName) {
        System.out.println("Tag name of " + elementName + " : " + webElement.getTagName());
        System.out.println("Location of " + elementName + " : " + webElement.getLocation());

    }

}