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