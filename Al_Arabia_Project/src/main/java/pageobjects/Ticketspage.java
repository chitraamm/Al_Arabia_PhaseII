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
	@FindBy(id = "doc_searchQueryInput")
	private WebElement TicketSearch;

	public void Ticket_search_enter_text() {
		wait.until(ExpectedConditions.visibilityOf(TicketSearch)).click();
		String ticket_search = prop.getProperty("Ticketno");
		wait.until(ExpectedConditions.visibilityOf(TicketSearch)).sendKeys(ticket_search + Keys.ENTER);
		System.out.println(">> User enter the Ticket number in search field: " + ticket_search);
	}

	@FindBy(xpath = "//tbody/tr[@class='table_white']/td[1]/div[1]")
	private WebElement ticketSearchedList, Ticketlist;

	public void TicketSearchedList() {
		wait.until(ExpectedConditions.visibilityOf(ticketSearchedList));

		if (ticketSearchedList.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new ticket btn");
		System.out.println(">> User got searched BB list: " + ticketSearchedList.getText());
	}

	public void Ticketlist() {
		wait.until(ExpectedConditions.visibilityOf(ticketSearchedList));

		if (Ticketlist.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new ticket btn");
		System.out.println(">> User got sorted Ticket list: " + Ticketlist.getText());
	}
	@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
	private WebElement ticket_sort;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement tickets_sort_recentlyupdated;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
	private WebElement tickets_sort_recentlyadded;

	public void Tickets_sort_recentlyupdated() {
		wait.until(ExpectedConditions.visibilityOf(ticket_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(tickets_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void Tickets_sort_recentlyadded() {
		wait.until(ExpectedConditions.visibilityOf(ticket_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(tickets_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently added in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement ticket_Name_A_to_Z;

	public void Ticket_A_to_Z() {
		wait.until(ExpectedConditions.visibilityOf(ticket_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(ticket_Name_A_to_Z)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
	private WebElement ticket_Name_Z_to_A;

	public void Ticket_sortZ_A() {
		wait.until(ExpectedConditions.visibilityOf(ticket_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(ticket_Name_Z_to_A)).click();
		System.out.println(">> User clicked Z-A updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	private WebElement Ticket_Name_decending;

	public void Ticket_DecendingDate() {
		wait.until(ExpectedConditions.visibilityOf(ticket_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(Ticket_Name_decending)).click();
		System.out.println(">> User clicked decending updated in sort");
	}
	@FindBy(xpath = "(//h6[contains(@class,'mb-0 by fw-normal')][normalize-space()='Filter By'])[1]")
	private WebElement Tickets_filter;
	
	@FindBy(xpath = "(//span[contains(text(),'Closed')])[1]")
	private WebElement closed_status;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement Tickets_filter_apply_btn;

	public void Tickets_status_closed() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(closed_status)).click();
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User clicked closed status in filter");
	}
	@FindBy(xpath = "//div[contains(text(),'No Tickets Found')]")
	private WebElement No_Tickets_found;
	
	public void Tickets_filtered_result_display() {
		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(Ticketlist));
				AssertJUnit.assertTrue(Ticketlist.isDisplayed());
				System.out.println(">> User got the filtered Tickets list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(No_Tickets_found));
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(No_Tickets_found));
		}
	}
	@FindBy(xpath = "(//span[contains(text(),'Created')])[1]")
	private WebElement Tickets_created;

	public void Tickets_status_created() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(Tickets_created)).click();
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Created status in filter");
	}
	@FindBy(xpath = "(//span[contains(text(),'Reassigned')])[1]")
	private WebElement Tickets_Reassigned;

	public void Tickets_status_Reassigned() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(Tickets_Reassigned)).click();
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Reassigned status in filter");
	}
	
	@FindBy(xpath = "(//span[contains(text(),'Submitted')])[1]")
	private WebElement Tickets_Submitted;

	public void Tickets_status_Submitted() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(Tickets_Submitted)).click();
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Submitted status in filter");
	}
	
	@FindBy(xpath = "(//span[contains(text(),'Viewed')])[1]")
	private WebElement Tickets_Viewed;

	public void Tickets_status_Viewed() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(Tickets_Viewed)).click();
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Viewed status in filter");
	}
	@FindBy(xpath = "(//span[contains(text(),'Verified')])[1]")
	private WebElement Tickets_Verifed;

	public void Tickets_status_Verified() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(Tickets_Verifed)).click();
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Verifed status in filter");
	}
	@FindBy(xpath = "(//span[contains(text(),'Overdue')])[1]")
	private WebElement Tickets_Overdue;
	
	public void Tickets_status_Overdue() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(Tickets_Overdue)).click();
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Verifed status in filter");
	}
	public void Multiple_Ticket_statuses() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(closed_status)).click();
	
		act.moveToElement(Tickets_created).click().perform();
		act.moveToElement(Tickets_Reassigned).click().perform();
		act.moveToElement(Tickets_Submitted).click().perform();
		act.moveToElement(Tickets_Verifed).click().perform();
		act.moveToElement(Tickets_Viewed).click().perform();
		act.moveToElement(Tickets_Overdue).click().perform();
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Verifed status in filter");
	}
	@FindBy(id = "react-select-3-input")
	private WebElement billboard_number;

	public void select_BB_Number() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		String BB_NO = prop.getProperty("bb_no");
		wait.until(ExpectedConditions.visibilityOf(billboard_number)).click();
		wait.until(ExpectedConditions.visibilityOf(billboard_number)).sendKeys(BB_NO + Keys.ENTER);
		LOGGER.info(">> User selected the Billboard number:" + billboard_number.getText());
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User selected the billboard number in filter" + BB_NO);
	}
	@FindBy(id = "react-select-4-input")
	private WebElement assignee_select;

	public void select_Assignee() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		String assignee = prop.getProperty("assignee");
		wait.until(ExpectedConditions.visibilityOf(assignee_select)).click();
		wait.until(ExpectedConditions.visibilityOf(assignee_select)).sendKeys(assignee + Keys.ENTER);
		LOGGER.info(">> User selected the assignee:" + assignee_select.getText());
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User selected the assignee in filter" + assignee);
	}
	@FindBy(id = "react-select-5-input")
	private WebElement city_select;

	public void select_City() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(city_select)).click();
		wait.until(ExpectedConditions.visibilityOf(city_select)).sendKeys(""+ Keys.ARROW_DOWN + Keys.ENTER);
		LOGGER.info(">> User selected the city:" + city_select.getText());
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User selected the city in filter");
	}
	@FindBy(id = "react-select-6-input")
	private WebElement department_select;

	public void select_Department() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(department_select)).click();
		wait.until(ExpectedConditions.visibilityOf(department_select)).sendKeys(""+ Keys.ARROW_DOWN + Keys.ENTER);
		LOGGER.info(">> User selected the department:" + department_select.getText());
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User selected the department in filter");
	}
	@FindBy(xpath = "(//div[contains(@class,'ps-4 pe-1 fw-semibold off')][normalize-space()='Non-Cleaning'])[1]")
	private WebElement Click_Cleaning_Ticket;

	public void Cleaning_Ticket() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(Click_Cleaning_Ticket)).click();
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Cleaning Ticket in filter");
	}
	@FindBy(xpath = "(//div[contains(@class,'pe-4 fw-semibold on')][normalize-space()='Cleaning'])[1]")
	private WebElement Click_non_Cleaning_Ticket;

	public void Non_Cleaning_Ticket() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(Click_non_Cleaning_Ticket)).click();
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Non Cleaning Ticket in filter");
	}
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='Download'])[1]")
	private WebElement download_buttn_ticketspage;

	public void Download_button_Ticketspage() {
		//wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		//wait.until(ExpectedConditions.visibilityOf(Click_non_Cleaning_Ticket)).click();
		act.moveToElement(download_buttn_ticketspage).click().perform();
		System.out.println(">> User clicked Download button");
	}
	@FindBy(xpath = "//div[@class='modal-header']")
	private WebElement tickets_Download_popup_display;

	public void Tickets_Download_popup_display() {
		wait.until(ExpectedConditions.visibilityOf(tickets_Download_popup_display)).isDisplayed();
		AssertJUnit.assertTrue(tickets_Download_popup_display.isDisplayed());
		LOGGER.info(">> The Download Popup got displayed");
	}
}
