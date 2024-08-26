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

public class Cleaningpage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Actions act;
	private Logger LOGGER = LogManager.getLogger(Cleaningpage.class);
	//private Signinpage signinpage;


	public Cleaningpage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		//this.signinpage = new Signinpage(driver);
		LOGGER = LogManager.getLogger(Cleaningpage.class.getName());
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
	
	@FindBy(xpath = "//span[normalize-space()='Cleaning']")
	private WebElement cleaningClick;

	@FindBy(xpath = "//span[normalize-space()='Cleaning']")
	private WebElement cleaning_menu;

	public void Cleaning_click() {
		wait.until(ExpectedConditions.elementToBeClickable(cleaningClick)).click();
		wait.until(ExpectedConditions.visibilityOf(cleaning_menu)).isDisplayed();
		LOGGER.info(">> Admin/User got navigated to cleaning page");
	}

	@FindBy(xpath = "//h5[contains(@class,'mb-0')]")
	private WebElement cleaningCount;

	public void AllcleaningCount() {
		wait.until(ExpectedConditions.visibilityOf(cleaningCount)).isDisplayed();
		AssertJUnit.assertTrue(cleaningCount.isDisplayed());
		LOGGER.info(">> The Cleaning page got displayed");
	}
	
	@FindBy(id = "New Group")
	private WebElement click_New_Group_button;
	
	public void New_Group_button() {
		wait.until(ExpectedConditions.visibilityOf(click_New_Group_button)).click();
	}
	@FindBy(xpath = "//*[@id=\"group_name\"]")
	private WebElement group_Name;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/form/div/div/div/div[2]/div/div/div/div/div[1]")
	private WebElement ticket_title;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/form/div/div/div/div[4]/div/div/div/div")
	private WebElement schedule;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/form/div/div/div/div[5]/div/div/div/div/div[1]/div[2]")
	private WebElement Billboard_Type ;
	
	@FindBy(xpath = "(//div[contains(@class,'select__input-container css-19bb58m')])[3]")
	private WebElement nameofBillboard;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/form/div/div/div/div[10]/div/div/div/div/div[1]")
	private WebElement Priority;
	
	@FindBy(id = "react-select-16-input")
	private WebElement Assignee;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/form/div/div/div/div[12]/div/div[1]/input")
	private WebElement Start_Date;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/form/div/div/div/div[12]/div/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div/div[6]/div[3]/span")
	private WebElement selected_start_date;
	
