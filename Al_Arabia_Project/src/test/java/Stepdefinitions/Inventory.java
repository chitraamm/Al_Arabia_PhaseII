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
	
	//<----------------------------------Material Request-------------------------------->

	
	@And("Admin or user clicks the Material Request Tab")
	public void Admin_or_user_clicks_the_Material_Request_Tab() throws Exception {
		inventorypage.Material_request_page();
}
	@Then("Material Request page should display successfully")
	public void Material_Request_page_should_display_successfully() throws Exception {
		inventorypage.Material_request_page_Displayed();
}
		@And("Admin or user search a Material Request")
	public void Admin_or_user_search_a_Material_Request() throws Exception {
		inventorypage.Material_search_enter_text();
	}

	@Then("Searched Material Request details get displayed successfully")
	public void Searched_Material_Request_details_get_displayed_successfully() {
		inventorypage.MaterialSearchedList();
	}
	@And("Admin or user sort the Material Request list recently updated")
	public void Admin_or_user_sort_the_Material_Request_list_recently_updated() throws Exception {
		inventorypage.Material_sort_recentlyupdated();
	}

	@Then("Recently updated Material Request list get displayed successfully")
	public void Recently_updated_Material_Request_list_get_displayed_successfully() throws Exception {
		inventorypage.Material_list();
	}

	@And("User sort the Material Request list Name A to Z")
	public void User_sort_the_Material_Request_list_Name_A_to_Z() throws Exception {
		inventorypage.Material_sortA_Z();
	}

	@Then("Material Request list get displayed successfully")
	public void Material_list_get_displayed_successfully() throws Exception {
		inventorypage.Material_list();
	}

	@And("User sort the Material Request list Name Z to A")
	public void User_sort_the_Material_Request_list_Name_Z_to_A() throws Exception {
		inventorypage.Material_sortZ_A();
	}

	@Then("Material Request list Z to A get displayed successfully")
	public void Material_Request_list_Z_to_A_get_displayed_successfully() throws Exception {
		inventorypage.Material_list();
	}

	@And("User sort the Material Request list Recently Added")
	public void User_sort_the_Material_Request_list_Recently_Added() throws Exception {
		inventorypage.Material_sort_recentlyadded();
	}

	@Then("Recent Material Request list get displayed successfully")
	public void Recent_Material_Request_list_get_displayed_successfully() throws Exception {
		inventorypage.Material_list();
	}
	@And("User sort the Material Request list decending")
	public void User_sort_the_Material_Request_list_Decending() throws Exception {
		inventorypage.Material_DecendingDate();
	}

	@Then("Decending Material Request list get displayed successfully")
	public void Decending_Material_Request_list_get_displayed_successfully() throws Exception {
		inventorypage.Material_list();
	}
	@And("User clicks the Download button in Material Request page")
	public void User_clicks_the_Download_button_in_Material_Request_page() throws Exception {
		inventorypage.Download_button_Materialpage();
	}
	@Then("Download pop up of Material Request will be displayed successfully")
	public void Download_pop_up_of_Material_Request_will_be_displayed_successfully() throws Exception {
		inventorypage.Material_Download_popup_display();
	}
	@And("User clicks the Download button with Download As Excel of Material Request list")
	public void User_clicks_the_Download_button_with_Download_As_Excel_of_Material_Request_list() throws Exception {
		inventorypage.Download_button_Materialpage();
		inventorypage.Material_Download_Excel();
	}
	@And("User clicks the Download button with Download As PDF for Material Request")
	public void User_clicks_the_Download_button_with_Download_As_PDF_for_Material_Request() throws Exception {
		inventorypage.Download_button_Materialpage();
		inventorypage.Material_Download_PDF();
	}
	@And("User clicks the Download button in Material Request page after that click on close button")
	public void User_clicks_the_Download_in_Material_Request_page_after_that_click_on_close_button() throws Exception {
		inventorypage.Download_button_Materialpage();
		inventorypage.Material_Download_popup_close();
	}
	@Then("The Download pop up get closed successfully and display the Material Request list")
	public void The_Download_pop_up_get_closed_successfully_and_display_the_Material_Request_list() throws Exception {
		inventorypage.Download_popupclosd_displayed_Material();
	}
    @And("Admin or user clicks the New Request button")
    public void Admin_or_user_clicks_the_New_Request_button() throws Exception{
		inventorypage.New_Request_Button();
    }
    @And("Admin or user enters the all mandatory fields of Material Request")
    public void Admin_or_user_enters_the_all_mandatory_fields_of_Material_Request() throws Exception{
		inventorypage.Enter_Mandatory_fieldsof_New_Request();
    }
    @And("Admin or user clicks the Add Request button")
    public void Admin_or_user_clicks_the_Add_Request_button() throws Exception{
		inventorypage.Click_Add_Request_button();
    }
	@Then("^Particular Request gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Request_gets_updated_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = inventorypage.inventory_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin got the purchase created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	
	
//	@And("User click on edit icon in all Material page")
//	public void User_click_on_edit_icon_in_all_Material_page() throws Exception {
//		inventorypage.Click_DamageRec_return_Edit();
//	}
//	@And("User edit the Requestedby and Click on Update return button of DamageRecTechnician")
//	public void User_edit_the_Requestedby_and_Click_on_Update_return_button_of_DamageRecTechnician() throws Exception {
//		inventorypage.Edit_requestby();	
//	}
//	@And("User Click on Update Material button")
//	public void User_Click_on_Update_Material_button() throws Exception {
//		inventorypage.Updatebutton_click();
//	}
	@Then("^Particular Material gets updated successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Material_gets_updated_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = inventorypage.inventory_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin got the purchase created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User click on Material Request view option of kebab menu")
	public void User_click_on_Material_Request_view_option_of_kebab_menu() throws Exception {
		inventorypage.Material_Viewclick_option();
	}
	@Then("Particular Material Request viewed with details successfully")
	public void Particular_Material_Request_viewed_with_details_successfully() throws Exception {
		inventorypage.material_View_display();
	}
	@And("User click on Material Request Delete option in kebab menu and confirm Yes")
	public void User_click_on_Material_Request_Delete_option_in_kebab_menu_and_confirm_Yes() throws Exception {
		inventorypage.Material_Deleteclick_option();
		inventorypage.Material_Confirmed_Deleteclick_option();
	}
	@Then("^Material Request deleted popup will be displayed successfully as \"([^\"]*)\"$")
	public void Material_Request_deleted_popup_will_be_displayed_successfully_as(String expectedMessage) throws Exception {
		  String actualMessage = inventorypage.inventory_create_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin Deleted Material Request successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}
	@And("User click on second page button of Material Request page")
	public void User_click_on_second_page_button_of_Material_Request_page() throws Exception {
		inventorypage.Material_Second_page();
}
	@Then("Second page Material Request get displayed successfully")
	public void Second_page_Material_Request_get_displayed_successfully() throws Exception {
		inventorypage.Second_page_Material_Display();
}
	@And("Go to Next page of Material Request page")
	public void Go_to_Next_page_of_Material_Request_page() throws Exception {
		inventorypage.Material_next_page();
}
	@Then("Next page Material Request get displayed successfully")
	public void Next_page_Material_Request_get_displayed_successfully() throws Exception {
}
	@And("Go to Previous page of Material Request")
	public void Go_to_Previous_page_of_Material_Request_page() throws Exception {
		inventorypage.Material_Previous_page();
}
	@Then("Previous page Material Request get displayed successfully")
	public void Previous_page_Material_Request_get_displayed_successfully() throws Exception {
}
	@And("Go to Last page of Material Request page")
	public void Go_to_Last_page_of_Material_Request_page() throws Exception {
		inventorypage.Material_last_page();
}
	@Then("Last page Material Request get displayed successfully")
	public void Last_page_Material_Request_get_displayed_successfully() throws Exception {
}
	@And("User click on first page button of Material Request")
	public void User_click_on_first_page_button_of_Material_Request() throws Exception {
		inventorypage.First_page_Material();
}
	@Then("First page Material Request get displayed successfully")
	public void First_page_Material_Request_get_displayed_successfully() throws Exception {
}
	//<--------------------------------------Material Issued---------------------------------------------------->


	
	@And("Admin or user clicks the Material Issued Tab")
	public void Admin_or_user_clicks_the_Material_Issued_Tab() throws Exception {
		inventorypage.Material_Issued_page();
}
	@Then("Material Issued page should display successfully")
	public void Material_Issued_page_should_display_successfully() throws Exception {
		inventorypage.Material_Issued_page_Displayed();
}
		@And("Admin or user search a Material Issued")
	public void Admin_or_user_search_a_Material_Issued() throws Exception {
		inventorypage.Issued_Material_search_enter_text();
	}

	@Then("Searched Material Issued details get displayed successfully")
	public void Searched_Material_Issued_details_get_displayed_successfully() {
		inventorypage.Issued_MaterialSearchedList();
	}
	@And("Admin or user sort the Material Issued list recently updated")
	public void Admin_or_user_sort_the_Material_Issued_list_recently_updated() throws Exception {
		inventorypage.Issued_Material_sort_recentlyupdated();
	}

	@Then("Recently updated Material Issued list get displayed successfully")
	public void Recently_updated_Material_Issued_list_get_displayed_successfully() throws Exception {
		inventorypage.Issued_Material_list();
	}

	@And("User sort the Material Issued list Name A to Z")
	public void User_sort_the_Material_Issued_list_Name_A_to_Z() throws Exception {
		inventorypage.Issued_Material_sortA_Z();
	}

	@Then("Material Issued list get displayed successfully")
	public void Material_Issued_list_get_displayed_successfully() throws Exception {
		inventorypage.Issued_Material_list();
	}

	@And("User sort the Material Issued list Name Z to A")
	public void User_sort_the_Material_Issued_list_Name_Z_to_A() throws Exception {
		inventorypage.Issued_Material_sortZ_A();
	}

	@Then("Material Issued list Z to A get displayed successfully")
	public void Material_Issued_list_Z_to_A_get_displayed_successfully() throws Exception {
		inventorypage.Issued_Material_list();
	}

	@And("User sort the Material Issued list Recently Added")
	public void User_sort_the_Material_Issued_list_Recently_Added() throws Exception {
		inventorypage.Issued_Material_sort_recentlyadded();
	}

	@Then("Recent Material Issued list get displayed successfully")
	public void Recent_Material_Issued_list_get_displayed_successfully() throws Exception {
		inventorypage.Issued_Material_list();
	}
	@And("User sort the Material Issued Request list decending")
	public void User_sort_the_Material_Issued_list_Decending() throws Exception {
		inventorypage.Issued_Material_DecendingDate();
	}

	@Then("Decending Material Issued list get displayed successfully")
	public void Decending_Material_Issued_list_get_displayed_successfully() throws Exception {
		inventorypage.Issued_Material_list();
	}
	@And("User clicks the Download button in Material Issued page")
	public void User_clicks_the_Download_button_in_Material_Issued_page() throws Exception {
		inventorypage.Download_button_Issued_Materialpage();
	}
	@Then("Download pop up of Material Issued will be displayed successfully")
	public void Download_pop_up_of_Material_Issued_will_be_displayed_successfully() throws Exception {
		inventorypage.Issued_Material_Download_popup_display();
	}
	@And("User clicks the Download button with Download As Excel of Material Issued list")
	public void User_clicks_the_Download_button_with_Download_As_Excel_of_Material_Issued_list() throws Exception {
		inventorypage.Download_button_Materialpage();
		inventorypage.Issued_Material_Download_Excel();
	}
	@And("User clicks the Download button with Download As PDF for Material Issued")
	public void User_clicks_the_Download_button_with_Download_As_PDF_for_Material_Issued() throws Exception {
		inventorypage.Download_button_Materialpage();
		inventorypage.Issued_Material_Download_PDF();
	}
	@And("User clicks the Download button in Material Issued page after that click on close button")
	public void User_clicks_the_Download_in_Material_Issued_page_after_that_click_on_close_button() throws Exception {
		inventorypage.Download_button_Issued_Materialpage();
		inventorypage.Issued_Material_Download_popup_close();
	}
	@Then("The Download pop up get closed successfully and display the Material Issued list")
	public void The_Download_pop_up_get_closed_successfully_and_display_the_Material_Issued_list() throws Exception {
		inventorypage.Download_popupclosd_displayed_Material();
	}
	@And("User click on Material Issued view option of kebab menu")
	public void User_click_on_Material_Issued_view_option_of_kebab_menu() throws Exception {
		inventorypage.Issued_Material_Viewclick_option();
	}
	@Then("Particular Material Issued viewed with details successfully")
	public void Particular_Material_Issued_viewed_with_details_successfully() throws Exception {
		inventorypage.Issued_Material_View_display();
	}
	@And("User click on second page button of Material Issued page")
	public void User_click_on_second_page_button_of_Material_Issued_page() throws Exception {
		inventorypage.Issued_Material_Second_page();
}
	@Then("Second page Material Issued get displayed successfully")
	public void Second_page_Material_Issued_get_displayed_successfully() throws Exception {
		inventorypage.Second_page_Issued_Material_Display();
}
	@And("Go to Next page of Material Issued page")
	public void Go_to_Next_page_of_Material_Issued_page() throws Exception {
		inventorypage.Issued_Material_next_page();
}
	@Then("Next page Material Issued get displayed successfully")
	public void Next_page_Material_Issued_get_displayed_successfully() throws Exception {
}
	@And("Go to Previous page of Material Issued")
	public void Go_to_Previous_page_of_Material_Issued_page() throws Exception {
		inventorypage.Issued_Material_Previous_page();
}
	@Then("Previous page Material Issued get displayed successfully")
	public void Previous_page_Material_Issued_get_displayed_successfully() throws Exception {
}
	@And("Go to Last page of Material Issued page")
	public void Go_to_Last_page_of_Material_Issued_page() throws Exception {
		inventorypage.Issued_Material_last_page();
}
	@Then("Last page Material Issued get displayed successfully")
	public void Last_page_Material_Issued_get_displayed_successfully() throws Exception {
}
	@And("User click on first page button of Material Issued")
	public void User_click_on_first_page_button_of_Material_Issued() throws Exception {
		inventorypage.First_page_Issued_Material();
}
	@Then("First page Material Issued get displayed successfully")
	public void First_page_Material_Issued_get_displayed_successfully() throws Exception {
}

	//<-----------------------------------------Damage Received from Technician-------------------------------------------------->
	
	@And("Admin or user clicks the DamageRecTechnician Tab")
	public void Admin_or_user_clicks_the_DamageRecTechnician_Tab() throws Exception {
		inventorypage.DamageRecTechnician_page();
}
	@Then("DamageRecTechnician page should display successfully")
	public void DamageRecTechnician_page_should_display_successfully() throws Exception {
		inventorypage.DamageRecTechnician_page_Displayed();
}
		@And("Admin or user search a DamageRecTechnician")
	public void Admin_or_user_search_a_DamageRecTechnician() throws Exception {
		inventorypage.DamageRecTechnician_search_enter_text();
	}

	@Then("Searched DamageRecTechnician details get displayed successfully")
	public void Searched_DamageRecTechnician_details_get_displayed_successfully() {
		inventorypage.DamageRecTechnicianSearchedList();
	}
	@And("Admin or user sort the DamageRecTechnician list recently updated")
	public void Admin_or_user_sort_the_DamageRecTechnician_list_recently_updated() throws Exception {
		inventorypage.DamageRecTechnician_sort_recentlyupdated();
	}

	@Then("Recently updated DamageRecTechnician list get displayed successfully")
	public void Recently_updated_DamageRecTechnician_list_get_displayed_successfully() throws Exception {
		inventorypage.DamageRecTechnician_list();
	}

	@And("User sort the DamageRecTechnician list Name A to Z")
	public void User_sort_the_DamageRecTechnician_list_Name_A_to_Z() throws Exception {
		inventorypage.DamageRecTechnician_sortA_Z();
	}

	@Then("DamageRecTechnician list get displayed successfully")
	public void DamageRecTechnician_list_get_displayed_successfully() throws Exception {
		inventorypage.DamageRecTechnician_list();
	}

	@And("User sort the DamageRecTechnician list Name Z to A")
	public void User_sort_the_DamageRecTechnician_list_Name_Z_to_A() throws Exception {
		inventorypage.DamageRecTechnician_sortZ_A();
	}

	@Then("DamageRecTechnician list Z to A get displayed successfully")
	public void DamageRecTechnician_list_Z_to_A_get_displayed_successfully() throws Exception {
		inventorypage.DamageRecTechnician_list();
	}

	@And("User sort the DamageRecTechnician list Recently Added")
	public void User_sort_the_DamageRecTechnician_list_Recently_Added() throws Exception {
		inventorypage.DamageRecTechnician_sort_recentlyadded();
	}

	@Then("Recent DamageRecTechnician list get displayed successfully")
	public void Recent_DamageRecTechnician_list_get_displayed_successfully() throws Exception {
		inventorypage.DamageRecTechnician_list();
	}
	@And("User sort the DamageRecTechnician list decending")
	public void User_sort_the_DamageRecTechnician_list_Decending() throws Exception {
		inventorypage.DamageRecTechnician_DecendingDate();
	}

	@Then("Decending DamageRecTechnician list get displayed successfully")
	public void Decending_DamageRecTechnician_list_get_displayed_successfully() throws Exception {
		inventorypage.DamageRecTechnician_list();
	}
	@And("User clicks the Download button in DamageRecTechnician page")
	public void User_clicks_the_Download_button_in_DamageRecTechnician_page() throws Exception {
		inventorypage.Download_button_DamageRecTechnicianpage();
	}
	@Then("Download pop up of DamageRecTechnician will be displayed successfully")
	public void Download_pop_up_of_DamageRecTechnician_will_be_displayed_successfully() throws Exception {
		inventorypage.DamageRecTechnician_Download_popup_display();
	}
	@And("User clicks the Download button with Download As Excel of DamageRecTechnician list")
	public void User_clicks_the_Download_button_with_Download_As_Excel_of_DamageRecTechnician_list() throws Exception {
		inventorypage.Download_button_DamageRecTechnicianpage();
		inventorypage.DamageRecTechnician_Download_Excel();
	}
	@And("User clicks the Download button with Download As PDF for DamageRecTechnician")
	public void User_clicks_the_Download_button_with_Download_As_PDF_for_DamageRecTechnician() throws Exception {
		inventorypage.Download_button_DamageRecTechnicianpage();
		inventorypage.DamageRecTechnician_Download_PDF();
	}
	@And("User clicks the Download button in DamageRecTechnician page after that click on close button")
	public void User_clicks_the_Download_in_DamageRecTechnician_page_after_that_click_on_close_button() throws Exception {
		inventorypage.Download_button_DamageRecTechnicianpage();
		inventorypage.DamageRecTechnician_Download_popup_close();
	}
	@Then("The Download pop up get closed successfully and display the DamageRecTechnician list")
	public void The_Download_pop_up_get_closed_successfully_and_display_the_DamageRecTechnician_list() throws Exception {
		inventorypage.Download_popupclosd_displayed_DamageRecTechnician();
	}
    @And("Admin or user clicks the New Return button in DamageRecTechnician")
    public void Admin_or_user_clicks_the_New_Return_button_in_DamageRecTechnician() throws Exception{
		inventorypage.New_Return_Button();
    }
    @And("Admin or user enters the all mandatory fields of DamageRecTechnician")
    public void Admin_or_user_enters_the_all_mandatory_fields_of_DamageRecTechnician() throws Exception{
		inventorypage.Enter_Mandatory_fieldsof_New_Return();
    }
    @And("Admin or user clicks the Add Return button")
    public void Admin_or_user_clicks_the_Add_Return_button() throws Exception{
		inventorypage.Click_Add_Return_button();
    }
	@Then("^Particular Return received from Technician gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Return_received_from_Technician_gets_created_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = inventorypage.inventory_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin got the purchase created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	
	@And("User click on edit icon in all return page")
	public void User_click_on_edit_icon_in_all_return_page() throws Exception {
		inventorypage.Click_DamageRec_return_Edit();
	}
	@And("User edit the Requestedby and Click on Update return button of DamageRecTechnician")
	public void User_edit_the_Requestedby_and_Click_on_Update_return_button_of_DamageRecTechnician() throws Exception {
		inventorypage.Edit_requestby();	
	}
	@Then("^Particular Return gets updated successfully for DamageRecTechnician with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Return_gets_updated_successfully_for_DamageRecTechnician_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = inventorypage.inventory_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin got the purchase created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User click on DamageRecTechnician view option of kebab menu")
	public void User_click_on_DamageRecTechnician_view_option_of_kebab_menu() throws Exception {
		inventorypage.DamageRecTechnician_Viewclick_option();
	}
	@Then("Particular DamageRecTechnician viewed with details successfully")
	public void Particular_DamageRecTechnician_viewed_with_details_successfully() throws Exception {
		inventorypage.DamageRecTechnicianView_display();
	}
	@And("User click on DamageRecTechnician Delete option in kebab menu and confirm Yes")
	public void User_click_on_DamageRecTechnician_Delete_option_in_kebab_menu_and_confirm_Yes() throws Exception {
		inventorypage.DamageRecTechnician_Deleteclick_option();
		inventorypage.DamageRecTechnician_Confirmed_Deleteclick_option();
	}
	@Then("^DamageRecTechnician deleted popup will be displayed successfully as \"([^\"]*)\"$")
	public void DamageRecTechnician_deleted_popup_will_be_displayed_successfully_as(String expectedMessage) throws Exception {
		  String actualMessage = inventorypage.inventory_create_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin Deleted DamageRecTechnician successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}
	@And("User click on second page button of DamageRecTechnician page")
	public void User_click_on_second_page_button_of_DamageRecTechnician_page() throws Exception {
		inventorypage.DamageRecTechnician_Second_page();
}
	@Then("Second page DamageRecTechnician get displayed successfully")
	public void Second_page_DamageRecTechnician_get_displayed_successfully() throws Exception {
		inventorypage.Second_page_DamageRecTechnician_Display();
}
	@And("Go to Next page of DamageRecTechnician page")
	public void Go_to_Next_page_of_DamageRecTechnician_page() throws Exception {
		inventorypage.DamageRecTechnician_next_page();
}
	@Then("Next page DamageRecTechnician get displayed successfully")
	public void Next_page_DamageRecTechnician_get_displayed_successfully() throws Exception {
}
	@And("Go to Previous page of DamageRecTechnician")
	public void Go_to_Previous_page_of_DamageRecTechnician_page() throws Exception {
		inventorypage.DamageRecTechnician_Previous_page();
}
	@Then("Previous page DamageRecTechnician get displayed successfully")
	public void Previous_page_DamageRecTechnician_get_displayed_successfully() throws Exception {
}
	@And("Go to Last page of DamageRecTechnician page")
	public void Go_to_Last_page_of_DamageRecTechnician_page() throws Exception {
		inventorypage.DamageRecTechnician_last_page();
}
	@Then("Last page DamageRecTechnician get displayed successfully")
	public void Last_page_DamageRecTechnician_get_displayed_successfully() throws Exception {
}
	@And("User click on first page button of DamageRecTechnician")
	public void User_click_on_first_page_button_of_DamageRecTechnician() throws Exception {
		inventorypage.First_page_DamageRecTechnician();
}
	@Then("First page DamageRecTechnician get displayed successfully")
	public void First_page_DamageRecTechnician_get_displayed_successfully() throws Exception {
}
	//<---------------------------------------Damage Returned To Supplier---------------------------------------->
	
	@And("Admin or user clicks the DamageRetSupplier Tab")
	public void Admin_or_user_clicks_the_DamageRetSupplier_Tab() throws Exception {
		inventorypage.DamageRetSupplier_page();
}
	@Then("DamageRetSupplier page should display successfully")
	public void DamageRetSupplier_page_should_display_successfully() throws Exception {
		inventorypage.DamageRetSupplier_page_Displayed();
}
		@And("Admin or user search a DamageRetSupplier")
	public void Admin_or_user_search_a_DamageRetSupplier() throws Exception {
		inventorypage.DamageRetSupplier_search_enter_text();
	}

	@Then("Searched DamageRetSupplier details get displayed successfully")
	public void Searched_DamageRetSupplier_details_get_displayed_successfully() {
		inventorypage.DamageRetSupplierSearchedList();
	}
	@And("Admin or user sort the DamageRetSupplier list recently updated")
	public void Admin_or_user_sort_the_DamageRetSupplier_list_recently_updated() throws Exception {
		inventorypage.DamageRetSupplier_sort_recentlyupdated();
	}

	@Then("Recently updated DamageRetSupplier list get displayed successfully")
	public void Recently_updated_DamageRetSupplier_list_get_displayed_successfully() throws Exception {
		inventorypage.DamageRetSupplier_list();
	}

	@And("User sort the DamageRetSupplier list Name A to Z")
	public void User_sort_the_DamageRetSupplier_list_Name_A_to_Z() throws Exception {
		inventorypage.DamageRetSupplier_sortA_Z();
	}

	@Then("DamageRetSupplier list get displayed successfully")
	public void DamageRetSupplier_list_get_displayed_successfully() throws Exception {
		inventorypage.DamageRetSupplier_list();
	}

	@And("User sort the DamageRetSupplier list Name Z to A")
	public void User_sort_the_DamageRetSupplier_list_Name_Z_to_A() throws Exception {
		inventorypage.DamageRetSupplier_sortZ_A();
	}

	@Then("DamageRetSupplier list Z to A get displayed successfully")
	public void DamageRetSupplier_list_Z_to_A_get_displayed_successfully() throws Exception {
		inventorypage.DamageRetSupplier_list();
	}

	@And("User sort the DamageRetSupplier list Recently Added")
	public void User_sort_the_DamageRetSupplier_list_Recently_Added() throws Exception {
		inventorypage.DamageRetSupplier_sort_recentlyadded();
	}

	@Then("Recent DamageRetSupplier list get displayed successfully")
	public void Recent_DamageRetSupplier_list_get_displayed_successfully() throws Exception {
		inventorypage.DamageRetSupplier_list();
	}
	@And("User sort the DamageRetSupplier list decending")
	public void User_sort_the_DamageRetSupplier_list_Decending() throws Exception {
		inventorypage.DamageRetSupplier_DecendingDate();
	}

	@Then("Decending DamageRetSupplier list get displayed successfully")
	public void Decending_DamageRetSupplier_list_get_displayed_successfully() throws Exception {
		inventorypage.DamageRetSupplier_list();
	}
	@And("User clicks the Download button in DamageRetSupplier page")
	public void User_clicks_the_Download_button_in_DamageRetSupplier_page() throws Exception {
		inventorypage.Download_button_DamageRetSupplierpage();
	}
	@Then("Download pop up of DamageRetSupplier will be displayed successfully")
	public void Download_pop_up_of_DamageRetSupplier_will_be_displayed_successfully() throws Exception {
		inventorypage.DamageRetSupplier_Download_popup_display();
	}
	@And("User clicks the Download button with Download As Excel of DamageRetSupplier list")
	public void User_clicks_the_Download_button_with_Download_As_Excel_of_DamageRetSupplier_list() throws Exception {
		inventorypage.Download_button_DamageRetSupplierpage();
		inventorypage.DamageRetSupplier_Download_Excel();
	}
	@And("User clicks the Download button with Download As PDF for DamageRetSupplier")
	public void User_clicks_the_Download_button_with_Download_As_PDF_for_DamageRetSupplier() throws Exception {
		inventorypage.Download_button_DamageRetSupplierpage();
		inventorypage.DamageRetSupplier_Download_PDF();
	}
	@And("User clicks the Download button in DamageRetSupplier page after that click on close button")
	public void User_clicks_the_Download_in_DamageRetSupplier_page_after_that_click_on_close_button() throws Exception {
		inventorypage.Download_button_DamageRetSupplierpage();
		inventorypage.DamageRetSupplier_Download_popup_close();
	}
	@Then("The Download pop up get closed successfully and display the DamageRetSupplier list")
	public void The_Download_pop_up_get_closed_successfully_and_display_the_DamageRetSupplier_list() throws Exception {
		inventorypage.Download_popupclosd_displayed_DamageRetSupplier();
	}
    @And("Admin or user clicks the New Return button in DamageRetSupplier")
    public void Admin_or_user_clicks_the_New_Return_button_in_DamageRetSupplier() throws Exception{
		inventorypage.New_Return_Button_damageReturncount_supplier();
    }
    @And("Admin or user enters the all mandatory fields of DamageRetSupplier")
    public void Admin_or_user_enters_the_all_mandatory_fields_of_DamageRetSupplier() throws Exception{
		inventorypage.Enter_Mandatory_fieldsof_New_Return_DamageRetSupplier();
    }
    @And("Admin or user clicks the Add Return button DamageRetSupplier")
    public void Admin_or_user_clicks_the_Add_Return_button_DamageRetSupplier() throws Exception{
		inventorypage.Add_Return_button_DamageRetSupplier();
    }
	@Then("^Particular Damage Return received from Supplier gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Damage_Return_received_from_Supplier_gets_created_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = inventorypage.inventory_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin got the Damage Return received from Supplier gets created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@Then("^Particular DamageRetSupplier gets updated successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_DamageRetSupplier_gets_updated_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = inventorypage.inventory_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin got the purchase created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User click on DamageRetSupplier view option of kebab menu")
	public void User_click_on_DamageRetSupplier_view_option_of_kebab_menu() throws Exception {
		inventorypage.DamageRetSupplier_Viewclick_option();
	}
	@Then("Particular DamageRetSupplier viewed with details successfully")
	public void Particular_DamageRetSupplier_viewed_with_details_successfully() throws Exception {
		inventorypage.DamageRetSupplierView_display();
	}
	@And("User click on DamageRetSupplier Delete option in kebab menu and confirm Yes")
	public void User_click_on_DamageRetSupplier_Delete_option_in_kebab_menu_and_confirm_Yes() throws Exception {
		inventorypage.DamageRetSupplier_Deleteclick_option();
		inventorypage.DamageRetSupplier_Confirmed_Deleteclick_option();
	}
	@Then("^DamageRetSupplier deleted popup will be displayed successfully as \"([^\"]*)\"$")
	public void DamageRetSupplier_deleted_popup_will_be_displayed_successfully_as(String expectedMessage) throws Exception {
		  String actualMessage = inventorypage.inventory_create_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin Deleted DamageRetSupplier successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}
	@And("User click on second page button of DamageRetSupplier page")
	public void User_click_on_second_page_button_of_DamageRetSupplier_page() throws Exception {
		inventorypage.DamageRetSupplier_Second_page();
}
	@Then("Second page DamageRetSupplier get displayed successfully")
	public void Second_page_DamageRetSupplier_get_displayed_successfully() throws Exception {
		inventorypage.Second_page_DamageRetSupplier_Display();
}
	@And("Go to Next page of DamageRetSupplier page")
	public void Go_to_Next_page_of_DamageRetSupplier_page() throws Exception {
		inventorypage.DamageRetSupplier_next_page();
}
	@Then("Next page DamageRetSupplier get displayed successfully")
	public void Next_page_DamageRetSupplier_get_displayed_successfully() throws Exception {
}
	@And("Go to Previous page of DamageRetSupplier")
	public void Go_to_Previous_page_of_DamageRetSupplier_page() throws Exception {
		inventorypage.DamageRetSupplier_Previous_page();
}
	@Then("Previous page DamageRetSupplier get displayed successfully")
	public void Previous_page_DamageRetSupplier_get_displayed_successfully() throws Exception {
}
	@And("Go to Last page of DamageRetSupplier page")
	public void Go_to_Last_page_of_DamageRetSupplier_page() throws Exception {
		inventorypage.DamageRetSupplier_last_page();
}
	@Then("Last page DamageRetSupplier get displayed successfully")
	public void Last_page_DamageRetSupplier_get_displayed_successfully() throws Exception {
}
	@And("User click on first page button of DamageRetSupplier")
	public void User_click_on_first_page_button_of_DamageRetSupplier() throws Exception {
		inventorypage.First_page_DamageRetSupplier();
}
	@Then("First page DamageRetSupplier get displayed successfully")
	public void First_page_DamageRetSupplier_get_displayed_successfully() throws Exception {
}
	//<-------------------------------------------------Damage Received From Supplier------------------------------------------------------------->

	@And("Admin or user clicks the DamageRecSupplier Tab")
	public void Admin_or_user_clicks_the_DamageRecSupplier_Tab() throws Exception {
		inventorypage.DamageRecSupplier_page();
}
	@Then("DamageRecSupplier page should display successfully")
	public void DamageRecSupplier_page_should_display_successfully() throws Exception {
		inventorypage.DamageRecSupplier_page_Displayed();
}
		@And("Admin or user search a DamageRecSupplier")
	public void Admin_or_user_search_a_DamageRecSupplier() throws Exception {
		inventorypage.DamageRecSupplier_search_enter_text();
	}

	@Then("Searched DamageRecSupplier details get displayed successfully")
	public void Searched_DamageRecSupplier_details_get_displayed_successfully() {
		inventorypage.DamageRecSupplierSearchedList();
	}
	@And("Admin or user sort the DamageRecSupplier list recently updated")
	public void Admin_or_user_sort_the_DamageRecSupplier_list_recently_updated() throws Exception {
		inventorypage.DamageRecSupplier_sort_recentlyupdated();
	}

	@Then("Recently updated DamageRecSupplier list get displayed successfully")
	public void Recently_updated_DamageRecSupplier_list_get_displayed_successfully() throws Exception {
		inventorypage.DamageRecSupplier_list();
	}

	@And("User sort the DamageRecSupplier list Name A to Z")
	public void User_sort_the_DamageRecSupplier_list_Name_A_to_Z() throws Exception {
		inventorypage.DamageRecSupplier_sortA_Z();
	}

	@Then("DamageRecSupplier list get displayed successfully")
	public void DamageRecSupplier_list_get_displayed_successfully() throws Exception {
		inventorypage.DamageRecSupplier_list();
	}

	@And("User sort the DamageRecSupplier list Name Z to A")
	public void User_sort_the_DamageRecSupplier_list_Name_Z_to_A() throws Exception {
		inventorypage.DamageRecSupplier_sortZ_A();
	}

	@Then("DamageRecSupplier list Z to A get displayed successfully")
	public void DamageRecSupplier_list_Z_to_A_get_displayed_successfully() throws Exception {
		inventorypage.DamageRecSupplier_list();
	}

	@And("User sort the DamageRecSupplier list Recently Added")
	public void User_sort_the_DamageRecSupplier_list_Recently_Added() throws Exception {
		inventorypage.DamageRecSupplier_sort_recentlyadded();
	}

	@Then("Recent DamageRecSupplier list get displayed successfully")
	public void Recent_DamageRecSupplier_list_get_displayed_successfully() throws Exception {
		inventorypage.DamageRecSupplier_list();
	}
	@And("User sort the DamageRecSupplier list decending")
	public void User_sort_the_DamageRecSupplier_list_Decending() throws Exception {
		inventorypage.DamageRecSupplier_DecendingDate();
	}

	@Then("Decending DamageRecSupplier list get displayed successfully")
	public void Decending_DamageRecSupplier_list_get_displayed_successfully() throws Exception {
		inventorypage.DamageRecSupplier_list();
	}
	@And("User clicks the Download button in DamageRecSupplier page")
	public void User_clicks_the_Download_button_in_DamageRecSupplier_page() throws Exception {
		inventorypage.Download_button_DamageRecSupplierpage();
	}
	@Then("Download pop up of DamageRecSupplier will be displayed successfully")
	public void Download_pop_up_of_DamageRecSupplier_will_be_displayed_successfully() throws Exception {
		inventorypage.DamageRecSupplier_Download_popup_display();
	}
	@And("User clicks the Download button with Download As Excel of DamageRecSupplier list")
	public void User_clicks_the_Download_button_with_Download_As_Excel_of_DamageRecSupplier_list() throws Exception {
		inventorypage.Download_button_DamageRecSupplierpage();
		inventorypage.DamageRecSupplier_Download_Excel();
	}
	@And("User clicks the Download button with Download As PDF for DamageRecSupplier")
	public void User_clicks_the_Download_button_with_Download_As_PDF_for_DamageRecSupplier() throws Exception {
		inventorypage.Download_button_DamageRecSupplierpage();
		inventorypage.DamageRecSupplier_Download_PDF();
	}
	@And("User clicks the Download button in DamageRecSupplier page after that click on close button")
	public void User_clicks_the_Download_in_DamageRecSupplier_page_after_that_click_on_close_button() throws Exception {
		inventorypage.Download_button_DamageRecSupplierpage();
		inventorypage.DamageRecSupplier_Download_popup_close();
	}
	@Then("The Download pop up get closed successfully and display the DamageRecSupplier list")
	public void The_Download_pop_up_get_closed_successfully_and_display_the_DamageRecSupplier_list() throws Exception {
		inventorypage.Download_popupclosd_displayed_DamageRecSupplier();
	}
    @And("Admin or user clicks the New Replace button in DamageRecSupplier")
    public void Admin_or_user_clicks_the_New_Replace_button_in_DamageRecSupplier() throws Exception{
		inventorypage.New_Replace_Button_damageRec_supplier();
    }
    @And("Admin or user enters the all mandatory fields of DamageRecSupplier")
    public void Admin_or_user_enters_the_all_mandatory_fields_of_DamageRecSupplier() throws Exception{
		inventorypage.Enter_Mandatory_fieldsof_New_Replace_DamageRecSupplier();
    }
    @And("Admin or user clicks the Add Replace button DamageRecSupplier")
    public void Admin_or_user_clicks_the_Add_Replace_button_DamageRecSupplier() throws Exception{
		inventorypage.Add_Return_button_DamageRecSupplier();
    }
	@Then("^Particular Damage Replace received from Supplier gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Damage_Replace_received_from_Supplier_gets_created_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = inventorypage.inventory_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin got the Damage Return received from Supplier gets created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@Then("^Particular DamageRecSupplier gets updated successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_DamageRecSupplier_gets_updated_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = inventorypage.inventory_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin got the purchase created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User click on DamageRecSupplier view option of kebab menu")
	public void User_click_on_DamageRecSupplier_view_option_of_kebab_menu() throws Exception {
		inventorypage.DamageRecSupplier_Viewclick_option();
	}
	@Then("Particular DamageRecSupplier viewed with details successfully")
	public void Particular_DamageRecSupplier_viewed_with_details_successfully() throws Exception {
		inventorypage.DamageRecSupplierView_display();
	}
	@And("User click on DamageRecSupplier Delete option in kebab menu and confirm Yes")
	public void User_click_on_DamageRecSupplier_Delete_option_in_kebab_menu_and_confirm_Yes() throws Exception {
		inventorypage.DamageRecSupplier_Deleteclick_option();
		inventorypage.DamageRecSupplier_Confirmed_Deleteclick_option();
	}
	@Then("^DamageRecSupplier deleted popup will be displayed successfully as \"([^\"]*)\"$")
	public void DamageRecSupplier_deleted_popup_will_be_displayed_successfully_as(String expectedMessage) throws Exception {
		  String actualMessage = inventorypage.inventory_create_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin Deleted DamageRecSupplier successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}
	@And("User click on second page button of DamageRecSupplier page")
	public void User_click_on_second_page_button_of_DamageRecSupplier_page() throws Exception {
		inventorypage.DamageRecSupplier_Second_page();
}
	@Then("Second page DamageRecSupplier get displayed successfully")
	public void Second_page_DamageRecSupplier_get_displayed_successfully() throws Exception {
		inventorypage.Second_page_DamageRecSupplier_Display();
}
	@And("Go to Next page of DamageRecSupplier page")
	public void Go_to_Next_page_of_DamageRecSupplier_page() throws Exception {
		inventorypage.DamageRecSupplier_next_page();
}
	@Then("Next page DamageRecSupplier get displayed successfully")
	public void Next_page_DamageRecSupplier_get_displayed_successfully() throws Exception {
}
	@And("Go to Previous page of DamageRecSupplier")
	public void Go_to_Previous_page_of_DamageRecSupplier_page() throws Exception {
		inventorypage.DamageRecSupplier_Previous_page();
}
	@Then("Previous page DamageRecSupplier get displayed successfully")
	public void Previous_page_DamageRecSupplier_get_displayed_successfully() throws Exception {
}
	@And("Go to Last page of DamageRecSupplier page")
	public void Go_to_Last_page_of_DamageRecSupplier_page() throws Exception {
		inventorypage.DamageRecSupplier_last_page();
}
	@Then("Last page DamageRecSupplier get displayed successfully")
	public void Last_page_DamageRecSupplier_get_displayed_successfully() throws Exception {
}
	@And("User click on first page button of DamageRecSupplier")
	public void User_click_on_first_page_button_of_DamageRecSupplier() throws Exception {
		inventorypage.First_page_DamageRecSupplier();
}
	@Then("First page DamageRecSupplier get displayed successfully")
	public void First_page_DamageRecSupplier_get_displayed_successfully() throws Exception {
}
	//<----------------------------------Report Page-------------------------------------------------->
	@And("User click on Report page")
	public void User_click_on_Report_page() throws Exception {
		inventorypage.Reportpage();
}
	@Then("Report page should display successfully")
	public void Report_page_should_display_successfully() throws Exception {
		inventorypage.Report_page_Displayed();
}
	@And("User Generate Stock based Report")
	public void User_Generate_Stock_based_Report() throws Exception {
		inventorypage.Generate_Stock_Based_Report();
}
	@Then("Stock based Report should be download successfully")
	public void Stock_based_Report_should_be_download_successfully() throws Exception {
}
	//<-------------------------------------------------Stock Adjustments------------------------------------------------------------->

	@And("Admin or user clicks the Stock Adjustments Tab")
	public void Admin_or_user_clicks_the_Stock_Adjustments_Tab() throws Exception {
		inventorypage.Stock_Adjustments_page();
}
	@Then("Stock Adjustments page should display successfully")
	public void Stock_Adjustments_page_should_display_successfully() throws Exception {
		inventorypage.Stock_Adjustments_page_Displayed();
}
		@And("Admin or user search a Stock Adjustments")
	public void Admin_or_user_search_a_Stock_Adjustments() throws Exception {
		inventorypage.Stock_Adjustments_search_enter_text();
	}

	@Then("Searched Stock Adjustments details get displayed successfully")
	public void Searched_Stock_Adjustments_details_get_displayed_successfully() {
		inventorypage.Stock_AdjustmentsSearchedList();
	}
	@And("Admin or user sort the Stock Adjustments list recently updated")
	public void Admin_or_user_sort_the_Stock_Adjustments_list_recently_updated() throws Exception {
		inventorypage.Stock_Adjustments_sort_recentlyupdated();
	}

	@Then("Recently updated Stock Adjustments list get displayed successfully")
	public void Recently_updated_Stock_Adjustments_list_get_displayed_successfully() throws Exception {
		inventorypage.Stock_Adjustments_list();
	}

	@And("User sort the Stock Adjustments list Name A to Z")
	public void User_sort_the_Stock_Adjustments_list_Name_A_to_Z() throws Exception {
		inventorypage.Stock_Adjustments_sortA_Z();
	}

	@Then("Stock Adjustments list get displayed successfully")
	public void Stock_Adjustments_list_get_displayed_successfully() throws Exception {
		inventorypage.Stock_Adjustments_list();
	}

	@And("User sort the Stock Adjustments list Name Z to A")
	public void User_sort_the_Stock_Adjustments_list_Name_Z_to_A() throws Exception {
		inventorypage.Stock_Adjustments_sortZ_A();
	}

	@Then("Stock Adjustments list Z to A get displayed successfully")
	public void Stock_Adjustments_list_Z_to_A_get_displayed_successfully() throws Exception {
		inventorypage.Stock_Adjustments_list();
	}

	@And("User sort the Stock Adjustments list Recently Added")
	public void User_sort_the_Stock_Adjustments_list_Recently_Added() throws Exception {
		inventorypage.Stock_Adjustments_sort_recentlyadded();
	}

	@Then("Recent Stock Adjustments list get displayed successfully")
	public void Recent_Stock_Adjustments_list_get_displayed_successfully() throws Exception {
		inventorypage.Stock_Adjustments_list();
	}
	@And("User sort the Stock Adjustments list decending")
	public void User_sort_the_Stock_Adjustments_list_Decending() throws Exception {
		inventorypage.Stock_Adjustments_DecendingDate();
	}

	@Then("Decending Stock Adjustments list get displayed successfully")
	public void Decending_Stock_Adjustments_list_get_displayed_successfully() throws Exception {
		inventorypage.Stock_Adjustments_list();
	}

    @And("Admin or user clicks the New Stock Adjustments button")
    public void Admin_or_user_clicks_the_New_Stock_Adjustments_button() throws Exception{
		inventorypage.New_Stock_Adjustment_Button();
    }
    @And("Admin or user enters the all mandatory fields of Stock Adjustments")
    public void Admin_or_user_enters_the_all_mandatory_fields_of_Stock_Adjustments() throws Exception{
		inventorypage.Enter_Mandatory_fieldsof_Stock_Adjustments();
    }
    @And("Admin or user clicks the Add Stock Adjustment button")
    public void Admin_or_user_clicks_the_Add_Stock_Adjustment_button() throws Exception{
		inventorypage.Add_Stock_Adjustments_Button();
    }
	@Then("^Particular Stock Adjustment gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Stock_Adjustment_gets_created_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = inventorypage.inventory_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin Stock Adjustment gets created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@Then("^Particular Stock Adjustments gets updated successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Stock_Adjustments_gets_updated_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = inventorypage.inventory_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin got the purchase created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User click on Stock Adjustments view option of kebab menu")
	public void User_click_on_Stock_Adjustments_view_option_of_kebab_menu() throws Exception {
		inventorypage.Stock_Adjustments_Viewclick_option();
	}
	@Then("Particular Stock Adjustments viewed with details successfully")
	public void Particular_Stock_Adjustments_viewed_with_details_successfully() throws Exception {
		inventorypage.Stock_AdjustmentsView_display();
	}
	@And("User click on Stock Adjustments Delete option in kebab menu and confirm Yes")
	public void User_click_on_Stock_Adjustments_Delete_option_in_kebab_menu_and_confirm_Yes() throws Exception {
		inventorypage.Stock_Adjustments_Deleteclick_option();
		inventorypage.Stock_Adjustments_Confirmed_Deleteclick_option();
	}
	@Then("^Stock Adjustments deleted popup will be displayed successfully as \"([^\"]*)\"$")
	public void Stock_Adjustments_deleted_popup_will_be_displayed_successfully_as(String expectedMessage) throws Exception {
		  String actualMessage = inventorypage.inventory_create_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin Deleted Stock Adjustments successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}
	@And("User click on second page button of Stock Adjustments page")
	public void User_click_on_second_page_button_of_Stock_Adjustments_page() throws Exception {
		inventorypage.Stock_Adjustments_Second_page();
}
	@Then("Second page Stock Adjustments get displayed successfully")
	public void Second_page_Stock_Adjustments_get_displayed_successfully() throws Exception {
		inventorypage.Second_page_Stock_Adjustments_Display();
}
	@And("Go to Next page of Stock Adjustments page")
	public void Go_to_Next_page_of_Stock_Adjustments_page() throws Exception {
		inventorypage.Stock_Adjustments_next_page();
}
	@Then("Next page Stock Adjustments get displayed successfully")
	public void Next_page_Stock_Adjustments_get_displayed_successfully() throws Exception {
}
	@And("Go to Previous page of Stock Adjustments")
	public void Go_to_Previous_page_of_Stock_Adjustments_page() throws Exception {
		inventorypage.Stock_Adjustments_Previous_page();
}
	@Then("Previous page Stock Adjustments get displayed successfully")
	public void Previous_page_Stock_Adjustments_get_displayed_successfully() throws Exception {
}
	@And("Go to Last page of Stock Adjustments page")
	public void Go_to_Last_page_of_Stock_Adjustments_page() throws Exception {
		inventorypage.Stock_Adjustments_last_page();
}
	@Then("Last page Stock Adjustments get displayed successfully")
	public void Last_page_Stock_Adjustments_get_displayed_successfully() throws Exception {
}
	@And("User click on first page button of Stock Adjustments")
	public void User_click_on_first_page_button_of_Stock_Adjustments() throws Exception {
		inventorypage.First_page_Stock_Adjustments();
}
	@Then("First page Stock Adjustments get displayed successfully")
	public void First_page_Stock_Adjustments_get_displayed_successfully() throws Exception {
}
	@And("User filter the Stock adjustment list stock code")
	public void User_filter_the_Stock_adjustment_list_stock_code() throws Exception {
		inventorypage.Stock_code_filter();
}
	@Then("Filtered stock code list get displayed successfully")
	public void Filtered_stock_code_list_get_displayed_successfully() throws Exception {
		inventorypage.Stockadjustment_filtered_result_display();
}
	@And("User filter the Stock Adjustment list Credit Type PLUS")
	public void User_filter_the_Stock_adjustment_list_Credit_Type_PLUS() throws Exception {
		inventorypage.Credit_Type_PLUS_filter();
}
	@Then("Filtered Credit Type PLUS list get displayed successfully")
	public void Filtered_Credit_Type_PLUS_list_get_displayed_successfully() throws Exception {
		inventorypage.Stockadjustment_filtered_result_display();
}
	@And("User filter the Stock Adjustment list Credit Type MINUS")
	public void User_filter_the_Stock_adjustment_list_Credit_Type_MINUS() throws Exception {
		inventorypage.Credit_Type_MINUS_filter();
}
	@Then("Filtered Credit Type MINUS list get displayed successfully")
	public void Filtered_Credit_Type_MINUS_list_get_displayed_successfully() throws Exception {
		inventorypage.Stockadjustment_filtered_result_display();
}
	@And("User filter the Stock Adjustments list Created By")
	public void User_filter_the_Stock_adjustment_list_Created_By() throws Exception {
		inventorypage.Created_BY_filter();
}
	@Then("Filtered Created By Stock Adjustments list get displayed successfully")
	public void Filtered_Created_By_Stock_Adjustments_list_get_displayed_successfully() throws Exception {
		inventorypage.Stockadjustment_filtered_result_display();
}
	@And("User clicks reset button of filter")
	public void User_clicks_reset_button_of_filter() throws Exception {
		inventorypage.Reset_button();
}
	@Then("Filters should be got Reset and Stock Adjustment list get displayed successfully")
	public void Filters_should_be_got_Reset_and_Stock_Adjustment_list_get_displayed_successfully() throws Exception {
		inventorypage.Stockadjustment_filtered_result_display();
}
}
