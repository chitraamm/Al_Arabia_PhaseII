package Stepdefinitions;

import static org.junit.Assert.assertEquals;

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
    
    @And("^Particular billboard get created successfully as \"([^\"]*)\"$")
    public void Particular_billboard_get_created_successfully(String expectedMessage) throws Exception {
        String actualMessage = billboardsPage.billboard_created_Success_display();
        String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
        String normalizedActualMessage = normalizeWhitespace(actualMessage);
        System.out.println(">> User or Admin got the billboard created success message successfully"+actualMessage);
        assertEquals(normalizedExpectedMessage, normalizedActualMessage);
    }

    private String normalizeWhitespace(String input) {
        return input.replaceAll("\\s+", " ").trim();
    }
    
    
    @And("Admin or user sort the billboards list recently updated")
    public void Admin_or_user_sort_the_billboards_list_recently_updated() throws Exception {
    	billboardsPage.BB_sort();
    }  
    
    
    @Then("Recently updated billboards list get displayed successfully")
    public void Recently_updated_billboards_list_get_displayed_successfully() throws Exception {
    	billboardsPage.Billboards_sort_recentlyupdated();
    }  
    
    @Then("User sort the billboards list Name A to Z")
    public void User_sort_the_billboards_list_Name_A_to_Z() throws Exception {
    	billboardsPage.Billboard_sort();
    } 
    
    
    @Then("billboards list get displayed successfully")
    public void billboards_list_get_displayed_successfully() throws Exception {
    	billboardsPage.BB_A_to_Z();
    } 
    
    @Then("User sort the billboards list Name Z to A")
    public void User_sort_the_billboards_list_Name_Z_to_A() throws Exception {
    	billboardsPage.BB_Z_to_A();
    } 
    
    
    @Then("billboards list Z-A get displayed successfully")
    public void billboards_list_Z_get_displayed_successfully() throws Exception {
    	billboardsPage.BB_Z_to_A();
    } 
    
}