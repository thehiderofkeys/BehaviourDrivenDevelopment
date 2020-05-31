package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void startBrowser(){
        String browser = "Chrome";
        if (browser == "Chrome"){
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser == "IE") {
            System.setProperty("webdriver.ie.driver", "IEdriver.exe");
            driver = new InternetExplorerDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "Geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}