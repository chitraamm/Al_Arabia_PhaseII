package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

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

import resources.Base;

public class Forgotpasswordpage extends Base {
	org.apache.logging.log4j.Logger log;

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	String actualResult = null;
	public Actions act;
	 public static Logger LOGGER =
	 LogManager.getLogger(Forgotpasswordpage.class);

	public Forgotpasswordpage(WebDriver driver) throws Exception {

		Forgotpasswordpage.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir")
				+ "/src/main/java/resources/dataproperties";

		FileInputStream fis = new FileInputStream(propPath);

		prop.load(fis);
		initializeWait();
		 LOGGER = LogManager
		 .getLogger(Forgotpasswordpage.class.getName());
	}

	public static void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	/////////////////////////// Signup page//////////////////////////

	@FindBy(xpath = "//a[normalize-space()='I forgot my password']")
	static WebElement forgot_click;

	public static void forgot_click() {
		wait.until(ExpectedConditions.visibilityOf(forgot_click)).click();
		System.out.println(">> User clicks on forgot password link");
		 LOGGER.info(">> User clicks on forgot password link");
	}

	@FindBy(name = "email")
	static WebElement email_field, invalid_email, invalid_email_delete;
	public static void email_field() {
		wait.until(ExpectedConditions.visibilityOf(email_field)).click();
		wait.until(ExpectedConditions.visibilityOf(email_field)).sendKeys(prop.getProperty("Forgot_email_address"));
		System.out.println(">> User enters valid email address");
	}
	
	public static void invalid_email() {
		wait.until(ExpectedConditions.visibilityOf(invalid_email)).click();
		wait.until(ExpectedConditions.visibilityOf(invalid_email)).sendKeys(prop.getProperty("INV_email_address"));
		System.out.println(">> User enters invalid email address");
	}
	
	public static void invalid_email_delete() {
		wait.until(ExpectedConditions.visibilityOf(invalid_email_delete)).click();
		wait.until(ExpectedConditions.visibilityOf(invalid_email)).sendKeys(prop.getProperty("INV_email_address"));
		invalid_email_delete.sendKeys(Keys.CONTROL, "a",
				Keys.DELETE);
		System.out.println(">> User enters invalid email address and deleted");
	}
	
	@FindBy(xpath = "//a[normalize-space()='English']")
	static WebElement click_english;
	public static void click_english() {
		wait.until(ExpectedConditions.visibilityOf(click_english)).click();
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	static WebElement send_resetlink;
	public static void send_resetlink() {
		wait.until(ExpectedConditions.visibilityOf(send_resetlink)).click();
		System.out.println(">> User clicks on send reset link button");
	}

	@FindBy(xpath = "//small[@class='text-danger']")
	static WebElement required_error;
	public static void required_error() {
		wait.until(ExpectedConditions.visibilityOf(required_error)).isDisplayed();
		System.out.println(
				">> User got a email address or phone number required error message");
	}
	
	@FindBy(xpath = "//small[@class='text-danger']")
	static WebElement invalid_email_error;
	public static void invalid_email_error() {
		wait.until(ExpectedConditions.visibilityOf(invalid_email_error)).isDisplayed();
		System.out.println(">> User got invalid email address error message");
	}
	
	
}
