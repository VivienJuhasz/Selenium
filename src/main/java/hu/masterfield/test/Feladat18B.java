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

public class Feladat18B {
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
    public void testFeladat18B() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

        driver.findElement(By.linkText("CHAPTER1")).click();
        Thread.sleep(3000);

        WebElement radioButtonStateWebElement = driver.findElement(By.id("radiobuttonJava"));
        WebElement radioButtonLabelWebElement = driver.findElement(By.xpath("//label[text()='Java']"));

        System.out.println("Firstly: " + radioButtonStateWebElement.isSelected());
        if (radioButtonStateWebElement.isSelected()) {
            System.out.println("1. Do nothing.");
        } else {
            radioButtonLabelWebElement.click();
            System.out.println("1. Click done.");
        }
        assertTrue(radioButtonStateWebElement.isSelected());
        System.out.println("After first section is radioButton selected? :" + radioButtonStateWebElement.isSelected());

        Thread.sleep(3000);
        if (radioButtonStateWebElement.isSelected()) {
            radioButtonLabelWebElement.click();
            System.out.println("2. Click done.");
        } else {
            System.out.println("2. Do nothing.");
        }
        assertTrue(radioButtonStateWebElement.isSelected());
        System.out.println("After second section is radioButton selected? : " + radioButtonStateWebElement.isSelected());
        Thread.sleep(3000);

    }

    public void showInfos(WebElement webElement, String elementName) {
        System.out.println("Tag name of " + elementName + " : " + webElement.getTagName());
        System.out.println("Location of " + elementName + " : " + webElement.getLocation());
        System.out.println("Text of " + elementName + " : " + webElement.getText());
    }
}