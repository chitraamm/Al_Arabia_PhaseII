package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Base;

public class Forgotpasswordpage extends Base {
	private final WebDriver driver;
	private WebDriverWait wait;
	private final Properties prop;

	public Forgotpasswordpage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		this.prop = new Properties();
		initializeWait();

		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		try {
			FileInputStream fis = new FileInputStream(propPath);
			prop.load(fis);
		} catch (Exception e) {
//			e.printStackTrace();
			e.getStackTrace();
		}

		PageFactory.initElements(driver, this);
	}

	private void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//a[normalize-space()='I forgot my password']")
	private WebElement forgotLink;

	public void clickForgotPasswordLink() {
		wait.until(ExpectedConditions.visibilityOf(forgotLink)).click();
		System.out.println(">> User clicks on forgot password link");
	}

	@FindBy(name = "email")
	private WebElement emailField, invalidEmailField, enterInvalidEmail;

	public void enterValidEmail() {
		wait.until(ExpectedConditions.visibilityOf(emailField)).click();
		emailField.sendKeys(prop.getProperty("Forgot_email_address"));
		System.out.println(">> User enters valid email address");
	}

	public void enterInvalidEmail() {
		wait.until(ExpectedConditions.visibilityOf(invalidEmailField)).click();
		invalidEmailField.sendKeys(prop.getProperty("INV_email_address"));
		System.out.println(">> User enters invalid email address");
	}

	public void deleteInvalidEmail() {
		wait.until(ExpectedConditions.visibilityOf(invalidEmailField)).click();
		invalidEmailField.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		System.out.println(">> User enters invalid email address and deletes it");
	}

	@FindBy(xpath = "//a[normalize-space()='English']")
	private WebElement englishLink;

	public void clickEnglishLink() {
		wait.until(ExpectedConditions.visibilityOf(englishLink)).click();
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement sendResetLink;

	public void clickSendResetLink() {
		wait.until(ExpectedConditions.visibilityOf(sendResetLink)).click();
		System.out.println(">> User clicks on send reset link button");
	}

	@FindBy(xpath = "//small[@class='text-danger']")
	private WebElement requiredError;

	public void isRequiredErrorDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(requiredError)).isDisplayed();
	}

	@FindBy(xpath = "//small[@class='text-danger']")
	private WebElement invalidEmailError;

	public void isInvalidEmailErrorDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(invalidEmailError)).isDisplayed();
	}

}
