package Stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Cleaningpage;
import pageobjects.Masterpage;
import pageobjects.Signinpage;
import resources.Base;

public class Master extends Base {

	private static Logger LOGGER = LogManager.getLogger(Cleaning.class);
	private WebDriver driver;
	private Masterpage masterpage;
	public Master(Testhooks testhooks) throws Exception {
		this.driver = testhooks.getDriver();
		this.masterpage = new Masterpage(driver);
		new Signinpage(driver);
		LOGGER = LogManager.getLogger(Cleaning.class.getName());
	}
	@And("Admin or user clicks the Master")
	public void Admin_or_user_clicks_the_Master() throws Exception {
		masterpage.Master_click();
	}
	@Then("Al Arabia Department page should display successfully")
	public void Al_Arabia_Department_page_should_display_successfully() throws Exception {
		masterpage.alldepartmentCount();
	}
	@And("User click on New Department button")
	public void User_click_on_New_Department_button() throws Exception {
		masterpage.New_Department_button_click();
	}
	@And("User Enter department name and clicks Add Department button")
	public void User_Enter_department_name_and_clicks_Add_Department_button() throws Exception {
		masterpage.Add_Department();
	}
	@Then("^Particular department gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_department_gets_created_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.department_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Created Department successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	private String normalizeWhitespace(String input) {
		return input.replaceAll("\\s+", " ").trim();
	}
	@And("Admin or user search the Department")
	public void Admin_or_user_search_the_Department() throws Exception {
		masterpage.Department_search_enter_text();
	}
	@Then("Searched Department details get displayed successfully")
	public void Searched_Department_details_get_displayed_successfully() {
		masterpage.DepartmentSearchedList();
	}
	@And("Admin or user sort the Department list recently updated")
	public void Admin_or_user_sort_the_Department_list_recently_updated() throws Exception {
		masterpage.Department_sort_recentlyupdated();
	}
	@Then("Recently updated Department list get displayed successfully")
	public void Recently_updated_Department_list_get_displayed_successfully() throws Exception {
		masterpage.Departmentlist();
	}
	@And("User sort the Department list Name A to Z")
	public void User_sort_the_Department_list_Name_A_to_Z() throws Exception {
		masterpage.Department_sortA_Z();
	}
	@Then("Department list get displayed successfully")
	public void Department_list_get_displayed_successfully() throws Exception {
		masterpage.Departmentlist();
	}
	@And("User sort the Department list Name Z to A")
	public void User_sort_the_Department_list_Name_Z_to_A() throws Exception {
		masterpage.Department_sortZ_A();
	}
	@Then("Department list Z to A get displayed successfully")
	public void Department_list_Z_to_A_get_displayed_successfully() throws Exception {
		masterpage.Departmentlist();
	}
	@And("User sort the Department list Recently Added")
	public void User_sort_the_Department_list_Recently_Added() throws Exception {
		masterpage.Department_sort_recentlyadded();
	}
	@Then("Recent Department list get displayed successfully")
	public void Recent_Department_list_get_displayed_successfully() throws Exception {
		masterpage.Departmentlist();
	}
	@And("User sort the Department list decending")
	public void User_sort_the_Department_list_Decending() throws Exception {
		masterpage.Department_DecendingDate();
	}
	@Then("Decending Department list get displayed successfully")
	public void Decending_Department_list_get_displayed_successfully() throws Exception {
		masterpage.Departmentlist();
	}
	@And("User click on kebab menu of Supplier")
	public void User_click_on_kebab_menu_of_Supplier() throws Exception {
		masterpage.kebabmenu();
	}
	@And("User selects Edit option of Supplier")
	public void User_selects_Edit_option_of_Supplier() throws Exception {
		//masterpage.kebabmenu();
		masterpage.selects_edit_department();
	}
	@And("User Updated Department")
	public void User_Updated_Department () throws Exception {
		masterpage.Updated_department();
	}
	@Then("^Particular department gets Edited successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_department_gets_Edited_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.department_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Edited Department successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User clicked Delete Department option")
	public void User_clicked_Delete_Department_option  () throws Exception {
		masterpage.selects_delete_department();
	}
	@Then("^Particular department gets Deleted successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_department_gets_Deleted_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.department_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Edited Department successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	//<------------------------------------Supplier---------------------------------------->

	@And("Admin or user clicks the Supplier")
	public void Admin_or_user_clicks_the_Supplier() throws Exception {
		masterpage.Supplier_click();
	}
	@Then("Al Arabia Supplier page should display successfully")
	public void Al_Arabia_Supplier_page_should_display_successfully() throws Exception {
		masterpage.allSupplierCount();
	}
	@And("User click on New Supplier button")
	public void User_click_on_New_Supplier_button() throws Exception {
		masterpage.New_Supplier_button_click();
	}
	@And("User Enter Mandatory fields of New Supplier page")
	public void User_Enter_Mandatory_fields_of_New_Supplier_page() throws Exception {
		masterpage.Enter_Mandatory_fields_Supplier();
	}
	@Then("^Particular Supplier gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Supplier_gets_created_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.Supplier_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Created Supplier successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
//	private String normalizeWhitespace(String input) {
//		return input.replaceAll("\\s+", " ").trim();
//	}
	@And("Admin or user search the Supplier")
	public void Admin_or_user_search_the_Supplier() throws Exception {
		masterpage.Supplier_search_enter_text();
	}
	@Then("Searched Supplier details get displayed successfully")
	public void Searched_Supplier_details_get_displayed_successfully() {
		masterpage.SupplierSearchedList();
	}
	@And("Admin or user sort the Supplier list recently updated")
	public void Admin_or_user_sort_the_Supplier_list_recently_updated() throws Exception {
		masterpage.Supplier_sort_recentlyupdated();
	}
	@Then("Recently updated Supplier list get displayed successfully")
	public void Recently_updated_Supplier_list_get_displayed_successfully() throws Exception {
		masterpage.Supplierlist();
	}
	@And("User sort the Supplier list Name A to Z")
	public void User_sort_the_Supplier_list_Name_A_to_Z() throws Exception {
		masterpage.Supplier_sortA_Z();
	}
	@Then("Supplier list get displayed successfully")
	public void Supplier_list_get_displayed_successfully() throws Exception {
		masterpage.Supplierlist();
	}
	@And("User sort the Supplier list Name Z to A")
	public void User_sort_the_Supplier_list_Name_Z_to_A() throws Exception {
		masterpage.Supplier_sortZ_A();
	}
	@Then("Supplier list Z to A get displayed successfully")
	public void Supplier_list_Z_to_A_get_displayed_successfully() throws Exception {
		masterpage.Supplierlist();
	}
	@And("User sort the Supplier list Recently Added")
	public void User_sort_the_Supplier_list_Recently_Added() throws Exception {
		masterpage.Supplier_sort_recentlyadded();
	}
	@Then("Recent Supplier list get displayed successfully")
	public void Recent_Supplier_list_get_displayed_successfully() throws Exception {
		masterpage.Supplierlist();
	}
	@And("User sort the Supplier list decending")
	public void User_sort_the_Supplier_list_Decending() throws Exception {
		masterpage.Supplier_DecendingDate();
	}
	@Then("Decending Supplier list get displayed successfully")
	public void Decending_Supplier_list_get_displayed_successfully() throws Exception {
		masterpage.Supplierlist();
	}
	@And("User click on kebab menu")
	public void User_click_on_kebab_menu() throws Exception {
		masterpage.kebabmenu();
	}
	@And("User selects Edit option")
	public void User_selects_Edit_option() throws Exception {
		//masterpage.kebabmenu();
		masterpage.selects_edit_Supplier();
	}
	@And("User Updated Supplier")
	public void User_Updated_Supplier () throws Exception {
	//	masterpage.Updated_Supplier();
	}
	@Then("^Particular Supplier gets Edited successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Supplier_gets_Edited_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.Supplier_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Edited Supplier successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User clicked Delete Supplier option")
	public void User_clicked_Delete_Supplier_option  () throws Exception {
		//masterpage.selects_delete_Supplier();
	}
	@Then("^Particular Supplier gets Deleted successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Supplier_gets_Deleted_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.Supplier_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Edited Supplier successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
}
