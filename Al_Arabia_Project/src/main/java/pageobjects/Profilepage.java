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

public class Profilepage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Actions act; 
	private Logger LOGGER = LogManager.getLogger(Profilepage.class);
	private Signinpage signinpage;

	public Profilepage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		this.signinpage = new Signinpage(driver);
		LOGGER = LogManager.getLogger(Profilepage.class.getName());
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

	private static String generateUniqueLicenceNumber(String baseLicenceNumber) {
		Random rand = new Random();
		return baseLicenceNumber + rand.nextInt(1000); // Append random number
	}

	@FindBy(xpath = "//div[@class='avatar pointer']")
	private WebElement Profile;

	public void Profile() {
		wait.until(ExpectedConditions.visibilityOf(Profile)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(Profile)).click();
	}

	@FindBy(xpath = "//a[normalize-space()='Personal Profile']")
	private WebElement Personalprofile;

	public void Personalprofile() {
		wait.until(ExpectedConditions.visibilityOf(Personalprofile)).click();
	}

	@FindBy(name = "name")
	private WebElement personalinfo_name;

	@FindBy(xpath = "//div[@class='toastpop position-relative']")
	private WebElement profile_success_display;
	
	public void personalinfo_name() {
		wait.until(ExpectedConditions.visibilityOf(personalinfo_name)).isDisplayed();
	}
	
	

	@FindBy(name = "iqama_no")
	private WebElement personalinfo_iqma, iqmaerror;

	public void personalinfo_iqma() {
		wait.until(ExpectedConditions.visibilityOf(personalinfo_iqma)).click();
		personalinfo_iqma.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		String uniqueIQMANumber = generateUniqueIQMANumber(prop.getProperty("Iqma"));
		wait.until(ExpectedConditions.visibilityOf(personalinfo_iqma)).sendKeys(uniqueIQMANumber+Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(members_personalprofile_update_btn_Yes)).click();
	}

	@FindBy(xpath = "//button[contains(@type,'submit')]")
	private WebElement personalinfo_Updatebutton_text_enter;

	public void personalinfo_Updatebutton_text_enter() {
		wait.until(ExpectedConditions.visibilityOf(personalinfo_Updatebutton_text_enter)).click();

	}

	@FindBy(xpath = "//h6[normalize-space()='Yes, update.']")
	private WebElement Yesbutton;

	public void Yesbutton() {
		wait.until(ExpectedConditions.visibilityOf(Yesbutton)).click();
	}
	
	public String profile_success_display() {
		WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(profile_success_display));
		return successMessageElement.getText().trim();
	}
	
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[2]/div/div[1]/input")
	private WebElement personalinfo_contractnumber_text_enter;

	@FindBy(xpath = "//input[@value='+91 88833 80008']")
	private WebElement personalinfo_alternatenumber_text_enter;

	@FindBy(xpath = "//input[contains(@error,'alternate number required')]")
	private WebElement personalinfo_alternatenumber_text_enter1;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div[2]/div/div[1]/input")
	private WebElement personalinfo_whatsappnumber_text_enter;

	@FindBy(xpath = "//input[contains(@error,'whatsapp number required')]")
	private WebElement personalinfo_whatsappnumber_text_enter1;

	@FindBy(xpath = "//input[@value='Coducer Technologies Private Limited, RAJ INFINITY, AECS Layout - A Block, AECS Layout, Singasandra, Bengaluru, Karnataka, India']")
	private WebElement personalinfo_location_text_enter;

	@FindBy(name = "biography")
	private WebElement personalinfo_biography_text_enter;

	public void personalinfo_text_enter() throws Exception {
		personalinfo_alternatenumber_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(personalinfo_alternatenumber_text_enter1))
				.sendKeys(prop.getProperty("Phone_number"));
		wait.until(ExpectedConditions.visibilityOf(personalinfo_whatsappnumber_text_enter)).click();
		personalinfo_whatsappnumber_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(personalinfo_whatsappnumber_text_enter1))
				.sendKeys(prop.getProperty("App_Phone_number"));
		wait.until(ExpectedConditions.visibilityOf(personalinfo_biography_text_enter)).click();
		personalinfo_biography_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(personalinfo_biography_text_enter)).sendKeys("Demo");
		wait.until(ExpectedConditions.visibilityOf(personalinfo_location_text_enter)).click();
		personalinfo_location_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(personalinfo_location_text_enter))
				.sendKeys("Saudi Arabia" + Keys.ARROW_DOWN + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(Yesbutton)).click();

	}

	@FindBy(xpath = "//span[normalize-space()='Reset from']")
	private WebElement Resetform;

	public void Resetform() {
		wait.until(ExpectedConditions.visibilityOf(Resetform)).click();
	}

	@FindBy(xpath = "//h6[normalize-space()='Yes, reset it.']")
	private WebElement YesResetform;

	public void YesResetform() {
		wait.until(ExpectedConditions.visibilityOf(YesResetform)).click();
	}

	@FindBy(xpath = "//div[contains(@class,'popup')]//h6[1]")
	private WebElement NoResetform;

	public void NoResetform() {
		wait.until(ExpectedConditions.visibilityOf(NoResetform)).click();
	}

	@FindBy(xpath = "//div[contains(@class,'popup')]//h6[1]")
	private WebElement Noupdate;

	public void Noupdate() {
		wait.until(ExpectedConditions.visibilityOf(Noupdate)).click();
	}

	public void nameerror() {
		wait.until(ExpectedConditions.visibilityOf(iqmaerror)).click();
		iqmaerror.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(personalinfo_name)).click();
	}
	
	@FindBy(xpath = "//h6[normalize-space()='Yes, update.']")
	private WebElement members_personalprofile_update_btn_Yes;

}
