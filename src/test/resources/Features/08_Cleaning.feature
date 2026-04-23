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
Then Dry Cleaning list get displayed successfully

@Cleaning @Cleaning12 @smoke @regression @all
Scenario Outline: T012_To verify the Cleaning feature filter Cleaning Type Wet 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User filter the Cleaning list status Wet
Then Wet Cleaning list get displayed successfully

@Cleaning @Cleaning13 @smoke @regression @all
Scenario Outline: T013_To verify the Cleaning feature filter the priority High
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User filter the Priority High status
Then Priority High Cleaning list get displayed successfully

@Cleaning @Cleaning14 @smoke @regression @all
Scenario Outline: T014_To verify the Cleaning feature filter the priority Medium
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User filter the Priority Medium status
Then Priority Medium Cleaning list get displayed successfully

@Cleaning @Cleaning15 @smoke @regression @all
Scenario Outline: T015_To verify the Cleaning feature filter the priority Low
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User filter the Priority Low status
Then Priority Low Cleaning list get displayed successfully

@Cleaning @Cleaning16 @smoke @regression @all
Scenario Outline: T016_To verify the Cleaning feature Multiple statuses filter
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User filter the multiple statuses
Then Multiple status Cleaning list get displayed successfully

@Cleaning @Cleaning17 @smoke @regression @all
Scenario Outline: T017_To verify the Cleaning feature filter Start Date
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User filter the Start Date
Then Cleaning from Start Date list get displayed successfully

@Cleaning @Cleaning18 @smoke @regression @all
Scenario Outline: T018_To verify the Cleaning feature filter Start Date and End date 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User filter the Start Date and End date
Then Cleaning from Start date and End date list get displayed successfully

@Cleaning @Cleaning19 @smoke @regression @all
Scenario Outline: T019_To verify the Cleaning feature filter by Assignee
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User filter the Assignee
Then Assignee cleaning list get displayed successfully

@Cleaning @Cleaning20 @smoke @regression @all
Scenario Outline: T020_To verify the Cleaning feature filter by Assignee
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User filter the Billboard Type cleaning
Then Billboard Type cleaning list get displayed successfully

@Cleaning @Cleaning21 @smoke @regression @all
Scenario Outline: T021_To verify the Cleaning feature Update the Group
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User click edit button
And User edit the Group name
And User Update the group and confirmed yes button 
Then Particular Group gets updated successfully as "<successMessage>"
  Examples:
      | successMessage         |
      | Success Group updated  |
@Cleaning @Cleaning22 @smoke @regression @all
Scenario Outline: T022_To verify the Cleaning feature Download button
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And Admin or user clicks the Download button in Cleaning page
Then Download popup get displayed successfully

@Cleaning @Cleaning23 @smoke @regression @all
Scenario Outline: T023_To verify the Cleaning feature Excel Download
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And Admin or user clicks the Download button in Cleaning page
And User click on Excel Download
Then Excel file get downloaded successfully

@Cleaning @Cleaning24 @smoke @regression @all
Scenario Outline: T024_To verify the Cleaning feature PDF Download
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And Admin or user clicks the Download button in Cleaning page
And User click on PDF Download
Then PDF file get downloaded successfully

@Cleaning @Cleaning25 @smoke @regression @all
Scenario Outline: T025_To verify the Cleaning feature display view Ticket page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User click edit button
And User click on View Ticket Tab
Then View Ticket page will display successfully

@Cleaning @Cleaning26 @smoke @regression @all
Scenario Outline: T026_To verify the Cleaning feature upload photos videos and voice
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User click edit button
And User click on View Ticket Tab
And User Click on Upload Photos videos and voice in View Ticket page
And User Update the group and confirmed yes button 
Then Particular Group gets updated successfully as "<successMessage>"
  Examples:
      | successMessage         |
      | Success Group updated  |

