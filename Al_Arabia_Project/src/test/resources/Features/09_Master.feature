Feature: Master
Admin, Manager and Supervisor can able to access the Master features,only if they have roles access

@Master @Master01 @smoke @regression @all
Scenario Outline: T001_Verify Department page display
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
Then Al Arabia Department page should display successfully

@Master @Master02 @regression @sanity @all
Scenario Outline: T002_Create the Ticket with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User click on New Department button
And User Enter department name and clicks Add Department button
Then Particular department gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                       |
      | LOADING...            | Success Added Department successfully |      
@Master @Master03 @smoke @regression @all
Scenario Outline: T003_ the Department feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user search the Department
Then Searched Ticket details get displayed successfully

@Master @Master04 @smoke @regression @all
Scenario Outline: T004_To verify the Department feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user sort the Department list recently updated
Then Recently updated Department list get displayed successfully

@Master @Master05 @smoke @regression @all
Scenario Outline: T005_To verify the Department feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User sort the Department list Name A to Z
Then Department list get displayed successfully

@Master @Master06 @smoke @regression @all
Scenario Outline: T006_To verify the Department feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User sort the Department list Name Z to A 
Then Department list Z to A get displayed successfully

@Master @Master07 @smoke @regression @all
Scenario Outline: T007_To verify the Department feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User sort the Department list Recently Added
Then Recent Department list get displayed successfully

@Master @Master08 @smoke @regression @all
Scenario Outline: T008_To verify the Department feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User sort the Department list decending
Then Decending Department list get displayed successfully

@Master @Master09 @smoke @regression @all
Scenario Outline: T009_To verify the Department Edit
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User click on kebab menu
And User selects Edit option 
And User Updated Department 
Then Particular department gets Edited successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                        |
      | LOADING...            | Success Edited Department successfully | 
      
@Master @Master10 @smoke @regression @all
Scenario Outline: T010_To verify the Department Delete
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User click on kebab menu
And User clicked Delete Department option 
Then Particular department gets Deleted successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2              |
      | LOADING...            | Success Deleted successfully |  
      
 @Master @Supplier @Supplier01 @smoke @regression @all
Scenario Outline: T001_Verify Supplier page display
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
Then Al Arabia Supplier page should display successfully

@Master @Supplier @Supplier02 @regression @sanity @all
Scenario Outline: T002_Create the New Supplier with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User click on New Supplier button
And User Enter Mandatory fields of New Supplier page
And User click on Add Supplier button
Then Particular Supplier gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2        |
      | LOADING...            | Success Supplier Added |      
@Master @Supplier @Supplier03 @smoke @regression @all
Scenario Outline: T003_ the Supplier feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And Admin or user search the Supplier
Then Searched Ticket details get displayed successfully

@Master @Supplier @Supplier04 @smoke @regression @all
Scenario Outline: T004_To verify the Supplier feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And Admin or user sort the Supplier list recently updated
Then Recently updated Supplier list get displayed successfully

@Master @Supplier @Supplier05 @smoke @regression @all
Scenario Outline: T005_To verify the Supplier feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User sort the Supplier list Name A to Z
Then Supplier list get displayed successfully

@Master @Supplier @Supplier06 @smoke @regression @all 
Scenario Outline: T006_To verify the Supplier feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User sort the Supplier list Name Z to A 
Then Supplier list Z to A get displayed successfully

@Master @Supplier @Supplier07 @smoke @regression @all
Scenario Outline: T007_To verify the Supplier feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User sort the Supplier list Recently Added
Then Recent Supplier list get displayed successfully

@Master @Supplier @Supplier08 @smoke @regression @all
Scenario Outline: T008_To verify the Supplier feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User sort the Supplier list decending
Then Decending Supplier list get displayed successfully

