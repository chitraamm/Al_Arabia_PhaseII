Feature: Inventory
Admin, Manager and Supervisor can able to access the Inventory feature,only if they have roles access

@Inventory @Inventory01 @smoke @regression @all
Scenario Outline: T001_Verify Inventory page
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
And User sort the billboards list Name Z to A 
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