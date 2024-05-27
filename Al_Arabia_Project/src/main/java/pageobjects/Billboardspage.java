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

	@FindBy(xpath = "//button[contains(@class,'btn_invite_member  btn btn-primary')]")
	private WebElement New_billboardClick, New_billboard_display;

	public void New_billboardClick() {
		wait.until(ExpectedConditions.visibilityOf(New_billboardClick)).click();
		LOGGER.info(">> Admin/User clicked new billboard btn");
	}
	
	public void New_billboard_display() {
		wait.until(ExpectedConditions.visibilityOf(New_billboard_display)).isDisplayed();
		LOGGER.info(">> Admin/User clicked new billboard btn");
	}

	@FindBy(name = "board_no")
	private WebElement Newbillboard_boardno;

	@FindBy(xpath = "//input[contains(@itemtype,'establishment')]")
	private WebElement Newbillboard_BB_location;

	@FindBy(xpath = "//input[@type='text'][@tabindex='0']")
	private WebElement Newbillboard_BB_type;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]")
	private WebElement Newbillboard_BOM_type;
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]")
	private WebElement Newbillboard_city;
	
	@FindBy(name = "team_viewer_id")
	private WebElement Newbillboard_teamviewer_id;
	
	@FindBy(name = "team_viewer_password")
	private WebElement Newbillboard_teamviewer_password;
	
	@FindBy(name = "longitude")
	private WebElement Newbillboard_longtitude;
	
	@FindBy(name = "latitude")
	private WebElement Newbillboard_lontitude;
	
	@FindBy(name = "screen_width")
	private WebElement Newbillboard_screen_width;
	
	@FindBy(name = "screen_height")
	private WebElement Newbillboard_screen_height;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div[2]/form/div[1]/div[6]/div[2]/div/div[1]/div/div[1]/div[2]")
	private WebElement Newbillboard_screen_resolution;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div[2]/form/div[1]/div[7]/div[1]/div/div/div/div[1]")
	private WebElement Newbillboard_screen_units;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div[2]/form/div[1]/div[7]/div[2]/div/div[1]/div/div[1]/div[2]")
	private WebElement Newbillboard_screen_pixel;
	
	@FindBy(name = "screen_model")
	private WebElement Newbillboard_screen_model;

	public void NewBillboard_mandatory_fields_enter() {
		String uniqueboardno = generateUniqueboardNumber(prop.getProperty("BB_NO"));
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_boardno)).sendKeys(uniqueboardno);
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_BB_location))
				.sendKeys("Saudi Arabia" + Keys.ARROW_DOWN + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_BB_type)).click();
		Newbillboard_BB_type.sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_BOM_type)).click();
		Newbillboard_BOM_type.sendKeys("" + Keys.ARROW_DOWN +Keys.ARROW_DOWN+ Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_city)).click();
		Newbillboard_city.sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_teamviewer_id)).sendKeys("123456789");
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_teamviewer_password)).sendKeys("Password@123");
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_longtitude)).sendKeys("23.8859");
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_lontitude)).sendKeys("45.0792");
		
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_screen_width)).sendKeys("80");
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_screen_height)).sendKeys("40");
		
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_screen_resolution)).click();
		Newbillboard_screen_resolution.sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_screen_units)).click();
		Newbillboard_screen_units.sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOf(Newbillboard_screen_pixel)).click();
		Newbillboard_screen_pixel.sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER);
		
	}
	
	
	@FindBy(name = "//button[@type='submit']")
	private WebElement Newbillboard_create_BB_btn;

	public void Newbillboard_create_BB_btn() {
	act.scrollToElement(Newbillboard_create_BB_btn).click().perform();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}