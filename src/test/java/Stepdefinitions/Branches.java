package Stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Branchespage;
import pageobjects.Masterpage;
import pageobjects.Signinpage;
import resources.Base;

public class Branches extends Base {

	private static Logger LOGGER = LogManager.getLogger(Cleaning.class);
	private WebDriver driver;
	private Branchespage branchespage;
	public Branches(Testhooks testhooks) throws Exception { 
		this.driver = testhooks.getDriver();
		this.branchespage = new Branchespage(driver);
		new Branchespage(driver);
		LOGGER = LogManager.getLogger(Cleaning.class.getName());
	}
	
	@And("User clicks the Branches")
	public void User_clicks_the_Branches() throws Exception {
		branchespage.Branches_click();
	}
	
	@Then("Branches page should display successfully")
	public void Branches_page_should_display_successfully() throws Exception {
		branchespage.Display_Branches();
	}
	
	@And("User click on New Branch Button")
	public void User_click_on_New_Branch_Button() throws Exception {
		branchespage.New_Branch_click();
	}
	
	@And("User Enter Mandatory fields of New Branch popup")
	public void User_Enter_Mandatory_fields_of_New_Branch_popup() throws Exception {
		branchespage.Enter_New_Branch_Mandatory_details();
	}
	
	@And("User Click on Add Branch Button")
	public void User_Click_on_Add_Branch_Button() throws Exception {
		branchespage.Click_AddBranch();
	}
	
    @Then("^Branch should be get created Successfully as \"([^\"]*)\"$")
    public void Branch_should_be_get_created_Successfully_as(String expectedMessage) {
        String actualMessage = branchespage.Success_display();
        String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
        String normalizedActualMessage = normalizeWhitespace(actualMessage);
        System.out.println(">> User or Admin got the branch added success message successfully");
        assertEquals(normalizedExpectedMessage, normalizedActualMessage);
    }

    private String normalizeWhitespace(String input) {
        return input.replaceAll("\\s+", " ").trim();
    }
    
    @And("User click on kebab menu of any branch")
    public void User_click_on_kebab_menu_of_any_branch() {
    	branchespage.Onclicks_kebabu_menu ();
    }
    
    @And("User Updates any field of the Branch")
    public void User_Updates_any_field_of_the_Branch() {
    	branchespage.Update_Branch ();
    }
    
    @Then("^Branch should be get updated Successfully as \"([^\"]*)\"$")
    public void Branch_should_be_get_updated_Successfully_as(String expectedMessage) {
        String actualMessage = branchespage.Success_display();
        String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
        String normalizedActualMessage = normalizeWhitespace(actualMessage);
        System.out.println(">> User or Admin got the branch added success message successfully");
        assertEquals(normalizedExpectedMessage, normalizedActualMessage);
    }
	
}	