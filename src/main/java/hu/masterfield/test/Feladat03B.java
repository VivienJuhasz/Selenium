package hu.masterfield.test;

import hu.masterfield.browser.WebBrowser;
import hu.masterfield.browser.WebBrowserSetting;
import hu.masterfield.browser.WebBrowserType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Feladat03B {

    private static WebDriver driver;
    private static String baseURL;

    @BeforeAll
    public static void setup() {
        driver = WebBrowser.createDriver(WebBrowserType.EdgeWDM);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        baseURL = WebBrowserSetting.getBaseURL();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"CHAPTER1", "CHAPTER2", "CHAPTER3", "CHAPTER4", "CHAPTER5"})
    public void testFeladat03B(String chapter) throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);
        driver.findElement(By.linkText(chapter)).click();
        Thread.sleep(3000);
    }

}