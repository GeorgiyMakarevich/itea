package linkedin.pages;

import Common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public String url;

    public By emailFieldLocator = By.cssSelector("input#login-email");
    public By passwordFieldLocator = By.cssSelector("input#login-password");
    public By signInButtonLocator = By.cssSelector("input#login-submit");

    public WebElement emailField;
    public WebElement passwordField;
    public WebElement signInButton;



    public LoginPage(WebDriver someDriver) {
        driver = someDriver;
        wait = new WebDriverWait(driver, 15);
        url = "https://www.linkedin.com/";
    }

    public void initElements() {
        emailField = driver.findElement(emailFieldLocator);
        passwordField = driver.findElement(passwordFieldLocator);
        signInButton = driver.findElement(signInButtonLocator);
    }

    public void loginAs(String email, String password) {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));

        initElements();

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }

    public void waitUntilElementClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilElementClickable(By locator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilElementClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitUntilElementClickable(WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

}
