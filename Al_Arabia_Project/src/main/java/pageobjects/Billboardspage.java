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

public class Billboardspage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Actions act;
	private Logger LOGGER = LogManager.getLogger(Billboardspage.class);
	private Signinpage signinpage;

////
	public Billboardspage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		this.signinpage = new Signinpage(driver);
		LOGGER = LogManager.getLogger(Billboardspage.class.getName());
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

//<-------------------BillBoards------------------------------------------>
	@FindBy(xpath = "//span[normalize-space()='BillBoards']")
	private WebElement billboardClick;

	@FindBy(xpath = "//table[contains(@class,'table')]")
	private WebElement billboardMenu; //

	public void billboardClick() {
		wait.until(ExpectedConditions.visibilityOf(billboardClick)).click();
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

	@FindBy(id = "Create BillBoard")
	private WebElement Newbillboard_create_BB_btn;

	public void Newbillboard_create_BB_btn() {
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

	@FindBy(xpath = "//table[@class='table']")
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
 //<------------------------------------------Activestatus------------------------------------------->
	@FindBy(xpath = "(//span[@id='ACTIVE'])[1]")
	private WebElement activestatus;

	public void BB_filter_active() {
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(activestatus)).click();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User clicked active status in filter");
	}
	//<--------------------------------------Filter by non oper.status---------------------------->

	@FindBy(xpath = "(//span[@id='NON_OPERATIONAL'])[1]")
	private WebElement Nonoperstatus;

	public void Nonoper() {
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(Nonoperstatus)).click();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Non Oper. status in filter");
	}

	@FindBy(xpath = "(//div[contains(@class,'filterbox foractivefilter')])[1]")
	private WebElement Billboard_filter;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement Billboard_filter_apply_btn;
	
	@FindBy(xpath = "//div[contains(text(),'No BillBoard Found')]")
	private WebElement billboard_no_BB_found;
	
	public void BB_filter_nonop_list_display() {

		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(BBlist));
				AssertJUnit.assertTrue(BBlist.isDisplayed());
				System.out.println(">> User got filtered non operational bb list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(billboard_no_BB_found));
				System.out.println(">> User got no billboard found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(billboard_no_BB_found));
			System.out.println(">> User got no billboard found message");
		}
	}
	
	//<-------------------------------------Filter by Request status---------------------------------->

	@FindBy(xpath = "(//span[@id='REQUEST'])[1]")
	private WebElement Requeststatus;

	public void BB_filter_Request_list() {
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(Requeststatus)).click();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Request status in filter");
	}
	
	
	public void BB_filter_Request_list_display() {
		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(BBlist));
				AssertJUnit.assertTrue(BBlist.isDisplayed());
				System.out.println(">> User got filtered request bb list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(billboard_no_BB_found));
				System.out.println(">> User got no billboard found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(billboard_no_BB_found));
			System.out.println(">> User got no billboard found message");
		}
	}
	//<-------------------------------------Filter by Location EnterDropdown---------------------------------------->

	@FindBy(id = "react-select-3-input")
	private WebElement selectlocationdropdown;

	public void select_bb_location() {
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		String bb_location = prop.getProperty("bb_location");
		wait.until(ExpectedConditions.visibilityOf(selectlocationdropdown)).click();
		wait.until(ExpectedConditions.visibilityOf(selectlocationdropdown)).sendKeys(bb_location + Keys.ENTER);
		LOGGER.info(">> User selected the location:" + selectlocationdropdown.getText());
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User selected the bb location in filter"+bb_location);
	}
	
	public void BB_filter_location_list_display() {
		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(BBlist));
				AssertJUnit.assertTrue(BBlist.isDisplayed());
				System.out.println(">> User got filtered location bb list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(billboard_no_BB_found));
				System.out.println(">> User got no billboard found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(billboard_no_BB_found));
			System.out.println(">> User got no billboard found message");
		}
	}
	//<-------------------------------------Filter by Bill Board Ticket count---------------------------------------->

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
	
	public void BB_filter_ticketcount_list_displayed() {
		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(BBlist));
				AssertJUnit.assertTrue(BBlist.isDisplayed());
				System.out.println(">> User got filtered location bb list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(billboard_no_BB_found));
				System.out.println(">> User got no billboard found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(billboard_no_BB_found));
			System.out.println(">> User got no billboard found message");
		}
	}
	//<-------------------------------------Filter by Bill Board Type drop down ---------------------------------------->

	@FindBy(id = "react-select-4-input")
	private WebElement BB_Typedropdown;

	public void select_bb_Type() {
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		String bb_Type = prop.getProperty("bb_Type");
		wait.until(ExpectedConditions.visibilityOf(BB_Typedropdown)).click();
		wait.until(ExpectedConditions.visibilityOf(BB_Typedropdown)).sendKeys(bb_Type + Keys.ENTER);
		LOGGER.info(">> User selected the Billboard Type:" + BB_Typedropdown.getText());
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User selected the bb Type in filter"+bb_Type);
	}
	
	public void BB_filter_Type_list_display() {
		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(BBlist));
				AssertJUnit.assertTrue(BBlist.isDisplayed());
				System.out.println(">> User got filtered BB Type list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(billboard_no_BB_found));
				System.out.println(">> User got no billboard found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(billboard_no_BB_found));
			System.out.println(">> User got no billboard found message");
		}
	}
	
	//<-------------------------------------Filter Online status for Team viewer,Novostar,IVMS ---------------------------------------->

	@FindBy(xpath = "(//span[@id='online'])[1]")
	private WebElement teamvieweronline;
	@FindBy(xpath = "(//span[@id='online'])[2]")
	private WebElement novostaronline;
	@FindBy(xpath = "(//span[@id='online'])[3]")
	private WebElement ivmsonline;
	public void BB_filter_onlinestatus() {
		wait.until(ExpectedConditions.visibilityOf(Billboard_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(teamvieweronline)).click();
		wait.until(ExpectedConditions.visibilityOf(novostaronline)).click();
		wait.until(ExpectedConditions.visibilityOf(ivmsonline)).click();
		act.moveToElement(Billboard_filter_apply_btn).click().perform();
		System.out.println(">> User clicked Request status in filter");
	}
	
	
	public void BB_filter_online_status_display() {
		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(BBlist));
				AssertJUnit.assertTrue(BBlist.isDisplayed());
				System.out.println(">> User got filtered Online status for Team viewer Novastar IVMS");
			} else {
				wait.until(ExpectedConditions.visibilityOf(billboard_no_BB_found));
				System.out.println(">> User got no billboard found message");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(billboard_no_BB_found));
			System.out.println(">> User got no billboard found message");
		}
	}
	
	
	
	
}





