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

//	private String generateUniqueEmail(String baseEmail) {
//		return baseEmail.replace("@", +System.currentTimeMillis() + "@");
//	}
	
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
		String searchTerm = prop.getProperty("projects_search_text");
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

	

	
}	