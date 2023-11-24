package hu.masterfield.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Feladat12 extends BaseTest {

    @Test
    public void testFeladat12() throws Exception {
        driver.get(baseURL);
        driver.findElement(By.linkText("CHAPTER2")).click();

        WebElement checkerElement = driver.findElement(By.id("buttonClicker"));
        Thread.sleep(2000);

        driver.findElement(By.name("but2")).click();
        assertEquals("Button with name", checkerElement.getAttribute("value"));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@value='Random' and @type='button']")).click();
        assertEquals("Random", checkerElement.getAttribute("value"));
        Thread.sleep(2000);

        driver.findElement(By.id("but1")).click();
        assertEquals("Button with ID", checkerElement.getAttribute("value"));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@value='Sibling Button' and @type='button']")).click();
        assertEquals("Sibling Button", checkerElement.getAttribute("value"));
        Thread.sleep(2000);

        driver.findElement(By.name("verifybutton")).click();
        assertEquals("Verify this button here", checkerElement.getAttribute("value"));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@value='chocolate' and @type='button' and @name='verifybutton1']")).click();
        assertEquals("chocolate", checkerElement.getAttribute("value"));
        Thread.sleep(2000);


    }
}
