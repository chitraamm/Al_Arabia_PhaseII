Feature: Projects
Admin, Manager and Supervisor can able to access the projects feature, if they are get the roles access only

@Projects @Projects01 @smoke @regression @all
Scenario Outline: To verify projects listing page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the Projects   
Then Projects page should display successfully

@Projects @Projects02 @smoke @regression @all
Scenario Outline: To verify the projects feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the Projects
And User search a project     
Then Searched Project details get displayed successfully  

@Projects @Projects03 @smoke @regression @all
Scenario Outline: To verify the projects feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the Projects 
And User click sort button 
And User sort the list recently updated of projects 
Then Recently updated projects list get displayed successfully 

@Projects @Projects04 @smoke @regression @all
Scenario Outline: T004_To verify the projects feature sort recently added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the Projects 
And User click sort button 
And User sort the list recently added of projects  
Then Recently added projects list get displayed successfully 

@Projects @Projects05 @smoke @regression @all
Scenario Outline: T004_To verify the projects feature sort Name A-Z 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the Projects 
And User click sort button 
And User sort the list Name A to Z of projects   
Then Name A to Z projects list get displayed successfully 

@Projects @Projects06 @smoke @regression @all
Scenario Outline: To verify the projects feature sort Name Z-A 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the Projects 
And User click sort button  
And User sort the list Name Z to A of projects   
Then Name Z to A projects list get displayed successfully 

@Projects @Projects07 @smoke @regression @all
Scenario Outline: To verify the projects feature sort Decendingg Date 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the Projects 
And User click sort button  
And User sort the list Decending Date of projects   
Then Decending Date projects list get displayed successfully 

@Projects @Projects08 @smoke @regression @all
Scenario Outline: To verify the projects feature sort Decending Date 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the Projects 
And User Onclicks Download Button 
Then Projects page get downloaded successfully

@Projects @Projects09 @smoke @regression @all
Scenario Outline: To verify the projects feature with update any Project 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the Projects 
And User click on kebab menu of any project
And User clicks Edit  
And User Edit any Project 
And User click on edit projects button

@Projects @Projects10 @smoke @regression @all
Scenario Outline: To verify the projects Next page button 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the Projects 
And User clicks next page button 
Then Second page get displayed successfully

@Projects @Projects11 @smoke @regression @all
Scenario Outline: To verify the projects Previous page button 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the Projects 
And User clicks next page button
And User clicks previous page button 
Then First page should be displayed successfully 

