package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
//    private Actions act;
	private Logger LOGGER = LogManager.getLogger(Memberspage.class);

	public Memberspage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
//        act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		LOGGER = LogManager.getLogger(Memberspage.class.getName());
	}

	private void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private String generateUniqueEmail(String baseEmail) {
		return baseEmail.replace("@", +System.currentTimeMillis() + "@");
	}

	@FindBy(xpath = "//span[normalize-space()='Members']")
	private WebElement membersClick;

	public void membersClick() {
		wait.until(ExpectedConditions.visibilityOf(membersClick)).click();
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
		System.out.println(">> User clicked blocked status in filter");
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
	private boolean condition = true;

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
}
