package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class retrieveEnrolmentsSteps {
    @Given ("I am on the main page")
    public void i_am_on_the_main_page(){
        //driver.get("localhost:3000");

        //check we're on the web page (might just be localhost for our testing)
        String url = driver.getCurrentUrl;
    }

}
