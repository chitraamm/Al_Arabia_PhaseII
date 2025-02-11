package Stepdefinitions;

import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Forgotpasswordpage;
import resources.Base;

public class Forgotpassword extends Base {
	private WebDriver driver;
	private Forgotpasswordpage forgotPasswordPage;

	public Forgotpassword(Testhooks testhooks) {
		this.driver = testhooks.getDriver(); 
		this.forgotPasswordPage = new Forgotpasswordpage(driver);
	}

	@When("User clicks forgot password option")
	public void user_clicks_forgot_password_option() {
		forgotPasswordPage.clickForgotPasswordLink();
	}

	@When("^User enters forgot password valid email address$")
	public void user_enters_forgot_password_valid_email_address() {
		forgotPasswordPage.enterValidEmail();
	}

	@When("User clicks Send Reset link button")
	public void user_clicks_send_reset_link_button() {
		forgotPasswordPage.clickSendResetLink();
	}

	@Then("Proper confirmation email message should receive to user mail")
	public void proper_confirmation_email_message_should_receive_to_user_mail() {
		System.out.println(">> User got a reset password link mail");
	}

	@When("^User enters forgot password invalid email address$")
	public void user_enters_forgot_password_invalid_email_address() {
		forgotPasswordPage.enterInvalidEmail();
		forgotPasswordPage.clickEnglishLink();
	}

	@Then("User should get a email address or phone number is required error message")
	public void User_should_get_a_email_address_or_phone_number_is_required_error_message() {
		forgotPasswordPage.isRequiredErrorDisplayed();
	}

	@Then("User should get a invalid email address error message in forgotpassword page")
	public void user_should_get_a_invalid_email_address_error_message_in_forgotpassword_page() {
		forgotPasswordPage.isInvalidEmailErrorDisplayed();
	}

	@And("User enters forgot password invalid email address and delete")
	public void User_enters_forgot_password_invalid_email_address_and_delete() {
		forgotPasswordPage.deleteInvalidEmail();
		forgotPasswordPage.clickEnglishLink();
	}
}
