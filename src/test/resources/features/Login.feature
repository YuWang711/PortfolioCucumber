Feature: Log In functionality
  If a user log in successfully, the web app needs to update the navbar
  to show the user projects.

  If the log in credential is incorrect, then the web app needs to
  notify the user.

  If the username does not exist in the system, then the web app needs
  to notify the user.

  If the user log in, but has not verify their email, then the web
  app needs to redirect the user to an email verification page.

  Scenario: Successful Log in
    Given I am on the Home Page
    When I click on Login
    And I am on Login Page
    And I enter "ytwangBlog+demo@gmail.com" into the "username" field
    And I enter "1234@ABcd" into the "password" field
    And I click on submit
    Then I have access to MyProject
    And I sign out

  Scenario: Fail Log in - Email does not exist
    Given I am on the Home Page
    When I click on Login
    And I am on Login Page
    And I enter "ytwangBlog+notExist@gmail.com" into the "username" field
    And I enter "1234@ABcd" into the "password" field
    And I click on submit
    Then I get login error notification "Login credential does not exist in the system"

  Scenario: Fail Log in - Incorrect credentials
    Given I am on the Home Page
    When I click on Login
    And I am on Login Page
    And I enter "ytwangBlog+demo@gmail.com" into the "username" field
    And I enter "4321@dcBA" into the "password" field
    And I click on submit
    Then I get login error notification "Login credential does not match with the system"

  Scenario: Successful Log in
    Given I am on the Home Page
    When I click on Login
    And I am on Login Page
    And I enter "ytwangBlog+demo2@gmail.com" into the "username" field
    And I enter "1234@ABcd" into the "password" field
    And I click on submit
    Then I arrive at email verification page
