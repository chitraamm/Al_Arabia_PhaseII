package Stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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
	@And("Admin or user clicks the Master module")
	public void Admin_or_user_clicks_the_Master_module() throws Exception {
		masterpage.Master_click();
	}
	@Then("Al Arabia Master page should display successfully")
	public void Al_Arabia_Master_page_should_display_successfully() throws Exception {
		masterpage.alldepartmentCount();
	}
	@And("User click on New Department button")
	public void User_click_on_New_Department_button() throws Exception {
		masterpage.New_Department_button_click();
	}
	@And("User Enter department name and clicks Add Department button")
	public void User_Enter_department_name_and_clicks_Add_Department_button() throws Exception {
		masterpage.Add_Department();
	}
	@Then("^Particular department gets created successfully with either \"([^\"]*)\" or \"([^\"]*)\"$")
	public void Particular_department_gets_created_successfully_as (String expectedMessage1,
			String expectedMessage2) throws Exception {
		String actualMessage = masterpage.department_created_Success_display();
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println(">> User or Admin got the purchase created success message successfully: " + actualMessage);

		boolean matchesMessage1 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage1));
		boolean matchesMessage2 = normalizedActualMessage.equals(normalizeWhitespace(expectedMessage2));

		assertTrue("The actual message was neither of the expected success messages.",
				matchesMessage1 || matchesMessage2);
	}
	private String normalizeWhitespace(String input) {
		return input.replaceAll("\\s+", " ").trim();
	}
}
