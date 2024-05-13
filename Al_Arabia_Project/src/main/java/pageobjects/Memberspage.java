package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import io.cucumber.datatable.DataTable;
import resources.Base;

public class Memberspage extends Base {
	org.apache.logging.log4j.Logger log;

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	String actualResult = null;
	public Actions act;
	 public static Logger LOGGER =
	 LogManager.getLogger(Memberspage.class);

	public Memberspage(WebDriver driver) throws Exception {

		Memberspage.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir")
				+ "/src/main/java/resources/dataproperties";

		FileInputStream fis = new FileInputStream(propPath);

		prop.load(fis);
		initializeWait();
		 LOGGER = LogManager
		 .getLogger(Memberspage.class.getName());
	}

	public static void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	/////////////////////////// Signup page//////////////////////////

	@FindBy(xpath = "//span[normalize-space()='Members']")
	static WebElement members_click;
	
	@FindBy(xpath = "//h6[normalize-space()='Dashboard'][position()=1]")
	static WebElement dashboard_text;
	
	public static void dashboard_text() {
		wait.until(ExpectedConditions.visibilityOf(dashboard_text)).isDisplayed();
		 LOGGER.info(">> Admin/User got navigated to dashboard page");
	}

	public static void members_click() {
		wait.until(ExpectedConditions.visibilityOf(members_click)).click();
		System.out.println(">> Admin/User got navigated to members page");
		 LOGGER.info(">> Admin/User got navigated to members page");
	}

	@FindBy(xpath = "//h5[@class=' mb-0 '][position()=1]")
	static WebElement All_members_count;

	public static void All_members_count() {
		wait.until(ExpectedConditions.visibilityOf(All_members_count)).isDisplayed();
		AssertJUnit.assertTrue(All_members_count.isDisplayed());
		System.out.println(">> The members dashboard list page got displayed");
		 LOGGER.info(">> The members dashboard list page got displayed");
	}
	
	@FindBy(xpath = "//button[@class=' btn_invite_member  btn btn-primary'][normalize-space()='Invite Member']")
	static WebElement Invite_member_btn;
	
	@FindBy(xpath = "//tbody/tr[1]/td[6]/div[1]/div[1]/button[1]//*[name()='svg']")
	static WebElement Members_menu;

	public static void Invite_member_btn() {
		wait.until(ExpectedConditions.visibilityOf(Members_menu)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(Invite_member_btn)).click();
		 LOGGER.info(">> User clicked the invite member button");
	}
	
	@FindBy(name = "email")
	static WebElement invite_email_phonenumber_field;

