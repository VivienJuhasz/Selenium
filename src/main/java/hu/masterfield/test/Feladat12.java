package hu.masterfield.test;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Feladat12 extends BaseTest {

    WebElement checkerWebElement;
    @Test
    public void testFeladat12() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);

        driver.findElement(By.linkText("CHAPTER2")).click();

        Thread.sleep(3000);

        checkerWebElement = driver.findElement(By.id("buttonClicker"));

        buttonClicker(By.id("but1"), "Button with ID");
        buttonClicker(By.cssSelector("input[type='button'][value='Sibling Button']"), "Sibling Button");
        buttonClicker(By.name("but2"), "Button with name");
        buttonClicker(By.xpath("//input[@type='button' and @value='Random']"), "Random");
        buttonClicker(By.xpath("//input[@type='button' and @value='Verify this button here' and @name='verifybutton']"), "Verify this button here");
        buttonClicker(By.cssSelector("input[type='button'][name='verifybutton1'][value='chocolate']"), "chocolate");

    }

    public void buttonClicker(By locator, String expected) throws InterruptedException {
        driver.findElement(locator).click();
        assertEquals(expected, checkerWebElement.getAttribute("value"));
        Thread.sleep(2000);
    }
}