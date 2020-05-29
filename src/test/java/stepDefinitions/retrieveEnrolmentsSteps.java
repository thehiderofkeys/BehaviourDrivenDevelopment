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

import java.util.List;

public class retrieveEnrolmentsSteps {
    private final WebDriver driver = new FirefoxDriver();
    @Given ("I am on the main page")
    public void i_am_on_the_main_page(){
        driver.get("localhost:3000");

        //check we're on the web page (might just be localhost for our testing)
        String url = driver.getCurrentUrl();
        assert(url.equals("localhost:3000"));
    }

    @And("I am logged in with a <Username>")
    public void i_am_logged_in_with_a_username(String username){
        driver.findElement(By.id("username")).sendKeys(username);

        WebElement element = driver.findElement(By.id("userInfo"));
        String loggedInUser = element.getAttribute("username");
        assert(username.equals(loggedInUser));
    }

    @When("I press the 'see enrolled courses' button")
    public void i_press_the_see_enrolled_courses_button(){
        driver.findElement(By.id("see_enrolled_courses_button")).click();
    }

    @Then ("My <Enrolled courses> are displayed")
    public void my_enrolled_courses_are_displayed(List<String> enrolledCourses){
        // no automation needed

        WebElement element = driver.findElement(By.id("enrolledCourses"));

        // TODO figure out how to access a list, and how to identify unique elements
        String currentEnrolledCourse = element.getAttribute("courseName");
        String currentEnrolledCourse2 = element.getAttribute("courseName");

        assert(currentEnrolledCourse.equals("701"));
        assert(currentEnrolledCourse2.equals("702"));
    }

}
