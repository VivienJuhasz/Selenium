package hu.masterfield.POMAndPageFactory.Feladat02.basic;

import hu.masterfield.browser.WebBrowser;
import hu.masterfield.browser.WebBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Login {
    private WebDriver driver;
    private String baseURL;

    @BeforeEach
    public void setup() {
        driver = WebBrowser.createDriver(WebBrowserType.Chrome);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        baseURL = "https://www.saucedemo.com/";
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLoginOK() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(5000);

        String userName = "standard_user";
        String password = "secret_sauce";

        setTextbox(By.id("user-name"), userName);
        setTextbox(By.id("password"), password);

        driver.findElement(By.id("login-button")).click();

        assertEquals("Products", driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText());
        Thread.sleep(3000);
    }

    public void setTextbox(By by, String text) {
        WebElement textboxWebElement = driver.findElement(by);
        textboxWebElement.clear();
        textboxWebElement.sendKeys(text);
    }

}