@Master @Supplier @Supplier09 @smoke @regression @all
Scenario Outline: T009_To verify the Supplier Edit
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User click on kebab menu of Supplier
And User selects Edit option of Supplier
And User Updated Supplier 
Then Particular Supplier gets Edited successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2          |
      | LOADING...            | Success Supplier updated | 
     
@Master @Supplier @Supplier10 @smoke @regression @all
Scenario Outline: T010_To verify the Supplier View
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User click on kebab menu
And User clicked View Supplier option
Then Supplier page will be displayed to the user      
      
@Master @Supplier @Supplier11 @smoke @regression @all
Scenario Outline: T011_To verify the Supplier Delete
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Supplier
And User click on kebab menu
And User clicked Delete Supplier option 
Then Particular Supplier gets Deleted successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2          |
      | LOADING...            | Success Supplier deleted |  
 @Master @Stock @Stock01 @smoke @regression @all
Scenario Outline: T001_Verify Stock page display
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
Then Al Arabia Stock page should display successfully

@Master @Stock @Stock02 @regression @sanity @all
Scenario Outline: T002_Create the New Stock with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And User click on New Stock button
And User Enter Mandatory fields of New Stock page
And User click on Add Stock button  
Then Particular Stock gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2     |
      | LOADING...            | Success Stock added |  
          
@Master @Stock @Stock03 @smoke @regression @all
Scenario Outline: T003_ the Stock feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And Admin or user search the Stock
Then Searched Ticket details get displayed successfully

@Master @Stock @Stock04 @smoke @regression @all
Scenario Outline: T004_To verify the Stock feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And Admin or user sort the Stock list recently updated
Then Recently updated Stock list get displayed successfully

@Master @Stock @Stock05 @smoke @regression @all
Scenario Outline: T005_To verify the Stock feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And User sort the Stock list Name A to Z
Then Stock list get displayed successfully

@Master @Stock @Stock06 @smoke @regression @all 
Scenario Outline: T006_To verify the Stock feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And User sort the Stock list Name Z to A 
Then Stock list Z to A get displayed successfully

@Master @Stock @Stock07 @smoke @regression @all
Scenario Outline: T007_To verify the Stock feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And User sort the Stock list Recently Added
Then Recent Stock list get displayed successfully

@Master @Stock @Stock08 @smoke @regression @all
Scenario Outline: T008_To verify the Stock feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And User sort the Stock list decending
Then Decending Stock list get displayed successfully

@Master @Stock @Stock09 @smoke @regression @all
Scenario Outline: T009_To verify the Stock Edit
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And User click on kebab menu of Stock
And User selects Edit option of Stock
And User Updated Stock 
Then Particular Stock gets Edited successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2          |
      | LOADING...            | Success Stock updated | 
     
@Master @Stock @Stock10 @smoke @regression @all
Scenario Outline: T010_To verify the Stock View
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And Admin or user clicks the Stock
And User click on kebab menu of Stock
And User clicked View Stock option
Then Stock page will be displayed to the user      
      
@Master @TicketTitle @TicketTitle01 @smoke @regression @all
Scenario Outline: T001_Verify TicketTitle page display
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks TicketTitle
Then Al Arabia TicketTitle page should display successfully

@Master @TicketTitle @TicketTitle02 @regression @sanity @all
Scenario Outline: T002_Create the Ticket with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks TicketTitle
And User click on New TicketTitle button
And User Enter TicketTitle name and clicks Add TicketTitle button
Then Particular TicketTitle gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                       |
      | LOADING...            | Success Added TicketTitle successfully |      
@Master @TicketTitle @TicketTitle03 @smoke @regression @all
Scenario Outline: T003_ the TicketTitle feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks TicketTitle
And Admin or user search the TicketTitle
Then Searched Ticket details get displayed successfully

@Master @TicketTitle @TicketTitle04 @smoke @regression @all
Scenario Outline: T004_To verify the TicketTitle feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks TicketTitle
And Admin or user sort the TicketTitle list recently updated
Then Recently updated TicketTitle list get displayed successfully

