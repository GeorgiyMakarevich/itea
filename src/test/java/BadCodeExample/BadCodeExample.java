package BadCodeExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Iterator;
import java.util.List;

import static java.lang.Thread.sleep;

public class BadCodeExample {
    @Test
    public static void main (String args[]) {
        System.out.println("Hello world");
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String url = "https://www.google.com";
        driver.get(url);
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement qInput = driver.findElement(By.cssSelector("input[name=q]"));
        qInput.sendKeys("selenium");
        WebElement OkButton = driver.findElement(By.cssSelector("input[name=btnK]"));
        OkButton.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> resultHeaders = driver.findElements(By.cssSelector("div.g h3"));

        for (Iterator<WebElement> i = resultHeaders.iterator(); i.hasNext();) {
            WebElement resultHeader = i.next();
            String resultHeaderText = resultHeader.getText();
            System.out.println(resultHeaderText);
            String expected_string = "selenium1";
            //boolean isOk = resultHeaderText.toLowerCase().contains(expected_string);
            //System.out.println(isOk);
            Assert.assertTrue(resultHeaderText.toLowerCase().contains(expected_string));
        }

        try {
            sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
