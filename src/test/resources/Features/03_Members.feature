Feature: Members
Admin, Manager and Supervisor can able to access the members feature, if they are get the roles access only

@members @members01 @smoke @regression @all
Scenario Outline: T001_Check members dashboard page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
Then Al-Arabia members dashboard should display successfully

@members @members02 @regression @sanity @all
Scenario Outline: T002_Invite the member with valid inputs and Project selection 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User clicks the invite member button
And User enters the email or phone number
And User selects the role manager
And User selects the department electrical
And User selects Projects    
And User selects billboard type
And User clicks the send invite button
Then The invitation should sent to user given mail address successfully

@members @members03 @smoke @regression @all
Scenario Outline: T003_ the members feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User search the members 
Then Searched member details get displayed successfully

@members @members04 @smoke @regression @all
Scenario Outline: T004_To verify the members feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User sort the list recently updated 
Then Recently updated list get displayed successfully

@members @members05 @smoke @regression @all
Scenario Outline: T005_To verify the members feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User sort the list Name A to Z
Then Name A to Z list get displayed successfully

@members @members06 @smoke @regression @all
Scenario Outline: T006_To verify the members feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User sort the list Name Z to A  
Then Z to A list get displayed successfully

@members @members07 @smoke @regression @all
Scenario Outline: T007_To verify the members feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User sort the list Recently Added 
Then Recently added list get displayed successfully

@members @members08 @smoke @regression @all
Scenario Outline: T008_To verify the members feature filter active status members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the list status-Active
And User click apply button
Then Active members list get displayed successfully

@members @members09 @smoke @regression @all
Scenario Outline: T009_To verify the members feature filter blocked status members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Blocked
And User click apply button
Then Blocked members list get displayed successfully

@members @members10 @smoke @regression @all
Scenario Outline: T010_To verify the members feature filter expired status members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-expired
And User click apply button
Then Expired members list get displayed successfully

@members @members11 @smoke @regression @all
Scenario Outline: T011_To verify the members feature filter pending status members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-pending
And User click apply button
Then Pending members list get displayed successfully

@members @members12 @smoke @regression @all
Scenario Outline: T012_To verify the members feature filter admin role members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list role-admin
And User click apply button
Then Admin members list get displayed successfully

@members @members13 @smoke @regression @all
Scenario Outline: T013_To verify the members feature filter manager role members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list role-manager
And User click apply button
Then Manager members list get displayed successfully

@members @members14 @smoke @regression @all
Scenario Outline: T014_To verify the members feature filter supervisor role members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list role-supervisor
And User click apply button
Then Supervisor members list get displayed successfully

@members @members15 @smoke @regression @all
Scenario Outline: T015_To verify the members feature filter technician role members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list role-technician
And User click apply button
Then Technician members list get displayed successfully

@members @members16 @smoke @regression @all
Scenario Outline: T016_To verify the members feature filter electrical dept members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display 
And User clicks the members module
And User filter the members list dept-electrical
Then Electrical dept members list get displayed successfully

@members @members17 @smoke @regression @all
Scenario Outline: T017_To verify the members feature filter resposible area
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list responsible area
And User click apply button 
Then Responsible area members list get displayed successfully

@members @members18 @sanity @regression @all
Scenario Outline: T018_To verify the members feature filter with multiple selected options
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list role-supervisor1
And User filter the members list responsible area1
And User filter the members list status-Active1
Then Filtered members list get displayed successfully

@members @members19 @sanity @regression @all
Scenario Outline: T019_To verify the members feature download members list excel
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User clicks the members list download btn
And User clicks the excel formate btn
Then All members excel formate list get downloaded successfully

@members @members20 @sanity @regression @all
Scenario Outline: T020_To verify the members feature download members list pdf
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User clicks the members list download btn
And User clicks the pdf formate btn
Then All members pdf formate list get downloaded successfully

@members @members21 @smoke @regression @all
Scenario Outline: T021_To verify the members feature download popup closing
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User clicks the members list download btn
And User clicks the close icon
Then The popup get closed successfully

@members @members22 @smoke @regression @all
Scenario Outline: T022_To verify the members feature pagination 1st to 2nd page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And Go to next page of members page
Then Second page get displayed successfully

@members @members23 @sanity @regression @all
Scenario Outline: T023_To verify the members feature particular members profile page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User search the members
And User filter the members list status-Active
And Admin or User go the members profile page
Then Members page get displayed successfully

@members @members24 @sanity @regression @all
Scenario Outline: T024_To verify the members feature personal profile updation
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin or User go the members profile page
And Admin or User update the members profile page
Then Particular members profile get updated successfully as "<successMessage>"
 Examples:
      | successMessage                        |
      | Success Personal profile updated      |

