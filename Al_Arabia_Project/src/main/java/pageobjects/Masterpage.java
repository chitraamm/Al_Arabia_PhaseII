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
	private static final String Automationtest = null;
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
	private static String generateUniqueboardName(String baseboardName) {
	    Random rand = new Random();
	    int uniqueNumber = rand.nextInt(10000);  // Generates a random number between 0 and 9999
	    return baseboardName + "_" + uniqueNumber;
	}
	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	private WebElement dashboardpage;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a[6]/span")
	private WebElement click_master_module;

	public void Master_click() throws Exception {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(dashboardpage)).isDisplayed();
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
		String suppliername = generateUniqueboardNumber(prop.getProperty("suppliername"));
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
		System.out.println(">> User got searched Supplier list: " + SupplierSearched.getText());
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
	private WebElement sortingName_Z_to_A;

	public void recent_sortZ_A() {
		wait.until(ExpectedConditions.visibilityOf(Supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(sortingName_Z_to_A)).click();
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
		wait.until(ExpectedConditions.visibilityOf(kebabmenu_click)).isDisplayed();
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
	//<------------------------------------Stock---------------------------------------->
	@FindBy(xpath = "//span[normalize-space()='Stock']")
	private WebElement click_Stock;

	public void Stock_click() throws Exception {
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(click_master_module)).click();
		wait.until(ExpectedConditions.visibilityOf(click_Stock)).click();
	}
	@FindBy(xpath = "//h5[contains(@class,'mb-0')]")
	private WebElement StockCount;

	public void allStockCount() {
		wait.until(ExpectedConditions.visibilityOf(StockCount)).isDisplayed();
		AssertJUnit.assertTrue(StockCount.isDisplayed());
		LOGGER.info(">> The Stock page got displayed");
	}
	
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='New Stock'])[1]")
	private WebElement click_new_Stockbutton;

	public void New_Stock_button_click() throws Exception {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(click_new_Stockbutton)).click();
	}
	@FindBy(xpath = "//h5[normalize-space()='New Stock']")
	private WebElement New_Stock_page_padding;
	
	@FindBy(id = "stock_code")
	private WebElement Stock_Code;
	
	@FindBy(xpath = "//div[@class='select__input-container css-19bb58m']")
	private WebElement ID_supplier;
	
	@FindBy(id = "material_name")
	private WebElement Material_Name;
	
	@FindBy(id = "supplier_part_no")
	private WebElement Supplier_Name;
	
	@FindBy(xpath = "//input[@id='available_qty_in_store']")
	private WebElement Available_quantity_in_store;
	
	@FindBy(id = "qty_used_on_site")
	private WebElement Quantity_Used_on_site;
	
	@FindBy(id = "minimum_quantity")
	private WebElement Minimum_Quantity;
	
	@FindBy(id = "maximum_quantity")
	private WebElement Maximum_Quantity;
	
	@FindBy(id = "react-select-4-placeholder")
	private WebElement Lead_Time_To_Order;
	
	@FindBy(id = "formikDateField_warranty_period")
	private WebElement dateof_warranty;
	
	@FindBy(xpath = "//span[normalize-space()='12']")
	private WebElement dateselect_warrantyperiod;
	
	@FindBy(xpath = "//textarea[@id='part_description']")
	private WebElement descriptionstocks;

	public void Enter_Mandatory_fields_Stock () throws Exception {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(New_Stock_page_padding)).isDisplayed();
		String Stockcode = generateUniqueboardNumber(prop.getProperty("Stockcode"));
		wait.until(ExpectedConditions.visibilityOf(Stock_Code)).sendKeys(Stockcode);
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(Stock_Code)).isDisplayed();
		Thread.sleep(3000);
		act.moveToElement(ID_supplier).click().sendKeys(""+ Keys.ARROW_DOWN + Keys.ENTER).perform();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(ID_supplier)).isDisplayed();
		String Materialname = prop.getProperty("Materialname");
		wait.until(ExpectedConditions.visibilityOf(Material_Name)).sendKeys(Materialname);
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(Material_Name)).isDisplayed();
		String SupplierName = prop.getProperty("SupplierName");
		wait.until(ExpectedConditions.visibilityOf(Supplier_Name)).sendKeys(SupplierName);
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOf(Supplier_Name)).isDisplayed();
		String Availablequantity = prop.getProperty("Availablequantity");
		wait.until(ExpectedConditions.visibilityOf(Available_quantity_in_store)).sendKeys(Availablequantity);
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(Available_quantity_in_store)).isDisplayed();
        String QuantityUsed = prop.getProperty("QuantityUsed");
		wait.until(ExpectedConditions.visibilityOf(Quantity_Used_on_site)).sendKeys(QuantityUsed);
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(Quantity_Used_on_site)).isDisplayed();
		String minimQty = prop.getProperty("minimQty");
		wait.until(ExpectedConditions.visibilityOf(Minimum_Quantity)).sendKeys(minimQty);
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(Quantity_Used_on_site)).isDisplayed();
		String maximQty = prop.getProperty("maximQty");
		wait.until(ExpectedConditions.visibilityOf(Maximum_Quantity)).sendKeys(maximQty);
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(Maximum_Quantity)).isDisplayed();
		act.moveToElement(Lead_Time_To_Order).click().sendKeys(""+Keys.ARROW_DOWN+Keys.ENTER+Keys.TAB).perform();
		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOf(dateof_warranty)).isDisplayed();
		String Descriptionstocks = prop.getProperty("Descriptionstocks");
		wait.until(ExpectedConditions.visibilityOf(descriptionstocks)).sendKeys(Descriptionstocks);
		
	}

	@FindBy(xpath = "//div[@data-testid='Add Stock']")
	private WebElement add_stock_button_click;
	
	public void Add_Stock() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(add_stock_button_click)).click();
	}
	@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
	private WebElement Stock_created_Success_display;

	public String Stock_created_Success_display() throws Exception {
		WebElement successMessageElement = wait
				.until(ExpectedConditions.visibilityOf(Stock_created_Success_display));
		return successMessageElement.getText().trim();
	}
	@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
	private WebElement StocksSearch;
	
	public void Stock_search_enter_text() {
		wait.until(ExpectedConditions.visibilityOf(StockSearch)).click();
		String Stock_Search = prop.getProperty("Stocknames");
		wait.until(ExpectedConditions.visibilityOf(StocksSearch)).sendKeys(Stock_Search + Keys.ENTER);
		System.out.println(">> User enter the Stock id in search field: " + Stock_Search);
	}
	@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
	private WebElement StockSearched, StockSearch;

	@FindBy(xpath = "//div[@class='container p-3 ']")
	private WebElement Stocklist;
	
	public void StockSearchedList() {
		wait.until(ExpectedConditions.visibilityOf(StockSearch));

		if (StockSearched.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User searched Stock");
		System.out.println(">> User got searched Stock list: " + StockSearched.getText());
	}

	public void Stocklist() {
	//	wait.until(ExpectedConditions.visibilityOf(StockSearch));

		if (Stocklist.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new Stock btn");
		System.out.println(">> User got sorted Stock list: " + Stocklist.getText());
	}

	@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
	private WebElement Stock_sort;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement Stock_sort_recentlyupdated;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
	private WebElement Stock_sort_recentlyadded;

	public void Stock_sort_recentlyupdated()throws Exception {
		wait.until(ExpectedConditions.visibilityOf(Stock_sort)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(Stock_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void Stock_sort_recentlyadded() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(Stock_sort)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(Stock_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently added in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
	private WebElement A_to_Z_Stock_Name;

	public void A_Z_Stock_sort() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(Stock_sort)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(A_to_Z_Stock_Name)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
	private WebElement stock_sortingName_Z_to_A;

	public void Stock_recent_sortZ_A() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(Stock_sort)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(stock_sortingName_Z_to_A)).click();
		System.out.println(">> User clicked Z-A updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	private WebElement Stock_Name_decending;

	public void Stock_DecendingDate() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(Stock_sort)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(Stock_Name_decending)).click();
		System.out.println(">> User clicked decending updated in sort");
	}

	@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
	private WebElement Stock_kebabmenu_click;
	
	public void kebabmenu_stock() throws Exception {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(Stock_kebabmenu_click)).click();
	}
	@FindBy(xpath = "//a[normalize-space()='Edit']")
	private WebElement click_edit_Stock;

	public void selects_edit_Stock() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(click_edit_Stock)).click();
	}
	@FindBy(xpath = "//h5[normalize-space()='Edit Stock']")
	private WebElement stock_editpage_pading;
	
	@FindBy(id = "Update Stock")
	private WebElement stock_click_updatebuttn;

	public void Updated_Stock() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(stock_editpage_pading));
		String edited_contctpersn = prop.getProperty("edited_contctpersn");
		wait.until(ExpectedConditions.visibilityOf(contact_person)).sendKeys(edited_contctpersn);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(stock_click_updatebuttn)).click();
	}
	@FindBy(xpath = "(//a[normalize-space()='Delete'])[1]")
	private WebElement click_delete_Stock;

	public void selects_delete_Stock() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(click_delete_Stock)).click();
	}
	@FindBy(xpath = "//a[normalize-space()='View']")
	private WebElement click_view_Stock;

	public void selects_view_Stock() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(kebabmenu_click)).isDisplayed();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(click_view_Stock)).click();
	}
	@FindBy(xpath = "//h5[normalize-space()='View Stock']")
	private WebElement display_Stockviewpage;

	public void Stock_viewpagedisplay() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(display_Stockviewpage)).isDisplayed();
		AssertJUnit.assertTrue(display_Stockviewpage.isDisplayed());
		LOGGER.info("Stock view page displayed");
	}


