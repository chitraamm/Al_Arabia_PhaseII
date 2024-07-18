package Stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Signinpage;
import pageobjects.Ticketspage;
import resources.Base;

public class Tickets extends Base {
	
	private static Logger LOGGER = LogManager.getLogger(Tickets.class);
	private WebDriver driver;
	private Ticketspage ticketsPage;

	public Tickets(Testhooks testhooks) throws Exception {
		this.driver = testhooks.getDriver();
		this.ticketsPage = new Ticketspage(driver);
		new Signinpage(driver);
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
	public void Particular_Ticket_gets_created_successfully_with_either (String expectedMessage) throws Exception {
		  String actualMessage = ticketsPage.ticket_create_Success_display();
	      String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	      String normalizedActualMessage = normalizeWhitespace(actualMessage);
	      System.out.println(">> User or Admin got the QR code file downloaded successfully"+actualMessage);
	      assertEquals(normalizedExpectedMessage, normalizedActualMessage);
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
}
