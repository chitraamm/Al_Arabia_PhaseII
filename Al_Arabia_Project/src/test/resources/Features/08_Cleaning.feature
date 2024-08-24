Feature: Cleaning
Admin, Manager and Supervisor can able to access the Cleaning feature,only if they have roles access

@Cleaning @Cleaning01 @smoke @regression @all
Scenario Outline: T001_Verify Cleaning page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
Then Al-Arabia Cleaning page should display successfully

@Cleaning @Cleaning02 @regression @sanity @all
Scenario Outline: T002_Create the New Group with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And Admin or user clicks the New Group button
And Admin or user enters the all mandatory fields of New Group
And Admin or user clicks the Create Group button 
Then Particular Group gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2        |
      | LOADING...            | Success Group Created  |

@Cleaning @Cleaning03 @smoke @regression @all
Scenario Outline: T003_ the Purchases feature search a Group by Group name
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And Admin or user search the Group
Then Searched Purchase details get displayed successfully

@Cleaning @Cleaning04 @smoke @regression @all
Scenario Outline: T004_To verify the Purchases feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And Admin or user sort the Purchases list recently updated
Then Recently updated Purchases list get displayed successfully

@Cleaning @Cleaning05 @smoke @regression @all
Scenario Outline: T005_To verify the Purchases feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User sort the Purchases list Name A to Z
Then Purchases list get displayed successfully

@Cleaning @Cleaning06 @smoke @regression @all
Scenario Outline: T006_To verify the Purchases feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User sort the billboards list Name Z to A 
Then Purchases list Z to A get displayed successfully

@Cleaning @Cleaning07 @smoke @regression @all
Scenario Outline: T007_To verify the Purchases feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User sort the Purchases list Recently Added
Then Recent Purchases list get displayed successfully

@Cleaning @Cleaning08 @smoke @regression @all
Scenario Outline: T008_To verify the Purchases feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User sort the Purchases list decending
Then Decending Purchases list get displayed successfully 

@Cleaning @Cleaning09 @smoke @regression @all
Scenario Outline: T009_To verify the Cleaning feature filter shedule Type Automatic cleaning 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User filter the Cleaning list status Automatic
Then Automatic Cleaning list get displayed successfully

@Cleaning @Cleaning10 @smoke @regression @all
Scenario Outline: T010_To verify the Cleaning feature filter shedule Type Manual cleaning 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User filter the Cleaning list status Manual
Then Manual Cleaning list get displayed successfully

@Cleaning @Cleaning11 @smoke @regression @all
Scenario Outline: T011_To verify the Cleaning feature filter Cleaning Type Dry 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User filter the Cleaning list status Dry
Then Automatic Cleaning list get displayed successfully

@Cleaning @Cleaning12 @smoke @regression @all
Scenario Outline: T012_To verify the Cleaning feature filter Cleaning Type Wet 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User filter the Cleaning list status Dry
Then Automatic Cleaning list get displayed successfully