//<-----------------------------------------TicketTitle---------------------------------------------->

@FindBy(xpath = "//span[normalize-space()='Ticket Title']")
private WebElement click_TicketTile;

public void TicketTitle_click() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(click_TicketTile)).click();
}
@FindBy(xpath = "//h5[normalize-space()='Ticket Title(89)']")
private WebElement TicketTitleCount;

public void allTicketTitleCount() {
	wait.until(ExpectedConditions.visibilityOf(TicketTitleCount)).isDisplayed();
	AssertJUnit.assertTrue(TicketTitleCount.isDisplayed());
	LOGGER.info(">> The TicketTitle page got displayed");
}

@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='New Ticket Title'])[1]")
private WebElement click_new_TTbutton;

public void New_TicketTitle_button_click() throws Exception {
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOf(click_new_TTbutton)).click();
}
@FindBy(id = "title")
private WebElement enter_TicketTitle;

@FindBy(xpath = "//h6[normalize-space()='Add Ticket Title']")
private WebElement click_addTicketTitle;

public void Add_TicketTitle() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(enter_TicketTitle));
	String TicketTitlename = prop.getProperty("TicketTitlename");
	wait.until(ExpectedConditions.visibilityOf(enter_TicketTitle)).sendKeys(TicketTitlename);
	Thread.sleep(2000);
	act.moveToElement(click_addTicketTitle).click().perform();
}
@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
private WebElement TicketTitle_created_Success_display;

public String TicketTitle_created_Success_display() throws Exception {
	WebElement successMessageElement = wait
			.until(ExpectedConditions.visibilityOf(TicketTitle_created_Success_display));
	return successMessageElement.getText().trim();
}
@FindBy(xpath = "//div[@class='container p-3 ']")
private WebElement TicketTitlelist;

@FindBy(id = "doc_searchQueryInput")
private WebElement TicketTitle_search;

public void TicketTitle_search_enter_text() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(TicketTitle_search)).click();
	String TicketTitleSearch = prop.getProperty("TicketTitleSearch");
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(TicketTitle_search)).sendKeys(""+TicketTitleSearch + Keys.SHIFT);
	wait.until(ExpectedConditions.visibilityOf(TicketTitle_search)).sendKeys(""+Keys.ENTER);
	System.out.println(">> User enter the TicketTitle id in search field: " + TicketTitle_search);
}
@FindBy(id = "doc_searchQueryInput")
private WebElement TicketTitleSearched, TicketTitleSearch;

public void TicketTitleSearchedList() {
	wait.until(ExpectedConditions.visibilityOf(TicketTitlelist));

	if (TicketTitleSearched.isDisplayed()) {
		System.out.println("Element is displayed");
	} else {
		System.out.println("Element is not displayed");
	}
	LOGGER.info(">> Admin/User searched TicketTitle");
	System.out.println(">> User got searched TicketTitle list: " + TicketTitleSearched.getText());
}

