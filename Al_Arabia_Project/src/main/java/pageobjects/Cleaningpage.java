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

public class Cleaningpage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Actions act;
	private Logger LOGGER = LogManager.getLogger(Cleaningpage.class);
	private Signinpage signinpage;


	public Cleaningpage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		this.signinpage = new Signinpage(driver);
		LOGGER = LogManager.getLogger(Cleaningpage.class.getName());
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
	
	@FindBy(xpath = "//span[normalize-space()='Cleaning']")
	private WebElement cleaningClick;

	@FindBy(xpath = "//span[normalize-space()='Cleaning']")
	private WebElement cleaning_menu;

	public void Cleaning_click() {
		wait.until(ExpectedConditions.elementToBeClickable(cleaningClick)).click();
		wait.until(ExpectedConditions.visibilityOf(cleaning_menu)).isDisplayed();
		LOGGER.info(">> Admin/User got navigated to cleaning page");
	}

	@FindBy(xpath = "//h5[contains(@class,'mb-0')]")
	private WebElement cleaningCount;

	public void AllcleaningCount() {
		wait.until(ExpectedConditions.visibilityOf(cleaningCount)).isDisplayed();
		AssertJUnit.assertTrue(cleaningCount.isDisplayed());
		LOGGER.info(">> The Cleaning page got displayed");
	}
	
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='New Group'])[1]")
	private WebElement click_New_Group_button;
	
	public void New_Group_button() {
		wait.until(ExpectedConditions.visibilityOf(click_New_Group_button)).click();
	}
	@FindBy(id = "group_name")
	private WebElement group_Name;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/form/div/div[1]/div/div[2]/div/div/div/div/div[1]/div")
	private WebElement ticket_title;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/form/div/div[1]/div/div[4]/div/div/div/div/div[1]/div")
	private WebElement schedule;
	
	@FindBy(id = "react-select-11-input")
	private WebElement Billboard_Type ;
	
	@FindBy(id = "react-select-14-input")
	private WebElement Billboards;
	
	@FindBy(xpath = "//div[contains(text(),'Medium')]")
	private WebElement Priority;
	
	@FindBy(xpath = "react-select-16-input")
	private WebElement Assignee;
	
	@FindBy(xpath = "//input[@name='start_date']")
	private WebElement Start_Date;
	
	@FindBy(xpath = "//input[@name='start_date']")
	private WebElement selected_start_date;
	
//	@FindBy(xpath = "//input[@name='invoice_date']")
//	private WebElement End_Date;
	
	@FindBy(xpath = "//textarea[@id='description']")
	private WebElement Description;
	
	public void Mandatory_fields_enter_new_cleaning() throws Exception {

	String groupname = prop.getProperty("groupname");
	wait.until(ExpectedConditions.visibilityOf(group_Name)).sendKeys(groupname);
	
	wait.until(ExpectedConditions.visibilityOf(group_Name)).isDisplayed();
	Thread.sleep(1000);
	act.moveToElement(ticket_title).click().sendKeys(""+Keys.ENTER).perform();
	
	wait.until(ExpectedConditions.visibilityOf(ticket_title)).isDisplayed();
	Thread.sleep(1000);
	act.moveToElement(schedule).click().sendKeys(""+Keys.ARROW_DOWN+Keys.ENTER).perform();
	
	String billboard = prop.getProperty("billboardsname");
	Thread.sleep(1000);

    act.moveToElement(Billboards).click().sendKeys(""+(billboard)).perform();
    
    String assignee = prop.getProperty("assigneename");
    act.moveToElement(Assignee).click().sendKeys(""+(assignee)).perform();
    
    act.moveToElement(Start_Date).click().perform();
    act.moveToElement(selected_start_date).click().perform();

    String description = prop.getProperty("description_texts");
    act.moveToElement(Assignee).click().sendKeys(""+(description)).perform();
	}
	@FindBy(id = "Create Group")
	private WebElement create_group;

	public void Create_group_button() {
		wait.until(ExpectedConditions.visibilityOf(cleaningCount)).isDisplayed();
		act.moveToElement(create_group).click().perform();
	}
}