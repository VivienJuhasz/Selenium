package hu.masterfield.test;

import hu.masterfield.browser.WebBrowser;
import hu.masterfield.browser.WebBrowserSetting;
import hu.masterfield.browser.WebBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Feladat03 {

    private static WebDriver driver;
    private static String baseURL;

    @BeforeEach
    public static void setup() {
        driver = WebBrowser.createDriver(WebBrowserType.Chrome);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        baseURL = WebBrowserSetting.getBaseURL();
    }

    @AfterEach
    public void tearDown() {
        //driver.close(); az aktuális tabot zárja be
        driver.quit(); // az egész ablakot bezárja
    }

    @ParameterizedTest
    @ValueSource(strings = {"CHAPTER1","CHAPTER2", "CHAPTER3", "CHAPTER4"})
    public void testFeladat03(String chapter) throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);
        driver.findElement(By.linkText(chapter)).click();
        Thread.sleep(3000);
    }

}