public void TicketTitlelist() {
	wait.until(ExpectedConditions.visibilityOf(TicketTitlelist));

	if (TicketTitlelist.isDisplayed()) {
		System.out.println("Element is displayed");
	} else {
		System.out.println("Element is not displayed");
	}
	LOGGER.info(">> Admin/User clicked new TicketTitle btn");
	System.out.println(">> User got sorted TicketTitle list: " + TicketTitlelist.getText());
}

@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
private WebElement TicketTitle_sort;

@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
private WebElement TicketTitle_sort_recentlyupdated;

@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
private WebElement TicketTitle_sort_recentlyadded;

public void TicketTitle_sort_recentlyupdated() {
	wait.until(ExpectedConditions.visibilityOf(TicketTitle_sort)).click();
	wait.until(ExpectedConditions.visibilityOf(TicketTitle_sort_recentlyupdated)).click();
	System.out.println(">> User clicked recently updated in sort");
}

public void TicketTitle_sort_recentlyadded() {
	wait.until(ExpectedConditions.visibilityOf(TicketTitle_sort)).click();
	wait.until(ExpectedConditions.visibilityOf(TicketTitle_sort_recentlyadded)).click();
	System.out.println(">> User clicked recently added in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
private WebElement TicketTitle_Name_A_to_Z;

public void TicketTitle_sortA_Z() {
	wait.until(ExpectedConditions.visibilityOf(TicketTitle_sort)).click();
	wait.until(ExpectedConditions.visibilityOf(TicketTitle_Name_A_to_Z)).click();
	System.out.println(">> User clicked recently updated in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
private WebElement TicketTitle_Name_Z_to_A;

public void TicketTitle_sortZ_A() {
	wait.until(ExpectedConditions.visibilityOf(TicketTitle_sort)).click();
	wait.until(ExpectedConditions.visibilityOf(TicketTitle_Name_Z_to_A)).click();
	System.out.println(">> User clicked Z-A updated in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
private WebElement TicketTitle_Name_decending;

public void TicketTitle_DecendingDate() {
	wait.until(ExpectedConditions.visibilityOf(TicketTitle_sort)).click();
	wait.until(ExpectedConditions.visibilityOf(TicketTitle_Name_decending)).click();
	System.out.println(">> User clicked decending updated in sort");
}

@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
private WebElement TicketTitle_kebabmenu_click;

public void kebabmenu_TicketTitle() throws Exception {
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(TicketTitle_kebabmenu_click)).click();
}
@FindBy(xpath = "(//a[@role='button'][normalize-space()='Edit'])[1]")
private WebElement click_edit_TicketTitle;

public void selects_edit_TicketTitle() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(click_edit_TicketTitle)).click();
}
@FindBy(xpath = "//h6[normalize-space()='Edit Ticket Title']")
private WebElement click_Edit_TicketTitlebuttn;

public void Updated_TicketTitle() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(enter_TicketTitle));
	String edited_TicketTitlename = prop.getProperty("newTicketTitlename");
	wait.until(ExpectedConditions.visibilityOf(enter_TicketTitle)).sendKeys(edited_TicketTitlename);
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(click_Edit_TicketTitlebuttn)).click();
}
@FindBy(xpath = "//a[normalize-space()='Delete']")
private WebElement click_delete_TicketTitle;

public void selects_delete_TicketTitle() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(click_delete_TicketTitle)).click();
}
//<-----------------------------------------ScreenResolution---------------------------------------------->

@FindBy(xpath = "//span[normalize-space()='Screen Resolution']")
private WebElement click_ScreenResolution;

public void ScreenResolution_click() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(click_ScreenResolution)).click();
}
@FindBy(xpath = "//h5[normalize-space()='Screen Resolution(12)']")
private WebElement ScreenResolutionCount;

public void allScreenResolutionCount() {
	wait.until(ExpectedConditions.visibilityOf(ScreenResolutionCount)).isDisplayed();
	AssertJUnit.assertTrue(ScreenResolutionCount.isDisplayed());
	LOGGER.info(">> The ScreenResolution page got displayed");
}

@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='New Screen Resolution'])[1]")
private WebElement click_new_ScreenResolutionbutton;

public void New_ScreenResolution_button_click() throws Exception {
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOf(click_new_ScreenResolutionbutton)).click();
}
@FindBy(id = "title")
private WebElement enter_ScreenResolution;

@FindBy(xpath = "//h6[normalize-space()='Add Screen Resolution']")
private WebElement click_addScreenResolution;

public void Add_ScreenResolution() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(enter_ScreenResolution));
	String ScreenResolutionname = prop.getProperty("Screen_Resolutionname");
	wait.until(ExpectedConditions.visibilityOf(enter_ScreenResolution)).sendKeys(ScreenResolutionname);
	Thread.sleep(2000);
	act.moveToElement(click_addScreenResolution).click().perform();
}
@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
private WebElement ScreenResolution_created_Success_display;

public String ScreenResolution_created_Success_display() throws Exception {
	WebElement successMessageElement = wait
			.until(ExpectedConditions.visibilityOf(ScreenResolution_created_Success_display));
	return successMessageElement.getText().trim();
}
@FindBy(xpath = "//div[@class='list_members p-3 ']")
private WebElement ScreenResolutionlist;

@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
private WebElement ScreenResolution_Search;

public void ScreenResolution_search_enter_text() {
	wait.until(ExpectedConditions.visibilityOf(ScreenResolution_Search)).click();
	String ScreenResolutionSearch = prop.getProperty("ScreenResolutionSearch");
	wait.until(ExpectedConditions.visibilityOf(ScreenResolution_Search)).sendKeys(ScreenResolutionSearch + Keys.ENTER);
	System.out.println(">> User enter the ScreenResolution id in search field: " + ScreenResolution_Search);
}
@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
private WebElement ScreenResolutionSearched, ScreenResolutionSearch;

