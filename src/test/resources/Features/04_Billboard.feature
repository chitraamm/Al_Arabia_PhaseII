Feature: billboards
Admin, Manager and Supervisor can able to access the billboards feature, if they are get the roles access only

@billboards @billboards01 @smoke @regression @all
Scenario Outline: T001_Check billboards dashboard page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
Then Al-Arabia billboards dashboard should display successfully

@billboards @billboards02 @regression @sanity @all
Scenario Outline: T002_Create new Billboard with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And Admin or user clicks the new billboard button
And Admin or user enters the all new billboard mandatory fields 
And Admin or user clicks the create billboard 
And Particular billboard gets created successfully with either "<successMessage1>" or "<successMessage2>"
Then The billboard should created and displayed in billboard dashboard successfully
  Examples:
      | successMessage1       | successMessage2          |
      | LOADING...            | Success Billboard created|

@billboards @billboards03 @smoke @regression @all
Scenario Outline: T003_ the billboards feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And Admin or user search the billboards
Then Searched Billboard details get displayed successfully

@billboards @billboards04 @smoke @regression @all
Scenario Outline: T004_To verify the billboards feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And Admin or user sort the billboards list recently updated
Then Recently updated billboards list get displayed successfully

@billboards @billboards05 @smoke @regression @all
Scenario Outline: T005_To verify the billboards feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User sort the billboards list Name A to Z
Then billboards list get displayed successfully

@billboards @billboards06 @smoke @regression @all
Scenario Outline: T006_To verify the billboards feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User sort the billboards list Name Z to A 
Then billboards list Z to A get displayed successfully

@billboards @billboards07 @smoke @regression @all
Scenario Outline: T007_To verify the billboards feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User sort the billboards list Recently Added
Then Recent billboards list get displayed successfully

@billboards @billboards08 @smoke @regression @all
Scenario Outline: T008_To verify the billboards feature sort decending
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User sort the billboards list decending
Then Decending billboards list get displayed successfully

@billboards @billboards09 @smoke @regression @all
Scenario Outline: T009_To verify the billboards feature filter active status billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards list status Active
Then Active billboards list get displayed successfully

@billboards @billboards10 @smoke @regression @all
Scenario Outline: T010_To verify the billboards feature filter Non oper status billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards list status Non Oper
Then Non Oper billboards list get displayed successfully

@billboards @billboards11 @smoke @regression @all
Scenario Outline: T011_To verify the billboards feature filter expired status billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards list status Request
Then Request billboards list get displayed successfully

@billboards @billboards12 @smoke @regression @all
Scenario Outline: T012_To verify the billboards feature filter location billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User selects billboard location
Then Selected location billboards list get displayed successfully

@billboards @billboards13 @smoke @regression @all
Scenario Outline: T013_To verify the billboards feature filter ticket count billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards ticket count
Then ticket count billboards list get displayed successfully

@billboards @billboards14 @smoke @regression @all
Scenario Outline: T014_To verify the billboards feature filter Billboard Type
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the Billboard Type 
Then Billboard type billboards list get displayed successfully

@billboards @billboards15 @smoke @regression @all
Scenario Outline: T015_To verify the billboards feature filters Online for Team viewer,Novastar,IVMS 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards Online Team viewer Novastar IVMS 
Then Online billboards list get displayed successfully for Team viewer Novastar IVMS 

@billboards @billboards16 @smoke @regression @all
Scenario Outline: T016_To verify the billboards feature filters Offline for Team viewer,Novastar,IVMS 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards Offline Team viewer Novastar IVMS 
Then Offline billboards list get displayed successfully for Team viewer Novastar IVMS

@billboards @billboards17 @smoke @regression @all
Scenario Outline: T017_To verify the billboards feature filters installed for IVMS 4200 N/A,Novastar N/A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards installed IVMS and Novastar 
Then installed billboards list get displayed successfully for IVMS and Novastar

@billboards @billboards18 @smoke @regression @all
Scenario Outline: T018_To verify the billboards feature filters Not installed for IVMS 4200 N/A,Novastar N/A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards Not installed IVMS and Novastar 
Then Not installed billboards list get displayed successfully for IVMS and Novastar

@billboards @billboards19 @smoke @regression @all
Scenario Outline: T019_To verify the billboards feature filters Online for Team Viewer,Novostar and installed for IVMS 4200 N/A,Novastar N/A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards installed IVMS and Novastar with online
Then Online and installed status billboards list get displayed successfully for IVMS and Novastar

@billboards @billboards20 @smoke @regression @all
Scenario Outline: T020_To verify the billboards feature filters Onine for Team Viewer,Novostar and installed for IVMS 4200 N/A,Novastar N/A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards Offline Team viewer Novastar IVMS with installed
Then Offline and installed status billboards list get displayed successfully for IVMS and Novastar