@Master @TicketTitle @TicketTitle05 @smoke @regression @all
Scenario Outline: T005_To verify the TicketTitle feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks TicketTitle
And User sort the TicketTitle list Name A to Z
Then TicketTitle list get displayed successfully

@Master @TicketTitle @TicketTitle06 @smoke @regression @all
Scenario Outline: T006_To verify the TicketTitle feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks TicketTitle
And User sort the TicketTitle list Name Z to A 
Then TicketTitle list Z to A get displayed successfully

@Master @TicketTitle @TicketTitle07 @smoke @regression @all
Scenario Outline: T007_To verify the TicketTitle feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks TicketTitle
And User sort the TicketTitle list Recently Added
Then Recent TicketTitle list get displayed successfully

@Master @TicketTitle @TicketTitle08 @smoke @regression @all
Scenario Outline: T008_To verify the TicketTitle feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks TicketTitle
And User sort the TicketTitle list decending
Then Decending TicketTitle list get displayed successfully

@Master @TicketTitle @TicketTitle09 @smoke @regression @all
Scenario Outline: T009_To verify the TicketTitle Edit
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks TicketTitle
And User click on kebab menu
And User selects Edit option 
And User Updated TicketTitle 
Then Particular TicketTitle gets Edited successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                        |
      | LOADING...            | Success Edited TicketTitle successfully | 
      
@Master @TicketTitle @TicketTitle10 @smoke @regression @all
Scenario Outline: T010_To verify the TicketTitle Delete
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks TicketTitle
And User click on New TicketTitle button
And User Enter TicketTitle name and clicks Add TicketTitle button
And User click on kebab menu
And User clicked Delete TicketTitle option 
Then Particular TicketTitle gets Deleted successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2              |
      | LOADING...            | Success Deleted successfully |  
@Master @ScreenResolution @ScreenResolution01 @smoke @regression @all
Scenario Outline: T001_Verify ScreenResolution page display
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenResolution
Then Al Arabia ScreenResolution page should display successfully

@Master @ScreenResolution @ScreenResolution02 @regression @sanity @all
Scenario Outline: T002_Create the Ticket with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenResolution
And User click on New ScreenResolution button
And User Enter ScreenResolution name and clicks Add ScreenResolution button
Then Particular ScreenResolution gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                             |
      | LOADING...            | Success Added ScreenResolution successfully |      
@Master @ScreenResolution @ScreenResolution03 @smoke @regression @all
Scenario Outline: T003_ the ScreenResolution feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenResolution
And Admin or user search the ScreenResolution
Then Searched Ticket details get displayed successfully

@Master @ScreenResolution @ScreenResolution04 @smoke @regression @all
Scenario Outline: T004_To verify the ScreenResolution feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenResolution
And Admin or user sort the ScreenResolution list recently updated
Then Recently updated ScreenResolution list get displayed successfully

@Master @ScreenResolution @ScreenResolution05 @smoke @regression @all
Scenario Outline: T005_To verify the ScreenResolution feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenResolution
And User sort the ScreenResolution list Name A to Z
Then ScreenResolution list get displayed successfully

@Master @ScreenResolution @ScreenResolution06 @smoke @regression @all
Scenario Outline: T006_To verify the ScreenResolution feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenResolution
And User sort the ScreenResolution list Name Z to A 
Then ScreenResolution list Z to A get displayed successfully

@Master @ScreenResolution @ScreenResolution07 @smoke @regression @all
Scenario Outline: T007_To verify the ScreenResolution feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenResolution
And User sort the ScreenResolution list Recently Added
Then Recent ScreenResolution list get displayed successfully

@Master @ScreenResolution @ScreenResolution08 @smoke @regression @all
Scenario Outline: T008_To verify the ScreenResolution feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenResolution
And User sort the ScreenResolution list decending
Then Decending ScreenResolution list get displayed successfully

