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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Feladat16B {
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
    public void testFeladat16B() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

        driver.findElement(By.linkText("CHAPTER11")).click();
        Thread.sleep(3000);
        assertEquals("4864", getBMICategory(160, "Normal"));
    }
    @Test
    public void testFeladat16B2() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

        driver.findElement(By.linkText("CHAPTER11")).click();
        Thread.sleep(3000);
        assertEquals("5473", getBMICategory(170, "Normal"));
    }

    public String getBMICategory(int heightCM, String categoryText) {
        WebElement heightWebElement = driver.findElement(By.id("heightCMS"));
        heightWebElement.clear();
        heightWebElement.sendKeys("" + heightCM);

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
        } while (!category.equals(categoryText));

        weightTo = weightFrom;

        do {
            weightWebElement.clear();
            weightWebElement.sendKeys("" + weightTo);
            calculateButtonWebElement.click();
            category = bmiCategoryWebElement.getAttribute("value");
            weightTo++;
        } while (category.equals(categoryText));

        System.out.println("Weight from: " + (weightFrom-1));
        System.out.println("Weight to: " + (weightTo-1));

        return String.valueOf(weightFrom-1)+String.valueOf(weightTo-1);
    }

    public void showInfos(WebElement webElement, String elementName) {
        System.out.println("Tag name of " + elementName + " : " + webElement.getTagName());
        System.out.println("Location of " + elementName + " : " + webElement.getLocation());
        System.out.println("Text of " + elementName + " : " + webElement.getText());
    }
}