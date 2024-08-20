package Stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Inventorypage;
import pageobjects.Signinpage;
import resources.Base;

public class Inventory extends Base {

	private static Logger LOGGER = LogManager.getLogger(Inventory.class);
	private WebDriver driver;
	private Inventorypage inventorypage;
	public Inventory(Testhooks testhooks) throws Exception {
		this.driver = testhooks.getDriver();
		this.inventorypage = new Inventorypage(driver);
		new Signinpage(driver);
		LOGGER = LogManager.getLogger(Inventory.class.getName());
	}
	@And("Admin or user clicks the Inventory module")
	public void Admin_or_user_clicks_the_Inventory_module() throws Exception {
		inventorypage.Inventory_click();
	}
	@Then("Al-Arabia Inventory page should display successfully")
	public void Al_Arabia_Inventory_page_should_display_successfully() throws Exception {
		inventorypage.allpurchaseCount();
		LOGGER.info(">> Admin/user got the Inventory page >>");
	}
	@And("Admin or user clicks the New Purchase button")
	public void Admin_or_user_clicks_New_Purchase_button () throws Exception {
		inventorypage.New_purchase_button();
	}
	@And("Admin or user enters the all mandatory fields of New Purchase")
	public void Admin_or_user_enters_the_all_mandatory_fields_of_New_Purchase () throws Exception {
		inventorypage.Mandatory_fields_enter_new_purchase();
	}
	@And("Admin or user clicks the Add Purchase button")
	public void Admin_or_user_clicks_the_Add_Purchase_button () throws Exception {
		inventorypage.Add_purchase_button();
	}
	@Then("^Particular Purchase gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Purchase_gets_created_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = inventorypage.inventory_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin got the purchase created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	private String normalizeWhitespace(String input) {
		return input.replaceAll("\\s+", " ").trim();
	}
	@And("Admin or user search the Purchases")
	public void Admin_or_user_search_the_Purchases() throws Exception {
		inventorypage.Purchases_search_enter_text();
	}

	@Then("Searched Purchase details get displayed successfully")
	public void Searched_Purchase_details_get_displayed_successfully() {
		inventorypage.PurchasesSearchedList();
	}
	@And("Admin or user sort the Purchases list recently updated")
	public void Admin_or_user_sort_the_Purchases_list_recently_updated() throws Exception {
		inventorypage.Purchases_sort_recentlyupdated();
	}

	@Then("Recently updated Purchases list get displayed successfully")
	public void Recently_updated_Purchases_list_get_displayed_successfully() throws Exception {
		inventorypage.Purchaseslist();
	}

	@And("User sort the Purchases list Name A to Z")
	public void User_sort_the_Purchases_list_Name_A_to_Z() throws Exception {
		inventorypage.Purchases_sortZ_A();
	}

	@Then("Purchases list get displayed successfully")
	public void Purchases_list_get_displayed_successfully() throws Exception {
		inventorypage.Purchaseslist();
	}

	@And("User sort the Purchases list Name Z to A")
	public void User_sort_the_Purchases_list_Name_Z_to_A() throws Exception {
		inventorypage.Purchases_sortZ_A();
	}

	@Then("Purchases list Z to A get displayed successfully")
	public void Purchases_list_Z_to_A_get_displayed_successfully() throws Exception {
		inventorypage.Purchaseslist();
	}

	@And("User sort the Purchases list Recently Added")
	public void User_sort_the_Purchases_list_Recently_Added() throws Exception {
		inventorypage.Purchases_sort_recentlyadded();
	}

	@Then("Recent Purchases list get displayed successfully")
	public void Recent_Purchases_list_get_displayed_successfully() throws Exception {
		inventorypage.Purchaseslist();
	}
	@And("User sort the Purchases list decending")
	public void User_sort_the_Purchases_list_Decending() throws Exception {
		inventorypage.Purchases_DecendingDate();
	}

	@Then("Decending Purchases list get displayed successfully")
	public void Decending_Purchases_list_get_displayed_successfully() throws Exception {
		inventorypage.Purchaseslist();
	}
	
}
