package linkedin.page;

import org.openqa.selenium.WebDriver;

public class LinkedinHomePage extends LinkedinBasePage {
    public LinkedinHomePage(WebDriver someDriver) {
        super(someDriver);
        url = "https://www.linkedin.com/feed";
    }
}
