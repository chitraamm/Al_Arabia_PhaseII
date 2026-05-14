package Stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Campaignspage;
import resources.Base;

public class Campaigns extends Base {
	
	private static Logger LOGGER = LogManager.getLogger(Tickets.class);
	private WebDriver driver;
	private Campaignspage campaignsPage;

	public Campaigns(Testhooks testhooks) throws Exception {
		this.driver = testhooks.getDriver(); 
		this.campaignsPage = new Campaignspage(driver);
		LOGGER = LogManager.getLogger(Campaigns.class.getName());
	}
	
	@And("Admin or user clicks the campaigns module")
	public void Admin_or_user_clicks_the_campaigns_module() throws Exception {
		campaignsPage.campaigns_click();
	}

	@Then("Al-Arabia campaigns page should display successfully")
	public void Al_Arabia_campaigns_page_should_display_successfully() throws Exception {
		campaignsPage.allcampaignsCount();
		LOGGER.info(">> Admin/user got the campaigns page >>");
	}
	
}	