//	@FindBy(xpath = "//input[@name='invoice_date']")
//	private WebElement End_Date;
	
	@FindBy(xpath = "//*[@id=\"description\"]")
	private WebElement Description;
	
	public void Mandatory_fields_enter_new_cleaning() throws Exception {

	String groupname = prop.getProperty("groupname");
	wait.until(ExpectedConditions.visibilityOf(group_Name)).sendKeys(groupname);
	
	wait.until(ExpectedConditions.visibilityOf(group_Name)).isDisplayed();
	Thread.sleep(1000);
	act.moveToElement(ticket_title).click().sendKeys(""+Keys.ENTER).perform();
	
	wait.until(ExpectedConditions.visibilityOf(ticket_title)).isDisplayed();
	Thread.sleep(1000);
	act.moveToElement(schedule).click().sendKeys(""+Keys.ARROW_DOWN+Keys.ENTER).perform();
	
	wait.until(ExpectedConditions.visibilityOf(schedule)).isDisplayed();
	Thread.sleep(2000);
	act.moveToElement(Billboard_Type).click().sendKeys(""+Keys.ARROW_DOWN+Keys.ENTER).perform();
	Thread.sleep(2000);

//	String billboard = prop.getProperty("billboardsname");
//	Thread.sleep(5000);
//    act.moveToElement(nameofBillboard).click().sendKeys(""+(billboard)).perform();
//	Thread.sleep(2000);

	Thread.sleep(2000);
	String billboard = prop.getProperty("billboardsname");
	wait.until(ExpectedConditions.visibilityOf(Assignee)).sendKeys(billboard);
	Thread.sleep(5000);
	act.moveToElement(nameofBillboard).click().sendKeys(""+Keys.ENTER+Keys.ARROW_RIGHT).perform();
  
	wait.until(ExpectedConditions.visibilityOf(nameofBillboard)).isDisplayed();
	Thread.sleep(1000);
	act.moveToElement(Priority).click().sendKeys(""+Keys.ARROW_DOWN+Keys.ENTER).perform();
	
	wait.until(ExpectedConditions.visibilityOf(Priority)).isDisplayed();
	Thread.sleep(1000);
	act.moveToElement(Assignee).click().sendKeys(""+Keys.ARROW_DOWN+Keys.ENTER).perform();
	Thread.sleep(2000);

    act.moveToElement(Start_Date).click().perform();
	Thread.sleep(2000);

    act.moveToElement(selected_start_date).click().perform();
	Thread.sleep(2000);

    String description = prop.getProperty("descriptiontexts");
    act.moveToElement(Description).click().sendKeys(""+(description)).perform();
    
//	String description = prop.getProperty("groupname");
//	wait.until(ExpectedConditions.visibilityOf(group_Name)).sendKeys(groupname);
	}
	@FindBy(id = "Create Group")
	private WebElement create_group;

	public void Create_group_button() {
		wait.until(ExpectedConditions.visibilityOf(cleaningCount)).isDisplayed();
		act.moveToElement(create_group).click().perform();
	}
	@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
	private WebElement Cleaning_created_Success_display;

	public String cleaning_create_Success_display() throws Exception {
		WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(Cleaning_created_Success_display));
		return successMessageElement.getText().trim();
	}
	@FindBy(id = "doc_searchQueryInput")
	private WebElement CleaningSearch;
	
	public void Cleaning_search_enter_text() {
		wait.until(ExpectedConditions.visibilityOf(CleaningSearch)).click();
		String ticket_search = prop.getProperty("Cleaningno");
		wait.until(ExpectedConditions.visibilityOf(CleaningSearch)).sendKeys(ticket_search + Keys.ENTER);
		System.out.println(">> User enter the Cleaning number in search field: " + ticket_search);
	}
	@FindBy(xpath = "//tbody/tr[contains(@class,'table_white')]/td[1]/div[1]")
	private WebElement cleaningSearchedList, Cleaninglist;

	public void CleaningSearchedList() {
		wait.until(ExpectedConditions.visibilityOf(cleaningSearchedList));

		if (cleaningSearchedList.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new ticket btn");
		System.out.println(">> User got searched BB list: " + cleaningSearchedList.getText());
	}

	public void Cleaninglist() {
		wait.until(ExpectedConditions.visibilityOf(cleaningSearchedList));

		if (Cleaninglist.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User searched a Cleaning");
		System.out.println(">> User got searched Cleaning list: " + Cleaninglist.getText());
	}

	@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
	private WebElement cleaning_sort;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement cleaning_sort_recentlyupdated;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
	private WebElement cleaning_sort_recentlyadded;

	public void Cleaning_sort_recentlyupdated() {
		wait.until(ExpectedConditions.visibilityOf(cleaning_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(cleaning_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void Cleaning_sort_recentlyadded() {
		wait.until(ExpectedConditions.visibilityOf(cleaning_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(cleaning_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently added in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement cleaning_Name_A_to_Z;

	public void Cleaning_A_to_Z() {
		wait.until(ExpectedConditions.visibilityOf(cleaning_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(cleaning_Name_A_to_Z)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
	private WebElement cleaning_Name_Z_to_A;

	public void Cleaning_sortZ_A() {
		wait.until(ExpectedConditions.visibilityOf(cleaning_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(cleaning_Name_Z_to_A)).click();
		System.out.println(">> User clicked Z-A updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	private WebElement Cleaning_Name_decending;

	public void Cleaning_DecendingDate() {
		wait.until(ExpectedConditions.visibilityOf(cleaning_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(Cleaning_Name_decending)).click();
		System.out.println(">> User clicked decending updated in sort");
	}
	@FindBy(xpath = "(//div[contains(@class,'filterbox')])[1]")
	private WebElement cleaning_filter;

	@FindBy(xpath = "(//span[contains(text(),'Automatic')])[1]")
	private WebElement automatic_status;

	@FindBy(id = "Apply")
	private WebElement cleaning_filter_apply_btn;

	public void Automatic_list() {
		wait.until(ExpectedConditions.visibilityOf(cleaning_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(automatic_status)).click();
		act.moveToElement(cleaning_filter_apply_btn).click().perform();
		System.out.println(">> User clicked automatic status in filter");
	}
	@FindBy(xpath = "(//div[contains(text(),'No Data Found')])[1]")
	private WebElement No_Cleanings_found;

	public void Cleaning_filtered_result_display() {
		try {
			if (condition) {
				wait.until(ExpectedConditions.visibilityOf(Cleaninglist));
				AssertJUnit.assertTrue(Cleaninglist.isDisplayed());
				System.out.println(">> User got the filtered Cleaning list");
			} else {
				wait.until(ExpectedConditions.visibilityOf(No_Cleanings_found));
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(No_Cleanings_found));
		}
	}
	@FindBy(id = "MANUAL")
	private WebElement manual_status;
	public void Manual_list() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(cleaning_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(manual_status)).click();
		act.moveToElement(cleaning_filter_apply_btn).click().perform();

		System.out.println(">>Manual status Cleaning list filtered");
	}
	@FindBy(id = "DRY")
	private WebElement dry_status;
	public void Dry_list()throws Exception {
		wait.until(ExpectedConditions.visibilityOf(cleaning_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(dry_status)).click();
		act.moveToElement(cleaning_filter_apply_btn).click().perform();
	}
	@FindBy(xpath = "(//span[contains(text(),'Wet')])[1]")
	private WebElement wet_status;
	public void Wet_list()throws Exception {
	wait.until(ExpectedConditions.visibilityOf(cleaning_filter)).click();
	act.moveToElement(wet_status).click().perform();
	wait.until(ExpectedConditions.visibilityOf(wet_status)).isDisplayed();

	act.moveToElement(cleaning_filter_apply_btn).click().perform();
	}
	@FindBy(id = "HIGH")
	private WebElement high_priority;
	public void Priority_High_list()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(cleaning_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(high_priority)).click();
		act.moveToElement(cleaning_filter_apply_btn).click().perform();
	}
	@FindBy(id = "MEDIUM")
	private WebElement medium_priority;
	public void Priority_Medium_list()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(cleaning_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(medium_priority)).click();
		act.moveToElement(cleaning_filter_apply_btn).click().perform();
	}
	@FindBy(id = "LOW")
	private WebElement low_priority;
	public void Priority_Low_list()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(cleaning_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(low_priority)).click();
		act.moveToElement(cleaning_filter_apply_btn).click().perform();
	}

	public void Multiple_status_filter()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(cleaning_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(automatic_status)).click();
		//act.moveToElement(automatic_status).click().perform();
		act.moveToElement(wet_status).click().perform();
		act.moveToElement(high_priority).click().perform();
		act.moveToElement(cleaning_filter_apply_btn).click().perform();
	}
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='Download'])[1]")
	private WebElement download_cleaning;
	public void Cleaning_Download()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(download_cleaning)).click();
	}
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='Download'])[1]")
	private WebElement popup_download_cleaning_display;
	public void Popup_download_cleaning_display()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(download_cleaning)).isDisplayed();
        AssertJUnit.assertTrue(download_cleaning.isDisplayed());
}
	@FindBy(xpath = "//div[normalize-space()='As Excel']")
	private WebElement excel_download_cleaning;
	public void Excel_Download()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(excel_download_cleaning)).click();;
}
	@FindBy(xpath = "//div[normalize-space()='As PDF']")
	private WebElement pdf_download_cleaning;
	public void PDF_Download()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(pdf_download_cleaning)).click();;
}
	@FindBy(xpath = "(//*[name()='path'][contains(@fill-rule,'evenodd')])[2]")
	private WebElement close_download_cleaning;
	public void Close_Download()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(close_download_cleaning)).click();;
}
	@FindBy(xpath = "(//input[contains(@placeholder,'DD-MM-YYYY')])[1]")
	private WebElement startdate_clicked;
	@FindBy(xpath = "//span[normalize-space()='20']")
	private WebElement startdate_selected;
	public void StartDate_filter()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(cleaning_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(startdate_clicked)).click();
		wait.until(ExpectedConditions.visibilityOf(startdate_selected)).click();

		act.moveToElement(cleaning_filter_apply_btn).click().perform();
	}
	@FindBy(xpath = "(//input[contains(@placeholder,'DD-MM-YYYY')])[2]")
	private WebElement enddate_clicked;
	@FindBy(xpath = "//span[normalize-space()='20']")
	private WebElement enddate_selected;
	public void StartEnd_Date_filter()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(cleaning_filter)).click();
		wait.until(ExpectedConditions.visibilityOf(startdate_clicked)).click();
		wait.until(ExpectedConditions.visibilityOf(startdate_selected)).click();
		wait.until(ExpectedConditions.visibilityOf(enddate_clicked)).click();
		wait.until(ExpectedConditions.visibilityOf(enddate_selected)).click();
		act.moveToElement(cleaning_filter_apply_btn).click().perform();
	}
	@FindBy(id = "react-select-3-input")
	private WebElement assignee_select;

	public void Select_Assignee_filter() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(cleaning_filter)).click();
		//String assignee = prop.getProperty("Assignee");
		wait.until(ExpectedConditions.visibilityOf(assignee_select)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(assignee_select)).sendKeys("" + Keys.ENTER);
		act.moveToElement(cleaning_filter_apply_btn).click().perform();
		System.out.println(">> User selected the assignee in filter" + assignee_select);
	}
	@FindBy(id = "react-select-4-input")
	private WebElement billboard_type_select;

	public void Select_Billboard_Type_cleaning_filter() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(cleaning_filter)).click();
		act.moveToElement(billboard_type_select).click().sendKeys(""+Keys.ENTER).perform();
		Thread.sleep(2000);
		act.moveToElement(cleaning_filter_apply_btn).click().perform();
		System.out.println(">> User selected the assignee in filter" + billboard_type_select);
	}
	@FindBy(xpath = "(//img[contains(@class,'pointer')])[2]")
	private WebElement Edit_Buttonclick;

	public void Click_edit_group() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(Edit_Buttonclick)).click();
	}
	@FindBy(id = "group_name")
	private WebElement group_edited;

	@FindBy(xpath = "//h5[normalize-space()='Cleaning']")
	private WebElement edit_priority_label;

	public void Group_edited() {

		wait.until(ExpectedConditions.visibilityOf(edit_priority_label));
		String Editgroup = prop.getProperty("Editgroup");
		act.moveToElement(group_edited).click().sendKeys(Editgroup);
		LOGGER.info("User updated the Group ");
	}

	@FindBy(xpath = "//h6[normalize-space()='Update Group']")
	private WebElement group_update_button;

	public void Group_update_clicked() throws Exception {
		Thread.sleep(2000);
		act.moveToElement(group_update_button).perform();
		wait.until(ExpectedConditions.visibilityOf(group_update_button)).click();

	}
	@FindBy(xpath = "//h6[normalize-space()='Yes, update it.']")
	private WebElement group_update_confirm_yes_button;

	public void update_Group_confirmed() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(group_update_confirm_yes_button)).click();

	}
}	
