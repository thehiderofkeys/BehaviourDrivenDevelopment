Feature: View Course Details
  Background:
    Given I am logged in as 'user123' on the main page

  Scenario Outline: When I click on an enrolled course, I should see the course details
    Given My enrollment list includes <EnrolledCourse>
    When I click on the expansion button next to enrolled course, <EnrolledCourse>
    Then I should be able to see the lecture time as: <LectureTime>
    And I should be able to see the lab time as: <LabTime>
    And I should be able to see the tutorial time as: <TutorialTime>


    Examples:
      | EnrolledCourse| LectureTime  | LabTime      | TutorialTime   |
      | 'SOFTENG 754' | 'Monday 11am'|'Tuesday 11am'|'Wednesday 11am'|
      | 'SOFTENG 754' | 'Monday 12pm'|'Monday 12pm' |'Monday 12pm'   |

  Scenario Outline: When I click on a returned course from a search, I should see the course details
    Given I searched for <SearchedCourse> in the search bar
    When I click on the expansion button next to searched course, <SearchedCourse>
    Then I should be able to see the lecture time as: <LectureTime>
    And I should be able to see the lab time as: <LabTime>
    And I should be able to see the tutorial time as: <TutorialTime>


    Examples:
      | SearchedCourse| LectureTime  | LabTime      | TutorialTime   |
      | 'SOFTENG 754' | 'Monday 11am'|'Tuesday 11am'|'Wednesday 11am'|
      | 'SOFTENG 754' | 'Monday 12pm'|'Monday 12pm' |'Monday 12pm'   |

