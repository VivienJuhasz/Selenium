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

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Feladat19 {
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
    public void testFeladat19() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

        driver.findElement(By.linkText("CHAPTER1")).click();
        Thread.sleep(3000);

//        WebElement checkboxWebElement = driver.findElement(By.cssSelector("[name='selected(1234)']"));
        WebElement checkboxStateWebElement = driver.findElement(By.name("selected(1234)"));
        WebElement checkboxLabelWebElement = driver.findElement(By.xpath("//span[text()='Ruby']"));

        System.out.println("Firstly: " + checkboxStateWebElement.isSelected());
        System.out.println("Displayed: " + checkboxStateWebElement.isDisplayed());
        System.out.println("Enabled: " + checkboxStateWebElement.isEnabled());
        System.out.println("Position: " + checkboxStateWebElement.getLocation());
        if ((checkboxLabelWebElement.isDisplayed()) && (checkboxLabelWebElement.isEnabled())) {
            if (checkboxStateWebElement.isSelected()) {
                System.out.println("1. Do nothing.");
            } else {
                checkboxLabelWebElement.click();
                System.out.println("1. Click done.");
            }
        }
        assertTrue(checkboxStateWebElement.isSelected());
        System.out.println("After first section is radioButton selected? :" + checkboxStateWebElement.isSelected());

        Thread.sleep(3000);
        if ((checkboxLabelWebElement.isDisplayed()) && (checkboxLabelWebElement.isEnabled())) {
            if (checkboxStateWebElement.isSelected()) {
                checkboxLabelWebElement.click();
                System.out.println("2. Click done.");
            } else {
                System.out.println("2. Do nothing.");
            }
        }
        assertFalse(checkboxStateWebElement.isSelected());
        assertTrue(!checkboxStateWebElement.isSelected());
        System.out.println("After second section is radioButton selected? : " + checkboxStateWebElement.isSelected());
        Thread.sleep(3000);

    }

    public void showInfos(WebElement webElement, String elementName) {
        System.out.println("Tag name of " + elementName + " : " + webElement.getTagName());
        System.out.println("Location of " + elementName + " : " + webElement.getLocation());
        System.out.println("Text of " + elementName + " : " + webElement.getText());
    }

}
