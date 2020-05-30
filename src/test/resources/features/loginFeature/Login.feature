Feature: Logging in

  Scenario Outline: User logging in

      Given I am on the login page
      And I enter a username as "<Username>"
      And I enter a password as "<Password>"
      When I press the login button
      Then I will be "<LoggedIn>"

      Examples:
          | Username | Password | LoggedIn |
          | rightUsrN | rightPw  |        True |
          | wrongUsrN | rightPw  |        False|
          | rightUsrN | wrongPw  |       False |
