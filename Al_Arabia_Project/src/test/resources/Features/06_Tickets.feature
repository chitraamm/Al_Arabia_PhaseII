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
And Admin or user clicks the billboards module
And User sort the Tickets list Recently Added
Then Recent Tickets list get displayed successfully

@Tickets @Tickets08 @smoke @regression @all
Scenario Outline: T008_To verify the Tickets feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User sort the Tickets list decending
Then Decending Tickets list get displayed successfully
      