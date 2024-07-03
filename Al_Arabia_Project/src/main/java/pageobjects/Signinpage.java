package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import resources.Base;

public class Signinpage extends Base {

    private Logger LOGGER = LogManager.getLogger(Signinpage.class);
    private WebDriver driver;
    private WebDriverWait wait;
    private Properties prop;

    public Signinpage(WebDriver driver) throws Exception {
        this.driver = driver;
        prop = new Properties();
        PageFactory.initElements(driver, this);

        String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
        FileInputStream fis = new FileInputStream(propPath);
        prop.load(fis);

        initializeWait();
    }

    private void initializeWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Page Elements
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "signin")
    private WebElement signinButton;

    @FindBy(xpath = "//small[normalize-space()='Invalid email address or phone number']")
    private WebElement userPasswordError;

    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    private WebElement dashboard;

    @FindBy(xpath = "//small[contains(text(),'Password is too short- should be 8 characters')]")
    private WebElement passwordTooShortError;

    @FindBy(xpath = "//small[normalize-space()='Must Contain One Number']")
    private WebElement passwordNoNumberError;

    @FindBy(xpath = "//small[normalize-space()='Must Contain One Special Case Character']")
    private WebElement passwordNoSpecialCharError;

    @FindBy(xpath = "//small[normalize-space()='Must Contain One Uppercase, One Lowercase']")
    private WebElement passwordNoUppercaseError;

    @FindBy(xpath = "//span[@class='eyeicon']//*[name()='svg']")
    private WebElement passwordFieldEyeIcon;

    @FindBy(xpath = "//small[normalize-space()='E-mail Address or phone number is required']")
    private WebElement emailPhoneNoRequiredError;

    // Page Methods
    public void enterValidEmail() {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(prop.getProperty("Admin_email_address"));
        LOGGER.info("User enters valid email address");
    }

    public void emailField() {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(prop.getProperty("Supervisor_email_address"));
        LOGGER.info("Supervisor enters valid email address");
    }
    
    public void enterInvalidEmail() {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(prop.getProperty("INV_email_address"));
    }

    public void clickEmailField() {
        wait.until(ExpectedConditions.visibilityOf(emailField)).click();
    }

    public void enterValidPassword() {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(prop.getProperty("Admin_password"));
        LOGGER.info("User enters valid password");
    }

    public void clickPasswordField() {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).click();
    }

    public void enterInvalidPassword() {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(prop.getProperty("INV_password"));
    }

    public void enterInvalidPasswordWithoutUpperCharacter() {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(prop.getProperty("INVpassword_withoutupper_character"));
    }

    public void enterInvalidPasswordShortCharacter() {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(prop.getProperty("INVpassword_short_character"));
    }

    public void enterInvalidPasswordWithoutSpecialCharacter() {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(prop.getProperty("INVpassword_withoutspl_character"));
    }

    public void enterPasswordWithoutNumber() {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(prop.getProperty("INV_withoutNO_password"));
    }

    public void clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signinButton)).click();
        LOGGER.info("User clicks on signin button");
    }

    public void checkUserPasswordErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(userPasswordError));
        AssertJUnit.assertTrue(userPasswordError.isDisplayed());
        LOGGER.info("User got an invalid username and password error message");
    }

    public void checkDashboardDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(dashboard));
        AssertJUnit.assertTrue(dashboard.isDisplayed());
        LOGGER.info("Al-Arabia user got signed in successfully");
    }

    public void checkPasswordTooShortErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(passwordTooShortError)).isDisplayed();
        LOGGER.info("User got a password_is_too_short_error message");
    }

    public void checkPasswordNoNumberErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(passwordNoNumberError)).isDisplayed();
        LOGGER.info("User got a must contain one number error message");
    }

    public void checkPasswordNoSpecialCharErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(passwordNoSpecialCharError)).isDisplayed();
        LOGGER.info("User got a must contain one special case character error message");
    }

    public void checkPasswordNoUppercaseErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(passwordNoUppercaseError)).isDisplayed();
        LOGGER.info("User got a must contain one uppercase character error message");
    }

    public void clickPasswordFieldEyeIcon() {
        wait.until(ExpectedConditions.visibilityOf(passwordFieldEyeIcon)).click();
        LOGGER.info("User clicked password_field_eyeicon");
    }

    public void checkEmailPhoneNoRequiredErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(emailPhoneNoRequiredError)).isDisplayed();
        LOGGER.info("User has got the emailphoneNo_required_error");
    }
}

