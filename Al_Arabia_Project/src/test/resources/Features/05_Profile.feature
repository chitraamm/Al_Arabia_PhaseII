Feature: Profile
User should be able to complete the personal profile

@profile @profile01 @validcredentials @regression @sanity @all
Scenario Outline: User must be able to provide personal profile information
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
Then Personal profile should be displaying
When User able to give personal profile information
And User able to click on update personal profile 
And User able to select yes option for saving deatils
Then User able to get success popup message

