package Common;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public String url;
    public WebDriver driver;

    public BasePage(WebDriver someDriver) {
        driver = someDriver;
    }
}
