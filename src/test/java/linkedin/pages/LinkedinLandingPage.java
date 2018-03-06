package linkedin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLandingPage extends BasePage {
    //private By emailFieldLocator = By.cssSelector("input#login-email");
    //private By passwordFieldLocator = By.cssSelector("input#login-password");
    //private By signInButtonLocator = By.cssSelector("input#login-submit");
    private By errorMessageDivLocator = By.cssSelector("#control_gen_1");

    @FindBy (id = "login-email")
    private WebElement emailField;

    @FindBy (id = "login-password")
    private WebElement passwordField;

    @FindBy (id = "login-submit")
    private WebElement signInButton;

    @FindBy (id = "control_gen_1")
    private WebElement errorMessageDiv;

    public LinkedinLandingPage(WebDriver someDriver) {
        super(someDriver);
        url = "https://www.linkedin.com/";
        PageFactory.initElements(driver, this);
    }

    /*
    public void initElements() {
        emailField = getElement(emailFieldLocator);
        passwordField = getElement(passwordFieldLocator);
        signInButton = getElement(signInButtonLocator);
    }
    */

    /*
    public void initErrorElements() {
        errorMessageDiv = getElement(errorMessageDivLocator);
    }
    */

    public boolean isErrorMessageDivPresent() {

        return driver.findElements(errorMessageDivLocator).size() > 0;
    }


    public String getErrorMessage() {
        //initErrorElements();
        return errorMessageDiv.getText();
    }

    public void loginAs(String email, String password) {
        //initElements();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }

    public LinkedinHomePage loginAsSuccessful(String email, String password) {
        loginAs(email, password);
        return new LinkedinHomePage(driver);
    }

    public LinkedinLandingPage loginAsNotSuccessful(String email, String password) {
        loginAs(email, password);
        return this;
    }


}
