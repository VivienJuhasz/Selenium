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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Feladat23 {
    private WebDriver driver;
    private String baseURL;

    @BeforeEach
    public void setup() {
        driver = WebBrowser.createDriver(WebBrowserType.Chrome);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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

        By[] locs = {By.id("xxxmultiplewindow"),
                By.className("xxxmultiplewindow"),
                By.xpath("//div[@class='xxxmultiplewindow']"),
                By.cssSelector("div[class='xxxmultiplewindow']"),
                By.cssSelector(".xxxmultiplewindow"),
                By.xpath("(//div[contains(text(),'this link to launch another window')])[1]")
        };
        WebElement multipleWindowWebElement = myFindElement(locs);
        if (multipleWindowWebElement != null) {
            multipleWindowWebElement.click();
        } else {
            fail();
        }
        Thread.sleep(3000);
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

    private WebElement myFindElement(By[] locators) throws InterruptedException {
        long timeout = 10_000;
        boolean webElementExist = false;
        WebElement webElement = null;
        long maxTime = System.currentTimeMillis() + timeout;

        while ((System.currentTimeMillis() <= maxTime) && (!webElementExist)) {
            try {
                webElement = driver.findElement(locators[0]);
                webElementExist = true;
                System.out.println("Element found with " + locators[0] + " locator.");
                break;
            } catch (NoSuchElementException ex) {
                Thread.sleep(1000);
            }
        }
        if (!webElementExist) {
            for (int i = 1; i < locators.length; i++) {
                try {
                    webElement = driver.findElement(locators[i]);
                    System.out.println("Element found with " + locators[i] + " locator.");
                    break;
                } catch (NoSuchElementException ex) {
                    System.out.println("Element NOT found with " + locators[i] + " locator.");
                }
            }
        }
        return webElement;
    }
}