package linkedin;

import linkedin.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class LinkedinSearchTest {
    public WebDriver driver;
    public WebDriverWait wait;

    public String email = "jonsnowfromvesteros@gmail.com";
    public String password = "L;jyCyje;bd";

    public By searchFieldLocator = By.cssSelector(".nav-search-typeahead input");

    public By searchResultsLocator = By.cssSelector(".search-results .search-result");

    public WebElement searchField;

    public List<WebElement> searchResults;

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
        wait = new WebDriverWait(driver, 30);
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }

    @Test
    public void tc1_searchTest1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email, password);

        String searchText = "hr";
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));

        searchField = driver.findElement(searchFieldLocator);
        searchField.sendKeys(searchText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsLocator));
        searchResults = driver.findElements(searchResultsLocator);

    }
}