@billboards @billboards21 @smoke @regression @all
Scenario Outline: T021_To verify the billboards feature filters Onine for Team Viewer,Novostar and Not installed for IVMS 4200 N/A,Novastar N/A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards Online Team viewer Novastar IVMS with Not installed
Then Online and Not installed status billboards list get displayed successfully for IVMS and Novastar

@billboards @billboards22 @smoke @regression @all
Scenario Outline: T022_To verify the billboards feature filters Offine for Team Viewer,Novostar and Not installed for IVMS 4200 N/A,Novastar N/A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards Offline Team viewer Novastar IVMS with Not installed
Then Offline and Not installed status billboards list get displayed successfully for IVMS and Novastar

@billboards @billboards23 @smoke @regression @all
Scenario Outline: T023_To verify the billboards feature filter Screen resolution
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the Screen resolution drop down
Then Screen resolution billboards list get displayed successfully

@billboards @billboards24 @smoke @regression @all
Scenario Outline: T024_To verify the billboards feature Download button
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User clicks Download button 
Then Download pop up displayed successfully

@billboards @billboards25 @smoke @regression @all
Scenario Outline: T025_To verify the billboards feature Download as excel
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User clicks Download button with Download As Excel
Then Excel file will be downloaded successfully as "<successMessage>"
  Examples:
      | successMessage       |
      | LOADING...           |

@billboards @billboards26 @smoke @regression @all
Scenario Outline: T026_To verify the billboards feature Download as PDF
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User clicks Download button with Download As PDF
Then PDF file will be downloaded successfully as "<successMessage>"
  Examples:
      | successMessage       |
      | LOADING...           |  
          
@billboards @billboards28 @smoke @regression @all
Scenario Outline: T028_To verify the billboards feature Download popup close
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User clicks Download button after that click on close button 
Then Download pop up get closed successfully and display the Billboard list 
         
@billboards @billboards29 @smoke @regression @all
Scenario Outline: T029_To verify the billboards feature Edit button in BillBoards page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User clicks the Edit button	 
Then Edit BillBoard page will be displayed successfully
         
@billboards @billboards30 @smoke @regression @all
Scenario Outline: T030_To verify the billboards feature Plus button in BillBoards page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User clicks on the Plus button 
Then BillBoard View page will be displayed successfully  
       
@billboards @billboards311 @smoke @regression @all
Scenario Outline: T031_To verify the billboards feature Delete button in BillBoards page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User clicks on the Delete button with clicks confirm yes button
Then BillBoard delete popup will be displayed successfully as "<successMessage>"
  Examples:
      | successMessage     			   	    |
      | Success deleted this billboard      |      

@billboards @billboards32 @smoke @regression @all
Scenario Outline: T032_To verify the billboards features Billboard location in the BillBoards page when the location text is clicked
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User click on the Billboard location text 
Then page redirected to the map page with billboard location
      
@billboards @billboards33 @smoke @regression @all
Scenario Outline: T033_To verify the billboards features Update BillBoard
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards list status Active32
And User clicks the Edit button 
And User edit screen height 
And User click on Update BillBoard button with confirm yes button
Then BillBoard Updated popup will be displayed successfully as "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2            |
      | LOADING...            | Success Billboard updated  |    
        
@billboards @billboards34 @smoke @regression @all
Scenario Outline: T034_To verify the billboards features BOM Tab in Update BillBoard page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards list status Active32
And User clicks the Edit button 
And User click on BOM Tab
Then BOM details of BillBoard will be display successfully
      
@billboards @billboards35 @smoke @regression @all
Scenario Outline: T035_To verify the billboards features Download PDF File in BOM Details page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards list status Active32
And User clicks the Edit button 
And User click on BOM Tab
Then User click on Download PDF button and will be downloaded the PDF file of BOM
  
@billboards @billboards36 @smoke @regression @all
Scenario Outline: T036_To verify the billboards features QR display in Update BillBoard page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards list status Active32
And User clicks the Edit button 
And User click on Download QR code icon
Then BillBoard QR code will be displayed sucessfully

@billboards @billboards37 @smoke @regression @all
Scenario Outline: T037_To verify the billboards features clicks Mark it as non operational in Update BillBoard page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards list status Active32
And User clicks the Edit button 
And User Click on Mark it as non operational button with Temporary 
Then Temporary Non-Operational Details popup will be displayed 

@billboards @billboards38 @smoke @regression @all
Scenario Outline: T038_To verify the billboards features Mark it as non operational in Update BillBoard page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards list status Active32
And User clicks the Edit button 
And User Click on Mark it as non operational button with Temporary 
And User enters Temporary Non Operational Details 
And User Onclicks Yes mark it as Non operational button   
Then Temporary Non Operational ticket created successfully "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                    |
      | LOADING...            | Success Updated as non-operational |
      
@billboards @billboards39 @smoke @regression @all
Scenario Outline: T039_To verify the billboards feature pagination 1st to 2nd page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User click on second page button of billboards
Then Second page billboards get displayed successfully    

