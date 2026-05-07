package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
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

public class Billboardspage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Actions act;
	private Logger LOGGER = LogManager.getLogger(Billboardspage.class);


	public Billboardspage(WebDriver driver) throws Exception { 
		this.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		LOGGER = LogManager.getLogger(Billboardspage.class.getName());
	}
	private boolean condition = true;
	private void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	private static String generateUniqueboardNumber(String baseboardNumber) {
		Random rand = new Random();
		return baseboardNumber + rand.nextInt(1000);
	}
	private static String generateUniqueboardName(String baseboardName) {
		Random rand = new Random();
		return baseboardName + rand.toString();
	}
//<-------------------BillBoards------------------------------------------>
	@FindBy(xpath = "//span[normalize-space()='BillBoards']")
	private WebElement billboardClick;

	@FindBy(xpath = "//table[contains(@class,'table')]")
	private WebElement billboardMenu; //

	public void billboardClick() {
		wait.until(ExpectedConditions.elementToBeClickable(billboardClick)).click();
		wait.until(ExpectedConditions.visibilityOf(billboardMenu)).isDisplayed();
		LOGGER.info(">> Admin/User got navigated to billboard page");
	}

	@FindBy(xpath = "//div[@class='members ']")
	private WebElement allBillboardsCount;

	public void allBillboardsCount() {
		wait.until(ExpectedConditions.visibilityOf(allBillboardsCount)).isDisplayed();
		AssertJUnit.assertTrue(allBillboardsCount.isDisplayed());
		LOGGER.info(">> The billboard dashboard list page got displayed");
	}

	@FindBy(id = "New BillBoard")
	private WebElement New_billboardClick, New_billboard_display;

	public void New_billboardClick() {
		wait.until(ExpectedConditions.visibilityOf(New_billboardClick)).click();
		LOGGER.info(">> Admin/User clicked new billboard btn");
	}

	public void New_billboard_display() {
		act.moveToElement(New_billboard_display).perform();

		wait.until(ExpectedConditions.visibilityOf(New_billboard_display));

		if (New_billboard_display.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new billboard btn");
	}

	@FindBy(id = "board_no")
	private WebElement Newbillboard_boardno;

	@FindBy(xpath = "(//input[@placeholder='Enter Location'])[1]")
	private WebElement Newbillboard_BB_location;

	@FindBy(xpath = "(//*[name()='svg'][@class='css-tj5bde-Svg'])[2]")
	private WebElement Newbillboard_BB_type;

	@FindBy(xpath = "//div[@class='select__menu css-1nmdiq5_menu'][1]")
	private WebElement Newbillboard_BB_type1;

	@FindBy(xpath = "(//*[name()='svg'][@class='css-tj5bde-Svg'])[3]")
	private WebElement Newbillboard_BOM_type;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]")
	private WebElement Newbillboard_city;

	@FindBy(id = "team_viewer_id")
	private WebElement Newbillboard_teamviewer_id;

	@FindBy(id = "team_viewer_password")
	private WebElement Newbillboard_teamviewer_password;

	@FindBy(id = "longitude")
	private WebElement Newbillboard_longtitude;

	@FindBy(id = "latitude")
	private WebElement Newbillboard_lontitude;

	@FindBy(id = "screen_width")
	private WebElement Newbillboard_screen_width;

	@FindBy(id = "screen_height")
	private WebElement Newbillboard_screen_height;

	@FindBy(xpath = "(//*[name()='svg'][contains(@class,'css-tj5bde-Svg')])[4]")
	private WebElement Newbillboard_screen_resolution;

	@FindBy(xpath = "(//*[name()='svg'][contains(@class,'css-tj5bde-Svg')])[5]")
	private WebElement Newbillboard_screen_units;

	@FindBy(xpath = "(//*[name()='svg'][contains(@class,'css-tj5bde-Svg')])[6]")
	private WebElement Newbillboard_screen_pixel;

	@FindBy(id = "screen_model")
	private WebElement Newbillboard_screen_model;
	
	@FindBy(id = "formikDateField_contract_start_date")
	private WebElement Contract_startdate;
	
	@FindBy(xpath = "(//input[@id='formikDateField_contract_end_date'])[1]")
	private WebElement Contract_enddate;
	
	@FindBy(xpath = "(//button[@class='rmdp-arrow-container rmdp-right '])[1]")
	private WebElement display_datepicker_end_date;
	
	@FindBy(xpath = "(//span[normalize-space()='30'])[1]")
	private WebElement select_Contract_enddate;

	public void NewBillboard_mandatory_fields_enter() throws Exception {
		String uniqueboardno = generateUniqueboardNumber(prop.getProperty("BB_NO"));
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_boardno)).sendKeys(uniqueboardno);
	    wait.until(ExpectedConditions.visibilityOf(Newbillboard_BB_location)).sendKeys(""+"riyadh"); Thread.sleep(2000);
	    wait.until(ExpectedConditions.visibilityOf(Newbillboard_BB_location)).sendKeys(""+Keys.DOWN+Keys.ENTER);
		act.moveToElement(Newbillboard_BB_type).click().sendKeys("" + Keys.ENTER).perform();
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_BOM_type)).click();Thread.sleep(2000);
		act.moveToElement(Newbillboard_BOM_type).click().sendKeys("" + Keys.DOWN+Keys.ENTER).perform();

		wait.until(ExpectedConditions.visibilityOf(Newbillboard_teamviewer_id)).sendKeys("123456789");
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_teamviewer_password)).sendKeys("Password@123");
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_screen_width)).sendKeys("80");
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_screen_height)).sendKeys("40");
		
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_screen_height)).isDisplayed();
		act.moveToElement(Newbillboard_screen_resolution).click().sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER).perform();
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_screen_resolution)).isDisplayed();
		act.moveToElement(Newbillboard_screen_units).click().sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER).perform();
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_screen_units)).isDisplayed();
		act.moveToElement(Newbillboard_screen_pixel).click().sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER).perform();
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_screen_pixel)).isDisplayed();
		act.moveToElement(Contract_startdate).click().perform();
		wait.until(ExpectedConditions.visibilityOf(Contract_startdate)).isDisplayed();
		act.moveToElement(Contract_enddate).click().perform();
		wait.until(ExpectedConditions.visibilityOf(display_datepicker_end_date)).isDisplayed();
		act.moveToElement(select_Contract_enddate).click().perform();

	
	}
	
	@FindBy(xpath = "//div[@class='d-flex justify-content-between py-5']")
	private WebElement create_BB_container;
	
	@FindBy(xpath = "(//button[@id='Reset Form'])[1]")
	private WebElement scrollto_add;

	@FindBy(xpath = "(//div[@data-testid='Create Billboard'])[1]")
	private WebElement Newbillboard_create_BB_btn;

	public void Newbillboard_create_BB_btn() throws Exception {
		Thread.sleep(2000);
		act.scrollToElement(scrollto_add).perform();
		act.moveToElement(Newbillboard_create_BB_btn).click().perform();
	}

	@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
	private WebElement billboard_created_Success_display;

	public String billboard_created_Success_display() throws Exception {
		WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(billboard_created_Success_display));
		return successMessageElement.getText().trim();
	}

	@FindBy(id = "doc_searchQueryInput")
	private WebElement BBSearch;

	public void Billboard_search_enter_text() {
		wait.until(ExpectedConditions.visibilityOf(BBSearch)).click();
		String billboard_search = prop.getProperty("BB_NO");
		wait.until(ExpectedConditions.visibilityOf(BBSearch)).sendKeys(billboard_search + Keys.ENTER);
		System.out.println(">> User enter the BB name in search field: " + billboard_search);
	}

	@FindBy(id = "doc_searchQueryInput")
	private WebElement BBSearchedList, BBlist;

	public void BBSearchedList() {
		wait.until(ExpectedConditions.visibilityOf(BBSearchedList));

		if (BBSearchedList.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new billboard btn");
		System.out.println(">> User got searched BB list: " + BBSearchedList.getText());
	}

	public void BBlist() {
		wait.until(ExpectedConditions.visibilityOf(BBSearchedList));

		if (BBlist.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new billboard btn");
		System.out.println(">> User got sorted BB list: " + BBlist.getText());
	}

	@FindBy(xpath = "(//div[contains(@class,'d-flex sortbox')])[1]")
	private WebElement BB_sort;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement Billboards_sort_recentlyupdated;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
	private WebElement Billboards_sort_recentlyadded;

	public void Billboards_sort_recentlyupdated() {
		wait.until(ExpectedConditions.visibilityOf(BB_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(Billboards_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void Billboards_sort_recentlyadded() {
		wait.until(ExpectedConditions.visibilityOf(BB_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(Billboards_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently added in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
	private WebElement Name_A_to_Z;

	public void BB_A_to_Z() {
		wait.until(ExpectedConditions.visibilityOf(BB_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(Name_A_to_Z)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
	private WebElement Name_Z_to_A;

	public void Billboard_sortZ_A() {
		wait.until(ExpectedConditions.visibilityOf(BB_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(Name_Z_to_A)).click();
		System.out.println(">> User clicked Z-A updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	private WebElement Name_decending;

	public void DecendingDate() {
		wait.until(ExpectedConditions.visibilityOf(BB_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(Name_decending)).click();
		System.out.println(">> User clicked decending updated in sort");
	}
	@FindBy(xpath = "(//span[@id='ACTIVE'])[1]")
	private WebElement activestatus;

	public void BB_filter_active() {
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(activestatus)).click();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User clicked active status in filter");
	}
	public void BB_filter_active_32() {
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(activestatus)).click();
		System.out.println(">> User clicked active status in filter");
	}
	@FindBy(xpath = "(//span[@id='NON_OPERATIONAL'])[1]")
	private WebElement Nonoperstatus;

	public void Nonoper() {
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(Nonoperstatus)).click();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Non Oper. status in filter");
	}

	@FindBy(xpath = "(//h6[contains(@class,'mb-0 by fw-normal')][normalize-space()='Filter By'])[1]")
	private WebElement Billboard_filter;

	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='Apply'])[1]")
	private WebElement Billboard_filter_apply_btn;

	@FindBy(xpath = "//div[contains(text(),'No BillBoard Found')]")
	private WebElement billboard_no_BB_found;

	@FindBy(xpath = "(//span[@id='REQUEST'])[1]")
	private WebElement Requeststatus;

	public void BB_filter_Request_list() {
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(Requeststatus)).click();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Request status in filter");
	}

	@FindBy(id = "react-select-3-input")
	private WebElement selectlocationdropdown;


	public void select_bb_location() {
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		String bb_location = prop.getProperty("bb_location");
		wait.until(ExpectedConditions.visibilityOf(selectlocationdropdown)).click();
		wait.until(ExpectedConditions.visibilityOf(selectlocationdropdown)).sendKeys(bb_location + Keys.ENTER);
		LOGGER.info(">> User selected the location:" + selectlocationdropdown.getText());
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User selected the bb location in filter" + bb_location);
	}

	public void select_bb_location32() {
		String bb_location = prop.getProperty("bb_location");
		wait.until(ExpectedConditions.visibilityOf(selectlocationdropdown)).click();
		wait.until(ExpectedConditions.visibilityOf(selectlocationdropdown)).sendKeys(bb_location + Keys.ENTER);
		LOGGER.info(">> User selected the location:" + selectlocationdropdown.getText());
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
	}
	@FindBy(id = "doc_searchQueryInputfilter")
	private WebElement BB_filter_Ticket_count;

	public void BB_filter_ticketcount_enter() {
		String bb_ticket_count = prop.getProperty("bb_ticket_count");
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(BB_filter_Ticket_count)).click();
		BB_filter_Ticket_count.sendKeys(bb_ticket_count);
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User entered the Ticket count in filter");
	}

	@FindBy(xpath = "(//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer'])[2]")
	private WebElement BB_Typedropdown;

	public void select_bb_Type() throws Exception {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		String bb_Type = prop.getProperty("bb_Type");
		act.moveToElement(BB_Typedropdown).click().sendKeys(""+Keys.ENTER).perform();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User selected the bb Type in filter" + bb_Type);
	}

	// <-------------------------------------Filter Online status for Team
	// viewer,Novostar,IVMS ---------------------------------------->

	@FindBy(xpath = "(//span[@id='online'])[1]")
	private WebElement teamvieweronline;
	@FindBy(xpath = "(//span[@id='online'])[2]")
	private WebElement novostaronline;
	@FindBy(xpath = "(//span[@id='online'])[3]")
	private WebElement ivmsonline;

	public void BB_filter_onlinestatus() {

		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(teamvieweronline)).click();
		act.moveToElement(novostaronline).click().perform();
		act.moveToElement(ivmsonline).click().perform();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Offline status in filter");
	}

//<-------------------------------------Filter Offline status for Team viewer,Novostar,IVMS ---------------------------------------->

	@FindBy(xpath = "(//span[contains(text(),'Offline')])[1]")
	private WebElement teamvieweroffline;
	@FindBy(xpath = "(//span[contains(text(),'Offline')])[2]")
	private WebElement novostaroffline;
	@FindBy(xpath = "(//span[contains(text(),'Offline')])[3]")
	private WebElement ivmsoffline;

	public void BB_filter_offlinestatus() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(teamvieweroffline)).click();
		act.moveToElement(novostaroffline).click().perform();
		act.moveToElement(ivmsoffline).click().perform();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Offline status in filter");
	}

//<-------------------------------------Filter installed for Novostar,IVMS ---------------------------------------->

	@FindBy(xpath = "(//span[@id='installed'])[1]")
	private WebElement IVMS_installed;
	@FindBy(xpath = "(//span[@id='installed'])[2]")
	private WebElement Novastar_installed;

	public void BB_filter_installedstatus() {

		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		act.moveToElement(IVMS_installed).click().perform();
		act.moveToElement(Novastar_installed).click().perform();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User clicked IVMS and Novastar installed status in filter");
	}

//<-------------------------------------Filter Not installed status for Novostar,IVMS ---------------------------------------->

	@FindBy(xpath = "(//span[@id='not_installed'])[1]")
	private WebElement IVMS_Not_installed;
	@FindBy(xpath = "(//span[@id='not_installed'])[2]")
	private WebElement Novastar_Not_installed;

	public void BB_filter_Not_installedstatus() {

		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		act.moveToElement(IVMS_Not_installed).click().perform();
		act.moveToElement(Novastar_Not_installed).click().perform();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User clicked IVMS and Novastar Not installed status in filter");
	}

//<-------------------------------------Filter Online and installed status for BillBoards ---------------------------------------->

	public void BB_filter_online_installed() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(teamvieweronline)).click();
		act.moveToElement(novostaronline).click().perform();
		act.moveToElement(ivmsonline).click().perform();
		act.moveToElement(IVMS_installed).click().perform();
		act.moveToElement(Novastar_installed).click().perform();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User filtered the online with ivms and novastar installed BB");
	}
//<----------------------common if condition for filters--------------------------------------------->

	public void BB_filtered_result_display() {
		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(BBlist));
				AssertJUnit.assertTrue(BBlist.isDisplayed());
				System.out.println(">> User got the filtered BB list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(billboard_no_BB_found));
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(billboard_no_BB_found));
		}
	}
	// <-------------------------------------Filter Offline and installed status for
	// BillBoards ---------------------------------------->

	public void BB_filter_offline_installed() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(teamvieweroffline)).click();
		act.moveToElement(novostaroffline).click().perform();
		act.moveToElement(ivmsoffline).click().perform();
		act.moveToElement(IVMS_installed).click().perform();
		act.moveToElement(Novastar_installed).click().perform();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User filtered the offline with ivms and novastar installed BB");
	}

	// <-------------------------------------Filter Online and Not installed status
	// for BillBoards ---------------------------------------->

	public void BB_filter_online_Not_installed() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(teamvieweronline)).click();
		act.moveToElement(novostaronline).click().perform();
		act.moveToElement(ivmsonline).click().perform();
		act.moveToElement(IVMS_Not_installed).click().perform();
		act.moveToElement(Novastar_Not_installed).click().perform();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User filtered the online with ivms and novastar Not installed BB");
	}

	// <-------------------------------------Filter Online and Not installed status
	// for BillBoards ---------------------------------------->
	public void BB_filter_offline_Not_installed() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(teamvieweroffline)).click();
		act.moveToElement(novostaroffline).click().perform();
		act.moveToElement(ivmsoffline).click().perform();
		act.moveToElement(IVMS_Not_installed).click().perform();
		act.moveToElement(Novastar_Not_installed).click().perform();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User filtered the online with ivms and novastar Not installed BB");

	}

	@FindBy(id = "react-select-5-input")
	private WebElement scr_Resolutiondropdown;

	public void BB_filter_Screen_Resolution() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		act.moveToElement(Billboard_filter_apply_btn).perform();
		Thread.sleep(2000);

		act.moveToElement(scr_Resolutiondropdown).click().sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER).perform();

		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User selected the Screen resolution in filter");
	}

	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='Download'])[1]")
	private WebElement BB_Download_btn;

	public void BB_Download_popup() throws Exception {

		act.moveToElement(BB_Download_btn).click().perform();
	}

	@FindBy(xpath = "(//div[contains(text(),'Download')])[1]")
	private WebElement BB_Download_popup_display;

	public void BB_Download_popup_display() {
		wait.until(ExpectedConditions.visibilityOf(BB_Download_popup_display)).isDisplayed();
		AssertJUnit.assertTrue(BB_Download_popup_display.isDisplayed());
		LOGGER.info(">> The Download Popup got displayed");
	}

	@FindBy(xpath = "(//div[normalize-space()='As Excel'])[1]")
	private WebElement BB_Download_excel;

	public void BB_Download_excel() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(BB_Download_popup_display)).isDisplayed();
		act.moveToElement(BB_Download_excel).click().perform();
	}
	@FindBy(xpath = "//div[normalize-space()='As PDF']")
	private WebElement BB_Download_As_PDF;

	public void BB_Download_PDF() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(BB_Download_popup_display)).isDisplayed();
		act.moveToElement(BB_Download_As_PDF).click().perform();
	}

	@FindBy(xpath = "(//div[normalize-space()='As QR Code'])[1]")
	private WebElement BB_Download_As_QR_Code_file;

	public void BB_Download_QR_Code_file() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(BB_Download_popup_display)).isDisplayed();
		act.moveToElement(BB_Download_As_QR_Code_file).click().perform();
	}

	@FindBy(xpath = "//span[contains(@class,'cursor-pointer')]//*[name()='svg']")
	WebElement BB_Download_popupclose;

	public void BB_Download_popup_close() throws Exception {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(BB_Download_popup_display)).isDisplayed();
		act.moveToElement(BB_Download_popupclose).click().perform();
	}

	@FindBy(xpath = "(//img[@class='pointer'])[4]")
	WebElement BB_Download_popupclosed_and_displyd_billboards;

	public void BB_Download_popupclosd_displayed_Billboards() {
		wait.until(ExpectedConditions.visibilityOf(BB_Download_popupclosed_and_displyd_billboards)).isDisplayed();
		AssertJUnit.assertTrue(BB_Download_popupclosed_and_displyd_billboards.isDisplayed());
		LOGGER.info(">> The Download Popup get closed and listed BillBoards");
	}

	@FindBy(xpath = "//tbody/tr[1]/td[6]/div[2]/div[1]/img[1]")
	private WebElement BB_Edit_Buttonclick;

	public void BB_Edit_icon() throws Exception {

		act.moveToElement(BB_Edit_Buttonclick).click().perform();
	}

	@FindBy(xpath = "(//span[@class='edit_link_routes active'])[1]")
	private WebElement BB_Edit_page_display;

	public void BB_Edit_page() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(BB_Edit_page_display)).isDisplayed();
		AssertJUnit.assertTrue(BB_Edit_page_display.isDisplayed());
		LOGGER.info(">>Billboard edit page displayed");

	}

	@FindBy(xpath = "//tbody/tr[1]/td[6]/div[2]/div[2]/img[1]")
	private WebElement plus_Buttonclick;

	public void plus_icon_click() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(plus_Buttonclick)).click();
	}

	@FindBy(xpath = "(//h5[normalize-space()='BillBoard Number'])[1]")
	private WebElement BB_View_page_display;

	public void BB_View_page() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(BB_View_page_display)).isDisplayed();
		AssertJUnit.assertTrue(BB_View_page_display.isDisplayed());
		LOGGER.info("BillBoard View page displayed");

	}

	@FindBy(xpath = "(//img[contains(@class,'pointer')])[6]")
	private WebElement BB_Delete_button;

	public void BB_Delete_icon() throws Exception {
		act.moveToElement(BB_Delete_button).click().perform();
	}
	@FindBy(xpath = "(//h6[normalize-space()='Yes, delete it.'])[1]")
	private WebElement BB_Delete_confirm_yes_button;

	public void BB_delete_popup_confirmed() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(BB_Delete_confirm_yes_button)).click();

	}
	// <-------------------------------------Redirect to billboard location when
	// click on location text
	// ---------------------------------------->

