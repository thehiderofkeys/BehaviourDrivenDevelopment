package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.junit.Assert;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ViewCurrentEnrolmentsSteps {

    MainPage mainPage = new MainPage(Hooks.driver);

    @Given("I am logged in as: {string} on the main page")
    public void i_am_logged_in_on_the_main_page(String username) {
        Hooks.driver.get("http://localhost:3000/"+username+"/main");

        // check we're on a given web page
        assert(Hooks.driver.getCurrentUrl().equals("http://localhost:3000/"+username+"/main"));
    }

    @Then("I can see my {string}")
    public void i_can_see_my_current_enrolments(String courseList) {
        List<String> currentEnrolmentsList = Arrays.asList(courseList.split(","));
        assertEquals(currentEnrolmentsList, mainPage.getCurrentEnrolmentsList());
    }
}
