package hu.masterfield.test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class Feladat00 {
    private WebDriver driver;
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test01() {
        driver.get("https://raczpeterantal.hu/");
        driver.manage().window().setSize(new Dimension(1918, 1150));
        driver.findElement(By.cssSelector(".container-grid:nth-child(2) > .link-button")).click();
        driver.findElement(By.id("but1")).click();
        driver.findElement(By.cssSelector("#divontheleft > input:nth-child(2)")).click();
        driver.findElement(By.name("but2")).click();
        driver.findElement(By.xpath("//div[@id=\'divontheleftplus\']/input[2]")).click();
        driver.findElement(By.name("verifybutton")).click();
        driver.findElement(By.name("verifybutton1")).click();
        driver.findElement(By.linkText("Index")).click();
        driver.close();
    }
}