package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
//import java.util.Random;

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

//import net.bytebuddy.asm.Advice.Enter;
import resources.Base;

public class Inventorypage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Actions act;
	private Logger LOGGER = LogManager.getLogger(Inventorypage.class);


	public Inventorypage(WebDriver driver) throws Exception { 
		this.driver = driver;
		prop = new Properties();
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		initializeWait();
		//this.signinpage = new Signinpage(driver);
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
	@FindBy(xpath = "//h6[normalize-space()='Dashboard'][position()=1]")
	private WebElement dashboardText;
	@FindBy(xpath = "//span[normalize-space()='Inventory']")
	private WebElement inventoryClick;

	@FindBy(xpath = "//span[normalize-space()='Inventory']")
	private WebElement inventory_menu;

	public void Inventory_click() {
		wait.until(ExpectedConditions.elementToBeClickable(dashboardText)).isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(inventoryClick)).click();
		//wait.until(ExpectedConditions.visibilityOf(inventory_menu)).isDisplayed();
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
	
	@FindBy(id = "react-select-4-input")
	private WebElement stock_code;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/form/div[3]/div[2]/div/table/tbody/tr/td[4]/form/div/div/input")
	private WebElement quantity;
	
	@FindBy(id = "Save")
	private WebElement save_stock;
	
	public void Mandatory_fields_enter_new_purchase() throws Exception {
		
		String suppliername = prop.getProperty("suppliername");
		wait.until(ExpectedConditions.visibilityOf(supplier_name)).sendKeys(suppliername);
		Thread.sleep(2000);
		act.moveToElement(supplier_name).click().sendKeys(""+Keys.ENTER+Keys.ARROW_RIGHT).perform();
		
		
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
		
		wait.until(ExpectedConditions.visibilityOf(stock_code));
		act.moveToElement(stock_code).click().sendKeys(""+Keys.ENTER).perform();
		
		wait.until(ExpectedConditions.visibilityOf(stock_code));
		String QTY =prop.getProperty("QTY");
		Thread.sleep(2000);
        act.moveToElement(quantity).click().sendKeys(""+(QTY)).perform();
        
        act.moveToElement(save_stock).click().perform();
	}
	@FindBy(id = "Add Purchase")
	private WebElement add_purchase_button;
	
	public void Add_purchase_button() {
		wait.until(ExpectedConditions.visibilityOf(add_purchase_button)).click();
	}
	@FindBy(xpath = "//div[contains(@class, 'toastpop') and contains(@class, 'position-relative')]")
	private WebElement inventory_created_Success_display;

	public String inventory_create_Success_display() throws Exception {
		WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(inventory_created_Success_display));
		return successMessageElement.getText().trim();
	}
	
	@FindBy(id = "doc_searchQueryInput")
	private WebElement PurchasesSearch;
	
	public void Purchases_search_enter_text() {
		wait.until(ExpectedConditions.visibilityOf(PurchasesSearch)).click();
		String Purchases_Search = prop.getProperty("Invoiceid");
		wait.until(ExpectedConditions.visibilityOf(PurchasesSearch)).sendKeys(Purchases_Search + Keys.ENTER);
		System.out.println(">> User enter the Purchase id in search field: " + Purchases_Search);
	}
	@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
	private WebElement PurchasesSearched, purchasesSearch;

	public void PurchasesSearchedList() {
		wait.until(ExpectedConditions.visibilityOf(purchasesSearch));

		if (PurchasesSearched.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User searched purchases");
		System.out.println(">> User got searched purchases list: " + PurchasesSearched.getText());
	}

	public void Purchaseslist() {
		wait.until(ExpectedConditions.visibilityOf(purchasesSearch));

		if (purchasesSearch.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new purchase btn");
		System.out.println(">> User got sorted purchase list: " + purchasesSearch.getText());
	}

	@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
	private WebElement purchase_sort;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement purchases_sort_recentlyupdated;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
	private WebElement purchases_sort_recentlyadded;

	public void Purchases_sort_recentlyupdated() {
		wait.until(ExpectedConditions.visibilityOf(purchase_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(purchases_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void Purchases_sort_recentlyadded() {
		wait.until(ExpectedConditions.visibilityOf(purchase_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(purchases_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently added in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
	private WebElement purchase_Name_A_to_Z;

	public void Purchases_sortA_Z() {
		wait.until(ExpectedConditions.visibilityOf(purchase_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(purchase_Name_A_to_Z)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
	private WebElement purchase_Name_Z_to_A;

	public void Purchases_sortZ_A() {
		wait.until(ExpectedConditions.visibilityOf(purchase_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(purchase_Name_Z_to_A)).click();
		System.out.println(">> User clicked Z-A updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	private WebElement purchase_Name_decending;

	public void Purchases_DecendingDate() {
		wait.until(ExpectedConditions.visibilityOf(purchase_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(purchase_Name_decending)).click();
		System.out.println(">> User clicked decending updated in sort");
	}
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='Download'])[1]")
	private WebElement download_buttn_inventorypage;

	public void Download_button_inventorypage() {
		act.moveToElement(download_buttn_inventorypage).click().perform();
		System.out.println(">> User clicked Download button");
	}

	@FindBy(xpath = "//div[contains(text(),'Download')]")
	private WebElement purchases_Download_popup_display;

	public void Purchases_Download_popup_display() {
		wait.until(ExpectedConditions.visibilityOf(purchases_Download_popup_display)).isDisplayed();
		AssertJUnit.assertTrue(purchases_Download_popup_display.isDisplayed());
		LOGGER.info(">> The Download Popup got displayed");
	}

	@FindBy(xpath = "//div[normalize-space()='As Excel']")
	private WebElement purchases_Download_excel;

	public void Purchases_Download_Excel() {
		wait.until(ExpectedConditions.visibilityOf(purchases_Download_excel)).click();
	}

	@FindBy(xpath = "//div[normalize-space()='As PDF']")
	private WebElement purchases_Download_pdf;

	public void Purchases_Download_PDF() {
		wait.until(ExpectedConditions.visibilityOf(purchases_Download_pdf)).click();
	}

	@FindBy(xpath = "//span[@class='cursor-pointer']//*[name()='svg']")
	private WebElement purchase_Download_popupclose;

	public void Purchases_Download_popup_close() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(purchase_Download_popupclose)).click();
	}

	public void Download_popupclosd_displayed_Purchases() {
		wait.until(ExpectedConditions.visibilityOf(purchaseCount)).isDisplayed();
		AssertJUnit.assertTrue(purchaseCount.isDisplayed());
		LOGGER.info(">> The Download Popup get closed and listed Purchases");
	}
	@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
	private WebElement click_Purchases_Edit;
	@FindBy(xpath = "//a[normalize-space()='Edit']")
	private WebElement click_Edit;
	public void Click_Purchases_Edit()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(purchaseCount)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_Purchases_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(click_Edit)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[4]/div[1]/div/input")
	private WebElement edit_projectname;
	public void Edit_projectname()throws Exception{
		String projectname = prop.getProperty("editedprojectname");
		wait.until(ExpectedConditions.visibilityOf(edit_projectname)).sendKeys(projectname);
	}
	@FindBy(id = "Update Purchase")
	private WebElement updatebutton_click;
	public void Updatebutton_click()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(updatebutton_click)).isDisplayed();
		act.moveToElement(updatebutton_click).click().perform();
	}
	@FindBy(xpath = "//a[normalize-space()='View']")
	private WebElement click_view;
	public void Viewclick_option()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(purchaseCount)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_Purchases_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(click_view)).click();
	}
	@FindBy(xpath = "//h5[normalize-space()='View Purchase']")
	private WebElement purchaseView_display;
	public void PurchaseView_display()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(purchaseView_display)).isDisplayed();
		AssertJUnit.assertTrue(purchaseView_display.isDisplayed());
		//wait.until(ExpectedConditions.visibilityOf(click_view)).click();
	}
	@FindBy(xpath = "//a[normalize-space()='Delete']")
	private WebElement click_delete;
	public void Deleteclick_option()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(purchaseCount)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_Purchases_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(click_delete)).click();
	}
	@FindBy(xpath = "//h4[@class=' fw-semibold text-center text-black']")
	private WebElement popup_delete;
	@FindBy(xpath = "//h6[normalize-space()='Yes, delete material received from supplier.']")
	private WebElement confirm_delete;
	public void Confirmed_Deleteclick_option()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(popup_delete)).isDisplayed();
		act.moveToElement(confirm_delete).click().perform();
		//wait.until(ExpectedConditions.visibilityOf(click_delete)).click();
	}
	@FindBy(xpath = "//div[normalize-space()='2']")
	private WebElement click_second_page;
	public void Second_page() throws Exception {
		act.scrollToElement(click_second_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_second_page)).click();
	}
	@FindBy(xpath = "//div[contains(text(),'Showing')]")
	private WebElement second_page_display;
	public void Second_page_Display() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(second_page_display));
		AssertJUnit.assertTrue(second_page_display.isDisplayed());
	}
	@FindBy(xpath = "(//div[contains(@class,'round-effect')][contains(text(),'›')])[1]")
	private WebElement click_next_page;
	public void next_page() throws Exception {
		act.scrollToElement(click_next_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_next_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[1]")
	private WebElement click_previous_page;
	public void Previous_page() throws Exception {
		act.scrollToElement(click_previous_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_previous_page)).click();
	}
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[5]")
	private WebElement click_last_page;
	public void last_page() throws Exception {
		act.scrollToElement(click_last_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_last_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[1]")
	private WebElement click_first_page;
	public void First_page() throws Exception {
		act.scrollToElement(click_first_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_first_page)).click();
	}
	@FindBy(xpath = "(//img[@class='mx-3 pointer'])[1]")
	private WebElement click_start_conversation;

	public void Start_conversation() throws Exception {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(purchaseCount)).isDisplayed();
		act.moveToElement(click_start_conversation).click().perform();
	}
	@FindBy(xpath = "//span[@class='edit_link_routes active']")
	private WebElement chat_page_display;

	public void Chat_page_Displayed() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(chat_page_display));
		AssertJUnit.assertTrue(chat_page_display.isDisplayed());
		LOGGER.info("Chat page displayed");
	}
	
	//<------------------------Material Request---------------------------------------------------->|
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/ul/li[2]/a/span")
	private WebElement material_request;
	
	public void Material_request_page() throws Exception{
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(inventory_menu)).isDisplayed();
		act.moveToElement(material_request).click().perform();
	}
	@FindBy(xpath = "//h5[normalize-space()='All Request(44)']")
	private WebElement material_request_display;
	public void Material_request_page_Displayed() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(material_request_display)).isDisplayed();
		AssertJUnit.assertTrue(material_request_display.isDisplayed());
	}

	@FindBy(id = "doc_searchQueryInput")
	private WebElement materialsearch;
	
	public void Material_search_enter_text() {
		wait.until(ExpectedConditions.visibilityOf(materialsearch)).click();
		String Material_Search = prop.getProperty("Materialid");
		wait.until(ExpectedConditions.visibilityOf(materialsearch)).sendKeys(Material_Search + Keys.ENTER);
		System.out.println(">> User enter the Purchase id in search field: " + Material_Search);
	}
	@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
	private WebElement MaterialSearched, materialSearchlist;

	public void MaterialSearchedList() {
		wait.until(ExpectedConditions.visibilityOf(materialsearch));

		if (MaterialSearched.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User searched purchases");
		System.out.println(">> User got searched Material list: " + MaterialSearched.getText());
	}

	public void Material_list() {
		wait.until(ExpectedConditions.visibilityOf(purchasesSearch));

		if (materialSearchlist.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new purchase btn");
		System.out.println(">> User got sorted Material list: " + materialSearchlist.getText());
	}

	@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
	private WebElement material_sort;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement material_sort_recentlyupdated;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
	private WebElement material_sort_recentlyadded;

	public void Material_sort_recentlyupdated() {
		wait.until(ExpectedConditions.visibilityOf(material_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(material_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void Material_sort_recentlyadded() {
		wait.until(ExpectedConditions.visibilityOf(material_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(material_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently added in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
	private WebElement material_Name_A_to_Z;

	public void Material_sortA_Z() {
		wait.until(ExpectedConditions.visibilityOf(material_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(material_Name_A_to_Z)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
	private WebElement material_Name_Z_to_A;

	public void Material_sortZ_A() {
		wait.until(ExpectedConditions.visibilityOf(material_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(purchase_Name_Z_to_A)).click();
		System.out.println(">> User clicked Z-A updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	private WebElement material_Name_decending;

	public void Material_DecendingDate() {
		wait.until(ExpectedConditions.visibilityOf(material_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(material_Name_decending)).click();
		System.out.println(">> User clicked decending updated in sort");
	}
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='Download'])[1]")
	private WebElement download_buttn_materialpage;

	public void Download_button_Materialpage() {
		act.moveToElement(download_buttn_materialpage).click().perform();
		System.out.println(">> User clicked Download button");
	}

	@FindBy(xpath = "//div[contains(text(),'Download')]")
	private WebElement material_Download_popup_display;

	public void Material_Download_popup_display() {
		wait.until(ExpectedConditions.visibilityOf(material_Download_popup_display)).isDisplayed();
		AssertJUnit.assertTrue(purchases_Download_popup_display.isDisplayed());
		LOGGER.info(">> The Download Popup got displayed");
	}

	@FindBy(xpath = "//div[normalize-space()='As Excel']")
	private WebElement material_Download_excel;

	public void Material_Download_Excel() {
		wait.until(ExpectedConditions.visibilityOf(material_Download_excel)).click();
	}

	@FindBy(xpath = "//div[normalize-space()='As PDF']")
	private WebElement material_Download_pdf;

	public void Material_Download_PDF() {
		wait.until(ExpectedConditions.visibilityOf(material_Download_pdf)).click();
	}

	@FindBy(xpath = "//span[@class='cursor-pointer']//*[name()='svg']")
	private WebElement material_Download_popupclose;

	public void Material_Download_popup_close() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(material_Download_popupclose)).click();
	}

	public void Download_popupclosd_displayed_Material() {
		wait.until(ExpectedConditions.visibilityOf(material_request)).isDisplayed();
		AssertJUnit.assertTrue(material_request.isDisplayed());
		LOGGER.info(">> The Download Popup get closed and listed Material page");
	}
	@FindBy(xpath = "//h5[normalize-space()='All Request(44)']")
	private WebElement allrequestcount;
	public void Allrequestcount()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(allrequestcount)).isDisplayed();
		AssertJUnit.assertTrue(allrequestcount.isDisplayed());
	}
	@FindBy(id = "New Request")
	private WebElement newrequest_button;
	public void New_Request_Button()throws Exception{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(material_request)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(newrequest_button)).click();
	}
	@FindBy(xpath = "//h5[normalize-space()='New Request']")
	private WebElement New_Request_heading;
	@FindBy(id = "react-select-3-input")
	private WebElement requestby;
	
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='New Request'])[1]")
	private WebElement billboard_Id;
	
	@FindBy(xpath = "//input[@placeholder='Enter Location']")
	private WebElement city;
	
	@FindBy(id = "react-select-4-input")
	private WebElement request_stock_code;
	
	@FindBy(id = "Save")
	private WebElement request_save;
	
	public void Enter_Mandatory_fieldsof_New_Request()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(New_Request_heading)).isDisplayed();
		String RequestBy = prop.getProperty("requestbyuser");
		wait.until(ExpectedConditions.visibilityOf(requestby)).sendKeys(RequestBy);
		Thread.sleep(3000);
        act.moveToElement(requestby).click().sendKeys(""+Keys.ENTER).perform(); 
		
        Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(requestby)).isDisplayed();
        String Cityname = prop.getProperty("cityname");
        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOf(city)).sendKeys(Cityname+Keys.DOWN);
        
		Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(city)).isDisplayed();
		Thread.sleep(2000);
		act.moveToElement(stock_code).click().sendKeys(""+Keys.ENTER).perform();
		
		wait.until(ExpectedConditions.visibilityOf(stock_code)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(request_save)).click();
	}
	@FindBy(id = "Add Request")
	private WebElement add_request;
	public void Click_Add_Request_button()throws Exception{

		wait.until(ExpectedConditions.visibilityOf(add_request)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(add_request)).click();
	}
	
	//updatepenng
	
	

	@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
	private WebElement click_material_Edit;
	@FindBy(xpath = "//a[normalize-space()='View']")
	private WebElement material_click_view;
	public void Material_Viewclick_option()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(material_request)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_material_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(click_view)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/h5[2]")
	private WebElement materialView_display;
	public void material_View_display()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(materialView_display)).isDisplayed();
		AssertJUnit.assertTrue(materialView_display.isDisplayed());
		//wait.until(ExpectedConditions.visibilityOf(click_view)).click();
	}
	@FindBy(xpath = "//a[normalize-space()='Edit']")
	private WebElement select_materialedit;
	
	public void Click_Material_Edit() throws Exception {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(material_request)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_material_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(select_materialedit)).click();

	}
	@FindBy(xpath = "//h5[normalize-space()='Edit Request']")
	private WebElement materia_edit_padding;
	
	@FindBy(xpath = "(//div[contains(@class,'select__input-container css-19bb58m')])[2]")
	private WebElement issued_to;
	
	@FindBy(xpath = "(//input[@name='id_no'])[1]")
	private WebElement ID_Number;
	
	public void enter_material_edit_mandatory() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(materia_edit_padding)).isDisplayed();
		act.moveToElement(issued_to).click().sendKeys(""+Keys.ENTER+Keys.TAB).perform();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(issued_to)).isDisplayed();
		String IDnumber = generateUniqueboardNumber(prop.getProperty("IDnumber"));
		wait.until(ExpectedConditions.visibilityOf(ID_Number)).sendKeys(IDnumber);
	}
	
	@FindBy(xpath = "//h6[normalize-space()='Update Request']")
	private WebElement update_request;
	
	public void Update_Materialbutton_click() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(update_request)).isDisplayed();
		act.moveToElement(update_request).click().perform();
	}
	@FindBy(xpath = "//a[normalize-space()='Delete']")
	private WebElement materialclick_delete;
	public void Material_Deleteclick_option()throws Exception{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(material_request)).isDisplayed();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(click_material_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(materialclick_delete)).click();
	}
	@FindBy(xpath = "//h4[normalize-space()='Are you sure, you want to delete material request?']")
	private WebElement materialpopup_delete;
	@FindBy(xpath = "//h6[normalize-space()='Yes, delete material request.']")
	private WebElement material_confirm_delete;
	public void Material_Confirmed_Deleteclick_option()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(materialpopup_delete)).isDisplayed();
		act.moveToElement(material_confirm_delete).click().perform();
		//wait.until(ExpectedConditions.visibilityOf(click_delete)).click();
	}
	@FindBy(xpath = "//div[normalize-space()='2']")
	private WebElement material_second_page;
	public void Material_Second_page() throws Exception {
		act.scrollToElement(material_second_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_second_page)).click();
	}
	@FindBy(xpath = "//div[contains(text(),'Showing')]")
	private WebElement material_second_page_display;
	public void Second_page_Material_Display() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(material_second_page_display));
		AssertJUnit.assertTrue(material_second_page_display.isDisplayed());
	}
	@FindBy(xpath = "(//div[contains(@class,'round-effect')][contains(text(),'›')])[1]")
	private WebElement clickmaterial_next_page;
	public void Material_next_page() throws Exception {
		act.scrollToElement(clickmaterial_next_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(clickmaterial_next_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[1]")
	private WebElement clickmaterial_previous_page;
	public void Material_Previous_page() throws Exception {
		act.scrollToElement(clickmaterial_previous_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(clickmaterial_previous_page)).click();
	}
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[5]")
	private WebElement click_material_last_page;
	public void Material_last_page() throws Exception {
		act.scrollToElement(click_material_last_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_material_last_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[1]")
	private WebElement click_material_first_page;
	public void First_page_Material() throws Exception {
		act.scrollToElement(click_material_first_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_material_first_page)).click();
	}
	
	//<---------------------------------------------Material Issued-------------------------------------------------------->

	@FindBy(xpath = "//span[normalize-space()='Material Issued (To Technician)']")
	private WebElement material_issued_page;
	
	public void Material_Issued_page() throws Exception{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(inventory_menu)).isDisplayed();
		act.moveToElement(material_issued_page).click().perform();
	}
	@FindBy(xpath = "//span[normalize-space()='Material Issued (To Technician)']")
	private WebElement issued_material_display;
	public void Material_Issued_page_Displayed() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(issued_material_display)).isDisplayed();
		AssertJUnit.assertTrue(issued_material_display.isDisplayed());
	}

	@FindBy(id = "doc_searchQueryInput")
	private WebElement issued_materialsearch;
	
	public void Issued_Material_search_enter_text() {
		wait.until(ExpectedConditions.visibilityOf(issued_materialsearch)).click();
		String Issued_Material_Search = prop.getProperty("Issued_Materialid");
		wait.until(ExpectedConditions.visibilityOf(issued_materialsearch)).sendKeys(Issued_Material_Search + Keys.ENTER);
		System.out.println(">> User enter the Purchase id in search field: " + Issued_Material_Search);
	}
	@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
	private WebElement Issued_MaterialSearched, issued_materialSearchlist;

	public void Issued_MaterialSearchedList() {
		wait.until(ExpectedConditions.visibilityOf(issued_materialsearch));

		if (Issued_MaterialSearched.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User searched purchases");
		System.out.println(">> User got searched Issued_Material list: " + Issued_MaterialSearched.getText());
	}

	public void Issued_Material_list() {
		wait.until(ExpectedConditions.visibilityOf(purchasesSearch));

		if (issued_materialSearchlist.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new purchase btn");
		System.out.println(">> User got sorted Issued_Material list: " + issued_materialSearchlist.getText());
	}

	@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
	private WebElement issued_material_sort;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement issued_material_sort_recentlyupdated;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
	private WebElement issued_material_sort_recentlyadded;

	public void Issued_Material_sort_recentlyupdated() {
		wait.until(ExpectedConditions.visibilityOf(issued_material_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(issued_material_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void Issued_Material_sort_recentlyadded() {
		wait.until(ExpectedConditions.visibilityOf(issued_material_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(issued_material_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently added in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
	private WebElement issued_material_Name_A_to_Z;

	public void Issued_Material_sortA_Z() {
		wait.until(ExpectedConditions.visibilityOf(issued_material_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(issued_material_Name_A_to_Z)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
	private WebElement issued_material_Name_Z_to_A;

	public void Issued_Material_sortZ_A() {
		wait.until(ExpectedConditions.visibilityOf(issued_material_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(purchase_Name_Z_to_A)).click();
		System.out.println(">> User clicked Z-A updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	private WebElement issued_material_Name_decending;

	public void Issued_Material_DecendingDate() {
		wait.until(ExpectedConditions.visibilityOf(issued_material_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(issued_material_Name_decending)).click();
		System.out.println(">> User clicked decending updated in sort");
	}
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='Download'])[1]")
	private WebElement download_buttn_issued_materialpage;

	public void Download_button_Issued_Materialpage() {
		act.moveToElement(download_buttn_issued_materialpage).click().perform();
		System.out.println(">> User clicked Download button");
	}

	@FindBy(xpath = "//div[contains(text(),'Download')]")
	private WebElement issued_material_Download_popup_display;

	public void Issued_Material_Download_popup_display() {
		wait.until(ExpectedConditions.visibilityOf(issued_material_Download_popup_display)).isDisplayed();
		AssertJUnit.assertTrue(purchases_Download_popup_display.isDisplayed());
		LOGGER.info(">> The Download Popup got displayed");
	}

	@FindBy(xpath = "//div[normalize-space()='As Excel']")
	private WebElement issued_material_Download_excel;

	public void Issued_Material_Download_Excel() {
		wait.until(ExpectedConditions.visibilityOf(issued_material_Download_excel)).click();
	}

	@FindBy(xpath = "//div[normalize-space()='As PDF']")
	private WebElement issued_material_Download_pdf;

	public void Issued_Material_Download_PDF() {
		wait.until(ExpectedConditions.visibilityOf(issued_material_Download_pdf)).click();
	}

	@FindBy(xpath = "//span[@class='cursor-pointer']//*[name()='svg']")
	private WebElement issued_material_Download_popupclose;

	public void Issued_Material_Download_popup_close() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(issued_material_Download_popupclose)).click();
	}
	public void Download_popupclosd_displayed_Issued_Material() {
		wait.until(ExpectedConditions.visibilityOf(material_issued_page)).isDisplayed();
		AssertJUnit.assertTrue(material_issued_page.isDisplayed());
		LOGGER.info(">> The Download Popup get closed and listed Issued_Material page");
	}
	@FindBy(xpath = "//h5[normalize-space()='All Request(44)']")
	private WebElement all_buyerscount;
	public void All_Buyers_count()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(all_buyerscount)).isDisplayed();
		AssertJUnit.assertTrue(all_buyerscount.isDisplayed());
	}

	@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
	private WebElement click_issuedmaterial_Edit_option;
	@FindBy(xpath = "//a[normalize-space()='View']")
	private WebElement issued_material_click_view;
	public void Issued_Material_Viewclick_option()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(material_request)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_issuedmaterial_Edit_option)).click();
		wait.until(ExpectedConditions.visibilityOf(issued_material_click_view)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/h5[2]")
	private WebElement issued_materialView_display;
	public void Issued_Material_View_display()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(issued_materialView_display)).isDisplayed();
		AssertJUnit.assertTrue(issued_materialView_display.isDisplayed());
		//wait.until(ExpectedConditions.visibilityOf(click_view)).click();
	}
	@FindBy(xpath = "//div[normalize-space()='2']")
	private WebElement issued_material_second_page;
	public void Issued_Material_Second_page() throws Exception {
		act.scrollToElement(issued_material_second_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_second_page)).click();
	}
	@FindBy(xpath = "//div[contains(text(),'Showing')]")
	private WebElement issued_material_second_page_display;
	public void Second_page_Issued_Material_Display() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(issued_material_second_page_display));
		AssertJUnit.assertTrue(issued_material_second_page_display.isDisplayed());
	}
	@FindBy(xpath = "(//div[contains(@class,'round-effect')][contains(text(),'›')])[1]")
	private WebElement clickissued_material_next_page;
	public void Issued_Material_next_page() throws Exception {
		act.scrollToElement(clickissued_material_next_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(clickissued_material_next_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[1]")
	private WebElement clickissued_material_previous_page;
	public void Issued_Material_Previous_page() throws Exception {
		act.scrollToElement(clickissued_material_previous_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(clickissued_material_previous_page)).click();
	}
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[5]")
	private WebElement click_issued_material_last_page;
	public void Issued_Material_last_page() throws Exception {
		act.scrollToElement(click_issued_material_last_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_issued_material_last_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[1]")
	private WebElement click_issued_material_first_page;
	public void First_page_Issued_Material() throws Exception {
		act.scrollToElement(click_issued_material_first_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_issued_material_first_page)).click();
	}

	//<------------------------------------------Damage Received From Technician----------------------------------------------------->
	
	@FindBy(xpath = "//span[normalize-space()='Damage Rec. (From Technician)']")
	private WebElement damage_rec_Technician_Return;
	
	public void DamageRecTechnician_page() throws Exception{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(inventory_menu)).isDisplayed();
		act.moveToElement(damage_rec_Technician_Return).click().perform();
	}
	@FindBy(xpath = "//span[normalize-space()='Damage Rec. (From Technician)']")
	private WebElement damage_rec_Technician_Return_display;
	public void DamageRecTechnician_page_Displayed() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_Return_display)).isDisplayed();
		AssertJUnit.assertTrue(damage_rec_Technician_Return_display.isDisplayed());
	}

	@FindBy(id = "doc_searchQueryInput")
	private WebElement damage_rec_Techniciansearch;
	
	public void DamageRecTechnician_search_enter_text() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Techniciansearch)).click();
		String DamageRecTechnician_Search = prop.getProperty("Billboardid");
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Techniciansearch)).sendKeys(DamageRecTechnician_Search + Keys.ENTER);
		System.out.println(">> User enter the Purchase id in search field: " + DamageRecTechnician_Search);
	}
	@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
	private WebElement DamageRecTechnicianSearched, damage_rec_TechnicianSearchlist;

	public void DamageRecTechnicianSearchedList() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Techniciansearch));

		if (DamageRecTechnicianSearched.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User searched purchases");
		System.out.println(">> User got searched DamageRecTechnician list: " + DamageRecTechnicianSearched.getText());
	}

	public void DamageRecTechnician_list() {
		wait.until(ExpectedConditions.visibilityOf(purchasesSearch));

		if (damage_rec_TechnicianSearchlist.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new purchase btn");
		System.out.println(">> User got sorted DamageRecTechnician list: " + damage_rec_TechnicianSearchlist.getText());
	}

	@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
	private WebElement damage_rec_Technician_sort;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement damage_rec_Technician_sort_recentlyupdated;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
	private WebElement damage_rec_Technician_sort_recentlyadded;

	public void DamageRecTechnician_sort_recentlyupdated() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void DamageRecTechnician_sort_recentlyadded() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently added in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
	private WebElement damage_rec_Technician_Name_A_to_Z;

	public void DamageRecTechnician_sortA_Z() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_Name_A_to_Z)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
	private WebElement damage_rec_Technician_Name_Z_to_A;

	public void DamageRecTechnician_sortZ_A() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(purchase_Name_Z_to_A)).click();
		System.out.println(">> User clicked Z-A updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	private WebElement damage_rec_Technician_Name_decending;

	public void DamageRecTechnician_DecendingDate() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_Name_decending)).click();
		System.out.println(">> User clicked decending updated in sort");
	}
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='Download'])[1]")
	private WebElement download_buttn_damage_rec_Technicianpage;

	public void Download_button_DamageRecTechnicianpage() {
		act.moveToElement(download_buttn_damage_rec_Technicianpage).click().perform();
		System.out.println(">> User clicked Download button");
	}

	@FindBy(xpath = "//div[contains(text(),'Download')]")
	private WebElement damage_rec_Technician_Download_popup_display;

	public void DamageRecTechnician_Download_popup_display() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_Download_popup_display)).isDisplayed();
		AssertJUnit.assertTrue(purchases_Download_popup_display.isDisplayed());
		LOGGER.info(">> The Download Popup got displayed");
	}

	@FindBy(xpath = "//div[normalize-space()='As Excel']")
	private WebElement damage_rec_Technician_Download_excel;

	public void DamageRecTechnician_Download_Excel() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_Download_excel)).click();
	}

	@FindBy(xpath = "//div[normalize-space()='As PDF']")
	private WebElement damage_rec_Technician_Download_pdf;

	public void DamageRecTechnician_Download_PDF() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_Download_pdf)).click();
	}

	@FindBy(xpath = "//span[@class='cursor-pointer']//*[name()='svg']")
	private WebElement damage_rec_Technician_Download_popupclose;

	public void DamageRecTechnician_Download_popup_close() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_Download_popupclose)).click();
	}

	public void Download_popupclosd_displayed_DamageRecTechnician() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_Return)).isDisplayed();
		AssertJUnit.assertTrue(damage_rec_Technician_Return.isDisplayed());
		LOGGER.info(">> The Download Popup get closed and listed DamageRecTechnician page");
	}
	@FindBy(xpath = "//h5[normalize-space()='All Request(44)']")
	private WebElement allReturncount;
	public void AllReturncount()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(allReturncount)).isDisplayed();
		AssertJUnit.assertTrue(allReturncount.isDisplayed());
	}
	@FindBy(id = "New Return")
	private WebElement new_return_button;
	public void New_Return_Button()throws Exception{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_Return)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(new_return_button)).click();
	}
	@FindBy(id = "react-select-3-input")
	private WebElement Used_in_board;
	@FindBy(xpath = "//h5[normalize-space()='New Return']")
	private WebElement newreturn_page_display;
	
	@FindBy(id = "react-select-4-input")
	private WebElement Requested_By;
	
	@FindBy(xpath = "(//input[@value='0'])[1]")
	private WebElement quantitycount;
	
	@FindBy(xpath = "(//div[@class='select__value-container select__value-container--has-value css-hlgwow'])[4]")
	private WebElement defecttype;
	
	@FindBy(id = "react-select-6-input")
	private WebElement reasonsfor_return;
	
	@FindBy(id = "react-select-5-input")
	private WebElement Return_stock_code;
	
	@FindBy(id = "Save")
	private WebElement Return_save;
	
	public void Enter_Mandatory_fieldsof_New_Return()throws Exception{
        Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(newreturn_page_display)).isDisplayed();
		String Usedinboard = prop.getProperty("Usedinboard");
		wait.until(ExpectedConditions.visibilityOf(Used_in_board)).sendKeys(Usedinboard);
        Thread.sleep(7000);
        act.moveToElement(Used_in_board).click().sendKeys(""+Keys.ENTER).perform(); 

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(Used_in_board)).isDisplayed();
		String RequestedBy = prop.getProperty("RequestedBy");
		wait.until(ExpectedConditions.visibilityOf(Requested_By)).sendKeys(RequestedBy);
        Thread.sleep(7000);
        act.moveToElement(Requested_By).click().sendKeys(""+Keys.ENTER).perform(); 
        
        
        wait.until(ExpectedConditions.visibilityOf(Return_stock_code)).isDisplayed();
		Thread.sleep(2000);
		act.moveToElement(Return_stock_code).click().sendKeys(""+Keys.ENTER).perform();
		
		wait.until(ExpectedConditions.visibilityOf(Return_stock_code));
		String QTY =prop.getProperty("QTY");
		Thread.sleep(2000);
        act.moveToElement(quantity).click().sendKeys(""+(QTY)).perform();
		
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(quantitycount)).isDisplayed();
        String defect_type = prop.getProperty("Defecttype");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(defecttype)).sendKeys(defect_type);
		
	    wait.until(ExpectedConditions.visibilityOf(defecttype)).isDisplayed();
	    Thread.sleep(2000);
	    act.moveToElement(reasonsfor_return).click().sendKeys(""+Keys.ENTER).perform();
			      
	
	}
	@FindBy(id = "Add Request")
	private WebElement add_Return;
	public void Click_Add_Return_button()throws Exception{

		wait.until(ExpectedConditions.visibilityOf(add_Return)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(add_Return)).click();
	}
	@FindBy(xpath = "//h5[normalize-space()='Edit Return']")
	private WebElement edit_returnpage_display;
	
	@FindBy(id = "react-select-4-input")
	private WebElement requestby_edit;
	@FindBy(id = "Update Return")
	private WebElement updatereurndamagerec;
	
	public void Edit_requestby()throws Exception{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(edit_returnpage_display)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(requestby_edit)).click();
		Thread.sleep(5000);
        act.moveToElement(requestby_edit).sendKeys(""+Keys.ARROW_DOWN+Keys.ENTER).perform();
	}	
	@FindBy(xpath = "//h5[contains(@class,'mb-0')]")
	private WebElement all_Returns;
	@FindBy(xpath = "//a[normalize-space()='Edit']")
	private WebElement edit_damagerec_Return;
	public void Click_DamageRec_return_Edit()throws Exception{

		wait.until(ExpectedConditions.visibilityOf(all_Returns)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_damage_rec_Technician_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(edit_damagerec_Return)).click();
	}
	@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
	private WebElement click_damage_rec_Technician_Edit;
	@FindBy(xpath = "//a[normalize-space()='View']")
	private WebElement damage_rec_Technician_click_view;
	public void DamageRecTechnician_Viewclick_option()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_Return)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_damage_rec_Technician_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(click_view)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/h5[2]")
	private WebElement damage_rec_TechnicianView_display;
	public void DamageRecTechnicianView_display()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(damage_rec_TechnicianView_display)).isDisplayed();
		AssertJUnit.assertTrue(damage_rec_TechnicianView_display.isDisplayed());
		//wait.until(ExpectedConditions.visibilityOf(click_view)).click();
	}
	@FindBy(xpath = "//a[normalize-space()='Delete']")
	private WebElement damage_rec_Technicianclick_delete;
	public void DamageRecTechnician_Deleteclick_option()throws Exception{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_Return_display)).isDisplayed();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(click_damage_rec_Technician_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technicianclick_delete)).click();
	}
	@FindBy(xpath = "//h4[@class=' fw-semibold text-center text-black']")
	private WebElement damage_rec_Technicianpopup_delete;
	@FindBy(xpath = "//h6[normalize-space()='Yes, delete damage received From technician.']")
	private WebElement damage_rec_Technician_confirm_delete;
	public void DamageRecTechnician_Confirmed_Deleteclick_option()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technicianpopup_delete)).isDisplayed();
		act.moveToElement(damage_rec_Technician_confirm_delete).click().perform();
		//wait.until(ExpectedConditions.visibilityOf(click_delete)).click();
	}
	@FindBy(xpath = "//div[normalize-space()='2']")
	private WebElement damage_rec_Technician_second_page;
	public void DamageRecTechnician_Second_page() throws Exception {
		act.scrollToElement(damage_rec_Technician_second_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_second_page)).click();
	}
	@FindBy(xpath = "//div[contains(text(),'Showing')]")
	private WebElement damage_rec_Technician_second_page_display;
	public void Second_page_DamageRecTechnician_Display() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_second_page_display));
		AssertJUnit.assertTrue(damage_rec_Technician_second_page_display.isDisplayed());
	}
	@FindBy(xpath = "(//div[contains(@class,'round-effect')][contains(text(),'›')])[1]")
	private WebElement clickdamage_rec_Technician_next_page;
	public void DamageRecTechnician_next_page() throws Exception {
		act.scrollToElement(clickdamage_rec_Technician_next_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(clickdamage_rec_Technician_next_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[1]")
	private WebElement clickdamage_rec_Technician_previous_page;
	public void DamageRecTechnician_Previous_page() throws Exception {
		act.scrollToElement(clickdamage_rec_Technician_previous_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(clickdamage_rec_Technician_previous_page)).click();
	}
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[5]")
	private WebElement click_damage_rec_Technician_last_page;
	public void DamageRecTechnician_last_page() throws Exception {
		act.scrollToElement(click_damage_rec_Technician_last_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_damage_rec_Technician_last_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[1]")
	private WebElement click_damage_rec_Technician_first_page;
	public void First_page_DamageRecTechnician() throws Exception {
		act.scrollToElement(click_damage_rec_Technician_first_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_damage_rec_Technician_first_page)).click();
	}
   //<-----------------------------------------------Damage Returned to Supplier----------------------------------------------------->


	@FindBy(xpath = "//span[normalize-space()='Damage Ret. (To Supplier)']")
	private WebElement damage_ret_supplier_Return;
	
	public void DamageRetSupplier_page() throws Exception{
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(inventory_menu)).isDisplayed();
		act.moveToElement(damage_ret_supplier_Return).click().perform();
	}
	@FindBy(xpath = "//span[normalize-space()='Damage Rec. (From Technician)']")
	private WebElement damage_ret_supplier_Return_display;
	public void DamageRetSupplier_page_Displayed() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_Return_display)).isDisplayed();
		AssertJUnit.assertTrue(damage_ret_supplier_Return_display.isDisplayed());
	}

	@FindBy(id = "doc_searchQueryInput")
	private WebElement damage_ret_suppliersearch;
	
	public void DamageRetSupplier_search_enter_text() {
		wait.until(ExpectedConditions.visibilityOf(damage_ret_suppliersearch)).click();
		String DamageRetSupplier_Search = prop.getProperty("Billboardid");
		wait.until(ExpectedConditions.visibilityOf(damage_ret_suppliersearch)).sendKeys(DamageRetSupplier_Search + Keys.ENTER);
		System.out.println(">> User enter the Purchase id in search field: " + DamageRetSupplier_Search);
	}
	@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
	private WebElement DamageRetSupplierSearched, damage_ret_supplierSearchlist;

	public void DamageRetSupplierSearchedList() {
		wait.until(ExpectedConditions.visibilityOf(damage_ret_suppliersearch));

		if (DamageRetSupplierSearched.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User searched purchases");
		System.out.println(">> User got searched DamageRetSupplier list: " + DamageRetSupplierSearched.getText());
	}

	public void DamageRetSupplier_list() {
		wait.until(ExpectedConditions.visibilityOf(purchasesSearch));

		if (damage_ret_supplierSearchlist.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new purchase btn");
		System.out.println(">> User got sorted DamageRetSupplier list: " + damage_ret_supplierSearchlist.getText());
	}

	@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
	private WebElement damage_ret_supplier_sort;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement damage_ret_supplier_sort_recentlyupdated;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
	private WebElement damage_ret_supplier_sort_recentlyadded;

	public void DamageRetSupplier_sort_recentlyupdated() {
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void DamageRetSupplier_sort_recentlyadded() {
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently added in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
	private WebElement damage_ret_supplier_Name_A_to_Z;

	public void DamageRetSupplier_sortA_Z() {
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_Name_A_to_Z)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
	private WebElement damage_ret_supplier_Name_Z_to_A;

	public void DamageRetSupplier_sortZ_A() {
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(purchase_Name_Z_to_A)).click();
		System.out.println(">> User clicked Z-A updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	private WebElement damage_ret_supplier_Name_decending;

	public void DamageRetSupplier_DecendingDate() {
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_Name_decending)).click();
		System.out.println(">> User clicked decending updated in sort");
	}
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='Download'])[1]")
	private WebElement download_buttn_damage_ret_supplierpage;

	public void Download_button_DamageRetSupplierpage() {
		act.moveToElement(download_buttn_damage_ret_supplierpage).click().perform();
		System.out.println(">> User clicked Download button");
	}

	@FindBy(xpath = "(//div[contains(text(),'Download')])[1]")
	private WebElement all_damage_returns_Download_popup_display;

	public void DamageRetSupplier_Download_popup_display() {
		wait.until(ExpectedConditions.visibilityOf(all_damage_returns_Download_popup_display)).isDisplayed();
		AssertJUnit.assertTrue(all_damage_returns_Download_popup_display.isDisplayed());
		LOGGER.info(">> The Download Popup got displayed");
	}

	@FindBy(xpath = "//div[normalize-space()='As Excel']")
	private WebElement damage_ret_supplier_Download_excel;

	public void DamageRetSupplier_Download_Excel() {
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_Download_excel)).click();
	}

	@FindBy(xpath = "(//div[normalize-space()='As PDF'])[1]")
	private WebElement damage_ret_supplier_Download_pdf;

	public void DamageRetSupplier_Download_PDF() {
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_Download_pdf)).click();
	}

	@FindBy(xpath = "//span[@class='cursor-pointer']//*[name()='svg']")
	private WebElement damage_ret_supplier_Download_popupclose;

	public void DamageRetSupplier_Download_popup_close() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_Download_popupclose)).click();
	}

	public void Download_popupclosd_displayed_DamageRetSupplier() {
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_Return)).isDisplayed();
		AssertJUnit.assertTrue(damage_ret_supplier_Return.isDisplayed());
		LOGGER.info(">> The Download Popup get closed and listed DamageRetSupplier page");
	}
	@FindBy(xpath = "//h5[normalize-space()='All Request(44)']")
	private WebElement all_damageReturncount_supplier;
	public void All_DamageReturncount_supplier()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(allReturncount)).isDisplayed();
		AssertJUnit.assertTrue(allReturncount.isDisplayed());
	}
	@FindBy(id = "New Return")
	private WebElement new_return_button_damageReturncount_supplier;
	public void New_Return_Button_damageReturncount_supplier()throws Exception{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_Return)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(new_return_button)).click();
	}
	@FindBy(id = "react-select-3-input")
	private WebElement supplier_name_select;
	@FindBy(xpath = "//input[@name='delivery_no']")
	private WebElement delivery_date;
	
	@FindBy(xpath = "//h5[normalize-space()='New Return']")
	private WebElement newreturn_pagesupplr;
	
	@FindBy(xpath = "//span[normalize-space()='3']")
	private WebElement date_selctd;
	
	@FindBy(id = "react-select-4-input")
	private WebElement id_billboard;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/form/div/div[3]/div[2]/div/table/tbody/tr/td[4]/form/div/div/input")
	private WebElement qty;

	@FindBy(xpath = "(//div[@class='select__value-container select__value-container--has-value css-hlgwow'])[4]")
	private WebElement Defecttype;

	public void Enter_Mandatory_fieldsof_New_Return_DamageRetSupplier()throws Exception{
		
		wait.until(ExpectedConditions.visibilityOf(newreturn_pagesupplr)).isDisplayed();
		String suppliername = prop.getProperty("suppliername");
		wait.until(ExpectedConditions.visibilityOf(supplier_name_select)).sendKeys(suppliername);
	 	Thread.sleep(1000);
		act.moveToElement(supplier_name_select).click().sendKeys(""+Keys.ENTER+Keys.ARROW_RIGHT).perform();
		
		wait.until(ExpectedConditions.visibilityOf(supplier_name)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(delivery_date)).click();
		wait.until(ExpectedConditions.visibilityOf(date_selctd)).click();
		
	 	Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(delivery_date)).isDisplayed();
		String billboardid = prop.getProperty("billboardid");
		wait.until(ExpectedConditions.visibilityOf(id_billboard)).sendKeys(billboardid);
	 	Thread.sleep(5000);
		act.moveToElement(id_billboard).click().sendKeys(""+Keys.ENTER+Keys.ARROW_RIGHT).perform();
	
		 wait.until(ExpectedConditions.visibilityOf(Return_stock_code)).isDisplayed();
			Thread.sleep(2000);
			act.moveToElement(Return_stock_code).click().sendKeys(""+Keys.ENTER).perform();
			
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(Return_stock_code)).isDisplayed();
			String QTY =prop.getProperty("QTY");
			Thread.sleep(7000);
	        act.moveToElement(qty).click().sendKeys(""+(QTY)).perform();
			
	        Thread.sleep(4000);
	        wait.until(ExpectedConditions.visibilityOf(qty)).isDisplayed();
			act.moveToElement(Defecttype).click().sendKeys(""+Keys.ENTER).perform();
	        
	}
	@FindBy(id = "Add Request")
	private WebElement add_Return_DamageRetSupplier;
	public void Add_Return_button_DamageRetSupplier()throws Exception{

		wait.until(ExpectedConditions.visibilityOf(add_Return)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(add_Return)).click();
	}
	@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
	private WebElement click_damage_ret_supplier_Edit;
	@FindBy(xpath = "//a[normalize-space()='View']")
	private WebElement damage_ret_supplier_click_view;
	public void DamageRetSupplier_Viewclick_option()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_Return)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_damage_ret_supplier_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(click_view)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/h5[2]")
	private WebElement damage_ret_supplierView_display;
	public void DamageRetSupplierView_display()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplierView_display)).isDisplayed();
		AssertJUnit.assertTrue(damage_ret_supplierView_display.isDisplayed());
		//wait.until(ExpectedConditions.visibilityOf(click_view)).click();
	}
	@FindBy(xpath = "//a[normalize-space()='Edit']")
	private WebElement select_damagereturnedit;
	
	public void edits_remarks() throws Exception {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_Return)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_material_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(select_damagereturnedit)).click();

	}
	@FindBy(xpath = "//h5[normalize-space()='Edit Return']")
	private WebElement damage_return_edit_padding;
	
	@FindBy(xpath = "//input[@name='remarks']")
	private WebElement damagereturn_remarks;
	
	@FindBy(xpath = "//h6[normalize-space()='Update Return']")
    private WebElement update_damagereturn;

	public void Click_edit_DamageRetSupplier() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(damage_return_edit_padding)).isDisplayed();
		//wait.until(ExpectedConditions.visibilityOf(issued_to)).isDisplayed();
		damagereturn_remarks.sendKeys(Keys.CONTROL, "a", Keys.DELETE);

		String D_remarks = generateUniqueboardNumber(prop.getProperty("D_remarks"));
		wait.until(ExpectedConditions.visibilityOf(damagereturn_remarks)).sendKeys(D_remarks);
		Thread.sleep(2000);
		act.moveToElement(update_damagereturn).click().perform();
	}
	
	@FindBy(xpath = "//a[normalize-space()='Delete']")
	private WebElement damage_ret_supplierclick_delete;
	public void DamageRetSupplier_Deleteclick_option()throws Exception{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_Return_display)).isDisplayed();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(click_damage_ret_supplier_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplierclick_delete)).click();
	}
	@FindBy(xpath = "//h4[@class=' fw-semibold text-center text-black']")
	private WebElement damage_ret_supplierpopup_delete;
	@FindBy(xpath = "//h6[normalize-space()='Yes, delete damage received From technician.']")
	private WebElement damage_ret_supplier_confirm_delete;
	public void DamageRetSupplier_Confirmed_Deleteclick_option()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplierpopup_delete)).isDisplayed();
		act.moveToElement(damage_ret_supplier_confirm_delete).click().perform();
		//wait.until(ExpectedConditions.visibilityOf(click_delete)).click();
	}
	@FindBy(xpath = "//div[normalize-space()='2']")
	private WebElement damage_ret_supplier_second_page;
	public void DamageRetSupplier_Second_page() throws Exception {
		act.scrollToElement(damage_ret_supplier_second_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_second_page)).click();
	}
	@FindBy(xpath = "//div[contains(text(),'Showing')]")
	private WebElement damage_ret_supplier_second_page_display;
	public void Second_page_DamageRetSupplier_Display() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(damage_ret_supplier_second_page_display));
		AssertJUnit.assertTrue(damage_ret_supplier_second_page_display.isDisplayed());
	}
	@FindBy(xpath = "(//div[contains(@class,'round-effect')][contains(text(),'›')])[1]")
	private WebElement clickdamage_ret_supplier_next_page;
	public void DamageRetSupplier_next_page() throws Exception {
		act.scrollToElement(clickdamage_ret_supplier_next_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(clickdamage_ret_supplier_next_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[1]")
	private WebElement clickdamage_ret_supplier_previous_page;
	public void DamageRetSupplier_Previous_page() throws Exception {
		act.scrollToElement(clickdamage_ret_supplier_previous_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(clickdamage_ret_supplier_previous_page)).click();
	}
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[5]")
	private WebElement click_damage_ret_supplier_last_page;
	public void DamageRetSupplier_last_page() throws Exception {
		act.scrollToElement(click_damage_ret_supplier_last_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_damage_ret_supplier_last_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[1]")
	private WebElement click_damage_ret_supplier_first_page;
	public void First_page_DamageRetSupplier() throws Exception {
		act.scrollToElement(click_damage_ret_supplier_first_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_damage_ret_supplier_first_page)).click();
	}
//<--------------------------------------------Damage Received From Supplier---------------------------------------------------------->
	
	@FindBy(xpath = "//span[normalize-space()='Damage Rec. (From Supplier)']")
	private WebElement damage_rec_supplier_Return;
	
	public void DamageRecSupplier_page() throws Exception{
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(inventory_menu)).isDisplayed();
		act.moveToElement(damage_rec_supplier_Return).click().perform();
	}
	@FindBy(xpath = "//span[normalize-space()='Damage Rec. (From Technician)']")
	private WebElement damage_rec_supplier_display;
	public void DamageRecSupplier_page_Displayed() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_display)).isDisplayed();
		AssertJUnit.assertTrue(damage_rec_supplier_display.isDisplayed());
	}

	@FindBy(id = "doc_searchQueryInput")
	private WebElement damage_rec_suppliersearch;
	
	public void DamageRecSupplier_search_enter_text() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_suppliersearch)).click();
		String DamageRecSupplier_Search = prop.getProperty("Billboardid");
		wait.until(ExpectedConditions.visibilityOf(damage_rec_suppliersearch)).sendKeys(DamageRecSupplier_Search + Keys.ENTER);
		System.out.println(">> User enter the supplier id in search field: " + DamageRecSupplier_Search);
	}
	@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
	private WebElement DamageRecSupplierSearched, damage_rec_supplierSearchlist;

	public void DamageRecSupplierSearchedList() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_suppliersearch));

		if (DamageRecSupplierSearched.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User searched Suppliers");
		System.out.println(">> User got searched DamageRecSupplier list: " + DamageRecSupplierSearched.getText());
	}

	public void DamageRecSupplier_list() {
		wait.until(ExpectedConditions.visibilityOf(purchasesSearch));

		if (damage_rec_supplierSearchlist.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
		LOGGER.info(">> Admin/User clicked new Replace btn");
		System.out.println(">> User got sorted DamageRecSupplier list: " + damage_rec_supplierSearchlist.getText());
	}

	@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
	private WebElement damage_rec_supplier_sort;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
	private WebElement damage_rec_supplier_sort_recentlyupdated;

	@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
	private WebElement damage_rec_supplier_sort_recentlyadded;

	public void DamageRecSupplier_sort_recentlyupdated() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_sort_recentlyupdated)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	public void DamageRecSupplier_sort_recentlyadded() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_sort_recentlyadded)).click();
		System.out.println(">> User clicked recently added in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
	private WebElement damage_rec_supplier_Name_A_to_Z;

	public void DamageRecSupplier_sortA_Z() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_Name_A_to_Z)).click();
		System.out.println(">> User clicked recently updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
	private WebElement damage_rec_supplier_Name_Z_to_A;

	public void DamageRecSupplier_sortZ_A() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(purchase_Name_Z_to_A)).click();
		System.out.println(">> User clicked Z-A updated in sort");
	}

	@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
	private WebElement damage_rec_supplier_Name_decending;

	public void DamageRecSupplier_DecendingDate() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_sort)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_Name_decending)).click();
		System.out.println(">> User clicked decending updated in sort");
	}
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='Download'])[1]")
	private WebElement download_buttn_damage_rec_supplierpage;

	public void Download_button_DamageRecSupplierpage() {
		act.moveToElement(download_buttn_damage_rec_supplierpage).click().perform();
		System.out.println(">> User clicked Download button");
	}

	@FindBy(xpath = "(//div[contains(text(),'Download')])[1]")
	private WebElement all_damage_rec_Download_popup_display;

	public void DamageRecSupplier_Download_popup_display() {
		wait.until(ExpectedConditions.visibilityOf(all_damage_returns_Download_popup_display)).isDisplayed();
		AssertJUnit.assertTrue(all_damage_returns_Download_popup_display.isDisplayed());
		LOGGER.info(">> The Download Popup got displayed");
	}

	@FindBy(xpath = "//div[normalize-space()='As Excel']")
	private WebElement damage_rec_supplier_Download_excel;

	public void DamageRecSupplier_Download_Excel() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_Download_excel)).click();
	}

	@FindBy(xpath = "(//div[normalize-space()='As PDF'])[1]")
	private WebElement damage_rec_supplier_Download_pdf;

	public void DamageRecSupplier_Download_PDF() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_Download_pdf)).click();
	}

	@FindBy(xpath = "//span[@class='cursor-pointer']//*[name()='svg']")
	private WebElement damage_rec_supplier_Download_popupclose;

	public void DamageRecSupplier_Download_popup_close() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_Download_popupclose)).click();
	}

	public void Download_popupclosd_displayed_DamageRecSupplier() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_Return)).isDisplayed();
		AssertJUnit.assertTrue(damage_rec_supplier_Return.isDisplayed());
		LOGGER.info(">> The Download Popup get closed and listed DamageRecSupplier page");
	}
	@FindBy(xpath = "//h5[contains(@class,'mb-0')]")
	private WebElement all_damageReplacescount_supplier;
	public void all_damageReplacescount_supplier()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(all_damageReplacescount_supplier)).isDisplayed();
		AssertJUnit.assertTrue(all_damageReplacescount_supplier.isDisplayed());
	}
	@FindBy(id = "New Replace")
	private WebElement new_Replace_supplier;
	public void New_Replace_Button_damageRec_supplier()throws Exception{
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(new_Replace_supplier)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(new_Replace_supplier)).click();
	}

	@FindBy(xpath = "//h5[normalize-space()='New Replace']")
	private WebElement newreplace_pagesupplr;

	@FindBy(xpath = "(//input[@type='text'])[9]")
	private WebElement Dttype;

	public void Enter_Mandatory_fieldsof_New_Replace_DamageRecSupplier()throws Exception{
		
		wait.until(ExpectedConditions.visibilityOf(newreplace_pagesupplr)).isDisplayed();
		String suppliername = prop.getProperty("suppliername");
		wait.until(ExpectedConditions.visibilityOf(supplier_name_select)).sendKeys(suppliername);
	 	Thread.sleep(1000);
		act.moveToElement(supplier_name_select).click().sendKeys(""+Keys.ENTER+Keys.ARROW_RIGHT).perform();
		
	 	Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(supplier_name)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(delivery_date)).click();
		wait.until(ExpectedConditions.visibilityOf(date_selctd)).click();

	 	Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(delivery_date)).isDisplayed();
		String billboardid = prop.getProperty("billboardid");
		wait.until(ExpectedConditions.visibilityOf(id_billboard)).sendKeys(billboardid);
	 	Thread.sleep(5000);
		act.moveToElement(id_billboard).click().sendKeys(""+Keys.ENTER+Keys.ARROW_RIGHT).perform();
	
		 wait.until(ExpectedConditions.visibilityOf(Return_stock_code)).isDisplayed();
			Thread.sleep(2000);
			act.moveToElement(Return_stock_code).click().sendKeys(""+Keys.ENTER).perform();
			
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(Return_stock_code)).isDisplayed();
			String QTY =prop.getProperty("QTY");
			Thread.sleep(7000);
	        act.moveToElement(qty).click().sendKeys(""+(QTY)).perform();
			
	        Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(qty)).isDisplayed();
			String Dt =prop.getProperty("Dt");
			Thread.sleep(7000);
	        act.moveToElement(Dttype).click().sendKeys(""+(Dt)).perform();        
	        Thread.sleep(4000);
	        wait.until(ExpectedConditions.visibilityOf(qty)).isDisplayed();
			act.moveToElement(Defecttype).click().sendKeys(""+Keys.ENTER).perform();
	        
	}
	@FindBy(id = "Add Request")
	private WebElement add_Return_DamageRecSupplier;
	public void Add_Return_button_DamageRecSupplier()throws Exception{

		wait.until(ExpectedConditions.visibilityOf(add_Return)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(add_Return)).click();
	}

	@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
	private WebElement click_damage_rec_supplier_Edit;
	@FindBy(xpath = "//a[normalize-space()='View']")
	private WebElement damage_rec_supplier_click_view;
	public void DamageRecSupplier_Viewclick_option()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_Return)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_damage_rec_supplier_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(click_view)).click();
	}
	@FindBy(xpath = "//h5[normalize-space()='View Replace']")
	private WebElement damage_rec_supplierView_display;
	public void DamageRecSupplierView_display()throws Exception{
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplierView_display)).isDisplayed();
		AssertJUnit.assertTrue(damage_rec_supplierView_display.isDisplayed());
		//wait.until(ExpectedConditions.visibilityOf(click_view)).click();
	}
	@FindBy(xpath = "//a[normalize-space()='Edit']")
	private WebElement select_damagereceivededit;
	
	public void Click_edit_DamageRecSupplier() throws Exception {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_Return)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(click_material_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(select_damagereceivededit)).click();

	}
	@FindBy(xpath = "//h5[normalize-space()='Edit Replace']")
	private WebElement damage_received_edit_padding;
	
	@FindBy(xpath = "//input[@name='remarks']")
	private WebElement damagereceived_remarks;
	
	@FindBy(xpath = "//div[@data-testid='Update Replace']")
    private WebElement update_damagere;

	public void edits_remarks_DamageRecSupplier() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(damage_received_edit_padding)).isDisplayed();
		//wait.until(ExpectedConditions.visibilityOf(issued_to)).isDisplayed();
		damagereturn_remarks.sendKeys(Keys.CONTROL, "a", Keys.DELETE);

		String D_remarks = generateUniqueboardNumber(prop.getProperty("D_remarks"));
		wait.until(ExpectedConditions.visibilityOf(damagereceived_remarks)).sendKeys(D_remarks);
		Thread.sleep(2000);
		act.moveToElement(update_damagere).click().perform();
	}
	@FindBy(xpath = "//a[normalize-space()='Delete']")
	private WebElement damage_rec_supplierclick_delete;
	public void DamageRecSupplier_Deleteclick_option()throws Exception{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_display)).isDisplayed();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(click_damage_rec_supplier_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplierclick_delete)).click();
	}
	@FindBy(xpath = "//h4[@class=' fw-semibold text-center text-black']")
	private WebElement damage_rec_supplierpopup_delete;
	@FindBy(xpath = "//h6[normalize-space()='Yes, delete damage received From technician.']")
	private WebElement damage_rec_supplier_confirm_delete;
	public void DamageRecSupplier_Confirmed_Deleteclick_option()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplierpopup_delete)).isDisplayed();
		act.moveToElement(damage_rec_supplier_confirm_delete).click().perform();
		//wait.until(ExpectedConditions.visibilityOf(click_delete)).click();
	}

	@FindBy(xpath = "//div[normalize-space()='2']")
	private WebElement damage_rec_supplier_second_page;

	public void DamageRecSupplier_Second_page() {
	    try {
	        // Scroll to the element
	        act.scrollToElement(damage_rec_supplier_second_page).build().perform();

	        // Wait for the element to become visible and click it
	        wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_second_page)).click();
	        
	        System.out.println("Second page clicked successfully.");
	    } catch (NoSuchElementException e) {
	        // Handle the scenario where the element does not exist
	        System.out.println("Second page element not found. Proceeding without clicking.");
	    } catch (Exception e) {
	        // Log any other exceptions
	        System.out.println("An error occurred while handling the second page: " + e.getMessage());
	    }
	}
	
	
	@FindBy(xpath = "//div[contains(text(),'Showing')]")
	private WebElement damage_rec_supplier_second_page_display;
	public void Second_page_DamageRecSupplier_Display() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_supplier_second_page_display));
		AssertJUnit.assertTrue(damage_rec_supplier_second_page_display.isDisplayed());
	}
	@FindBy(xpath = "(//div[contains(@class,'round-effect')][contains(text(),'›')])[1]")
	private WebElement clickdamage_rec_supplier_next_page;
	public void DamageRecSupplier_next_page() throws Exception {
		act.scrollToElement(clickdamage_rec_supplier_next_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(clickdamage_rec_supplier_next_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[1]")
	private WebElement clickdamage_rec_supplier_previous_page;
	public void DamageRecSupplier_Previous_page() throws Exception {
		act.scrollToElement(clickdamage_rec_supplier_previous_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(clickdamage_rec_supplier_previous_page)).click();
	}
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[5]")
	private WebElement click_damage_rec_supplier_last_page;
	public void DamageRecSupplier_last_page() throws Exception {
		act.scrollToElement(click_damage_rec_supplier_last_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_damage_rec_supplier_last_page)).click();
	}
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div[2]/div[1]")
	private WebElement click_damage_rec_supplier_first_page;
	public void First_page_DamageRecSupplier() throws Exception {
		act.scrollToElement(click_damage_rec_supplier_first_page).build().perform();
		wait.until(ExpectedConditions.visibilityOf(click_damage_rec_supplier_first_page)).click();
	}
//<-----------------------------------------Report Page---------------------------------------------------------->
	
	@FindBy(xpath = "//span[normalize-space()='Report']")
	private WebElement Click_report_tab;
	
	public void Reportpage() throws Exception{
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(inventory_menu)).isDisplayed();
		act.moveToElement(Click_report_tab).click().perform();
	}
	@FindBy(xpath = "//h5[normalize-space()='Generate Report']")
	private WebElement report_display;
	public void Report_page_Displayed() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(report_display)).isDisplayed();
		AssertJUnit.assertTrue(report_display.isDisplayed());
	}
	@FindBy(xpath ="//div[@class='select__input-container css-19bb58m']")
	private WebElement stockcode;
	
	@FindBy(xpath ="//h6[normalize-space()='Generate Report']")
	private WebElement generate_report_button;
	public void Generate_Stock_Based_Report()throws Exception{
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(report_display)).isDisplayed();
		Thread.sleep(4000);
		act.moveToElement(stockcode).click().sendKeys(""+Keys.ENTER).perform();
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(stockcode)).isDisplayed();
		act.moveToElement(generate_report_button).click().perform();

	}
	
	//<--------------------------------------------Stock Adjustments---------------------------------------------------------->
	
		@FindBy(xpath = "//span[normalize-space()='Stock Adjustment']")
		private WebElement stock_adjustment;
		
		public void Stock_Adjustments_page() throws Exception{
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(inventory_menu)).isDisplayed();
			act.moveToElement(stock_adjustment).click().perform();
		}
		@FindBy(xpath = "//h5[contains(@class,'mb-0')]")
		private WebElement stock_adjustment_display;
		public void Stock_Adjustments_page_Displayed() throws Exception{
			wait.until(ExpectedConditions.visibilityOf(stock_adjustment_display)).isDisplayed();
			AssertJUnit.assertTrue(stock_adjustment_display.isDisplayed());
		}

		@FindBy(id = "doc_searchQueryInput")
		private WebElement stock_adjustmentsearch;
		
		public void Stock_Adjustments_search_enter_text() {
			wait.until(ExpectedConditions.visibilityOf(stock_adjustmentsearch)).click();
			String Stock_Adjustments_Search = prop.getProperty("Billboardid");
			wait.until(ExpectedConditions.visibilityOf(stock_adjustmentsearch)).sendKeys(Stock_Adjustments_Search + Keys.ENTER);
			System.out.println(">> User enter the supplier id in search field: " + Stock_Adjustments_Search);
		}
		@FindBy(xpath = "(//input[@id='doc_searchQueryInput'])[1]")
		private WebElement Stock_AdjustmentsSearched, stock_adjustmentSearchlist;

		public void Stock_AdjustmentsSearchedList() {
			wait.until(ExpectedConditions.visibilityOf(stock_adjustmentsearch));

			if (Stock_AdjustmentsSearched.isDisplayed()) {
				System.out.println("Element is displayed");
			} else {
				System.out.println("Element is not displayed");
			}
			LOGGER.info(">> Admin/User searched Suppliers");
			System.out.println(">> User got searched Stock_Adjustments list: " + Stock_AdjustmentsSearched.getText());
		}

		public void Stock_Adjustments_list() {
			wait.until(ExpectedConditions.visibilityOf(purchasesSearch));

			if (stock_adjustmentSearchlist.isDisplayed()) {
				System.out.println("Element is displayed");
			} else {
				System.out.println("Element is not displayed");
			}
			LOGGER.info(">> Admin/User clicked new Replace btn");
			System.out.println(">> User got sorted Stock_Adjustments list: " + stock_adjustmentSearchlist.getText());
		}

		@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Recently Added'])[1]")
		private WebElement stock_adjustment_sort;

		@FindBy(xpath = "(//h6[contains(text(),'Recently Updated')])[1]")
		private WebElement stock_adjustment_sort_recentlyupdated;

		@FindBy(xpath = "(//h6[contains(text(),'Recently Added')])[2]")
		private WebElement stock_adjustment_sort_recentlyadded;

		public void Stock_Adjustments_sort_recentlyupdated() {
			wait.until(ExpectedConditions.visibilityOf(stock_adjustment_sort)).click();
			wait.until(ExpectedConditions.visibilityOf(stock_adjustment_sort_recentlyupdated)).click();
			System.out.println(">> User clicked recently updated in sort");
		}

		public void Stock_Adjustments_sort_recentlyadded() {
			wait.until(ExpectedConditions.visibilityOf(stock_adjustment_sort)).click();
			wait.until(ExpectedConditions.visibilityOf(stock_adjustment_sort_recentlyadded)).click();
			System.out.println(">> User clicked recently added in sort");
		}

		@FindBy(xpath = "(//h6[contains(text(),'Name - A to Z')])[1]")
		private WebElement stock_adjustment_Name_A_to_Z;

		public void Stock_Adjustments_sortA_Z() {
			wait.until(ExpectedConditions.visibilityOf(stock_adjustment_sort)).click();
			wait.until(ExpectedConditions.visibilityOf(stock_adjustment_Name_A_to_Z)).click();
			System.out.println(">> User clicked recently updated in sort");
		}

		@FindBy(xpath = "(//h6[contains(text(),'Name - Z to A')])[1]")
		private WebElement stock_adjustment_Name_Z_to_A;

		public void Stock_Adjustments_sortZ_A() {
			wait.until(ExpectedConditions.visibilityOf(stock_adjustment_sort)).click();
			wait.until(ExpectedConditions.visibilityOf(purchase_Name_Z_to_A)).click();
			System.out.println(">> User clicked Z-A updated in sort");
		}

		@FindBy(xpath = "(//h6[contains(text(),'Decending - Date')])[1]")
		private WebElement stock_adjustment_Name_decending;

		public void Stock_Adjustments_DecendingDate() {
			wait.until(ExpectedConditions.visibilityOf(stock_adjustment_sort)).click();
			wait.until(ExpectedConditions.visibilityOf(stock_adjustment_Name_decending)).click();
			System.out.println(">> User clicked decending updated in sort");
		}
	
		@FindBy(xpath = "//h5[contains(@class,'mb-0')]")
		private WebElement all_stock_adjustmentcount;
		public void All_Stock_Adjustmentcount()throws Exception{
			wait.until(ExpectedConditions.visibilityOf(all_stock_adjustmentcount)).isDisplayed();
			AssertJUnit.assertTrue(all_stock_adjustmentcount.isDisplayed());
		}
		@FindBy(xpath = "(//button[contains(@type,'button')][normalize-space()='New Stock Adjustment'])[1]")
		private WebElement new_stock_adjustmentbuttn;
		public void New_Stock_Adjustment_Button()throws Exception{
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(new_stock_adjustmentbuttn)).isDisplayed();
			wait.until(ExpectedConditions.visibilityOf(new_stock_adjustmentbuttn)).click();
		}
		@FindBy(xpath = "//h5[normalize-space()='Stock Adjustment']")
		private WebElement stockadjmnt_page;
		@FindBy(xpath = "//div[@class='select__input-container css-19bb58m']")
		private WebElement stockcodedropdown;
		
		@FindBy(xpath = "//input[@name='quantity']")
		private WebElement quantitystockadjstmnt;
		
		@FindBy(xpath = "//textarea[@name='description']")
		private WebElement Descriptions;
		public void Enter_Mandatory_fieldsof_Stock_Adjustments()throws Exception{
		 	Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOf(stockadjmnt_page)).isDisplayed();
			act.moveToElement(stockcodedropdown).click().sendKeys(""+Keys.ENTER).perform();
			
		 	Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(stockcodedropdown)).isDisplayed();
			String quantityofstockadjstmnt = prop.getProperty("quantityofstockadjstmnt");
			wait.until(ExpectedConditions.visibilityOf(quantitystockadjstmnt)).isDisplayed();
		 	Thread.sleep(3000);
            act.moveToElement(quantitystockadjstmnt).click().sendKeys(""+(quantityofstockadjstmnt)).perform();
            
            Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(quantitystockadjstmnt)).isDisplayed();
			String descrptns = prop.getProperty("descrptns");
			wait.until(ExpectedConditions.visibilityOf(Descriptions)).isDisplayed();
		 	Thread.sleep(3000);
            act.moveToElement(Descriptions).click().sendKeys(""+(descrptns)).perform();
		}
		@FindBy(xpath = "//span[normalize-space()='Add Stock Adjustment']")
		private WebElement add_Stock_Adjustments;
		public void Add_Stock_Adjustments_Button()throws Exception{

			wait.until(ExpectedConditions.visibilityOf(Descriptions)).isDisplayed();
			wait.until(ExpectedConditions.visibilityOf(add_Stock_Adjustments)).click();
		}
		@FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[7]")
		private WebElement click_stock_adjustment_Edit;
		@FindBy(xpath = "//a[normalize-space()='View']")
		private WebElement stock_adjustment_click_view;
		public void Stock_Adjustments_Viewclick_option()throws Exception{
			wait.until(ExpectedConditions.visibilityOf(stock_adjustment)).isDisplayed();
			wait.until(ExpectedConditions.visibilityOf(click_stock_adjustment_Edit)).click();
			wait.until(ExpectedConditions.visibilityOf(click_view)).click();
		}
		@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/h5[2]")
		private WebElement stock_adjustmentView_display;
		public void Stock_AdjustmentsView_display()throws Exception{
			wait.until(ExpectedConditions.visibilityOf(stock_adjustmentView_display)).isDisplayed();
			AssertJUnit.assertTrue(stock_adjustmentView_display.isDisplayed());
			//wait.until(ExpectedConditions.visibilityOf(click_view)).click();
		}
		@FindBy(xpath = "//a[normalize-space()='Delete']")
		private WebElement stock_adjustmentclick_delete;
		public void Stock_Adjustments_Deleteclick_option()throws Exception{
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(stock_adjustment_display)).isDisplayed();
			Thread.sleep(1000);

			wait.until(ExpectedConditions.visibilityOf(click_stock_adjustment_Edit)).click();
			wait.until(ExpectedConditions.visibilityOf(stock_adjustmentclick_delete)).click();
		}
		@FindBy(xpath = "//h4[@class=' fw-semibold text-center text-black']")
		private WebElement stock_adjustmentpopup_delete;
		@FindBy(xpath = "//h6[normalize-space()='Yes, delete damage received From technician.']")
		private WebElement stock_adjustment_confirm_delete;
		public void Stock_Adjustments_Confirmed_Deleteclick_option()throws Exception{
			wait.until(ExpectedConditions.visibilityOf(stock_adjustmentpopup_delete)).isDisplayed();
			act.moveToElement(stock_adjustment_confirm_delete).click().perform();
			//wait.until(ExpectedConditions.visibilityOf(click_delete)).click();
		}
		@FindBy(xpath = "//div[normalize-space()='2']")
		private WebElement stock_adjustment_second_page;
		public void Stock_Adjustments_Second_page() throws Exception {
			act.scrollToElement(stock_adjustment_second_page).build().perform();
			wait.until(ExpectedConditions.visibilityOf(click_second_page)).click();
		}
		@FindBy(xpath = "//div[contains(text(),'Showing')]")
		private WebElement stock_adjustment_second_page_display;
		public void Second_page_Stock_Adjustments_Display() throws Exception {
			wait.until(ExpectedConditions.visibilityOf(stock_adjustment_second_page_display));
			AssertJUnit.assertTrue(stock_adjustment_second_page_display.isDisplayed());
		}
		@FindBy(xpath = "(//div[contains(@class,'round-effect')][contains(text(),'›')])[1]")
		private WebElement clickstock_adjustment_next_page;
		public void Stock_Adjustments_next_page() throws Exception {
			act.scrollToElement(clickstock_adjustment_next_page).build().perform();
			wait.until(ExpectedConditions.visibilityOf(clickstock_adjustment_next_page)).click();
		}
		@FindBy(xpath = "//div[contains(@class,'d-flex justify-content-between align-items-center')]//div[contains(@class,'d-flex')]//div[1]")
		private WebElement clickstock_adjustment_previous_page;
		public void Stock_Adjustments_Previous_page() throws Exception {
			act.scrollToElement(clickstock_adjustment_previous_page).build().perform();
			wait.until(ExpectedConditions.visibilityOf(clickstock_adjustment_previous_page)).click();
		}
		@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[4]/div[2]/div[5]")
		private WebElement click_stock_adjustment_last_page;
		public void Stock_Adjustments_last_page() throws Exception {
			act.scrollToElement(click_stock_adjustment_last_page).build().perform();
			wait.until(ExpectedConditions.visibilityOf(click_stock_adjustment_last_page)).click();
		}
		@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[4]/div[2]/div[1]")
		private WebElement click_stock_adjustment_first_page;
		public void First_page_Stock_Adjustments() throws Exception {
			act.scrollToElement(click_stock_adjustment_first_page).build().perform();
			wait.until(ExpectedConditions.visibilityOf(click_stock_adjustment_first_page)).click();
		}
		@FindBy(xpath = "(//div[contains(@class,'select__input-container css-19bb58m')])[1]")
		private WebElement stock_code_dropdown;
		
		@FindBy(xpath = "(//h6[contains(@class,'m-0 by fw-normal')][normalize-space()='Filter By'])[1]")
		private WebElement filterby_buttn;
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[3]/div/div[2]/div/div[2]/div/div[5]/button[2]")
		private WebElement apply_buttn;
		
		public void Stock_code_filter() throws Exception{
			wait.until(ExpectedConditions.visibilityOf(filterby_buttn)).click();
			wait.until(ExpectedConditions.visibilityOf(stock_code_dropdown)).click();
			Thread.sleep(5000);
			act.moveToElement(stock_code_dropdown).click().sendKeys(""+Keys.ENTER).perform();
			wait.until(ExpectedConditions.visibilityOf(apply_buttn)).click();
		}
		@FindBy(xpath = "//div[contains(@class,'d-flex justify-content-center align-items-center')]")
		private WebElement No_Stock_Adjustment_Found;

		public void Stockadjustment_filtered_result_display() {
			try {
				if (condition) {
					wait.until(ExpectedConditions.visibilityOf(stock_adjustmentSearchlist));
					AssertJUnit.assertTrue(stock_adjustmentSearchlist.isDisplayed());
					System.out.println(">> User got the filtered Tickets list");
				} else {
					wait.until(ExpectedConditions.visibilityOf(No_Stock_Adjustment_Found));
				}
			} catch (Exception e) {
				wait.until(ExpectedConditions.visibilityOf(No_Stock_Adjustment_Found));
			}
		}
		@FindBy(xpath = "(//div[contains(@class,'ps-4 pe-1 fw-semibold off')][normalize-space()='MINUS'])[1]")
		private WebElement credit_Type_PLUS_filter;
		
		public void Credit_Type_PLUS_filter() throws Exception{
			wait.until(ExpectedConditions.visibilityOf(filterby_buttn)).click();
			wait.until(ExpectedConditions.visibilityOf(credit_Type_PLUS_filter)).click();
			wait.until(ExpectedConditions.visibilityOf(apply_buttn)).click();
		}
		@FindBy(xpath = "(//div[contains(@class,'pe-4 fw-semibold on')][normalize-space()='PLUS'])[1]")
		private WebElement credit_Type_MINUS_filter;
		
		public void Credit_Type_MINUS_filter() throws Exception{
			wait.until(ExpectedConditions.visibilityOf(filterby_buttn)).click();
			wait.until(ExpectedConditions.visibilityOf(credit_Type_MINUS_filter)).click();
			wait.until(ExpectedConditions.visibilityOf(apply_buttn)).click();
		}
		@FindBy(xpath = "(//div[contains(@class,'select__input-container css-19bb58m')])[2]")
		private WebElement credit_by_filter;
		
		public void Created_BY_filter() throws Exception{
			wait.until(ExpectedConditions.visibilityOf(filterby_buttn)).click();
			String createdby = prop.getProperty("createdby");
			wait.until(ExpectedConditions.visibilityOf(credit_by_filter)).isDisplayed();
			Thread.sleep(5000);
			act.moveToElement(credit_by_filter).click().sendKeys(""+createdby);
			Thread.sleep(2000);
			act.moveToElement(credit_by_filter).sendKeys(Keys.ENTER).perform();
			LOGGER.info(">> User selected the createdby:" + credit_by_filter.getText());
			wait.until(ExpectedConditions.visibilityOf(apply_buttn)).click();
		}
		@FindBy(xpath = "(//img[contains(@class,'pointer')])[1]")
		private WebElement reset;
		public void Reset_button() throws Exception{
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(filterby_buttn)).click();
			wait.until(ExpectedConditions.visibilityOf(reset)).isDisplayed();
		}
		
		
}
