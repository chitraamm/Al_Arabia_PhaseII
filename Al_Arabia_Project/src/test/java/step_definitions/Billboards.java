package test.java.step_definitions;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Billboardspage;
import pageobjects.Signinpage;
import resources.Base;

public class Billboards extends Base {

	private static Logger LOGGER = LogManager.getLogger(Billboards.class);
    private final Billboardspage billboardsPage;

	public Billboards(Testhooks testhooks) throws Exception {
        WebDriver driver = testhooks.getDriver();
		this.billboardsPage = new Billboardspage(driver);
		new Signinpage(driver);
		LOGGER = LogManager.getLogger(Billboards.class.getName());
	}

	@And("Admin or user clicks the billboards module")
	public void Admin_or_user_clicks_the_billboards_module() throws Exception {
		billboardsPage.billboardClick();
	}

	@Then("Al-Arabia billboards dashboard should display successfully")
	public void Al_Arabia_members_dashboard_should_display_successfully() throws Exception {
		billboardsPage.allBillboardsCount();
		LOGGER.info(">> Admin/user got the billboards page >>");
	}

	@And("Admin or user clicks the new billboard button")
	public void Admin_or_user_clicks_the_new_billboard_button() throws Exception {
		billboardsPage.New_billboardClick();
	}

	@And("Admin or user enters the all new billboard mandatory fields")
	public void Admin_or_user_enters_the_all_new_billboard_mandatory_fields() throws Exception {
		billboardsPage.NewBillboard_mandatory_fields_enter();
	}

	@And("Admin or user clicks the create billboard")
	public void Admin_or_user_clicks_the_create_billboard() throws Exception {
		billboardsPage.Newbillboard_create_BB_btn();
	}

	@Then("The billboard should created and displayed in billboard dashboard successfully")
	public void The_billboard_should_created_and_displayed_in_billboard_dashboard_successfully() throws Exception {
		billboardsPage.New_billboard_display();
	}

	@And("Admin or user search the billboards")
	public void Admin_or_user_search_the_billboards() throws Exception {
		billboardsPage.Billboard_search_enter_text();
	}

	@Then("Searched Billboard details get displayed successfully")
	public void Searched_Billboard_details_get_displayed_successfully() {
		billboardsPage.BBSearchedList();
	}

	public void Particular_billboard_gets_created_successfully_with_either(String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = billboardsPage.billboard_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);

