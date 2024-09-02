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

@Inventory @MaterialRequest01 @smoke @regression @all
Scenario Outline: T_MaterialRequest01_Verify the Inventory feature Material Request page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
Then Material Request page should display successfully

@Inventory @MaterialRequest02 @regression @sanity @all
Scenario Outline: T_MaterialRequest02_Create the New Material Request with valid inputs
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

@Inventory @MaterialRequest03 @smoke @regression @all
Scenario Outline: T_MaterialRequest03_The Inventory feature search a Material Request by Material Id	
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And Admin or user search a Material Request
Then Searched Material Request details get displayed successfully

@Inventory @MaterialRequest04 @smoke @regression @all
Scenario Outline: T_MaterialRequest04_To verify the Material Request feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display 
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And Admin or user sort the Material Request list recently updated
Then Recently updated Material Request list get displayed successfully

@Inventory @MaterialRequest05 @smoke @regression @all
Scenario Outline: T_MaterialRequest05_To verify the Material Request feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User sort the Material Request list Name A to Z
Then Material Request list get displayed successfully

@Inventory @MaterialRequest06 @smoke @regression @all
Scenario Outline: T_MaterialRequest06_To verify the Material Request feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User sort the Material Request list Name Z to A 
Then Material Request list Z to A get displayed successfully

@Inventory @MaterialRequest07 @smoke @regression @all
Scenario Outline: T_MaterialRequest07_To verify the Material Request feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User sort the Material Request list Recently Added
Then Recent Material Request list get displayed successfully

@Inventory @MaterialRequest08 @smoke @regression @all
Scenario Outline: T_MaterialRequest08_To verify the Material Request feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User sort the Material Request list decending 
Then Decending Material Request list get displayed successfully  

@Inventory @MaterialRequest09 @smoke @regression @all
Scenario Outline: T_MaterialRequest09_To verify the Material Request feature Download button
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User clicks the Download button in Material Request page 
Then Download pop up of Material Request will be displayed successfully

@Inventory @MaterialRequest10 @smoke @regression @all
Scenario Outline: T_MaterialRequest10_To verify the Material Request feature Download as Excel 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User clicks the Download button with Download As Excel of Material Request list
      
@Inventory @MaterialRequest11 @smoke @regression @all
Scenario Outline: T_MaterialRequest11_To verify the Material Request feature Download as PDF
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User clicks the Download button with Download As PDF for Material Request
      
@Inventory @MaterialRequest12 @smoke @regression @all
Scenario Outline: T_MaterialIssued12_To verify the Material Request feature Download popup close
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab
And User clicks the Download button in Material Request page after that click on close button 
Then The Download pop up get closed successfully and display the Material Request list

#@Inventory @MaterialRequest13 @regression @sanity @all
#Scenario Outline: T_MaterialRequest13_To verify Purchase edit of any field
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
      
@Inventory @MaterialRequest14 @regression @sanity @all
Scenario Outline: T_MaterialRequest14_To verify Material Request View
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Request Tab   
And User click on Material Request view option of kebab menu 
Then Particular Material Request viewed with details successfully

@Inventory @MaterialRequest15 @regression @sanity @all
Scenario Outline: T_MaterialRequest15_To verify Material Request Delete
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Request Tab      
And User click on Material Request Delete option in kebab menu and confirm Yes
Then Material Request deleted popup will be displayed successfully as "<successMessage>"
 Examples:
      | successMessage 			         	 |
      | Success Material info deleted  |   
      
@Inventory @MaterialRequest16 @smoke @regression @all
Scenario Outline: T_MaterialRequest16_To verify the Material Request feature pagination 1st to 2nd page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab    
And User click on second page button of Material Request page
Then Second page Material Request get displayed successfully    

@Inventory @MaterialRequest17 @smoke @regression @all
Scenario Outline: T_MaterialRequest17_To verify the Material request feature pagination next page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Request Tab   
And Go to Next page of Material Request page
Then Next page Material Request get displayed successfully  

