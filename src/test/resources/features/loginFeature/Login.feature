Feature: SSO Login

  Scenario Outline: User logging in

      Given I am on the login page
      And I enter a username:<Username>
      And I enter a password:<Password>
      When I press the login button
      Then I will be <LoggedIn>

      Examples:
          | Username | Password | LoggedIn |
          | "rightUsrN" | "rightPw"  |        "True" |
          | "wrongUsrN" | "rightPw"  |        "False"|
          | "rightUsrN" | "wrongPw"  |       "False" |
