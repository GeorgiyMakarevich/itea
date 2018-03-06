package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.edge.EdgeDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;

public class Drivers {
    public Drivers() {




    }
    public WebDriver chrome() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        return new ChromeDriver();
    }
    public WebDriver firefox() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");
        return new FirefoxDriver();
    }
    public WebDriver ie() {
        System.setProperty("webdriver.ie.driver", "./src/main/resources/drivers/IEDriverServer.exe");
        return new InternetExplorerDriver();
    }

    /*
    public static WebDriver edge() {
        System.setProperty("webdriver.edge.driver", "./src/main/resources/drivers/MicrosoftWebDriver.exe");
        return new EdgeDriver();
    }
    */

    /*
    public static void createAndStartService() {
        EdgeDriverService service = new EdgeDriverService.Builder()
                .usingDriverExecutable(new File("./src/main/resources/drivers/MicrosoftWebDriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
    }
    */

}
