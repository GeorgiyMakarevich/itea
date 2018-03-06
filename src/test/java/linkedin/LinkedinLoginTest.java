package linkedin;

import linkedin.pages.LinkedinHomePage;
import linkedin.pages.LinkedinLandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LinkedinLoginTest {
    public WebDriver driver;
    public LinkedinLandingPage linkedinLandingPage;


    public String correctEmail = "jonsnowfromvesteros@gmail.com";
    public String correctPassword = "L;jyCyje;bd";
    public String badEmail = "test@ukr.net";
    public String badPassword = "L;jyCyje;bd1";

    public String titleBeforeSignIn;
    public String urlBeforeSignIn;


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
        linkedinLandingPage = new LinkedinLandingPage(driver);
        linkedinLandingPage.open();
        titleBeforeSignIn = linkedinLandingPage.getPageTitle();
        urlBeforeSignIn = linkedinLandingPage.getPageUrl();


    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }

    @Test
    public void tc1_successfulLoginTest1() {

        Assert.assertTrue(titleBeforeSignIn.toLowerCase().contains("linkedin"), "Title does not contains \"linkedin\"");
        Assert.assertEquals(urlBeforeSignIn, "https://www.linkedin.com/", "URL is bad");

        LinkedinHomePage linkedinHomePage = linkedinLandingPage.loginAsSuccessful(correctEmail, correctPassword);
        Assert.assertTrue(linkedinHomePage.isSignedIn(), "Profile button is not here");

        String titleAfterSignIn = linkedinHomePage.getPageTitle();
        String urlAfterSignIn = linkedinHomePage.getPageUrl();

        Assert.assertTrue(titleAfterSignIn.contains("LinkedIn"), "Title does not contain LinedIn");
        Assert.assertNotEquals(titleAfterSignIn, titleBeforeSignIn, "Title after log in is the same as title before log in");

        Assert.assertTrue(urlAfterSignIn.contains("https://www.linkedin.com"), "URL does not contain https://www.linkedin.com");
        Assert.assertNotEquals(urlAfterSignIn, urlBeforeSignIn, "URL after log in is the same as URL before log in");

    }

    @Test
    public void tc2_negativeLoginTest1() {
        LinkedinLandingPage linkedinLandingPage = new LinkedinLandingPage(driver);
        linkedinLandingPage.open();
        LinkedinLandingPage linkedinLandingPage2 = linkedinLandingPage.loginAsNotSuccessful(badEmail, badPassword);

        Assert.assertTrue(linkedinLandingPage2.isErrorMessageDivPresent(), "Error message displayed");


    }
}
