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

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Feladat16 {
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
    public void testFeladat16() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

        driver.findElement(By.linkText("CHAPTER11")).click();
        Thread.sleep(3000);

        WebElement heightWebElement = driver.findElement(By.id("heightCMS"));
        heightWebElement.clear();
        heightWebElement.sendKeys("178");

        WebElement weightWebElement = driver.findElement(By.id("weightKg"));
        WebElement calculateButtonWebElement = driver.findElement(By.id("Calculate"));
        WebElement bmiCategoryWebElement = driver.findElement(By.id("bmi_category"));

        int weightFrom = 1;
        int weightTo = 1;
        String category = "";

        do {
            weightWebElement.clear();
            weightWebElement.sendKeys(String.valueOf(weightFrom));
            calculateButtonWebElement.click();
            category = bmiCategoryWebElement.getAttribute("value");
            weightFrom++;
        } while (!category.equals("Overweight"));

        weightTo = weightFrom;

        do {
            weightWebElement.clear();
            weightWebElement.sendKeys("" + weightTo);
            calculateButtonWebElement.click();
            category = bmiCategoryWebElement.getAttribute("value");
            weightTo++;
        } while (category.equals("Overweight"));

        System.out.println("Weight from: " + (weightFrom-1));
        System.out.println("Weight to: " + (weightTo-1));



    }

    public void showInfos(WebElement webElement, String elementName) {
        System.out.println("Tag name of " + elementName + " : " + webElement.getTagName());
        System.out.println("Location of " + elementName + " : " + webElement.getLocation());
        System.out.println("Text of " + elementName + " : " + webElement.getText());
    }
}
