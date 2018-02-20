package linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.List;

public class LinkedinLoginTest {
    public WebDriver driver;
    public WebDriverWait wait;

    public String correctEmail = "jonsnowfromvesteros@gmail.com";
    public String correctPassword = "L;jyCyje;bd";
    public String badEmail = "test@ukr.net";
    public String badPassword = "L;jyCyje;bd1";

    public By emailFieldLocator = By.cssSelector("input#login-email");
    public By passwordFieldLocator = By.cssSelector("input#login-password");
    public By signInButtonLocator = By.cssSelector("input#login-submit");
    public By profileButtonLocator = By.xpath("//*[@id=\"nav-settings__dropdown-trigger\"]");
    public By signOutLinkLocator = By.xpath("//*[@data-control-name=\"nav.settings_signout\"]");
    public By errorMessageDivLocator = By.cssSelector("#control_gen_1");


    public WebElement emailField;
    public WebElement passwordField;
    public WebElement signInButton;
    public WebElement profileButton;
    public WebElement signOutLink;
    public WebElement errorMessageDiv;




    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");

    }

    @AfterClass
    public void afterClass() {

    }

    @BeforeMethod
    public void beforeTest() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 15);
        driver.get("https://www.linkedin.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        emailFieldLocator = By.cssSelector("input#login-email");
        passwordFieldLocator = By.cssSelector("input#login-password");
        signInButtonLocator = By.cssSelector("input#login-submit");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }

    @Test
    public void tc1_successfulLoginTest1() {
        String titleBeforeSignIn = driver.getTitle();
        Assert.assertEquals(titleBeforeSignIn, "LinkedIn: Log In or Sign Up", "Title is bad");

        String urlBeforeSignIn = driver.getCurrentUrl();

        emailField = driver.findElement(emailFieldLocator);
        passwordField = driver.findElement(passwordFieldLocator);
        signInButton = driver.findElement(signInButtonLocator);


        emailField.sendKeys(correctEmail);
        passwordField.sendKeys(correctPassword);
        signInButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(profileButtonLocator));

        profileButton = driver.findElement(profileButtonLocator);
        Assert.assertTrue(profileButton.isDisplayed(), "Profile button is not here");

        Assert.assertTrue(driver.getTitle().contains("LinkedIn"), "Title does not contain LinedIn");
        Assert.assertNotEquals(driver.getTitle(), titleBeforeSignIn, "Title after log in is the same as title before log in");

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.linkedin.com"), "URL does not contain https://www.linkedin.com");
        Assert.assertNotEquals(driver.getCurrentUrl(), urlBeforeSignIn, "URL after log in is the same as URL before log in");

        profileButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(signOutLinkLocator));

        List<WebElement> signOutElements = driver.findElements(signOutLinkLocator);
        System.out.println(signOutElements.size());

        Assert.assertTrue(signOutElements.size() > 0, "Sign Out found");

    }

    @Test
    public void tc2_negativeLoginTest1() {
        emailField = driver.findElement(By.cssSelector("input#login-email"));
        passwordField = driver.findElement(By.cssSelector("input#login-password"));
        signInButton = driver.findElement(By.cssSelector("input#login-submit"));

        emailField.sendKeys(badEmail);
        passwordField.sendKeys(badPassword);
        signInButton.click();

        errorMessageDiv = driver.findElement(errorMessageDivLocator);
        Assert.assertTrue(errorMessageDiv.isDisplayed(), "Error message displayed");
        //String expectedErrorText = "There were one or more errors in your submission. Please correct the marked fields below.";
        //String actualErrorText = errorMessageDiv.getText();
        //System.out.println(actualErrorText);
        //Assert.assertTrue(errorMessageDiv.getText().length()>0, "");
        //Assert.assertTrue(errorMessageDiv.getAttribute("class").equals("alert error"));
        //String errorClass = errorMessageDiv.getAttribute("class");
        //System.out.println(errorClass);

    }
}
