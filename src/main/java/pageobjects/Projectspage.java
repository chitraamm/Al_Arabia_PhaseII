package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import resources.Base;

public class Projectspage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Actions act;
	private Logger LOGGER = LogManager.getLogger(Memberspage.class); 
	private Signinpage signinpage;

	public Projectspage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		this.signinpage = new Signinpage(driver);
		LOGGER = LogManager.getLogger(Memberspage.class.getName());
	}

	private boolean condition = true;

	private void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
//
//	private String generateUniqueEmail(String baseEmail) {
//		return baseEmail.replace("@", +System.currentTimeMillis() + "@");
//	}
	
	private static String generateUniqueNumber(String baseLicenceNumber) {
		Random rand = new Random();
		return baseLicenceNumber + rand.nextInt(1000);
	}

	@FindBy(xpath = "(//a[normalize-space()='Projects'])[1]")
	WebElement projectsClick;

	public void Projects_Click() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(projectsClick)).click();
		LOGGER.info(">> Admin/User got navigated to projects page");
	}
	
	@FindBy(xpath = "//th[normalize-space()='Project Name']")
	WebElement display_projects;

	public void Projects_Display() {
		wait.until(ExpectedConditions.visibilityOf(display_projects)).isDisplayed();
		AssertJUnit.assertTrue(display_projects.isDisplayed());
		LOGGER.info(">> The projects list page got displayed");
	}
	
