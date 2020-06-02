Feature: View Course Details
  Background:
    Given I am logged in as 'user123' on the main page

  Scenario Outline: When I click on an enrolled course, I should see the course details
    Given My enrollment list includes <EnrolledCourse>
    When I click on the expansion button next to enrolled course, <EnrolledCourse>
    Then I should be able to see the lecture time as: <LectureTime> for the course: <EnrolledCourse>
    And I should be able to see the lab time as: <LabTime> for the course: <EnrolledCourse>
    And I should be able to see the tutorial time as: <TutorialTime> for the course: <EnrolledCourse>


    Examples:
      | EnrolledCourse| LectureTime  | TutorialTime | LabTime        |
      | 'SOFTENG 754' | 'Monday 4pm' |'Tuesday 4pm' |'Wednesday 4pm' |
      | 'SOFTENG 701' | 'Monday 10am'|'Tuesday 10am'|'Wednesday 10am'|

  Scenario Outline: When I click on a returned course from a search, I should see the course details
    Given I searched for <SearchedCourse> in the search bar
    When I click on the expansion button next to searched course, <SearchedCourse>
    Then I should be able to see the lecture time as: <LectureTime> for the course: <SearchedCourse>
    And I should be able to see the lab time as: <LabTime> for the course: <SearchedCourse>
    And I should be able to see the tutorial time as: <TutorialTime> for the course: <SearchedCourse>


    Examples:
      | SearchedCourse| LectureTime  | TutorialTime | LabTime        |
      | 'SOFTENG 754' | 'Monday 4pm' |'Tuesday 4pm' |'Wednesday 4pm' |
      | 'SOFTENG 701' | 'Monday 10am'|'Tuesday 10am'|'Wednesday 10am'|

