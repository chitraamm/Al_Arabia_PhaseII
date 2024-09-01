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

@Inventory @Inventory22 @MaterialRequest @smoke @regression @all
Scenario Outline: T022_Verify the Inventory feature Material Request page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
Then Material Request page should display successfully

@Inventory @Inventory23 @MaterialRequest @regression @sanity @all
Scenario Outline: T023_Create the New Material Request with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And Admin or user clicks the New Request button
And Admin or user enters the all mandatory fields of Material Request
And Admin or user clicks the Add Request button 
Then Particular Request gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                 |
      | LOADING...            | Success Material Request added  |

@Inventory @Inventory24 @MaterialRequest @smoke @regression @all
Scenario Outline: T024_ The Inventory feature search a Material Request by Material Id	
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And Admin or user search a Material Request
Then Searched Material Request details get displayed successfully

@Inventory @Inventory25 @MaterialRequest @smoke @regression @all
Scenario Outline: T025_To verify the Material Request feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display 
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And Admin or user sort the Material Request list recently updated
Then Recently updated Material Request list get displayed successfully

@Inventory @Inventory26 @MaterialRequest @smoke @regression @all
Scenario Outline: T026_To verify the Material Request feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User sort the Material Request list Name A to Z
Then Material Request list get displayed successfully

@Inventory @Inventory27 @MaterialRequest @smoke @regression @all
Scenario Outline: T027_To verify the Material Request feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User sort the Material Request list Name Z to A 
Then Material Request list Z to A get displayed successfully

@Inventory @Inventory28 @MaterialRequest @smoke @regression @all
Scenario Outline: T028_To verify the Material Request feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User sort the Material Request list Recently Added
Then Recent Material Request list get displayed successfully

@Inventory @Inventory29 @MaterialRequest @smoke @regression @all
Scenario Outline: T029_To verify the Material Request feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User sort the Material Request list decending 
Then Decending Material Request list get displayed successfully  

@Inventory @Inventory30 @MaterialRequest @smoke @regression @all
Scenario Outline: T030_To verify the Material Request feature Download button
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User clicks the Download button in Material Request page 
Then Download pop up of Material Request will be displayed successfully

@Inventory @Inventory31 @MaterialRequest @smoke @regression @all
Scenario Outline: T031_To verify the Material Request feature Download as Excel 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User clicks the Download button with Download As Excel of Material Request list
      
@Inventory @Inventory32 @MaterialRequest @smoke @regression @all
Scenario Outline: T032_To verify the Material Request feature Download as PDF
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User clicks the Download button with Download As PDF for Material Request
      
@Inventory @Inventory33 @MaterialRequest @smoke @regression @all
Scenario Outline: T033_To verify the Material Request feature Download popup close
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User clicks the Download button in Material Request page after that click on close button 
Then The Download pop up get closed successfully and display the Material Request list

#@Inventory @Inventory34 @MaterialRequest @regression @sanity @all
#Scenario Outline: T034_To verify Purchase edit of any field
#Given Admin logged in with valid credentials
#When Al-Arabia overall dashboard should display
#And Admin or user clicks the Inventory module  
#And User click on edit icon in all Material page
#And User edit the City name
#And User Click on Update Material button
#Then Particular Material gets updated successfully with either "<successMessage1>" or "<successMessage2>"
  #Examples:
      #| successMessage1       | successMessage2                |
      #| LOADING...            | Success Material info updated  |
      
@Inventory @Inventory35 @MaterialRequest @regression @sanity @all
Scenario Outline: T035_To verify Material Request edit of any field
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Request Tab   
And User click on Material Request view option of kebab menu 
Then Particular Material Request viewed with details successfully

@Inventory @Inventory36 @MaterialRequest @regression @sanity @all
Scenario Outline: T036_To verify Material Request edit of any field
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Request Tab      
And User click on Material Request Delete option in kebab menu and confirm Yes
Then Material Request deleted popup will be displayed successfully as "<successMessage>"
 Examples:
      | successMessage 			         	 |
      | Success Material info deleted  |   
      
