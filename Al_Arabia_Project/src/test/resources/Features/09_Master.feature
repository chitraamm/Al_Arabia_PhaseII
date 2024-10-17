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
      
 @Master @Supplier01 @smoke @regression @all
Scenario Outline: T001_Verify Supplier page display
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
Then Al Arabia Supplier page should display successfully

@Master @Supplier02 @regression @sanity @all
Scenario Outline: T002_Create the New Supplier with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User click on New Supplier button
And User Enter Mandatory fields of New Supplier page
#Then Particular Supplier gets created successfully with either "<successMessage1>" or "<successMessage2>"
  #Examples:
      #| successMessage1       | successMessage2                       |
      #| LOADING...            | Success Added Supplier successfully |      
@Master @Supplier03 @smoke @regression @all
Scenario Outline: T003_ the Supplier feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Supplier
And Admin or user search the Supplier
Then Searched Ticket details get displayed successfully

@Master @Supplier04 @smoke @regression @all
Scenario Outline: T004_To verify the Supplier feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Supplier
And Admin or user sort the Supplier list recently updated
Then Recently updated Supplier list get displayed successfully

@Master @Supplier05 @smoke @regression @all
Scenario Outline: T005_To verify the Supplier feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Supplier
And User sort the Supplier list Name A to Z
Then Supplier list get displayed successfully

@Master @Supplier06 @smoke @regression @all
Scenario Outline: T006_To verify the Supplier feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Supplier
And User sort the Supplier list Name Z to A 
Then Supplier list Z to A get displayed successfully

@Master @Supplier07 @smoke @regression @all
Scenario Outline: T007_To verify the Supplier feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Supplier
And User sort the Supplier list Recently Added
Then Recent Supplier list get displayed successfully

@Master @Supplier08 @smoke @regression @all
Scenario Outline: T008_To verify the Supplier feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Supplier
And User sort the Supplier list decending
Then Decending Supplier list get displayed successfully

@Master @Supplier09 @smoke @regression @all
Scenario Outline: T009_To verify the Supplier Edit
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Supplier
And User click on kebab menu of Supplier
And User selects Edit option of Supplier
And User Updated Supplier 
Then Particular Supplier gets Edited successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                        |
      | LOADING...            | Success Edited Supplier successfully | 
      
@Master @Supplier10 @smoke @regression @all
Scenario Outline: T010_To verify the Supplier Delete
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Supplier
And User click on kebab menu
And User clicked Delete Supplier option 
Then Particular Supplier gets Deleted successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2              |
      | LOADING...            | Success Deleted successfully |  
      
          