package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
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

import resources.Base;

public class Signinpage extends Base {
	org.apache.logging.log4j.Logger log;

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	String actualResult = null;
	public Actions act;
	 public static Logger LOGGER =
			 LogManager.getLogger(Signinpage.class);
	public Signinpage(WebDriver driver) throws Exception {

		Signinpage.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir")
				+ "/src/main/java/resources/dataproperties";

		FileInputStream fis = new FileInputStream(propPath);

		prop.load(fis);
		initializeWait();
		 LOGGER = LogManager
				 .getLogger(Signinpage.class.getName());
	}

	public static void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	/////////////////////////// login page//////////////////////////

	@FindBy(name = "email")
	static WebElement email_field, INVemail_field, Clickemail_field;

	public static void email_field() {
		wait.until(ExpectedConditions.visibilityOf(email_field))
				.sendKeys(prop.getProperty("Admin_email_address"));
		LOGGER.info(">> User enters valid email address");
		System.out.println(">> User enters valid email address");
	}
	public static void INVemail_field() {
		wait.until(ExpectedConditions.visibilityOf(INVemail_field))
				.sendKeys(prop.getProperty("INV_email_address"));
		System.out.println(
				">> User enters invalid email address");
	}
	
	public static void Clickemail_field() {
		wait.until(ExpectedConditions.visibilityOf(Clickemail_field)).click();
		System.out.println(
				">> User clicks email address field");
	}
	
	@FindBy(name = "password")
	static WebElement password_field, INVpassword_field,INVpassword_withoutnumber_field, INVpassword_withoutspl_character, INVpassword_withoutupper_character, INVpassword_short_character, Clickpassword_field;

	public static void password_field() {
		wait.until(ExpectedConditions.visibilityOf(password_field))
				.sendKeys(prop.getProperty("Admin_password"));
		LOGGER.info(">> User enters valid password");
		System.out.println(">> User enters valid password");
	}
	
	public static void Clickpassword_field() {
		wait.until(ExpectedConditions.visibilityOf(Clickpassword_field)).click();
		System.out
		.println(">> User clicks password field");
	}
	
	public static void INVpassword_withoutupper_character() {
		wait.until(ExpectedConditions.visibilityOf(INVpassword_withoutupper_character))
				.sendKeys(prop.getProperty("INVpassword_withoutupper_character"));
		System.out
		.println(">> User enters INVpassword_withoutspl_character");
	}
	
	public static void INVpassword_short_character() {
		wait.until(ExpectedConditions.visibilityOf(INVpassword_short_character))
				.sendKeys(prop.getProperty("INVpassword_short_character"));
		System.out
		.println(">> User enters INVpassword_short_character");
	}
	
	public static void INVpassword_withoutspl_character() {
		wait.until(ExpectedConditions.visibilityOf(INVpassword_withoutspl_character))
				.sendKeys(prop.getProperty("INVpassword_withoutspl_character"));
		System.out
		.println(">> User enters INVpassword_withoutspl_character");
	}
	
	public static void INVpassword_field() {
		wait.until(ExpectedConditions.visibilityOf(INVpassword_field))
				.sendKeys(prop.getProperty("INV_password"));
		System.out
		.println(">> User enters invalid password");
	}
	
	public static void INVpassword_withoutnumber_field() {
		wait.until(ExpectedConditions.visibilityOf(INVpassword_withoutnumber_field))
				.sendKeys(prop.getProperty("INV_withoutNO_password"));
	}
	
	@FindBy(id = "signin")
	static WebElement signinbutton;

	public static void signinbutton() {
		wait.until(ExpectedConditions.visibilityOf(signinbutton)).click();
		LOGGER.info(">> User clicks on signin button");
		System.out.println(">> User clicks on signin button");
	}

	@FindBy(xpath = "//small[normalize-space()='Invalid email address or phone number']")
	static WebElement user_password_error;

	public static void user_password_error() {
		wait.until(ExpectedConditions.visibilityOf(user_password_error)).isDisplayed();
		AssertJUnit.assertTrue(user_password_error.isDisplayed());
		System.out.println(
				">> User got a invalid username and password error message");
	}
	
	@FindBy(xpath = "//div[@class='avatar pointer']")
	static WebElement dashboard;

	public static void dashboard() {
		wait.until(ExpectedConditions.visibilityOf(dashboard)).isDisplayed();
		AssertJUnit.assertTrue(dashboard.isDisplayed());
		LOGGER.info(">> Al-Arabia user got signed in successfully");
		System.out.println(">> Al-Arabia user got signed in successfully");
	}
	
	@FindBy(xpath = "//small[contains(text(),'Password is too short- should be 8 characters')]")
	static WebElement password_is_too_short_error;

	public static void password_is_too_short_error() {
		wait.until(ExpectedConditions.visibilityOf(password_is_too_short_error)).isDisplayed();
		AssertJUnit.assertTrue(password_is_too_short_error.isDisplayed());
		System.out
		.println(">> User got a password_is_too_short_error message");
	}
	
	@FindBy(xpath = "//small[normalize-space()='Must Contain One Number']")
	static WebElement user_password_withoutNO_error;

	public static void user_password_withoutNO_error() {
		wait.until(ExpectedConditions.visibilityOf(user_password_withoutNO_error)).isDisplayed();
		AssertJUnit.assertTrue(user_password_withoutNO_error.isDisplayed());
		System.out
		.println(">> User got a must contain one number error message");
	}
	
	@FindBy(xpath = "//small[normalize-space()='Must Contain One Special Case Character']")
	static WebElement must_contain_onespl_char_error;

	public static void must_contain_onespl_char_error() {
		wait.until(ExpectedConditions.visibilityOf(must_contain_onespl_char_error)).isDisplayed();
		AssertJUnit.assertTrue(must_contain_onespl_char_error.isDisplayed());
		System.out.println(
				">> User has got must contain one special case character error message");
	}
	
	@FindBy(xpath = "//small[normalize-space()='Must Contain One Uppercase, One Lowercase']")
	static WebElement must_contain_oneuppercase_char_error;

	public static void must_contain_oneuppercase_char_error() {
		wait.until(ExpectedConditions.visibilityOf(must_contain_oneuppercase_char_error)).isDisplayed();
		AssertJUnit.assertTrue(must_contain_oneuppercase_char_error.isDisplayed());
		System.out.println(
				">> User has got must contain one upper case character error message");
	}
	
	@FindBy(xpath = "//div[@class=' position-relative']//div[@class='eyeicon']//*[name()='svg']")
	static WebElement password_field_eyeicon;

	public static void password_field_eyeicon() {
		wait.until(ExpectedConditions.visibilityOf(password_field_eyeicon)).click();
		System.out.println(
				">> User clicked password_field_eyeicon");
	}
	
	@FindBy(xpath = "//small[normalize-space()='E-mail Address or phone number is required']")
	static WebElement emailphoneNo_required_error;

	public static void emailphoneNo_required_error() {
		wait.until(ExpectedConditions.visibilityOf(emailphoneNo_required_error)).click();
		System.out.println(
				">> User has got the emailphoneNo_required_error");
	}
}
