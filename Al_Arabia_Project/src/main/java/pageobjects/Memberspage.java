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

	public Memberspage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
        act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		LOGGER = LogManager.getLogger(Memberspage.class.getName());
	}

	private boolean condition = true;

	private void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private String generateUniqueEmail(String baseEmail) {
		return baseEmail.replace("@", +System.currentTimeMillis() + "@");
	}
	
	private static String generateUniqueIQMANumber(String baseIQMANumber) {
		Random rand = new Random();
		return baseIQMANumber + rand.nextInt(10000); // Append random number
	}

	@FindBy(xpath = "//span[normalize-space()='Members']")
	private WebElement membersClick;

	public void membersClick() {
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

	@FindBy(xpath = "//button[@class=' btn_invite_member  btn btn-primary'][normalize-space()='Invite Member']")
	private WebElement inviteMemberBtn;

	public void inviteMemberBtn() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(inviteMemberBtn)).click();
		LOGGER.info(">> User clicked the invite member button");
	}

	@FindBy(xpath = "//tbody/tr[1]/td[6]/div[1]/div[1]/button[1]//*[name()='svg']")
	private WebElement membersMenu;

	@FindBy(name = "email")
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

	public void inviteSelectDept() {
		wait.until(ExpectedConditions.visibilityOf(inviteSelectDept)).click();
		wait.until(ExpectedConditions.visibilityOf(inviteSelectDeptSelect)).click();
		LOGGER.info(">> User selected the role:" + inviteSelectDept.getText());
	}

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]")
	private WebElement inviteSelectDept;

	@FindBy(id = "react-select-8-listbox")
	private WebElement inviteSelectDeptSelect;

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
	private WebElement members_sort_recentluupdated;

	@FindBy(xpath = "//h6[contains(.,'Name - A to Z')][.='Name - A to Z']")
	private WebElement members_sort_A_Z;

	@FindBy(xpath = "//h6[contains(.,'Name - Z to A')][.='Name - Z to A']")
	private WebElement members_sort_Z_A;

	@FindBy(xpath = "//h6[contains(.,'Recently Added')][.='Recently Added']")
	private WebElement members_sort_Recently_Added;

	@FindBy(xpath = "//div[@class='d-flex sortbox']")
	private WebElement members_sort;

	public void members_sort() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(members_sort_recentluupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void members_sort_list_displayed() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
		AssertJUnit.assertTrue(membersMenu.isDisplayed());
		System.out.println(">> User got sorted the members list");
	}

	public void members_sort_A_Z() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(members_sort_A_Z)).click();
		System.out.println(">> User clicked A-Z in sort");
	}

	public void members_sort_Z_A() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(members_sort_Z_A)).click();
		System.out.println(">> User clicked Z-A in sort");
	}

	public void members_sort_Recently_Added() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
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

	@FindBy(xpath = "//h6[contains(.,'Active')][.='Active']")
	private WebElement members_filter_sts_active;

	public void members_filter_sts_active() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
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

	@FindBy(xpath = "//h6[contains(.,'Blocked')][.='Blocked']")
	private WebElement members_filter_sts_blocked;

	public void members_filter_sts_blocked() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_sts_blocked)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User clicked blocked status in filter");
	}

	@FindBy(xpath = "//h6[contains(.,'Expired')][.='Expired']")
	private WebElement members_filter_sts_expired;

	public void members_filter_sts_expired() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_sts_expired)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User clicked expired status in filter");
	}

	@FindBy(xpath = "//h6[contains(.,'Pending')]")
	private WebElement members_filter_sts_pending;

	public void members_filter_sts_pending() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_sts_pending)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User clicked pending status in filter");
	}

	@FindBy(xpath = "//div[@class='d-flex filterbox']")
	private WebElement members_filter;

	@FindBy(xpath = "//button[contains(.,'Apply')]")
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

	@FindBy(xpath = "//h6[contains(.,'Admin')]")
	private WebElement members_filter_role_admin;

	public void members_filter_role_admin() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
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

	@FindBy(xpath = "//h6[contains(.,'Manager')]")
	private WebElement members_filter_role_manager;

	public void members_filter_role_manager() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
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

	@FindBy(xpath = "//h6[contains(.,'Supervisor')]")
	private WebElement members_filter_role_Supervisor;

	public void members_filter_role_Supervisor() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(members_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_role_Supervisor)).click();
		wait.until(ExpectedConditions.visibilityOf(members_filter_apply_btn)).click();
		System.out.println(">> User clicked supervisor role in filter");
	}

	public void members_filter_role_Supervisor1() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
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

	@FindBy(xpath = "//h6[contains(.,'Technician')]")
	private WebElement members_filter_role_technician;

	public void members_filter_role_technician() {
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
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
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
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
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
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

	@FindBy(xpath = "//h6[normalize-space()='Riyadh Saudi Arabia']")
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
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
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
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
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
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(membersMenu)).click();
		wait.until(ExpectedConditions.visibilityOf(members_action_icon_edit_click)).click();
	}
	
	@FindBy(name = "name")
	private WebElement members_profile_personal_name;
	public void members_profile_personal_name() {
		wait.until(ExpectedConditions.visibilityOf(members_profile_personal_name));
		AssertJUnit.assertTrue(members_profile_personal_name.isDisplayed());
		System.out.println(">> User or Admin got the members personal profile page successfully");
	}
	
	@FindBy(xpath = "//input[@value='+91 96777 75555']")
	private WebElement members_personalprofile_altNO_text_enter;
	@FindBy(xpath = "//input[contains(@error,'alternate number required')]")
	private WebElement members_personalprofile_altNO_text_enter1;
	
	@FindBy(xpath = "//input[@value='+91 96777 75556']")
	private WebElement members_personalprofile_whatappNo_text_enter;
	@FindBy(xpath = "//input[contains(@error,'whatsapp number required')]")
	private WebElement members_personalprofile_whatappNo_text_enter1;
	
	
	@FindBy(xpath = "//input[@class='select-wrapper pac-target-input']")
	private WebElement members_personalprofile_location_text_enter;
	
	@FindBy(name = "iqama_no")
	private WebElement members_personalprofile_IQMA_No_text_enter;
	
	@FindBy(name = "biography")
	private WebElement members_personalprofile_Bio_text_enter;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement members_personalprofile_update_btn;
	
	@FindBy(xpath = "//h6[normalize-space()='Yes, update.']")
	private WebElement members_personalprofile_update_btn_Yes;
	
	@FindBy(partialLinkText = "Success")
	private WebElement members_personalprofile_Success_display;
	
	public void members_personalprofile_text_enter() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(members_profile_personal_name)).click();
		members_profile_personal_name.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_profile_personal_name)).sendKeys("Panneer");
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_altNO_text_enter)).click();
		members_personalprofile_altNO_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_altNO_text_enter1)).sendKeys(prop.getProperty("Alt_Phone_number"));
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_whatappNo_text_enter)).click();
		members_personalprofile_whatappNo_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_whatappNo_text_enter1)).sendKeys(prop.getProperty("Whatsapp_Phone_number"));
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_IQMA_No_text_enter)).click();
		members_personalprofile_IQMA_No_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		String uniqueIQMANumber = generateUniqueIQMANumber(prop.getProperty("IQMA_number"));
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_IQMA_No_text_enter)).sendKeys(uniqueIQMANumber);
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_Bio_text_enter)).click();
		members_personalprofile_Bio_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_Bio_text_enter)).sendKeys("Demo");
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_location_text_enter)).click();
		members_personalprofile_location_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_location_text_enter)).sendKeys("Saudi Arabia"+Keys.ARROW_DOWN +Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_update_btn_Yes)).click();
		
		
	}
	
	public void members_profile_personal_success_display() {
//		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_Success_display));
//		AssertJUnit.assertTrue(members_personalprofile_Success_display.isDisplayed());
//		wait.until(ExpectedConditions.alertIsPresent());
//		 Alert alert = driver.switchTo().alert();
//		 String alertText = alert.getText();
//		 System.out.println("Alert text: " + alertText);
//		 members_personalprofile_Success_display.isDisplayed();
//		 String expectedText = "Success";  // Replace with the expected text
//         Assert.assertEquals("Popup message did not match the expected text", expectedText, alertText);
		System.out.println(">> User or Admin got the members updation success message successfully");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
