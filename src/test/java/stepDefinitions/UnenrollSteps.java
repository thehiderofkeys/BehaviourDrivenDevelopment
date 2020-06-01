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

import static org.junit.Assert.assertEquals;

public class UnenrollSteps {
    MainPage mainPage = new MainPage(Hooks.driver);

    @Given("I am logged in as: {string} on the main page to unenroll")
    public void i_am_logged_in_on_the_main_page(String username) {
        Hooks.driver.get("http://localhost:3000/"+username+"/main");

        // check we're on a given web page
        assert(Hooks.driver.getCurrentUrl().equals("http://localhost:3000/"+username+"/main"));
    }

    @Given("I am enrolled in {string}")
    public void iAmEnrolledInCurrentEnrolments(String currentEnrolmentsCommaSeparated) {
        List<String> currentEnrolmentsList = Arrays.asList(currentEnrolmentsCommaSeparated.split(","));
        assertEquals(currentEnrolmentsList, mainPage.getCurrentEnrolmentsList());

    }

    @When("I press the 'unenroll' button next to a listed {string} and I click Save")
    public void i_press_the_unenroll_button_next_to_a_listed_course(String course){
        mainPage.pressAnUnenrollButton(course);
        mainPage.pressSaveButton();
    }

    @Then("The list of enrolled courses should be updated to {string}")
    public void i_can_see_my_current_enrolments_without_the_specified_course(String expectedEnrolmentsCommaSeparated)
    {
        List<String> expectedEnrolments;

        if (expectedEnrolmentsCommaSeparated.equals("")){
            expectedEnrolments = new ArrayList<>();
        } else {
            expectedEnrolments = Arrays.asList(expectedEnrolmentsCommaSeparated.split(","));
        }


        assert(mainPage.getCurrentEnrolmentsList().equals(expectedEnrolments));
    }
}