@Inventory @MaterialRequest18 @smoke @regression @all
Scenario Outline: T_MaterialRequest18_To verify the Material Request feature pagination previous page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Request Tab   
And Go to Next page of Material Request page 
And Go to Previous page of Material Request
Then Previous page Material Request get displayed successfully 

@Inventory @MaterialRequest19 @smoke @regression @all
Scenario Outline: T_MaterialRequest19_To verify the Material Request feature pagination last page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Request Tab   
And Go to Last page of Material Request page
Then Last page Material Request get displayed successfully   

@Inventory @MaterialRequest20 @smoke @regression @all
Scenario Outline: T_MaterialRequest20_To verify the Material Request feature pagination last page to first page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Request Tab   
And Go to Last page of Material Request page
And User click on first page button of Material Request
Then First page Material Request get displayed successfully  

@Inventory @MaterialIssued01 @smoke @regression @all
Scenario Outline: T_MaterialIssued01_Verify the Inventory feature Material Issued page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
Then Material Issued page should display successfully

@Inventory @MaterialIssued02 @smoke @regression @all
Scenario Outline: T_MaterialIssued02_The Material Issued feature search a Purchase by Material Id	
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And Admin or user search a Material Issued
Then Searched Material Issued details get displayed successfully

@Inventory @MaterialIssued03 @smoke @regression @all
Scenario Outline: T_MaterialIssued03_To verify the Material Issued feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display 
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And Admin or user sort the Material Issued list recently updated
Then Recently updated Purchases list get displayed successfully

@Inventory @MaterialIssued04 @smoke @regression @all
Scenario Outline: T_MaterialIssued04_To verify the Material Issued feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User sort the Material Issued list Name A to Z
Then Material Issued list get displayed successfully

@Inventory @MaterialIssued05 @smoke @regression @all
Scenario Outline: T_MaterialIssued05_To verify the Material Issued feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User sort the Material Issued list Name Z to A 
Then Material Issued list Z to A get displayed successfully

@Inventory @MaterialIssued06 @smoke @regression @all
Scenario Outline: T_MaterialIssued06_To verify the Material Issued feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User sort the Material Issued list Recently Added
Then Recent Material Issued list get displayed successfully

@Inventory @MaterialIssued07 @smoke @regression @all
Scenario Outline: T_MaterialIssued07_To verify the Material Issued feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User sort the Material Issued Request list decending 
Then Decending Material Issued list get displayed successfully  

@Inventory @MaterialIssued08 @smoke @regression @all
Scenario Outline: T_MaterialIssued08_To verify the Material Issued feature Download button
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User clicks the Download button in Material Issued page 
Then Download pop up of Material Issued will be displayed successfully

@Inventory @MaterialIssued09 @smoke @regression @all
Scenario Outline: T_MaterialIssued09_To verify the Material Issued feature Download as Excel 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User clicks the Download button with Download As Excel of Material Issued list
      
@Inventory @MaterialIssued10 @smoke @regression @all
Scenario Outline: T_MaterialIssued10_To verify the Material Issued feature Download as PDF
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User clicks the Download button with Download As PDF for Material Issued
      
@Inventory @MaterialIssued11 @smoke @regression @all
Scenario Outline: T_MaterialIssued11_To verify the Material Issued feature Download popup close
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab
And User clicks the Download button in Material Issued page after that click on close button 
Then The Download pop up get closed successfully and display the Material Issued list
    
@Inventory @MaterialIssued12 @regression @sanity @all
Scenario Outline: T_MaterialIssued12_To verify Material Issued edit of any field
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Issued Tab   
And User click on Material Issued view option of kebab menu 
Then Particular Material Issued viewed with details successfully
   
@Inventory @MaterialIssued13 @smoke @regression @all
Scenario Outline: T_MaterialIssued13_To verify the Material Issued feature pagination 1st to 2nd page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab    
And User click on second page button of Material Issued page
Then Second page Material Issued get displayed successfully    

@Inventory @MaterialIssued14 @smoke @regression @all
Scenario Outline: T_MaterialIssued14_To verify the Material Issued feature pagination next page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Issued Tab   
And Go to Next page of Material Issued page
Then Next page Material Issued get displayed successfully  

