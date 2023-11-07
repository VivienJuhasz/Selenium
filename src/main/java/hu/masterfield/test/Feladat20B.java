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
import java.util.List;

public class Feladat20B {
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
    public void testFeladat20() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

        driver.findElement(By.linkText("CHAPTER7")).click();
        Thread.sleep(3000);

        showTable(By.id("items1"), "items1 table");
        showTable(By.id("items2"), "items2 table");
    }

    public void showTable(By by, String name) {
        System.out.println("*********************** " + name + " ***********************");
        WebElement table = driver.findElement(by);

        List<WebElement> headers = table.findElements(By.tagName("th"));
        for (WebElement header : headers) {
            System.out.print(header.getText() + "\t\t\t");
        }
        System.out.println();


        WebElement tbody = table.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                if (cell.getText().length() >=4) {
                    System.out.print(cell.getText() + "\t\t\t\t");
                } else {
                    System.out.print(cell.getText() + "\t\t\t\t\t");
                }
            }
            System.out.println();
        }
        System.out.println("*********************** " + name + " ***********************");
    }

    public void showInfos(WebElement webElement, String elementName) {
        System.out.println("Tag name of " + elementName + " : " + webElement.getTagName());
        System.out.println("Location of " + elementName + " : " + webElement.getLocation());
        System.out.println("Text of " + elementName + " : " + webElement.getText());
    }
}
