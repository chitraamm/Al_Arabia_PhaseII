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
	
	@And("User click sort button in the Posters page")
	public void User_click_sort_button_in_the_Posters_page() throws Exception {
		postersPage.Click_Sort();
	}
	
    @And("User sort the recently updated list")
    public void User_sort_the_recently_updated_list() {
    	postersPage.Sort_recently_Updated();
    }
    
    @Then("Recently updated page get displayed successfully")
    public void Recently_updated_page_get_displayed_successfully() {
    	postersPage.display_Sort_recently_updatedd();
    }
    
    @And("User sort the recently added list")
    public void User_sort_the_recently_added_list() {
    	postersPage.Sort_recently_added();
    }
    
    @Then("Recently added page get displayed successfully")
    public void Recently_added_get_displayed_successfully() {
    	postersPage.display_Sort_recently_added();
    }
    
    
    @And("User sort the Name A to Z list")
    public void User_sort_the_Name_A_to_Z_list() {
    	postersPage.Sort_Name_A_to_Z ();
    }
    
    @Then("Name A to Z page get displayed successfully")
    public void Name_A_to_Z_page_get_displayed_successfully () {
    	postersPage.display_Sort_Name_A_to_Z ();
    }
    
    @And("User sort the Name Z to A list")
    public void User_sort_the_Name_Z_to_A_list() throws Exception {
    	postersPage.Sort_Name_Z_to_A ();
    }
    
    @Then("Name Z to A page get displayed successfully")
    public void Name_Z_to_A_page_get_displayed_successfully () {
    	postersPage.display_Sort_Name_Z_to_A ();
    }
    
    @And("User sort the Decending list Date of projects")
    public void User_sort_the_Decending_list_Date_of_projects() {
    	postersPage.Sort_Decending_Date ();
    }
    
    @Then("Decending Date list get displayed successfully")
    public void Decending_Date_list_get_displayed_successfully() {
    	postersPage.display_Sort_Decending_Date ();
    }
    
    @And("User click on kebab menu of any poster")
    public void User_click_on_kebab_menu_of_any_poster() {
    	postersPage.Onclicks_kebabu_menu ();
    }
	
    @And("User clicks on edit")
    public void User_clicks_on_edit() {
    	postersPage.Onclicks_Edit ();
    }
    
    @And("User Updates any field of the Poster")
    public void User_Updates_any_field_of_the_Poster() {
    	postersPage.Update_Poster ();
    }
	
	
}	