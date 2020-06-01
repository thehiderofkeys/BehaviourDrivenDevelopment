package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EnrollSteps {


    @Given("I am on the main page")
    public void i_am_on_the_main_page(){
        assert(Hooks.driver.getCurrentUrl().equals("http://localhost:3000/"));
    }

    @And("I am logged in as: {string}")
    public void i_am_logged_in(String username){
        assert(mainPage.getUsername().equals(username));
    }

    @And("I have completed courses {string}")
    public void i_have_completed_courses(String completedCoursesCommaSeparated){
        assert(mainPage.getCompletedCourses().equals(completedCourses));
    }

    @Given("I enter a {string} into the search bar")
    public void i_enter_a_course_name_into_the_search_bar(String courseName){
        assert(mainPage.getSearchBarText().equals(coruseName));
    }

    @When("I press the 'enroll' button")
    public void i_press_the_enroll_button(){

    }

    @Then("I am {string} in <CourseName>")
    public void i_am_enrolled_in_the_course(String enrolmentStatus, String courseName){
        assert(mainPage.getEnrolmentStatus(courseName).equals(enrolmentStatus));
    }

}
