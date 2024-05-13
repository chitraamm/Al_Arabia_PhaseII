package Stepdefinitions;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hooks.Testhooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Memberspage;
import pageobjects.Signinpage;
import resources.Base;

public class Members extends Base {

	private static Logger LOGGER = LogManager.getLogger(Members.class);
	public WebDriver driver;
	public WebDriverWait wait;

	public Members(Testhooks testhooks) {
		this.driver = testhooks.getDriver();
		initializeWait();
		LOGGER = LogManager.getLogger(Members.class.getName());
	}
	public void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Given("Admin logged in with valid credentials")
	public void Admin_logged_in_with_valid_credentials() throws Exception {
		Signinpage.email_field();
		Signinpage.password_field();
		Signinpage.signinbutton();
		LOGGER.info(">> Admin/User got logged in >>");
	}
	
	@And("User clicks the members module")
	public void User_clicks_the_members_module() throws Exception {
		Memberspage.members_click();
	}
	
	@And("User clicks the invite member button")
	public void User_clicks_the_invite_member_button() throws Exception {
		Memberspage.Invite_member_btn();
	}
	
	@And("User enters the email or phone number")
	public void User_enters_the_email_or_phone_number() throws Exception {
		Memberspage.invite_email_phonenumber_field();
	}
	
	@And("User selects the role manager")
	public void User_selects_the_role_manager() throws Exception {
		Memberspage.Invite_select_role();
	}
	
	@And("User selects the department electrical")
	public void User_selects_the_department_electrical() throws Exception {
		Memberspage.Invite_select_dept();
	}
	
	@And("User clicks the send invite button")
	public void User_clicks_the_send_invite_button() throws Exception {
		Memberspage.Invite_send_invite();
	}
	
	@Then("The invitation should sent to user given mail address successfully")
	public void The_invitation_should_sent_to_user_given_mail_address_successfully() throws Exception {
		System.out.println(
				">> User got the invitation mail successfully >>");
		LOGGER.info(">> User got the invitation mail successfully >>");
	}
	
	@When("Al-Arabia overall dashboard should display")
	public void Al_Arabia_overall_dashboard_should_display() throws Exception {
		Memberspage.dashboard_text();
	}
	
	@Then("Al-Arabia members dashboard should display successfully")
	public void Al_Arabia_members_dashboard_should_display_successfully() throws Exception {
		Memberspage.All_members_count();
		LOGGER.info(">> Admin/user got the members dashboard page >>");
	}

	@When("User enters below detail into the fields")
	public void User_enters_below_detail_into_the_fields(DataTable dataTable)
			throws Exception {
		Memberspage.common_signup_steps(dataTable);
	}

	@And("User clicks on agree terms and condition checkbox")
	public void user_clicks_on_agree_terms_and_condition_checkbox() {
		Memberspage.termsandcondition();
	}

	@And("Clicks on Sign up button")
	public void clicks_on_sign_up_button() {
		Memberspage.signupbutton();
	}

	@Then("Jofin login page should display successfully")
	public void jofin_login_page_should_display_successfully() {
		Memberspage.loginpage();
	}

	@Then("User should get a invalid email address error message")
	public void user_should_get_a_invalid_email_address_error_message() {
		Memberspage.invalid_email_error();
	}

	@When("User dont clicks the agree terms and condition checkbox")
	public void user_dont_clicks_the_agree_terms_and_condition_checkbox() {
		System.out.println(
				">> User has not clicked terms and condition checkbox");
	}

	@Then("User should get a Please accept terms and condition error message")
	public void user_should_get_a_please_accept_terms_and_condition_error_message() {
		Memberspage.accept_termsandcondition_error();
	}

	@Then("User should get a Email already exist error message")
	public void user_should_get_a_email_already_exist_error_message() {
		Memberspage.email_already_exist_error();
	}

	@When("User dont enter any inputs")
	public void user_dont_enter_any_inputs() {
		System.out.println(">> User has not entered any inputs");
	}

	@Then("User should get required fields error messages")
	public void User_should_get_required_fields_error_messages() {
		Memberspage.required_error();
	}

	@Then("User should get must contain one number error message in signup page")
	public void User_should_get_must_contain_one_number_error_message_in_signup_page() {
		Memberspage.contain_onenumber_error();
	}

}
