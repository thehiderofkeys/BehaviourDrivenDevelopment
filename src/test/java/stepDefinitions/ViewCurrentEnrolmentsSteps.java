package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.junit.Assert;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.util.List;

import static org.junit.Assert.*;

public class ViewCurrentEnrolmentsSteps {

    MainPage mainPage = new MainPage(Hooks.driver);

    @Given("I am on the main page")
    public void i_am_on_the_main_page(){


        // check we're on a given web page
        assert(Hooks.driver.getCurrentUrl().equals("http://localhost:3000/"));
    }

    @Given("I am logged in as: {String}")
    public void i_am_logged_in(String username){
        mainPage.logIn(username);

        assert(mainPage.getUsername().equals(username));
    }

    @When ("I press the 'show current enrolments' button")
    public void i_press_the_show_current_enrolments_button(){
        mainPage.click_show_current_enrolments_button();
    }

    @Then ("I can see my {CurrentEnrolments}")
    public void i_can_see_my_current_enrolments(List<String> currentEnrolmentsList){

        assert(mainPage.getCurrentEnrolmentsList().equals(currentEnrolmentsList));
    }

}
