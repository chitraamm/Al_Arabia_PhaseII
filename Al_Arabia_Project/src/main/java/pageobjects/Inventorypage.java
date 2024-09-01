package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
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
	//private Signinpage signinpage;


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
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[1]/ul/li[2]/a/span")
	private WebElement material_request;
	
	public void Material_request_page() throws Exception{
		Thread.sleep(1000);
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
	@FindBy(xpath = "//a[normalize-space()='Delete']")
	private WebElement materialclick_delete;
	public void Material_Deleteclick_option()throws Exception{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(material_request_display)).isDisplayed();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(click_material_Edit)).click();
		wait.until(ExpectedConditions.visibilityOf(materialclick_delete)).click();
	}
	@FindBy(xpath = "//h4[@class=' fw-semibold text-center text-black']")
	private WebElement materialpopup_delete;
	@FindBy(xpath = "//h6[normalize-space()='Yes, delete material received from supplier.']")
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

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[1]/ul/li[2]/a/span")
	private WebElement material_issued_page;
	
	public void Material_Issued_page() throws Exception{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(inventory_menu)).isDisplayed();
		act.moveToElement(material_issued_page).click().perform();
	}
	@FindBy(xpath = "")
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
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[1]/ul/li[2]/a/span")
	private WebElement damage_rec_Technician_Return;
	
	public void DamageRecTechnician_page() throws Exception{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(inventory_menu)).isDisplayed();
		act.moveToElement(damage_rec_Technician_Return).click().perform();
	}
	@FindBy(xpath = "//h5[normalize-space()='All Request(44)']")
	private WebElement damage_rec_Technician_Return_display;
	public void DamageRecTechnician_page_Displayed() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_Return_display)).isDisplayed();
		AssertJUnit.assertTrue(damage_rec_Technician_Return_display.isDisplayed());
	}

	@FindBy(id = "doc_searchQueryInput")
	private WebElement damage_rec_Techniciansearch;
	
	public void DamageRecTechnician_search_enter_text() {
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Techniciansearch)).click();
		String DamageRecTechnician_Search = prop.getProperty("DamageRecTechnicianid");
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
	@FindBy(id = "New Request")
	private WebElement new_return_button;
	public void New_Return_Button()throws Exception{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(damage_rec_Technician_Return)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(new_return_button)).click();
	}
	@FindBy(xpath = "//h5[normalize-space()='New Request']")
	private WebElement New_Return_heading;
	@FindBy(id = "react-select-3-input")
	private WebElement Returnby;
	
	@FindBy(xpath = "(//h6[contains(@class,'m-0 fw-normal')][normalize-space()='New Request'])[1]")
	private WebElement billboard_Id;
	
	@FindBy(xpath = "//input[@placeholder='Enter Location']")
	private WebElement city;
	
	@FindBy(id = "react-select-4-input")
	private WebElement Return_stock_code;
	
	@FindBy(id = "Save")
	private WebElement Return_save;
	
	public void Enter_Mandatory_fieldsof_New_Return()throws Exception{
		wait.until(ExpectedConditions.visibilityOf(New_Return_heading)).isDisplayed();
		String RequestBy = prop.getProperty("Returnbyuser");
		wait.until(ExpectedConditions.visibilityOf(Returnby)).sendKeys(RequestBy);
		Thread.sleep(3000);
        act.moveToElement(Returnby).click().sendKeys(""+Keys.ENTER).perform(); 
		
        Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(Returnby)).isDisplayed();
        String Cityname = prop.getProperty("cityname");
        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOf(city)).sendKeys(Cityname+Keys.DOWN);
        
		Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(city)).isDisplayed();
		Thread.sleep(2000);
		act.moveToElement(stock_code).click().sendKeys(""+Keys.ENTER).perform();
		
		wait.until(ExpectedConditions.visibilityOf(stock_code)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(Return_save)).click();
	}
	@FindBy(id = "Add Request")
	private WebElement add_Return;
	public void Click_Add_Return_button()throws Exception{

		wait.until(ExpectedConditions.visibilityOf(add_Return)).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(add_Return)).click();
	}
	
	//updatepenng
	
	

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
	public void damage_rec_Technician_View_display()throws Exception{
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
	@FindBy(xpath = "//h6[normalize-space()='Yes, delete damage_rec_Technician received from supplier.']")
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

}