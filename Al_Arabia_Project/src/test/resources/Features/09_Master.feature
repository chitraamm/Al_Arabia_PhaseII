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
Scenario Outline: T008_To verify the Department Edit
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User click on kebab menu
And User selects Edit option 
And User Updated Department 
Then Department get Edited successfully