@Inventory @Inventory37 @MaterialRequest @smoke @regression @all
Scenario Outline: T037_To verify the Material Request feature pagination 1st to 2nd page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab    
And User click on second page button of Material Request page
Then Second page Material Request get displayed successfully    

@Inventory @Inventory38 @MaterialRequest @smoke @regression @all
Scenario Outline: T038_To verify the Material request feature pagination next page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Request Tab   
And Go to Next page of Material Request page
Then Next page Material Request get displayed successfully  

@Inventory @Inventory39 @MaterialRequest @smoke @regression @all
Scenario Outline: T039_To verify the Material Request feature pagination previous page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Request Tab   
And Go to Next page of Material Request page 
And Go to Previous page of Material Request
Then Previous page Material Request get displayed successfully 

@Inventory @Inventory40 @MaterialRequest @smoke @regression @all
Scenario Outline: T040_To verify the Material Request feature pagination last page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab   
And Go to Last page of Material Request page
Then Last page Material Request get displayed successfully   

@Inventory @Inventory41 @MaterialRequest @smoke @regression @all
Scenario Outline: T041_To verify the Material Request feature pagination last page to first page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Request Tab   
And Go to Last page of Material Request page
And User click on first page button of Material Request
Then First page Material Request get displayed successfully  

@Inventory @Inventory42 @MaterialIssued @smoke @regression @all
Scenario Outline: T042_Verify the Inventory feature Material Issued page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
Then Material Issued page should display successfully

@Inventory @Inventory43 @MaterialIssued @smoke @regression @all
Scenario Outline: T043_ The Material Issued feature search a Purchase by Material Id	
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And Admin or user search a Material Issued
Then Searched Material Issued details get displayed successfully

@Inventory @Inventory44 @MaterialIssued @smoke @regression @all
Scenario Outline: T044_To verify the Material Issued feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display 
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And Admin or user sort the Material Issued list recently updated
Then Recently updated Purchases list get displayed successfully

@Inventory @Inventory45 @MaterialIssued @smoke @regression @all
Scenario Outline: T045_To verify the Material Issued feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User sort the Material Issued list Name A to Z
Then Material Issued list get displayed successfully

@Inventory @Inventory46 @MaterialIssued @smoke @regression @all
Scenario Outline: T046_To verify the Material Issued feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User sort the Material Issued list Name Z to A 
Then Material Issued list Z to A get displayed successfully

@Inventory @Inventory47 @MaterialIssued @smoke @regression @all
Scenario Outline: T047_To verify the Material Issued feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User sort the Material Issued list Recently Added
Then Recent Material Issued list get displayed successfully

@Inventory @Inventory48 @MaterialIssued @smoke @regression @all
Scenario Outline: T048_To verify the Material Issued feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User sort the Material Issued Request list decending 
Then Decending Material Issued list get displayed successfully  

@Inventory @Inventory49 @MaterialIssued @smoke @regression @all
Scenario Outline: T049_To verify the Material Issued feature Download button
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User clicks the Download button in Material Issued page 
Then Download pop up of Material Issued will be displayed successfully

@Inventory @Inventory50 @MaterialIssued @smoke @regression @all
Scenario Outline: T050_To verify the Material Issued feature Download as Excel 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User clicks the Download button with Download As Excel of Material Issued list
      
@Inventory @Inventory51 @MaterialIssued @smoke @regression @all
Scenario Outline: T051_To verify the Material Issued feature Download as PDF
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User clicks the Download button with Download As PDF for Material Issued
      
@Inventory @Inventory52 @MaterialIssued @smoke @regression @all
Scenario Outline: T052_To verify the Material Issued feature Download popup close
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User clicks the Download button in Material Issued page after that click on close button 
Then The Download pop up get closed successfully and display the Material Issued list
    
@Inventory @Inventory53 @MaterialIssued @regression @sanity @all
Scenario Outline: T053_To verify Material Issued edit of any field
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Issued Tab   
And User click on Material Issued view option of kebab menu 
Then Particular Material Issued viewed with details successfully
   
