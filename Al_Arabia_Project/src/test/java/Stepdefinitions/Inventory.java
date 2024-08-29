package Stepdefinitions;

import static org.junit.Assert.assertEquals;
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
	//private static Logger LOGGER = LogManager.getLogger(Inventory.class);

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
		inventorypage.Purchases_sortA_Z();
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
	@And("User clicks the Download button in inventory page")
	public void User_clicks_the_Download_button_in_inventory_page() throws Exception {
		inventorypage.Download_button_inventorypage();
	}
	@Then("Download pop up will be displayed successfully")
	public void Download_pop_up_will_be_displayed_successfully() throws Exception {
		inventorypage.Purchases_Download_popup_display();
	}
	@And("User clicks the Download button with Download As Excel of Purchase list")
	public void User_clicks_the_Download_button_with_Download_As_Excel_of_Purchase_list() throws Exception {
		inventorypage.Download_button_inventorypage();
		inventorypage.Purchases_Download_Excel();
	}
	@And("User clicks the Download button with Download As PDF")
	public void User_clicks_the_Download_button_with_Download_As_PDF() throws Exception {
		inventorypage.Download_button_inventorypage();
		inventorypage.Purchases_Download_PDF();
	}
	@And("User clicks the Download button in inventory page after that click on close button")
	public void User_clicks_the_Download_in_inventory_page_after_that_click_on_close_button() throws Exception {
		inventorypage.Download_button_inventorypage();
		inventorypage.Purchases_Download_popup_close();
	}
	@Then("The Download pop up get closed successfully and display the Inventory list")
	public void The_Download_pop_up_get_closed_successfully_and_display_the_Inventory_list() throws Exception {
		inventorypage.Download_popupclosd_displayed_Purchases();
	}
	@And("User click on edit icon in all purchase page")
	public void User_click_on_edit_icon_in_all_purchase_page() throws Exception {
		inventorypage.Click_Purchases_Edit();
	}
	@And("User edit the Project name")
	public void User_edit_the_Project_name() throws Exception {
		inventorypage.Edit_projectname();
	}
	@And("User Click on Update Purchase button")
	public void User_Click_on_Update_Purchase_button() throws Exception {
		inventorypage.Updatebutton_click();
	}
	@Then("^Particular Purchase gets updated successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Purchase_gets_updated_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = inventorypage.inventory_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin got the purchase created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User click on view option in kebab menu")
	public void User_click_on_view_option_in_kebab_menu() throws Exception {
		inventorypage.Viewclick_option();
	}
	@Then("Particular parchase get displayed successfully")
	public void Particular_parchase_get_displayed_successfully() throws Exception {
		inventorypage.Download_popupclosd_displayed_Purchases();
	}
	@And("User click on Delete option in kebab menu and confirm Yes")
	public void User_click_on_Delete_option_in_kebab_menu_and_confirm_Yes() throws Exception {
		inventorypage.Deleteclick_option();
		inventorypage.Confirmed_Deleteclick_option();
	}
	@Then("^Purchase deleted popup will be displayed successfully as \"([^\"]*)\"$")
	public void Purchase_deleted_popup_will_be_displayed_successfully_as(String expectedMessage) throws Exception {
		  String actualMessage = inventorypage.inventory_create_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin Deleted Material successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}
	@And("User click on second page button of Inventory page")
	public void User_click_on_second_page_button_of_Inventory_page() throws Exception {
		inventorypage.Second_page();
}
	@Then("Second page Inventory get displayed successfully")
	public void Second_page_Inventory_get_displayed_successfully() throws Exception {
		inventorypage.Second_page_Display();
}
	@And("Go to Next page of Inventory page")
	public void Go_to_Next_page_of_Inventory_page() throws Exception {
		inventorypage.next_page();
}
	@Then("Next page Inventory get displayed successfully")
	public void Next_page_Inventory_get_displayed_successfully() throws Exception {
}
	@And("Go to Previous page of Inventory page")
	public void Go_to_Previous_page_of_Inventory_page() throws Exception {
		inventorypage.Previous_page();
}
	@Then("Previous page Inventory get displayed successfully")
	public void Previous_page_Inventory_get_displayed_successfully() throws Exception {
}
	@And("Go to Last page of Inventory page")
	public void Go_to_Last_page_of_Inventory_page() throws Exception {
		inventorypage.last_page();
}
	@Then("Last page Inventory get displayed successfully")
	public void Last_page_Inventory_get_displayed_successfully() throws Exception {
}
	@And("User click on first page button of inventory")
	public void User_click_on_first_page_button_of_inventory() throws Exception {
		inventorypage.First_page();
}
	@Then("First page Inventory get displayed successfully")
	public void First_page_Inventory_get_displayed_successfully() throws Exception {
}
	@And("User clicks start conversation button in Inventory page")
	public void User_clicks_start_conversation_button_in_Inventory_page() throws Exception {
		inventorypage.Start_conversation();
}
	@Then("The chat page will be displayed successfully")
	public void The_chat_page_will_be_displayed_successfully() throws Exception {
		inventorypage.Chat_page_Displayed();
}
	@And("Admin or user clicks the Material Request Tab")
	public void Admin_or_user_clicks_the_Material_Request_Tab() throws Exception {
		inventorypage.Material_request_page();
}
	@Then("Material Request page should display successfully")
	public void Material_Request_page_should_display_successfully() throws Exception {
		inventorypage.Material_request_page_Displayed();
}
	
	
	@And("Admin or user search a Material")
	public void Admin_or_user_search_a_Material() throws Exception {
		inventorypage.Material_search_enter_text();
	}

	@Then("Searched Material details get displayed successfully")
	public void Searched_Material_details_get_displayed_successfully() {
		inventorypage.MaterialSearchedList();
	}
	@And("Admin or user sort the Material list recently updated")
	public void Admin_or_user_sort_the_Material_list_recently_updated() throws Exception {
		inventorypage.Material_sort_recentlyupdated();
	}

	@Then("Recently updated Material list get displayed successfully")
	public void Recently_updated_Material_list_get_displayed_successfully() throws Exception {
		inventorypage.Material_list();
	}

	@And("User sort the Material list Name A to Z")
	public void User_sort_the_Material_list_Name_A_to_Z() throws Exception {
		inventorypage.Material_sortA_Z();
	}

	@Then("Material list get displayed successfully")
	public void Material_list_get_displayed_successfully() throws Exception {
		inventorypage.Material_list();
	}

	@And("User sort the Material list Name Z to A")
	public void User_sort_the_Material_list_Name_Z_to_A() throws Exception {
		inventorypage.Material_sortZ_A();
	}

	@Then("Material list Z to A get displayed successfully")
	public void Material_list_Z_to_A_get_displayed_successfully() throws Exception {
		inventorypage.Material_list();
	}

	@And("User sort the Material list Recently Added")
	public void User_sort_the_Material_list_Recently_Added() throws Exception {
		inventorypage.Material_sort_recentlyadded();
	}

	@Then("Recent Material list get displayed successfully")
	public void Recent_Material_list_get_displayed_successfully() throws Exception {
		inventorypage.Material_list();
	}
	@And("User sort the Material list decending")
	public void User_sort_the_Material_list_Decending() throws Exception {
		inventorypage.Material_DecendingDate();
	}

	@Then("Decending Material list get displayed successfully")
	public void Decending_Material_list_get_displayed_successfully() throws Exception {
		inventorypage.Material_list();
	}
	@And("User clicks the Download button in Material page")
	public void User_clicks_the_Download_button_in_Material_page() throws Exception {
		inventorypage.Download_button_Materialpage();
	}
	@Then("Download pop up of Material will be displayed successfully")
	public void Download_pop_up_of_Material_will_be_displayed_successfully() throws Exception {
		inventorypage.Material_Download_popup_display();
	}
	@And("User clicks the Download button with Download As Excel of Material list")
	public void User_clicks_the_Download_button_with_Download_As_Excel_of_Material_list() throws Exception {
		inventorypage.Download_button_Materialpage();
		inventorypage.Material_Download_Excel();
	}
	@And("User clicks the Download button with Download As PDF for Materials")
	public void User_clicks_the_Download_button_with_Download_As_PDF_for_Materials() throws Exception {
		inventorypage.Download_button_Materialpage();
		inventorypage.Material_Download_PDF();
	}
	@And("User clicks the Download button in Material page after that click on close button")
	public void User_clicks_the_Download_in_Material_page_after_that_click_on_close_button() throws Exception {
		inventorypage.Download_button_Materialpage();
		inventorypage.Material_Download_popup_close();
	}
	@Then("The Download pop up get closed successfully and display the Material list")
	public void The_Download_pop_up_get_closed_successfully_and_display_the_Material_list() throws Exception {
		inventorypage.Download_popupclosd_displayed_Material();
	}

}
