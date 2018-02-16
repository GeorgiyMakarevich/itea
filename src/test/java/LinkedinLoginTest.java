import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {
    public String correctEmail = "jonsnowfromvesteros@gmail.com";
    public String correctPassword = "L;jyCyje;bd";
    public String badEmail = "test@ukr.net";
    public String badPassword = "L;jyCyje;bd";
    @Test
    public void successfulLoginTest() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.linkedin.com/");


        WebElement emailField = driver.findElement(By.cssSelector("input#login-email"));
        WebElement passwordField = driver.findElement(By.cssSelector("input#login-password"));
        WebElement signinButton = driver.findElement(By.cssSelector("input#login-submit"));

        emailField.sendKeys(correctEmail);
        passwordField.sendKeys(correctPassword);
        signinButton.click();

        driver.close();
    }

    @Test
    public void negativeLoginTest() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.linkedin.com/");

        WebElement emailField = driver.findElement(By.cssSelector("input#login-email"));
        WebElement passwordField = driver.findElement(By.cssSelector("input#login-password"));
        WebElement signinButton = driver.findElement(By.cssSelector("input#login-submit"));

        emailField.sendKeys(badEmail);
        passwordField.sendKeys(badPassword);
        signinButton.click();

        WebElement errorMessageDiv = driver.findElement(By.cssSelector("#control_gen_1"));
        Assert.assertTrue(errorMessageDiv.isDisplayed(), "Error message displayed");
        //String expectedErrorText = "There were one or more errors in your submission. Please correct the marked fields below.";
        //String actualErrorText = errorMessageDiv.getText();
        //System.out.println(actualErrorText);
        //Assert.assertTrue(errorMessageDiv.getText().length()>0, "");
        //Assert.assertTrue(errorMessageDiv.getAttribute("class").equals("alert error"));
        //String errorClass = errorMessageDiv.getAttribute("class");
        //System.out.println(errorClass);
        driver.close();
    }
}