@Inventory @Inventory54 @MaterialIssued @smoke @regression @all
Scenario Outline: T054_To verify the Material Issued feature pagination 1st to 2nd page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab    
And User click on second page button of Material Issued page
Then Second page Material Issued get displayed successfully    

@Inventory @Inventory55 @MaterialIssued @smoke @regression @all
Scenario Outline: T055_To verify the Material Issued feature pagination next page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Issued Tab   
And Go to Next page of Material Issued page
Then Next page Material Issued get displayed successfully  

@Inventory @Inventory57 @MaterialIssued @smoke @regression @all
Scenario Outline: T057_To verify the Material Issued feature pagination previous page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Issued Tab   
And Go to Next page of Material Issued page 
And Go to Previous page of Material Issued
Then Previous page Material Issued get displayed successfully 

@Inventory @Inventory58 @MaterialIssued @smoke @regression @all
Scenario Outline: T058_To verify the Material Issued feature pagination last page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab   
And Go to Last page of Material Issued page
Then Last page Material Issued get displayed successfully   

@Inventory @Inventory59 @MaterialIssued @smoke @regression @all
Scenario Outline: T059_To verify the Material Issued feature pagination last page to first page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Issued Tab   
And Go to Last page of Material Issued page
And User click on first page button of Material Issued
Then First page Material Issued get displayed successfully  

@Inventory @Inventory60 @DamageRec.Technician01 @smoke @regression @all
Scenario Outline: T060_Verify the Inventory01 feature Damage Rec.Technician page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Damage Rec.Technician Tab
Then Damage Rec.Technician page should display successfully

@Inventory @Inventory61 @DamageRec.Technician02 @regression @sanity @all
Scenario Outline: T002_Create the New Damage Rec.Technician with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should displa
And Admin or user clicks the Inventory module
And Admin or user clicks the Damage Rec.Technician Tab
And Admin or user clicks the New Request button
And Admin or user enters the all mandatory fields of Damage Rec.Technician
And Admin or user clicks the Add Request button 
Then Particular Request gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                 |
      | LOADING...            | Success Damage Rec.Technician added  |

@Inventory @Inventory62 @DamageRec.Technician03 @smoke @regression @all
Scenario Outline: T062_ The Inventory feature search a Damage Rec.Technician by Material Id	
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Damage Rec.Technician Tab
And Admin or user search a Damage Rec.Technician
Then Searched Damage Rec.Technician details get displayed successfully

@Inventory @Inventory25 @DamageRec.Technician @smoke @regression @all
Scenario Outline: T025_To verify the Damage Rec.Technician feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display 
And Admin or user clicks the Inventory module
And Admin or user clicks the Damage Rec.Technician Tab
And Admin or user sort the Damage Rec.Technician list recently updated
Then Recently updated Damage Rec.Technician list get displayed successfully

@Inventory @Inventory26 @DamageRec.Technician @smoke @regression @all
Scenario Outline: T026_To verify the Damage Rec.Technician feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Damage Rec.Technician Tab
And User sort the Damage Rec.Technician list Name A to Z
Then Damage Rec.Technician list get displayed successfully

@Inventory @Inventory27 @DamageRec.Technician @smoke @regression @all
Scenario Outline: T027_To verify the Damage Rec.Technician feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Damage Rec.Technician Tab
And User sort the Damage Rec.Technician list Name Z to A 
Then Damage Rec.Technician list Z to A get displayed successfully

@Inventory @Inventory28 @DamageRec.Technician @smoke @regression @all
Scenario Outline: T028_To verify the Damage Rec.Technician feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Damage Rec.Technician Tab
And User sort the Damage Rec.Technician list Recently Added
Then Recent Damage Rec.Technician list get displayed successfully

@Inventory @Inventory29 @DamageRec.Technician @smoke @regression @all
Scenario Outline: T029_To verify the Damage Rec.Technician feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Damage Rec.Technician Tab
And User sort the Damage Rec.Technician list decending 
Then Decending Damage Rec.Technician list get displayed successfully  

