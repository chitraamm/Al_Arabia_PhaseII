package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import resources.Base;

public class Masterpage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Actions act;
	private Logger LOGGER = LogManager.getLogger(Cleaningpage.class);
	//private Signinpage signinpage;


	public Masterpage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		//this.signinpage = new Signinpage(driver);
		LOGGER = LogManager.getLogger(Masterpage.class.getName());
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
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a[6]/span")
	private WebElement click_master_module;

	public void Master_click() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(click_master_module)).click();;
	}
	@FindBy(xpath = "//h5[normalize-space()='Department(8)']")
	private WebElement departmentCount;

	public void alldepartmentCount() {
		wait.until(ExpectedConditions.visibilityOf(departmentCount)).isDisplayed();
		AssertJUnit.assertTrue(departmentCount.isDisplayed());
		LOGGER.info(">> The department page got displayed");
	}
	
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='New Department'])[1]")
	private WebElement click_new_departmentbutton;

	public void New_Department_button_click() throws Exception {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(click_new_departmentbutton)).click();
	}
}
