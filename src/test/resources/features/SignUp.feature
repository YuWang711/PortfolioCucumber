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
    And I am on Login Page
    And I click on Sign Up
    And I enter a name into the "Last Name" field
    And I enter a name into the "First Name" field
    And I enter an email into the Email field
    And I enter a valid password into Password field
    And I click on submit
    Then I arrive at email verification page
    And I receive success notification "Sign up was successful."

  Scenario: Fail Sign up - Email existed already
    Given I am on the Home Page
    When I click on Login
    And I click on Sign Up
    And I enter a name into the "Last Name" field
    And I enter a name into the "First Name" field
    And I enter an existing email into the Email field
    And I enter a valid password into Password field
    And I click on submit
    And I click on submit
    Then I receive error notification "Alert: Email already exist in the system"

  Scenario Outline: Fail Sign up - Password Invalidate
    Given I am on the Home Page
    When I click on Login
    And I click on Sign Up
    And I enter a name into the "Last Name" field
    And I enter a name into the "First Name" field
    And I enter an email into the Email field
    And I enter an "<invalid password>" into Password field
    And I click on submit
    Then I receive error notification "Alert: Password does not meet the requirements"

    Examples:
      | invalid password |
      | 1234             |
      | 1234@abcd        |
      | 1234@ABCD        |
      | abcdefghi        |
      | 1234abcd         |
      | 1234@#$%         |
      | 12345678         |
      | ABCDEFGH         |