@Inventory @Inventory30 @DamageRec.Technician @smoke @regression @all
Scenario Outline: T030_To verify the Damage Rec.Technician feature Download button
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Damage Rec.Technician Tab
And User clicks the Download button in Damage Rec.Technician page 
Then Download pop up of Damage Rec.Technician will be displayed successfully

@Inventory @Inventory31 @DamageRec.Technician @smoke @regression @all
Scenario Outline: T031_To verify the Damage Rec.Technician feature Download as Excel 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Damage Rec.Technician Tab
And User clicks the Download button with Download As Excel of Damage Rec.Technician list
      
@Inventory @Inventory32 @DamageRec.Technician @smoke @regression @all
Scenario Outline: T032_To verify the Damage Rec.Technician feature Download as PDF
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Damage Rec.Technician Tab
And User clicks the Download button with Download As PDF for Damage Rec.Technician
      
@Inventory @Inventory33 @DamageRec.Technician @smoke @regression @all
Scenario Outline: T033_To verify the Damage Rec.Technician feature Download popup close
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Damage Rec.Technician Tab
And User clicks the Download button in Damage Rec.Technician page after that click on close button 
Then The Download pop up get closed successfully and display the Damage Rec.Technician list

#@Inventory @Inventory34 @DamageRec.Technician @regression @sanity @all
#Scenario Outline: T034_To verify Purchase edit of any field
#Given Admin logged in with valid credentials
#When Al-Arabia overall dashboard should display
#And Admin or user clicks the Inventory module  
#And User click on edit icon in all Material page
#And User edit the City name
#And User Click on Update Material button
#Then Particular Material gets updated successfully with either "<successMessage1>" or "<successMessage2>"
  #Examples:
      #| successMessage1       | successMessage2                |
      #| LOADING...            | Success Material info updated  |
      
@Inventory @Inventory35 @DamageRec.Technician @regression @sanity @all
Scenario Outline: T035_To verify Damage Rec.Technician edit of any field
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Damage Rec.Technician Tab   
And User click on Damage Rec.Technician view option of kebab menu 
Then Particular Damage Rec.Technician viewed with details successfully

@Inventory @Inventory36 @DamageRec.Technician @regression @sanity @all
Scenario Outline: T036_To verify Damage Rec.Technician edit of any field
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Damage Rec.Technician Tab      
And User click on Damage Rec.Technician Delete option in kebab menu and confirm Yes
Then Damage Rec.Technician deleted popup will be displayed successfully as "<successMessage>"
 Examples:
      | successMessage 			         	 |
      | Success Material info deleted  |   
      
@Inventory @Inventory37 @DamageRec.Technician @smoke @regression @all
Scenario Outline: T037_To verify the Damage Rec.Technician feature pagination 1st to 2nd page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Damage Rec.Technician Tab    
And User click on second page button of Damage Rec.Technician page
Then Second page Damage Rec.Technician get displayed successfully    

@Inventory @Inventory38 @DamageRec.Technician @smoke @regression @all
Scenario Outline: T038_To verify the Material request feature pagination next page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Damage Rec.Technician Tab   
And Go to Next page of Damage Rec.Technician page
Then Next page Damage Rec.Technician get displayed successfully  

@Inventory @Inventory39 @DamageRec.Technician @smoke @regression @all
Scenario Outline: T039_To verify the Damage Rec.Technician feature pagination previous page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Damage Rec.Technician Tab   
And Go to Next page of Damage Rec.Technician page 
And Go to Previous page of Damage Rec.Technician
Then Previous page Damage Rec.Technician get displayed successfully 

@Inventory @Inventory40 @DamageRec.Technician @smoke @regression @all
Scenario Outline: T040_To verify the Damage Rec.Technician feature pagination last page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Damage Rec.Technician Tab   
And Go to Last page of Damage Rec.Technician page
Then Last page Damage Rec.Technician get displayed successfully   

@Inventory @Inventory41 @DamageRec.Technician @smoke @regression @all
Scenario Outline: T041_To verify the Damage Rec.Technician feature pagination last page to first page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Damage Rec.Technician Tab   
And Go to Last page of Damage Rec.Technician page
And User click on first page button of Damage Rec.Technician
Then First page Damage Rec.Technician get displayed successfully  
    