package linkedin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    //public WebDriverWait wait;
    public String url;

    public BasePage (WebDriver someDriver) {
        driver = someDriver;
        //wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }


    public WebElement getElement(By webElementLocator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(webElementLocator));
        return driver.findElement(webElementLocator);
    }

    public boolean isElementPresent (By webElementLocator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(webElementLocator));
        try {
            driver.findElement(webElementLocator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /*

    public WebElement getElement(By webElementLocator) {
        return getElement(webElementLocator, 10);
    }

    public boolean isElementPresent(By webElementLocator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(webElementLocator));
        return driver.findElements(webElementLocator).size()>0;
    }



    public void waitUntilElementIsClickable(By webElementLocator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElementLocator));
    }

    public void waitUntilElementIsClickable(By webElementLocator) {
        waitUntilElementIsClickable(webElementLocator, 10);
    }
    */

    public void waitUntilElementIsClickable(WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitUntilElementIsClickable(WebElement webElement) {
        waitUntilElementIsClickable(webElement, 10);
    }


}
