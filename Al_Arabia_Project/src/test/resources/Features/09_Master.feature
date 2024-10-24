Feature: Master
Admin, Manager and Supervisor can able to access the Master features,only if they have roles access

@Master @Master01 @smoke @regression @all
Scenario Outline: T001_Verify Department page display
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
Then Al Arabia Department page should display successfully

@Master @Master02 @regression @sanity @all
Scenario Outline: T002_Create the Ticket with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User click on New Department button
And User Enter department name and clicks Add Department button
Then Particular department gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                       |
      | LOADING...            | Success Added Department successfully |      
@Master @Master03 @smoke @regression @all
Scenario Outline: T003_ the Department feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user search the Department
Then Searched Ticket details get displayed successfully

@Master @Master04 @smoke @regression @all
Scenario Outline: T004_To verify the Department feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user sort the Department list recently updated
Then Recently updated Department list get displayed successfully

@Master @Master05 @smoke @regression @all
Scenario Outline: T005_To verify the Department feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User sort the Department list Name A to Z
Then Department list get displayed successfully

@Master @Master06 @smoke @regression @all
Scenario Outline: T006_To verify the Department feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User sort the Department list Name Z to A 
Then Department list Z to A get displayed successfully

@Master @Master07 @smoke @regression @all
Scenario Outline: T007_To verify the Department feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User sort the Department list Recently Added
Then Recent Department list get displayed successfully

@Master @Master08 @smoke @regression @all
Scenario Outline: T008_To verify the Department feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User sort the Department list decending
Then Decending Department list get displayed successfully

@Master @Master09 @smoke @regression @all
Scenario Outline: T009_To verify the Department Edit
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User click on kebab menu
And User selects Edit option 
And User Updated Department 
Then Particular department gets Edited successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                        |
      | LOADING...            | Success Edited Department successfully | 
      
@Master @Master10 @smoke @regression @all
Scenario Outline: T010_To verify the Department Delete
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User click on kebab menu
And User clicked Delete Department option 
Then Particular department gets Deleted successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2              |
      | LOADING...            | Success Deleted successfully |  
      
 @Master @Supplier @Supplier01 @smoke @regression @all
Scenario Outline: T001_Verify Supplier page display
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
Then Al Arabia Supplier page should display successfully

@Master @Supplier @Supplier02 @regression @sanity @all
Scenario Outline: T002_Create the New Supplier with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User click on New Supplier button
And User Enter Mandatory fields of New Supplier page
And User click on Add Supplier button
Then Particular Supplier gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2        |
      | LOADING...            | Success Supplier Added |      
@Master @Supplier @Supplier03 @smoke @regression @all
Scenario Outline: T003_ the Supplier feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And Admin or user search the Supplier
Then Searched Ticket details get displayed successfully

@Master @Supplier @Supplier04 @smoke @regression @all
Scenario Outline: T004_To verify the Supplier feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And Admin or user sort the Supplier list recently updated
Then Recently updated Supplier list get displayed successfully

@Master @Supplier @Supplier05 @smoke @regression @all
Scenario Outline: T005_To verify the Supplier feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User sort the Supplier list Name A to Z
Then Supplier list get displayed successfully

@Master @Supplier @Supplier06 @smoke @regression @all 
Scenario Outline: T006_To verify the Supplier feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User sort the Supplier list Name Z to A 
Then Supplier list Z to A get displayed successfully

@Master @Supplier @Supplier07 @smoke @regression @all
Scenario Outline: T007_To verify the Supplier feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User sort the Supplier list Recently Added
Then Recent Supplier list get displayed successfully

@Master @Supplier @Supplier08 @smoke @regression @all
Scenario Outline: T008_To verify the Supplier feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User sort the Supplier list decending
Then Decending Supplier list get displayed successfully

@Master @Supplier @Supplier09 @smoke @regression @all
Scenario Outline: T009_To verify the Supplier Edit
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User click on kebab menu of Supplier
And User selects Edit option of Supplier
And User Updated Supplier 
Then Particular Supplier gets Edited successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2          |
      | LOADING...            | Success Supplier updated | 
     
@Master @Supplier @Supplier10 @smoke @regression @all
Scenario Outline: T010_To verify the Supplier View
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User click on kebab menu
And User clicked View Supplier option
Then Supplier page will be displayed to the user      
      
@Master @Supplier @Supplier11 @smoke @regression @all
Scenario Outline: T011_To verify the Supplier Delete
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User click on kebab menu
And User clicked Delete Supplier option 
Then Particular Supplier gets Deleted successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2          |
      | LOADING...            | Success Supplier deleted |  
 @Master @Stock @Stock01 @smoke @regression @all
Scenario Outline: T001_Verify Stock page display
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
Then Al Arabia Stock page should display successfully

@Master @Stock @Stock02 @regression @sanity @all
Scenario Outline: T002_Create the New Stock with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And User click on New Stock button
And User Enter Mandatory fields of New Stock page
And User click on Add Stock button
Then Particular Stock gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2        |
      | LOADING...            | Success Stock Added |      
@Master @Stock @Stock03 @smoke @regression @all
Scenario Outline: T003_ the Stock feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And Admin or user search the Stock
Then Searched Ticket details get displayed successfully

@Master @Stock @Stock04 @smoke @regression @all
Scenario Outline: T004_To verify the Stock feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And Admin or user sort the Stock list recently updated
Then Recently updated Stock list get displayed successfully

@Master @Stock @Stock05 @smoke @regression @all
Scenario Outline: T005_To verify the Stock feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And User sort the Stock list Name A to Z
Then Stock list get displayed successfully

@Master @Stock @Stock06 @smoke @regression @all 
Scenario Outline: T006_To verify the Stock feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And User sort the Stock list Name Z to A 
Then Stock list Z to A get displayed successfully

@Master @Stock @Stock07 @smoke @regression @all
Scenario Outline: T007_To verify the Stock feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And User sort the Stock list Recently Added
Then Recent Stock list get displayed successfully

@Master @Stock @Stock08 @smoke @regression @all
Scenario Outline: T008_To verify the Stock feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And User sort the Stock list decending
Then Decending Stock list get displayed successfully

@Master @Stock @Stock09 @smoke @regression @all
Scenario Outline: T009_To verify the Stock Edit
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And User click on kebab menu of Stock
And User selects Edit option of Stock
And User Updated Stock 
Then Particular Stock gets Edited successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2          |
      | LOADING...            | Success Stock updated | 
     
@Master @Stock @Stock10 @smoke @regression @all
Scenario Outline: T010_To verify the Stock View
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And User click on kebab menu of Stock
And User clicked View Stock option
Then Stock page will be displayed to the user      
      
 
      
	      
          