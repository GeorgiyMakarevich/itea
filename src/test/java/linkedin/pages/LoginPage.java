package linkedin.pages;

import Common.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver someDriver, String someUrl) {
        super(someDriver);
        url = someUrl;
    }
}