		System.out.println(">> User or Admin got the billboard created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	private String normalizeWhitespace(String input) {
		return input.replaceAll("\\s+", " ").trim();
	}
	@And("Admin or user sort the billboards list recently updated")
	public void Admin_or_user_sort_the_billboards_list_recently_updated() throws Exception {
		billboardsPage.Billboards_sort_recentlyupdated();
	}
	@Then("Recently updated billboards list get displayed successfully")
	public void Recently_updated_billboards_list_get_displayed_successfully() throws Exception {
		billboardsPage.BBlist();
	}
	@And("User sort the billboards list Name A to Z")
	public void User_sort_the_billboards_list_Name_A_to_Z() throws Exception {
		billboardsPage.BB_A_to_Z();
	}
	@Then("billboards list get displayed successfully")
	public void billboards_list_get_displayed_successfully() throws Exception {
		billboardsPage.BBlist();
	}
	@And("User sort the billboards list Name Z to A")
	public void User_sort_the_billboards_list_Name_Z_to_A() throws Exception {
		billboardsPage.Billboard_sortZ_A();
	}
	@Then("billboards list Z to A get displayed successfully")
	public void billboards_list_Z_to_A_get_displayed_successfully() throws Exception {
		billboardsPage.BBlist();
	}
	@And("User sort the billboards list Recently Added")
	public void User_sort_the_billboards_list_Recently_Added() throws Exception {
		billboardsPage.Billboards_sort_recentlyadded();
	}
	@Then("Recent billboards list get displayed successfully")
	public void Recent_billboards_list_get_displayed_successfully() throws Exception {
		billboardsPage.BBlist();
	}
	@And("User sort the billboards list decending")
	public void User_sort_the_billboards_list_decending() throws Exception {
		billboardsPage.DecendingDate();
	}
	@Then("Decending billboards list get displayed successfully")
	public void Decending_billboards_list_get_displayed_successfully() throws Exception {
		billboardsPage.BBlist();
	}
	@And("User filter the billboards list status Active")
	public void User_filter_the_billboards_list_status_Active() throws Exception {
		billboardsPage.BB_filter_active();
	}
	@Then("Active billboards list get displayed successfully")
	public void Active_billboards_list_get_displayed_successfully() throws Exception {
		billboardsPage.BB_filtered_result_display();
	}
	@And("User filter the billboards list status Non Oper")
	public void User_filter_the_billboards_list_status_Non_Oper() throws Exception {
		billboardsPage.Nonoper();
	}
	@Then("Non Oper billboards list get displayed successfully")
	public void Non_Oper_billboards_list_get_displayed_successfully() throws Exception {
		billboardsPage.BB_filtered_result_display();
	}
	@And("User filter the billboards list status Request")
	public void And_User_filter_the_billboards_list_status_Request() throws Exception {
		billboardsPage.BB_filter_Request_list();
	}
	@Then("Request billboards list get displayed successfully")
	public void Request_billboards_list_get_displayed_successfully() throws Exception {
		billboardsPage.BB_filtered_result_display();
	}
	@And("User selects billboard location")
	public void User_selects_billboard_location() throws Exception {
	    billboardsPage.select_bb_location();
}
	@And("User selects billboard location32")
	public void User_selects_billboard_location32() throws Exception {
	    billboardsPage.select_bb_location32();
}
	@And("User filter the billboards list status Active32")
	public void User_filter_the_billboards_list_status_Active32() throws Exception {
	    billboardsPage.BB_filter_active_32();
}
	@Then("Selected location billboards list get displayed successfully")
	public void Selected_location_billboards_list_get_displayed_successfully () throws Exception {
	    billboardsPage.BB_filtered_result_display();
	}	
	@And("User filter the billboards ticket count")
	public void User_filter_the_billboards_ticket_count () throws Exception {
	    billboardsPage.BB_filter_ticketcount_enter();
	}	
	@Then("ticket count billboards list get displayed successfully")
	public void ticket_count_billboards_list_get_displayed_successfully () throws Exception {
	    billboardsPage.BB_filtered_result_display();
	}	
	@And("User filter the Billboard Type")
	public void User_filter_the_Billboard_Type () throws Exception {
	    billboardsPage.select_bb_Type();
	}	
	@Then("Billboard type billboards list get displayed successfully")
	public void Billboard_type_billboards_list_get_displayed_successfully () throws Exception {
	    billboardsPage.BB_filtered_result_display();
	}
	@And("User filter the billboards Online Team viewer Novastar IVMS")
	public void User_filter_the_billboards_Online_Team_viewer_Novastar_IVMS () throws Exception {
	    billboardsPage.BB_filter_onlinestatus();
	}
	@Then("Online billboards list get displayed successfully for Team viewer Novastar IVMS")
	public void Online_billboards_list_get_displayed_successfully_for_Team_viewer_Novastar_IVMS () throws Exception {
	    billboardsPage.BB_filtered_result_display();
	}
	@And("User filter the billboards Offline Team viewer Novastar IVMS")
	public void User_filter_the_billboards_Offline_Team_viewer_Novastar_IVMS () throws Exception {
	    billboardsPage.BB_filter_offlinestatus();
	}
	@And("User filter the billboards Offline Team viewer Novastar IVMS with installed")
	public void User_filter_the_billboards_Offline_Team_viewer_Novastar_IVMS_installed () throws Exception {
	    billboardsPage.BB_filter_offline_installed();
	}
	@Then("Offline billboards list get displayed successfully for Team viewer Novastar IVMS")
	public void Offline_billboards_list_get_displayed_successfully_for_Team_viewer_Novastar_IVMS () throws Exception {
	    billboardsPage.BB_filtered_result_display();
	}
	@And("User filter the billboards installed IVMS and Novastar")
	public void User_filter_the_billboards_installed_IVMS_and_Novastar  () throws Exception {
	    billboardsPage.BB_filter_installedstatus();
	}
	@Then("installed billboards list get displayed successfully for IVMS and Novastar")
	public void installed_billboards_list_get_displayed_successfully_for_IVMS_and_Novastar () throws Exception {
	    billboardsPage.BB_filtered_result_display();
}
	@And("User filter the billboards Not installed IVMS and Novastar")
	public void User_filter_the_billboards_Not_installed_IVMS_and_Novastar  () throws Exception {
	    billboardsPage.BB_filter_Not_installedstatus();
	}
	@Then("Not installed billboards list get displayed successfully for IVMS and Novastar")
	public void Not_installed_billboards_list_get_displayed_successfully_for_IVMS_and_Novastar () throws Exception {
	    billboardsPage.BB_filtered_result_display();
}
	
