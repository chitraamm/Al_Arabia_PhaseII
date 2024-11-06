package Stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
//import pageobjects.Signinpage;
import pageobjects.Ticketspage;
import resources.Base;

public class Tickets extends Base {
	
	private static Logger LOGGER = LogManager.getLogger(Tickets.class);
	private WebDriver driver;
	private Ticketspage ticketsPage;

	public Tickets(Testhooks testhooks) throws Exception {
		this.driver = testhooks.getDriver(); 
		this.ticketsPage = new Ticketspage(driver);
		//new Signinpage(driver);
		LOGGER = LogManager.getLogger(Tickets.class.getName());
	}
	 
	@And("Admin or user clicks the Tickets module")
	public void Admin_or_user_clicks_the_Tickets_module() throws Exception {
		ticketsPage.Tickets_click();
	}

	@Then("Al-Arabia Tickets page should display successfully")
	public void Al_Arabia_Tickets_page_should_display_successfully() throws Exception {
		ticketsPage.allticketsCount();
		LOGGER.info(">> Admin/user got the Tickets page >>");
	}
	
	@And("Admin or user clicks the new Ticket button")
	public void Admin_or_user_clicks_the_new_Ticket_button() throws Exception {
		ticketsPage.New_TicketClick();
	}

	@And("Admin or user enters the all mandatory fields")
	public void Admin_or_user_enters_the_all_mandatory_fields() throws Exception {
		ticketsPage.NewTicket_mandatory_fields_enter();
	}
	@And("Admin or user clicks the create Ticket")
	public void Admin_or_user_clicks_the_create_Ticket() throws Exception {
		ticketsPage.NewTicket_create_btn();
	}

	@Then("^Particular Ticket gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_Ticket_gets_created_successfully_with_either (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = ticketsPage.ticket_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);

		System.out.println(">> User or Admin got the ticket cerified success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	private String normalizeWhitespace(String input) {
		return input.replaceAll("\\s+", " ").trim();
	}
	@And("Admin or user search the Tickets")
	public void Admin_or_user_search_the_Tickets() throws Exception {
		ticketsPage.Ticket_search_enter_text();
	}

	@Then("Searched Ticket details get displayed successfully")
	public void Searched_Ticket_details_get_displayed_successfully() {
		ticketsPage.TicketSearchedList();
	}
	@And("Admin or user sort the Tickets list recently updated")
	public void Admin_or_user_sort_the_Tickets_list_recently_updated() throws Exception {
		ticketsPage.Tickets_sort_recentlyupdated();
	}

	@Then("Recently updated Tickets list get displayed successfully")
	public void Recently_updated_Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Ticketlist();
	}

	@And("User sort the Tickets list Name A to Z")
	public void User_sort_the_Tickets_list_Ticket_Name_A_to_Z() throws Exception {
		ticketsPage.Ticket_A_to_Z();
	}

