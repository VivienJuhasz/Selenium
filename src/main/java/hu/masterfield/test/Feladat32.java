package hu.masterfield.test;

import hu.masterfield.browser.WebBrowser;
import hu.masterfield.browser.WebBrowserSetting;
import hu.masterfield.browser.WebBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Feladat32 {
    private WebDriver driver;
    private String baseURL;

    @BeforeEach
    public void setup() {
        driver = WebBrowser.createDriver(WebBrowserType.Chrome);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        baseURL = "https://edition.cnn.com/";
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFeladat32() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

        System.out.println("1. GeoData: " + driver.manage().getCookieNamed("geoData"));
        System.out.println("1. Country code: " + driver.manage().getCookieNamed("countryCode"));

        driver.manage().deleteCookieNamed("geoData");
        driver.manage().deleteCookieNamed("countryCode");

        Cookie geoDataCookie = new Cookie("geoData", "myNewGeoData");
        Cookie countryCodeCookie = new Cookie("countryCode", "US");

        driver.manage().addCookie(geoDataCookie);
        driver.manage().addCookie(countryCodeCookie);

        System.out.println("2. GeoData: " + driver.manage().getCookieNamed("geoData"));
        System.out.println("2. Country code: " + driver.manage().getCookieNamed("countryCode"));

        driver.navigate().to("https://edition.cnn.com/");

        System.out.println("3. GeoData: " + driver.manage().getCookieNamed("geoData"));
        System.out.println("3. Country code: " + driver.manage().getCookieNamed("countryCode"));

        for(Cookie cookie : driver.manage().getCookies()) {
            System.out.println(cookie.getName() + " : " + cookie.getValue());
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