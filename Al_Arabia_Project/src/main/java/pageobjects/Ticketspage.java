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

public class Ticketspage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Actions act;
	private Logger LOGGER = LogManager.getLogger(Ticketspage.class);
	private Signinpage signinpage;

	public Ticketspage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		this.signinpage = new Signinpage(driver);
		LOGGER = LogManager.getLogger(Ticketspage.class.getName());
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
	
	@FindBy(xpath = "//span[normalize-space()='Tickets']")
	private WebElement ticketsClick;

	@FindBy(xpath = "(//td[contains(@class,'d-flex')])[2]")
	private WebElement tickets_menu; 

	public void Tickets_click() {
		wait.until(ExpectedConditions.elementToBeClickable(ticketsClick)).click();
		wait.until(ExpectedConditions.visibilityOf(tickets_menu)).isDisplayed();
		LOGGER.info(">> Admin/User got navigated to Tickets page");
	}
	
	@FindBy(xpath = "(//h5[contains(@class,'mb-0')])[1]")
	private WebElement ticketsCount;

	public void allticketsCount() {
		wait.until(ExpectedConditions.visibilityOf(ticketsCount)).isDisplayed();
		AssertJUnit.assertTrue(ticketsCount.isDisplayed());
		LOGGER.info(">> The Tickets page got displayed");
	}
	
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='New Ticket'])[1]")
	private WebElement New_TicketClick, New_Ticket_display;

	public void New_TicketClick() {
		wait.until(ExpectedConditions.visibilityOf(New_TicketClick)).click();
		LOGGER.info(">> Admin/User clicked New Ticket btn");
	}

	public void New_billboard_display() {
		act.moveToElement(New_Ticket_display).perform();

		wait.until(ExpectedConditions.visibilityOf(New_Ticket_display));

		if (New_Ticket_display.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new billboard btn");
	}
	
	@FindBy(id = "react-select-15-input")
	private WebElement BB_no_select ;
	
	@FindBy(id = "react-select-16-input")
	private WebElement Department_select ;
	
	@FindBy(id = "react-select-17-input")
	private WebElement Priority_select ;
	
	@FindBy(id = "react-select-18-input")
	private WebElement Ticket_title_select ;
	
	@FindBy(xpath = "(//div[contains(@class,'select__input-container css-19bb58m')])[5]")
	private WebElement Assignee_select ;
	
	@FindBy(xpath = "//input[@id='formikDateField_start_date']")
	private WebElement Start_date ;
	
	@FindBy(xpath = "//input[@id='formikDateField_end_date']")
	private WebElement End_date ;
	
	@FindBy(xpath = "//textarea[@id='description']")
	private WebElement Description_enter;
	
	public void NewTicket_mandatory_fields_enter() {
		wait.until(ExpectedConditions.visibilityOf(BB_no_select));

		act.moveToElement(BB_no_select).click().sendKeys("" + Keys.ENTER).perform();
		act.moveToElement(Department_select).click().sendKeys("" + Keys.ENTER).perform();
		act.moveToElement(Priority_select).click().sendKeys("" + Keys.ENTER).perform();
		act.moveToElement(Ticket_title_select).click().sendKeys("" + Keys.ENTER).perform();
		act.moveToElement(Assignee_select).click().sendKeys("" + Keys.ENTER).perform();
		act.moveToElement(Start_date).click().sendKeys("" + Keys.ENTER).perform();
		wait.until(ExpectedConditions.visibilityOf(Start_date));

		act.moveToElement(End_date).click().sendKeys("" + Keys.ENTER).perform();
		String Description = prop.getProperty("Description");
		wait.until(ExpectedConditions.visibilityOf(Description_enter)).sendKeys(Description);
}
	@FindBy(id = "Create Ticket")
	private WebElement Ticket_create_BB_btn;

	public void NewTicket_create_btn() {
		act.moveToElement(Ticket_create_BB_btn).click().perform();
	}
	
	@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
	private WebElement Ticket_created_Success_display;

	public String ticket_create_Success_display() throws Exception {
		WebElement successMessageElement = wait
				.until(ExpectedConditions.visibilityOf(Ticket_created_Success_display));
		return successMessageElement.getText().trim();
	}
}