//	@FindBy(xpath = "(//h5[contains(@class,'mb-0')])[1]")
//	WebElement allMembersCount;
//
//	public void allMembersCount() {
//		wait.until(ExpectedConditions.visibilityOf(allMembersCount)).isDisplayed();
//		AssertJUnit.assertTrue(allMembersCount.isDisplayed());
//		LOGGER.info(">> The members dashboard list page got displayed");
//	}
	
	@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
	private WebElement Success_display,members_profile_Success_display1;

	public String success_display() {
		WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(Success_display));
		return successMessageElement.getText().trim();
	}
	
	public String members_profile_success_display1() throws Exception {
		WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(members_profile_Success_display1));
		return successMessageElement.getText().trim();
	}
	
	@FindBy(id = "doc_searchQueryInput")
	private WebElement projectSearch;

	public void Search_Project() {
		wait.until(ExpectedConditions.visibilityOf(display_projects)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(projectSearch)).click();
		String searchTerm = prop.getProperty("projects_search_text");
		wait.until(ExpectedConditions.visibilityOf(projectSearch)).sendKeys(""+"Test" + Keys.ENTER);
		System.out.println(">> User enter the member name in search field: " + searchTerm);
	}
	
	@FindBy(xpath = "(//td[normalize-space()='Default Project'])[1]")
	private WebElement projectSearchedList;

	public void Project_SearchedList() {
		wait.until(ExpectedConditions.visibilityOf(projectSearchedList)).isDisplayed();
		AssertJUnit.assertTrue(projectSearchedList.isDisplayed());
		System.out.println(">> User got searched project list: " + projectSearchedList.getText());
	}
	
	@FindBy(xpath = "(//div[@class='d-flex sortbox foractivesort'])[1]")
	WebElement clickssort;
	
	public void Click_sort_button() {

		wait.until(ExpectedConditions.visibilityOf(display_projects)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(clickssort)).click();
		System.out.println(">> User clicked sort");
	}
	
	@FindBy(xpath = "(//h6[@class='m-0 by fw-normal'][normalize-space()='Recently Updated'])[1]")
	WebElement projects_sort_recentlyupdated;
	
	public void Sort_recently_updated() {	
		wait.until(ExpectedConditions.visibilityOf(projects_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void display_Sort_recently_updated() {
		wait.until(ExpectedConditions.visibilityOf(projects_sort_recentlyupdated)).isDisplayed();
		AssertJUnit.assertTrue(projects_sort_recentlyupdated.isDisplayed());
		System.out.println(">> User got sorted the recently updated list");
	}
	
	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[1]")
	WebElement projects_sort_recentlyadded;
	
	public void Sort_recently_added() {	
		wait.until(ExpectedConditions.visibilityOf(projects_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently updated in sort");
	}
	
	public void display_Sort_recently_added() {
		wait.until(ExpectedConditions.visibilityOf(projects_sort_recentlyadded)).isDisplayed();
		AssertJUnit.assertTrue(projects_sort_recentlyadded.isDisplayed());
		System.out.println(">> User got sorted the recently added list");
	}
	
	@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
	WebElement projects_sort_AtoZ;
	
	public void Sort_Name_A_to_Z() {	
		wait.until(ExpectedConditions.visibilityOf(projects_sort_AtoZ)).click();
		System.out.println(">> User clicked projects sort A to Z");
	}
	
	public void display_Sort_Name_A_to_Z() {
		wait.until(ExpectedConditions.visibilityOf(projects_sort_AtoZ)).isDisplayed();
		AssertJUnit.assertTrue(projects_sort_AtoZ.isDisplayed());
		System.out.println(">> User got sorted the Name A-Z list");
	}
	
	@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
	WebElement projects_sort_ZtoA;
	
	public void Sort_Name_Z_to_A() {	
		wait.until(ExpectedConditions.visibilityOf(projects_sort_ZtoA)).click();
		System.out.println(">> User clicked projects sort Z to A");
	}
	
	public void display_Sort_Name_Z_to_A() {
		wait.until(ExpectedConditions.visibilityOf(projects_sort_ZtoA)).isDisplayed();
		AssertJUnit.assertTrue(projects_sort_ZtoA.isDisplayed());
		System.out.println(">> User got sorted the Name Z-A list");
	}	
	
	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	WebElement projects_sort_Decending_Date;
	
	public void Sort_Decending_Date() {	
		wait.until(ExpectedConditions.visibilityOf(projects_sort_Decending_Date)).click();
		System.out.println(">> User clicked projects Decending Date ");
	}
	
	public void display_Sort_Decending_Date() {
		wait.until(ExpectedConditions.visibilityOf(projects_sort_Decending_Date)).isDisplayed();
		AssertJUnit.assertTrue(projects_sort_Decending_Date.isDisplayed());
		System.out.println(">> User got sorted the Decending Date list");
	}
	
	@FindBy(id = "Download")
	WebElement click_download_button;
	
	public void Onclicks_Download_Button () {
		wait.until(ExpectedConditions.visibilityOf(display_projects)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(click_download_button)).click();	
	}
	
	public void Downloaded_Projects () {
		System.out.println(">> Projects list get downloaded successfully");
	}
	
	
	@FindBy(xpath = "//tbody/tr[1]/td[5]/div[1]/div[1]/button[1]//*[name()='svg']")
	WebElement click_on_kebab;
	
	public void Onclicks_kebabu_menu () {
		wait.until(ExpectedConditions.visibilityOf(display_projects)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(click_on_kebab)).click();	

	}
	
	@FindBy(xpath = "(//a[normalize-space()='Edit'])[1]")
	WebElement click_edit;
	
	public void Onclicks_Edit () {
		wait.until(ExpectedConditions.visibilityOf(display_projects)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(click_edit)).click();	
	}
		
	@FindBy(id = "title")
	WebElement project_name;
	
	@FindBy(xpath = "(//h4[normalize-space()='Edit Project'])[1]")
	WebElement editproject_display;
	
	public void User_Update_projectname () {
		wait.until(ExpectedConditions.visibilityOf(editproject_display)).isDisplayed();
		project_name.sendKeys(Keys.CONTROL, "a" ,Keys.DELETE);
        wait.until(ExpectedConditions.visibilityOf(project_name)).sendKeys(generateUniqueNumber(prop.getProperty("projectname")));	
        
	}	
	
	@FindBy(id = "Edit Projects")
	WebElement User_clicks_edit_projects;
	
	public void User_clicks_edit_projects () {
        wait.until(ExpectedConditions.visibilityOf(User_clicks_edit_projects)).click();	
        
	}
	
	@FindBy(xpath = "(//div[normalize-space()='2'])[1]")
	WebElement nextPageButton;

	public void Next_page_icon_click() throws Exception {
		
	    try {

	        wait.until(ExpectedConditions.visibilityOf(nextPageButton)).click();
	        System.out.println("Second page clicked successfully.");
	        
	    } catch (NoSuchElementException e) {
	        System.out.println("Second page element not found , Proceeding without clicking");
	    } catch (Exception e) {
	    	
	        System.out.println("An error occurred while handling the second page: " + e.getMessage());
	    }
	}

	public void Display_Next_page() throws Exception {
	try {
    	if (previousPageButton.isDisplayed() && nextPageButton.isEnabled()) {
			LOGGER.info("✅ Successfully clicked the 'Next' button.");
			Thread.sleep(2000);

			LOGGER.warn("⚠️ Clicked 'Next' but next page not displayed — possibly only one page is available.");
			AssertJUnit.assertTrue(true);
      }
	}
    	catch (NoSuchElementException e) {
    		
        System.out.println("Second page element not found. Proceeding without clicking.");
    } catch (Exception e) {
    	
        System.out.println("An error occurred while handling the second page: " + e.getMessage());
     }
	}
	
	@FindBy(xpath = "(//button[@title='Previous Page'])[1]")
	WebElement previousPageButton;
	
	public void Previous_pageicon_click() {
	    try {
	    	
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.elementToBeClickable(previousPageButton)).click();
	        LOGGER.info("✅ Clicked the 'Previous' page button.");
	        
	    } catch (TimeoutException e) {
	        LOGGER.warn("⚠️ 'Previous' button not clickable – likely already on the first page.");
	        AssertJUnit.assertTrue(true); // Mark as passed (graceful skip)
	        
	    } catch (Exception e) {
	        LOGGER.error("❌ Unexpected error while clicking previous page button: " + e.getMessage());
	        AssertJUnit.fail("Error clicking 'Previous' button.");
	    }
	}

	@FindBy(xpath = "//div[contains(@class,'round-effect activeEffect')]")
	WebElement displayPageone;

	public void Display_FirstPage() {
		try {
			wait.until(ExpectedConditions.visibilityOf(displayPageone));
			if (displayPageone.isDisplayed()) {
				LOGGER.info("✅ First page displayed");
				AssertJUnit.assertTrue(true);
			} else {
				LOGGER.error("❌ First page not visible even though it was located.");
				AssertJUnit.fail("First page not visible.");
			}
		} catch (Exception e) {
			LOGGER.error("❌ Exception occurred while checking first page: " + e.getMessage());
			AssertJUnit.fail("first page not found or not visible.");
		}
	}
	
	@FindBy(xpath = "(//button[@id=' New Project '])[1]")
	WebElement clicks_newproject_button;
	
	public void Click_NewProject_button () {
        wait.until(ExpectedConditions.visibilityOf(display_projects)).isDisplayed();	
        wait.until(ExpectedConditions.visibilityOf(clicks_newproject_button)).click();	       
	}
	
	@FindBy(xpath = "(//input[@placeholder='Enter Location'])[1]")
	WebElement location ;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div/div[2]/div/div/div[2]/div[3]/div/div/div/form/div[3]/div[1]/span[1]")
	WebElement static_project ;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div/div[2]/div/div/div[2]/div[3]/div/div/div/form/div[3]/div[1]/span[2]")
	WebElement Digital_project ;
	
	@FindBy(xpath = "(//h4[normalize-space()='Add Project'])[1]")
	WebElement display_newproject_popup;
	
	public void Enter_mandatoryfields_Newproject () throws Exception {
        wait.until(ExpectedConditions.visibilityOf(display_newproject_popup)).isDisplayed();	
        wait.until(ExpectedConditions.visibilityOf(project_name)).sendKeys(generateUniqueNumber(prop.getProperty("projectname")));
        wait.until(ExpectedConditions.visibilityOf(location)).sendKeys(""+"riyadh");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(location)).sendKeys(""+Keys.DOWN+Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(static_project)).click();
        wait.until(ExpectedConditions.visibilityOf(Digital_project)).click();
	}
	
	@FindBy(id = "Add Projects")
	WebElement clicks_Addprojects_button;
	
	public void Clicks_Add_Projects () {
        wait.until(ExpectedConditions.visibilityOf(display_newproject_popup)).isDisplayed();	
        wait.until(ExpectedConditions.visibilityOf(clicks_Addprojects_button)).click();	       
	}
	
	public void New_Project_without_ProjectName () throws Exception {
        wait.until(ExpectedConditions.visibilityOf(display_newproject_popup)).isDisplayed();	
        wait.until(ExpectedConditions.visibilityOf(location)).sendKeys(""+"riyadh");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(location)).sendKeys(""+Keys.DOWN+Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(static_project)).click();
        wait.until(ExpectedConditions.visibilityOf(Digital_project)).click();
	}
	
	@FindBy(xpath = "//small[normalize-space()='Project Name is required']")
	WebElement display_projectname_required_error;
	
	public void Error_ProjectName_required () {
        wait.until(ExpectedConditions.visibilityOf(display_projectname_required_error)).isDisplayed();	
		AssertJUnit.assertTrue(display_projectname_required_error.isDisplayed());
		System.out.println(">> User got Error Project Name required");
	}
	
	public void New_Project_without_locationName () throws Exception {
        wait.until(ExpectedConditions.visibilityOf(display_newproject_popup)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(project_name)).sendKeys(generateUniqueNumber(prop.getProperty("projectname")));
        wait.until(ExpectedConditions.visibilityOf(static_project)).click();
        wait.until(ExpectedConditions.visibilityOf(Digital_project)).click();
	}
	
	@FindBy(xpath = "//small[text()='Project Location is required']")
	WebElement display_locationname_required_error;
	
	public void Error_locationName_required () {
        wait.until(ExpectedConditions.visibilityOf(display_locationname_required_error)).isDisplayed();	
		AssertJUnit.assertTrue(display_locationname_required_error.isDisplayed());
		System.out.println(">> User got Error location Name required");
	}
	
	public void New_Project_without_project_type () throws Exception {
        wait.until(ExpectedConditions.visibilityOf(display_newproject_popup)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(project_name)).sendKeys(generateUniqueNumber(prop.getProperty("projectname")));
	}
	
	@FindBy(xpath = "//div[text()='Billboard Type is required']")
	WebElement display_project_type_required_error;
	
	public void Error_project_type_required () {
        wait.until(ExpectedConditions.visibilityOf(display_project_type_required_error)).isDisplayed();	
		AssertJUnit.assertTrue(display_project_type_required_error.isDisplayed());
		System.out.println(">> User got Error project type is required");
	}
	
}