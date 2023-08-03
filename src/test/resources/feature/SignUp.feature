Feature: Sign Up functionality
  If a user sign up successfully, the web app needs to inform the user that
  email verification is send.

  If there is an existing email in the system, the system needs to inform
  that the email has already register.

  If the user failed to pass password validation, the system needs to
  inform the user that either the password format is incorrect, or the
  second password does not match the first password.

  Scenario: Successful Sign Up
    Given I am on the Home Page
    When I click on Login
    And I click on Sign Up
    And I filled out the form
    And I click on submit
    Then I arrive at email verification page
    And I receive notification that sign up was successful

  Scenario: Fail Sign up - Email existed already
    Given I am on the Home Page
    When I click on Login
    And I click on Sign Up
    And I filled out the form
    And I click on submit
    Then I receive notification that Email has already existed

  Scenario: Fail Sign up - Password Invalidate
    Given I am on the Home Page
    When I click on Login
    And I click on Sign Up
    And I filled out the form
    And I click on submit
    Then I receive notification that Password is invalid