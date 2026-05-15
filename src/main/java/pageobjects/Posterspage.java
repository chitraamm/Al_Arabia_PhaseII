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
import org.testng.Assert;
import org.testng.AssertJUnit;

import io.cucumber.core.backend.Options;
import resources.Base;

public class Posterspage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop; 
	private Actions act;
	private Logger LOGGER = LogManager.getLogger(Ticketspage.class);
	private Signinpage signinpage;
	public Posterspage(WebDriver driver) throws Exception {
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
	
	@FindBy(xpath = "(//a[normalize-space()='Master'])[1]")
	WebElement mastersclick;
	
	@FindBy(xpath = "(//span[contains(text(),'C')])[2]")
	WebElement profiledisplay;
	
	public void Masters_click() {
		wait.until(ExpectedConditions.elementToBeClickable(profiledisplay)).isDisplayed();
		act.moveToElement(mastersclick).click().perform();
		LOGGER.info(">> Admin/User got navigated to Masters page");
	}

	@FindBy(xpath = "(//a[normalize-space()='Posters'])[1]")
	WebElement clickPosters;
	
	@FindBy(xpath = "(//a[normalize-space()='Department'])[1]")
	WebElement mastersdisplay;

	public void Posters_click() throws Exception {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(mastersdisplay)).isDisplayed();
		act.scrollToElement(clickPosters).perform();
		wait.until(ExpectedConditions.visibilityOf(clickPosters)).click();
		LOGGER.info(">> Admin/User got navigated to Posters page");
	}
	
	@FindBy(xpath = "(//h5[contains(@class,'mb-0')])[1]")
	private WebElement postersCount;

	public void allpostersCount() {
		wait.until(ExpectedConditions.visibilityOf(postersCount)).isDisplayed();
		AssertJUnit.assertTrue(postersCount.isDisplayed());
		LOGGER.info(">> The Tickets page got displayed");
	}
	
	@FindBy(xpath = "(//div[contains(@class,'d-flex sortbox foractivesort')])[1]")
	WebElement Posters_menu;

	public void Display_Posters() {
		wait.until(ExpectedConditions.visibilityOf(Posters_menu)).isDisplayed();
		AssertJUnit.assertTrue(Posters_menu.isDisplayed());
		LOGGER.info(">> The posters page got displayed");
	}
	
	@FindBy(id = "doc_searchQueryInput")
	private WebElement posterSearch;

	public void Poster_Search() {
		wait.until(ExpectedConditions.visibilityOf(Posters_menu)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(posterSearch)).click();
		String searchTerm = prop.getProperty("Posters_search_text");
		wait.until(ExpectedConditions.visibilityOf(posterSearch)).sendKeys(""+"Test" + Keys.ENTER);
		System.out.println(">> User enter the poster name in search field: " + searchTerm);
	}
	
	@FindBy(xpath = "(//td[normalize-space()='Test'])[1]")
	private WebElement posterSearchedList;

	public void display_searchedposter() {
		wait.until(ExpectedConditions.visibilityOf(posterSearchedList)).isDisplayed();
		AssertJUnit.assertTrue(posterSearchedList.isDisplayed());
		System.out.println(">> User got searched project list: " + posterSearchedList.getText());
	}
	
	@FindBy(xpath = "(//h6[@class='m-0 by fw-normal'][normalize-space()='Recently Updated'])[1]")
	private WebElement clicksortbutton;

	public void Click_Sort() {
		wait.until(ExpectedConditions.visibilityOf(posterSearchedList)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(clicksortbutton)).click();
	}
	
	@FindBy(xpath = "(//h6[@class='m-0 by fw-normal'][normalize-space()='Recently Updated'])[1]")
	WebElement Posters_sort_recentlyupdated;
	
	public void Sort_recently_Updated() {	
		wait.until(ExpectedConditions.visibilityOf(Posters_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void display_Sort_recently_updatedd() {
		wait.until(ExpectedConditions.visibilityOf(Posters_sort_recentlyupdated)).isDisplayed();
		AssertJUnit.assertTrue(Posters_sort_recentlyupdated.isDisplayed());
		System.out.println(">> User got sorted the recently updated list");
	}
	
	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[1]")
	WebElement Posters_sort_recentlyadded;
	
	public void Sort_recently_added() {	
		wait.until(ExpectedConditions.visibilityOf(Posters_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently updated in sort");
	}
	
	public void display_Sort_recently_added() {
		wait.until(ExpectedConditions.visibilityOf(Posters_sort_recentlyadded)).isDisplayed();
		AssertJUnit.assertTrue(Posters_sort_recentlyadded.isDisplayed());
		System.out.println(">> User got sorted the recently added list");
	}
	@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
	WebElement Posters_sort_AtoZ;
	
	public void Sort_Name_A_to_Z() {	
		wait.until(ExpectedConditions.visibilityOf(Posters_sort_AtoZ)).click();
		System.out.println(">> User clicked Posters sort A to Z");
	}
	
	public void display_Sort_Name_A_to_Z() {
		wait.until(ExpectedConditions.visibilityOf(Posters_sort_AtoZ)).isDisplayed();
		AssertJUnit.assertTrue(Posters_sort_AtoZ.isDisplayed());
		System.out.println(">> User got sorted the Name A-Z list");
	}
	
	@FindBy(xpath = "//h6[normalize-space()='Name - Z to A']")
	WebElement Posters_sort_ZtoA;
	
	@FindBy(xpath = "(//h6[contains(@class,'fw-bold m-0')][normalize-space()='Sort By'])[1]")
	WebElement Sortby_popup;
	
	public void Sort_Name_Z_to_A() throws Exception {	
		wait.until(ExpectedConditions.visibilityOf(Sortby_popup)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(Posters_sort_ZtoA)).click();
		System.out.println(">> User clicked Posters sort Z to A");
	}
	
	@FindBy(xpath = "(//h6[@class='m-0 by fw-normal'][normalize-space()='Name - Z to A'])[1]")
	WebElement displayPosters_sort_ZtoA;
	
	public void display_Sort_Name_Z_to_A() {
		wait.until(ExpectedConditions.visibilityOf(displayPosters_sort_ZtoA)).isDisplayed();
		AssertJUnit.assertTrue(displayPosters_sort_ZtoA.isDisplayed());
		System.out.println(">> User got sorted the Name Z-A list");
	}	
	
	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	WebElement Posters_sort_Decending_Date;
	
	public void Sort_Decending_Date() {	
		wait.until(ExpectedConditions.visibilityOf(Posters_sort_Decending_Date)).click();
		System.out.println(">> User clicked Posters Decending Date ");
	}
	
	public void display_Sort_Decending_Date() {
		wait.until(ExpectedConditions.visibilityOf(Posters_sort_Decending_Date)).isDisplayed();
		AssertJUnit.assertTrue(Posters_sort_Decending_Date.isDisplayed());
		System.out.println(">> User got sorted the Decending Date list");
	}
	
	@FindBy(xpath = "(//*[name()='svg' and @viewBox='0 0 16 16'])[1]")
	WebElement click_on_kebab;
	
	public void Onclicks_kebabu_menu () {
		wait.until(ExpectedConditions.visibilityOf(Posters_menu)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(click_on_kebab)).click();	
	}

	@FindBy(xpath = "(//a[normalize-space()='Edit'])[1]")
	WebElement click_edit;
	
	public void Onclicks_Edit () {
        wait.until(ExpectedConditions.visibilityOf(click_edit)).click();	
	}
	
	@FindBy(id = "poster_no")
	WebElement poster_no;
	
	@FindBy(id = "Edit Poster")
	WebElement click_updatebuttn;
	
	@FindBy(xpath = "(//h4[normalize-space()='Edit Poster'])[1]")
	WebElement editposter_displayed;
	
	public void Update_Poster () {
		wait.until(ExpectedConditions.visibilityOf(editposter_displayed)).isDisplayed();
		poster_no.sendKeys(Keys.CONTROL, "a" ,Keys.DELETE);
		String posterno = prop.getProperty("posterno");
        wait.until(ExpectedConditions.visibilityOf(poster_no)).sendKeys(generateUniqueNumber(""+posterno));
        wait.until(ExpectedConditions.visibilityOf(click_updatebuttn)).click();	
	}
	
	@FindBy(id = "New poster")
	WebElement clickNew_Poster;
	
	public void Click_New_Poster () {
		
		wait.until(ExpectedConditions.visibilityOf(Posters_menu)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(clickNew_Poster)).click();
		
	}
	
	@FindBy(id = "title")
	WebElement poster_name;
	
	@FindBy(xpath = "(//h4[normalize-space()='Add Poster'])[1]")
	WebElement display_New_Poster;
	
	public void Enter_New_Poster_Fields () {
		
		wait.until(ExpectedConditions.visibilityOf(display_New_Poster)).isDisplayed();
		String postername = prop.getProperty("postername");
		wait.until(ExpectedConditions.visibilityOf(poster_name)).sendKeys(generateUniqueNumber(""+postername));
		wait.until(ExpectedConditions.visibilityOf(clickNew_Poster)).isDisplayed();
		String posterno = prop.getProperty("posterno");
        wait.until(ExpectedConditions.visibilityOf(poster_no)).sendKeys(generateUniqueNumber(""+posterno));
	}
	
	@FindBy(xpath = "(//input[@name='image_urls'])[1]")

	private WebElement Click_upload_photos;

	public void Upload_Posterimage() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(poster_no));
		act.moveToElement(Click_upload_photos).perform();
		String Alarabia_Poster = System.getProperty("user.dir") + "/Documents/Alarabia_Poster.jpg";
		Click_upload_photos.sendKeys(Alarabia_Poster);
	}
	
	@FindBy(id = "Add Poster")
	WebElement click_AddPoster;
	
	public void Click_Add_Poster () {
		
		wait.until(ExpectedConditions.visibilityOf(Posters_menu)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_AddPoster)).click();
	}

	@FindBy(xpath = "(//a[normalize-space()='Inventory'])[1]")
	WebElement inventoryclick;
	
	public void Inventory_click() {
		wait.until(ExpectedConditions.elementToBeClickable(profiledisplay)).isDisplayed();
		act.moveToElement(inventoryclick).click().perform();
		LOGGER.info(">> Admin/User got navigated to inventory page");
	}
	
	@FindBy(xpath = "(//a[normalize-space()='Poster Printing'])[1]")
	WebElement Poster_Printingclick;
	
	@FindBy(xpath = "//a[@id='Material Rec. (From Supplier)']")
	WebElement inventories_display;
	
	public void Poster_Printing_click() throws Exception {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(inventories_display)).isDisplayed();
		act.scrollToElement(Poster_Printingclick).perform();
		wait.until(ExpectedConditions.visibilityOf(Poster_Printingclick)).click();
		LOGGER.info(">> Admin/User got navigated to Poster Printing page");
	}

	@FindBy(xpath = "(//th[normalize-space()='Requested Qty'])[1]")
	private WebElement display_postersprinting;

	public void Display_Posterprinting() {
		wait.until(ExpectedConditions.visibilityOf(display_postersprinting)).isDisplayed();
		AssertJUnit.assertTrue(display_postersprinting.isDisplayed());
		LOGGER.info(">> The Tickets page got displayed");
	}
	
	@FindBy(id = "New poster printing")
	WebElement click_New_Poster_Printing;
	
	public void New_Poster_Printing_click () {
		
		wait.until(ExpectedConditions.visibilityOf(display_postersprinting)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_New_Poster_Printing)).click();
	}
	
	@FindBy(xpath = "(//h5[normalize-space()='New poster printing'])[1]")
	WebElement display_Newpostersprinting_page;
	
	@FindBy(xpath = "(//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer'])[1]")
	WebElement Select_poster;
	
	@FindBy(id = "requested_qty")
	WebElement requested_Qty;
	
	@FindBy(xpath = "(//div[@class='select__control css-13cymwt-control'])[2]")
	WebElement selectBranch;
	
	@FindBy(xpath = "(//input[@name='allocations.0.qty'])[1]")
	WebElement posterprint_requested_Qty;
	
	public void NewPoster_printing_Details () throws Exception {
		
		wait.until(ExpectedConditions.visibilityOf(display_Newpostersprinting_page)).isDisplayed();
		act.moveToElement(Select_poster).click().sendKeys(""+Keys.ENTER).perform();
		wait.until(ExpectedConditions.visibilityOf(Select_poster)).isDisplayed();
		requested_Qty.sendKeys(Keys.CONTROL,"a" , Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(requested_Qty)).sendKeys(""+"30");
		wait.until(ExpectedConditions.visibilityOf(requested_Qty)).isDisplayed();
		act.moveToElement(selectBranch).click().sendKeys(""+Keys.ENTER).perform();
		Thread.sleep(2000);
		posterprint_requested_Qty.sendKeys(Keys.CONTROL,"a" , Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(posterprint_requested_Qty)).sendKeys(""+"30");
	}
	
	@FindBy(id = "Create")
	WebElement click_New_create_Button;
	
	public void Clicks_Create_Button () {		
//		wait.until(ExpectedConditions.visibilityOf(display_Newpostersprinting_page)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_New_create_Button)).click();
	}
}	