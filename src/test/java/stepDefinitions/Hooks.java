package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void startBrowser(){
        String browser = "Firefox";
        if (browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("IE")) {
            System.setProperty("webdriver.ie.driver", "IEdriver.exe");
            driver = new InternetExplorerDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
