package hu.masterfield.test;

import hu.masterfield.browser.WebBrowser;
import hu.masterfield.browser.WebBrowserSetting;
import hu.masterfield.browser.WebBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Feladat39 {
    private WebDriver driver;
    private String baseURL;

    @BeforeEach
    public void setup() {
        driver = WebBrowser.createDriver(WebBrowserType.Chrome);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1));
        baseURL = WebBrowserSetting.getBaseURL();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFeladat39() throws InterruptedException {
        Thread.sleep(3000);
        try {
            driver.get(baseURL);
        } catch (TimeoutException ex) {
            System.out.println("TimeoutException");
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            driver.get(baseURL);
        }

        WebElement chapterOne = driver.findElement(By.linkText("CHAPTER1"));
        WebElement chapterTwo = driver.findElement(By.linkText("CHAPTER2"));

        chapterOne.click();

        try {
            driver.switchTo().window("window");
        } catch (NoSuchWindowException ex) {
            System.out.println("NoSuchWindowException");
        }

        try {
            driver.switchTo().alert();
        } catch (NoAlertPresentException ex) {
            System.out.println("NoAlertPresentException");
        }

        try {
            driver.switchTo().frame("frame");
        } catch (NoSuchFrameException ex) {
            System.out.println("NoSuchFrameException");
        }

        try {
            WebElement storeTextWebElement = driver.findElement(By.id("storetext33"));
            storeTextWebElement.clear();
            storeTextWebElement.sendKeys("storetext33");
        } catch (NoSuchElementException ex) {
            System.out.println("NoSuchElementException");
        }

        try {
            WebElement storeTextWebElement = driver.findElement(By.id("storetext3"));
            storeTextWebElement.clear();
            storeTextWebElement.sendKeys("storetext3");
        } catch (InvalidElementStateException ex) {
            System.out.println("InvalidElementStateException");
        }

        try {
            WebElement disabledButtonWebElement = driver.findElement(By.id("disabledbutton"));
            disabledButtonWebElement.click();
        } catch (ElementClickInterceptedException ex) {
            System.out.println("ElementClickInterceptedException");
        }

        try {
            driver.findElement(By.xpath("//div[@name='valami']/ul/li[1]/a[1]']"));
        } catch (InvalidSelectorException ex) {
            System.out.println("InvalidSelectorException");
        }

        try {
            chapterTwo.click();
        } catch (StaleElementReferenceException ex) {
            System.out.println("StaleElementReferenceException");
        }

        try {
            driver.close();
            System.out.println(driver.getTitle());
        } catch (NoSuchSessionException ex) {
            System.out.println("NoSuchSessionException");
        }
        System.out.println("Everything is OK");

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
