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

	@FindBy(id = "react-select-12-input")
	private WebElement Newbillboard_BB_type;

	@FindBy(xpath = "//div[@class='select__menu css-1nmdiq5_menu'][1]")
	private WebElement Newbillboard_BB_type1;

	@FindBy(id = "react-select-13-input")
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

	@FindBy(xpath = "(//div)[95]")
	private WebElement Newbillboard_screen_resolution;

	@FindBy(xpath = "(//div[contains(@class,'select__value-container select__value-container--has-value css-hlgwow')])[4]")
	private WebElement Newbillboard_screen_units;

	@FindBy(xpath = "(//div)[114]")
	private WebElement Newbillboard_screen_pixel;

	@FindBy(id = "screen_model")
	private WebElement Newbillboard_screen_model;

	public void NewBillboard_mandatory_fields_enter() {
		String uniqueboardno = generateUniqueboardNumber(prop.getProperty("BB_NO"));
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_boardno)).sendKeys(uniqueboardno);
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_BB_location))
				.sendKeys("Riyadh Saudi Arabia" + Keys.ARROW_DOWN + Keys.ENTER);
		act.moveToElement(Newbillboard_BB_type).click().sendKeys("" + Keys.ENTER).perform();
		act.moveToElement(Newbillboard_BOM_type).click().sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER).perform();

		wait.until(ExpectedConditions.visibilityOf(Newbillboard_teamviewer_id)).sendKeys("123456789");
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_teamviewer_password)).sendKeys("Password@123");
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_screen_width)).sendKeys("80");
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_screen_height)).sendKeys("40");

		act.moveToElement(Newbillboard_screen_resolution).click().sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER).perform();
		act.moveToElement(Newbillboard_screen_units).click().sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER).perform();
		act.moveToElement(Newbillboard_screen_pixel).click().sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER).perform();
	}
	@FindBy(xpath = "//div[@class='d-flex justify-content-between py-5']")
	private WebElement create_BB_container;
	
	@FindBy(id = "Create BillBoard")
	private WebElement Newbillboard_create_BB_btn;

	public void Newbillboard_create_BB_btn() throws Exception {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(create_BB_container));
		act.moveToElement(Newbillboard_create_BB_btn).click().perform();
	}

	@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
	private WebElement billboard_created_Success_display;

	public String billboard_created_Success_display() throws Exception {
		WebElement successMessageElement = wait
				.until(ExpectedConditions.visibilityOf(billboard_created_Success_display));
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

	@FindBy(id = "react-select-4-input")
	private WebElement BB_Typedropdown;

	public void select_bb_Type() {
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		String bb_Type = prop.getProperty("bb_Type");
		wait.until(ExpectedConditions.visibilityOf(BB_Typedropdown)).click();
		wait.until(ExpectedConditions.visibilityOf(BB_Typedropdown)).sendKeys(bb_Type + Keys.ENTER);
		LOGGER.info(">> User selected the Billboard Type:" + BB_Typedropdown.getText());
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

	@FindBy(xpath = "(//div[@class='modal-header'])[1]")
	private WebElement BB_Download_popup_display;

	public void BB_Download_popup_display() {
		wait.until(ExpectedConditions.visibilityOf(BB_Download_popup_display)).isDisplayed();
		AssertJUnit.assertTrue(BB_Download_popup_display.isDisplayed());
		LOGGER.info(">> The Download Popup got displayed");
	}

	@FindBy(xpath = "(//div[normalize-space()='As Excel'])[1]")
	private WebElement BB_Download_excel;

	public void BB_Download_excel() throws Exception {

		act.moveToElement(BB_Download_excel).click().perform();
	}
	@FindBy(xpath = "(//div[normalize-space()='As PDF'])[1]")
	private WebElement BB_Download_As_PDF;

	public void BB_Download_PDF() throws Exception {

		act.moveToElement(BB_Download_As_PDF).click().perform();
	}

	@FindBy(xpath = "(//div[normalize-space()='As QR Code'])[1]")
	private WebElement BB_Download_As_QR_Code_file;

	public void BB_Download_QR_Code_file() throws Exception {

		act.moveToElement(BB_Download_As_QR_Code_file).click().perform();
	}

	@FindBy(xpath = "(//div[@role='dialog'])[1]")
	private WebElement BB_Download_popupclose;

	public void BB_Download_popup_close() throws Exception {

		act.moveToElement(BB_Download_popupclose).click().perform();
	}

	@FindBy(xpath = "(//img[@class='pointer'])[4]")
	private WebElement BB_Download_popupclosed_and_displyd_billboards;

	public void BB_Download_popupclosd_displayed_Billboards() {
		wait.until(ExpectedConditions.visibilityOf(BB_Download_popupclosed_and_displyd_billboards)).isDisplayed();
		AssertJUnit.assertTrue(BB_Download_popupclosed_and_displyd_billboards.isDisplayed());
		LOGGER.info(">> The Download Popup get closed and listed BillBoards");
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[3]/div/table/tbody/tr[1]/td[6]/div[2]/div[1]/img")
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

	//	act.moveToElement(plus_Buttonclick).click().perform();
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

	@FindBy(xpath = "(//h6[contains(text(),'Riyadh Saudi Arabia')])[2]")
	private WebElement BB_location_text_click;

	public void BB_location_click() throws Exception {
		String oldwindow1 = driver.getWindowHandle();
		System.out.println("oldwindow id:" + oldwindow1);
		act.moveToElement(BB_location_text_click).click().perform();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	@FindBy(xpath = "//canvas[@class='aFsglc widget-scene-canvas']")
	private WebElement BB_Google_map;

	public void BB_Google_map_display() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(BB_Google_map)).isDisplayed();
		AssertJUnit.assertTrue(BB_Google_map.isDisplayed());
		LOGGER.info("BillBoard google map view displayed");
	}

    @FindBy(xpath = "(//input[@id='screen_height'])[1]")
    private WebElement screenheight;

    public void BB_edit_screen_height() {
    	
		String Screen_height = prop.getProperty("Screen_height");
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_boardno)).isDisplayed();
		act.moveToElement(screenheight).click().sendKeys(""+Keys.DELETE+Screen_height).perform();
        LOGGER.info("User enters screenheight");
}

 	@FindBy(xpath = "//h6[normalize-space()='Update BillBoard']")
 	private WebElement BB_update_button;

 	
 	public void BB_update_clicked() throws Exception {

 		act.moveToElement(BB_update_button).click().perform();
 	}
	@FindBy(xpath = "//h6[normalize-space()='Yes, update it.']")
	private WebElement BB_update_confirm_yes_button;

	public void BB_update_confirmed() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(BB_update_confirm_yes_button)).click();

	}

		@FindBy(xpath = "(//span[@class='edit_link_routes false'])[1]")
		private WebElement BB_update_BOM_click;
	public void BB_editpage_BOM() throws Exception {
		
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_boardno)).isDisplayed();
		act.moveToElement(BB_update_BOM_click).click().perform();
	}
	@FindBy(xpath = "//h5[normalize-space()='All Stocks']")
	private WebElement BB_BOMTab_ALLstocks_displayed;

	public void BB_editpage_BOMdisplay() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(BB_BOMTab_ALLstocks_displayed)).isDisplayed();
		AssertJUnit.assertTrue(BB_BOMTab_ALLstocks_displayed.isDisplayed());
		LOGGER.info("BillBoard BOM details page displayed");
	}

			@FindBy(xpath = "(//a[normalize-space()='Download PDF'])[1]")
			private WebElement BB_BOM_Download;
		public void BB_BOMDetails_Download_PDF() throws Exception {
			
			wait.until(ExpectedConditions.visibilityOf(BB_BOMTab_ALLstocks_displayed)).isDisplayed();
			act.moveToElement(BB_BOM_Download).click().perform();
		}
		
		@FindBy(xpath = "//span[@class='mx-3 pointer']//*[name()='svg']")
		private WebElement BB_QR_click;
	public void BB_editpage_BOMTab_QRcode() throws Exception {
		
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_boardno)).isDisplayed();
		act.moveToElement(BB_QR_click).click().perform();
	}

	@FindBy(xpath = "//a[normalize-space()='Download QR']")
	private WebElement BB_BOM_QR;

	public void BB_editpage_BOMTab_QRcodedisplay() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(BB_BOM_QR)).isDisplayed();
		AssertJUnit.assertTrue(BB_BOM_QR.isDisplayed());
		LOGGER.info("BillBoard QR code displayed");
	}

	@FindBy(xpath = "//span[normalize-space()='Mark it as non-operational']")
	private WebElement BB_Mark_it_as_non_opernl_buttn_click;