@Inventory @MaterialIssued15 @smoke @regression @all
Scenario Outline: T_MaterialIssued15_To verify the Material Issued feature pagination previous page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Issued Tab   
And Go to Next page of Material Issued page 
And Go to Previous page of Material Issued
Then Previous page Material Issued get displayed successfully 

@Inventory @MaterialIssued16 @smoke @regression @all
Scenario Outline: T_MaterialIssued16_To verify the Material Issued feature pagination last page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the Material Issued Tab   
And Go to Last page of Material Issued page
Then Last page Material Issued get displayed successfully   

@Inventory @MaterialIssued17 @smoke @regression @all
Scenario Outline: T_MaterialIssued17_To verify the Material Issued feature pagination last page to first page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the Material Issued Tab   
And Go to Last page of Material Issued page
And User click on first page button of Material Issued
Then First page Material Issued get displayed successfully  

@Inventory @DamageRec.Technician01 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician01_Verify the Inventory01 feature DamageRecTechnician page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRecTechnician Tab
Then DamageRecTechnician page should display successfully

@Inventory @DamageRec.Technician02 @regression @sanity @all
Scenario Outline: T_DamageRec.Technician02_Create the New Return with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRecTechnician Tab
And Admin or user clicks the New Return button in DamageRecTechnician
And Admin or user enters the all mandatory fields of DamageRecTechnician
And Admin or user clicks the Add Return button 
Then Particular Return received from Technician gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                 |
      | LOADING...            | Success DamageRecTechnician added  |

@Inventory @DamageRec.Technician03 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician03_The Inventory feature search a DamageRecTechnician by Billboard Id	
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRecTechnician Tab
And Admin or user search a DamageRecTechnician
Then Searched DamageRecTechnician details get displayed successfully

@Inventory @DamageRec.Technician04 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician04_To verify the DamageRecTechnician feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display 
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRecTechnician Tab
And Admin or user sort the DamageRecTechnician list recently updated
Then Recently updated DamageRecTechnician list get displayed successfully

@Inventory @DamageRec.Technician05 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician05_To verify the DamageRecTechnician feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRecTechnician Tab
And User sort the DamageRecTechnician list Name A to Z
Then DamageRecTechnician list get displayed successfully

@Inventory @DamageRec.Technician06 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician06_To verify the DamageRecTechnician feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRecTechnician Tab
And User sort the DamageRecTechnician list Name Z to A 
Then DamageRecTechnician list Z to A get displayed successfully

@Inventory @DamageRec.Technician07 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician07_To verify the DamageRecTechnician feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRecTechnician Tab
And User sort the DamageRecTechnician list Recently Added
Then Recent DamageRecTechnician list get displayed successfully

@Inventory @DamageRec.Technician08 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician08_To verify the DamageRecTechnician feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRecTechnician Tab
And User sort the DamageRecTechnician list decending 
Then Decending DamageRecTechnician list get displayed successfully  

@Inventory @DamageRec.Technician09 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician09_To verify the DamageRecTechnician feature Download button
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRecTechnician Tab
And User clicks the Download button in DamageRecTechnician page 
Then Download pop up of DamageRecTechnician will be displayed successfully

@Inventory @DamageRec.Technician10 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician10_To verify the DamageRecTechnician feature Download as Excel 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRecTechnician Tab
And User clicks the Download button with Download As Excel of DamageRecTechnician list
      
@Inventory @DamageRec.Technician11 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician11_To verify the DamageRecTechnician feature Download as PDF
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRecTechnician Tab
And User clicks the Download button with Download As PDF for DamageRecTechnician
      
@Inventory @DamageRec.Technician12 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician12_To verify the DamageRecTechnician feature Download popup close
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRecTechnician Tab
And User clicks the Download button in DamageRecTechnician page after that click on close button 
Then The Download pop up get closed successfully and display the DamageRecTechnician list

