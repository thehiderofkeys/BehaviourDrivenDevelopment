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

public class UnenrollSteps {
    MainPage mainPage = new MainPage(Hooks.driver);

    @Given("I am on the main page")
    public void i_am_on_the_main_page(){
        assert(Hooks.driver.getCurrentUrl().equals("http://localhost:3000/"));
    }

    @Given("I am logged in as: {string}")
    public void i_am_logged_in(String username){
        mainPage.logIn(username);

        assert(mainPage.getUsername().equals(username));
    }

    @When("I press the 'unenroll' button next to a listed {string}")
    public void i_press_the_unenroll_button_next_to_a_listed_course(String course){
        mainPage.pressAnUnenrollButton(course);
    }

    @Then("I can see my <string> without the <string>, as <string>")
    public void i_can_see_my_current_enrolments_without_the_specified_course(
            String currentEnrolmentsCommaSeparated,
            String specifiedCourse,
            String expectedEnrolmentsCommaSeparated)
    {
        List<String> expectedEnrolments = Arrays.asList(expectedEnrolmentsCommaSeparated.split(","));

        assert(mainPage.getCurrentEnrolmentsList().equals(expectedEnrolments));
    }

    @Then("I can see my <string> as before, and see an <string>")
    public void i_can_see_my_current_enrolments_and_see_an_error(
            String currentEnrolmentsCommaSeparated,
            String errorMessage)
    {
        List<String> currentEnrolments = Arrays.asList(currentEnrolmentsCommaSeparated.split(","));

        assert(mainPage.getCurrentEnrolmentsList().equals(currentEnrolments));
        assert(mainPage.getErrorMessage().equals(errorMessage));
    }
}
