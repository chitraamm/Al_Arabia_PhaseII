package Stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Cleaningpage;
import pageobjects.Signinpage;
import resources.Base;

public class Cleaning extends Base {

	private static Logger LOGGER = LogManager.getLogger(Cleaning.class);
	private WebDriver driver;
	private Cleaningpage cleaningpage;
	public Cleaning(Testhooks testhooks) throws Exception {
		this.driver = testhooks.getDriver();
		this.cleaningpage = new Cleaningpage(driver);
		new Signinpage(driver);
		LOGGER = LogManager.getLogger(Master.class.getName());
	}
	@And("Admin or user clicks the Cleaning module")
	public void Admin_or_user_clicks_the_Cleaning_module() throws Exception {
		cleaningpage.Cleaning_click();
	}
	@Then("Al-Arabia Cleaning page should display successfully")
	public void Al_Arabia_Cleaning_page_should_display_successfully() throws Exception {
		cleaningpage.AllcleaningCount();
		LOGGER.info(">> Admin/user got the Cleaning page >>");
	}
	@And("Admin or user clicks the New Group button")
	public void Admin_or_user_clicks_New_Group_button () throws Exception {
		cleaningpage.New_Group_button();
	}
	@And("Admin or user enters the all mandatory fields of New Group")
	public void Admin_or_user_enters_the_all_mandatory_fields_of_New_Group () throws Exception {
		cleaningpage.Mandatory_fields_enter_new_cleaning();
	}
	@And("Admin or user clicks the Create Group button")
	public void Admin_or_user_clicks_Create_Group_Add_button () throws Exception {
		cleaningpage.Create_group_button();
	}
	@Then("^Particular Group gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Group_gets_created_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = cleaningpage.cleaning_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin got the cleaning created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	private String normalizeWhitespace(String input) {
		return input.replaceAll("\\s+", " ").trim();
	}
	@And("Admin or user search the Cleaning")
	public void Admin_or_user_search_the_Cleaning() throws Exception {
		cleaningpage.Cleaning_search_enter_text();
	}

	@Then("Searched Cleaning details get displayed successfully")
	public void Searched_Cleaning_details_get_displayed_successfully() {
		cleaningpage.CleaningSearchedList();
	}
	@And("Admin or user sort the Cleaning list recently updated")
	public void Admin_or_user_sort_the_Cleaning_list_recently_updated() throws Exception {
		cleaningpage.Cleaning_sort_recentlyupdated();
	}

	@Then("Recently updated Cleaning list get displayed successfully")
	public void Recently_updated_Cleaning_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaninglist();
	}

	@And("User sort the Cleaning list Name A to Z")
	public void User_sort_the_Cleaning_list_Name_A_to_Z() throws Exception {
		cleaningpage.Cleaning_sortZ_A();
	}

	@Then("Cleaning list get displayed successfully")
	public void Cleaning_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaninglist();
	}

	@And("User sort the Cleaning list Name Z to A")
	public void User_sort_the_Cleaning_list_Name_Z_to_A() throws Exception {
		cleaningpage.Cleaning_sortZ_A();
	}

	@Then("Cleaning list Z to A get displayed successfully")
	public void Cleaning_list_Z_to_A_get_displayed_successfully() throws Exception {
		cleaningpage.cleanicleanilist();
	}

	@And("User sort the Cleaning list Recently Added")
	public void User_sort_the_Cleaning_list_Recently_Added() throws Exception {
		cleaningpage.Cleaning_sort_recentlyadded();
	}

	@Then("Recent Cleaning list get displayed successfully")
	public void Recent_Cleaning_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaninglist();
	}
	@And("User sort the Cleaning list decending")
	public void User_sort_the_Cleaning_list_Decending() throws Exception {
		cleaningpage.Cleaning_DecendingDate();
	}

	@Then("Decending Cleaning list get displayed successfully")
	public void Decending_Cleaning_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaninglist();
	}
}