@Master @ScreenResolution @ScreenResolution09 @smoke @regression @all
Scenario Outline: T009_To verify the ScreenResolution Edit
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenResolution
And User click on kebab menu
And User selects Edit option 
And User Updated ScreenResolution 
Then Particular ScreenResolution gets Edited successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                              |
      | LOADING...            | Success Edited ScreenResolution successfully | 
      
@Master @ScreenResolution @ScreenResolution10 @smoke @regression @all
Scenario Outline: T010_To verify the ScreenResolution Delete
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenResolution
And User click on New ScreenResolution button
And User Enter ScreenResolution name and clicks Add ScreenResolution button
And User click on kebab menu
And User clicked Delete ScreenResolution option 
Then Particular ScreenResolution gets Deleted successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2              |
      | LOADING...            | Success Deleted successfully |  
  
@Master @ScreenPixel @ScreenPixel01 @smoke @regression @all
Scenario Outline: T001_Verify ScreenPixel page display
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenPixel
Then Al Arabia ScreenPixel page should display successfully

@Master @ScreenPixel @ScreenPixel02 @regression @sanity @all
Scenario Outline: T002_Create the Ticket with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenPixel
And User click on New ScreenPixel button
And User Enter ScreenPixel name and clicks Add ScreenPixel button
Then Particular ScreenPixel gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                        |
      | LOADING...            | Success Added ScreenPixel successfully |      
@Master @ScreenPixel @ScreenPixel03 @smoke @regression @all
Scenario Outline: T003_ the ScreenPixel feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenPixel
And Admin or user search the ScreenPixel
Then Searched Ticket details get displayed successfully

@Master @ScreenPixel @ScreenPixel04 @smoke @regression @all
Scenario Outline: T004_To verify the ScreenPixel feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenPixel
And Admin or user sort the ScreenPixel list recently updated
Then Recently updated ScreenPixel list get displayed successfully

@Master @ScreenPixel @ScreenPixel05 @smoke @regression @all
Scenario Outline: T005_To verify the ScreenPixel feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User sort the ScreenPixel list Name A to Z
Then ScreenPixel list get displayed successfully

@Master @ScreenPixel @ScreenPixel06 @smoke @regression @all
Scenario Outline: T006_To verify the ScreenPixel feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenPixel
And User sort the ScreenPixel list Name Z to A 
Then ScreenPixel list Z to A get displayed successfully

@Master @ScreenPixel @ScreenPixel07 @smoke @regression @all
Scenario Outline: T007_To verify the ScreenPixel feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenPixel
And User sort the ScreenPixel list Recently Added
Then Recent ScreenPixel list get displayed successfully

@Master @ScreenPixel @ScreenPixel08 @smoke @regression @all
Scenario Outline: T008_To verify the ScreenPixel feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenPixel
And User sort the ScreenPixel list decending
Then Decending ScreenPixel list get displayed successfully

@Master @ScreenPixel @ScreenPixel09 @smoke @regression @all
Scenario Outline: T009_To verify the ScreenPixel Edit
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenPixel
And User click on kebab menu
And User selects Edit option 
And User Updated ScreenPixel 
Then Particular ScreenPixel gets Edited successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                         |
      | LOADING...            | Success Edited ScreenPixel successfully | 
      
@Master @ScreenPixel @ScreenPixel10 @smoke @regression @all
Scenario Outline: T010_To verify the ScreenPixel Delete
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks ScreenPixel
And User click on New ScreenPixel button
And User Enter ScreenPixel name and clicks Add ScreenPixel button
And User click on kebab menu
And User clicked Delete ScreenPixel option 
Then Particular ScreenPixel gets Deleted successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2              |
      | LOADING...            | Success Deleted successfully |  
       
@Master @BillBoardType @BillBoardType01 @smoke @regression @all
Scenario Outline: T001_Verify BillBoardType page display
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BillBoardType
Then Al Arabia BillBoardType page should display successfully