public void ScreenResolutionSearchedList() {
	wait.until(ExpectedConditions.visibilityOf(ScreenResolutionlist));

	if (ScreenResolutionSearched.isDisplayed()) {
		System.out.println("Element is displayed");
	} else {
		System.out.println("Element is not displayed");
	}
	LOGGER.info(">> Admin/User searched ScreenResolution");
	System.out.println(">> User got searched ScreenResolution list: " + ScreenResolutionSearched.getText());
}

public void ScreenResolutionlist() {
	wait.until(ExpectedConditions.visibilityOf(ScreenResolutionlist));

	if (ScreenResolutionlist.isDisplayed()) {
		System.out.println("Element is displayed");
	} else {
		System.out.println("Element is not displayed");
	}
	LOGGER.info(">> Admin/User clicked new ScreenResolution btn");
	System.out.println(">> User got sorted ScreenResolution list: " + ScreenResolutionlist.getText());
}

@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
private WebElement ScreenResolution_sort;

@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
private WebElement ScreenResolution_sort_recentlyupdated;

@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
private WebElement ScreenResolution_sort_recentlyadded;

public void ScreenResolution_sort_recentlyupdated() throws  Exception {
	wait.until(ExpectedConditions.visibilityOf(ScreenResolution_sort)).click();
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(ScreenResolution_sort_recentlyupdated)).click();
	System.out.println(">> User clicked recently updated in sort");
}

public void ScreenResolution_sort_recentlyadded() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(ScreenResolution_sort)).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(ScreenResolution_sort_recentlyadded)).click();
	System.out.println(">> User clicked recently added in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
private WebElement ScreenResolution_Name_A_to_Z;

public void ScreenResolution_sortA_Z() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(ScreenResolution_sort)).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(ScreenResolution_Name_A_to_Z)).click();
	System.out.println(">> User clicked recently updated in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
private WebElement ScreenResolution_Name_Z_to_A;

public void ScreenResolution_sortZ_A() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(ScreenResolution_sort)).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(ScreenResolution_Name_Z_to_A)).click();
	System.out.println(">> User clicked Z-A updated in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
private WebElement ScreenResolution_Name_decending;

public void ScreenResolution_DecendingDate() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(ScreenResolution_sort)).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(ScreenResolution_Name_decending)).click();
	System.out.println(">> User clicked decending updated in sort");
}

@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
private WebElement ScreenResolution_kebabmenu_click;

public void kebabmenu_ScreenResolution() throws Exception {
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(ScreenResolution_kebabmenu_click)).click();
}
@FindBy(xpath = "(//a[@role='button'][normalize-space()='Edit'])[1]")
private WebElement click_edit_ScreenResolution;

public void selects_edit_ScreenResolution() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(click_edit_ScreenResolution)).click();
}
@FindBy(xpath = "//h6[normalize-space()='Edit Screen Resolution']")
private WebElement click_Edit_ScreenResolutionbuttn;

public void Updated_ScreenResolution() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(enter_ScreenResolution));
	String edited_ScreenResolutionname = prop.getProperty("newScreenResolutionname");
	wait.until(ExpectedConditions.visibilityOf(enter_ScreenResolution)).sendKeys(edited_ScreenResolutionname);
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(click_Edit_ScreenResolutionbuttn)).click();
}
@FindBy(xpath = "//a[normalize-space()='Delete']")
private WebElement click_delete_ScreenResolution;

public void selects_delete_ScreenResolution() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(click_delete_ScreenResolution)).click();
}

//<-----------------------------------------ScreenPixel------------------------------------------------>

@FindBy(xpath = "//span[normalize-space()='Screen Pixel']")
private WebElement click_ScreenPixel;

public void ScreenPixel_click() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(click_ScreenPixel)).click();
}
@FindBy(xpath = "//h5[normalize-space()='Screen Pixel(6)']")
private WebElement ScreenPixelCount;

public void allScreenPixelCount() {
	wait.until(ExpectedConditions.visibilityOf(ScreenPixelCount)).isDisplayed();
	AssertJUnit.assertTrue(ScreenPixelCount.isDisplayed());
	LOGGER.info(">> The ScreenPixel page got displayed");
}

@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='New Screen Pixel'])[1]")
private WebElement click_new_ScreenPixelbutton;

public void New_ScreenPixel_button_click() throws Exception {
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOf(click_new_ScreenPixelbutton)).click();
}
@FindBy(id = "title")
private WebElement enter_ScreenPixel;

@FindBy(xpath = "//h6[normalize-space()='Add Screen Pixel']")
private WebElement click_addScreenPixel;

public void Add_ScreenPixel() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(enter_ScreenPixel));
	String ScreenPixelname = prop.getProperty("ScreenPixelname");
	wait.until(ExpectedConditions.visibilityOf(enter_ScreenPixel)).sendKeys(ScreenPixelname);
	Thread.sleep(2000);
	act.moveToElement(click_addScreenPixel).click().perform();
}
@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
private WebElement ScreenPixel_created_Success_display;

public String ScreenPixel_created_Success_display() throws Exception {
	WebElement successMessageElement = wait
			.until(ExpectedConditions.visibilityOf(ScreenPixel_created_Success_display));
	return successMessageElement.getText().trim();
}
@FindBy(xpath = "//div[@class='list_members p-3 ']")
private WebElement ScreenPixellist;

@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
private WebElement screenPixelSearch;

public void ScreenPixel_search_enter_text() {
	wait.until(ExpectedConditions.visibilityOf(ScreenPixellist)).click();
	String ScreenPixel_Search = prop.getProperty("ScreenPixel_Search");
	wait.until(ExpectedConditions.visibilityOf(screenPixelSearch)).sendKeys(ScreenPixel_Search + Keys.ENTER);
	System.out.println(">> User enter the ScreenPixel id in search field: " + screenPixelSearch);
}
@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
private WebElement ScreenPixelSearched, ScreenPixelSearch;

public void ScreenPixelSearchedList() {
	wait.until(ExpectedConditions.visibilityOf(ScreenPixellist));

	if (ScreenPixelSearched.isDisplayed()) {
		System.out.println("Element is displayed");
	} else {
		System.out.println("Element is not displayed");
	}
	LOGGER.info(">> Admin/User searched ScreenPixel");
	System.out.println(">> User got searched ScreenPixel list: " + ScreenPixelSearched.getText());
}

