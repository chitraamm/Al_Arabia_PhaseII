package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import resources.Base;

public class Memberspage extends Base {
    private WebDriver driver;
    private WebDriverWait wait;
    private Properties prop;
//    private Actions act;
    private Logger LOGGER = LogManager.getLogger(Memberspage.class);

    
    public Memberspage(WebDriver driver) throws Exception {
        this.driver = driver;
        prop = new Properties();
//        act = new Actions(driver);
        PageFactory.initElements(driver, this);
        String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
        FileInputStream fis = new FileInputStream(propPath);
        prop.load(fis);
        initializeWait();
        LOGGER = LogManager.getLogger(Memberspage.class.getName());
    }

    private void initializeWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private String generateUniqueEmail(String baseEmail) {
        return baseEmail.replace("@", +System.currentTimeMillis() + "@");
    }
    
    @FindBy(xpath = "//span[normalize-space()='Members']")
    private WebElement membersClick;
    public void membersClick() {
        wait.until(ExpectedConditions.visibilityOf(membersClick)).click();
        LOGGER.info(">> Admin/User got navigated to members page");
    }

    @FindBy(xpath = "//h6[normalize-space()='Dashboard'][position()=1]")
    private WebElement dashboardText;
    public void dashboardText() {
        wait.until(ExpectedConditions.visibilityOf(dashboardText)).isDisplayed();
        LOGGER.info(">> Admin/User got navigated to dashboard page");
    }

    @FindBy(xpath = "//h5[@class=' mb-0 '][position()=1]")
    private WebElement allMembersCount;
    public void allMembersCount() {
        wait.until(ExpectedConditions.visibilityOf(allMembersCount)).isDisplayed();
        AssertJUnit.assertTrue(allMembersCount.isDisplayed());
        LOGGER.info(">> The members dashboard list page got displayed");
    }

    @FindBy(xpath = "//button[@class=' btn_invite_member  btn btn-primary'][normalize-space()='Invite Member']")
    private WebElement inviteMemberBtn;
    public void inviteMemberBtn() {
        wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(inviteMemberBtn)).click();
        LOGGER.info(">> User clicked the invite member button");
    }

    @FindBy(xpath = "//tbody/tr[1]/td[6]/div[1]/div[1]/button[1]//*[name()='svg']")
    private WebElement membersMenu;
 

    @FindBy(name = "email")
    private WebElement inviteEmailPhoneNumberField;
    public void inviteEmailPhoneNumberField() {
        String uniqueEmail = generateUniqueEmail(prop.getProperty("Invite_email"));
        wait.until(ExpectedConditions.visibilityOf(inviteEmailPhoneNumberField)).click();
        wait.until(ExpectedConditions.visibilityOf(inviteEmailPhoneNumberField)).sendKeys(uniqueEmail);
        LOGGER.info(">> User clicked the invite member button");
    }

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]")
    private WebElement inviteSelectRole;
    public void inviteSelectRole() {
        wait.until(ExpectedConditions.visibilityOf(inviteSelectRole)).click();
        wait.until(ExpectedConditions.visibilityOf(inviteSelectRoleSelect)).click();
        LOGGER.info(">> User selected the role:" + inviteSelectRole.getText());
    }


    @FindBy(id = "react-select-6-listbox")
    private WebElement inviteSelectRoleSelect;
    public void inviteSelectDept() {
        wait.until(ExpectedConditions.visibilityOf(inviteSelectDept)).click();
        wait.until(ExpectedConditions.visibilityOf(inviteSelectDeptSelect)).click();
        LOGGER.info(">> User selected the role:" + inviteSelectDept.getText());
    }

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]")
    private WebElement inviteSelectDept;
  

    @FindBy(id = "react-select-8-listbox")
    private WebElement inviteSelectDeptSelect;

    @FindBy(xpath = "//form[contains(@class,'floating was-validated')]//button[contains(@type,'submit')]")
    private WebElement inviteSendInvite;
    public void inviteSendInvite() {
        wait.until(ExpectedConditions.visibilityOf(inviteSendInvite)).click();
        LOGGER.info(">> User clicked the send invite button");
    }

    @FindBy(id = "doc_searchQueryInput")
    private WebElement membersSearch;
    public void membersSearch() {
        wait.until(ExpectedConditions.visibilityOf(membersMenu)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(membersSearch)).click();
        String searchTerm = prop.getProperty("members_search_text");
        wait.until(ExpectedConditions.visibilityOf(membersSearch)).sendKeys(searchTerm + Keys.ENTER);
        System.out.println(">> User enter the member name in search field: " + searchTerm);
    }
    
    @FindBy(xpath = "//h6[contains(text(),'panneer')]")
    private WebElement membersSearchedList;
    public void membersSearchedList() {
        wait.until(ExpectedConditions.visibilityOf(membersSearchedList)).isDisplayed();
        AssertJUnit.assertTrue(membersSearchedList.isDisplayed());
        System.out.println(">> User got searched members list: " + membersSearchedList.getText());
    }

    
}