@members @members25 @sanity @regression @all
Scenario Outline: T025_To verify the members feature personal profile error messages
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin or User go the members profile page
And Admin or User delete the member name
Then Name is required error message get displayed successfully

@members @members26 @sanity @regression @all
Scenario Outline: T026_To verify the members feature company profile updation
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members  
And Admin or User go the members profile page
And Admin or User update the members company profile page
Then Particular members profile get updated successfully with either "<successMessage1>" or "<successMessage2>"
 Examples:
      | successMessage                        |
      | Success Company profile updated       |

@members @members27 @sanity @regression @all
Scenario Outline: T027_To verify the members feature company profile error messages
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin or User go the members profile page
And Admin or User delete the workspace ID
Then Workspace id is required error message get displayed successfully

@members @members28 @sanity @regression @all
Scenario Outline: T028_To verify the members feature vehicle info profile updation
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin or User go the members profile page
And Admin or User update the members vehicle info profile page
Then Particular members profile get updated successfully as "<successMessage>"
 Examples:
      | successMessage                        |
      | Success Vehicle information updated   |

@members @members29 @sanity @regression @all
Scenario Outline: T029_To verify the members feature vehicle info profile error messages
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin or User go the members profile page
And Admin or User delete the licence number
Then Licence plate number is required error message get displayed successfully

@members @members30 @sanity @regression @all
Scenario Outline: T030_To verify the members feature reset password profile updation
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin or User go the members profile page
And Admin or User update the members reset password profile page
Then Particular members profile get updated successfully with either "<successMessage1>" or "<successMessage2>"
        Examples:
      | successMessage1       | successMessage2                 |
      | LOADING...            | Success  Company profile updated|
      
@members @members31 @sanity @regression @all
Scenario Outline: T031_To verify the members feature reset password profile error messages
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin or User go the members profile page
And Admin or User delete the new password
Then Reset password page error message get displayed successfully

@members @members32 @sanity @regression @all
Scenario Outline: T032_To verify the members feature reset password profile error messages (spl char)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin or User go the members profile page
And Admin or User delete the new password and enter without spl char
Then Reset password page error message get displayed successfully

@members @members33 @sanity @regression @all
Scenario Outline: T033_To verify the members feature reset password profile error messages (uppercase)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin or User go the members profile page
And Admin or User delete the new password and enter without uppercase char
Then Reset password page error message get displayed successfully

@members @members34 @sanity @regression @all
Scenario Outline: T034_To verify the members feature reset password profile error messages (number)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin or User go the members profile page
And Admin or User delete the new password and enter without number char
Then Reset password page error message get displayed successfully

@members @members35 @sanity @regression @all
Scenario Outline: T035_To verify the members feature reset password profile error messages (mismatch)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin or User go the members profile page
And Admin or User delete the new password and cofirm password mismatch
Then Reset password page error message get displayed successfully

@members @members36 @sanity @regression @all
Scenario Outline: T036_To verify the members feature block the active member
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin or User click the menu option
And Admin or User click the block option
And Admin or User click the Yes button
Then Member blocked successfully

@members @members37 @sanity @regression @all
Scenario Outline: T037_To verify the members feature unblock the blocked member
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Blocked
And User search the members
And Admin or User click the menu option
And Admin or User click the unblock option
And Admin or User click the unblock Yes button
Then Member activated successfully

@members @members38 @sanity @regression @all
Scenario Outline: T038_To verify the members feature roles wise (Read access for supervisor)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin click the personal profile icon
And Admin go to the roles page
And Admin enable the User read access for supervisor
And Admin clicks the logout button
And Supervisor logged in with valid credentials
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Supervisor go the members profile page
Then Supervisor get the read access successfully

@members @members39 @sanity @regression @all
Scenario Outline: T039_To verify the members feature roles wise (Write access for supervisor)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin click the personal profile icon
And Admin go to the roles page
And Admin enable the User write access for supervisor
And Admin clicks the logout button
And Supervisor logged in with valid credentials
And User clicks the members module
And Check invite btn is displayed or not
Then Supervisor get the write access successfully

@members @members40 @sanity @regression @all
Scenario Outline: T040_To verify the members feature roles wise (Update access for supervisor)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin click the personal profile icon
And Admin go to the roles page
And Admin enable the User update access for supervisor
And Admin clicks the logout button
And Supervisor logged in with valid credentials
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Supervisor go the members profile page1
And Supervisor update the members profile page
Then Supervisor get the update access successfully

@members @members41 @sanity @regression @all
Scenario Outline: T041_To verify the members feature roles wise (Block/Unblock access for supervisor)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Admin click the personal profile icon
And Admin go to the roles page
And Admin enable the User block or unblock access for supervisor
And Admin clicks the logout button
And Supervisor logged in with valid credentials
And User clicks the members module
And User filter the members list status-Active
And User search the members
And Supervisor clicks the members menu option
Then Supervisor get the block and unblock access successfully























