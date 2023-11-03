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

public class Feladat17 {
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
    public void testFeladat17() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

        driver.findElement(By.linkText("CHAPTER4")).click();
        Thread.sleep(3000);
        Select partsOfSeleniumWebElement = new Select(driver.findElement(By.id("selecttype")));
        System.out.println("Is DDL multiple?: " + partsOfSeleniumWebElement.isMultiple());
        assertFalse(partsOfSeleniumWebElement.isMultiple());
        assertTrue(!partsOfSeleniumWebElement.isMultiple());

        System.out.println("Number of DDL's options: " + partsOfSeleniumWebElement.getOptions().size());
        assertEquals(4, partsOfSeleniumWebElement.getOptions().size());

        partsOfSeleniumWebElement.selectByVisibleText("Selenium Grid");
        assertEquals("Selenium Grid", partsOfSeleniumWebElement.getFirstSelectedOption().getText());
        Thread.sleep(4000);

        partsOfSeleniumWebElement.selectByValue("Selenium RC");
        assertEquals("Selenium RC", partsOfSeleniumWebElement.getFirstSelectedOption().getText());
        Thread.sleep(4000);

        partsOfSeleniumWebElement.selectByIndex(0);
        assertEquals("Selenium IDE", partsOfSeleniumWebElement.getFirstSelectedOption().getText());
        Thread.sleep(4000);


//        String[] expected  = {"Selenium Core","Selenium IDE","Selenium RC","Selenium Grid"};
        String[] expected  = {"Selenium IDE","Selenium Core","Selenium RC","Selenium Grid"};
        ArrayList<String> actual = new ArrayList<>();
        List<WebElement> options = partsOfSeleniumWebElement.getOptions();
        for (WebElement option : options) {
            actual.add(option.getText());
        }

        System.out.println("Elements.of DDL: " + actual.toString());
        assertArrayEquals(expected, actual.toArray());

    }

    public void showInfos(WebElement webElement, String elementName) {
        System.out.println("Tag name of " + elementName + " : " + webElement.getTagName());
        System.out.println("Location of " + elementName + " : " + webElement.getLocation());
        System.out.println("Text of " + elementName + " : " + webElement.getText());
    }

}

