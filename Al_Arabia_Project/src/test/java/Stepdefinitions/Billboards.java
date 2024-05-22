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
    
    @And("User clicks the billboards module")
    public void User_clicks_the_billboards_module() throws Exception {
    	billboardsPage.billboardClick();
    }
    
    @Then("Al-Arabia billboards dashboard should display successfully")
    public void Al_Arabia_members_dashboard_should_display_successfully() throws Exception {
    	billboardsPage.allBillboardsCount();
        LOGGER.info(">> Admin/user got the members dashboard page >>");
    }
    
}