@Inventory @DamageRec.Technician13 @regression @sanity @all
Scenario Outline: T_DamageRec.Technician13_To verify edit of any Return
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module  
And User click on edit icon in all Material page
And User edit the City name
And User Click on Update Material button
Then Particular Material gets updated successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                |
      | LOADING...            | Success Material info updated  |
      
@Inventory @DamageRec.Technician14 @regression @sanity @all
Scenario Outline: T_DamageRec.Technician14_To verify DamageRecTechnician edit of any field
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the DamageRecTechnician Tab   
And User click on DamageRecTechnician view option of kebab menu 
Then Particular DamageRecTechnician viewed with details successfully

@Inventory @DamageRec.Technician15 @regression @sanity @all
Scenario Outline: T_DamageRec.Technician15_To verify DamageRecTechnician edit of any field
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the DamageRecTechnician Tab      
And User click on DamageRecTechnician Delete option in kebab menu and confirm Yes
Then DamageRecTechnician deleted popup will be displayed successfully as "<successMessage>"
 Examples:
      | successMessage 			         	 |
      | Success Damage info deleted  |   
      
@Inventory @DamageRec.Technician16 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician16_To verify the DamageRecTechnician feature pagination 1st to 2nd page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRecTechnician Tab    
And User click on second page button of DamageRecTechnician page
Then Second page DamageRecTechnician get displayed successfully    

@Inventory @DamageRec.Technician17 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician17_To verify the Material request feature pagination next page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the DamageRecTechnician Tab   
And Go to Next page of DamageRecTechnician page
Then Next page DamageRecTechnician get displayed successfully  

@Inventory @DamageRec.Technician18 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician18_To verify the DamageRecTechnician feature pagination previous page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the DamageRecTechnician Tab   
And Go to Next page of DamageRecTechnician page 
And Go to Previous page of DamageRecTechnician
Then Previous page DamageRecTechnician get displayed successfully 

@Inventory @DamageRec.Technician19 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician19_To verify the DamageRecTechnician feature pagination last page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRecTechnician Tab   
And Go to Last page of DamageRecTechnician page
Then Last page DamageRecTechnician get displayed successfully   

@Inventory @DamageRec.Technician20 @smoke @regression @all
Scenario Outline: T_DamageRec.Technician20_To verify the DamageRecTechnician feature pagination last page to first page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the DamageRecTechnician Tab   
And Go to Last page of DamageRecTechnician page
And User click on first page button of DamageRecTechnician
Then First page DamageRecTechnician get displayed successfully  

@Inventory @DamageRet.supplier01 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier01_Verify the Inventory01 feature DamageRetSupplier page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRetSupplier Tab
Then DamageRetSupplier page should display successfully

@Inventory @DamageRet.supplier02 @regression @sanity @all
Scenario Outline: T_DamageRet.supplier02_Create the New Return with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRetSupplier Tab
And Admin or user clicks the New Return button in DamageRetSupplier
And Admin or user enters the all mandatory fields of DamageRetSupplier
And Admin or user clicks the Add Return button 
Then Particular Return received from Technician gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                 |
      | LOADING...            | Success DamageRetSupplier added  |

@Inventory @DamageRet.supplier03 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier03_The Inventory feature search a DamageRetSupplier by Billboard Id	
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRetSupplier Tab
And Admin or user search a DamageRetSupplier
Then Searched DamageRetSupplier details get displayed successfully

@Inventory @DamageRet.supplier04 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier04_To verify the DamageRetSupplier feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display 
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRetSupplier Tab
And Admin or user sort the DamageRetSupplier list recently updated
Then Recently updated DamageRetSupplier list get displayed successfully

@Inventory @DamageRet.supplier05 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier05_To verify the DamageRetSupplier feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRetSupplier Tab
And User sort the DamageRetSupplier list Name A to Z
Then DamageRetSupplier list get displayed successfully

@Inventory @DamageRet.supplier06 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier06_To verify the DamageRetSupplier feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRetSupplier Tab
And User sort the DamageRetSupplier list Name Z to A 
Then DamageRetSupplier list Z to A get displayed successfully

