package Stepdefinitions;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Posterspage;
import resources.Base;

public class Posters extends Base {
	
	private static Logger LOGGER = LogManager.getLogger(Tickets.class);
	private WebDriver driver;
	private Posterspage postersPage;

	public Posters(Testhooks testhooks) throws Exception {
		this.driver = testhooks.getDriver(); 
		this.postersPage = new Posterspage(driver);
		//new Signinpage(driver);
		LOGGER = LogManager.getLogger(Posters.class.getName());
	}
	
	@And("User clicks the Posters")
	public void User_clicks_the_Posters() throws Exception {
		postersPage.Posters_click();
	}

	@Then("Al-Arabia Posters page should display successfully")
	public void Al_Arabia_Posters_page_should_display_successfully() throws Exception {
		postersPage.allpostersCount();
		LOGGER.info(">> Admin/user got the Posters page >>");
	}
	
	@And("Admin or user clicks the Master from the Profile")
	public void Admin_or_user_clicks_the_Master_from_the_Profile() throws Exception {
		postersPage.Masters_click();
	}
	
	@Then("Posters Page should display successfully")
	public void Posters_Page_should_display_successfully() throws Exception {
		postersPage.Display_Posters();
	}
	
	@And("User search a Poster")
	public void User_search_a_Poster() throws Exception {
		postersPage.Poster_Search();
	}

	@Then("Searched Poster details get displayed successfully")
	public void Searched_Poster_details_get_displayed_successfully() throws Exception {
		postersPage.display_searchedposter();
		LOGGER.info(">> Admin/user got the Searched Poster >>");
	}
	
}	