//	@FindBy(xpath = "(//h6[contains(text(),'Riyadh Saudi Arabia')])[2]")
//	private WebElement BB_location_text_click;
	
	@FindBy(xpath = "(//h6[@class='mb-2 fw-semibold textlocation text-capitalize membertitle'][normalize-space()='Riyadh'])[2]")
	private WebElement BB_location_text_click;
	
	public void BB_location_click() throws Exception {
//		String oldwindow1 = driver.getWindowHandle();
//		System.out.println("oldwindow id:" + oldwindow1);
//		act.moveToElement(BB_location_text_click).click().perform();
//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(1));
		wait.until(ExpectedConditions.visibilityOf(allBillboardsCount)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(BB_location_text_click)).click();
	}

	@FindBy(xpath = "(//div[normalize-space()='Directions'])[1]")
	private WebElement BB_Google_map;

	public void BB_Google_map_display() throws Exception {
		LOGGER.info("BillBoard google map view displayed");
	}

    @FindBy(xpath = "(//input[@id='screen_height'])[1]")
    private WebElement scr_height;
    
    @FindBy(xpath = "(//span[@class='edit_link_routes active'])[1]")
    private WebElement edit_display;

    public void BB_edit_screen_height() {
		String IDnumber = generateUniqueboardNumber(prop.getProperty("IDnumber"));

		wait.until(ExpectedConditions.visibilityOf(edit_display)).isDisplayed();
		act.moveToElement(Newbillboard_screen_height).click();
		Newbillboard_screen_height.sendKeys(Keys.CONTROL, "a" ,Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_screen_height)).sendKeys(IDnumber);		
        LOGGER.info("User enters screenheight");
        

}

 	@FindBy(id = "Update Billboard")
 	private WebElement BB_update_button;

 	public void BB_update_clicked() throws Exception {

 		act.moveToElement(BB_update_button).click().perform();
 	}
	@FindBy(xpath = "//h6[normalize-space()='Yes, update it.']")
	private WebElement BB_update_confirm_yes_button;

	public void BB_update_confirmed() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(BB_update_confirm_yes_button)).click();

	}

		@FindBy(xpath = "(//span[normalize-space()='BOM'])[1]")
		private WebElement BB_update_BOM_click;
		
    	public void BB_editpage_BOM() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(edit_display)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(BB_update_BOM_click)).click();
	}
    	
	@FindBy(xpath = "//h5[normalize-space()='All Stocks']")
	private WebElement BB_BOMTab_ALLstocks_displayed;

	public void BB_editpage_BOMdisplay() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(BB_BOMTab_ALLstocks_displayed)).isDisplayed();
		AssertJUnit.assertTrue(BB_BOMTab_ALLstocks_displayed.isDisplayed());
		LOGGER.info("BillBoard BOM details page displayed");
	}

			@FindBy(xpath = "(//button[@id='Download PDF'])[1]")
			private WebElement BB_BOM_Download;
			
		public void BB_BOMDetails_Download_PDF() throws Exception {

			wait.until(ExpectedConditions.visibilityOf(BB_BOMTab_ALLstocks_displayed)).isDisplayed();
			act.moveToElement(BB_BOM_Download).click().perform();
		}
		@FindBy(xpath = "(//*[name()='svg'][contains(@stroke,'currentColor')])[8]")
		private WebElement BB_QR_click;
		
	    public void BB_editpage_BOMTab_QRcode() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(edit_display)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(BB_QR_click)). click();

	}

	@FindBy(xpath = "(//a[normalize-space()='Download QR'])[1]")
	private WebElement BB_BOM_QR;

	public void BB_editpage_BOMTab_QRcodedisplay() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(BB_BOM_QR)).isDisplayed();
		AssertJUnit.assertTrue(BB_BOM_QR.isDisplayed());
		LOGGER.info("BillBoard QR code displayed");
	}

	@FindBy(xpath = "(//button[normalize-space()='Mark it as non-operational'])[1]")
	private WebElement BB_Mark_it_as_non_opernl_buttn_click;
	
	@FindBy(xpath = "(//li[normalize-space()='Temporary'])[1]")
	private WebElement Clicks_temporary;
	
    public void BB_Mark_it_as_nonoperational() throws Exception {
    	
	wait.until(ExpectedConditions.visibilityOf(edit_display)).isDisplayed();
	act.moveToElement(BB_Mark_it_as_non_opernl_buttn_click).click().perform();
	wait.until(ExpectedConditions.visibilityOf(Clicks_temporary)).click();
}

	public void display_temporary_nonoperntlpopup() {
		wait.until(ExpectedConditions.visibilityOf(displayNonOperational_popup_temporary)).isDisplayed();
		AssertJUnit.assertTrue(displayNonOperational_popup_temporary.isDisplayed());
		LOGGER.info(">> The Tempoarary Non operational billboard will be displayed");
	}

    @FindBy(xpath = "(//h4[normalize-space()='Temporary Non-Operational Details'])[1]")
	private WebElement displayNonOperational_popup_temporary;
    
	@FindBy(id = "damaged_by")
	private WebElement Damageby;
	
	@FindBy(id = "formikDateField_incident_date")
	private WebElement incident_date;
	
	@FindBy(xpath = "(//div[contains(@class,'select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer')])[10]")
	private WebElement Departmnt;
	
	@FindBy(xpath = "(//div[contains(@class,'select__input-container css-19bb58m')])[8]")
	private WebElement assignee;
	
	@FindBy(xpath = "(//div[@class='select__indicators css-1wy0on6'])[12]")
	private WebElement Checklist;
	
	@FindBy(id = "reason")
	private WebElement reason;
	
    public void Enter_Temporary_nonoperntl_fields() throws Exception {
    	
	wait.until(ExpectedConditions.visibilityOf(displayNonOperational_popup_temporary)).isDisplayed();
	act.moveToElement(Damageby).click().sendKeys(""+Keys.ARROW_DOWN+Keys.ENTER).perform();
	
	act.moveToElement(incident_date).click().perform();
	wait.until(ExpectedConditions.visibilityOf(incident_date)).isDisplayed();
	
	act.moveToElement(Departmnt).click().perform();Thread.sleep(2000);
	act.moveToElement(Departmnt).sendKeys(""+"Electrical").perform();Thread.sleep(2000);
	act.moveToElement(Departmnt).sendKeys(""+Keys.ENTER).perform();
	
	wait.until(ExpectedConditions.visibilityOf(Departmnt)).isDisplayed();	
	act.moveToElement(assignee).click().perform();Thread.sleep(2000);
	act.moveToElement(assignee).sendKeys(""+"Tom").perform();Thread.sleep(2000);
	act.moveToElement(assignee).sendKeys(""+Keys.ENTER).perform();Thread.sleep(2000);
	
	wait.until(ExpectedConditions.visibilityOf(assignee)).isDisplayed();
	act.moveToElement(Checklist).click().sendKeys(""+Keys.ENTER).perform();

	wait.until(ExpectedConditions.visibilityOf(Checklist)).isDisplayed();
	wait.until(ExpectedConditions.visibilityOf(reason)).sendKeys(prop.getProperty("reasonofnonoperational"));
	
}
    
   @FindBy(xpath = "(//li[normalize-space()='Temporary'])[1]")
   WebElement BB_reason_text;
   
   @FindBy(id = "Yes, mark it as non-operational")
   WebElement click_yesmarkas_nonoperntl;

   public void Clicks_Yes_mark_itNonoperationalbutton() {

	wait.until(ExpectedConditions.visibilityOf(reason)).isDisplayed();
	wait.until(ExpectedConditions.visibilityOf(click_yesmarkas_nonoperntl)).click();

}
	
	@FindBy(xpath = "(//li[normalize-space()='Permanent'])[1]")
	private WebElement Clicks_Permanent;
	
	@FindBy(xpath = "(//h4[normalize-space()='Permanent Non-Operational Details'])[1]")
	private WebElement displayNonOperational_popup_permanent;
	
   public void BB_Mark_it_as_nonoperational_Permanent() throws Exception {
   	
	wait.until(ExpectedConditions.visibilityOf(edit_display)).isDisplayed();
	act.moveToElement(BB_Mark_it_as_non_opernl_buttn_click).click().perform();
	wait.until(ExpectedConditions.visibilityOf(Clicks_Permanent)).click();
}

	public void display_Permanent_nonoperntlpopup() {
		wait.until(ExpectedConditions.visibilityOf(displayNonOperational_popup_permanent)).isDisplayed();
		AssertJUnit.assertTrue(displayNonOperational_popup_permanent.isDisplayed());
		LOGGER.info(">> The Permanent Non operational billboard will be displayed");
	}
	
   public void Enter_Permanent_nonoperntl_fields() throws Exception {
   	
	wait.until(ExpectedConditions.visibilityOf(displayNonOperational_popup_permanent)).isDisplayed();
	act.moveToElement(Departmnt).click().perform();Thread.sleep(2000);
	act.moveToElement(Departmnt).sendKeys(""+"Electrical").perform();Thread.sleep(2000);
	act.moveToElement(Departmnt).sendKeys(""+Keys.ENTER).perform();
	
	wait.until(ExpectedConditions.visibilityOf(Departmnt)).isDisplayed();	
	act.moveToElement(assignee).click().perform();Thread.sleep(2000);
	act.moveToElement(assignee).sendKeys(""+"Tom").perform();Thread.sleep(2000);
	act.moveToElement(assignee).sendKeys(""+Keys.ENTER).perform();Thread.sleep(2000);
	
	wait.until(ExpectedConditions.visibilityOf(assignee)).isDisplayed();
	act.moveToElement(Checklist).click().sendKeys(""+Keys.ENTER).perform();

	wait.until(ExpectedConditions.visibilityOf(Checklist)).isDisplayed();
	wait.until(ExpectedConditions.visibilityOf(reason)).sendKeys(prop.getProperty("reasonofnonoperational"));
	
}
   
   
   
	
	@FindBy(xpath = "(//div[contains(@class,'custom_select_input__input-container css-19bb58m')])[2]")
	private WebElement vehicle_type;
	
	@FindBy(xpath = "(//div[contains(@class,'custom_select_input__input-container css-19bb58m')])[3]")
	private WebElement Severity;
	
	@FindBy(xpath = "(//input[@id='plate_number'])[1]")
	private WebElement plate_no;
	
	@FindBy(xpath = "(//input[@id='FormikTimeField_accident_time'])[1]")
	private WebElement Accident_time;
	
	@FindBy(xpath = "(//input[@id='location'])[1]")
	private WebElement Accident_location;
	
	
   public void Enter_Accidental_nonoperntl_fields() throws Exception {
   	
	wait.until(ExpectedConditions.visibilityOf(displayNonOperational_popup_temporary)).isDisplayed();
	act.moveToElement(Damageby).click().sendKeys(""+Keys.ENTER).perform();
	
	act.moveToElement(incident_date).click().perform();
	wait.until(ExpectedConditions.visibilityOf(incident_date)).isDisplayed();
	
	wait.until(ExpectedConditions.visibilityOf(assignee)).isDisplayed();
	act.moveToElement(vehicle_type).click().sendKeys(""+Keys.ENTER).perform();
	
	wait.until(ExpectedConditions.visibilityOf(vehicle_type)).isDisplayed();
	wait.until(ExpectedConditions.visibilityOf(plate_no)).sendKeys(""+"GH 21");
	
	wait.until(ExpectedConditions.visibilityOf(plate_no)).isDisplayed();
	act.moveToElement(Severity).click().sendKeys(""+Keys.ENTER).perform();
	
	wait.until(ExpectedConditions.visibilityOf(Severity)).isDisplayed();
	wait.until(ExpectedConditions.visibilityOf(Accident_time)).sendKeys(""+"12:00 AM");
	
	wait.until(ExpectedConditions.visibilityOf(Severity)).isDisplayed();
	wait.until(ExpectedConditions.visibilityOf(Accident_location)).sendKeys(""+"Riyadh");
	
	
	act.moveToElement(Departmnt).click().perform();Thread.sleep(2000);
	act.moveToElement(Departmnt).sendKeys(""+"Electrical").perform();Thread.sleep(2000);
	act.moveToElement(Departmnt).sendKeys(""+Keys.ENTER).perform();
	
	wait.until(ExpectedConditions.visibilityOf(Departmnt)).isDisplayed();	
	act.moveToElement(assignee).click().perform();Thread.sleep(2000);
	act.moveToElement(assignee).sendKeys(""+"Tom").perform();Thread.sleep(2000);
	act.moveToElement(assignee).sendKeys(""+Keys.ENTER).perform();Thread.sleep(2000);
	
	wait.until(ExpectedConditions.visibilityOf(assignee)).isDisplayed();
	act.moveToElement(Checklist).click().sendKeys(""+Keys.ENTER).perform();

	wait.until(ExpectedConditions.visibilityOf(Checklist)).isDisplayed();
	wait.until(ExpectedConditions.visibilityOf(reason)).sendKeys(prop.getProperty("reasonofnonoperational"));
	
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
@FindBy(xpath = "//div[normalize-space()='‹']")
private WebElement click_previous_page;
public void Previous_page() throws Exception {
	act.scrollToElement(click_previous_page).build().perform();
	wait.until(ExpectedConditions.visibilityOf(click_previous_page)).click();
}
@FindBy(xpath = "//div[contains(@class,'round-effect') and normalize-space()='› ›']")
private WebElement click_last_page;
public void last_page() throws Exception {
	act.scrollToElement(click_last_page).build().perform();
	wait.until(ExpectedConditions.visibilityOf(click_last_page)).click();
}
@FindBy(xpath = "//div[normalize-space()='‹ ‹']")
private WebElement click_first_page;
public void First_page() throws Exception {
	act.scrollToElement(click_first_page).build().perform();
	wait.until(ExpectedConditions.visibilityOf(click_first_page)).click();
}
@FindBy(xpath = "(//span[@id='REQUEST'])[1]")
private WebElement pendingstatus;

public void Pending_Billboards() {
	wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
	wait.until(ExpectedConditions.visibilityOf(pendingstatus)).click();
	act.moveToElement(Billboard_filter_apply_btn).click().perform();
	System.out.println(">> User clicked Non Oper. status in filter");
}
@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/div[2]/div[1]/img[1]")
private WebElement BB_Edit_pending_Buttonclick;

public void BB_Edit_pending_icon() throws Exception {

	act.moveToElement(BB_Edit_Buttonclick).click().perform();
}
@FindBy(xpath = "//div[@class='d-flex justify-content-end py-5']")
private WebElement approve_container;
@FindBy(id = "Mark it as Approved")
private WebElement BB_approve_button;

	public void Approve_for_non_operational_Billboards() throws Exception {
		Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(approve_container)).isDisplayed();  
		act.moveToElement(BB_approve_button).click().perform();
	}
	@FindBy(xpath = "//h4[@class=' fw-semibold text-center text-black']")
	private WebElement BB_approve_confirm_popup_display;
