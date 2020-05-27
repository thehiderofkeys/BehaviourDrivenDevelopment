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

public class LoginSteps {

    private final WebDriver driver = new FirefoxDriver();
    @Given("I am on the login page")
    public void i_am_on_the_login_page(){

        // check we're on a given web page
        driver.get("https:\\www.google.com");
    }
    @Given("I enter a {String}")
    public void i_enter_a_username(String username){

    }
    @Given("I enter a {String}")
    public void i_enter_a_password(String password){

    }
    @When("I press the login button")
    public void i_press_the_login_button(){

    }
    @Then("I will be {boolean}")
    public void i_will_be_logged_in(boolean loggedIn){
        System.out.println("hi there");
    }


}
