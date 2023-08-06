package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage.Components.NavBar;
import page.HomePage.HomePage;
import page.LoginPage.Components.LoginForm;
import page.LoginPage.LoginPage;
import page.SignUpPage.Components.SignUpForm;
import page.SignUpPage.SignUpPage;
import page.VerificationPage.Components.VerificationForm;
import page.VerificationPage.VerificationPage;
import util.inputGenerator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserAuthenticationSteps {

    NavBar navbar;
    HomePage homePage;
    LoginForm loginForm;
    LoginPage loginPage;
    SignUpPage signUpPage;
    SignUpForm signUpForm;
    inputGenerator inputGen;
    VerificationForm verificationForm;
    VerificationPage verificationPage;

    @Before
    public void BeforeScenario(){
        navbar = new NavBar();
        loginForm = new LoginForm();
        homePage = new HomePage();
        loginPage = new LoginPage();
        signUpPage = new SignUpPage();
        signUpForm = new SignUpForm();
        verificationPage = new VerificationPage();
        verificationForm = new VerificationForm();
        inputGen = new inputGenerator();
    }

    @Given("I am on the Home Page")
    public void i_am_on_the_home_page() {
        homePage.GoToHomePage();
    }
    @When("I am on Login Page")
    public void i_am_on_login_page() {
        assertTrue(loginPage.checkIfOnLoginPage());
    }
    @When("I click on Login")
    public void i_click_on_login() {
        navbar.clickOnLogin();
    }

    @When("I click on Sign Up")
    public void i_click_on_sign_up() {
        loginForm.ClickOnSignUp();
    }
    @When("I enter a name into the {string} field")
    public void i_enter_a_name_into_the_field(String field) {
        switch(field){
            case "First Name":
                signUpForm.EnterFirstName(inputGen.randomString(5));
                break;
            case "Last Name":
                signUpForm.EnterLastName(inputGen.randomString(5));
                break;
        }
    }
    @When("I enter an email into the Email field")
    public void i_enter_an_email_into_the_email_field() {
        String tempEmail = "ytwangBlog+" + inputGen.randomString(10) + "@gmail.com";
        signUpForm.EnterEmail(tempEmail);
    }

    @When("I enter an existing email into the Email field")
    public void i_enter_an_existing_email_into_the_email_field() {
        String tempEmail = "ytwangBlog@gmail.com";
        signUpForm.EnterEmail(tempEmail);
    }
    @When("I enter a valid password into Password field")
    public void i_enter_a_valid_password_into_password_field() {
        String tempPass = "1234!@#ABcd";
        signUpForm.EnterPassword(tempPass);
        signUpForm.EnterPasswordAgain(tempPass);
    }
    @When("I enter an {string} into Password field")
    public void i_enter_an_into_password_field(String password) {
        signUpForm.EnterPassword(password);
        signUpForm.EnterPasswordAgain(password);
    }

    @When("I click on submit")
    public void i_click_on_submit() {
        signUpForm.ClickOnSubmit();
    }

    @Then("I arrive at email verification page")
    public void i_arrive_at_email_verification_page() {
        assertTrue(verificationPage.checkIfOnVerificationPage());
    }
    @Then("I receive success notification {string}")
    public void i_receive_success_notification(String expectedResult) {
        assertEquals(expectedResult, verificationForm.getSuccessMessage());
    }
    @Then("I receive error notification {string}")
    public void i_receive_error_notification(String expectedResult) {
        assertEquals(expectedResult, signUpForm.getErrorMessage());
    }
    @When("I input {string} into password fields")
    public void i_input_into_password_fields(String string) {
        signUpForm.EnterPassword(string);
        signUpForm.EnterPasswordAgain(string);
    }
    @When("I enter {string} into the {string} field")
    public void i_enter_into_the_field(String inputs, String fieldToInput) {
        switch(fieldToInput){
            case "username":
                loginForm.EnterUsername(inputs);
                break;
            case "password":
                loginForm.EnterPassword(inputs);
                break;
            default:
                break;
        }
    }

    @Then("I arrive at home page")
    public void i_arrive_at_home_page() {
        assertTrue(homePage.checkIfOnHomePage());
    }

    @Then("I have access to MyProject")
    public void i_have_access_to_my_project() {
        assertTrue(navbar.checkIfMyProjectIsAccessible());
    }

    @Then("I sign out")
    public void i_sign_ut() {
        navbar.clickOnSignOut();
    }
    @Then("I get login error notification {string}")
    public void i_get_login_error_notification(String expectedResult) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(expectedResult, loginForm.getErrorMessage());
    }
}