	public static void invite_email_phonenumber_field() {
		String uniqueEmail = generateUniqueEmail(prop.getProperty("Invite_email"));
		wait.until(ExpectedConditions.visibilityOf(invite_email_phonenumber_field)).click();
		wait.until(ExpectedConditions.visibilityOf(invite_email_phonenumber_field)).sendKeys(uniqueEmail);
		 LOGGER.info(">> User clicked the invite member button");
	}
	private static String generateUniqueEmail(String baseEmail) {
		return baseEmail.replace("@", +System.currentTimeMillis() + "@");
	}
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]")
	static WebElement Invite_select_role;
	
	@FindBy(id = "react-select-6-listbox")
	static WebElement Invite_select_role_select;

	public static void Invite_select_role() {
		wait.until(ExpectedConditions.visibilityOf(Invite_select_role)).click();
		wait.until(ExpectedConditions.visibilityOf(Invite_select_role_select)).click();
		 LOGGER.info(">> User selected the role:" +Invite_select_role.getText());
	}
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]")
	static WebElement Invite_select_dept;

	@FindBy(id = "react-select-8-listbox")
	static WebElement Invite_select_dept_select;
	
	public static void Invite_select_dept() {
		wait.until(ExpectedConditions.visibilityOf(Invite_select_dept)).click();
		wait.until(ExpectedConditions.visibilityOf(Invite_select_dept_select)).click();
		 LOGGER.info(">> User selected the role:" +Invite_select_dept.getText());
	}
	
	@FindBy(xpath = "//form[contains(@class,'floating was-validated')]//button[contains(@type,'submit')]")
	static WebElement Invite_send_invite;

	public static void Invite_send_invite() {
		wait.until(ExpectedConditions.visibilityOf(Invite_send_invite)).click();
		 LOGGER.info(">> User clicked the send invite button");
	}
	
	@FindBy(id = "firstName")
	static WebElement firstname;

	@FindBy(id = "lastName")
	static WebElement lastnmame;
	@FindBy(id = "email")
	static WebElement email_field;
	@FindBy(id = "password")
	static WebElement signup_password;

	public static void common_signup_steps(DataTable dataTable)
			throws Exception {
		List<Map<String, String>> dataList = dataTable.asMaps(String.class,
				String.class);
		for (Map<String, String> data : dataList) {
			String firstName = data.get("firstname");
			String lastName = data.get("lastname");
			String email = data.get("email");
			String password = data.get("password");
			wait.until(ExpectedConditions.visibilityOf(firstname))
					.sendKeys(firstName);
			System.out.println(
					">> User has entered the first name as " + firstName);
			wait.until(ExpectedConditions.visibilityOf(lastnmame))
					.sendKeys(lastName);
			System.out.println(
					">> User has entered the last name as " + lastName);
			wait.until(ExpectedConditions.visibilityOf(email_field))
					.sendKeys(email);
			System.out.println(
					">> User has entered the email address as " + email);
			wait.until(ExpectedConditions.visibilityOf(signup_password))
					.sendKeys(password);
			System.out
					.println(">> User has entered the password as " + password);
		}
	}

	@FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/div/div/form/div[6]/button")
	static WebElement signupbutton;

	public static void signupbutton() {
		wait.until(ExpectedConditions.visibilityOf(signupbutton)).click();
		System.out.println(">> User clicks on signup button");
	}

	@FindBy(name = "check")
	static WebElement termsandcondition;

	public static void termsandcondition() {
		wait.until(ExpectedConditions.visibilityOf(termsandcondition)).click();
		System.out.println(">> User clicks on terms and condition checkbox");
	}

	@FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/div/div/div[2]/form/div[4]/button")
	static WebElement loginpage;

	public static void loginpage() {
		wait.until(ExpectedConditions.visibilityOf(loginpage)).isDisplayed();
		AssertJUnit.assertTrue(loginpage.isDisplayed());
		System.out.println(">> User got signin page successfully");
	}
	
	@FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/div/div/form/div[3]/div")
	static WebElement invalid_email_error;

	public static void invalid_email_error() {
		wait.until(ExpectedConditions.visibilityOf(invalid_email_error)).isDisplayed();
		AssertJUnit.assertTrue(invalid_email_error.isDisplayed());
		System.out.println(">> User got invalid email address error message");
	}
	
	@FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/div/div/form/div[4]/div/div")
	static WebElement contain_onenumber_error;

	public static void contain_onenumber_error() {
		wait.until(ExpectedConditions.visibilityOf(contain_onenumber_error)).isDisplayed();
		AssertJUnit.assertTrue(contain_onenumber_error.isDisplayed());
		System.out
		.println(">> User got a must contain one number error message");
	}
	
	@FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/div/div/form/div[5]/div/small")
	static WebElement accept_termsandcondition_error;

	public static void accept_termsandcondition_error() {
		wait.until(ExpectedConditions.visibilityOf(accept_termsandcondition_error)).isDisplayed();
		AssertJUnit.assertTrue(accept_termsandcondition_error.isDisplayed());
		System.out.println(
				">> User got Please enter terms and condition error message");
	}
	
	@FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/div/div/form/div[3]/div")
	static WebElement email_already_exist_error;

	public static void email_already_exist_error() {
		wait.until(ExpectedConditions.visibilityOf(email_already_exist_error)).isDisplayed();
		AssertJUnit.assertTrue(email_already_exist_error.isDisplayed());
		System.out.println(">> User got Email already exist error message");
	}
	
	@FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/div/div/form/div[1]/div")
	static WebElement required_error;

	public static void required_error() {
		wait.until(ExpectedConditions.visibilityOf(required_error)).isDisplayed();
		AssertJUnit.assertTrue(required_error.isDisplayed());
		System.out.println(">> User got required fields error messages");
	}
}