public void BB_Mark_it_as_nonoperational() throws Exception {
	
	wait.until(ExpectedConditions.visibilityOf(Newbillboard_boardno)).isDisplayed();
	act.moveToElement(BB_Mark_it_as_non_opernl_buttn_click).click().perform();
}

@FindBy(xpath = "//h6[normalize-space()='Yes, mark it.']")
private WebElement BB_Mark_it_as_non_opernl_confirm_click;
public void BB_Mark_it_as_nonoperational_confirmed() throws Exception {

act.moveToElement(BB_Mark_it_as_non_opernl_confirm_click).click().perform();
}

@FindBy(xpath = "(//input[@type='text'])[16]")
private WebElement Reason_enter_for_Mark_Non_operntl;
@FindBy(xpath = "//h4[normalize-space()='Reason']")
private WebElement BB_reason_text;
public void BB_non_operatnl_reason_added() {
	
	String reason = prop.getProperty("reason");
	wait.until(ExpectedConditions.visibilityOf(BB_reason_text));

	act.moveToElement(Reason_enter_for_Mark_Non_operntl).sendKeys(""+reason).perform();
    LOGGER.info("User enters reason");

}

@FindBy(xpath = "//h6[normalize-space()='Reason']")
private WebElement BB_reason_buttn_click;