	@Then("Tickets list get displayed successfully")
	public void Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Ticketlist();
	}

	@And("User sort the Tickets list Name Z to A")
	public void User_sort_the_Tickets_list_Name_Z_to_A() throws Exception {
		ticketsPage.Ticket_sortZ_A();
	}

	@Then("Tickets list Z to A get displayed successfully")
	public void Tickets_list_Z_to_A_get_displayed_successfully() throws Exception {
		ticketsPage.Ticketlist();
	}

	@And("User sort the Tickets list Recently Added")
	public void User_sort_the_Tickets_list_Recently_Added() throws Exception {
		ticketsPage.Tickets_sort_recentlyadded();
	}

	@Then("Recent Tickets list get displayed successfully")
	public void Recent_Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Ticketlist();
	}
	@And("User sort the Tickets list decending")
	public void User_sort_the_Tickets_list_Decending() throws Exception {
		ticketsPage.Ticket_DecendingDate();
	}

	@Then("Decending Tickets list get displayed successfully")
	public void Decending_Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Ticketlist();
	}
	@And("User filter the Tickets list status Closed")
	public void User_filter_the_Tickets_list_status_Closed() throws Exception {
		ticketsPage.Tickets_status_closed();
	}
	@Then("Closed Tickets list get displayed successfully")
	public void Closed_Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	@And("User filter the Tickets list status Created")
	public void User_filter_the_Tickets_list_status_Created() throws Exception {
		ticketsPage.Tickets_status_created();
	}
	@Then("Created Tickets list get displayed successfully")
	public void Created_Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	@And("User filter the Tickets list status Reassigned")
	public void User_filter_the_Tickets_list_status_Reassigned() throws Exception {
		ticketsPage.Tickets_status_Reassigned();
	}
	@Then("Reassigned Tickets list get displayed successfully")
	public void Reassigned_Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	@And("User filter the Tickets list status Submitted")
	public void User_filter_the_Tickets_list_status_Submitted() throws Exception {
		ticketsPage.Tickets_status_Submitted();
	}
	@Then("Submitted Tickets list get displayed successfully")
	public void Submitted_Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	
	@And("User filter the Tickets list status Viewed")
	public void User_filter_the_Tickets_list_status_Viewed() throws Exception {
		ticketsPage.Tickets_status_Viewed();
	}
	@Then("Viewed Tickets list get displayed successfully")
	public void Viewed_Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	@And("User filter the Tickets list status Verified")
	public void User_filter_the_Tickets_list_status_Verified() throws Exception {
		ticketsPage.Tickets_status_Verified();
	}
	@Then("Verified Tickets list get displayed successfully")
	public void Verified_Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	@And("User filter the Tickets list status Overdue")
	public void User_filter_the_Tickets_list_status_Overdue() throws Exception {
		ticketsPage.Tickets_status_Overdue();
	}
	@Then("Overdue Tickets list get displayed successfully")
	public void Overdue_Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	@And("User selects billboard number")
	public void User_selects_billboard_number() throws Exception {
		ticketsPage.select_BB_Number();
	}
	@Then("Selected BillBoard number list get displayed successfully")
	public void Selected_BillBoard_number_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	@And("User selects Assignee")
	public void User_selects_Assignee() throws Exception {
		ticketsPage.select_Assignee();
	}
	@Then("Selected Assignee list get displayed successfully")
	public void Selected_Assignee_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	@And("User selects city")
	public void User_selects_city() throws Exception {
		ticketsPage.select_City();
	}
	@Then("Selected city list get displayed successfully")
	public void Selected_city_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	@And("User selects Department")
	public void User_selects_Department() throws Exception {
		ticketsPage.select_Department();
	}
	@Then("Selected Department list get displayed successfully")
	public void Selected_Department_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	@And("User Clicks Cleaning Tickets")
	public void User_Clicks_Cleaning_Tickets() throws Exception {
		ticketsPage.Cleaning_Ticket();
	}
	@Then("Cleaning Tickets list get displayed successfully")
	public void Cleaning_Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	@And("User Clicks Non Cleaning Tickets")
	public void User_Clicks_Non_Cleaning_Tickets() throws Exception {
		ticketsPage.Non_Cleaning_Ticket();
	}
	@Then("Non Cleaning Tickets list get displayed successfully")
	public void Non_Cleaning_Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	@Then("multiple status Tickets list get displayed successfully")
	public void multiple_status_Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	@And("User selected all statuses and submitted")
	public void User_selected_all_statuses_and_submitted() throws Exception {
		ticketsPage.Multiple_Ticket_statuses();
	}
	@And("User clicks the Download button")
	public void User_clicks_the_Download_button() throws Exception {
		ticketsPage.Download_button_Ticketspage();
	}
	@Then("Purchase Download pop up will be displayed successfully")
	public void Purchase_Download_pop_up_will_be_displayed_successfully() throws Exception {
		ticketsPage.Tickets_Download_popup_display();
	}
	@And("User clicks the Download button with Download As Excel")
	public void User_clicks_the_Download_button_with_Download_As_Excel() throws Exception {
		ticketsPage.Download_button_Ticketspage();
		ticketsPage.Tickets_Download_Excel();
	}
	@And("User clicks the Download button with Download As PDF for purchases")
	public void User_clicks_the_Download_button_with_Download_As_PDF_for_purchases() throws Exception {
		ticketsPage.Download_button_Ticketspage();
		ticketsPage.Tickets_Download_PDF();
	}
	@And("User clicks the Download button after that click on close button")
	public void User_clicks_the_Download_button_after_that_click_on_close_button() throws Exception {
		ticketsPage.Download_button_Ticketspage();
		ticketsPage.Ticket_Download_popup_close();
	}
	@Then("The Download pop up get closed successfully and display the Tickets list")
	public void The_Download_pop_up_get_closed_successfully_and_display_the_Tickets_list() throws Exception {
		ticketsPage.Ticket_Download_popupclosd_displayed_Tickets();
	}
	@And("The User clicks the Edit button")
	public void The_User_clicks_the_Edit_button() throws Exception {
		ticketsPage.Tickets_Edit_icon();
}
	@Then("Edit Tickets page will be displayed successfully")
	public void Edit_Tickets_page_will_be_displayed_successfully() throws Exception {
		ticketsPage.Ticket_Edit_page();
}
	@And("The User clicks on the Delete button with clicks confirm yes button")
	public void The_User_clicks_on_the_Delete_button_with_clicks_confirm_yes_button() throws Exception {
		ticketsPage.Ticket_delete_icon();
		ticketsPage.Ticket_delete_popup_confirmed();
}
	@Then("^Tickets delete popup will be displayed successfully with either \"([^\"]*)\"$")
	public void BillBoard_delete_popup_will_be_displayed_successfully (String expectedMessage) throws Exception {
		  String actualMessage = ticketsPage.ticket_create_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin Deleted Ticket successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}
	@And("User edit Description")
	public void User_edit_Description() throws Exception {
		ticketsPage.Description_edit();
}
	@And("User click on Update Tickets button with confirm yes button")
	public void User_click_on_Update_Tickets_button_with_confirm_yes_button() throws Exception {
		ticketsPage.Ticket_update_clicked();
		ticketsPage.Update_Ticket_confirmed();
}
	@Then("^Ticket Updated popup will be displayed successfully as \"([^\"]*)\"$")
	public void BillBoard_Updated_popup_will_be_displayed_successfully_as_(String expectedMessage) throws Exception {
		  String actualMessage = ticketsPage.ticket_create_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin updated Ticket successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}
	@And("User click on Activity Feed Tab")
	public void User_click_on_Activity_Feed_Tab() throws Exception {
		ticketsPage.Activity_Feed_Display();
}
	@Then("Activity Feed Tab page will be displayed successfully")
	public void Activity_Feed_Tab_page_will_be_displayed_successfully() throws Exception {
		ticketsPage.Ticket_Edit_page();
}
	@And("User Click on Upload Photos videos and voice")
	public void User_Click_on_Upload_videos_and_voice() throws Exception {
		ticketsPage.Upload_Photos();
		ticketsPage.Upload_videos();
		ticketsPage.Upload_voice();

}
	@Then("User Click on close button of uploaded photos and confirmed")
	public void User_Click_on_close_button_of_Upload_photos() throws Exception {
		ticketsPage.Upload_Photos();
		ticketsPage.Upload_photo_close();
		ticketsPage.Upload_photo_close_confirmed();
}
	@Then("User Click on close button of uploaded videos and confirmed")
	public void User_Click_on_close_button_of_Upload_videos() throws Exception {
		ticketsPage.Upload_videos();
		ticketsPage.Upload_video_close();
		ticketsPage.Upload_video_close_confirmed();
}
	@And("User clicks verify button and confirm yes button")
	public void User_clicks_verify_button_and_confirm_yes_button() throws Exception {
		ticketsPage.Verify();
		ticketsPage.confirm_verify();
}
	@Then("^Ticket verified popup will be displayed successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
//	public void Ticket_verified_popup_will_be_displayed_successfully_with_either(String expectedMessage) throws Exception {
//		  String actualMessage = ticketsPage.ticket_create_Success_display();
//	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
//	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
//	      System.out.println(">> User or Admin verified Ticket successfully"+actualMessage);
//	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
//	}
	
	public void Ticket_verified_popup_will_be_displayed_successfully_with_either(String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = ticketsPage.ticket_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);

		System.out.println(">> User or Admin got the ticket cerified success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}

	@And("User clicks Reassign button and confirm yes button")
	public void User_clicks_Reassign_button_and_confirm_yes_button() throws Exception {
		ticketsPage.Reassign();
		ticketsPage.confirm_Reassign();
}
	@Then("^Ticket Reassigned popup will be displayed successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Ticket_Reassign_popup_will_be_displayed_successfully_with_either(String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = ticketsPage.ticket_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);

		System.out.println(">> User or Admin got the ticket cerified success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User clicks Approve button and confirm yes button")
	public void User_clicks_Approve_button_and_confirm_yes_button() throws Exception {
		ticketsPage.Approve();
		ticketsPage.confirm_Approve();
}
	@Then("^Ticket Approved popup will be displayed successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Ticket_Approved_popup_will_be_displayed_successfully_as(String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = ticketsPage.ticket_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);

		System.out.println(">> User or Admin got the ticket cerified success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User clicks Reject button and confirm yes button")
	public void User_clicks_Reject_button_and_confirm_yes_button() throws Exception {
		ticketsPage.Reject();
		ticketsPage.confirm_Reject();
}
	@Then("^Ticket Rejected popup will be displayed successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Ticket_Rejected_popup_will_be_displayed_successfully_as(String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = ticketsPage.ticket_create_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);

		System.out.println(">> User or Admin got the ticket cerified success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	@And("User clicks start conversation button")
	public void User_clicks_start_conversation_button() throws Exception {
		ticketsPage.Start_conversation();
}
	@Then("chat page will be displayed successfully")
	public void chat_page_will_be_displayed_successfully() throws Exception {
		ticketsPage.Chat_page_Displayed();
}
	@And("User click on second page button")
	public void User_click_on_second_page_button() throws Exception {
		ticketsPage.Second_page();
}
	@Then("Second page Tickets get displayed successfully")
	public void Second_page_Tickets_get_displayed_successfully() throws Exception {
		ticketsPage.Second_page_Display();
}
	@And("Go to Next page of Tickets page")
	public void Go_to_Next_page_of_Tickets_page() throws Exception {
		ticketsPage.next_page();
}
	@Then("Next page Tickets get displayed successfully")
	public void Next_page_Tickets_get_displayed_successfully() throws Exception {
}
	@And("Go to Previous page of Tickets page")
	public void Go_to_Previous_page_of_Tickets_page() throws Exception {
		ticketsPage.Previous_page();
}
	@Then("Previous page Tickets get displayed successfully")
	public void Previous_page_Tickets_get_displayed_successfully() throws Exception {
}
	@And("Go to Last page of Tickets page")
	public void Go_to_Last_page_of_Tickets_page() throws Exception {
		ticketsPage.last_page();
}
	@Then("Last page Tickets get displayed successfully")
	public void Last_page_Tickets_get_displayed_successfully() throws Exception {
}
	@And("User click on first page button of Tickets")
	public void User_click_on_first_page_button_of_Tickets() throws Exception {
		ticketsPage.First_page();
}
	@Then("First page Tickets get displayed successfully")
	public void First_page_Tickets_get_displayed_successfully() throws Exception {
}
	@And("User click on Reset button with confirm yes button")
	public void User_click_on_Reset_button_with_confirm_yes_button() throws Exception {
		ticketsPage.Ticket_Reset_clicked();
		ticketsPage.Reset_Ticket_confirmed();
}
	@Then("The ticket reset form changes are being done")
	public void The_ticket_reset_form_changes_are_being_done() throws Exception {
}
	@And("The User clicks the Edit icon")
	public void The_User_clicks_the_Edit_icon() throws Exception {
		ticketsPage.Edit_View_Ticket();
	}
	@Then("Created Tick mark should be displayed in Progress bar")
	public void Created_Tick_mark_should_be_displayed_in_Progress_bar() throws Exception {
		ticketsPage.Created_Tick_display();

}
	@Then("Viewed Tick mark should be displayed in Progress bar")
	public void Viewed_Tick_mark_should_be_displayed_in_Progress_bar() throws Exception {
		ticketsPage.Viewed_Tick_display();
}
	@Then("Submitted Tick mark should be displayed in Progress bar")
	public void Submitted_Tick_mark_should_be_displayed_in_Progress_bar() throws Exception {
		ticketsPage.Submitted_Tick_display();
}
	@Then("Overdued Tick mark should be displayed in Progress bar")
	public void Overdued_Tick_mark_should_be_displayed_in_Progress_bar() throws Exception {
		ticketsPage.Overdued_Tick_display();

}
	@And("User filter the Tickets list status Pending")
	public void User_filter_the_Tickets_list_status_Pending() throws Exception {
		ticketsPage.Tickets_status_Pending();
	}
	@Then("Pending Tickets list get displayed successfully")
	public void Pending_Tickets_list_get_displayed_successfully() throws Exception {
		ticketsPage.Tickets_filtered_result_display();
	}
	@Then("Reassigned Tick mark should be displayed in Progress bar")
	public void Reassigned_Tick_mark_should_be_displayed_in_Progress_bar() throws Exception {
		ticketsPage.Reassingned_Tickmark();
	}
}
