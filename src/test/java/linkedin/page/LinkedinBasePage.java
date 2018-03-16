package linkedin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinBasePage extends BasePage {
    //private By userIconLocator = By.id("profile-nav-item");

    @FindBy(id = "profile-nav-item")
    private WebElement userIcon;

    public LinkedinBasePage(WebDriver someDriver) {
        super(someDriver);

    }

    public boolean isSignedIn() {
        waitUntilElementIsClickable(userIcon);
        return userIcon.isDisplayed();
    }


}