public void BB_clicked_reason_button() throws Exception {

wait.until(ExpectedConditions.visibilityOf(Newbillboard_boardno)).isDisplayed();
act.moveToElement(BB_reason_buttn_click).click().perform();
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
@FindBy(id = "react-select-13-input")
private WebElement Department_select;

@FindBy(id = "react-select-14-input")
private WebElement Priority_select;

@FindBy(id = "react-select-15-input")
private WebElement Ticket_title_select;

@FindBy(id = "react-select-16-input")
private WebElement Assignee_select;

@FindBy(id = "formikDateField_start_date")
private WebElement Start_date;

@FindBy(id = "formikDateField_end_date")
private WebElement End_date;

@FindBy(xpath = "//textarea[@id='description']")
private WebElement Description_enter;

public void Mandatory_fields_newticket() throws Exception{
//	wait.until(ExpectedConditions.visibilityOf(BB_no_select));

	//act.moveToElement(BB_no_select).click().sendKeys("" + Keys.ENTER).perform();
	
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
	Thread.sleep(5000);

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
@FindBy(xpath = "//span[normalize-space()='View Tickets']")
private WebElement click_view_ticket;

public void View_ticketBB() throws Exception {
	act.moveToElement(click_view_ticket).click().perform();
	//wait.until(ExpectedConditions.visibilityOf(click_view_ticket)).click();
}
@FindBy(xpath = "//label[normalize-space()='Created By']")
private WebElement View_Tickets_display;

@FindBy(xpath = "//div[contains(text(),'No Tickets Found')]")
private WebElement No_Tickets_found;

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
@FindBy(xpath = "//span[normalize-space()='Activity Feed']")
private WebElement activity_feed;

public void Activity_FeedBB() throws Exception {
	//wait.until(ExpectedConditions.visibilityOf(BB_View_page_display)).isDisplayed();
	act.moveToElement(activity_feed).click().perform();
}
@FindBy(xpath = "//span[normalize-space()='Activity Feed']")
private WebElement activityfeed_display;

public void Activity_FeedBB_display() throws Exception {
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
}