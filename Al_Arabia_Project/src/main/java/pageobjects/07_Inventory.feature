Feature: Inventory
Admin, Manager and Supervisor can able to access the Inventory feature,only if they have roles access

@Inventory @Inventory01 @smoke @regression @all
Scenario Outline: T001_Verify Inventory page of Materials received from supplier
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
Then Al-Arabia Inventory page should display successfully

@Inventory @Inventory02 @regression @sanity @all
Scenario Outline: T002_Create the New Purchase with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the New Purchase button
And Admin or user enters the all mandatory fields of New Purchase
And Admin or user clicks the Add Purchase button 
Then Particular Purchase gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2              |
      | LOADING...            | Success Material info added  |

@Inventory @Inventory03 @smoke @regression @all
Scenario Outline: T003_ the Purchases feature search a Purchase by using Invoice id
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user search the Purchases
Then Searched Purchase details get displayed successfully

@Inventory @Inventory04 @smoke @regression @all
Scenario Outline: T004_To verify the Purchases feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display 
And Admin or user clicks the Inventory module
And Admin or user sort the Purchases list recently updated
Then Recently updated Purchases list get displayed successfully

@Inventory @Inventory05 @smoke @regression @all
Scenario Outline: T005_To verify the Purchases feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User sort the Purchases list Name A to Z
Then Purchases list get displayed successfully

@Inventory @Inventory06 @smoke @regression @all
Scenario Outline: T006_To verify the Purchases feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User sort the Purchases list Name Z to A 
Then Purchases list Z to A get displayed successfully

@Inventory @Inventory07 @smoke @regression @all
Scenario Outline: T007_To verify the Purchases feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User sort the Purchases list Recently Added
Then Recent Purchases list get displayed successfully

@Inventory @Inventory08 @smoke @regression @all
Scenario Outline: T008_To verify the Purchases feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User sort the Purchases list decending
Then Decending Purchases list get displayed successfully  

@Inventory @Inventory09 @smoke @regression @all
Scenario Outline: T009_To verify the Tickets feature Download button in inventory page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User clicks the Download button 
Then Purchase Download pop up will be displayed successfully

@Inventory @Inventory10 @smoke @regression @all
Scenario Outline: T010_To verify the Inventory feature Download as Excel Purchases
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User clicks the Download button with Download As Excel of Purchase list
      
@Inventory @Inventory11 @smoke @regression @all
Scenario Outline: T011_To verify the Inventory feature Download as PDF
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User clicks the Download button with Download As PDF for purchases
      
@Inventory @Inventory12 @smoke @regression @all
Scenario Outline: T012_To verify the Inventory feature Download popup close
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User clicks the Download button in inventory page after that click on close button 
Then The Download pop up get closed successfully and display the Inventory list

@Inventory @Inventory13 @regression @sanity @all
Scenario Outline: T013_To verify Purchase edit of any field
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module  
And User click on edit icon in all purchase page
And User edit the Project name
And User Click on Update Purchase button
Then Particular Purchase gets updated successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                |
      | LOADING...            | Success Material info updated  |
      
      