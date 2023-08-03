package feature;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage.Components.NavBar;
import page.HomePage.HomePage;

public class SignUp {

    HomePage homepage;
    NavBar navbar;

    @Before
    public void BeforeScenario(){
        homepage = new HomePage();
        navbar = new NavBar();
    }

    @Given("I am on the Home Page")
    public void i_am_on_the_home_page() {
        homepage.GoToHomePage();
    }

    @When("I click on Login")
    public void i_click_on_login() {
        navbar.clickOnLogin();
    }

    @When("I click on Sign Up")
    public void i_click_on_sign_up() {

    }

    @When("I filled out the form")
    public void i_filled_out_the_form() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I click on submit")
    public void i_click_on_submit() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I arrive at email verification page")
    public void i_arrive_at_email_verification_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I receive notification that sign up was successful")
    public void i_receive_notification_that_sign_up_was_successful() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I receive notification that Email has already existed")
    public void i_receive_notification_that_email_has_already_existed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I receive notification that Password is invalid")
    public void i_receive_notification_that_password_is_invalid() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
