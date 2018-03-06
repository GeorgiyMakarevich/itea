package linkedin;

import Drivers.Drivers;
import linkedin.pages.LinkedinLandingPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


public class LinkedinSearchTest {
    public Drivers drivers;
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
    public JavascriptExecutor js;

    public String email = "jonsnowfromvesteros@gmail.com";
    public String password = "L;jyCyje;bd";

    public By searchFieldLocator = By.cssSelector(".nav-search-typeahead input");
    public By startSearchButtonLocator = By.cssSelector(".search-typeahead-v2__button");

    public By searchResultsLocator = By.cssSelector("li.search-result");
    public By searchResultsLocator2 = By.xpath("//li[contains(concat(' ', @class, ' '), ' search-result ')]");

    public By searchResultTitleLocator = By.cssSelector(".actor-name");






    public WebElement searchField;
    public WebElement startSearchButton;

    public List<WebElement> searchResults;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "./src/main/resources/drivers/MicrosoftWebDriver.exe");
        System.setProperty("webdriver.ie.driver", "./src/main/resources/drivers/IEDriverServer.exe");
    }

    @AfterClass
    public void afterClass() {

    }

    @BeforeMethod
    public void beforeTest() {
        driver = drivers.firefox();

        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
        js = ((JavascriptExecutor) driver);
        driver.get("https://www.linkedin.com/");

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }

    @Test
    public void tc1_searchTest1() {
        LinkedinLandingPage linkedinLandingPage = new LinkedinLandingPage(driver);
        linkedinLandingPage.loginAs(email, password);

        String searchText = "hr";
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));

        searchField = driver.findElement(searchFieldLocator);
        searchField.sendKeys(searchText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(startSearchButtonLocator));
        startSearchButton = driver.findElement(startSearchButtonLocator);
        startSearchButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsLocator));

        searchResults = driver.findElements(searchResultsLocator);
        //System.out.println(searchResults.size());

        Assert.assertEquals(searchResults.size(), 10, "Search results count not equal 10");


        int i = 1;
        for (WebElement searchResult : searchResults) {
            js.executeScript("arguments[0].scrollIntoView(true);", searchResult);
            wait.until(ExpectedConditions.visibilityOf(searchResult));

            /*
                actions.moveToElement(searchResult).perform();
            */

            WebElement searchResultTitle = searchResult.findElement(searchResultTitleLocator);
            String searchResultTitleText = searchResultTitle.getText();
            String searchResultText = searchResult.getText();
            //String searchResultClass = searchResult.getAttribute("class");
            System.out.println(i);
            System.out.println(searchResultTitleText);
            //System.out.println("Current text: " + searchResultText);
            //System.out.println("Current class: " + searchResultClass);
            Assert.assertTrue(searchResultText.toLowerCase().contains("hr"), "Search result #" + i + " does not contain text" + searchText);
            i++;
        }




    }
}