public void ScreenPixellist() {
	wait.until(ExpectedConditions.visibilityOf(ScreenPixellist));

	if (ScreenPixellist.isDisplayed()) {
		System.out.println("Element is displayed");
	} else {
		System.out.println("Element is not displayed");
	}
	LOGGER.info(">> Admin/User clicked new ScreenPixel btn");
	System.out.println(">> User got sorted ScreenPixel list: " + ScreenPixellist.getText());
}

@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
private WebElement ScreenPixel_sort;

@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
private WebElement ScreenPixel_sort_recentlyupdated;

@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
private WebElement ScreenPixel_sort_recentlyadded;

public void ScreenPixel_sort_recentlyupdated() {
	wait.until(ExpectedConditions.visibilityOf(ScreenPixel_sort)).click();
	wait.until(ExpectedConditions.visibilityOf(ScreenPixel_sort_recentlyupdated)).click();
	System.out.println(">> User clicked recently updated in sort");
}

public void ScreenPixel_sort_recentlyadded() {
	wait.until(ExpectedConditions.visibilityOf(ScreenPixel_sort)).click();
	wait.until(ExpectedConditions.visibilityOf(ScreenPixel_sort_recentlyadded)).click();
	System.out.println(">> User clicked recently added in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
private WebElement ScreenPixel_Name_A_to_Z;

public void ScreenPixel_sortA_Z() {
	wait.until(ExpectedConditions.visibilityOf(ScreenPixel_sort)).click();
	wait.until(ExpectedConditions.visibilityOf(ScreenPixel_Name_A_to_Z)).click();
	System.out.println(">> User clicked recently updated in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
private WebElement ScreenPixel_Name_Z_to_A;

public void ScreenPixel_sortZ_A() {
	wait.until(ExpectedConditions.visibilityOf(ScreenPixel_sort)).click();
	wait.until(ExpectedConditions.visibilityOf(ScreenPixel_Name_Z_to_A)).click();
	System.out.println(">> User clicked Z-A updated in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
private WebElement ScreenPixel_Name_decending;

public void ScreenPixel_DecendingDate() {
	wait.until(ExpectedConditions.visibilityOf(ScreenPixel_sort)).click();
	wait.until(ExpectedConditions.visibilityOf(ScreenPixel_Name_decending)).click();
	System.out.println(">> User clicked decending updated in sort");
}

@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
private WebElement ScreenPixel_kebabmenu_click;

public void kebabmenu_ScreenPixel() throws Exception {
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(ScreenPixel_kebabmenu_click)).click();
}
@FindBy(xpath = "(//a[@role='button'][normalize-space()='Edit'])[1]")
private WebElement click_edit_ScreenPixel;

public void selects_edit_ScreenPixel() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(click_edit_ScreenPixel)).click();
}
@FindBy(xpath = "//button[@id='Edit Screen Pixel']")
private WebElement click_Edit_ScreenPixelbuttn;

public void Updated_ScreenPixel() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(enter_ScreenPixel));
	String edited_ScreenPixelname = prop.getProperty("newScreenPixelname");
	wait.until(ExpectedConditions.visibilityOf(enter_ScreenPixel)).sendKeys(edited_ScreenPixelname);
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(click_Edit_ScreenPixelbuttn)).click();
}
@FindBy(xpath = "//a[normalize-space()='Delete']")
private WebElement click_delete_ScreenPixel;

public void selects_delete_ScreenPixel() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(click_delete_ScreenPixel)).click();
}


//<-----------------------------------------BillBoardType------------------------------------------------>

@FindBy(xpath = "//span[normalize-space()='BillBoard Type']")
private WebElement click_BillBoardType;

public void BillBoardType_click() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(click_BillBoardType)).click();
}
@FindBy(xpath = "//h5[normalize-space()='BillBoard Type(19)']")
private WebElement BillBoardTypeCount;

public void allBillBoardTypeCount() {
	wait.until(ExpectedConditions.visibilityOf(BillBoardTypeCount)).isDisplayed();
	AssertJUnit.assertTrue(BillBoardTypeCount.isDisplayed());
	LOGGER.info(">> The BillBoardType page got displayed");
}

@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='New BillBoard Type'])[1]")
private WebElement click_new_BillBoardTypebutton;

public void New_BillBoardType_button_click() throws Exception {
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOf(click_new_BillBoardTypebutton)).click();
}
@FindBy(xpath = "//input[@id='billboard_type']")
private WebElement enter_BillBoardType;

@FindBy(xpath = "//input[@id='dry_clean']")
private WebElement drycleaning;

@FindBy(xpath = "//input[@id='wet_clean']")
private WebElement WetClean;

@FindBy(xpath = "//h6[normalize-space()='Add BillBoard Type']")
private WebElement click_addBillBoardType;

public void Add_BillBoardType() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(enter_BillBoardType));
	String BillBoardTypename = prop.getProperty("BillBoardTypename");
	wait.until(ExpectedConditions.visibilityOf(enter_BillBoardType)).sendKeys(BillBoardTypename);
	Thread.sleep(2000);
	
	wait.until(ExpectedConditions.visibilityOf(enter_BillBoardType)).isDisplayed();
	String Drycleaning = prop.getProperty("Drycleaning");
	wait.until(ExpectedConditions.visibilityOf(drycleaning)).sendKeys(Drycleaning);
	Thread.sleep(2000);

	wait.until(ExpectedConditions.visibilityOf(drycleaning)).isDisplayed();
	String Wetcleaning = prop.getProperty("Wetcleaning");
	wait.until(ExpectedConditions.visibilityOf(WetClean)).sendKeys(Wetcleaning);
	Thread.sleep(2000);
	act.moveToElement(click_addBillBoardType).click().perform();
}
@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
private WebElement BillBoardType_created_Success_display;

public String BillBoardType_created_Success_display() throws Exception {
	WebElement successMessageElement = wait
			.until(ExpectedConditions.visibilityOf(BillBoardType_created_Success_display));
	return successMessageElement.getText().trim();
}
@FindBy(xpath = "//div[@class='list_members p-3 ']")
private WebElement BillBoardTypelist;

@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
private WebElement BillBoardTypesearch;