@FindBy(xpath = "//h6[normalize-space()='Yes, mark it.']")
private WebElement approve_confirm_yes_button;


public void approve_non_operational_confirmed() throws Exception {
	Thread.sleep(2000);

	wait.until(ExpectedConditions.visibilityOf(BB_approve_confirm_popup_display)).isDisplayed();
	wait.until(ExpectedConditions.visibilityOf(approve_confirm_yes_button)).click();

}

@FindBy(id = "Reject")
private WebElement reject_button;

	public void Reject_for_non_operational_Billboards() throws Exception {
		Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(approve_container)).isDisplayed();  
		act.moveToElement(reject_button).click().perform();
	}
	@FindBy(xpath = "//h4[@class=' fw-semibold text-center text-black']")
	private WebElement reject_confirm_popup_display;
@FindBy(xpath = "//h6[normalize-space()='Yes, mark it.']")
private WebElement reject_confirm_yes_button;


public void reject_non_operational_confirmed() throws Exception {
	Thread.sleep(2000);

	wait.until(ExpectedConditions.visibilityOf(reject_confirm_popup_display)).isDisplayed();
	wait.until(ExpectedConditions.visibilityOf(reject_confirm_yes_button)).click();

}
@FindBy(xpath = "(//*[name()='svg'][contains(@class,'css-tj5bde-Svg')])[2]")
private WebElement Department_select;

