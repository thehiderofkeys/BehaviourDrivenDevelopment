package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MainPage;

import static org.junit.Assert.assertEquals;

public class ViewCourseDetailsSteps {

    MainPage mainPage = new MainPage(Hooks.driver);

    @Given("I am logged in as 'user123' on the main page")
    public void i_am_logged_in_as_user123_on_the_main_page() {
        Hooks.driver.get("http://localhost:3000/user123/main");
        assertEquals("http://localhost:3000/user123/main",Hooks.driver.getCurrentUrl());
    }

    @Given("My enrollment list includes {string}")
    public void my_enrollment_list_includes_enrolled_course(String enrolledCourse) {
        assertEquals("Enrolled",mainPage.getEnrolmentStatus(enrolledCourse));
    }
    @When("I click on the expansion button next to enrolled course, {string}")
    public void I_click_on_the_expansion_button_next_to_enrolled_course(String enrolledCourse) {
        mainPage.expandDetailsOfEnrolledCourse(enrolledCourse);

    }
    @When("I click on the expansion button next to searched course, {string}")
    public void I_click_on_the_expansion_button_next_to_searched_course(String searchedCourse) {
        mainPage.expandDetailsOfSearchedCourse(searchedCourse);
    }
    @Then("I should be able to see the lecture time as: {string} for the course: {string}")
    public void i_should_be_able_to_see_the_lecture_time(String lectureTime, String course) {
        assertEquals(lectureTime, mainPage.getLectureTime(course));
    }
    @Then("I should be able to see the lab time as: {string} for the course: {string}")
    public void i_should_be_able_to_see_the_lab_time(String labTime, String course) {
        assertEquals(labTime, mainPage.getLabTime(course));
    }
    @Then("I should be able to see the tutorial time as: {string} for the course: {string}")
    public void i_should_be_able_to_see_the_tutorial_time(String tutorialTime, String course) {
        assertEquals(tutorialTime, mainPage.getTutorialTime(course));
    }
}
