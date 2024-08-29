Feature: Inventory
Admin, Manager and Supervisor can able to access the Inventory feature,only if they have roles access

@Inventory @Inventory01 @smoke @regression @all
Scenario Outline: T001_Verify Inventory page of Materials received from supplier
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
      | successMessage1       | successMessage2              |
      | LOADING...            | Success Material info added  |

@Inventory @Inventory03 @smoke @regression @all
Scenario Outline: T003_ the Purchases feature search a Purchase by using Invoice id
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user search the Purchases
Then Searched Purchase details get displayed successfully

@Inventory @Inventory04 @smoke @regression @all
Scenario Outline: T004_To verify the Purchases feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display 
And Admin or user clicks the Inventory module
And Admin or user sort the Purchases list recently updated
Then Recently updated Purchases list get displayed successfully

@Inventory @Inventory05 @smoke @regression @all
Scenario Outline: T005_To verify the Purchases feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User sort the Purchases list Name A to Z
Then Purchases list get displayed successfully

@Inventory @Inventory06 @smoke @regression @all
Scenario Outline: T006_To verify the Purchases feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User sort the Purchases list Name Z to A 
Then Purchases list Z to A get displayed successfully

@Inventory @Inventory07 @smoke @regression @all
Scenario Outline: T007_To verify the Purchases feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User sort the Purchases list Recently Added
Then Recent Purchases list get displayed successfully

@Inventory @Inventory08 @smoke @regression @all
Scenario Outline: T008_To verify the Purchases feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User sort the Purchases list decending
Then Decending Purchases list get displayed successfully  

@Inventory @Inventory09 @smoke @regression @all
Scenario Outline: T009_To verify the Inventory feature Download button in inventory page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User clicks the Download button 
Then Purchase Download pop up will be displayed successfully

@Inventory @Inventory10 @smoke @regression @all
Scenario Outline: T010_To verify the Inventory feature Download as Excel Purchases
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User clicks the Download button with Download As Excel of Purchase list
      
@Inventory @Inventory11 @smoke @regression @all
Scenario Outline: T011_To verify the Inventory feature Download as PDF
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User clicks the Download button with Download As PDF for purchases
      
@Inventory @Inventory12 @smoke @regression @all
Scenario Outline: T012_To verify the Inventory feature Download popup close
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And User clicks the Download button in inventory page after that click on close button 
Then The Download pop up get closed successfully and display the Inventory list

@Inventory @Inventory13 @regression @sanity @all
Scenario Outline: T013_To verify Purchase edit of any field
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module  
And User click on edit icon in all purchase page
And User edit the Project name
And User Click on Update Purchase button
Then Particular Purchase gets updated successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                |
      | LOADING...            | Success Material info updated  |
      
@Inventory @Inventory14 @regression @sanity @all
Scenario Outline: T014_To verify Purchase edit of any field
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module    
And User click on view option in kebab menu
Then Particular parchase get displayed successfully

@Inventory @Inventory15 @regression @sanity @all
Scenario Outline: T015_To verify Purchase edit of any field
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module    
And User click on Delete option in kebab menu and confirm Yes
Then Purchase deleted popup will be displayed successfully as "<successMessage>"
 Examples:
      | successMessage 			         	 |
      | Success Material info deleted  |   
      
@Inventory @Inventory16 @smoke @regression @all
Scenario Outline: T016_To verify the Inventory feature pagination 1st to 2nd page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And User click on second page button of Inventory page
Then Second page Inventory get displayed successfully    

@Inventory @Inventory17 @smoke @regression @all
Scenario Outline: T017_To verify the Inventory feature pagination next page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Go to Next page of Inventory page
Then Next page Inventory get displayed successfully  

@Inventory @Inventory18 @smoke @regression @all
Scenario Outline: T018_To verify the Inventory feature pagination previous page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Go to Next page of Inventory page 
And Go to Previous page of Inventory page
Then Previous page Inventory get displayed successfully 

@Inventory @Inventory19 @smoke @regression @all
Scenario Outline: T019_To verify the Inventory feature pagination last page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Go to Last page of Inventory page
Then Last page Inventory get displayed successfully   

@Inventory @Inventory20 @smoke @regression @all
Scenario Outline: T020_To verify the Inventory feature pagination last page to first page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Go to Last page of Inventory page
And User click on first page button of inventory
Then First page Inventory get displayed successfully 
      
@Inventory @Inventory21 @smoke @regression @all
Scenario Outline: T021_To verify the Inventory feature start conversation in Inventory page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And User clicks start conversation button in Inventory page
Then The chat page will be displayed successfully 

@Inventory @Inventory22 @smoke @regression @all
Scenario Outline: T022_Verify Inventory page of Material Request 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
Then Material Request page should display successfully

@Inventory @Inventory23 @regression @sanity @all
Scenario Outline: T023_Create the New Material Request with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the New Purchase button
And Admin or user enters the all mandatory fields of New Purchase
And Admin or user clicks the Add Purchase button 
Then Particular Purchase gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2              |
      | LOADING...            | Success Material info added  |