@Cleaning @Cleaning27 @smoke @regression @all
Scenario Outline: T027_To verify the Cleaning feature clicks close button of uploaded photo in view ticket page  
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User click edit button
And User click on View Ticket Tab
Then User Click on close button of uploaded photos and confirmed in view ticket page  

@Cleaning @Cleaning28 @smoke @regression @all
Scenario Outline: T028_To verify the Cleaning feature clicks close button of uploaded videos in view ticket page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User click edit button
And User click on View Ticket Tab
Then User Click on close button of uploaded videos and confirmed in view ticket page 

@Cleaning @Cleaning29 @smoke @regression @all
Scenario Outline: T029_To verify the Tickets feature start conversation in view ticket page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User click edit button
And User click on View Ticket Tab
And User clicks start conversation button in view ticket page 
Then Chat page will be displayed successfully 

@Cleaning @Cleaning30 @smoke @regression @all
Scenario Outline: T030_To verify the Tickets feature click 'Viewed' Tab  in Edit page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User click edit button
And User clicks Viewed Tab in Edit page
Then Viewed ticket Tab will be displayed successfully  

@Cleaning @Cleaning31 @smoke @regression @all
Scenario Outline: T031_To verify the Tickets feature click 'Overdue' Tab  in Edit page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User click edit button
And User clicks Overdue Tab in Edit page
Then Overdue ticket Tab will be displayed successfully 

@Cleaning @Cleaning32 @smoke @regression @all
Scenario Outline: T032_To verify the Tickets feature click 'Submitted' Tab  in Edit page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User click edit button
And User clicks Submitted Tab in Edit page
Then Submitted ticket Tab will be displayed successfully 

@Cleaning @Cleaning33 @smoke @regression @all
Scenario Outline: T033_To verify the Tickets feature click 'Verified' Tab in Edit page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User click edit button
And User clicks Verified Tab in Edit page
Then Verified ticket Tab will be displayed successfully 

@Cleaning @Cleaning34 @smoke @regression @all
Scenario Outline: T034_To verify the Tickets feature click 'Reassigned' Tab  in Edit page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User click edit button
And User clicks Reassigned Tab in Edit page
Then Reassigned ticket Tab will be displayed successfully 

@Cleaning @Cleaning35 @smoke @regression @all
Scenario Outline: T035_To verify the Tickets feature click 'Reassigned' Tab  in view ticket page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User click edit button
And User clicks Closed Tab in Edit page
Then Closed ticket Tab will be displayed successfully

@Cleaning @Cleaning36 @smoke @regression @all
Scenario Outline: T036_To verify the Cleaning feature pagination 1st to 2nd page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User click on second page button in the Cleaning module 
Then Second page of Cleaning get displayed successfully 

@Cleaning @Cleaning37 @smoke @regression @all
Scenario Outline: T037_To verify the Cleaning feature pagination next page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module 
And Go to Next page of Cleaning page
Then Next page Cleaning get displayed successfully  

@Cleaning @Cleaning38 @smoke @regression @all
Scenario Outline: T038_To verify the Cleaning feature pagination previous page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module 
And Go to Next page of Cleaning page 
And Go to Previous page of Cleaning page
Then Previous page Cleaning get displayed successfully 

@Cleaning @Cleaning39 @smoke @regression @all
Scenario Outline: T039_To verify the Cleaning feature pagination last page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And Go to Last page of Cleaning page
Then Last page Cleaning get displayed successfully   

@Cleaning @Cleaning40 @smoke @regression @all
Scenario Outline: T040_To verify the Cleaning feature pagination last page to first page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module 
And Go to Last page of Cleaning page
And User click on first page button of Cleaning
Then First page Cleaning get displayed successfully 

@Cleaning @Cleaning41 @smoke @regression @all
Scenario Outline: T041_To verify the Tickets feature click Edit icon in 'Created' Tab  in Edit page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Cleaning module
And User click edit button
And User clicks Edit icon in Created Ticket page
Then Cleaning edit page will redirect to the specified ticket page