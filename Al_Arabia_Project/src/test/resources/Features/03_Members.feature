Feature: Members
User should be able to access the members feature

@members @members01 @smoke @regression @all
Scenario Outline: Check members dashboard page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
Then Al-Arabia members dashboard should display successfully

@members @members02 @regression @sanity @all
Scenario Outline: Invite the member with valid inputs
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User clicks the invite member button
And User enters the email or phone number
And User selects the role manager
And User selects the department electrical
#And User clicks the send invite button
Then The invitation should sent to user given mail address successfully

@members @members03 @smoke @regression @all
Scenario Outline: To verify the members feature search
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User search the members
Then Searched member details get displayed successfully

@members @members04 @smoke @regression @all
Scenario Outline: To verify the members feature sort recently updated
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User sort the members list recently updated
Then Recently updated members list get displayed successfully

@members @members05 @smoke @regression @all
Scenario Outline: To verify the members feature sort Name - A to Z
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User sort the members list Name A to Z
Then Members list get displayed successfully

@members @members06 @smoke @regression @all
Scenario Outline: To verify the members feature sort Name - Z to A
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User sort the members list Name Z to A 
Then Members list get displayed successfully

@members @members07 @smoke @regression @all
Scenario Outline: To verify the members feature sort Recently Added
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User sort the members list Recently Added
Then Members list get displayed successfully

@members @members08 @smoke @regression @all
Scenario Outline: To verify the members feature filter active status members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Active
Then Active members list get displayed successfully

@members @members09 @smoke @regression @all
Scenario Outline: To verify the members feature filter blocked status members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-Blocked
Then Blocked members list get displayed successfully

@members @members10 @smoke @regression @all
Scenario Outline: To verify the members feature filter expired status members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-expired
Then Expired members list get displayed successfully

@members @members11 @smoke @regression @all
Scenario Outline: To verify the members feature filter pending status members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list status-pending
Then Pending members list get displayed successfully

@members @members12 @smoke @regression @all
Scenario Outline: To verify the members feature filter admin role members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list role-admin
Then Admin members list get displayed successfully

@members @members13 @smoke @regression @all
Scenario Outline: To verify the members feature filter manager role members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list role-manager
Then Manager members list get displayed successfully

@members @members14 @smoke @regression @all
Scenario Outline: To verify the members feature filter supervisor role members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list role-supervisor
Then Supervisor members list get displayed successfully

@members @members15 @smoke @regression @all
Scenario Outline: To verify the members feature filter technician role members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list role-technician
Then Technician members list get displayed successfully

@members @members16 @smoke @regression @all
Scenario Outline: To verify the members feature filter electrical dept members
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list dept-electrical
Then Electrical dept members list get displayed successfully

@members @members17 @smoke @regression @all
Scenario Outline: To verify the members feature filter resposible area
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
And User filter the members list responsible area
Then Responsible area members list get displayed successfully


