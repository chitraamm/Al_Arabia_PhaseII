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
		return baseIQMANumber + rand.nextInt(10000); // Append random number
	}

	private static String generateUniqueLicenceNumber(String baseLicenceNumber) {
		Random rand = new Random();
		return baseLicenceNumber + rand.nextInt(1000); // Append random number
	}

	@FindBy(xpath = "//span[normalize-space()='BillBoards']")
	private WebElement billboardClick;

	@FindBy(xpath = "//table[contains(@class,'table')]")
	private WebElement billboardMenu;

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

	

}