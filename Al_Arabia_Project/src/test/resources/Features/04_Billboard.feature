Feature: billboards
Admin, Manager and Supervisor can able to access the billboards feature, if they are get the roles access only

@billboards @billboards01 @smoke @regression @all
Scenario Outline: T001_Check billboards dashboard page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
Then Al-Arabia billboards dashboard should display successfully

@billboards @billboards02 @regression @sanity @all
Scenario Outline: T002_Invite the Billboard with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the billboards module
And Admin or user clicks the new billboard button
And Admin or user enters the all new billboard mandatory fields
#And Admin or user clicks the create billboard
Then The billboard should created and displayed in billboard dashboard successfully

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
And User clicks the billboards module
And User sort the billboards list recently updated
Then Recently updated billboards list get displayed successfully

@billboards @billboards05 @smoke @regression @all
Scenario Outline: T005_To verify the billboards feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User sort the billboards list Name A to Z
Then billboards list get displayed successfully

@billboards @billboards06 @smoke @regression @all
Scenario Outline: T006_To verify the billboards feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User sort the billboards list Name Z to A 
Then billboards list get displayed successfully

@billboards @billboards07 @smoke @regression @all
Scenario Outline: T007_To verify the billboards feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User sort the billboards list Recently Added
Then billboards list get displayed successfully

@billboards @billboards08 @smoke @regression @all
Scenario Outline: T008_To verify the billboards feature filter active status billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
Then Active billboards list get displayed successfully

@billboards @billboards09 @smoke @regression @all
Scenario Outline: T009_To verify the billboards feature filter blocked status billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Blocked
Then Blocked billboards list get displayed successfully

@billboards @billboards10 @smoke @regression @all
Scenario Outline: T010_To verify the billboards feature filter expired status billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-expired
Then Expired billboards list get displayed successfully

@billboards @billboards11 @smoke @regression @all
Scenario Outline: T011_To verify the billboards feature filter pending status billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-pending
Then Pending billboards list get displayed successfully

@billboards @billboards12 @smoke @regression @all
Scenario Outline: T012_To verify the billboards feature filter admin role billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list role-admin
Then Admin billboards list get displayed successfully

@billboards @billboards13 @smoke @regression @all
Scenario Outline: T013_To verify the billboards feature filter manager role billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list role-manager
Then Manager billboards list get displayed successfully

@billboards @billboards14 @smoke @regression @all
Scenario Outline: T014_To verify the billboards feature filter supervisor role billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list role-supervisor
Then Supervisor billboards list get displayed successfully

@billboards @billboards15 @smoke @regression @all
Scenario Outline: T015_To verify the billboards feature filter technician role billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list role-technician
Then Technician billboards list get displayed successfully

@billboards @billboards16 @smoke @regression @all
Scenario Outline: T016_To verify the billboards feature filter electrical dept billboards
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list dept-electrical
Then Electrical dept billboards list get displayed successfully

@billboards @billboards17 @smoke @regression @all
Scenario Outline: T017_To verify the billboards feature filter resposible area
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list responsible area
Then Responsible area billboards list get displayed successfully

@billboards @billboards18 @sanity @regression @all
Scenario Outline: T018_To verify the billboards feature filter with multiple selected options
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list role-supervisor1
And User filter the billboards list dept-electrical1
And User filter the billboards list responsible area1
And User filter the billboards list status-Active1
Then Filtered billboards list get displayed successfully

@billboards @billboards19 @sanity @regression @all
Scenario Outline: T019_To verify the billboards feature download billboards list excel
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User clicks the billboards list download btn
And User clicks the excel formate btn
Then All billboards excel formate list get downloaded successfully

@billboards @billboards20 @sanity @regression @all
Scenario Outline: T020_To verify the billboards feature download billboards list pdf
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User clicks the billboards list download btn
And User clicks the pdf formate btn
Then All billboards pdf formate list get downloaded successfully

@billboards @billboards21 @smoke @regression @all
Scenario Outline: T021_To verify the billboards feature download popup closing
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User clicks the billboards list download btn
And User clicks the close icon
Then The popup get closed successfully

@billboards @billboards22 @smoke @regression @all
Scenario Outline: T022_To verify the billboards feature pagination 1st to 2nd page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And Go to next page of billboards page
Then Second page get displayed successfully

@billboards @billboards23 @sanity @regression @all
Scenario Outline: T023_To verify the billboards feature particular billboards profile page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin or User go the billboards profile page
Then billboards page get displayed successfully

@billboards @billboards24 @sanity @regression @all
Scenario Outline: T024_To verify the billboards feature personal profile updation
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin or User go the billboards profile page
And Admin or User update the billboards profile page
Then Particular billboards profile get updated successfully as "<successMessage>"
 Examples:
      | successMessage                        |
      | Success Personal profile updated      |

@billboards @billboards25 @sanity @regression @all
Scenario Outline: T025_To verify the billboards feature personal profile error messages
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin or User go the billboards profile page
And Admin or User delete the Billboard name
Then Name is required error message get displayed successfully

