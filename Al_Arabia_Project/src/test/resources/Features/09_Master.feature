Feature: Master
Admin, Manager and Supervisor can able to access the Master feature,only if they have roles access

@Master @Master01 @smoke @regression @all
Scenario Outline: T001_Verify Master page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master module
Then Al-Arabia Master page should display successfully

@Master @Master02 @regression @sanity @all
Scenario Outline: T002_Create the Ticket with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master module
And Admin or user clicks the new Ticket button
And Admin or user enters the all mandatory fields
And Admin or user clicks the create Ticket
Then Particular Ticket gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2           |
      | LOADING...            | Success Ticket created    | 
      
@Master @Master03 @smoke @regression @all
Scenario Outline: T003_ the Master feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master module
And Admin or user search the Master
Then Searched Ticket details get displayed successfully

@Master @Master04 @smoke @regression @all
Scenario Outline: T004_To verify the Master feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master module
And Admin or user sort the Master list recently updated
Then Recently updated Master list get displayed successfully

@Master @Master05 @smoke @regression @all
Scenario Outline: T005_To verify the Master feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master module
And User sort the Master list Name A to Z
Then Master list get displayed successfully

@Master @Master06 @smoke @regression @all
Scenario Outline: T006_To verify the Master feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master module
And User sort the billboards list Name Z to A 
Then Master list Z to A get displayed successfully

@Master @Master07 @smoke @regression @all
Scenario Outline: T007_To verify the Master feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master module
And User sort the Master list Recently Added
Then Recent Master list get displayed successfully

@Master @Master08 @smoke @regression @all
Scenario Outline: T008_To verify the Master feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master module
And User sort the Master list decending
Then Decending Master list get displayed successfully