@Inventory @Inventory24 @smoke @regression @all
Scenario Outline: T024_ the Purchases feature search a Purchase by Material Id	
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And Admin or user search a Material
Then Searched Material details get displayed successfully

@Inventory @Inventory25 @smoke @regression @all
Scenario Outline: T025_To verify the Purchases feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display 
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And Admin or user sort the Purchases list recently updated
Then Recently updated Purchases list get displayed successfully

@Inventory @Inventory26 @smoke @regression @all
Scenario Outline: T026_To verify the Purchases feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User sort the Purchases list Name A to Z
Then Purchases list get displayed successfully

@Inventory @Inventory27 @smoke @regression @all
Scenario Outline: T027_To verify the Purchases feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User sort the Purchases list Name Z to A 
Then Purchases list Z to A get displayed successfully

@Inventory @Inventory28 @smoke @regression @all
Scenario Outline: T028_To verify the Purchases feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User sort the Purchases list Recently Added
Then Recent Purchases list get displayed successfully

@Inventory @Inventory29 @smoke @regression @all
Scenario Outline: T029_To verify the Purchases feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User sort the Purchases list decending
Then Decending Purchases list get displayed successfully  

@Inventory @Inventory30 @smoke @regression @all
Scenario Outline: T030_To verify the Inventory feature Download button in Material page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User clicks the Download button in Material page 
Then Download pop up of Material will be displayed successfully

@Inventory @Inventory31 @smoke @regression @all
Scenario Outline: T031_To verify the Inventory feature Download as Excel Material
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User clicks the Download button with Download As Excel of Material list
      
@Inventory @Inventory32 @smoke @regression @all
Scenario Outline: T032_To verify the Material feature Download as PDF
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User clicks the Download button with Download As PDF for Materials
      
@Inventory @Inventory33 @smoke @regression @all
Scenario Outline: T033_To verify the Material feature Download popup close
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User clicks the Download button in Material page after that click on close button 
Then The Download pop up get closed successfully and display the Material list

#@Inventory @Inventory34 @regression @sanity @all
#Scenario Outline: T034_To verify Purchase edit of any field
#Given Admin logged in with valid credentials
#When Al-Arabia overall dashboard should display
#And Admin or user clicks the Inventory module  
#And User click on edit icon in all purchase page
#And User edit the Project name
#And User Click on Update Purchase button
#Then Particular Purchase gets updated successfully with either "<successMessage1>" or "<successMessage2>"
  #Examples:
      #| successMessage1       | successMessage2                |
      #| LOADING...            | Success Material info updated  |
      #
#@Inventory @Inventory35 @regression @sanity @all
#Scenario Outline: T035_To verify Purchase edit of any field
#Given Admin logged in with valid credentials
#When Al-Arabia overall dashboard should display
#And Admin or user clicks the Inventory module    
#And User click on view option in kebab menu
#Then Particular parchase get displayed successfully
#
#@Inventory @Inventory36 @regression @sanity @all
#Scenario Outline: T015_To verify Material edit of any field
#Given Admin logged in with valid credentials
#When Al-Arabia overall dashboard should display
#And Admin or user clicks the Inventory module    
#And User click on Delete option in kebab menu and confirm Yes
#Then Material deleted popup will be displayed successfully as "<successMessage>"
 #Examples:
      #| successMessage 			         	 |
      #| Success Material info deleted  |   
      #
#@Inventory @Inventory16 @smoke @regression @all
#Scenario Outline: T016_To verify the Inventory feature pagination 1st to 2nd page 
#Given Admin logged in with valid credentials
#When Al-Arabia overall dashboard should display
#And Admin or user clicks the Inventory module 
#And User click on second page button of Inventory page
#Then Second page Inventory get displayed successfully    
#
#@Inventory @Inventory17 @smoke @regression @all
#Scenario Outline: T017_To verify the Inventory feature pagination next page 
#Given Admin logged in with valid credentials
#When Al-Arabia overall dashboard should display
#And Admin or user clicks the Inventory module 
#And Go to Next page of Inventory page
#Then Next page Inventory get displayed successfully  
#
#@Inventory @Inventory18 @smoke @regression @all
#Scenario Outline: T018_To verify the Inventory feature pagination previous page 
#Given Admin logged in with valid credentials
#When Al-Arabia overall dashboard should display
#And Admin or user clicks the Inventory module 
#And Go to Next page of Inventory page 
#And Go to Previous page of Inventory page
#Then Previous page Inventory get displayed successfully 
#
#@Inventory @Inventory19 @smoke @regression @all
#Scenario Outline: T019_To verify the Inventory feature pagination last page 
#Given Admin logged in with valid credentials
#When Al-Arabia overall dashboard should display
#And Admin or user clicks the Inventory module
#And Go to Last page of Inventory page
#Then Last page Inventory get displayed successfully   
#
#@Inventory @Inventory20 @smoke @regression @all
#Scenario Outline: T020_To verify the Inventory feature pagination last page to first page
#Given Admin logged in with valid credentials
#When Al-Arabia overall dashboard should display
#And Admin or user clicks the Inventory module 
#And Go to Last page of Inventory page
#And User click on first page button of inventory
#Then First page Inventory get displayed successfully      