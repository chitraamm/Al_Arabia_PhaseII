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
      | successMessage1       | successMessage2           |
      | LOADING...            | Success Purchase created  |
      