package hu.masterfield.test;


import hu.masterfield.browser.WebBrowser;
import hu.masterfield.browser.WebBrowserSetting;
import hu.masterfield.browser.WebBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Feladat26 {
    private WebDriver driver;
    private String baseURL;

    @BeforeEach
    public void setup() {
        driver = WebBrowser.createDriver(WebBrowserType.Firefox);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        baseURL = WebBrowserSetting.getBaseURL();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFeladat26CTRL() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

        driver.findElement(By.linkText("CHAPTER17")).click();

        WebElement multipleSelectWebElement = driver.findElement(By.id(("multipleSelect")));

        List<String> actual = new ArrayList<>();
        List<String> expected = new ArrayList<>();

        Select ddlExpected = new Select(driver.findElement(By.id("checkMultipleSelection")));
        Select ddlActual = new Select(multipleSelectWebElement);

        List<WebElement> options = multipleSelectWebElement.findElements(By.tagName("option"));
        Thread.sleep(2000);

        Actions builder = new Actions(driver);
        WebElement htmlTag = driver.findElement(By.tagName("html"));
        htmlTag.sendKeys(Keys.END);
/*         VAGY
        builder.sendKeys(Keys.PAGE_DOWN)
                .build()
                .perform();
        Thread.sleep(3000);
*/        builder.keyDown(Keys.SHIFT)
                .click(options.get(0))
                .click(options.get(1))
                .click(options.get(2))
                .click(options.get(3))
                .keyUp(Keys.SHIFT)
                .build()
                .perform();
        Thread.sleep(2000);

        for (WebElement option : ddlActual.getAllSelectedOptions()) {
            actual.add(option.getText());
        }
        for (WebElement option : ddlExpected.getOptions()) {
            expected.add(option.getText());
        }
        assertArrayEquals(expected.toArray(), actual.toArray());
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