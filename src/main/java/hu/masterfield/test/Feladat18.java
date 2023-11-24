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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Feladat18 {
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
    public void testFeladat18() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

        driver.findElement(By.linkText("CHAPTER1")).click();
        Thread.sleep(3000);

        WebElement radioButtonWebElement = driver.findElement(By.id("radiobuttonJava"));
        System.out.println("Firstly: " + radioButtonWebElement.isSelected());
        if (radioButtonWebElement.isSelected()) {
            System.out.println("1. Do nothing.");
        } else {
            radioButtonWebElement.click();
            System.out.println("1. Click done.");
        }
        assertTrue(radioButtonWebElement.isSelected());
        System.out.println("After first section is radioButton selected? :" + radioButtonWebElement.isSelected());

        Thread.sleep(3000);
        if (radioButtonWebElement.isSelected()) {
            radioButtonWebElement.click();
            System.out.println("2. Click done.");
        } else {
            System.out.println("2. Do nothing.");
        }
        assertTrue(radioButtonWebElement.isSelected());
        System.out.println("After second section is radioButton selected? : " + radioButtonWebElement.isSelected());
        Thread.sleep(3000);

    }

    public void showInfos(WebElement webElement, String elementName) {
        System.out.println("Tag name of " + elementName + " : " + webElement.getTagName());
        System.out.println("Location of " + elementName + " : " + webElement.getLocation());
        System.out.println("Text of " + elementName + " : " + webElement.getText());
    }

}