@FindBy(xpath = "(//div[contains(@class,'select__input-container css-19bb58m')])[2]")
private WebElement Priority_select;

@FindBy(xpath = "(//*[name()='svg'][contains(@class,'css-tj5bde-Svg')])[4]")
private WebElement Ticket_title_select;

@FindBy(xpath = "(//*[name()='svg'][contains(@class,'css-tj5bde-Svg')])[5]")
private WebElement Assignee_select;

@FindBy(id = "formikDateField_start_date")
private WebElement Start_date;

@FindBy(id = "formikDateField_end_date")
private WebElement End_date;

@FindBy(xpath = "(//*[name()='svg'][contains(@class,'css-tj5bde-Svg')])[7]")
private WebElement Checklist_Newticket;

@FindBy(id = "description")
private WebElement Description_enter;

public void Mandatory_fields_newticket() throws Exception{
	 Thread.sleep(2000);
     wait.until(ExpectedConditions.visibilityOf(BB_View_page_display)).isDisplayed();
	Thread.sleep(1000);
 	act.moveToElement(Department_select).click().perform();Thread.sleep(2000);
 	act.moveToElement(Department_select).sendKeys(""+"Electrical").perform();Thread.sleep(2000);
 	act.moveToElement(Department_select).sendKeys(""+Keys.ENTER).perform();
    wait.until(ExpectedConditions.visibilityOf(Department_select)).isDisplayed();
	act.moveToElement(Priority_select).click().sendKeys("" + Keys.ENTER).perform();
    wait.until(ExpectedConditions.visibilityOf(Priority_select)).isDisplayed();
	act.moveToElement(Ticket_title_select).click().sendKeys("" + Keys.ENTER).perform();Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(Ticket_title_select)).isDisplayed();	
	act.moveToElement(Assignee_select).click().perform();Thread.sleep(2000);
	act.moveToElement(Assignee_select).sendKeys(""+"Tom").perform();Thread.sleep(2000);
	act.moveToElement(Assignee_select).sendKeys(""+Keys.ENTER).perform();Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(Assignee_select)).isDisplayed();	
	act.moveToElement(Start_date).click().sendKeys("" + Keys.ENTER).perform();
	wait.until(ExpectedConditions.visibilityOf(Start_date));
	act.moveToElement(End_date).click().perform();
	wait.until(ExpectedConditions.visibilityOf(display_datepicker_end_date)).isDisplayed();
	act.moveToElement(select_Contract_enddate).click().perform();Thread.sleep(2000);
	act.moveToElement(Checklist_Newticket).click().sendKeys(""+Keys.ENTER).perform();Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(Description_enter)).sendKeys(prop.getProperty("Description"));
}

