package Stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Profilepage;
import pageobjects.Signinpage;
import resources.Base;

public class Profile extends Base {

	private Logger LOGGER = LogManager.getLogger(Profile.class); 
	private WebDriver driver;
	private Signinpage signinpage;
	private Profilepage profilepage;

	public Profile(Testhooks testhooks) throws Exception {
		this.driver = testhooks.getDriver();
		this.signinpage = new Signinpage(driver);
		this.profilepage = new Profilepage(driver);
		LOGGER = LogManager.getLogger(Profile.class.getName());
	}

	@When("User able to click on profile")
	public void user_able_to_click_on_profile() {
		profilepage.Profile();
	}

	@When("User able to click on personal profile")
	public void user_able_to_click_on_personal_profile() {
		profilepage.Personalprofile();
	}

//	@Then("Personal profile should be displaying")
//	public void personal_profile_should_be_displaying() {
//		profilepage.personalinfo_display();
//	}

	@And("User entered personal informations")
	public void User_entered_personal_informations() throws Exception {
		profilepage.personalinfo_text_enter();
	}
	@And("User able to give personal profile information")
	public void user_able_to_give_personal_profile_information() throws Exception {
		profilepage.Personalinfo_details();
	}
	@And("User able to click on update personal profile")
	public void user_able_to_click_on_update_personal_profile()throws Exception {
		profilepage.personalinfo_Updatebutton_text_enter();
	}
	@When("User able to select yes option for saving deatils")
	public void user_able_to_select_yes_option_for_saving_deatils() throws Exception{
		profilepage.Yesbutton();
	}

	@When("User able to click on reset form personal profile")
	public void user_able_to_click_on_reset_form_personal_profile() throws Exception{
		profilepage.Resetform();
	}

	@Then("User able to select yes option for reset the details")
	public void user_able_to_select_yes_option_for_reset_the_details() {
		profilepage.YesResetform();
	}

	@Then("User able to select no option for reset the details")
	public void user_able_to_select_no_option_for_reset_the_details() {
		profilepage.NoResetform();
	}

	@Then("User able to select no option for saving deatils")
	public void user_able_to_select_no_option_for_saving_deatils() {
		profilepage.Noupdate();
	}
	@Then("IQAMA is required error message get displayed successfully")
	public void IQAMA_is_required_error_message_get_displayed_successfully() {
		profilepage.nameerror();
		profilepage.IQMAerror_display();
	}
	@Then("Location is required error message get displayed successfully")
	public void Location_is_required_errror_message_get_displayed_successfully() {
		profilepage.locationerror();
		profilepage.locationerror_display();
	}
	@Then("^User Updated the profile details successfully as\"([^\"]*)\"$")
	public void User_Updated_the_profile_details_successfully_as(String expectedMessage) {
		String actualMessage = profilepage.profile_success_display();
		String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin got the members profile updation success message successfully");
		assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}

	private String normalizeWhitespace(String input) {
		return input.replaceAll("\\s+", " ").trim();
	}

	@When("Admin or User update the  profile page")
	public void admin_or_user_update_the_profile_page() {

	}

}