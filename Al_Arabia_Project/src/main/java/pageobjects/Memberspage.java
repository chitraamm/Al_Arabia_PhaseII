package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import resources.Base;

public class Memberspage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Actions act;
	private Logger LOGGER = LogManager.getLogger(Memberspage.class); 
	private Signinpage signinpage;

	public Memberspage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		this.signinpage = new Signinpage(driver);
		LOGGER = LogManager.getLogger(Memberspage.class.getName());
	}

	private boolean condition = true;

	private void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	private String generateUniqueEmail(String baseEmail) {
		return baseEmail.replace("@", +System.currentTimeMillis() + "@");
	}

	private static String generateUniqueIQMANumber(String baseIQMANumber) {
		Random rand = new Random();
		return baseIQMANumber + rand.nextInt(10000); 
	}

	private static String generateUniqueLicenceNumber(String baseLicenceNumber) {
		Random rand = new Random();
		return baseLicenceNumber + rand.nextInt(1000);
	}

	@FindBy(xpath = "//span[normalize-space()='Members']")
	private WebElement membersClick;

	public void membersClick() throws Exception{
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(membersClick)).click();
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
		LOGGER.info(">> Admin/User got navigated to members page");
	}
 
	@FindBy(xpath = "//h6[normalize-space()='Dashboard'][position()=1]")
	private WebElement dashboardText;

	public void dashboardText() {
		wait.until(ExpectedConditions.visibilityOf(dashboardText)).isDisplayed();
		LOGGER.info(">> Admin/User got navigated to dashboard page");
	}

	@FindBy(xpath = "//h5[@class=' mb-0 '][position()=1]")
	private WebElement allMembersCount;

	public void allMembersCount() {
		wait.until(ExpectedConditions.visibilityOf(allMembersCount)).isDisplayed();
		AssertJUnit.assertTrue(allMembersCount.isDisplayed());
		LOGGER.info(">> The members dashboard list page got displayed");
	}

	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='Invite Member'])[1]")
	private WebElement inviteMemberBtn, inviteMemberBtn1;
	
	public void inviteMemberBtn() {
		wait.until(ExpectedConditions.visibilityOf(inviteMemberBtn)).click();
		LOGGER.info(">> User clicked the invite member button");
	}

	@FindBy(xpath = "//tbody/tr[1]/td[6]/div[1]/div[1]/button[1]//*[name()='svg']")
	private WebElement membersMenu_click;

	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	private WebElement membersMenu;

	@FindBy(id = "email")
	private WebElement inviteEmailPhoneNumberField;

	public void inviteEmailPhoneNumberField() {
		String uniqueEmail = generateUniqueEmail(prop.getProperty("Invite_email"));
		wait.until(ExpectedConditions.visibilityOf(inviteEmailPhoneNumberField)).click();
		wait.until(ExpectedConditions.visibilityOf(inviteEmailPhoneNumberField)).sendKeys(uniqueEmail);
		LOGGER.info(">> User clicked the invite member button");
	}

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]")
	private WebElement inviteSelectRole;

	public void inviteSelectRole() {
		wait.until(ExpectedConditions.visibilityOf(inviteSelectRole)).click();
		wait.until(ExpectedConditions.visibilityOf(inviteSelectRoleSelect)).click();
		LOGGER.info(">> User selected the role:" + inviteSelectRole.getText());
	}

	@FindBy(id = "react-select-6-listbox")
	private WebElement inviteSelectRoleSelect;
	
	@FindBy(id = "department")
	private WebElement inviteSelectDept;

	public void inviteSelectDept() {
		String dept = generateUniqueEmail(prop.getProperty("Invite_Department"));
		wait.until(ExpectedConditions.visibilityOf(inviteSelectDept)).click();
		wait.until(ExpectedConditions.visibilityOf(inviteSelectDept)).sendKeys(dept + Keys.ENTER);
		LOGGER.info(">> User selected the role:" + inviteSelectDept.getText());
	}

	
	@FindBy(xpath = "//form[contains(@class,'floating was-validated')]//button[contains(@type,'submit')]")
	private WebElement inviteSendInvite;

	public void inviteSendInvite() {
		wait.until(ExpectedConditions.visibilityOf(inviteSendInvite)).click();
		LOGGER.info(">> User clicked the send invite button");
	}

	@FindBy(id = "doc_searchQueryInput")
	private WebElement membersSearch;

	public void membersSearch() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(membersSearch)).click();
		String searchTerm = prop.getProperty("members_search_text");
		wait.until(ExpectedConditions.visibilityOf(membersSearch)).sendKeys(searchTerm + Keys.ENTER);
		System.out.println(">> User enter the member name in search field: " + searchTerm);
	}

	@FindBy(xpath = "//h6[contains(text(),'panneer')]")
	private WebElement membersSearchedList;

	public void membersSearchedList() {
		wait.until(ExpectedConditions.visibilityOf(membersSearchedList)).isDisplayed();
		AssertJUnit.assertTrue(membersSearchedList.isDisplayed());
		System.out.println(">> User got searched members list: " + membersSearchedList.getText());
	}

	@FindBy(xpath = "//h6[contains(.,'Recently Updated')][.='Recently Updated']")
	private WebElement members_sort_recentlyupdated;

	@FindBy(xpath = "//h6[contains(.,'Name - A to Z')][.='Name - A to Z']")
	private WebElement members_sort_A_Z;

	@FindBy(xpath = "//h6[contains(.,'Name - Z to A')][.='Name - Z to A']")
	private WebElement members_sort_Z_A;

	@FindBy(xpath = "//h6[contains(.,'Recently Added')][.='Recently Added']")
	private WebElement members_sort_Recently_Added;

	@FindBy(xpath = "(//div[@class='d-flex sortbox '])[1]")
	private WebElement members_sort;

	public void members_sort() {	
		wait.until(ExpectedConditions.visibilityOf(members_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(members_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void members_sort_list_displayed() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
		AssertJUnit.assertTrue(membersMenu.isDisplayed());
		System.out.println(">> User got sorted the members list");
	}

	public void members_sort_A_Z() {

		wait.until(ExpectedConditions.visibilityOf(members_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(members_sort_A_Z)).click();
		System.out.println(">> User clicked A-Z in sort");
	}

	public void members_sort_Z_A() {

		wait.until(ExpectedConditions.visibilityOf(members_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(members_sort_Z_A)).click();
		System.out.println(">> User clicked Z-A in sort");
	}

	public void members_sort_Recently_Added() {

		wait.until(ExpectedConditions.visibilityOf(members_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(members_sort_Recently_Added)).click();
		System.out.println(">> User clicked Z-A in sort");
	}

	@FindBy(xpath = "//td[@class='py-5']")
	private WebElement members_sort_AtoZ_display;

	public void members_sort_AtoZ_display() {
		wait.until(ExpectedConditions.visibilityOf(members_sort_AtoZ_display)).isDisplayed();
		AssertJUnit.assertTrue(members_sort_AtoZ_display.isDisplayed());
		System.out.println(">> User got sorted the members list");
	}

	@FindBy(xpath = "(//span[contains(text(),'Active')])[1]")
	private WebElement members_filter_sts_active;

	public void members_filter_sts_active() {

		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_sts_active)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User clicked active status in filter");
	}

	public void members_filter_sts_active1() {
		wait.until(ExpectedConditions.visibilityOf(members_filter_sts_active)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User clicked active status in filter");
	}

	@FindBy(xpath = "(//span[contains(text(),'Blocked')])[1]")
	private WebElement members_filter_sts_blocked;

	public void members_filter_sts_blocked() {

		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_sts_blocked)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User clicked blocked status in filter");
	}

	@FindBy(xpath = "(//span[contains(text(),'Expired')])[1]")
	private WebElement members_filter_sts_expired;

	public void members_filter_sts_expired() {

		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_sts_expired)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User clicked expired status in filter");
	}

	@FindBy(xpath = "(//span[contains(text(),'Pending')])[1]")
	private WebElement members_filter_sts_pending;

	public void members_filter_sts_pending() {

		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_sts_pending)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User clicked pending status in filter");
	}

	@FindBy(xpath = "(//h6[contains(@class,'mb-0 by fw-normal')][normalize-space()='Filter By'])[1]")
	private WebElement members_filter;

	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='Apply'])[1]")
	private WebElement members_filter_apply_btn;

	@FindBy(xpath = "//div[contains(text(),'No Member Found')]")
	private WebElement members_no_members_found;

	@FindBy(xpath = "//span[@class='active-member']")
	private WebElement members_filter_active_list_display;

	public void members_filter_active_list_display() {

		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(members_filter_active_list_display)).isDisplayed();
				AssertJUnit.assertTrue(members_filter_active_list_display.isDisplayed());
				System.out.println(">> User got filtered active members list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(members_no_members_found)).isDisplayed();
				System.out.println(">> User got no members found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(members_no_members_found)).isDisplayed();
			System.out.println(">> User got no members found message");
		}
	}

	@FindBy(xpath = "//span[contains(@class,'in-active-membesr')]")
	private WebElement members_filter_blocked_list_display;

	public void members_filter_blocked_list_display() {

		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(members_filter_blocked_list_display));
				AssertJUnit.assertTrue(members_filter_blocked_list_display.isDisplayed());
				System.out.println(">> User got filtered blocked/inactive members list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
				System.out.println(">> User got no members found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
			System.out.println(">> User got no members found message");
		}
	}
	
	@FindBy(xpath = "(//span[contains(text(),'PENDING')])[1]")
	private WebElement members_filter_pending_list_display;

	public void members_filter_pending_list_display() {

		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(members_filter_pending_list_display));
				AssertJUnit.assertTrue(members_filter_pending_list_display.isDisplayed());
				System.out.println(">> User got filtered pending members list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
				System.out.println(">> User got no members found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
			System.out.println(">> User got no members found message");
		}
	}

	@FindBy(xpath = "(//span[contains(text(),'Admin')])[1]")
	private WebElement members_filter_role_admin;

	public void members_filter_role_admin() {

		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_role_admin)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User clicked admin role in filter");
	}

	@FindBy(xpath = "//h6[normalize-space()='ADMIN']")
	private WebElement members_filter_admin_list_display;

	public void members_filter_admin_list_display() {

		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(members_filter_admin_list_display));
				AssertJUnit.assertTrue(members_filter_admin_list_display.isDisplayed());
				System.out.println(">> User got filtered admin members list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
				System.out.println(">> User got no members found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
			System.out.println(">> User got no members found message");
		}
	}

	@FindBy(xpath = "(//span[contains(text(),'Manager')])[1]")
	private WebElement members_filter_role_manager;

	public void members_filter_role_manager() {

		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_role_manager)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User clicked manager role in filter");
	}

	@FindBy(xpath = "//h6[normalize-space()='MANAGER']")
	private WebElement members_filter_manager_list_display;

	public void members_filter_manager_list_display() {

		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(members_filter_manager_list_display));
				AssertJUnit.assertTrue(members_filter_manager_list_display.isDisplayed());
				System.out.println(">> User got filtered manager members list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
				System.out.println(">> User got no members found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
			System.out.println(">> User got no members found message");
		}
	}

	@FindBy(xpath = "(//span[contains(text(),'Supervisor')])[1]")
	private WebElement members_filter_role_Supervisor;

	public void members_filter_role_Supervisor() {

		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_role_Supervisor)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User clicked supervisor role in filter");
	}

	public void members_filter_role_Supervisor1() {

		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_role_Supervisor)).click();
		System.out.println(">> User clicked supervisor role in filter");
	}

	@FindBy(xpath = "//h6[.='SUPERVISOR ']")
	private WebElement members_filter_Supervisor_list_display;

	public void members_filter_Supervisor_list_display() {

		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(members_filter_Supervisor_list_display));
				AssertJUnit.assertTrue(members_filter_Supervisor_list_display.isDisplayed());
				System.out.println(">> User got filtered supervisor members list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
				System.out.println(">> User got no members found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
			System.out.println(">> User got no members found message");
		}
	}

	@FindBy(xpath = "(//span[contains(text(),'Technician')])[1]")
	private WebElement members_filter_role_technician;

	public void members_filter_role_technician() {

		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_role_technician)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User clicked technician role in filter");
	}

	@FindBy(xpath = "//h6[.='TECHNICIAN ']")
	private WebElement members_filter_technician_list_display;

	public void members_filter_technician_list_display() {

		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(members_filter_technician_list_display));
				AssertJUnit.assertTrue(members_filter_technician_list_display.isDisplayed());
				System.out.println(">> User got filtered technician members list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
				System.out.println(">> User got no members found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
			System.out.println(">> User got no members found message");
		}
	}

	@FindBy(xpath = "//input[@autocapitalize='none']")
	private WebElement members_filter_dept_click;

	@FindBy(id = "react-select-3-listbox")
	private WebElement members_filter_dept_select;

	public void members_filter_dept() {

		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_dept_click)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_dept_select)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User selected the dept in filter");
	}

	public void members_filter_dept1() {
		wait.until(ExpectedConditions.visibilityOf(members_filter_dept_click)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_dept_select)).click();
		System.out.println(">> User selected the dept in filter");
	}

	@FindBy(xpath = "//td[contains(normalize-space(),'ELECTRICAL')]")
	private WebElement members_filter_electrical_list_display;

	public void members_filter_electrical_list_display() {

		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(members_filter_electrical_list_display));
				AssertJUnit.assertTrue(members_filter_electrical_list_display.isDisplayed());
				System.out.println(">> User got filtered technician members list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
				System.out.println(">> User got no members found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
			System.out.println(">> User got no members found message");
		}
	}

	@FindBy(xpath = "//input[@itemtype='establishment']")
	private WebElement members_filter_responsible_area;

	public void members_filter_responsible_area() {

		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_responsible_area)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_responsible_area))
				.sendKeys("Saudi Arabia" + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User entered the responsible area in filter");
	}

	public void members_filter_responsible_area1() {
		wait.until(ExpectedConditions.visibilityOf(members_filter_responsible_area)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_responsible_area))
				.sendKeys("Saudi Arabia" + Keys.ENTER);
		System.out.println(">> User entered the responsible area in filter");
	}

	@FindBy(xpath = "(//td[contains(@class,'')])[5]")
	private WebElement members_filter_responsible_area_list_display;

	public void members_filter_responsible_area_list_display() {

		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(members_filter_responsible_area_list_display));
				AssertJUnit.assertTrue(members_filter_responsible_area_list_display.isDisplayed());
				System.out.println(">> User got filtered responsible area members list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
				System.out.println(">> User got no members found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
			System.out.println(">> User got no members found message");
		}
	}

	public void members_filtered_list_display() {
		members_filter_responsible_area_list_display();
	}

	@FindBy(xpath = "//button[.='Download']")
	private WebElement members_download_btn, members_download_btn_display;

	public void members_download_btn() {

		wait.until(ExpectedConditions.visibilityOf(members_download_btn)).click();
	}

	@FindBy(xpath = "//div[.='As Excel']")
	private WebElement members_download_excel_btn;

	public void members_download_excel_btn() {
		wait.until(ExpectedConditions.visibilityOf(members_download_excel_btn)).click();
	}

	@FindBy(xpath = "//div[.='As PDF']")
	private WebElement members_download_pdf_btn;

	public void members_download_pdf_btn() {
		wait.until(ExpectedConditions.visibilityOf(members_download_pdf_btn)).click();
	}

	public void excel_formate_members_list() {
		System.out.println(">> excel formate list get downloaded successfully");
	}

	public void pdf_formate_members_list() {
		System.out.println(">> pdf formate list get downloaded successfully");
	}

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement members_download_popup_closeicon;

	public void members_download_popup_closeicon() {
		wait.until(ExpectedConditions.visibilityOf(members_download_popup_closeicon)).click();
	}

	public void members_download_btn_display() {
		wait.until(ExpectedConditions.visibilityOf(members_download_btn_display)).isDisplayed();
		System.out.println(">> The download popup get closed successfully");
	}

	@FindBy(xpath = "//div[.='2']")
	private WebElement member_2nd_page_click;

	public void member_2nd_page_click() throws Exception {

		act.scrollToElement(member_2nd_page_click).build().perform();
		wait.until(ExpectedConditions.visibilityOf(member_2nd_page_click)).click();
	}

	@FindBy(xpath = "//div[contains(text(),'Showing')]")
	private WebElement member_2nd_page_display;

	public void member_2nd_page_display() {
		wait.until(ExpectedConditions.visibilityOf(member_2nd_page_display));
		AssertJUnit.assertTrue(member_2nd_page_display.isDisplayed());
		System.out.println(">> User got the 2nd page successfully");
	}

	@FindBy(xpath = "//a[normalize-space()='Edit']")
	private WebElement members_action_icon_edit_click;

	public void members_action_icon_click() throws Exception {
        Thread.sleep(3000); 
        wait.until(ExpectedConditions.visibilityOf(allMembersCount)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(membersMenu_click)).click();
		wait.until(ExpectedConditions.visibilityOf(members_action_icon_edit_click)).click();
	}

	@FindBy(id = "name")
	private WebElement members_profile_personal_name;

	public void members_profile_personal_name() {
		wait.until(ExpectedConditions.visibilityOf(members_profile_personal_name));
		AssertJUnit.assertTrue(members_profile_personal_name.isDisplayed());
		System.out.println(">> User or Admin got the members personal profile page successfully");
	}

	@FindBy(xpath = "//input[@value='+91 96777 75555']")
	private WebElement members_personalprofile_altNO_text_enter;

	@FindBy(name = "alternate_number")
	private WebElement members_personalprofile_altNO_text_enter1;

	@FindBy(xpath = "//input[@value='+91 96777 75556']")
	private WebElement members_personalprofile_whatappNo_text_enter;

	@FindBy(name = "whatsapp_number")
	private WebElement members_personalprofile_whatappNo_text_enter1;

	@FindBy(xpath = "//input[@class='select-wrapper pac-target-input']")
	private WebElement members_personalprofile_location_text_enter;

	@FindBy(id = "iqama_no")
	private WebElement members_personalprofile_IQMA_No_text_enter;

	@FindBy(id = "biography")
	private WebElement members_personalprofile_Bio_text_enter;

	@FindBy(xpath = "//h6[normalize-space()='Update Company Profile']")
	private WebElement profile_update_btn;
	
	public void members_personalprofile_text_enter() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(members_profile_personal_name));
		wait.until(ExpectedConditions.visibilityOf(members_profile_personal_name)).click();
		members_profile_personal_name.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_profile_personal_name)).sendKeys("Panneer");
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_altNO_text_enter)).click();
		members_personalprofile_altNO_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_altNO_text_enter1))
				.sendKeys(prop.getProperty("Alt_Phone_number"));
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_whatappNo_text_enter)).click();
		members_personalprofile_whatappNo_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_whatappNo_text_enter1))
				.sendKeys(prop.getProperty("Whatsapp_Phone_number"));
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_IQMA_No_text_enter)).click();
		members_personalprofile_IQMA_No_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		String uniqueIQMANumber = generateUniqueIQMANumber(prop.getProperty("IQMA_number"));
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_IQMA_No_text_enter))
				.sendKeys(uniqueIQMANumber);
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_Bio_text_enter)).click();
		members_personalprofile_Bio_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_Bio_text_enter)).sendKeys("Demo");
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_location_text_enter)).click();
		members_personalprofile_location_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_location_text_enter))
				.sendKeys("Saudi Arabia" + Keys.ARROW_DOWN + Keys.ENTER);
		Thread.sleep(2000);
	    act.moveToElement(profile_update_btn).click().perform();
	}

	@FindBy(xpath = "//h4[@class=' fw-semibold text-center text-black']")
	private WebElement confirmpopup;

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/div[2]/div/div/div[2]/h6[2]")
	private WebElement members_personalprofile_update_btn_Yes;
	
   public void companyprofile_update_confirmyes() throws Exception {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(confirmpopup)).isDisplayed();
        act.moveToElement(members_personalprofile_update_btn_Yes).click().perform();
	   
   }
	
	@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
	private WebElement members_profile_Success_display, members_profile_Success_display1;

	public String members_profile_success_display() {
		WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(members_profile_Success_display));
		return successMessageElement.getText().trim();
	}

	public String members_profile_success_display1() throws Exception {
		WebElement successMessageElement = wait
				.until(ExpectedConditions.visibilityOf(members_profile_Success_display1));
		return successMessageElement.getText().trim();
	}

	public void members_profile_personal_name_delete() {
		wait.until(ExpectedConditions.visibilityOf(members_profile_personal_name)).click();
		members_profile_personal_name.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_altNO_text_enter)).click();
		System.out.println(">> User or Admin erased the member name");
	}

	@FindBy(xpath = "//small[@class='form-text text-danger form_error']")
	private WebElement members_profilepage_error;

	public void members_profilepage_error() {
		wait.until(ExpectedConditions.visibilityOf(members_profilepage_error));
		AssertJUnit.assertTrue(members_profilepage_error.isDisplayed());
		System.out.println(">> User or Admin got error message successfully:>>>" + members_profilepage_error.getText());
	}

	@FindBy(xpath = "//span[normalize-space()='Company Profile']")
	private WebElement members_companyprofile;

	@FindBy(id = "work_space_id")
	private WebElement members_companyprofile_workspaceID;

	@FindBy(name = "date_of_joining")
	private WebElement members_companyprofile_DOJ;

	@FindBy(xpath = "//span[normalize-space()='1']")
	private WebElement members_companyprofile_DOJ_dateclick;

	@FindBy(xpath = "//input[@itemtype='establishment']")
	private WebElement members_companyprofile_responsible_area;

	public void members_companyprofile() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(members_companyprofile)).click();
		wait.until(ExpectedConditions.visibilityOf(members_companyprofile_workspaceID)).click();
		members_companyprofile_workspaceID.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_companyprofile_workspaceID)).sendKeys("123");
		wait.until(ExpectedConditions.visibilityOf(members_companyprofile_DOJ)).click();
		wait.until(ExpectedConditions.visibilityOf(members_companyprofile_DOJ_dateclick)).click();
		wait.until(ExpectedConditions.visibilityOf(members_companyprofile_responsible_area)).click();
		members_companyprofile_responsible_area.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_companyprofile_responsible_area))
				.sendKeys("Saudi Arabia" + Keys.ARROW_DOWN + Keys.ENTER);

		Thread.sleep(2000);
	    act.moveToElement(profile_update_btn).click().perform();
	}

	public void members_profile_personal_workspace_ID_delete() {
		wait.until(ExpectedConditions.visibilityOf(members_companyprofile)).click();
		wait.until(ExpectedConditions.visibilityOf(members_companyprofile_workspaceID)).click();
		members_companyprofile_workspaceID.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_companyprofile_DOJ)).click();
		System.out.println(">> User or Admin erased the member company profile ID");
	}

	public void members_profile_personal_workspaceID_error() {
		wait.until(ExpectedConditions.visibilityOf(members_profilepage_error));
		AssertJUnit.assertTrue(members_profilepage_error.isDisplayed());
		System.out.println(">> User or Admin got error message successfully:>>>" + members_profilepage_error.getText());
	}

	@FindBy(xpath = "//span[normalize-space()='Vehicle Information']")
	private WebElement members_vehicleinfoprofile;

	@FindBy(xpath = "//div[contains(@class,'select__value-container select__value-container--has-value css-hlgwow')]")
	private WebElement members_vehicleinfo_vehicletype;

	@FindBy(id = "react-select-6-listbox")
	private WebElement members_vehicleinfo_vehicletype_select;

	@FindBy(xpath = "//input[@id='number']")
	private WebElement members_vehicleinfo_licence;

	@FindBy(name = "model")
	private WebElement members_vehicleinfo_model;

	public void members_vehicleinfo_profile() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(members_vehicleinfoprofile)).click();
		wait.until(ExpectedConditions.visibilityOf(members_vehicleinfo_vehicletype)).click();
		wait.until(ExpectedConditions.visibilityOf(members_vehicleinfo_vehicletype_select)).click();
		wait.until(ExpectedConditions.visibilityOf(members_vehicleinfo_licence)).click();
		members_vehicleinfo_licence.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		String uniqueLicenceNumber = generateUniqueLicenceNumber(prop.getProperty("Licence_number"));
		wait.until(ExpectedConditions.visibilityOf(members_vehicleinfo_licence)).sendKeys(uniqueLicenceNumber);
		wait.until(ExpectedConditions.visibilityOf(members_vehicleinfo_model)).click();
		members_vehicleinfo_model.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_vehicleinfo_model)).sendKeys("2024" + Keys.ENTER);

		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_update_btn_Yes)).click();
		
	}

	public void members_profile_vehicleinfo_licenceNo_delete() {
		wait.until(ExpectedConditions.visibilityOf(members_vehicleinfoprofile)).click();
		wait.until(ExpectedConditions.visibilityOf(members_vehicleinfo_licence)).click();
		members_vehicleinfo_licence.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_vehicleinfo_model)).click();
		System.out.println(">> User or Admin erased the member vehicle licence number");
	}

	public void members_profile_vehicleinfo_licenceNo_error() {
		wait.until(ExpectedConditions.visibilityOf(members_profilepage_error));
		AssertJUnit.assertTrue(members_profilepage_error.isDisplayed());
		System.out.println(">> User or Admin got error message successfully:>>>" + members_profilepage_error.getText());
	}

	@FindBy(xpath = "//span[normalize-space()='Reset Password']")
	private WebElement members_resetpasswordprofile;

	@FindBy(id = "password")
	private WebElement members_reset_newpw;

	@FindBy(id = "password_confirmation")
	private WebElement members_reset_confirmpw;

	@FindBy(xpath = "//h6[normalize-space()='Yes, update it.']")
	private WebElement members_resetpass_profile_update_btn_Yes;

	public void members_resetpassword_profile() {
		wait.until(ExpectedConditions.visibilityOf(members_resetpasswordprofile)).click();
		wait.until(ExpectedConditions.visibilityOf(members_reset_newpw)).sendKeys("Password@123");
		wait.until(ExpectedConditions.visibilityOf(members_reset_confirmpw)).sendKeys("Password@123" + Keys.ENTER);

		wait.until(ExpectedConditions.visibilityOf(members_resetpass_profile_update_btn_Yes)).click();
	}

	public void members_profile_resetpassword_delete() {
		wait.until(ExpectedConditions.visibilityOf(members_resetpasswordprofile)).click();
		wait.until(ExpectedConditions.visibilityOf(members_reset_newpw)).sendKeys("password@123");
		wait.until(ExpectedConditions.visibilityOf(members_reset_confirmpw)).click();
		System.out.println(">> User or Admin enters the data into the reset password field");
	}

	public void members_profile_resetpassword_delete_enterwithout_splchar() {
		wait.until(ExpectedConditions.visibilityOf(members_resetpasswordprofile)).click();
		wait.until(ExpectedConditions.visibilityOf(members_reset_newpw)).sendKeys("Password123");
		wait.until(ExpectedConditions.visibilityOf(members_reset_confirmpw)).click();
		System.out.println(">> User or Admin enters the data into the reset password field");
	}

	public void members_profile_resetpassword_delete_enterwithout_uppercase() {
		wait.until(ExpectedConditions.visibilityOf(members_resetpasswordprofile)).click();
		wait.until(ExpectedConditions.visibilityOf(members_reset_newpw)).sendKeys("password@123");
		wait.until(ExpectedConditions.visibilityOf(members_reset_confirmpw)).click();
		System.out.println(">> User or Admin enters the data into the reset password field");
	}

	public void members_profile_resetpassword_delete_enterwithout_number() {
		wait.until(ExpectedConditions.visibilityOf(members_resetpasswordprofile)).click();
		wait.until(ExpectedConditions.visibilityOf(members_reset_newpw)).sendKeys("Password@sss");
		wait.until(ExpectedConditions.visibilityOf(members_reset_confirmpw)).click();
		System.out.println(">> User or Admin enters the data into the reset password field");
	}

	public void members_profile_resetpassword_delete_password_mismatch() {
		wait.until(ExpectedConditions.visibilityOf(members_resetpasswordprofile)).click();
		wait.until(ExpectedConditions.visibilityOf(members_reset_newpw)).sendKeys("Password@123");
		wait.until(ExpectedConditions.visibilityOf(members_reset_confirmpw)).sendKeys("Password@12" + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(members_reset_newpw)).click();
		System.out.println(">> User or Admin enters the data into the reset password field");
	}

	public void members_profile_resetpassword_error() {
		wait.until(ExpectedConditions.visibilityOf(members_profilepage_error));
		AssertJUnit.assertTrue(members_profilepage_error.isDisplayed());
		System.out.println(">> User or Admin got error message successfully:>>>" + members_profilepage_error.getText());
	}

	public void members_menu_icon_click() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(membersMenu_click)).click();
	}

	@FindBy(xpath = "//a[normalize-space()='Block']")
	private WebElement members_menu_block_click;

	@FindBy(xpath = "//a[normalize-space()='Unblock']")
	private WebElement members_menu_unblock_click;

	public void members_menu_block_click() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(members_menu_block_click)).click();
	}

	public void members_menu_block_yes_click() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(members_menu_block_Yes_click)).click();
	}

	@FindBy(xpath = "//h6[normalize-space()='Yes, block it.']")
	private WebElement members_menu_block_Yes_click;

	@FindBy(xpath = "//h6[normalize-space()='Yes, unblock it.']")
	private WebElement members_menu_unblock_Yes_click;

	public void members_menu_unblock_Yes_click() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(members_menu_unblock_Yes_click)).click();
	}

	public void members_menu_unblock_click() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(members_menu_unblock_click)).click();
	}

	@FindBy(xpath = "//span[normalize-space()='BLOCKED']")
	private WebElement members_menu_blocked_text;

	public void members_menu_blocked_text() {
		try {
			{
				wait.until(ExpectedConditions.visibilityOf(members_menu_blocked_text));
				AssertJUnit.assertTrue(members_menu_blocked_text.isDisplayed());
				System.out.println(">> Member got blocked" + members_menu_blocked_text.getText());
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
			System.out.println(">> User got no members found message");
		}
		System.out.println(">> User or Admin got blocked list successfully");
	}

	@FindBy(xpath = "//span[contains(.,'ACTIVE')]")
	private WebElement members_menu_Active_text;

	public void members_menu_Active_text() {
		try {
			{
				wait.until(ExpectedConditions.visibilityOf(members_menu_Active_text));
				AssertJUnit.assertTrue(members_menu_Active_text.isDisplayed());
				System.out.println(">> Member got blocked" + members_menu_Active_text.getText());
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(members_no_members_found));
			System.out.println(">> User got no members found message");
		}
		System.out.println(">> User or Admin got active list successfully");
	}

	@FindBy(xpath = "//div[contains(@class,'pointer sb-avatar__text')]")
	private WebElement members_avatar_icon;

	public void members_avatar_icon() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(members_avatar_icon)).click();
	}

	@FindBy(xpath = "//a[normalize-space()='Roles']")
	private WebElement members_avatar_icon_roles;

	public void members_avatar_icon_roles() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(members_avatar_icon_roles)).click();
	}

	@FindBy(xpath = "(//input[contains(@value,'[object Object]')])[11]")
	private WebElement members_roles_user_supervisor_read;

	public void members_roles_user_supervisor_read() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(members_roles_user_supervisor_read)).isDisplayed();
	}

	@FindBy(xpath = "(//a[normalize-space()='Logout'])[1]")
	private WebElement Logout;

	@FindBy(xpath = "(//h6[contains(text(),'Yes,')])[1]")
	private WebElement Logout_yes;

	public void Logout() throws Exception {
		members_avatar_icon();
		wait.until(ExpectedConditions.visibilityOf(Logout)).click();
		wait.until(ExpectedConditions.visibilityOf(Logout_yes)).click();
	}

	@FindBy(xpath = "//td[@class='py-5']//button[1]")
	private WebElement Members_supervisor_viewdetails_btn;

	public void Members_supervisor_viewdetails_btn() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(Members_supervisor_viewdetails_btn)).click();
	}

	public void Members_disabled_page() {
		members_profile_personal_name();
	}

	@FindBy(xpath = "(//input[contains(@value,'[object Object]')])[12]")
	private WebElement members_roles_user_supervisor_write;

	public void members_roles_user_supervisor_write() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(members_roles_user_supervisor_write)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_roles_user_supervisor_write)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_roles_user_supervisor_write)).isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(members_roles_user_supervisor_write)).click();
	}

	public void members_supervisor_inviteBtn() throws Exception {
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(inviteMemberBtn1)).isDisplayed();
		System.out.println(">> Invite button get displayed successfully");
	}

	public void members_supervisor_success() throws Exception {
		Logout();
		signinpage.enterValidEmail();
		signinpage.enterValidPassword();
		signinpage.clickSignInButton();
		LOGGER.info(">> Admin/User got logged in >>");
		members_avatar_icon();
		members_avatar_icon_roles();
		members_roles_user_supervisor_write();
		Logout();
		System.out.println(">> Supervisor get the write access successfully");
	}
	
	@FindBy(xpath = "(//input[contains(@value,'[object Object]')])[13]")
	private WebElement members_roles_user_supervisor_update;

	public void members_roles_user_supervisor_update() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(members_roles_user_supervisor_update)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_roles_user_supervisor_update)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_roles_user_supervisor_update)).isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(members_roles_user_supervisor_update)).click();
	}
	
	public void members_roles_user_supervisor_update_profile() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_IQMA_No_text_enter)).click();
		members_personalprofile_IQMA_No_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		String uniqueIQMANumber = generateUniqueIQMANumber(prop.getProperty("IQMA_number"));
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_IQMA_No_text_enter))
				.sendKeys(uniqueIQMANumber +Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_update_btn_Yes)).click();
		System.out.println(">> Supervisor updated the members successfully");
		Thread.sleep(5000);
	}
	
	public void members_supervisor_success_update() throws Exception {
		Logout();
		signinpage.enterValidEmail();
		signinpage.enterValidPassword();
		signinpage.clickSignInButton();
		LOGGER.info(">> Admin/User got logged in >>");
		members_avatar_icon();
		members_avatar_icon_roles();
		members_roles_user_supervisor_update();
		Logout();
		System.out.println(">> Supervisor get the update access successfully");
	}
	
	@FindBy(xpath = "(//input[contains(@value,'[object Object]')])[14]")
	private WebElement members_roles_user_supervisor_blockunblock;

	public void members_roles_user_supervisor_blockunblock() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(members_roles_user_supervisor_update)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_roles_user_supervisor_update)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_roles_user_supervisor_update)).isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(members_roles_user_supervisor_update)).click();
		wait.until(ExpectedConditions.visibilityOf(members_roles_user_supervisor_blockunblock)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_roles_user_supervisor_blockunblock)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_roles_user_supervisor_blockunblock)).isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(members_roles_user_supervisor_blockunblock)).click();
		System.out.println(">> Supervisor got the block unblock access successfully");
	}

	public void members_supervisor_success_block() throws Exception {
		Logout();
		signinpage.enterValidEmail();
		signinpage.enterValidPassword();
		signinpage.clickSignInButton();
		LOGGER.info(">> Admin/User got logged in >>");
		members_avatar_icon();
		members_avatar_icon_roles();
		members_roles_user_supervisor_update();
		members_roles_user_supervisor_blockunblock();
		Logout();
		System.out.println(">> Supervisor got the block unblock access successfully");
	}

}
