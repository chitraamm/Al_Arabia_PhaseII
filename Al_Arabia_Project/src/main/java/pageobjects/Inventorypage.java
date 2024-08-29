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
	@FindBy(xpath = "//span[normalize-space()='Inventory']")
	private WebElement inventoryClick;

	@FindBy(xpath = "//span[normalize-space()='Inventory']")
	private WebElement inventory_menu;

	public void Inventory_click() {
		wait.until(ExpectedConditions.elementToBeClickable(inventoryClick)).click();
		wait.until(ExpectedConditions.visibilityOf(inventory_menu)).isDisplayed();
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
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[1]/ul/li[2]/a/span")
	private WebElement material_request;
	public void Material_request_page() throws Exception{
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
}