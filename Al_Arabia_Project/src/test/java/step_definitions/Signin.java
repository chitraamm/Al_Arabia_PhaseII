package test.java.step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Signinpage;
import resources.Base;

public class Signin extends Base {

    private Logger LOGGER = LogManager.getLogger(Signin.class);
    private final Signinpage signinpage;

    public Signin(Testhooks testhooks) throws Exception {
        WebDriver driver = testhooks.getDriver();
        this.signinpage = new Signinpage(driver);
        LOGGER = LogManager.getLogger(Signin.class.getName());
    }

    @Given("User navigates to Login page")
    public void user_navigates_to_login_page() {
        LOGGER.info("User navigates to the login page");
    }

    @When("^User enters valid email address$")
    public void user_enters_valid_email_address() {
        signinpage.enterValidEmail();
    }

    @When("^Enter invalid password without special character$")
    public void enter_invalid_password_without_special_character() {
        signinpage.enterInvalidPasswordWithoutSpecialCharacter();
    }

    @And("^Enter invalid password with short char$")
    public void enter_invalid_password_with_short_char() {
        signinpage.enterInvalidPasswordShortCharacter();
    }

    @When("^Enter valid password$")
    public void enter_valid_password() {
        signinpage.enterValidPassword();
    }

    @When("Clicks on Sign in button")
    public void clicks_on_sign_in_button() {
        signinpage.clickSignInButton();
    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {
        signinpage.checkDashboardDisplayed();
    }

    @Then("Al-Arabia dashboard should display successfully")
    public void al_arabia_dashboard_should_display_successfully() {
        signinpage.checkDashboardDisplayed();
    }

    @When("^User enters invalid email address$")
    public void user_enters_invalid_email_address() {
        signinpage.enterInvalidEmail();
    }

    @When("^Enter invalid password$")
    public void enter_invalid_password() {
        signinpage.enterInvalidPassword();
    }

    @When("^Enter invalid password Password$")
    public void enter_invalid_password_password() {
        signinpage.enterPasswordWithoutNumber();
    }

    @And("^Click password field eye icon$")
    public void click_password_field_eye_icon() {
        signinpage.clickPasswordFieldEyeIcon();
    }

    @Then("User should get a invalid email and password error message")
    public void user_should_get_a_invalid_email_and_password_error_message() {
        signinpage.checkUserPasswordErrorDisplayed();
    }

    @Then("User should get must contain one number error message")
    public void user_should_get_must_contain_one_number_error_message() {
        signinpage.checkPasswordNoNumberErrorDisplayed();
    }

    @When("User don't enter any credentials")
    public void user_don_t_enter_any_credentials() {
        System.out.println("User has not entered any inputs in the fields");
    }

    @Then("User should get must contain one special case character error message")
    public void user_should_get_must_contain_one_special_case_character_error_message() {
        signinpage.checkPasswordNoSpecialCharErrorDisplayed();
    }

    @Then("User should get must contain one upper case character error message")
    public void user_should_get_must_contain_one_upper_case_character_error_message() {
        signinpage.checkPasswordNoUppercaseErrorDisplayed();
    }

    @And("Enter invalid password without uppercase char")
    public void enter_invalid_password_without_uppercase_char() {
        signinpage.enterInvalidPasswordWithoutUpperCharacter();
    }

    @Then("User should get password is too short error message")
    public void user_should_get_password_is_too_short_error_message() {
        signinpage.checkPasswordTooShortErrorDisplayed();
    }

    @Then("User should get required error message")
    public void user_should_get_required_error_message() {
        signinpage.checkEmailPhoneNoRequiredErrorDisplayed();
    }

    @And("Click password field")
    public void click_password_field() {
        signinpage.clickPasswordField();
    }

    @When("Click email field")
    public void click_email_field() {
        signinpage.clickEmailField();
    }
}

