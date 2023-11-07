package hu.masterfield.test;

import hu.masterfield.browser.WebBrowser;
import hu.masterfield.browser.WebBrowserSetting;
import hu.masterfield.browser.WebBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class Feladat21B {
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
    public void testFeladat21B() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

        driver.findElement(By.linkText("CHAPTER7")).click();
        Thread.sleep(3000);

        showTable(By.id("items1"), "items1 table");
        showTable(By.id("items2"), "items2 table");
    }

    public void showTable(By by, String name) throws InterruptedException {
        System.out.println("*********************** " + name + " ***********************");
        WebElement table = driver.findElement(by);

        List<WebElement> headers = table.findElements(By.tagName("th"));
        for (WebElement header : headers) {
            System.out.print(header.getText() + "\t\t\t");
        }
        System.out.println();


        WebElement tbody = table.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        for (int i = 0; i < rows.size(); i++) {
            String serviceName = "";
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int minIndex = -1;
            int maxIndex = -1;
            WebElement minWebElement = null;
            WebElement maxWebElement = null;
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < cells.size(); j++) {
                if (j == 0) {
                    serviceName = cells.get(j).getText();
                } else {
                    int temp = Integer.parseInt(cells.get(j).getText().trim().replace("$", ""));
                    if (min > temp) {
                        min = temp;
                        minIndex = j;
                        minWebElement = cells.get(j);
                    }
                    if (temp > max) {
                        max = temp;
                        maxIndex = j;
                        maxWebElement = cells.get(j);
                    }
                }
            }
            if ((minIndex >= 0) && (maxIndex >= 0)) {
                System.out.println("ServiceName: " + serviceName + " Company with minimum price: "
                        + headers.get(minIndex).getText() + " : " + min
                        + " Comapny with maximum price: " + headers.get(maxIndex).getText() + " : " + max);
                highlighter(driver, minWebElement);
                highlighter(driver, maxWebElement);
            }
        }


        System.out.println("*********************** " + name + " ***********************");
    }

    public void showInfos(WebElement webElement, String elementName) {
        System.out.println("Tag name of " + elementName + " : " + webElement.getTagName());
        System.out.println("Location of " + elementName + " : " + webElement.getLocation());
        System.out.println("Text of " + elementName + " : " + webElement.getText());
    }

    public void highlighter(WebDriver driver, WebElement webElement) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", webElement,
                    "background-color: yellow");
            Thread.sleep(500);
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", webElement,
                    "");
        }
    }

}