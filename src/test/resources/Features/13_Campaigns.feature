Feature: Campaigns
Admin, Manager and Supervisor can able to access the Campaigns feature, if they are get the roles access only

@Campaigns @Campaigns01 @smoke @regression @all
Scenario Outline: To verify projects listing page
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And Admin or user clicks the Master
And User clicks the Campaigns 