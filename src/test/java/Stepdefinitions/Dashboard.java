package Stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageobjects.Campaignspage;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Dashboardpage;
import resources.Base;

public class Dashboard extends Base {
	
	private static Logger LOGGER = LogManager.getLogger(Tickets.class);
	private WebDriver driver;
	private Dashboardpage dashboardpage;

	public Dashboard(Testhooks testhooks) throws Exception {
		this.driver = testhooks.getDriver(); 
		this.dashboardpage = new Dashboardpage(driver);
		LOGGER = LogManager.getLogger(Campaigns.class.getName());
	}
	
//	@And("")
//	public void () throws Exception {
//		dashboardpage.campaigns_click();
//	}
//
//	@Then("")
//	public void () throws Exception {
//		dashboardpage.allcampaignsCount();
//		LOGGER.info(">> Admin/user got the Dashboard page >>");
//	}
	
}	