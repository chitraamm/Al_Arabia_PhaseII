package test.java.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Cleaningpage;
import resources.Base;

public class Cleaning extends Base {

	private static Logger LOGGER = LogManager.getLogger(Cleaning.class);
    private final Cleaningpage cleaningpage;
	public Cleaning(Testhooks testhooks) throws Exception {
        WebDriver driver = testhooks.getDriver();
		this.cleaningpage = new Cleaningpage(driver);
		LOGGER = LogManager.getLogger(Cleaning.class.getName());
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
	@And("Admin or user search the Group")
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
		cleaningpage.Cleaninglist();
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
	@And("User filter the Cleaning list status Automatic")
	public void User_filter_the_Cleaning_list_status_Automatic() throws Exception {
		cleaningpage.Automatic_list();	
}
	@Then("Automatic Cleaning list get displayed successfully")
	public void Automatic_Cleaning_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaning_filtered_result_display();
	}
	@And("User filter the Cleaning list status Manual")
	public void User_filter_the_Cleaning_list_status_Manual() throws Exception {
		cleaningpage.Manual_list();	
}
	@Then("Manual Cleaning list get displayed successfully")
	public void Manual_Cleaning_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaning_filtered_result_display();
	}
	@And("User filter the Cleaning list status Dry")
	public void User_filter_the_Cleaning_list_status_Dry() throws Exception {
		cleaningpage.Dry_list();	
}
	@Then("Dry Cleaning list get displayed successfully")
	public void Dry_Cleaning_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaning_filtered_result_display();
	}
	@And("User filter the Cleaning list status Wet")
	public void User_filter_the_Cleaning_list_status_Wet() throws Exception {
		cleaningpage.Wet_list();	
}
	@Then("Wet Cleaning list get displayed successfully")
	public void Wet_Cleaning_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaning_filtered_result_display();
	}
	@And("User filter the Priority High status")
	public void User_filter_the_Priority_High_status() throws Exception {
		cleaningpage.Priority_High_list();	
}
	@Then("Priority High Cleaning list get displayed successfully")
	public void Priority_High_Cleaning_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaning_filtered_result_display();
	}
	@And("User filter the Priority Medium status")
	public void User_filter_the_Priority_Medium_status() throws Exception {
		cleaningpage.Priority_Medium_list();	
}
	@Then("Priority Medium Cleaning list get displayed successfully")
	public void Priority_Medium_Cleaning_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaning_filtered_result_display();
	}
	@And("User filter the Priority Low status")
	public void User_filter_the_Priority_Low_status() throws Exception {
		cleaningpage.Priority_Low_list();	
}
	@Then("Priority Low Cleaning list get displayed successfully")
	public void Priority_Low_Cleaning_list_get_displayed_successfully () throws Exception {
		cleaningpage.Cleaning_filtered_result_display();
	}
	@And("User filter the multiple statuses")
	public void User_filter_the_multiple_statuses()throws Exception{
		cleaningpage.Multiple_status_filter();
	}
	@Then("Multiple status Cleaning list get displayed successfully")
	public void Multiple_status_Cleaning_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaning_filtered_result_display();
	}
	@And("User filter the Start Date")
	public void User_filter_the_Start_Date()throws Exception{
		cleaningpage.StartDate_filter();
	}
	@Then("Cleaning from Start Date list get displayed successfully")
	public void Cleaning_from_Start_Date_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaning_filtered_result_display();
	}
	@And("User filter the Start Date and End date")
	public void User_filter_the_Start_Date_and_End_date()throws Exception{
		cleaningpage.StartEnd_Date_filter();
	}
	@Then("Cleaning from Start date and End date list get displayed successfully")
	public void Cleaning_from_Start_date_and_End_Date_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaning_filtered_result_display();
	}
	@And("User filter the Assignee")
	public void User_filter_the_Assignee()throws Exception{
		cleaningpage.Select_Assignee_filter();
	}
	@Then("Assignee cleaning list get displayed successfully")
	public void Assignee_cleaning_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaning_filtered_result_display();
	}
	@And("User filter the Billboard Type cleaning")
	public void User_filter_the_Billboard_Type_cleaning()throws Exception{
		cleaningpage.Select_Billboard_Type_cleaning_filter();
	}
	@Then("Billboard Type cleaning list get displayed successfully")
	public void Billboard_Type_cleaning_list_get_displayed_successfully() throws Exception {
		cleaningpage.Cleaning_filtered_result_display();
	}
	@And("User click edit button")
	public void User_click_edit_button()throws Exception{
		cleaningpage.Click_edit_group();
	}
	@And("User edit the Group name")
	public void User_edit_the_Group_name()throws Exception{
		cleaningpage.Group_edited();
	}
	@And("User Update the group and confirmed yes button")
	public void User_Update_the_group_and_confirmed_yes_button() throws Exception {
		cleaningpage.Group_update_clicked();
		cleaningpage.update_Group_confirmed();
}
	@Then("^Particular Group gets updated successfully as \"([^\"]*)\"$")
	public void Particular_Group_gets_updated_successfully_as_(String expectedMessage) throws Exception {
		  String actualMessage = cleaningpage.cleaning_create_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin updated Ticket successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}
	
	
	@And("Admin or user clicks the Download button in Cleaning page")
	public void Admin_or_user_clicks_the_Download_button_in_Cleaning_page() throws Exception {
		cleaningpage.Cleaning_Download();
	}
	@Then("Download popup get displayed successfully")
	public void Download_popup_get_displayed_successfully() throws Exception {
		cleaningpage.Popup_download_cleaning_display();
	}
	@And("User click on Excel Download")
	public void User_click_on_Excel_Download() throws Exception {
		cleaningpage.Excel_Download();
	}
	@Then("Excel file get downloaded successfully")
	public void Excel_file_get_downloaded_successfully() throws Exception {
	}
	@And("User click on PDF Download")
	public void User_click_on_PDF_Download() throws Exception {
		cleaningpage.PDF_Download();
	}
	@Then("PDF file get downloaded successfully")
	public void PDF_file_get_downloaded_successfully() throws Exception {
	}
	@And("User click on close button")
	public void User_click_on_close_button() throws Exception {
		cleaningpage.Close_Download();
	}
	@Then("download popup closed successfully")
	public void download_popup_closed_successfully() throws Exception {
	}
	@And("User click on View Ticket Tab")
	public void User_click_on_View_Ticket_Tab() throws Exception {
		cleaningpage.View_Ticket();
	}
	@Then("View Ticket page will display successfully")
	public void View_Ticket_page_will_display_successfully() throws Exception {
	}
	@And("User Click on Upload Photos videos and voice in View Ticket page")
	public void User_Click_on_Upload_videos_and_voice_in_View_Ticket_page() throws Exception {
		cleaningpage.Upload_Photos();
		cleaningpage.Upload_videos();
		cleaningpage.Upload_voice();
	}
	@And("User Click on close button of uploaded photos and confirmed in view ticket page")
	public void User_Click_on_close_button_of_Upload_photos_and_confirmed_in_view_ticket_page() throws Exception {
		cleaningpage.Upload_Photos();
		cleaningpage.Upload_photo_close();
		cleaningpage.Upload_photo_close_confirmed();
}
	@Then("User Click on close button of uploaded videos and confirmed in view ticket page")
	public void User_clicks_verify_button_and_confirm_yes_button_and_confirmed_in_view_ticket_page() throws Exception {
		cleaningpage.Upload_videos();
		cleaningpage.Upload_video_close();
		cleaningpage.Upload_video_close_confirmed();
}
	@And("User clicks start conversation button in view ticket page")
	public void User_clicks_start_conversation_button_in_view_ticket_page() throws Exception {
		cleaningpage.Start_conversation();
}
	@Then("Chat page will be displayed successfully")
	public void Chat_page_will_be_displayed_successfully() throws Exception {
		cleaningpage.Chat_page_Displayed();
}
	@And("User clicks Viewed Tab in Edit page")
	public void User_clicks_Viewed_Tab_in_Edit_page() throws Exception {
		cleaningpage.Viewed_ticket();
}
	@Then("Viewed ticket Tab will be displayed successfully")
	public void Viewed_ticket_Tab_will_be_displayed_successfully() throws Exception {
		cleaningpage.Viewed_ticket_Displayed();
}
	@And("User clicks Overdue Tab in Edit page")
	public void User_clicks_Overdue_Tab_in_Edit_page() throws Exception {
		cleaningpage.Overdue_ticket();
}
	@Then("Overdue ticket Tab will be displayed successfully")
	public void Overdue_ticket_Tab_will_be_displayed_successfully() throws Exception {
		cleaningpage.Overdue_ticket_Displayed();
}    
	@And("User clicks Submitted Tab in Edit page")
	public void User_clicks_Submitted_Tab_in_Edit_page() throws Exception {
		cleaningpage.Submitted_ticket();
}
	@Then("Submitted ticket Tab will be displayed successfully")
	public void Submitted_ticket_Tab_will_be_displayed_successfully() throws Exception {
		cleaningpage.Submitted_ticket_Displayed();
}
	@And("User clicks Verified Tab in Edit page")
	public void User_clicks_Verified_Tab_in_Edit_page() throws Exception {
		cleaningpage.Verified_ticket();
}
	@Then("Verified ticket Tab will be displayed successfully")
	public void Verified_ticket_Tab_will_be_displayed_successfully() throws Exception {
		cleaningpage.Verified_ticket_Displayed();
}
	@And("User clicks Reassigned Tab in Edit page")
	public void User_clicks_Reassigned_Tab_in_Edit_page() throws Exception {
		cleaningpage.Reassigned_ticket();
}
	@Then("Reassigned ticket Tab will be displayed successfully")
	public void Reassigned_ticket_Tab_will_be_displayed_successfully() throws Exception {
		cleaningpage.Reassigned_ticket_Displayed();
}
	@And("User clicks Closed Tab in Edit page")
	public void User_clicks_Closed_Tab_in_Edit_page() throws Exception {
		cleaningpage.Closed_ticket();
}
	@Then("Closed ticket Tab will be displayed successfully")
	public void Closed_ticket_Tab_will_be_displayed_successfully() throws Exception {
		cleaningpage.Closed_ticket_Displayed();
}
	@And("User click on second page button in the Cleaning module")
	public void User_click_on_second_page_button_in_the_Cleaning_module() throws Exception {
		cleaningpage.Second_page();
}
	@Then("Second page of Cleaning get displayed successfully")
	public void Second_page_of_Cleaning_get_displayed_successfully() throws Exception {
		cleaningpage.Second_page_Display();
}
	@And("Go to Next page of Cleaning page")
	public void Go_to_Next_page_of_Cleaning_page() throws Exception {
		cleaningpage.next_page();
}
	@Then("Next page Cleaning get displayed successfully")
	public void Next_page_Cleaning_get_displayed_successfully() throws Exception {
}
	@And("Go to Previous page of Cleaning page")
	public void Go_to_Previous_page_of_Cleaning_page() throws Exception {
		cleaningpage.Previous_page();
}
	@Then("Previous page Cleaning get displayed successfully")
	public void Previous_page_Cleaning_get_displayed_successfully() throws Exception {
}
	@And("Go to Last page of Cleaning page")
	public void Go_to_Last_page_of_Cleaning_page() throws Exception {
		cleaningpage.last_page();
}
	@Then("Last page Cleaning get displayed successfully")
	public void Last_page_Cleaning_get_displayed_successfully() throws Exception {
}
	@And("User click on first page button of Cleaning")
	public void User_click_on_first_page_button_of_Cleaning() throws Exception {
		cleaningpage.First_page();
}
	@Then("First page Cleaning get displayed successfully")
	public void First_page_Cleaning_get_displayed_successfully() throws Exception {
}
	@And("User clicks Edit icon in Created Ticket page")
	public void User_clicks_Edit_icon_in_Created_Ticket_page() throws Exception {
		cleaningpage.Click_edit_ticket();
}
	@Then("Cleaning edit page will redirect to the specified ticket page")
	public void Cleaning_edit_page_will_redirect_to_the_specified_ticket_page() throws Exception {
		cleaningpage.click_edit_ticket_display();

}
	
}