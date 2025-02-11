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
	@And("User click on Add Supplier button")
	public void User_click_on_Add_Supplier_button() throws Exception {
		masterpage.Add_Supplier();
	}
	@Then("^Particular Supplier gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Supplier_gets_created_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.Supplier_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Created Supplier successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
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
		masterpage.A_Z_Supplier_sort();
	}
	@Then("Supplier list get displayed successfully")
	public void Supplier_list_get_displayed_successfully() throws Exception {
		masterpage.Supplierlist();
	}
	@And("User sort the Supplier list Name Z to A")
	public void User_sort_the_Supplier_list_Name_Z_to_A() throws Exception {
		masterpage.recent_sortZ_A();
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
		masterpage.Updated_Supplier();
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
		masterpage.selects_delete_Supplier();
		masterpage.Supplier_delete_confirm();

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
	@And("User clicked View Supplier option")
	public void User_clicked_View_Supplier_option() throws Exception {
		masterpage.selects_view_Supplier();
	}
	@And("Supplier page will be displayed to the user")
	public void Supplier_page_will_be_displayed_to_the_user() throws Exception {
		masterpage.Supplier_viewpagedisplay();
	}
	//<------------------------------------Stock---------------------------------------->
	
	@And("Admin or user clicks the Stock")
	public void Admin_or_user_clicks_the_Stock() throws Exception {
		masterpage.Stock_click();
	}
	@Then("Al Arabia Stock page should display successfully")
	public void Al_Arabia_Stock_page_should_display_successfully() throws Exception {
		masterpage.allStockCount();
	}
	@And("User click on New Stock button")
	public void User_click_on_New_Stock_button() throws Exception {
		masterpage.New_Stock_button_click();
	}
	@And("User Enter Mandatory fields of New Stock page")
	public void User_Enter_Mandatory_fields_of_New_Stock_page() throws Exception {
		masterpage.Enter_Mandatory_fields_Stock();
	}
	@And("User click on Add Stock button")
	public void User_click_on_Add_Stock_button() throws Exception {
		masterpage.Add_Stock();
	}
	@Then("^Particular Stock gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Stock_gets_created_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.Stock_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Created Stock successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("Admin or user search the Stock")
	public void Admin_or_user_search_the_Stock() throws Exception {
		masterpage.Stock_search_enter_text();
	}
	@Then("Searched Stock details get displayed successfully")
	public void Searched_Stock_details_get_displayed_successfully() {
		masterpage.StockSearchedList();
	}
	@And("Admin or user sort the Stock list recently updated")
	public void Admin_or_user_sort_the_Stock_list_recently_updated() throws Exception {
		masterpage.Stock_sort_recentlyupdated();
	}
	@Then("Recently updated Stock list get displayed successfully")
	public void Recently_updated_Stock_list_get_displayed_successfully() throws Exception {
		masterpage.Stocklist();
	}
	@And("User sort the Stock list Name A to Z")
	public void User_sort_the_Stock_list_Name_A_to_Z() throws Exception {
		masterpage.A_Z_Stock_sort();
	}
	@Then("Stock list get displayed successfully")
	public void Stock_list_get_displayed_successfully() throws Exception {
		masterpage.Stocklist();
	}
	@And("User sort the Stock list Name Z to A")
	public void User_sort_the_Stock_list_Name_Z_to_A() throws Exception {
		masterpage.Stock_recent_sortZ_A();
	}
	@Then("Stock list Z to A get displayed successfully")
	public void Stock_list_Z_to_A_get_displayed_successfully() throws Exception {
		masterpage.Stocklist();
	}
	@And("User sort the Stock list Recently Added")
	public void User_sort_the_Stock_list_Recently_Added() throws Exception {
		masterpage.Stock_sort_recentlyadded();
	}
	@Then("Recent Stock list get displayed successfully")
	public void Recent_Stock_list_get_displayed_successfully() throws Exception {
		masterpage.Stocklist();
	}
	@And("User sort the Stock list decending")
	public void User_sort_the_Stock_list_Decending() throws Exception {
		masterpage.Stock_DecendingDate();
	}
	@Then("Decending Stock list get displayed successfully")
	public void Decending_Stock_list_get_displayed_successfully() throws Exception {
		masterpage.Stocklist();
	}
	@And("User click on kebab menu of Stock")
	public void User_click_on_kebab_menu_of_Stock() throws Exception {
		masterpage.kebabmenu_stock();
	}
	@And("User selects Edit option of Stock")
	public void User_selects_Edit_option_of_Stock() throws Exception {
		//masterpage.kebabmenu();
		masterpage.selects_edit_Stock();
	}
	@And("User Updated Stock")
	public void User_Updated_Stock () throws Exception {
		masterpage.Updated_Stock();
	}
	@Then("^Particular Stock gets Edited successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Stock_gets_Edited_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.Stock_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Edited Stock successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User clicked View Stock option")
	public void User_clicked_View_Stock_option() throws Exception {
		masterpage.selects_view_Stock();
	}
	@And("Stock page will be displayed to the user")
	public void Stock_page_will_be_displayed_to_the_user() throws Exception {
		masterpage.Stock_viewpagedisplay();
	}
	//<----------------------------------------TicketTitle------------------------------------------->
	
	@And("User clicks TicketTitle")
	public void User_clicks_the_TicketTitle() throws Exception {
		masterpage.TicketTitle_click();
	}
	@Then("Al Arabia TicketTitle page should display successfully")
	public void Al_Arabia_TicketTitle_page_should_display_successfully() throws Exception {
		masterpage.allTicketTitleCount();
	}
	@And("User click on New TicketTitle button")
	public void User_click_on_New_TicketTitle_button() throws Exception {
		masterpage.New_TicketTitle_button_click();
	}
	@And("User Enter TicketTitle name and clicks Add TicketTitle button")
	public void User_Enter_TicketTitle_name_and_clicks_Add_TicketTitle_button() throws Exception {
		masterpage.Add_TicketTitle();
	}
	@Then("^Particular TicketTitle gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_TicketTitle_gets_created_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.TicketTitle_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Created TicketTitle successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("Admin or user search the TicketTitle")
	public void Admin_or_user_search_the_TicketTitle() throws Exception {
		masterpage.TicketTitle_search_enter_text();
	}
	@Then("Searched TicketTitle details get displayed successfully")
	public void Searched_TicketTitle_details_get_displayed_successfully() {
		masterpage.TicketTitleSearchedList();
	}
	@And("Admin or user sort the TicketTitle list recently updated")
	public void Admin_or_user_sort_the_TicketTitle_list_recently_updated() throws Exception {
		masterpage.TicketTitle_sort_recentlyupdated();
	}
	@Then("Recently updated TicketTitle list get displayed successfully")
	public void Recently_updated_TicketTitle_list_get_displayed_successfully() throws Exception {
		masterpage.TicketTitlelist();
	}
	@And("User sort the TicketTitle list Name A to Z")
	public void User_sort_the_TicketTitle_list_Name_A_to_Z() throws Exception {
		masterpage.TicketTitle_sortA_Z();
	}
	@Then("TicketTitle list get displayed successfully")
	public void TicketTitle_list_get_displayed_successfully() throws Exception {
		masterpage.TicketTitlelist();
	}
	@And("User sort the TicketTitle list Name Z to A")
	public void User_sort_the_TicketTitle_list_Name_Z_to_A() throws Exception {
		masterpage.TicketTitle_sortZ_A();
	}
	@Then("TicketTitle list Z to A get displayed successfully")
	public void TicketTitle_list_Z_to_A_get_displayed_successfully() throws Exception {
		masterpage.TicketTitlelist();
	}
	@And("User sort the TicketTitle list Recently Added")
	public void User_sort_the_TicketTitle_list_Recently_Added() throws Exception {
		masterpage.TicketTitle_sort_recentlyadded();
	}
	@Then("Recent TicketTitle list get displayed successfully")
	public void Recent_TicketTitle_list_get_displayed_successfully() throws Exception {
		masterpage.TicketTitlelist();
	}
	@And("User sort the TicketTitle list decending")
	public void User_sort_the_TicketTitle_list_Decending() throws Exception {
		masterpage.TicketTitle_DecendingDate();
	}
	@Then("Decending TicketTitle list get displayed successfully")
	public void Decending_TicketTitle_list_get_displayed_successfully() throws Exception {
		masterpage.TicketTitlelist();
	}
	@And("User click on kebab menu of TicketTitle")
	public void User_click_on_kebab_menu_of_TicketTitle() throws Exception {
		masterpage.kebabmenu_TicketTitle();
	}
	@And("User selects Edit option of TicketTitle")
	public void User_selects_Edit_option_of_TicketTitle() throws Exception {
		//masterpage.kebabmenu();
		masterpage.selects_edit_TicketTitle();
	}
	@And("User Updated TicketTitle")
	public void User_Updated_TicketTitle () throws Exception {
		masterpage.Updated_TicketTitle();
	}
	@Then("^Particular TicketTitle gets Edited successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_TicketTitle_gets_Edited_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.TicketTitle_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Edited TicketTitle successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User clicked Delete TicketTitle option")
	public void User_clicked_Delete_TicketTitle_option  () throws Exception {
		masterpage.selects_delete_TicketTitle();
	}
	@Then("^Particular TicketTitle gets Deleted successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_TicketTitle_gets_Deleted_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.TicketTitle_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Edited TicketTitle successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	
	//<----------------------------------------ScreenResolution------------------------------------------->
	
	@And("User clicks ScreenResolution")
	public void User_clicks_ScreenResolution() throws Exception {
		masterpage.ScreenResolution_click();
	}
	@Then("Al Arabia ScreenResolution page should display successfully")
	public void Al_Arabia_ScreenResolution_page_should_display_successfully() throws Exception {
		masterpage.allScreenResolutionCount();
	}
	@And("User click on New ScreenResolution button")
	public void User_click_on_New_ScreenResolution_button() throws Exception {
		masterpage.New_ScreenResolution_button_click();
	}
	@And("User Enter ScreenResolution name and clicks Add ScreenResolution button")
	public void User_Enter_ScreenResolution_name_and_clicks_Add_ScreenResolution_button() throws Exception {
		masterpage.Add_ScreenResolution();
	}
	@Then("^Particular ScreenResolution gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_ScreenResolution_gets_created_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.ScreenResolution_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Created ScreenResolution successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("Admin or user search the ScreenResolution")
	public void Admin_or_user_search_the_ScreenResolution() throws Exception {
		masterpage.ScreenResolution_search_enter_text();
	}
	@Then("Searched ScreenResolution details get displayed successfully")
	public void Searched_ScreenResolution_details_get_displayed_successfully() {
		masterpage.ScreenResolutionSearchedList();
	}
	@And("Admin or user sort the ScreenResolution list recently updated")
	public void Admin_or_user_sort_the_ScreenResolution_list_recently_updated() throws Exception {
		masterpage.ScreenResolution_sort_recentlyupdated();
	}
	@Then("Recently updated ScreenResolution list get displayed successfully")
	public void Recently_updated_ScreenResolution_list_get_displayed_successfully() throws Exception {
		masterpage.ScreenResolutionlist();
	}
	@And("User sort the ScreenResolution list Name A to Z")
	public void User_sort_the_ScreenResolution_list_Name_A_to_Z() throws Exception {
		masterpage.ScreenResolution_sortA_Z();
	}
	@Then("ScreenResolution list get displayed successfully")
	public void ScreenResolution_list_get_displayed_successfully() throws Exception {
		masterpage.ScreenResolutionlist();
	}
	@And("User sort the ScreenResolution list Name Z to A")
	public void User_sort_the_ScreenResolution_list_Name_Z_to_A() throws Exception {
		masterpage.ScreenResolution_sortZ_A();
	}
	@Then("ScreenResolution list Z to A get displayed successfully")
	public void ScreenResolution_list_Z_to_A_get_displayed_successfully() throws Exception {
		masterpage.ScreenResolutionlist();
	}
	@And("User sort the ScreenResolution list Recently Added")
	public void User_sort_the_ScreenResolution_list_Recently_Added() throws Exception {
		masterpage.ScreenResolution_sort_recentlyadded();
	}
	@Then("Recent ScreenResolution list get displayed successfully")
	public void Recent_ScreenResolution_list_get_displayed_successfully() throws Exception {
		masterpage.ScreenResolutionlist();
	}
	@And("User sort the ScreenResolution list decending")
	public void User_sort_the_ScreenResolution_list_Decending() throws Exception {
		masterpage.ScreenResolution_DecendingDate();
	}
	@Then("Decending ScreenResolution list get displayed successfully")
	public void Decending_ScreenResolution_list_get_displayed_successfully() throws Exception {
		masterpage.ScreenResolutionlist();
	}
	@And("User click on kebab menu of ScreenResolution")
	public void User_click_on_kebab_menu_of_ScreenResolution() throws Exception {
		masterpage.kebabmenu_ScreenResolution();
	}
	@And("User selects Edit option of ScreenResolution")
	public void User_selects_Edit_option_of_ScreenResolution() throws Exception {
		//masterpage.kebabmenu();
		masterpage.selects_edit_ScreenResolution();
	}
	@And("User Updated ScreenResolution")
	public void User_Updated_ScreenResolution () throws Exception {
		masterpage.Updated_ScreenResolution();
	}
	@Then("^Particular ScreenResolution gets Edited successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_ScreenResolution_gets_Edited_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.ScreenResolution_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Edited ScreenResolution successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User clicked Delete ScreenResolution option")
	public void User_clicked_Delete_ScreenResolution_option  () throws Exception {
		masterpage.selects_delete_ScreenResolution();
	}
	@Then("^Particular ScreenResolution gets Deleted successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_ScreenResolution_gets_Deleted_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.ScreenResolution_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Edited ScreenResolution successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	//<----------------------------------------ScreenPixel------------------------------------------->
	
	@And("User clicks ScreenPixel")
	public void User_clicks_ScreenPixel() throws Exception {
		masterpage.ScreenPixel_click();
	}
	@Then("Al Arabia ScreenPixel page should display successfully")
	public void Al_Arabia_ScreenPixel_page_should_display_successfully() throws Exception {
		masterpage.allScreenPixelCount();
	}
	@And("User click on New ScreenPixel button")
	public void User_click_on_New_ScreenPixel_button() throws Exception {
		masterpage.New_ScreenPixel_button_click();
	}
	@And("User Enter ScreenPixel name and clicks Add ScreenPixel button")
	public void User_Enter_ScreenPixel_name_and_clicks_Add_ScreenPixel_button() throws Exception {
		masterpage.Add_ScreenPixel();
	}
	@Then("^Particular ScreenPixel gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_ScreenPixel_gets_created_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.ScreenPixel_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Created ScreenPixel successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("Admin or user search the ScreenPixel")
	public void Admin_or_user_search_the_ScreenPixel() throws Exception {
		masterpage.ScreenPixel_search_enter_text();
	}
	@Then("Searched ScreenPixel details get displayed successfully")
	public void Searched_ScreenPixel_details_get_displayed_successfully() {
		masterpage.ScreenPixelSearchedList();
	}
	@And("Admin or user sort the ScreenPixel list recently updated")
	public void Admin_or_user_sort_the_ScreenPixel_list_recently_updated() throws Exception {
		masterpage.ScreenPixel_sort_recentlyupdated();
	}
	@Then("Recently updated ScreenPixel list get displayed successfully")
	public void Recently_updated_ScreenPixel_list_get_displayed_successfully() throws Exception {
		masterpage.ScreenPixellist();
	}
	@And("User sort the ScreenPixel list Name A to Z")
	public void User_sort_the_ScreenPixel_list_Name_A_to_Z() throws Exception {
		masterpage.ScreenPixel_sortA_Z();
	}
	@Then("ScreenPixel list get displayed successfully")
	public void ScreenPixel_list_get_displayed_successfully() throws Exception {
		masterpage.ScreenPixellist();
	}
	@And("User sort the ScreenPixel list Name Z to A")
	public void User_sort_the_ScreenPixel_list_Name_Z_to_A() throws Exception {
		masterpage.ScreenPixel_sortZ_A();
	}
	@Then("ScreenPixel list Z to A get displayed successfully")
	public void ScreenPixel_list_Z_to_A_get_displayed_successfully() throws Exception {
		masterpage.ScreenPixellist();
	}
	@And("User sort the ScreenPixel list Recently Added")
	public void User_sort_the_ScreenPixel_list_Recently_Added() throws Exception {
		masterpage.ScreenPixel_sort_recentlyadded();
	}
	@Then("Recent ScreenPixel list get displayed successfully")
	public void Recent_ScreenPixel_list_get_displayed_successfully() throws Exception {
		masterpage.ScreenPixellist();
	}
	@And("User sort the ScreenPixel list decending")
	public void User_sort_the_ScreenPixel_list_Decending() throws Exception {
		masterpage.ScreenPixel_DecendingDate();
	}
	@Then("Decending ScreenPixel list get displayed successfully")
	public void Decending_ScreenPixel_list_get_displayed_successfully() throws Exception {
		masterpage.ScreenPixellist();
	}
	@And("User click on kebab menu of ScreenPixel")
	public void User_click_on_kebab_menu_of_ScreenPixel() throws Exception {
		masterpage.kebabmenu_ScreenPixel();
	}
	@And("User selects Edit option of ScreenPixel")
	public void User_selects_Edit_option_of_ScreenPixel() throws Exception {
		//masterpage.kebabmenu();
		masterpage.selects_edit_ScreenPixel();
	}
	@And("User Updated ScreenPixel")
	public void User_Updated_ScreenPixel () throws Exception {
		masterpage.Updated_ScreenPixel();
	}
	@Then("^Particular ScreenPixel gets Edited successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_ScreenPixel_gets_Edited_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.ScreenPixel_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Edited ScreenPixel successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User clicked Delete ScreenPixel option")
	public void User_clicked_Delete_ScreenPixel_option  () throws Exception {
		masterpage.selects_delete_ScreenPixel();
	}
	@Then("^Particular ScreenPixel gets Deleted successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_ScreenPixel_gets_Deleted_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.ScreenPixel_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Edited ScreenPixel successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	
	//<----------------------------------------BillBoardType------------------------------------------->
	
	@And("User clicks BillBoardType")
	public void User_clicks_the_BillBoardType() throws Exception {
		masterpage.BillBoardType_click();
	}
	@Then("Al Arabia BillBoardType page should display successfully")
	public void Al_Arabia_BillBoardType_page_should_display_successfully() throws Exception {
		masterpage.allBillBoardTypeCount();
	}
	@And("User click on New BillBoardType button")
	public void User_click_on_New_BillBoardType_button() throws Exception {
		masterpage.New_BillBoardType_button_click();
	}
	@And("User Enter BillBoardType name and clicks Add BillBoardType button")
	public void User_Enter_BillBoardType_name_and_clicks_Add_BillBoardType_button() throws Exception {
		masterpage.Add_BillBoardType();
	}
	@Then("^Particular BillBoardType gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_BillBoardType_gets_created_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.BillBoardType_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Created BillBoardType successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("Admin or user search the BillBoardType")
	public void Admin_or_user_search_the_BillBoardType() throws Exception {
		masterpage.BillBoardType_search_enter_text();
	}
	@Then("Searched BillBoardType details get displayed successfully")
	public void Searched_BillBoardType_details_get_displayed_successfully() {
		masterpage.BillBoardTypeSearchedList();
	}
	@And("Admin or user sort the BillBoardType list recently updated")
	public void Admin_or_user_sort_the_BillBoardType_list_recently_updated() throws Exception {
		masterpage.BillBoardType_sort_recentlyupdated();
	}
	@Then("Recently updated BillBoardType list get displayed successfully")
	public void Recently_updated_BillBoardType_list_get_displayed_successfully() throws Exception {
		masterpage.BillBoardTypelist();
	}
	@And("User sort the BillBoardType list Name A to Z")
	public void User_sort_the_BillBoardType_list_Name_A_to_Z() throws Exception {
		masterpage.BillBoardType_sortA_Z();
	}
	@Then("BillBoardType list get displayed successfully")
	public void BillBoardType_list_get_displayed_successfully() throws Exception {
		masterpage.BillBoardTypelist();
	}
	@And("User sort the BillBoardType list Name Z to A")
	public void User_sort_the_BillBoardType_list_Name_Z_to_A() throws Exception {
		masterpage.BillBoardType_sortZ_A();
	}
	@Then("BillBoardType list Z to A get displayed successfully")
	public void BillBoardType_list_Z_to_A_get_displayed_successfully() throws Exception {
		masterpage.BillBoardTypelist();
	}
	@And("User sort the BillBoardType list Recently Added")
	public void User_sort_the_BillBoardType_list_Recently_Added() throws Exception {
		masterpage.BillBoardType_sort_recentlyadded();
	}
	@Then("Recent BillBoardType list get displayed successfully")
	public void Recent_BillBoardType_list_get_displayed_successfully() throws Exception {
		masterpage.BillBoardTypelist();
	}
	@And("User sort the BillBoardType list decending")
	public void User_sort_the_BillBoardType_list_Decending() throws Exception {
		masterpage.BillBoardType_DecendingDate();
	}
	@Then("Decending BillBoardType list get displayed successfully")
	public void Decending_BillBoardType_list_get_displayed_successfully() throws Exception {
		masterpage.BillBoardTypelist();
	}
	@And("User click on kebab menu of BillBoardType")
	public void User_click_on_kebab_menu_of_BillBoardType() throws Exception {
		masterpage.kebabmenu_BillBoardType();
	}
	@And("User selects Edit option of BillBoardType")
	public void User_selects_Edit_option_of_BillBoardType() throws Exception {
		//masterpage.kebabmenu();
		masterpage.selects_edit_BillBoardType();
	}
	@And("User Updated BillBoardType")
	public void User_Updated_BillBoardType () throws Exception {
		masterpage.Updated_BillBoardType();
	}
	@Then("^Particular BillBoardType gets Edited successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_BillBoardType_gets_Edited_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.BillBoardType_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Edited BillBoardType successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User clicked Delete BillBoardType option")
	public void User_clicked_Delete_BillBoardType_option  () throws Exception {
		masterpage.selects_delete_BillBoardType();
	}
	@Then("^Particular BillBoardType gets Deleted successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_BillBoardType_gets_Deleted_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.BillBoardType_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Edited BillBoardType successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	
	//<----------------------------------------BOMUnit------------------------------------------->
	
		@And("User clicks BOMUnit")
		public void User_clicks_BOMUnit() throws Exception {
			masterpage.BOMUnit_click();
		}
		@Then("Al Arabia BOMUnit page should display successfully")
		public void Al_Arabia_BOMUnit_page_should_display_successfully() throws Exception {
			masterpage.allBOMUnitCount();
		}
		@And("User click on New BOMUnit button")
		public void User_click_on_New_BOMUnit_button() throws Exception {
			masterpage.New_BOMUnit_button_click();
		}
		@And("User Enter BOMUnit name and clicks Add BOMUnit button")
		public void User_Enter_BOMUnit_name_and_clicks_Add_BOMUnit_button() throws Exception {
			masterpage.Add_BOMUnit();
		}
		@Then("^Particular BOMUnit gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
		public void Particular_BOMUnit_gets_created_successfully_as (String expectedMessage1,
				String expectedMessage2) throws Exception {
			String actualMessage = masterpage.BOMUnit_created_Success_display();
			String normalizedActualMessage = normalizeWhitespace(actualMessage);
			System.out.println(">> User or Admin Created BOMUnit successfully: " + actualMessage);

			boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
			boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

			assertTrue("The actual message was neither of the expected success messages.",
					matchesMessage1 || matchesMessage2);
		}
		@And("Admin or user search the BOMUnit")
		public void Admin_or_user_search_the_BOMUnit() throws Exception {
			masterpage.BOMUnit_search_enter_text();
		}
		@Then("Searched BOMUnit details get displayed successfully")
		public void Searched_BOMUnit_details_get_displayed_successfully() {
			masterpage.BOMUnitSearchedList();
		}
		@And("Admin or user sort the BOMUnit list recently updated")
		public void Admin_or_user_sort_the_BOMUnit_list_recently_updated() throws Exception {
			masterpage.BOMUnit_sort_recentlyupdated();
		}
		@Then("Recently updated BOMUnit list get displayed successfully")
		public void Recently_updated_BOMUnit_list_get_displayed_successfully() throws Exception {
			masterpage.BOMUnitlist();
		}
		@And("User sort the BOMUnit list Name A to Z")
		public void User_sort_the_BOMUnit_list_Name_A_to_Z() throws Exception {
			masterpage.BOMUnit_sortA_Z();
		}
		@Then("BOMUnit list get displayed successfully")
		public void BOMUnit_list_get_displayed_successfully() throws Exception {
			masterpage.BOMUnitlist();
		}
		@And("User sort the BOMUnit list Name Z to A")
		public void User_sort_the_BOMUnit_list_Name_Z_to_A() throws Exception {
			masterpage.BOMUnit_sortZ_A();
		}
		@Then("BOMUnit list Z to A get displayed successfully")
		public void BOMUnit_list_Z_to_A_get_displayed_successfully() throws Exception {
			masterpage.BOMUnitlist();
		}
		@And("User sort the BOMUnit list Recently Added")
		public void User_sort_the_BOMUnit_list_Recently_Added() throws Exception {
			masterpage.BOMUnit_sort_recentlyadded();
		}
		@Then("Recent BOMUnit list get displayed successfully")
		public void Recent_BOMUnit_list_get_displayed_successfully() throws Exception {
			masterpage.BOMUnitlist();
		}
		@And("User sort the BOMUnit list decending")
		public void User_sort_the_BOMUnit_list_Decending() throws Exception {
			masterpage.BOMUnit_DecendingDate();
		}
		@Then("Decending BOMUnit list get displayed successfully")
		public void Decending_BOMUnit_list_get_displayed_successfully() throws Exception {
			masterpage.BOMUnitlist();
		}
		@And("User click on kebab menu of BOMUnit")
		public void User_click_on_kebab_menu_of_BOMUnit() throws Exception {
			masterpage.kebabmenu_BOMUnit();
		}
		@And("User selects Edit option of BOMUnit")
		public void User_selects_Edit_option_of_BOMUnit() throws Exception {
			//masterpage.kebabmenu();
			masterpage.selects_edit_BOMUnit();
		}
		@And("User Updated BOMUnit")
		public void User_Updated_BOMUnit () throws Exception {
			masterpage.Updated_BOMUnit();
		}
		@Then("^Particular BOMUnit gets Edited successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
		public void Particular_BOMUnit_gets_Edited_successfully_as (String expectedMessage1,
				String expectedMessage2) throws Exception {
			String actualMessage = masterpage.BOMUnit_created_Success_display();
			String normalizedActualMessage = normalizeWhitespace(actualMessage);
			System.out.println(">> User or Admin Edited BOMUnit successfully: " + actualMessage);

			boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
			boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

			assertTrue("The actual message was neither of the expected success messages.",
					matchesMessage1 || matchesMessage2);
		}
		@And("User clicked Delete BOMUnit option")
		public void User_clicked_Delete_BOMUnit_option  () throws Exception {
			masterpage.selects_delete_BOMUnit();
		}
		@Then("^Particular BOMUnit gets Deleted successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
		public void Particular_BOMUnit_gets_Deleted_successfully_as (String expectedMessage1,
				String expectedMessage2) throws Exception {
			String actualMessage = masterpage.BOMUnit_created_Success_display();
			String normalizedActualMessage = normalizeWhitespace(actualMessage);
			System.out.println(">> User or Admin Edited BOMUnit successfully: " + actualMessage);

			boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
			boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

			assertTrue("The actual message was neither of the expected success messages.",
					matchesMessage1 || matchesMessage2);
		}
		
		//<----------------------------------------BOM----------------------------------------->
		
		@And("User clicks the BOM")
		public void User_clicks_the_BOM() throws Exception {
			masterpage.BOM_click();
		}
		@Then("Al Arabia BOM page should display successfully")
		public void Al_Arabia_BOM_page_should_display_successfully() throws Exception {
			masterpage.allBOMCount();
		}
		@And("User click on New BOM button")
		public void User_click_on_New_BOM_button() throws Exception {
			masterpage.New_BOM_button_click();
		}
		@And("User Enter Mandatory fields of New BOM page")
		public void User_Enter_Mandatory_fields_of_New_BOM_page() throws Exception {
			masterpage.Enter_Mandatory_fields_BOM();
		}
		@And("User click on Add BOM button")
		public void User_click_on_Add_BOM_button() throws Exception {
			masterpage.Click_Add_BOM();
		}
		@Then("^Particular BOM gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
		public void Particular_BOM_gets_created_successfully_with_either (String expectedMessage1,
				String expectedMessage2) throws Exception {
			String actualMessage = masterpage.BOM_created_Success_display();
			String normalizedActualMessage = normalizeWhitespace(actualMessage);
			System.out.println(">> User or Admin Created BOM successfully: " + actualMessage);

			boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
			boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

			assertTrue("The actual message was neither of the expected success messages.",
					matchesMessage1 || matchesMessage2);
		}
		@And("Admin or user search the BOM")
		public void Admin_or_user_search_the_BOM() throws Exception {
			masterpage.BOM_search_enter_text();
		}
		@Then("Searched BOM details get displayed successfully")
		public void Searched_BOM_details_get_displayed_successfully() {
			masterpage.BOMSearchedList();
		}
		@And("Admin or user sort the BOM list recently updated")
		public void Admin_or_user_sort_the_BOM_list_recently_updated() throws Exception {
			masterpage.BOM_sort_recentlyupdated();
		}
		@Then("Recently updated BOM list get displayed successfully")
		public void Recently_updated_BOM_list_get_displayed_successfully() throws Exception {
			masterpage.BOMlist();
		}
		@And("User sort the BOM list Name A to Z")
		public void User_sort_the_BOM_list_Name_A_to_Z() throws Exception {
			masterpage.A_Z_BOM_sort();
		}
		@Then("BOM list get displayed successfully")
		public void BOM_list_get_displayed_successfully() throws Exception {
			masterpage.BOMlist();
		}
		@And("User sort the BOM list Name Z to A")
		public void User_sort_the_BOM_list_Name_Z_to_A() throws Exception {
			masterpage.recent_sortZ_A();
		}
		@Then("BOM list Z to A get displayed successfully")
		public void BOM_list_Z_to_A_get_displayed_successfully() throws Exception {
			masterpage.BOMlist();
		}
		@And("User sort the BOM list Recently Added")
		public void User_sort_the_BOM_list_Recently_Added() throws Exception {
			masterpage.BOM_sort_recentlyadded();
		}
		@Then("Recent BOM list get displayed successfully")
		public void Recent_BOM_list_get_displayed_successfully() throws Exception {
			masterpage.BOMlist();
		}
		@And("User sort the BOM list decending")
		public void User_sort_the_BOM_list_Decending() throws Exception {
			masterpage.BOM_DecendingDate();
		}
		@Then("Decending BOM list get displayed successfully")
		public void Decending_BOM_list_get_displayed_successfully() throws Exception {
			masterpage.BOMlist();
		}
		@And("User click on kebab menu of BOM")
		public void User_click_on_kebab_menu_of_BOM() throws Exception {
			masterpage.BOM_kebabmenu();
		}
		@And("User selects Edit option of BOM")
		public void User_selects_Edit_option_of_BOM() throws Exception {
			//masterpage.kebabmenu();
			masterpage.selects_edit_BOM();
		}
		@And("User Updated BOM")
		public void User_Updated_BOM () throws Exception {
			masterpage.Updated_BOM();
		}
		@Then("^Particular BOM gets Edited successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
		public void Particular_BOM_gets_Edited_successfully_as (String expectedMessage1,
				String expectedMessage2) throws Exception {
			String actualMessage = masterpage.BOM_created_Success_display();
			String normalizedActualMessage = normalizeWhitespace(actualMessage);
			System.out.println(">> User or Admin Edited BOM successfully: " + actualMessage);

			boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
			boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

			assertTrue("The actual message was neither of the expected success messages.",
					matchesMessage1 || matchesMessage2);
		}
		@And("User clicked Delete BOM option")
		public void User_clicked_Delete_BOM_option  () throws Exception {
			masterpage.selects_delete_BOM();
			masterpage.BOM_delete_confirm();

		}
		@Then("^Particular BOM gets Deleted successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
		public void Particular_BOM_gets_Deleted_successfully_as (String expectedMessage1,
				String expectedMessage2) throws Exception {
			String actualMessage = masterpage.BOM_created_Success_display();
			String normalizedActualMessage = normalizeWhitespace(actualMessage);
			System.out.println(">> User or Admin Edited BOM successfully: " + actualMessage);

			boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
			boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

			assertTrue("The actual message was neither of the expected success messages.",
					matchesMessage1 || matchesMessage2);
		}
		@And("User clicked View BOM option")
		public void User_clicked_View_BOM_option() throws Exception {
			masterpage.selects_view_BOM();
		}
		@And("BOM page will be displayed to the user")
		public void BOM_page_will_be_displayed_to_the_user() throws Exception {
			masterpage.BOM_viewpagedisplay();
		}
}
