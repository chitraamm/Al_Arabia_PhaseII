package Stepdefinitions;

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
	private WebDriver driver;
	private Billboardspage billboardsPage;

	public Billboards(Testhooks testhooks) throws Exception {
		this.driver = testhooks.getDriver();
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
		LOGGER.info(">> Admin/user got the members dashboard page >>");
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

	@And("^Particular billboard gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
//    public void Particular_billboard_gets_created_successfully(String expectedMessage) throws Exception {
//        String actualMessage = billboardsPage.billboard_created_Success_display();
//        String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
//        String normalizedActualMessage = normalizeWhitespace(actualMessage);
//        System.out.println(">> User or Admin got the billboard created success message successfully"+actualMessage);
//        assertEquals(normalizedExpectedMessage, normalizedActualMessage);
//    }
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

	@Then("billboards list Z get displayed successfully")
	public void billboards_list_Z_get_displayed_successfully() throws Exception {
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
}