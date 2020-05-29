package stepDefinitions;


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

import static org.junit.Assert.assertThat;

public class LoginSteps {

    private final WebDriver driver = new FirefoxDriver();
    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        // Automation needs to be implemented
        //driver.get("localhost:3000");

        // check we're on a given web page
        String url = driver.getCurrentUrl();
        assert(url.equals("localhost:3000"));
    }
    @Given("I enter a {String}")
    public void i_enter_a_username(String username){
        // Automation needs to be implemented

        WebElement element = driver.findElement(By.id("usernameElement"));
        String userInput = element.getText();
        assert(!userInput.equals(""));
    }

    @When("I press the login button")
    public void i_press_the_login_button(){
        // Automation needs to be implemented

    }
    @Then("I will be {boolean}")
    public void i_will_be_logged_in(boolean loggedIn){
        // Automation needs to be implemented

        // check for the resulting elements that arise from logging in
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        assert(welcomeMessage.getText().equals("Welcome"));

        System.out.println("You are now logged in");
    }


}
