Feature: Members
User should be able to access the members feature

#Background: Given Admin logged in with valid credentials

@members @members01 @validcredentials @smoke @regression @sanity @all
Scenario Outline: Check members dashboard page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User clicks the members module
Then Al-Arabia members dashboard should display successfully

@members @members02 @validcredentials @smoke @regression @sanity @all
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