@FindBy(id = "Create Ticket")
private WebElement Ticket_create_BB_btn;

public void NewTicket_create_btn() {
	act.moveToElement(Ticket_create_BB_btn).click().perform();
}
@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
WebElement Ticket_created_Success_display;

public String ticket_create_Success_display() throws Exception {
	WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(Ticket_created_Success_display));
	return successMessageElement.getText().trim();
}

@FindBy(xpath = "//span[normalize-space()='View Tickets']")
WebElement click_view_ticket;

@FindBy(xpath = "(//h5[normalize-space()='BillBoard Number'])[1]")
WebElement display_BillBoard_Number;

public void View_ticketBB() throws Exception {
	Thread.sleep(3000);
    wait.until(ExpectedConditions.visibilityOf(display_BillBoard_Number)).isDisplayed();
	act.moveToElement(click_view_ticket).click().perform();
}
@FindBy(xpath = "//label[normalize-space()='Created By']")
WebElement View_Tickets_display;

@FindBy(xpath = "(//div[contains(text(),'No Tickets Found')])[1]")
WebElement No_Tickets_found;

public void View_ticketBB_display() {
	try {
		if (condition) {
			wait.until(ExpectedConditions.visibilityOf(View_Tickets_display));
			AssertJUnit.assertTrue(View_Tickets_display.isDisplayed());
			System.out.println(">> User got the View Ticket page");
		} else {
			wait.until(ExpectedConditions.visibilityOf(No_Tickets_found));
		}
	} catch (Exception e) {
		wait.until(ExpectedConditions.visibilityOf(No_Tickets_found));
	}
}
@FindBy(xpath = "(//span[normalize-space()='Activity Feed'])[1]")
private WebElement activity_feed;