	@And("User filter the billboards installed IVMS and Novastar with online")
	public void User_filter_the_billboards_installed_IVMS_and_Novastar_with_online() throws Exception {
	    billboardsPage.BB_filter_online_installed();
}
	@Then("Online and installed status billboards list get displayed successfully for IVMS and Novastar")
	public void Online_and_installed_status_billboards_list_get_displayed_successfully_for_IVMS_and_Novastar () throws Exception {
	    billboardsPage.BB_filtered_result_display();
}
	@Then("Offline and installed status billboards list get displayed successfully for IVMS and Novastar")
	public void Offline_and_installed_status_billboards_list_get_displayed_successfully_for_IVMS_and_Novastar () throws Exception {
	    billboardsPage.BB_filtered_result_display();
}
	@And("User filter the billboards Online Team viewer Novastar IVMS with Not installed")
	public void User_filter_the_billboards_Online_Team_viewer_Novastar_IVMS_with_Not_installed() throws Exception {
	    billboardsPage.BB_filter_online_Not_installed();
}
	@Then("Online and Not installed status billboards list get displayed successfully for IVMS and Novastar")
	public void Online_and_Not_installed_status_billboards_list_get_displayed_successfully_for_IVMS_and_Novastar () throws Exception {
	    billboardsPage.BB_filtered_result_display();
}
	@And("User filter the billboards Offline Team viewer Novastar IVMS with Not installed")
	public void User_filter_the_billboards_Offline_Team_viewer_Novastar_IVMS_with_Not_installed() throws Exception {
	    billboardsPage.BB_filter_offline_Not_installed();
}
	@Then("Offline and Not installed status billboards list get displayed successfully for IVMS and Novastar")
	public void Offline_and_Not_installed_status_billboards_list_get_displayed_successfully_for_IVMS_and_Novastar () throws Exception {
	    billboardsPage.BB_filtered_result_display();
}
	@And("User filter the Screen resolution drop down")
	public void User_filter_the_Screen_resolution_drop_down() throws Exception {
	    billboardsPage.BB_filter_Screen_Resolution();
}
	@Then("Screen resolution billboards list get displayed successfully")
	public void Screen_resolution_billboards_list_get_displayed_successfully () throws Exception {
	    billboardsPage.BB_filtered_result_display();
}
	@And("User clicks Download button") 
	public void User_clicks_Download_button() throws Exception {
	    billboardsPage.BB_Download_popup();
}
	@Then("Download pop up displayed successfully")
	public void Download_pop_up_displayed_successfully () throws Exception {
	    billboardsPage.BB_Download_popup_display();
}
	@And("User clicks Download button with Download As Excel")
	public void User_clicks_Download_button_with_Download_As_Excel() throws Exception {
		billboardsPage.BB_Download_popup();
		billboardsPage.BB_Download_excel();
}
	@And("Excel file will be downloaded successfully as")
	public void Excel_file_will_be_downloaded_successfully () throws Exception {
	    billboardsPage.BB_Download_popup_display();
}	
	@Then("^Excel file will be downloaded successfully as \"([^\"]*)\"$")
  public void Excel_file_will_be_downloaded_successfully(String expectedMessage) throws Exception {
      String actualMessage = billboardsPage.billboard_created_Success_display();
      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
      String normalizedActualMessage = normalizeWhitespace(actualMessage);
      System.out.println(">> User or Admin got the BB excel downloaded successfully"+actualMessage);
      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
  }
	@And("User clicks Download button with Download As PDF")
	public void User_clicks_Download_button_with_Download_As_PDF() throws Exception {
		billboardsPage.BB_Download_popup();
		billboardsPage.BB_Download_PDF();
}
	@And("PDF file will be downloaded successfully as")
	public void PDF_file_will_be_downloaded_successfully () throws Exception {
	    billboardsPage.BB_Download_popup_display();
}
	@Then("^PDF file will be downloaded successfully as \"([^\"]*)\"$")
	  public void PDF_file_will_be_downloaded_successfully(String expectedMessage) throws Exception {
	      String actualMessage = billboardsPage.billboard_created_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin got the BB PDF downloaded successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	  }
	@And("User clicks Download button with Download As QR Code")
	public void User_clicks_Download_button_with_Download_As_QR_Code() throws Exception {
		billboardsPage.BB_Download_popup();
		billboardsPage.BB_Download_QR_Code_file();
}
	@And("QR Code file will be downloaded successfully as")
	public void QR_Code_file_will_be_downloaded_successfully () throws Exception {
	    billboardsPage.BB_Download_popup_display();
}
	@Then("^QR file will be downloaded successfully as \"([^\"]*)\"$")
	  public void QR_Code_file_will_be_downloaded_successfully(String expectedMessage) throws Exception {
	      String actualMessage = billboardsPage.billboard_created_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin got the QR code file downloaded successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	  }
	@And("User clicks Download button after that click on close button")
	public void User_clicks_Download_button_after_that_click_on_close_button() throws Exception {
		billboardsPage.BB_Download_popup();
		billboardsPage.BB_Download_popup_close();
}
	@Then("Download pop up get closed successfully and display the Billboard list")
	public void Download_pop_up_get_closed_successfully_and_display_the_Billboard_list () throws Exception {
	    billboardsPage.BB_Download_popupclosd_displayed_Billboards();
}
	@And("User clicks the Edit button")
	public void User_clicks_the_Edit_button() throws Exception {
		billboardsPage.BB_Edit_icon();
}
	@Then("Edit BillBoard page will be displayed successfully")
	public void Edit_BillBoard_page_will_be_displayed_successfully () throws Exception {
	    billboardsPage.BB_Edit_page();
}
	@And("User clicks on the Plus button")
	public void User_clicks_on_the_Plus_button() throws Exception {
		billboardsPage.plus_icon_click();
}
	@Then("BillBoard View page will be displayed successfully")
	public void BillBoard_View_page_will_be_displayed_successfully () throws Exception {
	    billboardsPage.BB_View_page();
	}	    
	@And("User clicks on the Delete button with clicks confirm yes button")
	public void User_clicks_on_the_Delete_button_with_clicks_confirm_yes_button() throws Exception {
		billboardsPage.BB_Delete_icon();
		billboardsPage.BB_delete_popup_confirmed();
}
	@Then("^BillBoard delete popup will be displayed successfully as \"([^\"]*)\"$")
	public void BillBoard_delete_popup_will_be_displayed_successfully (String expectedMessage) throws Exception {
		  String actualMessage = billboardsPage.billboard_created_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin got the QR code file downloaded successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}	
	@Then("User click on the Billboard location text")
	public void User_click_on_the_Billboard_location_text () throws Exception {
	    billboardsPage.BB_location_click();
	}	    
	@And("User edit screen height")
	public void User_edit_screen_height () throws Exception {
		billboardsPage.BB_edit_screen_height();
}
	@And("User click on Update BillBoard button with confirm yes button")
	public void User_click_on_Update_BillBoard_button_with_confirm_yes_button() throws Exception {
		billboardsPage.BB_update_clicked();
		billboardsPage.BB_update_confirmed();
}
	@Then("^BillBoard Updated popup will be displayed successfully as \"([^\"]*)\"$")
	public void BillBoard_Updated_popup_will_be_displayed_successfully_as_(String expectedMessage) throws Exception {
		  String actualMessage = billboardsPage.billboard_created_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin got the QR code file downloaded successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}
	@And("User click on BOM Tab")
	public void User_click_on_BOM_Tab () throws Exception {
		billboardsPage.BB_editpage_BOM();
}
	@And("BOM details of BillBoard will be display successfully")
	public void BOM_details_of_BillBoard_will_be_display_successfully () throws Exception {
		billboardsPage.BB_editpage_BOMdisplay();
}
	@And("User click on Download PDF button and will be downloaded the PDF file of BOM")
	public void User_click_on_Download_PDF_button_and_will_be_downloaded_the_PDF_file_of_BOM () throws Exception {
		billboardsPage.BB_BOMDetails_Download_PDF();
}
	@And("User click on Download QR code icon")
	public void User_click_on_Download_QR_code_icon () throws Exception {
		billboardsPage.BB_editpage_BOMTab_QRcode();
}
	@And("BillBoard QR code will be displayed sucessfully")
	public void BillBoard_QR_code_will_be_displayed_sucessfully () throws Exception {
		billboardsPage.BB_editpage_BOMTab_QRcodedisplay();
}
	@And("User clicks on Mark it as non operational and click yes mark it")
	public void User_clicks_on_Mark_it_as_non_operational_and_click_yes_mark_it () throws Exception {
		billboardsPage.BB_Mark_it_as_nonoperational();
		billboardsPage.BB_Mark_it_as_nonoperational_confirmed();
	}	
      @And("User Mark it as non operational and Added the reason")
	  public void User_Mark_it_as_non_operational_and_Added_the_reason () throws Exception {	
		
		billboardsPage.BB_Mark_it_as_nonoperational();
		billboardsPage.BB_Mark_it_as_nonoperational_confirmed();
		billboardsPage.BB_non_operatnl_reason_added();
		billboardsPage.BB_clicked_reason_button();	
}
  	@Then("^reason added popup will be displayed successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
  	public void reason_added_popup_will_be_displayed_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = billboardsPage.billboard_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);

