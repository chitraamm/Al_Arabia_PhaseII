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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import io.cucumber.core.backend.Options;
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
	private WebElement BB_no_select;

	@FindBy(id = "react-select-16-input")
	private WebElement Department_select;

	@FindBy(id = "react-select-17-input")
	private WebElement Priority_select;

	@FindBy(id = "react-select-18-input")
	private WebElement Ticket_title_select;

	@FindBy(id = "react-select-19-input")
	private WebElement Assignee_select;

	@FindBy(xpath = "//input[@id='formikDateField_start_date']")
	private WebElement Start_date;

	@FindBy(xpath = "//input[@id='formikDateField_end_date']")
	private WebElement End_date;

	@FindBy(xpath = "//textarea[@id='description']")
	private WebElement Description_enter;

	public void NewTicket_mandatory_fields_enter() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(BB_no_select));

		act.moveToElement(BB_no_select).click().sendKeys("" + Keys.ENTER).perform();
		
		String Departmnt = prop.getProperty("Departmnt");
		wait.until(ExpectedConditions.visibilityOf(Department_select)).sendKeys(Departmnt);
		Thread.sleep(1000);
		act.moveToElement(Department_select).click().sendKeys(""+Keys.ENTER+Keys.ARROW_RIGHT).perform();
		
		act.moveToElement(Priority_select).click().sendKeys("" + Keys.ENTER).perform();
			
		String Tckt_title = prop.getProperty("Tckt_title");
		wait.until(ExpectedConditions.visibilityOf(Ticket_title_select)).sendKeys(Tckt_title);
		Thread.sleep(2000);
		act.moveToElement(Ticket_title_select).click().sendKeys(""+Keys.ENTER+Keys.ARROW_RIGHT).perform();

		Thread.sleep(2000);
		String Assignee = prop.getProperty("Assignee");
		wait.until(ExpectedConditions.visibilityOf(Assignee_select)).sendKeys(Assignee);
		Thread.sleep(5000);
		act.moveToElement(Assignee_select).click().sendKeys(""+Keys.ENTER+Keys.ARROW_RIGHT).perform();
		
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
		WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(Ticket_created_Success_display));
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
		wait.until(ExpectedConditions.visibilityOf(city_select)).sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER);
		LOGGER.info(">> User selected the city:" + city_select.getText());
		act.moveToElement(Tickets_filter_apply_btn).click().perform();
		System.out.println(">> User selected the city in filter");
	}

	@FindBy(id = "react-select-6-input")
	private WebElement department_select;

	public void select_Department() {
		wait.until(ExpectedConditions.visibilityOf(Tickets_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(department_select)).click();
		wait.until(ExpectedConditions.visibilityOf(department_select)).sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER);
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

	@FindBy(xpath = "(//div[normalize-space()='As Excel'])[1]")
	private WebElement tickets_Download_excel;

	public void Tickets_Download_Excel() {
		wait.until(ExpectedConditions.visibilityOf(tickets_Download_excel)).click();
	}

	@FindBy(xpath = "//div[normalize-space()='As PDF']")
	private WebElement tickets_Download_pdf;

	public void Tickets_Download_PDF() {
		wait.until(ExpectedConditions.visibilityOf(tickets_Download_pdf)).click();
	}

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement ticket_Download_popupclose;

	public void Ticket_Download_popup_close() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(ticket_Download_popupclose)).click();
	}

	public void Ticket_Download_popupclosd_displayed_Tickets() {
		wait.until(ExpectedConditions.visibilityOf(ticketsCount)).isDisplayed();
		AssertJUnit.assertTrue(ticketsCount.isDisplayed());
		LOGGER.info(">> The Download Popup get closed and listed Tickets");
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[3]/div/table/tbody/tr[1]/td[6]/div[1]/div/img")
	private WebElement tickets_Edit_Buttonclick;

	public void Tickets_Edit_icon() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(tickets_Edit_Buttonclick)).click();
	}
	@FindBy(xpath = "(//img[contains(@class,'pointer')])[3]")
	private WebElement view_tickets_Edit_Buttonclick;

	public void Edit_View_Ticket() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(view_tickets_Edit_Buttonclick)).click();
	}

	@FindBy(xpath = "(//h5[normalize-space()='All Tickets'])[1]")
	private WebElement ticket_Edit_page_display;

	public void Ticket_Edit_page() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(ticket_Edit_page_display)).isDisplayed();
		AssertJUnit.assertTrue(ticket_Edit_page_display.isDisplayed());
		LOGGER.info(">>Ticket edit page displayed");

	}

	@FindBy(xpath = "//tbody/tr[1]/td[6]/div[2]/div[1]/img[1]")
	private WebElement ticket_delete_click;

	public void Ticket_delete_icon() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(ticket_delete_click)).click();
	}

	@FindBy(xpath = "//h6[normalize-space()='Yes, delete it.']")
	private WebElement ticket_delete_confirm_bttn;

	public void Ticket_delete_popup_confirmed() {
		wait.until(ExpectedConditions.visibilityOf(ticket_delete_confirm_bttn)).click();
	}

	@FindBy(xpath = "(//textarea[@id='description'])[1]")
	private WebElement edit_description;

	@FindBy(xpath = "//div[@class='p-5 mt-4 rounded-1 ']")
	private WebElement edit_priority_label;

	public void Description_edit() {

		wait.until(ExpectedConditions.visibilityOf(edit_priority_label));
		String EditDescription = prop.getProperty("EditDescription");
		act.moveToElement(edit_description).click().sendKeys(EditDescription);
		LOGGER.info("User updated the description ");
	}

	@FindBy(id = "Update Ticket")
	private WebElement ticket_update_button;

	public void Ticket_update_clicked() throws Exception {
		Thread.sleep(2000);
		act.moveToElement(ticket_update_button).perform();
		wait.until(ExpectedConditions.visibilityOf(ticket_update_button)).click();

	}
	@FindBy(xpath = "//h6[normalize-space()='Yes, update it.']")
	private WebElement ticket_update_confirm_yes_button;

	public void Update_Ticket_confirmed() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(ticket_update_confirm_yes_button)).click();

	}
	@FindBy(xpath = "//span[normalize-space()='Activity Feed']")
	private WebElement click_Activity_feed;
	@FindBy(xpath = "//span[@class='edit_link_routes active']")
	private WebElement view_ticket_tab;

	public void Activity_Feed_Display() throws Exception {
		// wait.until(ExpectedConditions.visibilityOf(view_ticket_tab));
		wait.until(ExpectedConditions.visibilityOf(click_Activity_feed)).click();
	}

	@FindBy(xpath = "//span[normalize-space()='Activity Feed']")
	private WebElement activity_Feed_display;

	public void Activity_Feed_Displayed() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(activity_Feed_display));
		AssertJUnit.assertTrue(activity_Feed_display.isDisplayed());
		LOGGER.info("Activity Feed page displayed");
	}

	@FindBy(xpath = "//input[@accept='image/png, image/gif, image/jpeg']")

	private WebElement Click_upload_photos;

	public void Upload_Photos() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(edit_priority_label));
		act.moveToElement(Click_upload_photos).perform();
		String image = System.getProperty("user.dir") + "/Documents/Image.png";
		Click_upload_photos.sendKeys(image);
	}
	@FindBy(xpath = "//input[@class='inputfilevideo']")
	private WebElement click_upload_videos;
	
	public void Upload_videos() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(edit_priority_label));
		act.moveToElement(click_upload_videos).perform();
		String video = System.getProperty("user.dir") + "/Documents/Video.webm";
		click_upload_videos.sendKeys(video);
	}
	@FindBy(xpath = "//h6[normalize-space()='VOICE']")
	private WebElement click_upload_voice;
	@FindBy(xpath = "//h6[normalize-space()='Record']")
	private WebElement record_button;
	@FindBy(xpath = "//h6[normalize-space()='Stop']")
	private WebElement stop_button;
	@FindBy(xpath = "//span[contains(@class,'fw-semibold')]")
	private WebElement update_audio_button;
	@FindBy(xpath = "//div[@class=' d-flex justify-content-end']//img")
	private WebElement record_close_button;
	
	public void Upload_voice() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(edit_priority_label));
		act.moveToElement(click_upload_voice).perform();
		wait.until(ExpectedConditions.visibilityOf(click_upload_voice)).click();
		wait.until(ExpectedConditions.visibilityOf(record_button)).click();
	//	Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOf(stop_button)).click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOf(update_audio_button)).click();
		wait.until(ExpectedConditions.visibilityOf(record_close_button)).click();

	}
	@FindBy(xpath = "//div[contains(@class,'attachment position-relative')]//img[contains(@class,'position-absolute x_close')]")
	private WebElement click_uploaded_photo_close;
	public void Upload_photo_close() throws Exception {
	act.moveToElement(click_uploaded_photo_close).perform();
		wait.until(ExpectedConditions.visibilityOf(click_uploaded_photo_close)).click();;
	}
	@FindBy(xpath = "//h6[normalize-space()='Yes, remove it.']")
	private WebElement click_uploaded_photo_close_confirm;
	public void Upload_photo_close_confirmed() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(click_uploaded_photo_close_confirm)).click();;
	}
	@FindBy(xpath = "//div[@class=' d-flex py-5 flex-wrap gap-4']")
	private WebElement attach_medias;
	@FindBy(xpath = "//img[@class=' position-absolute x_close']")
	private WebElement click_uploaded_video_close;
	public void Upload_video_close() throws Exception {
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(attach_medias));

		act.moveToElement(click_uploaded_video_close).perform();
		wait.until(ExpectedConditions.visibilityOf(click_uploaded_video_close)).click();
	}
	@FindBy(xpath = "//h6[normalize-space()='Yes, remove it.']")
	private WebElement click_uploaded_video_close_confirm;
	public void Upload_video_close_confirmed() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(click_uploaded_video_close_confirm)).click();;
	}
	@FindBy(xpath = "//h6[normalize-space()='Verify']")
	private WebElement click_verify_button;
	public void Verify() throws Exception {
		Thread.sleep(2000);
		act.moveToElement(click_verify_button).perform();
		wait.until(ExpectedConditions.visibilityOf(click_verify_button)).click();;
	}
	@FindBy(xpath = "(//h6[normalize-space()='Yes, verify it.'])[1]")
	private WebElement click_verify_confirm_button;
	public void confirm_verify() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(click_verify_confirm_button)).click();
	}
	@FindBy(xpath = "//h6[normalize-space()='Reassign']")
	private WebElement click_reassign_button;
	public void Reassign() throws Exception {
		Thread.sleep(2000);
		act.moveToElement(click_reassign_button).perform();
		wait.until(ExpectedConditions.visibilityOf(click_reassign_button)).click();;
	}
	@FindBy(xpath = "//h6[normalize-space()='Yes, reassign it.']")
	private WebElement click_reassign_confirm_button;
	public void confirm_Reassign() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(click_reassign_confirm_button)).click();
	}
	@FindBy(xpath = "//h6[normalize-space()='Approve']")
	private WebElement click_approve_button;
	public void Approve() throws Exception {
		Thread.sleep(2000);
		act.moveToElement(click_approve_button).perform();
		wait.until(ExpectedConditions.visibilityOf(click_approve_button)).click();;
	}
	@FindBy(xpath = "//h6[normalize-space()='Yes, approve it.']")
	private WebElement click_approve_confirm_button;
	public void confirm_Approve() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(click_approve_confirm_button)).click();
	}
	@FindBy(xpath = "//button[@id='Reject']")
	private WebElement click_reject_button;
	public void Reject() throws Exception {
		Thread.sleep(2000);
		act.moveToElement(click_reassign_button).perform();
		wait.until(ExpectedConditions.visibilityOf(click_reject_button)).click();;
	}
	@FindBy(xpath = "//h6[normalize-space()='Yes, reject it.']")
	private WebElement click_reject_confirm_button;
	public void confirm_Reject() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(click_reject_confirm_button)).click();
	}
	@FindBy(id = "Start Conversation")
	private WebElement click_start_conversation;

	public void Start_conversation() throws Exception {
		Thread.sleep(2000);
		act.moveToElement(click_start_conversation).perform();
		wait.until(ExpectedConditions.visibilityOf(click_start_conversation)).click();
	}
	@FindBy(xpath = "(//h5[normalize-space()='Ticket'])[1]")
	private WebElement chat_page_display;

	public void Chat_page_Displayed() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(chat_page_display));
		AssertJUnit.assertTrue(chat_page_display.isDisplayed());
		LOGGER.info("Chat page displayed");
	}
	@FindBy(xpath = "//div[normalize-space()='2']")
	private WebElement click_second_page;
	public void Second_page() throws Exception {
		act.scrollToElement(click_second_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_second_page)).click();
	}
	@FindBy(xpath = "//div[contains(text(),'Showing')]")
	private WebElement second_page_display;
	public void Second_page_Display() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(second_page_display));
		AssertJUnit.assertTrue(second_page_display.isDisplayed());
	}
	@FindBy(xpath = "(//div[contains(@class,'round-effect')][contains(text(),'›')])[1]")
	private WebElement click_next_page;
	public void next_page() throws Exception {
		act.scrollToElement(click_next_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_next_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[1]")
	private WebElement click_previous_page;
	public void Previous_page() throws Exception {
		act.scrollToElement(click_previous_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_previous_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[5]")
	private WebElement click_last_page;
	public void last_page() throws Exception {
		act.scrollToElement(click_last_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_last_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[1]")
	private WebElement click_first_page;
	public void First_page() throws Exception {
		act.scrollToElement(click_first_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_first_page)).click();
	}
	@FindBy(xpath = "//h6[normalize-space()='Reset Form']")
	private WebElement ticket_reset_button;

	public void Ticket_Reset_clicked() throws Exception {
		Thread.sleep(2000);
		act.moveToElement(ticket_reset_button).perform();
		wait.until(ExpectedConditions.visibilityOf(ticket_reset_button)).click();
	}
	@FindBy(xpath = "//h6[normalize-space()='Yes, reset it.']")
	private WebElement ticket_reset_confirm_yes_button;

	public void Reset_Ticket_confirmed() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(ticket_reset_confirm_yes_button)).click();
	}
	@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[9]")
	private WebElement created_Tickmark;
	public void Created_Tick_display () throws Exception {
		wait.until(ExpectedConditions.visibilityOf(created_Tickmark)).isDisplayed();
		AssertJUnit.assertTrue(created_Tickmark.isDisplayed());
	}
	@FindBy(xpath = "(//*[name()='svg'][contains(@stroke,'currentColor')])[10]")
	private WebElement viewed_Tickmark;
	public void Viewed_Tick_display () throws Exception {
		wait.until(ExpectedConditions.visibilityOf(viewed_Tickmark)).isDisplayed();
		AssertJUnit.assertTrue(viewed_Tickmark.isDisplayed());
	}
	@FindBy(xpath = "(//*[name()='svg'][contains(@stroke,'currentColor')])[11]")
	private WebElement submitted_Tickmark;
	public void Submitted_Tick_display () throws Exception {
		wait.until(ExpectedConditions.visibilityOf(submitted_Tickmark)).isDisplayed();
		AssertJUnit.assertTrue(submitted_Tickmark.isDisplayed());
	}
	@FindBy(xpath = "(//*[name()='path'])[16]")
	private WebElement overdued_Tickmark;
	public void Overdued_Tick_display () throws Exception {
		wait.until(ExpectedConditions.visibilityOf(overdued_Tickmark)).isDisplayed();
		AssertJUnit.assertTrue(overdued_Tickmark.isDisplayed());
	}
}