public void Activity_FeedBB() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(display_BillBoard_Number)).isDisplayed();
	act.moveToElement(activity_feed).click().perform();
}
@FindBy(xpath = "//span[normalize-space()='Activity Feed']")
private WebElement activityfeed_display;

public void Activity_FeedBB_display() throws Exception {
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(activityfeed_display)).isDisplayed();
	AssertJUnit.assertTrue(activityfeed_display.isDisplayed());
}
@FindBy(id = "fault")
private WebElement faulty_status;
public void Faulty_status() {
	wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();;
	act.moveToElement(faulty_status).click().perform();
	act.moveToElement(Billboard_filter_apply_btn).click().perform();
	System.out.println(">> User clicked Faulty status in filter");
}
@FindBy(id = "alaram")
private WebElement alarm_status;
public void Alarm_status() {
	wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();;
	act.moveToElement(alarm_status).click().perform();
	act.moveToElement(Billboard_filter_apply_btn).click().perform();
	System.out.println(">> User clicked Alarm status in filter");
  }

@FindBy(xpath = "(//span[normalize-space()='Incidents'])[1]")
WebElement clicks_incidents;

@FindBy(xpath = "(//label[contains(@for,'board_no')])[1]")
WebElement Editbillboard_display;

public void Clicks_Incidents() throws Exception {
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(Editbillboard_display)).isDisplayed();
	act.moveToElement(clicks_incidents).click().perform();
}

@FindBy(xpath = "display_incidents_with_download")
private WebElement display_incidents_with_download;

@FindBy(xpath = "(//div[contains(text(),'No Incidents Found')])[1]")
WebElement No_incidents_found;

public void Incidents_display() throws Exception {
	try {
		if (condition) {
			wait.until(ExpectedConditions.visibilityOf(display_incidents_with_download));
			AssertJUnit.assertTrue(display_incidents_with_download.isDisplayed());
			System.out.println(">> User got the View Incidents page");
		} else {
			wait.until(ExpectedConditions.visibilityOf(No_incidents_found));
		}
	} catch (Exception e) {
		wait.until(ExpectedConditions.visibilityOf(No_incidents_found));
	}
}

}
