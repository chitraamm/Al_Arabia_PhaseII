package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
//import java.util.Random;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import resources.Base;

public class Inventorypage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Actions act;
	private Logger LOGGER = LogManager.getLogger(Inventorypage.class);
	private Signinpage signinpage;


	public Inventorypage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		this.signinpage = new Signinpage(driver);
		LOGGER = LogManager.getLogger(Inventorypage.class.getName());
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
	@FindBy(xpath = "//span[normalize-space()='Inventory']")
	private WebElement inventoryClick;

	@FindBy(xpath = "//span[normalize-space()='Inventory']")
	private WebElement inventory_menu;

	public void Inventory_click() {
		wait.until(ExpectedConditions.elementToBeClickable(inventoryClick)).click();
		wait.until(ExpectedConditions.visibilityOf(inventory_menu)).isDisplayed();
		LOGGER.info(">> Admin/User got navigated to inventory page");
	}

	@FindBy(xpath = "//h5[contains(@class,'mb-0')]")
	private WebElement purchaseCount;

	public void allpurchaseCount() {
		wait.until(ExpectedConditions.visibilityOf(purchaseCount)).isDisplayed();
		AssertJUnit.assertTrue(purchaseCount.isDisplayed());
		LOGGER.info(">> The Inventory page got displayed");
	}
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='New Purchase'])[1]	")
	private WebElement click_New_Purchase;
	
	public void New_purchase_button() {
		wait.until(ExpectedConditions.visibilityOf(click_New_Purchase)).click();
	}
	@FindBy(id = "react-select-3-input")
	private WebElement supplier_name;
	
	@FindBy(xpath = "//input[@name='invoice_no']")
	private WebElement invoice_id;
	
	@FindBy(xpath = "//input[@name='invoice_date']")
	private WebElement invoice_date;
	
	@FindBy(xpath = "//span[normalize-space()='19']")
	private WebElement clicked_invoice_date;
	
	@FindBy(xpath = "//input[@name='po_no']")
	private WebElement purchase_number;
	
	@FindBy(xpath = "//input[@name='po_date']")
	private WebElement purchase_date;
	
	@FindBy(xpath = "//span[normalize-space()='27']")
	private WebElement clicked_purchased_date;
	
	@FindBy(xpath = "//input[@name='consignment_batch_no']")
	private WebElement Consignment_batch_no;
	
	@FindBy(xpath = "//input[@name='date_recevied']")
	private WebElement Date_recevied;
	
	@FindBy(xpath = "//span[normalize-space()='28']")
	private WebElement clicked_received_date;
	
	@FindBy(xpath = "//input[@name='project_name']")
	private WebElement project_name;
	
	public void Mandatory_fields_enter_new_purchase() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(supplier_name));

		act.moveToElement(supplier_name).click().sendKeys("" + Keys.ENTER).perform();
		
		String invoiceid = prop.getProperty("invoiceid");
		wait.until(ExpectedConditions.visibilityOf(invoice_id)).sendKeys(invoiceid);
		
		act.moveToElement(invoice_date).click().perform();
		act.moveToElement(clicked_invoice_date).click().perform();
		
		String purchasenumber = prop.getProperty("purchasenumber");
		wait.until(ExpectedConditions.visibilityOf(purchase_number)).sendKeys(purchasenumber);

		act.moveToElement(purchase_date).click().perform();
		act.moveToElement(clicked_purchased_date).click().perform();
		
		String consignmentnumber = prop.getProperty("consignmentnumber");
		wait.until(ExpectedConditions.visibilityOf(Consignment_batch_no)).sendKeys(consignmentnumber);
		
		act.moveToElement(Date_recevied).click().perform();
		act.moveToElement(clicked_received_date).click().perform();
		
		String projectname = prop.getProperty("projectname");
		wait.until(ExpectedConditions.visibilityOf(project_name)).sendKeys(projectname);
	}
	@FindBy(xpath = "")
	private WebElement add_purchase_button;
	
	public void Add_purchase_button() {
		wait.until(ExpectedConditions.visibilityOf(add_purchase_button)).click();
	}
	 
}