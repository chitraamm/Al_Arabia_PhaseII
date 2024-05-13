package Stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Forgotpasswordpage;
import resources.Base;

public class Forgotpassword extends Base {
	public WebDriver driver;
	public WebDriverWait wait;

	public Forgotpassword(Testhooks testhooks) {
		this.driver = testhooks.getDriver();
		initializeWait();
	}
	public void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("User clicks forgot password option")
	public void user_clicks_forgot_password_option() {
		Forgotpasswordpage.forgot_click();
	}

	@When("^User enters forgot password valid email address$")
	public void user_enters_forgot_password_valid_email_address() {
		Forgotpasswordpage.email_field();
	}

	@When("User clicks Send Reset link button")
	public void user_clicks_send_reset_link_button() {
		Forgotpasswordpage.send_resetlink();
	}

	@Then("Proper confirmation email message should receive to user mail")
	public void proper_confirmation_email_message_should_receive_to_user_mail() {
		System.out.println(">> User got a reset password link mail");
	}

	@When("^User enters forgot password invalid email address$")
	public void user_enters_forgot_password_invalid_email_address() {
		Forgotpasswordpage.invalid_email();
		Forgotpasswordpage.click_english();
	}

	@Then("User should get a email address or phone number is required error message")
	public void User_should_get_a_email_address_or_phone_number_is_required_error_message() {
		Forgotpasswordpage.required_error();
	}

	@Then("User should get a invalid email address error message in forgotpassword page")
	public void user_should_get_a_invalid_email_address_error_message_in_forgotpassword_page() {
		Forgotpasswordpage.invalid_email_error();
	}
	
	@And("User enters forgot password invalid email address and delete")
	public void User_enters_forgot_password_invalid_email_address_and_delete() {
		Forgotpasswordpage.invalid_email_delete();
		Forgotpasswordpage.click_english();
	}
}