@billboards @billboards26 @sanity @regression @all
Scenario Outline: T026_To verify the billboards feature company profile updation
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin or User go the billboards profile page
And Admin or User update the billboards company profile page
Then Particular billboards profile get updated successfully as "<successMessage>"
 Examples:
      | successMessage                        |
      | Success Company profile updated       |

@billboards @billboards27 @sanity @regression @all
Scenario Outline: T027_To verify the billboards feature company profile error messages
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin or User go the billboards profile page
And Admin or User delete the workspace ID
Then Workspace id is required error message get displayed successfully

@billboards @billboards28 @sanity @regression @all
Scenario Outline: T028_To verify the billboards feature vehicle info profile updation
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin or User go the billboards profile page
And Admin or User update the billboards vehicle info profile page
Then Particular billboards profile get updated successfully as "<successMessage>"
 Examples:
      | successMessage                        |
      | Success Vehicle information updated   |

@billboards @billboards29 @sanity @regression @all
Scenario Outline: T029_To verify the billboards feature vehicle info profile error messages
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin or User go the billboards profile page
And Admin or User delete the licence number
Then Licence plate number is required error message get displayed successfully

@billboards @billboards30 @sanity @regression @all
Scenario Outline: T030_To verify the billboards feature reset password profile updation
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin or User go the billboards profile page
And Admin or User update the billboards reset password profile page
Then Particular billboards reset password profile get updated successfully as "<successMessage>"
 Examples:
      | successMessage             |
      | Success Password updated   |

@billboards @billboards31 @sanity @regression @all
Scenario Outline: T031_To verify the billboards feature reset password profile error messages
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin or User go the billboards profile page
And Admin or User delete the new password
Then Reset password page error message get displayed successfully

@billboards @billboards32 @sanity @regression @all
Scenario Outline: T032_To verify the billboards feature reset password profile error messages (spl char)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin or User go the billboards profile page
And Admin or User delete the new password and enter without spl char
Then Reset password page error message get displayed successfully

@billboards @billboards33 @sanity @regression @all
Scenario Outline: T033_To verify the billboards feature reset password profile error messages (uppercase)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin or User go the billboards profile page
And Admin or User delete the new password and enter without uppercase char
Then Reset password page error message get displayed successfully

@billboards @billboards34 @sanity @regression @all
Scenario Outline: T034_To verify the billboards feature reset password profile error messages (number)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin or User go the billboards profile page
And Admin or User delete the new password and enter without number char
Then Reset password page error message get displayed successfully

@billboards @billboards35 @sanity @regression @all
Scenario Outline: T035_To verify the billboards feature reset password profile error messages (mismatch)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin or User go the billboards profile page
And Admin or User delete the new password and cofirm password mismatch
Then Reset password page error message get displayed successfully

@billboards @billboards36 @sanity @regression @all
Scenario Outline: T036_To verify the billboards feature block the active Billboard
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin or User click the menu option
And Admin or User click the block option
And Admin or User click the Yes button
Then Billboard blocked successfully

@billboards @billboards37 @sanity @regression @all
Scenario Outline: T037_To verify the billboards feature unblock the blocked Billboard
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Blocked
And User search the billboards
And Admin or User click the menu option
And Admin or User click the unblock option
And Admin or User click the unblock Yes button
Then Billboard activated successfully

@billboards @billboards38 @sanity @regression @all
Scenario Outline: T038_To verify the billboards feature roles wise (Read access for supervisor)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin click the personal profile icon
And Admin go to the roles page
And Admin enable the User read access for supervisor
And Admin clicks the logout button
And Supervisor logged in with valid credentials
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Supervisor go the billboards profile page
Then Supervisor get the read access successfully

@billboards @billboards39 @sanity @regression @all
Scenario Outline: T039_To verify the billboards feature roles wise (Write access for supervisor)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin click the personal profile icon
And Admin go to the roles page
And Admin enable the User write access for supervisor
And Admin clicks the logout button
And Supervisor logged in with valid credentials
And User clicks the billboards module
And Check invite btn is displayed or not
Then Supervisor get the write access successfully

@billboards @billboards40 @sanity @regression @all
Scenario Outline: T040_To verify the billboards feature roles wise (Update access for supervisor)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin click the personal profile icon
And Admin go to the roles page
And Admin enable the User update access for supervisor
And Admin clicks the logout button
And Supervisor logged in with valid credentials
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Supervisor go the billboards profile page
And Supervisor update the billboards profile page
Then Supervisor get the update access successfully

@billboards @billboards41 @sanity @regression @all
Scenario Outline: T041_To verify the billboards feature roles wise (Block/Unblock access for supervisor)
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Admin click the personal profile icon
And Admin go to the roles page
And Admin enable the User block or unblock access for supervisor
And Admin clicks the logout button
And Supervisor logged in with valid credentials
And User clicks the billboards module
And User filter the billboards list status-Active
And User search the billboards
And Supervisor clicks the billboards menu option
Then Supervisor get the block and unblock access successfully