@Master @BillBoardType @BillBoardType02 @regression @sanity @all
Scenario Outline: T002_Create the Ticket with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BillBoardType
And User click on New BillBoardType button
And User Enter BillBoardType name and clicks Add BillBoardType button
Then Particular BillBoardType gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                       |
      | LOADING...            | Success Added BillBoardType successfully |      
@Master @BillBoardType @BillBoardType03 @smoke @regression @all
Scenario Outline: T003_ the BillBoardType feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BillBoardType
And Admin or user search the BillBoardType
Then Searched Ticket details get displayed successfully

@Master @BillBoardType @BillBoardType04 @smoke @regression @all
Scenario Outline: T004_To verify the BillBoardType feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BillBoardType
And Admin or user sort the BillBoardType list recently updated
Then Recently updated BillBoardType list get displayed successfully

@Master @BillBoardType @BillBoardType05 @smoke @regression @all
Scenario Outline: T005_To verify the BillBoardType feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BillBoardType
And User sort the BillBoardType list Name A to Z
Then BillBoardType list get displayed successfully

@Master @BillBoardType @BillBoardType06 @smoke @regression @all
Scenario Outline: T006_To verify the BillBoardType feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BillBoardType
And User sort the BillBoardType list Name Z to A 
Then BillBoardType list Z to A get displayed successfully

@Master @BillBoardType @BillBoardType07 @smoke @regression @all
Scenario Outline: T007_To verify the BillBoardType feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BillBoardType
And User sort the BillBoardType list Recently Added
Then Recent BillBoardType list get displayed successfully

@Master @BillBoardType @BillBoardType08 @smoke @regression @all
Scenario Outline: T008_To verify the BillBoardType feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BillBoardType
And User sort the BillBoardType list decending
Then Decending BillBoardType list get displayed successfully

@Master @BillBoardType @BillBoardType09 @smoke @regression @all
Scenario Outline: T009_To verify the BillBoardType Edit
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BillBoardType
And User click on kebab menu
And User selects Edit option 
And User Updated BillBoardType 
Then Particular BillBoardType gets Edited successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                        |
      | LOADING...            | Success Edited BillBoardType successfully | 
      
@Master @BillBoardType @BillBoardType10 @smoke @regression @all
Scenario Outline: T010_To verify the BillBoardType Delete
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BillBoardType
And User click on New BillBoardType button
And User Enter BillBoardType name and clicks Add BillBoardType button
And User click on kebab menu
And User clicked Delete BillBoardType option 
Then Particular BillBoardType gets Deleted successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2              |
      | LOADING...            | Success Deleted successfully |  
	      
@Master @BOMUnit @BOMUnit01 @smoke @regression @all
Scenario Outline: T001_Verify BOMUnit page display
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BOMUnit
Then Al Arabia BOMUnit page should display successfully

@Master @BOMUnit @BOMUnit02 @regression @sanity @all
Scenario Outline: T002_Create the Ticket with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BOMUnit
And User click on New BOMUnit button
And User Enter BOMUnit name and clicks Add BOMUnit button
Then Particular BOMUnit gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                       |
      | LOADING...            | Success Added BOMUnit successfully |      
@Master @BOMUnit @BOMUnit03 @smoke @regression @all
Scenario Outline: T003_ the BOMUnit feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BOMUnit
And Admin or user search the BOMUnit
Then Searched Ticket details get displayed successfully

@Master @BOMUnit @BOMUnit04 @smoke @regression @all
Scenario Outline: T004_To verify the BOMUnit feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BOMUnit
And Admin or user sort the BOMUnit list recently updated
Then Recently updated BOMUnit list get displayed successfully

@Master @BOMUnit @BOMUnit05 @smoke @regression @all
Scenario Outline: T005_To verify the BOMUnit feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BOMUnit
And User sort the BOMUnit list Name A to Z
Then BOMUnit list get displayed successfully

