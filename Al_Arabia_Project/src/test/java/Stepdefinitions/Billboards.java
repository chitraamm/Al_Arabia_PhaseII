package Stepdefinitions;

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
    	billboardsPage.Newbillboard_create_BB_btn();
    }                                                                                                 
    
    @Then("User sort the billboards list recently updated")
    public void Searched_Billboard_details_get_displayed_successfully() throws Exception {
    	billboardsPage.New_billboard_display();
    }
    
//    @Then("")
//    public void Searched_Billboard_details_get_displayed_successfully() throws Exception {
//    	billboardsPage.New_billboard_display();
//    }
    
}