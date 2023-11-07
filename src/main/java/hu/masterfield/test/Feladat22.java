package hu.masterfield.test;

import hu.masterfield.browser.WebBrowser;
import hu.masterfield.browser.WebBrowserSetting;
import hu.masterfield.browser.WebBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Feladat22 {
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
    public void testFeladat22() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

        driver.findElement(By.linkText("CHAPTER1")).click();
        Thread.sleep(3000);

        if (isElementPresent(By.id("storeinput"))) {
            WebElement storeInputWebElement = driver.findElement(By.id("storeinput"));
            showElementInfos(storeInputWebElement, "StoreInput");
        }
        if (isElementPresent(By.id("selecttype"))) {
            WebElement selectTypeWebElement = driver.findElement(By.id("selecttype"));
            showElementInfos(selectTypeWebElement, "DDL 1");
            Select ddl = new Select(driver.findElement(By.id("selecttype")));
            ddl.selectByValue("Selenium RC");
            assertEquals("Selenium RC",ddl.getFirstSelectedOption().getText());
            showElementInfos(selectTypeWebElement, "DDL 2");
        }
        if (isElementPresent(By.id("radiobutton"))) {
            WebElement radioButtonWebElement = driver.findElement(By.id("radiobutton"));
            showElementInfos(radioButtonWebElement, "RadioButton");
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            System.out.println("Element present.");
            return true;
        } catch (NoSuchElementException ex) {
            System.out.println("Element NOT present.");
            return false;
        }
    }

    public void showElementInfos(WebElement webElement, String name) {
        System.out.println("*************  " + name + "  *************");
        System.out.println(name + ": Displayed: " + webElement.isDisplayed());
        System.out.println(name + ": Enabled: " + webElement.isEnabled());
        System.out.println(name + ": Selected: " + webElement.isSelected());
        System.out.println(name + ": Tag name of " + webElement.getTagName());
        System.out.println(name + ": Location of " + webElement.getLocation());
        System.out.println(name + ": Text of " + webElement.getText());
        System.out.println("*************  " + name + "  *************");
    }
}