public void BillBoardType_search_enter_text() {
	wait.until(ExpectedConditions.visibilityOf(BillBoardTypelist)).click();
	String BillBoardType_Search = prop.getProperty("BillBoardtypename");
	wait.until(ExpectedConditions.visibilityOf(BillBoardTypesearch)).sendKeys(BillBoardType_Search + Keys.ENTER);
	System.out.println(">> User enter the BillBoardType id in search field: " + BillBoardTypesearch);
}
@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
private WebElement BillBoardTypeSearched, BillBoardTypeSearch;

public void BillBoardTypeSearchedList() {
	wait.until(ExpectedConditions.visibilityOf(BillBoardTypelist));

	if (BillBoardTypeSearched.isDisplayed()) {
		System.out.println("Element is displayed");
	} else {
		System.out.println("Element is not displayed");
	}
	LOGGER.info(">> Admin/User searched BillBoardType");
	System.out.println(">> User got searched BillBoardType list: " + BillBoardTypeSearched.getText());
}

public void BillBoardTypelist() {
	wait.until(ExpectedConditions.visibilityOf(BillBoardTypelist));

	if (BillBoardTypelist.isDisplayed()) {
		System.out.println("Element is displayed");
	} else {
		System.out.println("Element is not displayed");
	}
	LOGGER.info(">> Admin/User clicked new BillBoardType btn");
	System.out.println(">> User got sorted BillBoardType list: " + BillBoardTypelist.getText());
}

@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
private WebElement BillBoardType_sort;

@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
private WebElement BillBoardType_sort_recentlyupdated;

@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
private WebElement BillBoardType_sort_recentlyadded;

public void BillBoardType_sort_recentlyupdated() throws Exception{
	wait.until(ExpectedConditions.visibilityOf(BillBoardType_sort)).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(BillBoardType_sort_recentlyupdated)).click();
	System.out.println(">> User clicked recently updated in sort");
}

public void BillBoardType_sort_recentlyadded()throws Exception {
	wait.until(ExpectedConditions.visibilityOf(BillBoardType_sort)).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(BillBoardType_sort_recentlyadded)).click();
	System.out.println(">> User clicked recently added in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
private WebElement BillBoardType_Name_A_to_Z;

public void BillBoardType_sortA_Z() throws Exception{
	wait.until(ExpectedConditions.visibilityOf(BillBoardType_sort)).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(BillBoardType_Name_A_to_Z)).click();
	System.out.println(">> User clicked recently updated in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
private WebElement BillBoardType_Name_Z_to_A;

public void BillBoardType_sortZ_A()throws Exception {
	wait.until(ExpectedConditions.visibilityOf(BillBoardType_sort)).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(BillBoardType_Name_Z_to_A)).click();
	System.out.println(">> User clicked Z-A updated in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
private WebElement BillBoardType_Name_decending;

public void BillBoardType_DecendingDate()throws Exception {
	wait.until(ExpectedConditions.visibilityOf(BillBoardType_sort)).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(BillBoardType_Name_decending)).click();
	System.out.println(">> User clicked decending updated in sort");
}

@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
private WebElement BillBoardType_kebabmenu_click;

public void kebabmenu_BillBoardType() throws Exception {
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(BillBoardType_kebabmenu_click)).click();
}
@FindBy(xpath = "(//a[@role='button'][normalize-space()='Edit'])[1]")
private WebElement click_edit_BillBoardType;

public void selects_edit_BillBoardType() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(click_edit_BillBoardType)).click();
}
@FindBy(xpath = "//h6[normalize-space()='Edit BillBoard Type']")
private WebElement click_Edit_BillBoardTypebuttn;

public void Updated_BillBoardType() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(enter_BillBoardType));
	String edited_BillBoardTypename = prop.getProperty("newBillBoardTypename");
	wait.until(ExpectedConditions.visibilityOf(enter_BillBoardType)).sendKeys(edited_BillBoardTypename);
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(click_Edit_BillBoardTypebuttn)).click();
}
@FindBy(xpath = "//a[normalize-space()='Delete']")
private WebElement click_delete_BillBoardType;

public void selects_delete_BillBoardType() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(click_delete_BillBoardType)).click();
}

//<-----------------------------------------BOMUnit------------------------------------------------>

@FindBy(xpath = "//span[normalize-space()='BOM Unit']")
private WebElement click_BOMUnit;

public void BOMUnit_click() throws Exception {
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(click_BOMUnit)).click();
}
@FindBy(xpath = "//h5[normalize-space()='BOM Unit(3)']")
private WebElement BOMUnitCount;

public void allBOMUnitCount() {
	wait.until(ExpectedConditions.visibilityOf(BOMUnitCount)).isDisplayed();
	AssertJUnit.assertTrue(BOMUnitCount.isDisplayed());
	LOGGER.info(">> The BOMUnit page got displayed");
}

@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='New BOM Unit'])[1]")
private WebElement click_new_BOMUnitbutton;

public void New_BOMUnit_button_click() throws Exception {
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOf(click_new_BOMUnitbutton)).click();
}
@FindBy(xpath = "//input[@id='title']")
private WebElement enter_BOMUnit;

@FindBy(xpath = "//h6[normalize-space()='Add BOM Unit']")
private WebElement click_addBOMUnit;

public void Add_BOMUnit() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(enter_BOMUnit));
	String BOMUnitname = generateUniqueboardName(prop.getProperty("BOMUnitname"));
	wait.until(ExpectedConditions.visibilityOf(enter_BOMUnit)).sendKeys(BOMUnitname);
	Thread.sleep(2000);
	act.moveToElement(click_addBOMUnit).click().perform();
}
@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
private WebElement BOMUnit_created_Success_display;

public String BOMUnit_created_Success_display() throws Exception {
	WebElement successMessageElement = wait
			.until(ExpectedConditions.visibilityOf(BOMUnit_created_Success_display));
	return successMessageElement.getText().trim();
}
@FindBy(xpath = "//div[@class='list_members p-3 ']")
private WebElement BOMUnitlist;

@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
private WebElement BOMUnitsearch;

public void BOMUnit_search_enter_text() {
	wait.until(ExpectedConditions.visibilityOf(BOMUnitlist)).click();
	String BOMUnitname = prop.getProperty("BOMUnitname");
	wait.until(ExpectedConditions.visibilityOf(BOMUnitsearch)).sendKeys(BOMUnitname + Keys.ENTER);
	System.out.println(">> User enter the BOMUnit id in search field: " + BOMUnitsearch);
}
@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
private WebElement BOMUnitSearched, BOMUnitSearch;

