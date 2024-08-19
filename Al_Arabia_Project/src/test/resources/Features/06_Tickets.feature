Feature: Tickets
Admin, Manager and Supervisor can able to access the Tickets feature,only if they have roles access

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
      | successMessage1       | successMessage2           |
      | LOADING...            | Success Ticket created    | 
      
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

@Tickets @Tickets24 @smoke @regression @all
Scenario Outline: T024_To verify the Tickets feature Download as Excel
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User clicks the Download button with Download As Excel
      
@Tickets @Tickets25 @smoke @regression @all
Scenario Outline: T025_To verify the Tickets feature Download as PDF
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User clicks the Download button with Download As PDF
      
@Tickets @Tickets26 @smoke @regression @all
Scenario Outline: T026_To verify the Tickets feature Download popup close
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User clicks the Download button after that click on close button 
Then The Download pop up get closed successfully and display the Tickets list      

@Tickets @Tickets27 @smoke @regression @all
Scenario Outline: T027_To verify the Tickets feature Edit button in Tickets page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And The User clicks the Edit button 
Then Edit Tickets page will be displayed successfully

@Tickets @Tickets28 @smoke @regression @all
Scenario Outline: T028_To verify the Tickets feature Delete button in Tickets page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And Admin or user clicks the new Ticket button
And Admin or user enters the all mandatory fields
And Admin or user clicks the create Ticket
And The User clicks on the Delete button with clicks confirm yes button
Then Tickets delete popup will be displayed successfully with either "<successMessage>"
 Examples:
      | successMessage   										 |
      | Success Ticket Deleted successfull   |  
      
@Tickets @Tickets29 @smoke @regression @all
Scenario Outline: T029_To verify the Tickets features Update a Ticket
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And The User clicks the Edit button 
And User edit Description 
And User click on Update Tickets button with confirm yes button
Then Ticket Updated popup will be displayed successfully as "<successMessage>"
  Examples:
      | successMessage     								  |
      | Success Tickets updated             |     
      
@Tickets @Tickets30 @smoke @regression @all
Scenario Outline: T030_To verify the Tickets feature Display Activity Feed in Edit Ticket page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And The User clicks the Edit button
And User click on Activity Feed Tab 
Then Activity Feed Tab page will be displayed successfully  

@Tickets @Tickets31 @smoke @regression @all
Scenario Outline: T031_To verify the Tickets feature upload photos videos and voice
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And The User clicks the Edit button 
And User Click on Upload Photos videos and voice
And User click on Update Tickets button with confirm yes button
Then Ticket Updated popup will be displayed successfully as "<successMessage>"
  Examples:
      | successMessage     								  |
      | Success Tickets updated             |  

@Tickets @Tickets32 @smoke @regression @all
Scenario Outline: T032_To verify the Tickets feature clicks close button of uploaded photo
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And The User clicks the Edit button 
Then User Click on close button of uploaded photos and confirmed

@Tickets @Tickets33 @smoke @regression @all
Scenario Outline: T033_To verify the Tickets feature clicks close button of uploaded videos
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User filter the Tickets list status Created
And The User clicks the Edit button 
Then User Click on close button of uploaded videos and confirmed
      
@Tickets @Tickets34 @smoke @regression @all
Scenario Outline: T033_To validate the Tickets feature 'verify'
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module 
And User filter the Tickets list status Submitted
And The User clicks the Edit button 
And User clicks verify button and confirm yes button
Then Ticket verified popup will be displayed successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2          |
      | LOADING...            | Success Ticket Verified  |
         
@Tickets @Tickets35 @smoke @regression @all
Scenario Outline: T035_To verify the Tickets feature Reassign a Ticket
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module 
And User filter the Tickets list status Submitted
And The User clicks the Edit button 
And User clicks Reassign button and confirm yes button
Then Ticket Reassigned popup will be displayed successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2            |
      | LOADING...            | Success Ticket reassigned  |
      