@Inventory @DamageRet.supplier07 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier07_To verify the DamageRetSupplier feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRetSupplier Tab
And User sort the DamageRetSupplier list Recently Added
Then Recent DamageRetSupplier list get displayed successfully

@Inventory @DamageRet.supplier08 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier08_To verify the DamageRetSupplier feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRetSupplier Tab
And User sort the DamageRetSupplier list decending 
Then Decending DamageRetSupplier list get displayed successfully  

@Inventory @DamageRet.supplier09 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier09_To verify the DamageRetSupplier feature Download button
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRetSupplier Tab
And User clicks the Download button in DamageRetSupplier page 
Then Download pop up of DamageRetSupplier will be displayed successfully

@Inventory @DamageRet.supplier10 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier10_To verify the DamageRetSupplier feature Download as Excel 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRetSupplier Tab
And User clicks the Download button with Download As Excel of DamageRetSupplier list
      
@Inventory @DamageRet.supplier11 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier11_To verify the DamageRetSupplier feature Download as PDF
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRetSupplier Tab
And User clicks the Download button with Download As PDF for DamageRetSupplier
      
@Inventory @DamageRet.supplier12 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier12_To verify the DamageRetSupplier feature Download popup close
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRetSupplier Tab
And User clicks the Download button in DamageRetSupplier page after that click on close button 
Then The Download pop up get closed successfully and display the DamageRetSupplier list

#@Inventory @DamageRet.supplier13 @regression @sanity @all
#Scenario Outline: T_DamageRet.supplier13_To verify edit of any Return
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
      #
@Inventory @DamageRet.supplier14 @regression @sanity @all
Scenario Outline: T_DamageRet.supplier14_To verify DamageRetSupplier edit of any field
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the DamageRetSupplier Tab   
And User click on DamageRetSupplier view option of kebab menu 
Then Particular DamageRetSupplier viewed with details successfully

#@Inventory @DamageRet.supplier15 @regression @sanity @all
#Scenario Outline: T_DamageRet.supplier15_To verify DamageRetSupplier edit of any field
#Given Admin logged in with valid credentials
#When Al-Arabia overall dashboard should display
#And Admin or user clicks the Inventory module 
#And Admin or user clicks the DamageRetSupplier Tab      
#And User click on DamageRetSupplier Delete option in kebab menu and confirm Yes
#Then DamageRetSupplier deleted popup will be displayed successfully as "<successMessage>"
 #Examples:
      #| successMessage 			         	 |
      #| Success Damage info deleted  |   
      #
@Inventory @DamageRet.supplier16 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier16_To verify the DamageRetSupplier feature pagination 1st to 2nd page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRetSupplier Tab    
And User click on second page button of DamageRetSupplier page
Then Second page DamageRetSupplier get displayed successfully    

@Inventory @DamageRet.supplier17 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier17_To verify the Material request feature pagination next page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the DamageRetSupplier Tab   
And Go to Next page of DamageRetSupplier page
Then Next page DamageRetSupplier get displayed successfully  

@Inventory @DamageRet.supplier18 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier18_To verify the DamageRetSupplier feature pagination previous page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the DamageRetSupplier Tab   
And Go to Next page of DamageRetSupplier page 
And Go to Previous page of DamageRetSupplier
Then Previous page DamageRetSupplier get displayed successfully 

@Inventory @DamageRet.supplier19 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier19_To verify the DamageRetSupplier feature pagination last page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module
And Admin or user clicks the DamageRetSupplier Tab   
And Go to Last page of DamageRetSupplier page
Then Last page DamageRetSupplier get displayed successfully   

@Inventory @DamageRet.supplier20 @smoke @regression @all
Scenario Outline: T_DamageRet.supplier20_To verify the DamageRetSupplier feature pagination last page to first page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Inventory module 
And Admin or user clicks the DamageRetSupplier Tab   
And Go to Last page of DamageRetSupplier page
And User click on first page button of DamageRetSupplier
Then First page DamageRetSupplier get displayed successfully  
    