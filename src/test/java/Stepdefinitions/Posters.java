package Stepdefinitions;

import static org.junit.Assert.assertEquals;

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
	
	@And("User Type in search field")
	public void User_Type_in_search_field() throws Exception {
		postersPage.Poster_Search();
	}

	@Then("Searched details get displayed successfully")
	public void Searched_details_get_displayed_successfully() throws Exception {
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
    
    @And("User click on New Poster")
    public void User_click_on_New_Poster() {
    	postersPage.Click_New_Poster ();
    }
    
    @And("User Enter Mandatory fields of New Poster")
    public void User_Enter_Mandatory_fields_of_New_Poster () {
    	postersPage.Enter_New_Poster_Fields ();
    }
    
    @And("User Upload Poster Image")
    public void User_Upload_Poster_Image() throws Exception {
    	postersPage.Upload_Posterimage ();
    }
    
    @And("User Click on Add Poster Button")
    public void User_Click_on_Add_Poster_Button() {
    	postersPage.Click_Add_Poster ();
    }
    
    @Then("Poster should be get created Successfully")
    public void Poster_should_be_get_created_Successfully() {
    	postersPage.Click_New_Poster ();
    }
    
    @Then("^Poster should be get created Successfully as \"([^\"]*)\"$")
    public void Poster_should_be_get_created_Successfully_as(String expectedMessage) {
        String actualMessage = postersPage.Success_display();
        String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
        String normalizedActualMessage = normalizeWhitespace(actualMessage);
        System.out.println(">> User or Admin got the Poster added success message successfully");
        assertEquals(normalizedExpectedMessage, normalizedActualMessage);
    }

    private String normalizeWhitespace(String input) {
        return input.replaceAll("\\s+", " ").trim();
    }
    
    @Then("^User Updates any field of the Poster \"([^\"]*)\"$")
    public void User_Updates_any_field_of_the_Poster (String expectedMessage) {
        String actualMessage = postersPage.Success_display();
        String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
        String normalizedActualMessage = normalizeWhitespace(actualMessage);
        System.out.println(">> User or Admin got the branch added success message successfully");
        assertEquals(normalizedExpectedMessage, normalizedActualMessage);
    }
	
	@And("Admin or user clicks the inventory from the Profile")
	public void Admin_or_user_clicks_the_inventory_from_the_Profile() throws Exception {
		postersPage.Inventory_click();
	}
	
	@And("User click on Poster Printing")
	public void User_click_on_Poster_Printing() throws Exception {
		postersPage.Poster_Printing_click();
	}
	
	@Then("Poster Printing page should display")
	public void Poster_Printing_page_should_display() throws Exception {
		postersPage.Display_Posterprinting();
		LOGGER.info(">> Admin/user got the Posters page >>");
	}
	
	@And("User Clicks New Poster Printing button")
	public void User_Clicks_New_Poster_Printing_button() throws Exception {
		postersPage.New_Poster_Printing_click();
	}
	
	@And("User Enter mandatory fields of New Poster Printing")
	public void User_Enter_mandatory_fields_of_New_Poster_Printing() throws Exception {
		postersPage.NewPoster_printing_Details();
	}
	
	@And("User clicks Create button")
	public void User_clicks_Create_button() throws Exception {
		postersPage.Clicks_Create_Button();
	}
	
    @Then("^New Poster should be get printed as per the Request \"([^\"]*)\"$")
    public void New_Poster_should_be_get_printed_as_per_the_Request (String expectedMessage) {
        String actualMessage = postersPage.Success_display();
        String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
        String normalizedActualMessage = normalizeWhitespace(actualMessage);
        System.out.println(">> User or Admin printed New Poster successfully");
        assertEquals(normalizedExpectedMessage, normalizedActualMessage);
    }
	
	
}	
