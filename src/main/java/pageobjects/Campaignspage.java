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

public class Campaignspage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop; 
	private Actions act;
	private Logger LOGGER = LogManager.getLogger(Campaignspage.class);
	private Signinpage signinpage;
	public Campaignspage(WebDriver driver) throws Exception {
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


	@FindBy(xpath = "//span[normalize-space()='Tickets']")
	private WebElement campaignsClick;

	@FindBy(xpath = "(//td[contains(@class,'d-flex')])[2]")
	private WebElement tickets_menu;

	public void campaigns_click() {
		wait.until(ExpectedConditions.elementToBeClickable(campaignsClick)).click();
		wait.until(ExpectedConditions.visibilityOf(tickets_menu)).isDisplayed();
		LOGGER.info(">> Admin/User got navigated to Tickets page");
	}
	
	@FindBy(xpath = "(//h5[contains(@class,'mb-0')])[1]")
	private WebElement campaignsCount;

	public void allcampaignsCount() {
		wait.until(ExpectedConditions.visibilityOf(campaignsCount)).isDisplayed();
		AssertJUnit.assertTrue(campaignsCount.isDisplayed());
		LOGGER.info(">> The Tickets page got displayed");
	}

	
}	