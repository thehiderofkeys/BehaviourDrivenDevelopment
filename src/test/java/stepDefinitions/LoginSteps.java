package stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    @Given("I am on the login page")
    public void i_am_on_the_login_page(){

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