@Master @BOMUnit @BOMUnit06 @smoke @regression @all
Scenario Outline: T006_To verify the BOMUnit feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BOMUnit
And User sort the BOMUnit list Name Z to A 
Then BOMUnit list Z to A get displayed successfully

@Master @BOMUnit @BOMUnit07 @smoke @regression @all
Scenario Outline: T007_To verify the BOMUnit feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BOMUnit
And User sort the BOMUnit list Recently Added
Then Recent BOMUnit list get displayed successfully

@Master @BOMUnit @BOMUnit08 @smoke @regression @all
Scenario Outline: T008_To verify the BOMUnit feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BOMUnit
And User sort the BOMUnit list decending
Then Decending BOMUnit list get displayed successfully

@Master @BOMUnit @BOMUnit09 @smoke @regression @all
Scenario Outline: T009_To verify the BOMUnit Edit
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BOMUnit
And User click on kebab menu
And User selects Edit option 
And User Updated BOMUnit 
Then Particular BOMUnit gets Edited successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                        |
      | LOADING...            | Success Edited BOMUnit successfully | 
      
@Master @BOMUnit @BOMUnit10 @smoke @regression @all
Scenario Outline: T010_To verify the BOMUnit Delete
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks BOMUnit
And User click on kebab menu
And User clicked Delete BOMUnit option 
Then Particular BOMUnit gets Deleted successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2              |
      | LOADING...            | Success Deleted successfully |  
	      
@Master @BOM @BOM01 @smoke @regression @all
Scenario Outline: T001_Verify BOM page display
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the BOM
Then Al Arabia BOM page should display successfully

@Master @BOM @BOM02 @regression @sanity @all
Scenario Outline: T002_Create the New BOM with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the BOM
And User click on New BOM button
And User Enter Mandatory fields of New BOM page
And User click on Add BOM button
Then Particular BOM gets created successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2        |
      | LOADING...            | Success Supplier Added |      
@Master @BOM @BOM03 @smoke @regression @all
Scenario Outline: T003_ the BOM feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the BOM
And Admin or user search the Tickets
Then Searched Ticket details get displayed successfully

@Master @BOM @BOM04 @smoke @regression @all
Scenario Outline: T004_To verify the BOM feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the BOM
And Admin or user sort the BOM list recently updated
Then Recently updated BOM list get displayed successfully

@Master @BOM @BOM05 @smoke @regression @all
Scenario Outline: T005_To verify the BOM feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the BOM
And User sort the BOM list Name A to Z
Then BOM list get displayed successfully

@Master @BOM @BOM06 @smoke @regression @all 
Scenario Outline: T006_To verify the BOM feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the BOM
And User sort the BOM list Name Z to A 
Then BOM list Z to A get displayed successfully

@Master @BOM @BOM07 @smoke @regression @all
Scenario Outline: T007_To verify the BOM feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the BOM
And User sort the BOM list Recently Added
Then Recent BOM list get displayed successfully

@Master @BOM @BOM08 @smoke @regression @all
Scenario Outline: T008_To verify the BOM feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the BOM
And User sort the BOM list decending
Then Decending BOM list get displayed successfully

@Master @BOM @BOM09 @smoke @regression @all
Scenario Outline: T009_To verify the BOM Edit
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the BOM
And User click on kebab menu of BOM
And User selects Edit option of BOM
And User Updated BOM 
Then Particular BOM gets Edited successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2     |
      | LOADING...            | Success BOM updated | 
     
@Master @BOM @BOM10 @smoke @regression @all
Scenario Outline: T010_To verify the BOM View
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the BOM
And User click on kebab menu
And User clicked View BOM option
Then BOM page will be displayed to the user      
      
@Master @BOM @BOM11 @smoke @regression @all
Scenario Outline: T011_To verify the BOM Delete
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the BOM
And User click on kebab menu
And User clicked Delete BOM option 
Then Particular BOM gets Deleted successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2          |
      | LOADING...            | Success BOM deleted |  
          