		System.out.println(">> User or Admin got the ticket cerified success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User click on second page button of billboards")
	public void User_click_on_second_page_button_of_billboards () throws Exception {
		billboardsPage.Second_page();
}
	@Then("Second page billboards get displayed successfully")
	public void Second_page_billboards_get_displayed_successfully () throws Exception {
		billboardsPage.Second_page_Display();
}
	@And("Go to Next page of billboards page")
	public void Go_to_Next_page_of_billboards_page() throws Exception {
		billboardsPage.next_page();
}
	@Then("Next page billboards get displayed successfully")
	public void Next_page_billboards_get_displayed_successfully() throws Exception {
}
	@And("Go to Previous page of billboards page")
	public void Go_to_Previous_page_of_billboards_page() throws Exception {
		billboardsPage.Previous_page();
}
	@Then("Previous page billboards get displayed successfully")
	public void Previous_page_billboards_get_displayed_successfully() throws Exception {
}
	@And("Go to Last page of billboards page")
	public void Go_to_Last_page_of_billboards_page() throws Exception {
		billboardsPage.last_page();
}
	@Then("Last page billboards get displayed successfully")
	public void Last_page_billboards_get_displayed_successfully() throws Exception {
}
	@And("User click on first page button of billboards")
	public void User_click_on_first_page_button_of_billboards() throws Exception {
		billboardsPage.First_page();
}
	@Then("First page billboards get displayed successfully")
	public void First_page_billboards_get_displayed_successfully() throws Exception {
}
	@And("User filter the billboards list status Pending")
	public void User_filter_the_billboards_list_status_Pending() throws Exception {
		billboardsPage.Pending_Billboards();
	}
	@Then("Pending billboards list get displayed successfully")
	public void Pending_billboards_list_get_displayed_successfully() throws Exception {
		billboardsPage.BB_filtered_result_display();
	}
	@And("User click on Approve button and confirmed")
	public void User_click_on_Approve_button_and_confirmed() throws Exception {
		billboardsPage.Approve_for_non_operational_Billboards();
		billboardsPage.approve_non_operational_confirmed();
	}
	@And("User clicks the Edit button of pending BillBoards")
	public void User_clicks_the_Edit_button_of_pending_BillBoards() throws Exception {
		billboardsPage.BB_Edit_pending_icon();
	}
	@Then("^Billboard marked as Approved popup will be display successfully as \"([^\"]*)\"$")
	public void Billboard_marked_as_Approved_popup_will_be_display_successfully_as_(String expectedMessage)throws Exception {
	      String actualMessage = billboardsPage.billboard_created_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin got the BB PDF downloaded successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	  }
	@And("User click on Reject button and confirmed")
	public void User_click_on_Reject_button_and_confirmed() throws Exception {
		billboardsPage.Reject_for_non_operational_Billboards();
		billboardsPage.reject_non_operational_confirmed();
	}
	@Then("^Billboard marked as Reject popup will be display successfully as \"([^\"]*)\"$")
	public void Billboard_marked_as_Reject_popup_will_be_display_successfully_as_(String expectedMessage)throws Exception {
	      String actualMessage = billboardsPage.billboard_created_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin got the BB PDF downloaded successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	  }
	@And("User enters mandatory fields of new ticket")
	public void User_enters_mandatory_fields_of_new_ticket() throws Exception {
		billboardsPage.Mandatory_fields_newticket();
	}
	@And("User clicks the create Ticket")
	public void User_clicks_the_create_Ticket() throws Exception {
		billboardsPage.NewTicket_create_btn();
	}
	@Then("^Ticket gets created from Add BillBoards page successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Ticket_gets_created_from_Add_BillBoards_page_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = billboardsPage.ticket_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);

		System.out.println(">> User or Admin got the ticket cerified success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
//	private String normalizeWhitespace(String input) {
//		return input.replaceAll("\\s+", " ").trim();
//	}
	@And("User clicks on the View Ticket Tab")
	public void User_clicks_on_the_View_Ticket_Tab() throws Exception {
		billboardsPage.View_ticketBB();
	}
	@Then("View Ticket page will be displayed successfully")
	public void View_Ticket_page_will_be_displayed_successfully() throws Exception {
		billboardsPage.View_ticketBB_display();
	}
	@And("User clicks on the Activity Feed Tab")
	public void User_clicks_on_the_Activity_Feed_Tab() throws Exception {
		billboardsPage.Activity_FeedBB();
	}
	@Then("Activity Feed page will be displayed successfully")
	public void Activity_page_will_be_displayed_successfully() throws Exception {
		billboardsPage.Activity_FeedBB_display();
	}
	@And("User filter the billboards Faulty")
	public void User_filter_the_billboards_Faulty() throws Exception {
		billboardsPage.Faulty_status();
	}
	@Then("Faulty billboards list get displayed successfully")
	public void Faulty_billboards_list_get_displayed_successfully() throws Exception {
		billboardsPage.BB_filtered_result_display();
	}
	@And("User filter the billboards Alarm")
	public void User_filter_the_billboards_Alarm() throws Exception {
		billboardsPage.Alarm_status();
	}
	@Then("Alarm billboards list get displayed successfully")
	public void Alarm_billboards_list_get_displayed_successfully() throws Exception {
		billboardsPage.BB_filtered_result_display();
	}
}