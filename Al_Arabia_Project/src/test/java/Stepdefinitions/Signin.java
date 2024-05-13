package Stepdefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Signinpage;
import resources.Base;

public class Signin extends Base {
	 private static Logger LOGGER =
			   LogManager.getLogger(Signin.class);
	public WebDriver driver;
	public WebDriverWait wait;

	public Signin(Testhooks testhooks) {
		this.driver = testhooks.getDriver();
		initializeWait();
		LOGGER = LogManager
				.getLogger(Signin.class.getName());
	}
	public void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@Given("User navigates to Login page")

	public void user_navigates_to_login_page() throws Exception {
		LOGGER.info(">> User got navigated to login page >>");
		System.out.println(">> User got navigated to login page");
	}

	@When("^User enters valid email address$")
	public void user_enters_valid_email_address() {
		Signinpage.email_field();
	}
	
	@When("^Enter invalid password without special character$")
	public void Enter_invalid_password_without_special_character() {
		Signinpage.INVpassword_withoutspl_character();
	}
	
	@And("^Enter invalid password with short char$")
	public void Enter_invalid_password_with_short_char() {
		Signinpage.INVpassword_short_character();
	}
	
	@When("^Enter valid password$")
	public void enter_valid_password() {
		Signinpage.password_field();
	}

	@When("Clicks on Sign in button")
	public void clicks_on_sign_in_button() {
		Signinpage.signinbutton();
	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {
		Signinpage.dashboard();
	}

	@Then("Al-Arabia dashboard should display successfully")
	public void Al_Arabia_dashboard_should_display_successfully() {
		Signinpage.dashboard();
	}

	@When("^User enters invalid email address$")
	public void user_enters_invalid_email_address() {
		Signinpage.INVemail_field();
	}

	@When("^Enter invalid password$")
	public void enter_invalid_password() {
		Signinpage.INVpassword_field();
	}
	
	@When("^Enter invalid password Password$")
	public void enter_invalid_password_Password() {
		Signinpage.INVpassword_withoutnumber_field();
	}
	
	@And("^Click password field eye icon$")
	public void Click_password_field_eye_icon() {
		Signinpage.password_field_eyeicon();
	}
	
	@Then("User should get a invalid email and password error message")
	public void User_should_get_a_invalid_email_and_password_error_message() {
		Signinpage.user_password_error();
	}

	@Then("User should get must contain one number error message")
	public void User_should_get_must_contain_one_number_error_message() {
		Signinpage.user_password_withoutNO_error();
	}

	@When("User dont enter any credentials")
	public void user_dont_enter_any_credentials() {
		System.out.println(">> User has not entered any inputs in the fields");
	}
	
	@Then("User should get must contain one special case character error message")
	public void User_should_get_must_contain_one_special_case_character_error_message () {
		Signinpage.must_contain_onespl_char_error();
	}
	
	@Then("User should get must contain one upper case character error message")
	public void User_should_get_must_contain_one_upper_case_character_error_message () {
		Signinpage.must_contain_oneuppercase_char_error();
	}
	
	@And("Enter invalid password without uppercase char")
	public void Enter_invalid_password_without_uppercase_char () {
		Signinpage.INVpassword_withoutupper_character();
	}
	
	@Then("User should get password is too short error message")
	public void User_should_get_password_is_too_short_error_message () {
		Signinpage.password_is_too_short_error();
	}
	
	@Then("User should get required error message")
	public void User_should_get_required_error_message() {
		Signinpage.emailphoneNo_required_error();
	}
	
	@And("Click password field")
	public void Click_password_field() {
		Signinpage.Clickpassword_field();
	}
	
	@When("Click email field")
	public void Click_email_field() {
		Signinpage.Clickemail_field();
	}

}
