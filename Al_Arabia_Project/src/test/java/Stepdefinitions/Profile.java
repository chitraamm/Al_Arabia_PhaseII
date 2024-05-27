package Stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Profilepage;
import pageobjects.Signinpage;
import resources.Base;

public class Profile extends Base {

    private Logger LOGGER = LogManager.getLogger(Profile.class);
    private WebDriver driver;
    private Signinpage signinpage;
    private Profilepage profilepage;
    

    public Profile(Testhooks testhooks) throws Exception {
        this.driver = testhooks.getDriver();
        this.signinpage = new Signinpage(driver);
        this.profilepage = new Profilepage(driver);
        LOGGER = LogManager.getLogger(Profile.class.getName());
    }
    
    @Given("Admin logged in with valid credentials")
    public void Admin_logged_in_with_valid_credentials() throws Exception {
    	signinpage.enterValidEmail();
    	 signinpage.enterValidPassword();
         signinpage.clickSignInButton();
        LOGGER.info(">> Admin/User got logged in >>");
    }
    
    @When("User able to click on profile")
    public void user_able_to_click_on_profile() {
      profilepage.Profile();
    }

    @When("User able to click on personal profile")
    public void user_able_to_click_on_personal_profile() {
        profilepage.Personalprofile();
    }

    @Then("Personal profile should be displaying")
    public void personal_profile_should_be_displaying() {
    	profilepage.Personalprofile();
    }

    @When("User able to give personal profile information")
    public void user_able_to_give_personal_profile_information() {
    	profilepage.personalinfo();
    }

    @When("User able to click on update personal profile")
    public void user_able_to_click_on_update_personal_profile() {
       profilepage.Updatebutton();
    }

    @When("User able to select yes option for saving deatils")
    public void user_able_to_select_yes_option_for_saving_deatils() {
        profilepage.Yesbutton();
    }

    @Then("^User able to get success popup message \"([^\"]*)\"$")
    public void user_able_to_get_success_popup_message() {
    	 String actualMessage = profilepage.success_display();
         String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
         String normalizedActualMessage = normalizeWhitespace(actualMessage);
         System.out.println(">> User or Admin got the members profile updation success message successfully");
         assertEquals(normalizedExpectedMessage, normalizedActualMessage);
    }
    
    
    
    
    
    
    
}