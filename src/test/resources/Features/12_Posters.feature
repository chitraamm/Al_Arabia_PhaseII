Feature: Posters
Admin, Manager and Supervisor can able to access the Posters feature, if they are get the roles access only

@Posters @Posters01 @smoke @regression @all
Scenario Outline: To verify Posters listing page
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Posters  
Then Posters Page should display successfully   

@Posters @Posters02 @smoke @regression @all
Scenario Outline: To verify Search a Poster 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Posters   
And User Type in search field     
Then Searched details get displayed successfully  

@Posters @Posters03 @smoke @regression @all
Scenario Outline: To verify Search a Poster 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Posters   
And User click sort button in the Posters page  
And User sort the recently updated list  
Then Recently updated page get displayed successfully  

@Posters @Posters04 @smoke @regression @all
Scenario Outline: To verify Sort Recently Added 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Posters   
And User click sort button in the Posters page  
And User sort the recently added list 
Then Recently added page get displayed successfully 

@Posters @Posters05 @smoke @regression @all
Scenario Outline: To verify Sort Recently Updated 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Posters   
And User click sort button in the Posters page 
And User sort the recently updated list
Then Recently updated page get displayed successfully 

@Posters @Posters06 @smoke @regression @all
Scenario Outline: To verify feature sort Name A-Z 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Posters   
And User click sort button in the Posters page 
And User sort the Name A to Z list
Then Name A to Z page get displayed successfully   

@Posters @Posters07 @smoke @regression @all
Scenario Outline: To verify feature sort Name Z-A 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Posters   
And User click sort button in the Posters page 
And User sort the Name Z to A list
Then Name Z to A page get displayed successfully  

@Posters @Posters08 @smoke @regression @all
Scenario Outline: To verify feature sort Decending 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Posters   
And User click sort button in the Posters page 
And User sort the Decending list Date of projects
Then Decending Date list get displayed successfully 

@Posters @Posters09 @smoke @regression @all
Scenario Outline: To verify feature Create Poster 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Posters 
And User click on New Poster 
And User Enter Mandatory fields of New Poster 
And User Upload Poster Image 
And User Click on Add Poster Button     
Then Poster should be get created Successfully as "<successMessage>"
 Examples:
      | successMessage        |
      | Success Added Poster  |

@Posters @Posters10 @smoke @regression @all
Scenario Outline: To verify Poster Edit
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Posters 
And User click on kebab menu of any poster
And User clicks on edit 
And User Updates any field of the Poster 
Then User Updates any field of the Poster "<successMessage>"
 Examples:
      | successMessage        |
      | Success Edited Poster |  
      
@Posters @Posters11 @smoke @regression @all
Scenario Outline: To verify Poster Printing page 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile 
And Admin or user clicks the inventory from the Profile
And User click on Poster Printing 
Then Poster Printing page should display 

@Posters @Posters12 @smoke @regression @all
Scenario Outline: To verify 'New Store Transfer' in the Poster Printing page 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile 
And Admin or user clicks the inventory from the Profile
And User click on Poster Printing 
And User Clicks New Poster Printing button  
And User Enter mandatory fields of New Poster Printing  
And User clicks Create button  
Then New Poster should be get printed as per the Request "<successMessage>"
 Examples:
      | successMessage         |
      | Success Poster created |  







 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

@Posters @Posters1232 @smoke @regression @all
Scenario Outline: To verify Poster Printing page when do Filter by Requested Status 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile 
And Admin or user clicks the inventory from the Profile
And User click on Poster Printing
Then Poster Printing page should display   
   
          

 


