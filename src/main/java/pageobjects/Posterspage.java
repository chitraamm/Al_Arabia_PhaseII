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
	
	@FindBy(xpath = "//th[normalize-space()='Poster number']")
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
	

	
}	