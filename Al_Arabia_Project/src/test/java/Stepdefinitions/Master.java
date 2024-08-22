package Stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import pageobjects.Cleaningpage;
import pageobjects.Masterpage;
import pageobjects.Signinpage;
import resources.Base;

public class Master extends Base {

	private static Logger LOGGER = LogManager.getLogger(Cleaning.class);
	private WebDriver driver;
	private Masterpage masterpage;
	public Master(Testhooks testhooks) throws Exception {
		this.driver = testhooks.getDriver();
		this.masterpage = new Masterpage(driver);
		new Signinpage(driver);
		LOGGER = LogManager.getLogger(Cleaning.class.getName());
	}
}