@billboards @billboards40 @smoke @regression @all
Scenario Outline: T040_To verify the billboards feature pagination next page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And Go to Next page of billboards page
Then Next page billboards get displayed successfully  

@billboards @billboards41 @smoke @regression @all
Scenario Outline: T041_To verify the billboards feature pagination previous page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And Go to Next page of billboards page 
And Go to Previous page of billboards page
Then Previous page billboards get displayed successfully 

@billboards @billboards42 @smoke @regression @all
Scenario Outline: T042_To verify the billboards feature pagination last page 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And Go to Last page of billboards page
Then Last page billboards get displayed successfully   

@billboards @billboards43 @smoke @regression @all
Scenario Outline: T043_To verify the billboards feature pagination last page to first page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And Go to Last page of billboards page
And User click on first page button of billboards
Then First page billboards get displayed successfully 
      
@billboards @billboards44 @smoke @regression @all
Scenario Outline: T044_To verify the billboards feature filter Pending status billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards list status Pending
Then Pending billboards list get displayed successfully  
    
@billboards @billboards45 @smoke @regression @all
Scenario Outline: T038_To verify the billboards features Mark it as Permanent non operational in Update BillBoard page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards list status Active32
And User clicks the Edit button 
And User Click on Mark it as non operational button with Permanent 
And User enters Permanent Non Operational Details 
And User Onclicks Yes mark it as Non operational button   
Then Permanent Non Operational ticket created successfully "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                    |
      | LOADING...            | Success Updated as non-operational |
      
@billboards @billboards46 @smoke @regression @all
Scenario Outline: T038_To verify the billboards features Mark it as Accidental non operational in Update BillBoard page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards list status Active32
And User clicks the Edit button 
And User Click on Mark it as non operational button with Temporary 
And User enters Accidental Non Operational Details 
And User Onclicks Yes mark it as Non operational button   
Then Accidental Non Operational ticket created successfully "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                    |
      | LOADING...            | Success Updated as non-operational |
      
@billboards @billboards47 @smoke @regression @all
Scenario Outline: T047_To verify the billboards feature Create New Ticket from Add BillBoards page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards list status Active
And User clicks on the Plus button
And User enters mandatory fields of new ticket  
And User clicks the create Ticket   
Then Ticket gets created from Add BillBoards page successfully with either "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2           |
      | LOADING...            | Success Ticket created    |    
@billboards @billboards48 @smoke @regression @all
Scenario Outline: T048_To verify the billboards feature 'View Ticket' Tab in Add BillBoards page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User clicks on the Plus button
And User clicks on the View Ticket Tab
Then View Ticket page will be displayed successfully

@billboards @billboards49 @smoke @regression @all
Scenario Outline: T049_To verify the billboards feature 'Activity Feed' in Add BillBoards page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User clicks on the Plus button
And User clicks on the Activity Feed Tab
Then Activity Feed page will be displayed successfully	

@billboards @billboards50 @smoke @regression @all
Scenario Outline: T050_To verify the billboards feature faulty
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards Faulty
Then Faulty billboards list get displayed successfully

@billboards @billboards51 @smoke @regression @all
Scenario Outline: T051_To verify the billboards feature Alarm
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User filter the billboards Alarm
Then Alarm billboards list get displayed successfully

@billboards @billboards52 @smoke @regression @all
Scenario Outline: T038_To verify the billboards feature with View Incidents of a Particular Billboard 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User clicks the Edit button 
And User clicks Incidents  
Then Display Incidents of the Billboard

@billboards @billboards53 @smoke @regression @all
Scenario Outline: T038_To verify Documents page of any billboard 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And User clicks the Edit button 
And User click on Documents 
Then Documents page should be display successfully

@billboards @billboards54 @smoke @regression @all
Scenario Outline: T038_To verify Upload a Document for any billboard 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module 
And User clicks the Edit button 
And User click on Documents  
And User Click Upload Document Option and Upload it from the local drive 
Then Document should be get Uploaded successfully "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                            |
      | LOADING...            | Success Document(s) uploaded successfully  | 

@billboards @billboards55 @smoke @regression @all
Scenario Outline: T038_To verify Delete Uploaded Document from the Documents page of any billboard 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module 
And User clicks the Edit button 
And User click on Documents  
And User Click Upload Document Option and Upload it from the local drive 
And User clicks close icon 
Then Document should be get deleted successfully "<successMessage1>" or "<successMessage2>"
  Examples:
      | successMessage1       | successMessage2                        |
      | LOADING...            | Success Document deleted successfully  | 
      
@billboards @billboards56 @smoke @regression @all
Scenario Outline: T038_To verify Download the Uploaded Document from the Documents page of any billboard 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module 
And User clicks the Edit button 
And User click on Documents  
And User clicks Download icon   
Then Document should be get Downloaded successfully  

@billboards @billboards57 @smoke @regression @all
Scenario Outline: T038_To verify Stock movements of any billboard 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module 
And User clicks the Edit button 
And User click on Stock movements   
Then Stock movements page should be display successfully       
           