@Tickets @Tickets36 @smoke @regression @all
Scenario Outline: T036_To verify the Tickets feature Approve a Ticket
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module 
And User filter the Tickets list status Verified
And The User clicks the Edit button 
And User clicks Approve button and confirm yes button
Then Ticket Approved popup will be displayed successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2            |
      | LOADING...            | Success Ticket approved    | 
@Tickets @Tickets37 @smoke @regression @all
Scenario Outline: T037_To verify the Tickets feature Reject a Ticket 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module 
And User filter the Tickets list status Verified
And The User clicks the Edit button 
And User clicks Reject button and confirm yes button
Then Ticket Rejected popup will be displayed successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2            |
      | LOADING...            | Success Ticket rejected    | 
                        
@Tickets @Tickets38 @smoke @regression @all
Scenario Outline: T038_To verify the Tickets feature start conversation 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module 
And User filter the Tickets list status Created
And The User clicks the Edit button 
And User clicks start conversation button
Then chat page will be displayed successfully  
 
@Tickets @Tickets39 @smoke @regression @all
Scenario Outline: T039_To verify the Tickets feature pagination 1st to 2nd page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module 
And User click on second page button
Then Second page Tickets get displayed successfully    

@Tickets @Tickets40 @smoke @regression @all
Scenario Outline: T040_To verify the Tickets feature pagination next page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module 
And Go to Next page of Tickets page
Then Next page Tickets get displayed successfully  

@Tickets @Tickets41 @smoke @regression @all
Scenario Outline: T041_To verify the Tickets feature pagination previous page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module 
And Go to Next page of Tickets page 
And Go to Previous page of Tickets page
Then Previous page Tickets get displayed successfully 

@Tickets @Tickets42 @smoke @regression @all
Scenario Outline: T042_To verify the Tickets feature pagination last page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And Go to Last page of Tickets page
Then Last page Tickets get displayed successfully   

@Tickets @Tickets43 @smoke @regression @all
Scenario Outline: T043_To verify the Tickets feature pagination last page to first page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module 
And Go to Last page of Tickets page
And User click on first page button
Then First page Tickets get displayed successfully 

@Tickets @Tickets44 @smoke @regression @all
Scenario Outline: T044_To verify the Tickets features Reset the form changes
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And The User clicks the Edit button 
And User edit Description 
And User click on Reset button with confirm yes button
Then The ticket reset form changes are being done

@Tickets @Tickets45 @smoke @regression @all
Scenario Outline: T045_To verify the Tickets features 'Created' Tick mark displayed on Progress bar in View Tickets page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User filter the Tickets list status Viewed
And The User clicks the Edit icon
Then Created Tick mark should be displayed in Progress bar

@Tickets @Tickets46 @smoke @regression @all
Scenario Outline: T046_To verify the Tickets features 'Viewed' Tick mark displayed on Progress bar in View Tickets page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User filter the Tickets list status Submitted
And The User clicks the Edit icon
Then Viewed Tick mark should be displayed in Progress bar 

@Tickets @Tickets47 @smoke @regression @all
Scenario Outline: T047_To verify the Tickets features 'Submitted' Tick mark displayed on Progress bar in View Tickets page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User filter the Tickets list status Verified
And The User clicks the Edit icon
Then Submitted Tick mark should be displayed in Progress bar   

@Tickets @Tickets48 @smoke @regression @all
Scenario Outline: T048_To verify the Tickets features 'Overdued' Tick mark displayed on Progress bar in View Tickets page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User filter the Tickets list status Overdue
And The User clicks the Edit icon
Then Overdued Tick mark should be displayed in Progress bar 

@Tickets @Tickets49 @smoke @regression @all
Scenario Outline: T049_To verify the Tickets features 'Reassigned' Tick mark displayed on Progress bar in View Tickets page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User filter the Tickets list status Reassigned
And The User clicks the Edit icon
Then Reassigned Tick mark should be displayed in Progress bar 

@Tickets @Tickets50 @smoke @regression @all
Scenario Outline: T0050_To verify the Tickets feature filter Pending status Tickets
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Tickets module
And User filter the Tickets list status Pending
Then Pending Tickets list get displayed successfully  
       