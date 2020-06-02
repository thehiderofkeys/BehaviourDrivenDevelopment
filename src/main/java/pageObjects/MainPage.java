package pageObjects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using="currentEnrolledCourse")
    private List<WebElement> currentEnrolmentElementsList;

    @FindBy(how = How.NAME, using="completedCourse")
    private List<WebElement> completedCourseElementsList;

    @FindBy(how = How.ID, using="enrollButton")
    private List<WebElement> enrollButtonElementsList;

    @FindBy(how = How.ID, using="errorMessage")
    private WebElement errorMessageElement;

    @FindBy(how = How.ID, using="unenrollButton")
    private List<WebElement> unenrollButtonList;

    @FindBy(how = How.ID, using="saveButton")
    private WebElement saveButton;

    @FindBy(how = How.ID, using = "courseSearchBar")
    private WebElement courseSearchBarElement;

    @FindBy(how = How.ID, using="searchButton")
    private WebElement searchButton;

    public List<String> getCurrentEnrolmentsList(){
        List<String> currentEnrolmentsList = new ArrayList();
        for (WebElement currentEnrolledCourseElement : currentEnrolmentElementsList){
            currentEnrolmentsList.add(currentEnrolledCourseElement.getText());
        }
        return currentEnrolmentsList;
    }

    public List<String> getCompletedCoursesList(){
        List<String> completedCoursesList = new ArrayList();
        for (WebElement completedCourseElement : completedCourseElementsList){
            completedCoursesList.add(completedCourseElement.getAttribute("value"));
        }
        return completedCoursesList;
    }

    public void enterCourseName(String search){
        courseSearchBarElement.sendKeys(search);
    }

    public String getSearchBarText(){
        return courseSearchBarElement.getAttribute("value");
    }

    public void pressSearchButton() {
        searchButton.click();
    }

    public String getEnrolmentStatus(String course){
        for (WebElement enrolledCourseElement : currentEnrolmentElementsList){
            if (enrolledCourseElement.getText().equals(course)){
                return ("Enrolled");
            }
        }
        return ("NotEnrolled");
    }

    public void pressAnUnenrollButton(String specifiedCourse){
        for (WebElement buttonElement : unenrollButtonList){
            if (buttonElement.getAttribute("courseName").equals(specifiedCourse)){
                buttonElement.click();
                return;
            }
        }
    }

    public void pressSaveButton() {
        saveButton.click();
    }

    public void pressAnEnrollButton(String specifiedCourse){
        List<WebElement> buttonElementsList = enrollButtonElementsList;
        for (WebElement buttonElement : buttonElementsList){
            if (buttonElement.getAttribute("courseName").equals(specifiedCourse)){
                buttonElement.click();
                return;
            }
        }
    }

    public String getErrorMessage(){
        return errorMessageElement.getText();
    }
}
