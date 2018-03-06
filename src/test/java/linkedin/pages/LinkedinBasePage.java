package linkedin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinBasePage extends BasePage {
    //private By userIconLocator = By.xpath("//*[@id=\"nav-settings__dropdown-trigger\"]");

    @FindBy(id = "profile-nav-item")
    private WebElement userIcon;

    public LinkedinBasePage(WebDriver someDriver) {
        super(someDriver);
        PageFactory.initElements(driver, this);
    }

    public boolean isSignedIn() {
        waitUntilElementIsClickable(userIcon);
        return userIcon.isDisplayed();
    }


}
