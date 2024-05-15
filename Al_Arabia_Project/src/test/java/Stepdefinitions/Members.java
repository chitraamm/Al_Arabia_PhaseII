//package Stepdefinitions;
//
//import java.time.Duration;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import Hooks.Testhooks;
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import pageobjects.Memberspage;
//import pageobjects.Signinpage;
//import resources.Base;
//
//public class Members extends Base {
//
//	private static Logger LOGGER = LogManager.getLogger(Members.class);
//	public WebDriver driver;
//	public WebDriverWait wait;
//
//	public Members(Testhooks testhooks) {
//		this.driver = testhooks.getDriver();
//		initializeWait();
//		LOGGER = LogManager.getLogger(Members.class.getName());
//	}
//	public void initializeWait() {
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	}
//	
//	@Given("Admin logged in with valid credentials")
//	public void Admin_logged_in_with_valid_credentials() throws Exception {
//		Signinpage.email_field();
//		Signinpage.password_field();
//		Signinpage.signinbutton();
//		LOGGER.info(">> Admin/User got logged in >>");
//	}
//	
//	@And("User clicks the members module")
//	public void User_clicks_the_members_module() throws Exception {
//		Memberspage.members_click();
//	}
//	
//	@And("User clicks the invite member button")
//	public void User_clicks_the_invite_member_button() throws Exception {
//		Memberspage.Invite_member_btn();
//	}
//	
//	@And("User enters the email or phone number")
//	public void User_enters_the_email_or_phone_number() throws Exception {
//		Memberspage.invite_email_phonenumber_field();
//	}
//	
//	@And("User selects the role manager")
//	public void User_selects_the_role_manager() throws Exception {
//		Memberspage.Invite_select_role();
//	}
//	
//	@And("User selects the department electrical")
//	public void User_selects_the_department_electrical() throws Exception {
//		Memberspage.Invite_select_dept();
//	}
//	
//	@And("User clicks the send invite button")
//	public void User_clicks_the_send_invite_button() throws Exception {
//		Memberspage.Invite_send_invite();
//	}
//	
//	@Then("The invitation should sent to user given mail address successfully")
//	public void The_invitation_should_sent_to_user_given_mail_address_successfully() throws Exception {
//		System.out.println(
//				">> User got the invitation mail successfully >>");
//		LOGGER.info(">> User got the invitation mail successfully >>");
//	}
//	
//	@When("Al-Arabia overall dashboard should display")
//	public void Al_Arabia_overall_dashboard_should_display() throws Exception {
//		Memberspage.dashboard_text();
//	}
//	
//	@Then("Al-Arabia members dashboard should display successfully")
//	public void Al_Arabia_members_dashboard_should_display_successfully() throws Exception {
//		Memberspage.All_members_count();
//		LOGGER.info(">> Admin/user got the members dashboard page >>");
//	}
//
//	@And("User search the members")
//	public void User_search_the_members() {
//		Memberspage.members_search();
//	}
//	
//	@Then("Searched member details get displayed successfully")
//	public void Searched_member_details_get_displayed_successfully() {
//		Memberspage.members_searched_list();
//	}
//	
//}

package Stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Memberspage;
import pageobjects.Signinpage;
import resources.Base;

public class Members extends Base {

    private static Logger LOGGER = LogManager.getLogger(Members.class);
    private WebDriver driver;
    private Memberspage membersPage;
    private Signinpage signinpage;

    public Members(Testhooks testhooks) throws Exception {
        this.driver = testhooks.getDriver();
        this.membersPage = new Memberspage(driver); // Instantiate Memberspage
        this.signinpage = new Signinpage(driver); // Instantiate Memberspage
        LOGGER = LogManager.getLogger(Members.class.getName());
    }

    @Given("Admin logged in with valid credentials")
    public void Admin_logged_in_with_valid_credentials() throws Exception {
    	signinpage.enterValidEmail();
    	 signinpage.enterValidPassword();
         signinpage.clickSignInButton();
        LOGGER.info(">> Admin/User got logged in >>");
    }

    @And("User clicks the members module")
    public void User_clicks_the_members_module() throws Exception {
        membersPage.membersClick();
    }

    @And("User clicks the invite member button")
    public void User_clicks_the_invite_member_button() throws Exception {
        membersPage.inviteMemberBtn();
    }

    @And("User enters the email or phone number")
    public void User_enters_the_email_or_phone_number() throws Exception {
        membersPage.inviteEmailPhoneNumberField();
    }

    @And("User selects the role manager")
    public void User_selects_the_role_manager() throws Exception {
        membersPage.inviteSelectRole();
    }

    @And("User selects the department electrical")
    public void User_selects_the_department_electrical() throws Exception {
        membersPage.inviteSelectDept();
    }

    @And("User clicks the send invite button")
    public void User_clicks_the_send_invite_button() throws Exception {
        membersPage.inviteSendInvite();
    }

    @Then("The invitation should sent to user given mail address successfully")
    public void The_invitation_should_sent_to_user_given_mail_address_successfully() throws Exception {
        System.out.println(">> User got the invitation mail successfully >>");
        LOGGER.info(">> User got the invitation mail successfully >>");
    }

    @When("Al-Arabia overall dashboard should display")
    public void Al_Arabia_overall_dashboard_should_display() throws Exception {
        membersPage.dashboardText();
    }

    @Then("Al-Arabia members dashboard should display successfully")
    public void Al_Arabia_members_dashboard_should_display_successfully() throws Exception {
        membersPage.allMembersCount();
        LOGGER.info(">> Admin/user got the members dashboard page >>");
    }

    @And("User search the members")
    public void User_search_the_members() {
        membersPage.membersSearch();
    }

    @Then("Searched member details get displayed successfully")
    public void Searched_member_details_get_displayed_successfully() {
        membersPage.membersSearchedList();
    }
}

