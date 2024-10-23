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
import org.openqa.selenium.support.ui.ExpectedCondition;
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
		wait.until(ExpectedConditions.visibilityOf(click_master_module)).click();
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
	@FindBy(id = "title")
	private WebElement enter_department;
	
	@FindBy(xpath = "(//h6[normalize-space()='Add Department'])[1]")
	private WebElement click_adddepartment;

	public void Add_Department() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(enter_department));
		String departmentname = prop.getProperty("departmentname");
		wait.until(ExpectedConditions.visibilityOf(enter_department)).sendKeys(departmentname);
		Thread.sleep(2000);
		act.moveToElement(click_adddepartment).click().perform();
	}
	@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
	private WebElement department_created_Success_display;

	public String department_created_Success_display() throws Exception {
		WebElement successMessageElement = wait
				.until(ExpectedConditions.visibilityOf(department_created_Success_display));
		return successMessageElement.getText().trim();
	}
	@FindBy(xpath = "//div[@class='list_members p-3 ']")
	private WebElement departmentlist;
	
	@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
	private WebElement Department_Search;
	
	public void Department_search_enter_text() {
		wait.until(ExpectedConditions.visibilityOf(departmentlist)).click();
		String Department_Search = prop.getProperty("departmentname");
		wait.until(ExpectedConditions.visibilityOf(departmentlist)).sendKeys(Department_Search + Keys.ENTER);
		System.out.println(">> User enter the department id in search field: " + Department_Search);
	}
	@FindBy(xpath = "(//td[normalize-space()='ADMIN'])[1]")
	private WebElement DepartmentSearched, departmentSearch;

	public void DepartmentSearchedList() {
		wait.until(ExpectedConditions.visibilityOf(departmentlist));

		if (DepartmentSearched.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User searched Department");
		System.out.println(">> User got searched Department list: " + departmentSearch.getText());
	}

	public void Departmentlist() {
		wait.until(ExpectedConditions.visibilityOf(departmentlist));

		if (departmentlist.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new department btn");
		System.out.println(">> User got sorted department list: " + departmentlist.getText());
	}

	@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
	private WebElement department_sort;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement Department_sort_recentlyupdated;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
	private WebElement Department_sort_recentlyadded;

	public void Department_sort_recentlyupdated() {
		wait.until(ExpectedConditions.visibilityOf(department_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(Department_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void Department_sort_recentlyadded() {
		wait.until(ExpectedConditions.visibilityOf(department_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(Department_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently added in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
	private WebElement department_Name_A_to_Z;

	public void Department_sortA_Z() {
		wait.until(ExpectedConditions.visibilityOf(department_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(department_Name_A_to_Z)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
	private WebElement department_Name_Z_to_A;

	public void Department_sortZ_A() {
		wait.until(ExpectedConditions.visibilityOf(department_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(department_Name_Z_to_A)).click();
		System.out.println(">> User clicked Z-A updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	private WebElement department_Name_decending;

	public void Department_DecendingDate() {
		wait.until(ExpectedConditions.visibilityOf(department_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(department_Name_decending)).click();
		System.out.println(">> User clicked decending updated in sort");
	}

	@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
	private WebElement kebabmenu_click;
	
	public void kebabmenu() throws Exception {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(kebabmenu_click)).click();
	}
	@FindBy(xpath = "(//a[@role='button'][normalize-space()='Edit'])[1]")
	private WebElement click_edit_department;

	public void selects_edit_department() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(click_edit_department)).click();
	}
	@FindBy(xpath = "(//h6[normalize-space()='Edit Department'])[1]")
	private WebElement click_Edit_departmentbuttn;

	public void Updated_department() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(enter_department));
		String edited_departmentname = prop.getProperty("newdepartmentname");
		wait.until(ExpectedConditions.visibilityOf(enter_department)).sendKeys(edited_departmentname);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(click_Edit_departmentbuttn)).click();
	}
	@FindBy(xpath = "//a[normalize-space()='Delete']")
	private WebElement click_delete_department;

	public void selects_delete_department() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(click_delete_department)).click();
	}
	
//<------------------------------------Supplier---------------------------------------->
	
	@FindBy(xpath = "//span[@class='edit_link_routes false']")
	private WebElement click_supplier;

	public void Supplier_click() throws Exception {
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(click_master_module)).click();
		wait.until(ExpectedConditions.visibilityOf(click_supplier)).click();
	}
	@FindBy(xpath = "//h5[contains(@class,'mb-0')]")
	private WebElement SupplierCount;

	public void allSupplierCount() {
		wait.until(ExpectedConditions.visibilityOf(SupplierCount)).isDisplayed();
		AssertJUnit.assertTrue(SupplierCount.isDisplayed());
		LOGGER.info(">> The Supplier page got displayed");
	}
	
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='New Supplier'])[1]")
	private WebElement click_new_Supplierbutton;

	public void New_Supplier_button_click() throws Exception {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(click_new_Supplierbutton)).click();
	}
	@FindBy(xpath = "//h5[normalize-space()='New Supplier']")
	private WebElement NewSupplier_page_padding;
	
	@FindBy(id = "name")
	private WebElement Supplier_name;
	
	@FindBy(id = "supplier_id")
	private WebElement Supplier_id;
	
	@FindBy(xpath = "//input[@id='contact_person']")
	private WebElement contact_person;
	
	@FindBy(xpath = "(//h6[normalize-space()='Add Supplier'])[1]")
	private WebElement click_addSupplier;
	
	@FindBy(xpath = "//input[@placeholder='Enter phone number']")
	private WebElement contact_number;
	
	@FindBy(id = "email")
	private WebElement enter_email;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Location'])[1]")
	private WebElement cityname;
	
	@FindBy(id = "country")
	private WebElement country_name;

	public void Enter_Mandatory_fields_Supplier () throws Exception {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(NewSupplier_page_padding)).isDisplayed();
		String suppliername = prop.getProperty("suppliername");
		wait.until(ExpectedConditions.visibilityOf(Supplier_name)).sendKeys(suppliername);
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(Supplier_name)).isDisplayed();
		String supplierid = prop.getProperty("supplierid");
		wait.until(ExpectedConditions.visibilityOf(Supplier_id)).sendKeys(supplierid);
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(Supplier_id)).isDisplayed();
		String Contactperson = prop.getProperty("Contactperson");
		wait.until(ExpectedConditions.visibilityOf(contact_person)).sendKeys(Contactperson);
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(contact_person)).isDisplayed();
		String contactnumber = prop.getProperty("Phone_number");
		wait.until(ExpectedConditions.visibilityOf(contact_number)).sendKeys(contactnumber);
	
		wait.until(ExpectedConditions.visibilityOf(contact_number)).isDisplayed();
	    String emailfield = prop.getProperty("emailfield");
	    wait.until(ExpectedConditions.visibilityOf(enter_email)).sendKeys(emailfield);
	    
	    wait.until(ExpectedConditions.visibilityOf(enter_email)).isDisplayed();
	    wait.until(ExpectedConditions.visibilityOf(cityname)).sendKeys("Riyadh Saudi Arabia");
		Thread.sleep(3000);
	    wait.until(ExpectedConditions.visibilityOf(cityname)).sendKeys(""+Keys.DOWN+Keys.ENTER);
	   
	    wait.until(ExpectedConditions.visibilityOf(cityname)).isDisplayed();
	    String countryname = prop.getProperty("countryname");
	    wait.until(ExpectedConditions.visibilityOf(country_name)).sendKeys(countryname);

	}
	@FindBy(id = "Add Supplier")
	private WebElement click_addsupplier;
	
	public void Add_Supplier() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(country_name)).isDisplayed();

		wait.until(ExpectedConditions.visibilityOf(click_addSupplier)).click();
		
	}
	@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
	private WebElement Supplier_created_Success_display;

	public String Supplier_created_Success_display() throws Exception {
		WebElement successMessageElement = wait
				.until(ExpectedConditions.visibilityOf(Supplier_created_Success_display));
		return successMessageElement.getText().trim();
	}
	@FindBy(id = "doc_searchQueryInput")
	private WebElement supplierSearch;
	
	public void Supplier_search_enter_text() {
		wait.until(ExpectedConditions.visibilityOf(SupplierSearch)).click();
		String Supplier_Search = prop.getProperty("Suppliernames");
		wait.until(ExpectedConditions.visibilityOf(supplierSearch)).sendKeys(Supplier_Search + Keys.ENTER);
		System.out.println(">> User enter the Supplier id in search field: " + Supplier_Search);
	}
	@FindBy(id = "doc_searchQueryInput")
	private WebElement SupplierSearched, SupplierSearch;

	@FindBy(xpath = "//table[@class='table']")
	private WebElement supplierlist;
	
	public void SupplierSearchedList() {
		wait.until(ExpectedConditions.visibilityOf(SupplierSearch));

		if (SupplierSearched.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User searched Supplier");
		System.out.println(">> User got searched Supplier list: " + SupplierSearch.getText());
	}

	public void Supplierlist() {
	//	wait.until(ExpectedConditions.visibilityOf(SupplierSearch));

		if (supplierlist.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new Supplier btn");
		System.out.println(">> User got sorted Supplier list: " + supplierlist.getText());
	}

	@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
	private WebElement Supplier_sort;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement Supplier_sort_recentlyupdated;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
	private WebElement Supplier_sort_recentlyadded;

	public void Supplier_sort_recentlyupdated() {
		wait.until(ExpectedConditions.visibilityOf(Supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(Supplier_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void Supplier_sort_recentlyadded() {
		wait.until(ExpectedConditions.visibilityOf(Supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(Supplier_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently added in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
	private WebElement A_to_Z_Supplier_Name;

	public void A_Z_Supplier_sort() {
		wait.until(ExpectedConditions.visibilityOf(Supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(A_to_Z_Supplier_Name)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
	private WebElement Supplier_Name_Z_to_A;

	public void Supplier_sortZ_A() {
		wait.until(ExpectedConditions.visibilityOf(Supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(Supplier_Name_Z_to_A)).click();
		System.out.println(">> User clicked Z-A updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	private WebElement Supplier_Name_decending;

	public void Supplier_DecendingDate() {
		wait.until(ExpectedConditions.visibilityOf(Supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(Supplier_Name_decending)).click();
		System.out.println(">> User clicked decending updated in sort");
	}

	@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
	private WebElement supplier_kebabmenu_click;
	
	public void Supplier_kebabmenu() throws Exception {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(supplier_kebabmenu_click)).click();
	}
	@FindBy(xpath = "(//a[@role='button'][normalize-space()='Edit'])[1]")
	private WebElement click_edit_Supplier;

	public void selects_edit_Supplier() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(click_edit_Supplier)).click();
	}
	@FindBy(xpath = "(//h5[normalize-space()='Edit Supplier'])[1]")
	private WebElement editpage_pading;
	
	@FindBy(id = "Update Supplier")
	private WebElement click_updatebuttn;

	public void Updated_Supplier() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(editpage_pading));
		String edited_contctpersn = prop.getProperty("edited_contctpersn");
		wait.until(ExpectedConditions.visibilityOf(contact_person)).sendKeys(edited_contctpersn);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(click_updatebuttn)).click();
	}
	@FindBy(xpath = "(//a[normalize-space()='Delete'])[1]")
	private WebElement click_delete_Supplier;

	public void selects_delete_Supplier() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(click_delete_Supplier)).click();
	}
	@FindBy(xpath = "//a[normalize-space()='View']")
	private WebElement click_view_Supplier;

	public void selects_view_Supplier() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(click_view_Supplier)).click();
	}
	@FindBy(xpath = "//h5[normalize-space()='View Supplier']")
	private WebElement display_supplierviewpage;

	public void Supplier_viewpagedisplay() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(display_supplierviewpage)).isDisplayed();
		AssertJUnit.assertTrue(display_supplierviewpage.isDisplayed());
		LOGGER.info("Supplier view page displayed");
	}
	
	@FindBy(xpath = "//h4[normalize-space()='Are you sure, you want to delete this supplier?']")
	private WebElement delete_confirmpopup;
	
	@FindBy(xpath = "//h6[normalize-space()='Yes, delete this supplier.']")
	private WebElement delete_Supplier_confirmbuttn;
	
	public void Supplier_delete_confirm() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(delete_confirmpopup));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(delete_Supplier_confirmbuttn)).click();
	}
}
