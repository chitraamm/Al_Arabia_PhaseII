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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import resources.Base;

public class Branchespage extends Base {
	private static final String Automationtest = null;
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Actions act;
	private Logger LOGGER = LogManager.getLogger(Branchespage.class); 


	public Branchespage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		LOGGER = LogManager.getLogger(Branchespage.class.getName());
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
		return baseIQMANumber + rand.nextInt(10000);
	}

	private static String generateUniqueboardNumber(String baseboardNumber) {
		Random rand = new Random();
		return baseboardNumber + rand.nextInt(1000);
	}
	private static String generateUniqueboardName(String baseboardName) {
	    Random rand = new Random();
	    int uniqueNumber = rand.nextInt(10000);  // Generates a random number between 0 and 9999
	    return baseboardName + "_" + uniqueNumber;
	}
	
	private static String generateUniqueNumber(String baseLicenceNumber) {
		Random rand = new Random();
		return baseLicenceNumber + rand.nextInt(1000);
	}
	
	@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
	private WebElement Success_display, members_profile_Success_display1;

	public String Success_display() {
		WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(Success_display));
		return successMessageElement.getText().trim();
	}
	
	@FindBy(xpath = "(//a[normalize-space()='Branches'])[1]")
	WebElement clickbranches;
	
	@FindBy(xpath = "(//a[normalize-space()='Department'])[1]")
	WebElement mastersdisplay;

	public void Branches_click() throws Exception {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(mastersdisplay)).isDisplayed();
		act.scrollToElement(clickbranches).perform();
		wait.until(ExpectedConditions.visibilityOf(clickbranches)).click();
		LOGGER.info(">> Admin/User got navigated to Branches page");
	}
	
	@FindBy(xpath = "(//th[normalize-space()='Branch name'])[1]")
	WebElement Branches_display;

	public void Display_Branches() {
		wait.until(ExpectedConditions.visibilityOf(Branches_display)).isDisplayed();
		AssertJUnit.assertTrue(Branches_display.isDisplayed());
		LOGGER.info(">> The posters page got displayed");
	}
	
	@FindBy(xpath = "(//button[@id=' New Branch '])[1]")
	WebElement clickNew_branch;
	
	public void New_Branch_click () {
		
		wait.until(ExpectedConditions.visibilityOf(Branches_display)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(clickNew_branch)).click();	
	}
	
	@FindBy(id = "title")
	WebElement branch_name;
	
	@FindBy(xpath = "(//h4[normalize-space()='Add Branch'])[1]")
	WebElement display_New_branch;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Location'])[1]")
	WebElement city_name;
	
	public void Enter_New_Branch_Mandatory_details () throws Exception {
		
		wait.until(ExpectedConditions.visibilityOf(display_New_branch)).isDisplayed();
		String branchname = prop.getProperty("branchname");
		wait.until(ExpectedConditions.visibilityOf(branch_name)).sendKeys(generateUniqueNumber(""+branchname));
		wait.until(ExpectedConditions.visibilityOf(branch_name)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(city_name)).sendKeys((""+"riyadh"));
        Thread.sleep(2000);
        act.moveToElement(city_name).sendKeys(""+Keys.ARROW_DOWN+Keys.ENTER).perform();
	}
	
	@FindBy(id = "Add Branch")
	WebElement click_Addbranch;
	
	public void Click_AddBranch () {
		
		wait.until(ExpectedConditions.visibilityOf(city_name)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_Addbranch)).click();

	}
	
	
	@FindBy(xpath = "(//*[name()='svg' and @viewBox='0 0 16 16'])[1]")
	WebElement click_on_kebab;
	
	public void Onclicks_kebabu_menu () {
		wait.until(ExpectedConditions.visibilityOf(Branches_display)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(click_on_kebab)).click();	
	}

	@FindBy(xpath = "(//a[normalize-space()='Edit'])[1]")
	WebElement click_edit;
	
	public void Onclicks_Edit () {
        wait.until(ExpectedConditions.visibilityOf(click_edit)).click();	
	}
	
	@FindBy(id = "Edit Branch")
	WebElement click_updatebuttn;
	
	@FindBy(xpath = "(//h4[normalize-space()='Edit Branch'])[1]")
	WebElement editbranch_displayed;
	
	public void Update_Branch () {
		wait.until(ExpectedConditions.visibilityOf(editbranch_displayed)).isDisplayed();
		branch_name.sendKeys(Keys.CONTROL, "a" ,Keys.DELETE);
		String branchname = prop.getProperty("branchname");
		wait.until(ExpectedConditions.visibilityOf(branch_name)).sendKeys(generateUniqueNumber(""+branchname));
        wait.until(ExpectedConditions.visibilityOf(click_updatebuttn)).click();	
	}
	
}	