public void BOMUnitSearchedList() {
	wait.until(ExpectedConditions.visibilityOf(BOMUnitlist));

	if (BOMUnitSearched.isDisplayed()) {
		System.out.println("Element is displayed");
	} else {
		System.out.println("Element is not displayed");
	}
	LOGGER.info(">> Admin/User searched BOMUnit");
	System.out.println(">> User got searched BOMUnit list: " + BOMUnitSearch.getText());
}

public void BOMUnitlist() {
	wait.until(ExpectedConditions.visibilityOf(BOMUnitlist));

	if (BOMUnitlist.isDisplayed()) {
		System.out.println("Element is displayed");
	} else {
		System.out.println("Element is not displayed");
	}
	LOGGER.info(">> Admin/User clicked new BOMUnit btn");
	System.out.println(">> User got sorted BOMUnit list: " + BOMUnitlist.getText());
}

@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
private WebElement BOMUnit_sort;

@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
private WebElement BOMUnit_sort_recentlyupdated;

@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
private WebElement BOMUnit_sort_recentlyadded;

public void BOMUnit_sort_recentlyupdated() throws Exception{
	wait.until(ExpectedConditions.visibilityOf(BOMUnit_sort)).click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOf(BOMUnit_sort_recentlyupdated)).click();
	System.out.println(">> User clicked recently updated in sort");
}

public void BOMUnit_sort_recentlyadded()throws Exception {
	wait.until(ExpectedConditions.visibilityOf(BOMUnit_sort)).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(BOMUnit_sort_recentlyadded)).click();
	System.out.println(">> User clicked recently added in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
private WebElement BOMUnit_Name_A_to_Z;

public void BOMUnit_sortA_Z()throws Exception {
	wait.until(ExpectedConditions.visibilityOf(BOMUnit_sort)).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(BOMUnit_Name_A_to_Z)).click();
	System.out.println(">> User clicked recently updated in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
private WebElement BOMUnit_Name_Z_to_A;

public void BOMUnit_sortZ_A()throws Exception {
	wait.until(ExpectedConditions.visibilityOf(BOMUnit_sort)).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(BOMUnit_Name_Z_to_A)).click();
	System.out.println(">> User clicked Z-A updated in sort");
}

@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
private WebElement BOMUnit_Name_decending;

public void BOMUnit_DecendingDate()throws Exception {
	wait.until(ExpectedConditions.visibilityOf(BOMUnit_sort)).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(BOMUnit_Name_decending)).click();
	System.out.println(">> User clicked decending updated in sort");
}

@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
private WebElement BOMUnit_kebabmenu_click;

public void kebabmenu_BOMUnit() throws Exception {
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(BOMUnit_kebabmenu_click)).click();
}
@FindBy(xpath = "(//a[@role='button'][normalize-space()='Edit'])[1]")
private WebElement click_edit_BOMUnit;

public void selects_edit_BOMUnit() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(click_edit_BOMUnit)).click();
}
@FindBy(xpath = "//button[@id='Edit BOM Unit']")
private WebElement click_Edit_BOMUnitbuttn;

public void Updated_BOMUnit() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(enter_BOMUnit));
	String edited_BOMUnitname = generateUniqueboardNumber(prop.getProperty("newBOMUnitname"));
	wait.until(ExpectedConditions.visibilityOf(enter_BOMUnit)).sendKeys(edited_BOMUnitname);
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(click_Edit_BOMUnitbuttn)).click();
}
@FindBy(xpath = "//a[normalize-space()='Delete']")
private WebElement click_delete_BOMUnit;

public void selects_delete_BOMUnit() throws Exception {
	wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(click_delete_BOMUnit)).click();
}

//<------------------------------------BOM---------------------------------------->

	@FindBy(xpath = "//span[normalize-space()='BOM']")
	private WebElement click_BOM;

	public void BOM_click() throws Exception {
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(click_master_module)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_BOM)).click();
	}
	@FindBy(xpath = "//h5[normalize-space()='BOM Masters(51)']")
	private WebElement BOMCount;

	public void allBOMCount() {
		wait.until(ExpectedConditions.visibilityOf(BOMCount)).isDisplayed();
		AssertJUnit.assertTrue(BOMCount.isDisplayed());
		LOGGER.info(">> The BOM page got displayed");
	}
	
	@FindBy(xpath = "(//button[@id=' New BOM Masters '])[1]")
	private WebElement click_new_BOMbutton;

	public void New_BOM_button_click() throws Exception {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(click_new_BOMbutton)).click();
	}
	@FindBy(xpath = "//h5[normalize-space()='New BOM']")
	private WebElement NewBOM_page_padding;
	
	@FindBy(id = "bom_name")
	private WebElement BOM_name;
	
	@FindBy(id = "BOM_id")
	private WebElement BOM_id;
 
	@FindBy(id = "react-select-3-input")
	private WebElement billboardtype_BOM;
	
	@FindBy(id = "board_size")
	private WebElement 	boardsize;
	
	@FindBy(id = "react-select-4-input")
	private WebElement stockcode;
	
	@FindBy(xpath = "(//input[@value='0'])[1]")	
	private WebElement QTY;
		
//	@FindBy(xpath = "(//input[@type='text'])[7]")
//	private WebElement country;
	
	@FindBy(id = "Save")
	private WebElement button_save;
//	
//	@FindBy(xpath = "(//button[@id='Add BOM'])[1]")
//	private WebElement click_addBOM_Button;
//	
	public void Enter_Mandatory_fields_BOM () throws Exception {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(NewBOM_page_padding)).isDisplayed();
		String BOMname = generateUniqueboardNumber(prop.getProperty("BOMname"));
		wait.until(ExpectedConditions.visibilityOf(BOM_name)).sendKeys(BOMname);
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(BOM_name)).isDisplayed();
		act.moveToElement(billboardtype_BOM).click().sendKeys(""+Keys.ENTER).perform();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(billboardtype_BOM)).isDisplayed();
		String Boardsize = generateUniqueboardNumber(prop.getProperty("Boardsize"));
		wait.until(ExpectedConditions.visibilityOf(boardsize)).sendKeys(Boardsize);
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(billboardtype_BOM)).isDisplayed();
		act.moveToElement(stockcode).click().sendKeys(""+Keys.ENTER).perform();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOf(stockcode)).isDisplayed();
		String number_of_qty = generateUniqueboardNumber(prop.getProperty("qty"));
		String countryname = prop.getProperty("countryname");

		wait.until(ExpectedConditions.visibilityOf(QTY)).sendKeys(number_of_qty+Keys.TAB+Keys.ARROW_DOWN+Keys.ENTER+Keys.TAB+countryname);
		//Thread.sleep(3000);
     //   act.moveToElement(button_save).click().sendKeys(""+Keys.TAB+Keys.ENTER).perform();
        
				act.moveToElement(button_save).click().perform();
