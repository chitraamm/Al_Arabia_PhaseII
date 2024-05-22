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
    
    @And("User sort the members list recently updated")
    public void User_sort_the_members_list_recently_updated() {
        membersPage.members_sort();
    }
    
    @Then("Recently updated members list get displayed successfully")
    public void Recently_updated_members_list_get_displayed_successfully() {
        membersPage.members_sort_list_displayed();
    }
    
    @And("User sort the members list Name A to Z")
    public void User_sort_the_members_list_Name_A_to_Z() {
        membersPage.members_sort_A_Z();
    }
    
    @Then("Members list get displayed successfully")
    public void A_Z_members_list_get_displayed_successfully() {
        membersPage.members_sort_AtoZ_display();
    }
    
    @And("User sort the members list Name Z to A")
    public void User_sort_the_members_list_Name_Z_to_A () {
        membersPage.members_sort_A_Z();
    }
    
    @And("User sort the members list Recently Added")
    public void User_sort_the_members_list_Recently_Added () {
        membersPage.members_sort_Recently_Added();
    }
    
    @And("User filter the members list status-Active")
    public void User_filter_the_members_list_status_Active () {
        membersPage.members_filter_sts_active();
    }
    
    @And("User filter the members list status-Active1")
    public void User_filter_the_members_list_status_Active1 () {
        membersPage.members_filter_sts_active1();
    }
    
    @Then("Active members list get displayed successfully")
    public void Active_members_list_get_displayed_successfully() {
        membersPage.members_filter_active_list_display();
    }
    
    @And("User filter the members list status-Blocked")
    public void User_filter_the_members_list_status_Blocked () {
        membersPage.members_filter_sts_blocked();
    }
    
    @Then("Blocked members list get displayed successfully")
    public void Blocked_members_list_get_displayed_successfully() {
        membersPage.members_filter_blocked_list_display();
    }
    
    @And("User filter the members list status-expired")
    public void User_filter_the_members_list_status_expired() {
        membersPage.members_filter_sts_expired();
    }
    
    @Then("Expired members list get displayed successfully")
    public void Expired_members_list_get_displayed_successfully() {
        membersPage.members_filter_blocked_list_display();
    }
    
    @And("User filter the members list status-pending")
    public void User_filter_the_members_list_status_pending() {
        membersPage.members_filter_sts_pending();
    }
    
    @Then("Pending members list get displayed successfully")
    public void Pending_members_list_get_displayed_successfully() {
        membersPage.members_filter_blocked_list_display();
    }
    
    @And("User filter the members list role-admin")
    public void User_filter_the_members_list_role_admin() {
        membersPage.members_filter_role_admin();
    }
    
    @Then("Admin members list get displayed successfully")
    public void Admin_members_list_get_displayed_successfully() {
        membersPage.members_filter_admin_list_display();
    }
    
    @And("User filter the members list role-manager")
    public void User_filter_the_members_list_role_manager() {
        membersPage.members_filter_role_manager();
    }
    
    @Then("Manager members list get displayed successfully")
    public void Manager_members_list_get_displayed_successfully() {
        membersPage.members_filter_manager_list_display();
    }
    
    @And("User filter the members list role-supervisor")
    public void User_filter_the_members_list_role_supervisor() {
        membersPage.members_filter_role_Supervisor();
    }
    
    @And("User filter the members list role-supervisor1")
    public void User_filter_the_members_list_role_supervisor1() {
        membersPage.members_filter_role_Supervisor1();
    }
    
    @Then("Supervisor members list get displayed successfully")
    public void Supervisor_members_list_get_displayed_successfully() {
        membersPage.members_filter_Supervisor_list_display();
    }
    
    @And("User filter the members list role-technician")
    public void User_filter_the_members_list_role_technician() {
        membersPage.members_filter_role_technician();
    }
    
    @Then("Technician members list get displayed successfully")
    public void Technician_members_list_get_displayed_successfully() {
        membersPage.members_filter_technician_list_display();
    }
    
    @And("User filter the members list dept-electrical")
    public void User_filter_the_members_list_dept_electrical() {
    	 membersPage.members_filter_dept();
    }
    
    @And("User filter the members list dept-electrical1")
    public void User_filter_the_members_list_dept_electrical1() {
    	 membersPage.members_filter_dept1();
    }
    
    @Then("Electrical dept members list get displayed successfully")
    public void Electrical_dept_members_list_get_displayed_successfully() {
        membersPage.members_filter_electrical_list_display();
    }
    
    @And("User filter the members list responsible area")
    public void User_filter_the_members_list_responsible_area() {
    	 membersPage.members_filter_responsible_area();
    }
    
    @And("User filter the members list responsible area1")
    public void User_filter_the_members_list_responsible_area1() {
    	 membersPage.members_filter_responsible_area1();
    }
    
    @Then("Responsible area members list get displayed successfully")
    public void Responsible_area_members_list_get_displayed_successfully() {
        membersPage.members_filter_responsible_area_list_display();
    }
    
    @Then("Filtered members list get displayed successfully")
    public void Filtered_members_list_get_displayed_successfully() {
        membersPage.members_filtered_list_display();
    }
    
    @And("User clicks the members list download btn")
    public void User_clicks_the_members_list_download_btn() {
    	 membersPage.members_download_btn();
    }
    
    @And("User clicks the excel formate btn")
    public void User_clicks_the_excel_formate_btn() {
    	 membersPage.members_download_excel_btn();
    }
    
    @Then("All members excel formate list get downloaded successfully")
    public void All_members_excel_formate_list_get_downloaded_successfully() {
        membersPage.excel_formate_members_list();
    }
    
    @And("User clicks the pdf formate btn")
    public void User_clicks_the_pdf_formate_btn() {
    	 membersPage.members_download_pdf_btn();
    }
    
    @Then("All members pdf formate list get downloaded successfully")
    public void All_members_pdf_formate_list_get_downloaded_successfully() {
        membersPage.pdf_formate_members_list();
    }
    
    @And("User clicks the close icon")
    public void User_clicks_the_close_icon() {
    	 membersPage.members_download_popup_closeicon();
    }
    
    @Then("The popup get closed successfully")
    public void The_popup_get_closed_successfully() {
        membersPage.members_download_btn_display();
    }
    
    @And("Go to next page of members page")
    public void Go_to_next_page_of_members_page() throws Exception {
    	 membersPage.member_2nd_page_click();
    }
    
    @Then("Second page get displayed successfully")
    public void Second_page_get_displayed_successfully() {
        membersPage.member_2nd_page_display();
    }
    
    @And("Admin or User go the members profile page")
    public void Admin_User_go_the_members_profile_page() throws Exception {
    	 membersPage.members_action_icon_click();
    }
    
    @Then("Members page get displayed successfully")
    public void Members_page_get_displayed_successfully() {
        membersPage.members_profile_personal_name();
    }
    
    @And("Admin or User update the members profile page")
    public void Admin_or_User_update_the_members_profile_page() throws Exception {
    	 membersPage.members_personalprofile_text_enter();
    }
    
    @Then("^Particular members profile get updated successfully as \"([^\"]*)\"$")
    public void Particular_members_profile_get_updated_successfully(String expectedMessage) {
        String actualMessage = membersPage.members_profile_success_display();
        String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
        String normalizedActualMessage = normalizeWhitespace(actualMessage);
        System.out.println(">> User or Admin got the members profile updation success message successfully");
        assertEquals(normalizedExpectedMessage, normalizedActualMessage);
    }

    private String normalizeWhitespace(String input) {
        return input.replaceAll("\\s+", " ").trim();
    }
    
    @And("Admin or User delete the member name")
    public void Admin_or_User_delete_the_member_name() throws Exception {
    	 membersPage.members_profile_personal_name_delete();
    }
    
    @Then("Name is required error message get displayed successfully")
    public void Name_is_required_error_message_get_displayed_successfully() {
        membersPage.members_profilepage_error();
    }
    
    @And("Admin or User update the members company profile page")
    public void Admin_or_User_update_the_members_company_profile_page() throws Exception {
    	 membersPage.members_companyprofile();
    }
    
    @And("Admin or User delete the workspace ID")
    public void Admin_or_User_delete_the_workspace_ID() throws Exception {
    	 membersPage.members_profile_personal_workspace_ID_delete();
    }
    
    @Then("Workspace id is required error message get displayed successfully")
    public void Workspace_id_is_required_error_message_get_displayed_successfully() {
        membersPage.members_profile_personal_workspaceID_error();
    }
    
    @And("Admin or User update the members vehicle info profile page")
    public void Admin_or_User_update_the_members_vehicle_info_profile_page() throws Exception {
    	 membersPage.members_vehicleinfo_profile();
    }
 
    @And("Admin or User delete the licence number")
    public void Admin_or_User_delete_the_licence_number() throws Exception {
    	 membersPage.members_profile_vehicleinfo_licenceNo_delete();
    }
    
    @Then("Licence plate number is required error message get displayed successfully")
    public void Licence_plate_number_is_required_error_message_get_displayed_successfully() {
        membersPage.members_profile_vehicleinfo_licenceNo_error();
    }
    
    @And("Admin or User update the members reset password profile page")
    public void Admin_or_User_update_the_members_reset_password_profile_page() throws Exception {
    	 membersPage.members_resetpassword_profile();
    }
    
    @And("Admin or User delete the new password")
    public void Admin_or_User_delete_the_new_password() throws Exception {
    	 membersPage.members_profile_resetpassword_delete();
    }
    
    @And("Admin or User delete the new password and enter without spl char")
    public void Admin_or_User_delete_the_new_password_and_enter_without_spl_char() throws Exception {
    	 membersPage.members_profile_resetpassword_delete_enterwithout_splchar();
    }
    
    @And("Admin or User delete the new password and enter without uppercase char")
    public void Admin_or_User_delete_the_new_password_and_enter_without_uppercase() throws Exception {
    	 membersPage.members_profile_resetpassword_delete_enterwithout_uppercase();
    }
    
    @And("Admin or User delete the new password and enter without number char")
    public void Admin_or_User_delete_the_new_password_and_enter_without_number() throws Exception {
    	 membersPage.members_profile_resetpassword_delete_enterwithout_number();
    }
    
    @And("Admin or User delete the new password and cofirm password mismatch")
    public void Admin_or_User_delete_the_new_password_and_cofirm_password_mismatch() throws Exception {
    	 membersPage.members_profile_resetpassword_delete_password_mismatch();
    }
    
    @Then("Reset password page error message get displayed successfully")
    public void Reset_password_page_error_message_get_displayed_successfully() {
        membersPage.members_profile_resetpassword_error();
    }
    
    @Then("^Particular members reset password profile get updated successfully as \"([^\"]*)\"$")
    public void Particular_members_resetpwprofile_get_updated_successfully(String expectedMessage) throws Exception {
        String actualMessage = membersPage.members_profile_success_display1();
        String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
        String normalizedActualMessage = normalizeWhitespace(actualMessage);
        System.out.println(">> User or Admin got the members profile updation success message successfully");
        assertEquals(normalizedExpectedMessage, normalizedActualMessage);
    }
    
    @And("Admin or User click the menu option")
    public void Admin_or_User_click_the_menu_option() throws Exception {
    	 membersPage.members_menu_icon_click();
    }
    
    @And("Admin or User click the block option")
    public void Admin_or_User_click_the_block_option() throws Exception {
    	 membersPage.members_menu_block_click();
    }
    
    @And("Admin or User click the Yes button")
    public void Admin_or_User_click_the_Yes_button() throws Exception {
    	 membersPage.members_menu_block_yes_click();
    }
    
    @Then("Member blocked successfully")
    public void Member_blocked_successfully() {
        membersPage.members_menu_blocked_text();
    }
    
    @And("Admin or User click the unblock option")
    public void Admin_or_User_click_the_unblock_option() throws Exception {
    	 membersPage.members_menu_unblock_click();
    }
    
    @And("Admin or User click the unblock Yes button")
    public void Admin_or_User_click_the_unblock_Yes_button() throws Exception {
    	 membersPage.members_menu_unblock_Yes_click();
    }
    
    @Then("Member activated successfully")
    public void Member_activated_successfully() {
        membersPage.members_menu_Active_text();
    }
    
    @And("Admin click the personal profile icon")
    public void Admin_click_the_personal_profile_icon() throws Exception {
    	 membersPage.members_avatar_icon();
    }
    
    @And("Admin go to the roles page")
    public void Admin_go_to_the_roles_page() throws Exception {
    	 membersPage.members_avatar_icon_roles();
    }
    
    @And("Admin enable the User read access for supervisor")
    public void Admin_enable_the_User_read_access_for_supervisor() throws Exception {
    	 membersPage.members_roles_user_supervisor_read();
    }
    
    @And("Admin clicks the logout button")
    public void Admin_clicks_the_logout_button() throws Exception {
    	 membersPage.Logout();
    }
    
    @And("Supervisor logged in with valid credentials")
    public void Supervisor_logged_in_with_valid_credentials() throws Exception {
    	signinpage.emailField();
   	 signinpage.enterValidPassword();
        signinpage.clickSignInButton();
       LOGGER.info(">> Supervisor got logged in >>");
    }
    
    @And("Supervisor go the members profile page")
    public void Supervisor_go_the_members_profile_page() throws Exception {
    	 membersPage.Members_supervisor_viewdetails_btn();
    }
    
    @Then("Supervisor get the read access successfully")
    public void Supervisor_get_the_read_access_successfully() {
        membersPage.Members_disabled_page();
    }
    
    @And("Admin enable the User write access for supervisor")
    public void Admin_enable_the_User_write_access_for_supervisor() throws Exception {
    	 membersPage.members_roles_user_supervisor_write();
    }
    
    @And("Check invite btn is displayed or not")
    public void Check_invite_btn_is_displayed_or_not() throws Exception {
    	 membersPage.members_supervisor_inviteBtn();
    }
    
    @Then("Supervisor get the write access successfully")
    public void Supervisor_get_the_write_access_successfully() throws Exception {
        membersPage.members_supervisor_success();
    }
    
    @And("Admin enable the User update access for supervisor")
    public void Admin_enable_the_User_update_access_for_supervisor() throws Exception {
    	 membersPage.members_roles_user_supervisor_update();
    }
    
    @And("Supervisor update the members profile page")
    public void Supervisor_update_the_members_profile_page() throws Exception {
    	 membersPage.members_roles_user_supervisor_update_profile();
    }
    
    @Then("Supervisor get the update access successfully")
    public void Supervisor_get_the_update_access_successfully() throws Exception {
        membersPage.members_supervisor_success_update();
    }
    
    @And("Admin enable the User block or unblock access for supervisor")
    public void Admin_enable_the_User_block_or_unblock_access_for_supervisor() throws Exception {
    	 membersPage.members_roles_user_supervisor_blockunblock();
    }
    
    @And("Supervisor clicks the members menu option")
    public void Supervisor_clicks_the_members_menu_option() throws Exception {
    	 membersPage.Members_supervisor_viewdetails_btn();
    }
    
    @Then("Supervisor get the block and unblock access successfully")
    public void Supervisor_get_the_block_and_unblock_access_successfully() throws Exception {
        membersPage.members_supervisor_success_block();
    }
    
    
    
    
    
    
    
    
    
    
    
    
}

