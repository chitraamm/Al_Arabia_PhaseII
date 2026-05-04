package Stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Memberspage;
import pageobjects.Projectspage;
import pageobjects.Signinpage;
import resources.Base;

public class Projects extends Base {

    private static Logger LOGGER = LogManager.getLogger(Members.class); 
    private WebDriver driver;
    private Memberspage membersPage;
    private Signinpage signinpage;
    private Projectspage projectspage;


    public Projects(Testhooks testhooks) throws Exception {
        this.driver = testhooks.getDriver();
        this.projectspage = new Projectspage(driver);
        this.signinpage = new Signinpage(driver);
        LOGGER = LogManager.getLogger(Projects.class.getName());
    }
    
    @And("User clicks the Projects")
    public void User_clicks_the_members_Projects() throws Exception {
    	projectspage.Projects_Click();
    }

    @Then("Projects page should display successfully")
    public void Projects_page_should_display_successfully() throws Exception {
    	projectspage.Projects_Display();
    }
    
    @And("User search a project")
    public void User_search_a_project() {
    	projectspage.Search_Project();
    } 
    
    @Then("Searched Project details get displayed successfully")
    public void Searched_Project_details_get_displayed_successfully() {
    	projectspage.Project_SearchedList();
    }
    
    @And("User click sort button")
    public void User_click_sort_button() throws Exception {
    	projectspage.Click_sort_button();
    }
    
    @And("User sort the list recently updated of projects")
    public void User_sort_the_list_recently_updated_of_projects() {
    	projectspage.Sort_recently_updated();
    }
    
    @Then("Recently updated projects list get displayed successfully")
    public void Recently_updated_projects_list_get_displayed_successfully() {
    	projectspage.display_Sort_recently_updated();
    } 
    
    @And("User sort the list recently added of projects")
    public void User_sort_the_list_recently_added_of_projects() {
    	projectspage.Sort_recently_added();
    }
    
    @Then("Recently added projects list get displayed successfully")
    public void Recently_added_projects_list_get_displayed_successfully() {
    	projectspage.display_Sort_recently_added();
    }
    
    @And("User sort the list Name A to Z of projects")
    public void User_sort_the_list_A_to_Z_of_projects() {
    	projectspage.Sort_Name_A_to_Z ();
    }
    
    @Then("Name A to Z projects list get displayed successfully")
    public void Name_A_to_Z_projects_list_get_displayed_successfully() {
    	projectspage.display_Sort_Name_A_to_Z ();
    }
    
    @And("User sort the list Name Z to A of projects")
    public void User_sort_the_list_Z_to_A_of_projects() {
    	projectspage.Sort_Name_Z_to_A ();
    }
    
    @Then("Name Z to A projects list get displayed successfully")
    public void Name_Z_to_A_projects_list_get_displayed_successfully() {
    	projectspage.display_Sort_Name_Z_to_A ();
    }
    
    @And("User sort the list Decending Date of projects")
    public void User_sort_the_list_Decending_Date_of_projects() {
    	projectspage.Sort_Decending_Date ();
    }
    
    @Then("Decending Date projects list get displayed successfully")
    public void Decending_Date_projects_list_get_displayed_successfully() {
    	projectspage.display_Sort_Decending_Date ();
    }
    
    @And("User Onclicks Download Button")
    public void User_Onclicks_Download_Button() {
    	projectspage.Onclicks_Download_Button ();
    }
    
    @Then("Projects page get downloaded successfully")
    public void Projects_page_get_downloaded_successfully() {
    	projectspage.Downloaded_Projects ();
    }
    
    @And("User click on kebab menu of any project")
    public void User_click_on_kebab_menu_of_any_project() {
    	projectspage.Onclicks_kebabu_menu ();
    }
    
    @And("User clicks Edit")
    public void User_clicks_Edit() {
    	projectspage.Onclicks_Edit ();
    }
    
    @And("User Edit any Project")
    public void User_Edit_any_Project() {
    	projectspage.User_Update_projectname ();
    }
    
    @And("User click on edit projects button")
    public void User_click_on_edit_projects_button() {
    	projectspage.User_clicks_edit_projects ();
    }
    
    @And("User clicks next page button")
    public void User_clicks_next_page_button() throws Exception {
    	projectspage.Next_page_icon_click ();
    }
    
    @And("User clicks previous page button")
    public void User_clicks_previous_page_button() throws Exception {
    	projectspage.Previous_pageicon_click ();
    }
    
    @Then("First page should be displayed successfully")
    public void First_page_should_be_displayed_successfully() {
    	projectspage.Display_FirstPage ();
    }
    
}