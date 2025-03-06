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

public class Profilepage extends Base {
	private final WebDriver driver;
	private WebDriverWait wait;
	private final Properties prop;
	private final Actions act;

    public Profilepage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
        Signinpage signinpage = new Signinpage(driver);
        Logger LOGGER = LogManager.getLogger(Profilepage.class.getName());
	}

	private final boolean condition = true;

	private void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private String generateUniqueEmail(String baseEmail) {
		return baseEmail.replace("@", +System.currentTimeMillis() + "@");
	}

	private static String generateUniqueIQMANumber(String baseIQMANumber) {
		Random rand = new Random();
		return baseIQMANumber + rand.nextInt(100); // Append random number
	}

	private static String generateUniqueLicenceNumber(String baseLicenceNumber) {
		Random rand = new Random();
		return baseLicenceNumber + rand.nextInt(1000); // Append random number
	}

	@FindBy(xpath = "(//span[contains(text(),'C')])[2]")
	private WebElement Profile;

	public void Profile() {
		wait.until(ExpectedConditions.visibilityOf(Profile)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(Profile)).click();
	}

	@FindBy(xpath = "//a[normalize-space()='Personal Profile']")
	private WebElement Personalprofile;

	public void Personalprofile() {
		wait.until(ExpectedConditions.visibilityOf(Personalprofile)).click();
	}

	
	@FindBy(id = "name")
	private WebElement personalinfo_name;
	
	@FindBy(xpath = "//input[@name='contact_number']")
	private WebElement contact_number; 
	
	@FindBy(name = "alternate_number")
	private WebElement alternate_number; 
	
	@FindBy(name = "whatsapp_number")
	private WebElement whtsap_number; 

	@FindBy(xpath = "//input[@placeholder='Enter Location']")
	private WebElement Location; 

	@FindBy(id = "iqama_no")
	private WebElement personalinfo_iqma, iqmaerror;
	@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")

	private WebElement profile_success_display;
	
	public void Personalinfo_details() throws Exception {
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(personalinfo_name)).isDisplayed();
		
		contact_number.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		String Phone_number = prop.getProperty("Phone_number");
		wait.until(ExpectedConditions.visibilityOf(contact_number)).sendKeys(Phone_number);
        Thread.sleep(2000);
		
        alternate_number.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		String Alt_Phone_number = prop.getProperty("Alt_Phone_number");
		wait.until(ExpectedConditions.visibilityOf(alternate_number)).sendKeys(Alt_Phone_number);
        Thread.sleep(2000);

        whtsap_number.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		String Whatsapp_Phone_number = prop.getProperty("Whatsapp_Phone_number");
		wait.until(ExpectedConditions.visibilityOf(whtsap_number)).sendKeys(Whatsapp_Phone_number);
        Thread.sleep(2000);

		String location = prop.getProperty("location");
		wait.until(ExpectedConditions.visibilityOf(Location)).sendKeys(location);
        Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(Location)).sendKeys(""+Keys.ARROW_DOWN+Keys.ENTER);
        Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOf(personalinfo_iqma)).click();
		personalinfo_iqma.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		String uniqueIQMANumber = generateUniqueIQMANumber(prop.getProperty("Iqma"));
		wait.until(ExpectedConditions.visibilityOf(personalinfo_iqma)).sendKeys(uniqueIQMANumber);
      
	}
	
	public void personalinfo_Updatebutton_text_enter() throws Exception {
		Thread.sleep(2000);
	    act.moveToElement(members_personalprofile_update_btn_Yes).click().perform();
	}

	@FindBy(xpath = "(//h4[@class=' fw-semibold text-center text-black'])[1]")
	private WebElement confirmpopup;
	
	@FindBy(xpath = "//h6[normalize-space()='Yes, update.']")
	private WebElement Yesbutton;

	public void Yesbutton() throws Exception{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(confirmpopup)).isDisplayed();
       act.moveToElement(Yesbutton).click().perform();
	}
	
	public String profile_success_display() {
		WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(profile_success_display));
		return successMessageElement.getText().trim();
	}
	
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[2]/div/div[1]/input")
	private WebElement personalinfo_contractnumber_text_enter;

	@FindBy(xpath = "//input[@value='+91 88833 80008']")
	private WebElement personalinfo_alternatenumber_text_enter;

	@FindBy(xpath = "//input[contains(@error,'alternate number required')]")
	private WebElement personalinfo_alternatenumber_text_enter1;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div[2]/div/div[1]/input")
	private WebElement personalinfo_whatsappnumber_text_enter;

	@FindBy(xpath = "//input[contains(@error,'whatsapp number required')]")
	private WebElement personalinfo_whatsappnumber_text_enter1;

	@FindBy(xpath = "//input[@value='Coducer Technologies Private Limited, RAJ INFINITY, AECS Layout - A Block, AECS Layout, Singasandra, Bengaluru, Karnataka, India']")
	private WebElement personalinfo_location_text_enter;

	@FindBy(name = "biography")
	private WebElement personalinfo_biography_text_enter;

	public void personalinfo_text_enter() throws Exception {
		personalinfo_alternatenumber_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(personalinfo_alternatenumber_text_enter1))
				.sendKeys(prop.getProperty("Phone_number"));
		wait.until(ExpectedConditions.visibilityOf(personalinfo_whatsappnumber_text_enter)).click();
		personalinfo_whatsappnumber_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(personalinfo_whatsappnumber_text_enter1))
				.sendKeys(prop.getProperty("App_Phone_number"));
		wait.until(ExpectedConditions.visibilityOf(personalinfo_biography_text_enter)).click();
		personalinfo_biography_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(personalinfo_biography_text_enter)).sendKeys("Demo");
		wait.until(ExpectedConditions.visibilityOf(personalinfo_location_text_enter)).click();
		personalinfo_location_text_enter.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(personalinfo_location_text_enter))
				.sendKeys("Saudi Arabia" + Keys.ARROW_DOWN + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(Yesbutton)).click();

	}

	@FindBy(xpath = "//h6[normalize-space()='Reset form']")
	private WebElement Resetform;

	public void Resetform() throws Exception{
		Thread.sleep(2000);
	    wait.until(ExpectedConditions.visibilityOf(personalinfo_iqma)).isDisplayed();
		act.moveToElement(Resetform).click().perform();
		//wait.until(ExpectedConditions.visibilityOf(Resetform)).click();
	}

	@FindBy(xpath = "//h6[normalize-space()='Yes, reset it.']")
	private WebElement YesResetform;

	public void YesResetform() {
		
		act.moveToElement(YesResetform).click().perform();
		//wait.until(ExpectedConditions.visibilityOf(YesResetform)).click();
	}

	@FindBy(xpath = "(//h6[normalize-space()=\"No, don't reset it!\"])[1]")
	private WebElement NoResetform;

	public void NoResetform() {
		wait.until(ExpectedConditions.visibilityOf(NoResetform)).click();
	}

	@FindBy(xpath = "//div[contains(@class,'popup')]//h6[1]")
	private WebElement Noupdate;

	public void Noupdate() {
		wait.until(ExpectedConditions.visibilityOf(Noupdate)).click();
	}

	public void nameerror() {
		wait.until(ExpectedConditions.visibilityOf(iqmaerror)).click();
		iqmaerror.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(personalinfo_name)).click();
	}
	@FindBy(xpath = "//small[@class='form-text text-danger form_error']")
	private WebElement IQMA_error_display;
	
	public void IQMAerror_display() {
		wait.until(ExpectedConditions.visibilityOf(IQMA_error_display)).isDisplayed();
		AssertJUnit.assertTrue(IQMA_error_display.isDisplayed());
	}
	
	public void locationerror() {
		
		wait.until(ExpectedConditions.visibilityOf(Location)).isDisplayed();
		Location.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(personalinfo_name)).click();
	}
	@FindBy(xpath = "//small[@class='form-text text-danger form_error']")
	private WebElement locationserror;
	public void locationerror_display() {
		
		wait.until(ExpectedConditions.visibilityOf(locationserror)).isDisplayed();
		AssertJUnit.assertTrue(locationserror.isDisplayed());
	}
	
	@FindBy(id = "Update Personal Profile")
	private WebElement members_personalprofile_update_btn_Yes;

}
