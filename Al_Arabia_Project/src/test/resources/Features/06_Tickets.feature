Feature: Tickets
Admin, Manager and Supervisor can able to access the Tickets feature, if they are get the roles access only

@Tickets @Tickets01 @smoke @regression @all
Scenario Outline: T001_Verify Tickets page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
Then Al-Arabia Tickets page should display successfully

@Tickets @Tickets02 @regression @sanity @all
Scenario Outline: T002_Create the Ticket with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And Admin or user clicks the new Ticket button
And Admin or user enters the all mandatory fields
And Admin or user clicks the create Ticket
Then Particular Ticket gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2          |
      | LOADING...            | Success Ticket created   |

@Tickets @Tickets03 @smoke @regression @all
Scenario Outline: T003_ the Tickets feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And Admin or user search the Tickets
Then Searched Ticket details get displayed successfully

@Tickets @Tickets04 @smoke @regression @all
Scenario Outline: T004_To verify the Tickets feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And Admin or user sort the Tickets list recently updated
Then Recently updated Tickets list get displayed successfully

@Tickets @Tickets05 @smoke @regression @all
Scenario Outline: T005_To verify the Tickets feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User sort the Tickets list Name A to Z
Then Tickets list get displayed successfully

@Tickets @Tickets06 @smoke @regression @all
Scenario Outline: T006_To verify the Tickets feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User sort the billboards list Name Z to A 
Then Tickets list Z to A get displayed successfully

@Tickets @Tickets07 @smoke @regression @all
Scenario Outline: T007_To verify the Tickets feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User sort the Tickets list Recently Added
Then Recent Tickets list get displayed successfully

@Tickets @Tickets08 @smoke @regression @all
Scenario Outline: T008_To verify the Tickets feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User sort the Tickets list decending
Then Decending Tickets list get displayed successfully

@Tickets @Tickets09 @smoke @regression @all
Scenario Outline: T009_To verify the Tickets feature filter Closed status Tickets
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User filter the Tickets list status Closed
Then Closed Tickets list get displayed successfully
      
@Tickets @Tickets10 @smoke @regression @all
Scenario Outline: T0010_To verify the Tickets feature filter Created status Tickets
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User filter the Tickets list status Created
Then Created Tickets list get displayed successfully  

@Tickets @Tickets11 @smoke @regression @all
Scenario Outline: T0011_To verify the Tickets feature filter Reassigned status Tickets
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User filter the Tickets list status Reassigned
Then Reassigned Tickets list get displayed successfully   

@Tickets @Tickets12 @smoke @regression @all
Scenario Outline: T0012_To verify the Tickets feature filter Submitted status Tickets
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User filter the Tickets list status Submitted
Then Submitted Tickets list get displayed successfully 

@Tickets @Tickets13 @smoke @regression @all
Scenario Outline: T0013_To verify the Tickets feature filter Verified status Tickets
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User filter the Tickets list status Verified
Then Verified Tickets list get displayed successfully 

@Tickets @Tickets14 @smoke @regression @all
Scenario Outline: T0014_To verify the Tickets feature filter Viewed status Tickets
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User filter the Tickets list status Viewed
Then Viewed Tickets list get displayed successfully 

@Tickets @Tickets15 @smoke @regression @all
Scenario Outline: T0015_To verify the Tickets feature filter Overdue status Tickets
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User filter the Tickets list status Overdue
Then Overdue Tickets list get displayed successfully

@Tickets @Tickets16 @smoke @regression @all
Scenario Outline: T0016_To verify the Tickets feature filter multiple status Tickets
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User selected all statuses and submitted
Then multiple status Tickets list get displayed successfully

@Tickets @Tickets17 @smoke @regression @all
Scenario Outline: T017_To verify the Tickets feature filter select BillBoard number
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User selects billboard number
Then Selected BillBoard number list get displayed successfully

@Tickets @Tickets18 @smoke @regression @all
Scenario Outline: T018_To verify the Tickets feature filter select Assignee
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User selects Assignee
Then Selected Assignee list get displayed successfully

@Tickets @Tickets19 @smoke @regression @all
Scenario Outline: T019_To verify the Tickets feature filter select city
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User selects city
Then Selected city list get displayed successfully     

@Tickets @Tickets20 @smoke @regression @all
Scenario Outline: T020_To verify the Tickets feature filter select Department
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User selects Department
Then Selected Department list get displayed successfully 

@Tickets @Tickets21 @smoke @regression @all
Scenario Outline: T021_To verify the Tickets feature filter Cleaning
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User Clicks Cleaning Tickets
Then Cleaning Tickets list get displayed successfully 

@Tickets @Tickets22 @smoke @regression @all
Scenario Outline: T022_To verify the Tickets feature filter Non Cleaning
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User Clicks Cleaning Tickets
And User Clicks Non Cleaning Tickets
Then Cleaning Tickets list get displayed successfully 

@Tickets @Tickets23 @smoke @regression @all
Scenario Outline: T023_To verify the Tickets feature Download button
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User clicks the Download button 
Then Download pop up will be displayed successfully
