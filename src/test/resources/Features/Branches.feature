Feature: Branches
Admin, Manager and Supervisor can able to access the Posters feature, if they are get the roles access only

@Branches @Branches01 @smoke @regression @all
Scenario Outline: To verify Branches listing page
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Branches  
Then Branches page should display successfully  

@Branches @Branches02 @smoke @regression @all
Scenario Outline: To verify Search a Branch
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Branches  
And User Type in search field     
Then Searched details get displayed successfully 

@Branches @Branches03 @smoke @regression @all
Scenario Outline: To verify Sort Recently updated  
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Branches  
And User click sort button in the Posters page  
And User sort the recently updated list  
Then Recently updated page get displayed successfully 

@Branches @Branches04 @smoke @regression @all
Scenario Outline: To verify Sort Recently Added
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Branches  
And User click sort button in the Posters page  
And User sort the recently added list 
Then Recently added page get displayed successfully 

@Branches @Branches05 @smoke @regression @all
Scenario Outline: To verify Sort Name A-Z 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Branches  
And User click sort button in the Posters page  
And User sort the Name A to Z list
Then Name A to Z page get displayed successfully 

@Branches @Branches06 @smoke @regression @all
Scenario Outline: To verify Sort Name Z-A 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Branches  
And User click sort button in the Posters page  
And User sort the Name Z to A list
Then Name Z to A page get displayed successfully  

@Branches @Branches07 @smoke @regression @all
Scenario Outline: To verify Sort Decending by Date 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Branches  
And User click sort button in the Posters page  
And User sort the Decending list Date of projects
Then Decending Date list get displayed successfully

@Branches @Branches08 @smoke @regression @all
Scenario Outline: To verify Sort Name A-Z 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Branches 
And User click on New Branch Button
And User Enter Mandatory fields of New Branch popup
And User Click on Add Branch Button   
Then Branch should be get created Successfully as "<successMessage>"
 Examples:
      | successMessage       |
      | Success Added Branch |
      
@Branches @Branches09 @smoke @regression @all
Scenario Outline: To verify Sort Name A-Z 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Branches 
And User click on kebab menu of any branch 
And User clicks on edit 
And User Updates any field of the Branch    
Then Branch should be get updated Successfully as "<successMessage>"
 Examples:
      | successMessage        |
      | Success Edited Branch |      