//        Thread.sleep(5000);
//		wait.until(ExpectedConditions.visibilityOf(button_save)).isDisplayed();
//        act.moveToElement(click_addBOM_Button).click().perform();

	}
	@FindBy(id = "Add BOM")
	private WebElement click_addBOM_Button;
	
	public void Click_Add_BOM() throws Exception {
		//Thread.sleep(6000);
		//wait.until(ExpectedConditions.visibilityOf(button_save)).isDisplayed();
       // act.moveToElement(click_addBOM_Button).click().perform();
		wait.until(ExpectedConditions.visibilityOf(click_addBOM_Button)).click();      

	}
	@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
	private WebElement BOM_created_Success_display;

	public String BOM_created_Success_display() throws Exception {
		WebElement successMessageElement = wait
				.until(ExpectedConditions.visibilityOf(BOM_created_Success_display));
		return successMessageElement.getText().trim();
	}
	@FindBy(id = "doc_searchQueryInput")
	private WebElement BOMSearch;
	
	public void BOM_search_enter_text() {
		wait.until(ExpectedConditions.visibilityOf(BOMSearch)).click();
		String BOMnames = prop.getProperty("BOMnames");
		wait.until(ExpectedConditions.visibilityOf(BOMSearch)).sendKeys(BOMnames + Keys.ENTER);
		System.out.println(">> User enter the BOM id in search field: " + BOMSearch);
	}
	@FindBy(id = "doc_searchQueryInput")
	private WebElement BOMSearched, BOM_Search;

	@FindBy(xpath = "//table[@class='table']")
	private WebElement BOMlist;
	
	public void BOMSearchedList() {
		wait.until(ExpectedConditions.visibilityOf(BOM_Search));

		if (BOMSearched.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User searched BOM");
		System.out.println(">> User got searched BOM list: " + BOMSearched.getText());
	}

	public void BOMlist() {
	//	wait.until(ExpectedConditions.visibilityOf(BOMSearch));

		if (BOMlist.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new BOM btn");
		System.out.println(">> User got sorted BOM list: " + BOMlist.getText());
	}

	@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
	private WebElement BOM_sort;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement BOM_sort_recentlyupdated;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
	private WebElement BOM_sort_recentlyadded;

	public void BOM_sort_recentlyupdated() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(BOM_sort)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(BOM_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void BOM_sort_recentlyadded() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(BOM_sort)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(BOM_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently added in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
	private WebElement A_to_Z_BOM_Name;

	public void A_Z_BOM_sort() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(BOM_sort)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(A_to_Z_BOM_Name)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
	private WebElement BOM_sortingName_Z_to_A;

	public void BOM_recent_sortZ_A()throws Exception {
		wait.until(ExpectedConditions.visibilityOf(BOM_sort)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(BOM_sortingName_Z_to_A)).click();
		System.out.println(">> User clicked Z-A updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	private WebElement BOM_Name_decending;

	public void BOM_DecendingDate() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(BOM_sort)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(BOM_Name_decending)).click();
		System.out.println(">> User clicked decending updated in sort");
	}

	@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
	private WebElement BOM_kebabmenu_click;
	
	public void BOM_kebabmenu() throws Exception {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(BOM_kebabmenu_click)).click();
	}
	@FindBy(xpath = "(//a[@role='button'][normalize-space()='Edit'])[1]")
	private WebElement click_edit_BOM;

	public void selects_edit_BOM() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(click_edit_BOM)).click();
	}
	@FindBy(xpath = "(//h5[normalize-space()='Edit BOM'])[1]")
	private WebElement BOM_editpage_pading;
	
	@FindBy(id = "bom_name")
	private WebElement Edited_BOM;
	
	@FindBy(xpath = "//h6[normalize-space()='Edit BOM']")
	private WebElement click_BOM_updatebuttn;
	
	public void Updated_BOM() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(BOM_editpage_pading));
		String edited_BOM = generateUniqueboardNumber(prop.getProperty("edited_BOM"));
		wait.until(ExpectedConditions.visibilityOf(Edited_BOM)).sendKeys(edited_BOM);
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(Edited_BOM)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_BOM_updatebuttn)).click();

		//act.moveToElement(click_BOM_updatebuttn).click().perform();

	}
	@FindBy(xpath = "(//a[normalize-space()='Delete'])[1]")
	private WebElement click_delete_BOM;

	public void selects_delete_BOM() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(kebabmenu_click));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(click_delete_BOM)).click();
	}
	@FindBy(xpath = "//a[normalize-space()='View']")
	private WebElement click_view_BOM;

	public void selects_view_BOM() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(kebabmenu_click)).isDisplayed();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(click_view_BOM)).click();
	}
	@FindBy(xpath = "//h5[normalize-space()='masters.View BOM']")
	private WebElement display_BOMviewpage;

	public void BOM_viewpagedisplay() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(display_BOMviewpage)).isDisplayed();
		AssertJUnit.assertTrue(display_BOMviewpage.isDisplayed());
		LOGGER.info("BOM view page displayed");
	}
	
	@FindBy(xpath = "//h4[normalize-space()='Are you sure, you want to delete this BOM?']")
	private WebElement delete_confirmpopup_BOM;
	
	@FindBy(xpath = "//h6[normalize-space()='Yes, delete this BOM.']")
	private WebElement delete_BOM_confirmbuttn;
	
	public void BOM_delete_confirm() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(delete_confirmpopup_BOM));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(delete_BOM_confirmbuttn)).click();
	}

}