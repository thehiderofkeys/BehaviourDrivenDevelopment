package pageObjects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(how = How.ID, using="currentEnrolledCourse")
    private List<WebElement> currentEnrolmentElementsList;

    @FindBy(how = How.NAME, using="completedCourse")
    private List<WebElement> completedCourseElementsList;

    @FindBy(how = How.ID, using="failedToEnrollCourse")
    private List<WebElement> failedToEnrollCourseElementsList;

    @FindBy(how = How.ID, using="enrollButton")
    private List<WebElement> enrollButtonElementsList;

    @FindBy(how = How.ID, using="errorMessage")
    private List<WebElement> errorMessageElementList;

    @FindBy(how = How.ID, using="errorMessageReason")
    private List<WebElement> errorMessageReasonElementList;

    @FindBy(how = How.ID, using="unenrollButton")
    private List<WebElement> unenrollButtonList;

    @FindBy(how = How.ID, using="saveButton")
    private WebElement saveButton;

    @FindBy(how = How.ID, using = "courseSearchBar")
    private WebElement courseSearchBarElement;

    @FindBy(how = How.ID, using="searchButton")
    private WebElement searchButton;

    @FindBy(how = How.ID, using="enrolledDetailsButton")
    private List<WebElement> enrolledDetailsButtons;

    @FindBy(how = How.ID, using="searchDetailsButton")
    private List<WebElement> searchDetailsButtons;

    @FindBy(how = How.ID, using="failedDetailsButton")
    private List<WebElement> failedDetailsButtons;

    @FindBy(how = How.ID, using="concessionDetailsButton")
    private List<WebElement> concessionDetailsButtons;

    @FindBy(how = How.ID, using="LectureTime")
    private List<WebElement> lectureTimes;

    @FindBy(how = How.ID, using="LabTime")
    private List<WebElement> labTimes;

    @FindBy(how = How.ID, using="TutorialTime")
    private List<WebElement> tutorialTimes;

    @FindBy(how = How.ID, using="applyForConcessionButton")
    private List<WebElement> applyForConcessionButtonElementList;

    @FindBy(how = How.ID, using="reasonTextBox")
    private List<WebElement> reasonTextBoxElementList;

    @FindBy(how = How.ID, using="concessionText")
    private List<WebElement> concessionTextElementList;

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

    public void pressApplyForConcessionButton(String courseName){
        for (WebElement buttonElement : applyForConcessionButtonElementList){
            if (buttonElement.getAttribute("courseName").equals(courseName)){
                buttonElement.click();
                return;
            }
        }
    }

    public String getConcessionText(String specifiedCourse){
        for (WebElement concessionText: concessionTextElementList){
            if (concessionText.getAttribute("courseName").equals(specifiedCourse)) {
                return concessionText.getText();
            }
        }
        return "";
    }

    public void enterReason(String reason, String specifiedCourse){
        for (WebElement reasonTextBox: reasonTextBoxElementList){
            if (reasonTextBox.getAttribute("name").equals(specifiedCourse)) {
                reasonTextBox.sendKeys(reason);
                return;
            }
        }
    }

    public String getReasonTextBoxText(String specifiedCourse){
        for (WebElement reasonTextBox: reasonTextBoxElementList){
            if (reasonTextBox.getAttribute("name").equals(specifiedCourse)) {
                return reasonTextBox.getAttribute("value");
            }
        }
        return "";
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

    public void expandDetailsOfEnrolledCourse(String specifiedCourse){
        for (WebElement buttonElement: enrolledDetailsButtons){
            if (buttonElement.getAttribute("courseName").equals(specifiedCourse)) {
                buttonElement.click();
                return;
            }
        }
    }

    public void expandDetailsOfSearchedCourse(String specifiedCourse){
        for (WebElement buttonElement: searchDetailsButtons){
            if (buttonElement.getAttribute("courseName").equals(specifiedCourse)) {
                buttonElement.click();
                return;
            }
        }
    }

    public void expandDetailsOfFailedCourse(String specifiedCourse){
        for (WebElement buttonElement: failedDetailsButtons){
            if (buttonElement.getAttribute("courseName").equals(specifiedCourse)) {
                buttonElement.click();
                return;
            }
        }
    }

    public void expandDetailsOfConcession(String specifiedCourse){
        for (WebElement buttonElement: concessionDetailsButtons){
            if (buttonElement.getAttribute("courseName").equals(specifiedCourse)) {
                buttonElement.click();
                return;
            }
        }
    }

    public String getLectureTime(String specifiedCourse){
        for (WebElement lectureTime: lectureTimes){
            if (lectureTime.getAttribute("courseName").equals(specifiedCourse)) {
                return lectureTime.getText();
            }
        }
        return "";
    }

    public String getLabTime(String specifiedCourse){
        for (WebElement labTime: labTimes){
            if (labTime.getAttribute("courseName").equals(specifiedCourse)) {
                return labTime.getText();
            }
        }
        return "";
    }


    public String getTutorialTime(String specifiedCourse){
        for (WebElement tutorialTime: tutorialTimes){
            if (tutorialTime.getAttribute("courseName").equals(specifiedCourse)) {
                return tutorialTime.getText();
            }
        }
        return "";
    }

    public Boolean didFailToEnrollInCourse(String specifiedCourse){
        for (WebElement failedCourse: failedToEnrollCourseElementsList){
            if (failedCourse.getText().equals(specifiedCourse)) {
                return true;
            }
        }
        return false;
    }


    public String getErrorMessage(String specifiedCourse){
        for (WebElement errorMessageElement: errorMessageElementList){
            if (errorMessageElement.getAttribute("courseName").equals(specifiedCourse)) {
                return errorMessageElement.getText();
            }
        }
        return "";
    }

    public String getErrorMessageReason(String specifiedCourse){
        for (WebElement errorMessageReasonElement: errorMessageReasonElementList){
            if (errorMessageReasonElement.getAttribute("courseName").equals(specifiedCourse)) {
                return errorMessageReasonElement.getText();
            }
        }
        return "";
    }

    public String getAlertMessage(){
        return driver.switchTo().alert().getText();
    }
}
