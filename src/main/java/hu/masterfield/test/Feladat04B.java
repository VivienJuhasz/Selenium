package hu.masterfield.test;

import hu.masterfield.browser.WebBrowser;
import hu.masterfield.browser.WebBrowserSetting;
import hu.masterfield.browser.WebBrowserType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Feladat04B {

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

    @DisplayName("RepeatedTest")
    @RepeatedTest( value = 5, name = "{displayName} -> {currentRepetition}/{totalRepetitions}}")
    public void testFeladat02() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);
    }

}
