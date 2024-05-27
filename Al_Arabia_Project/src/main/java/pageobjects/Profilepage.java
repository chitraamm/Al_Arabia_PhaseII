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
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Actions act;
	private Logger LOGGER = LogManager.getLogger(Profilepage.class);
	private Signinpage signinpage;

	public Profilepage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		this.signinpage = new Signinpage(driver);
		LOGGER = LogManager.getLogger(Profilepage.class.getName());
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

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div/div[1]/div/div")
    private WebElement Profile;
    
    public void Profile() {
		wait.until(ExpectedConditions.visibilityOf(Profile)).click();
		wait.until(ExpectedConditions.visibilityOf(Profile)).isDisplayed();
		
	}
	
    @FindBy(xpath = "//div[contains(@class,'row')]//li[1]")
    private WebElement Persoalprofile;
    
    public void Personalprofile() {
    	wait.until(ExpectedConditions.visibilityOf(Profile)).click();
    	
    }
    
    @FindBy(name = "name")
    private WebElement personalinfo;
    
    public void personalinfo() {
    	wait.until(ExpectedConditions.visibilityOf(personalinfo)).isDisplayed();
    }
    
    @FindBy(xpath = "//button[contains(@type,'submit')]")
    private WebElement Updatebutton;
    
    public void Updatebutton() {
    	wait.until(ExpectedConditions.visibilityOf(Updatebutton)).click();
    	
    }
    
    @FindBy(xpath = "//h6[normalize-space()='Yes, update.']")
    private WebElement Yesbutton;
    
    public void Yesbutton() {
    	wait.until(ExpectedConditions.visibilityOf(Yesbutton)).click();
    	wait.until(ExpectedConditions.visibilityOf(Yesbutton)).isDisplayed();
    }
    
    @FindBy(name = "name")
	private WebElement success;

	public void members_profile_personal_name() {
		wait.until(ExpectedConditions.visibilityOf(success));
		AssertJUnit.assertTrue(success.isDisplayed());
		System.out.println(">> User or Admin got the members personal profile page successfully");
	}
    
    

	
	
	
	
	
	
	
	
	
	
	

}
