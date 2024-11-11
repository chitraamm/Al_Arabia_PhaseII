Feature: Profile
User should be able to complete the personal profile

@profile @profile01 @validcredentials @regression @sanity @all
Scenario Outline: T01_User must be able to provide personal profile information
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
And User able to give personal profile information
And User able to click on update personal profile
And User able to select yes option for saving deatils
Then User Updated the profile details successfully as"<successMessage>"
  Examples:
      | successMessage                   |
      | Success Personal profile updated |  

@profile @profile02 @validcredentials @regression @sanity @all
Scenario Outline: T02_User must be able to provide personal info and click on Reset form
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
And User able to give personal profile information
And User able to click on reset form personal profile 
Then User able to select yes option for reset the details

@profile @profile03 @validcredentials @regression @sanity @all
Scenario Outline: T03_User must be able to provide personal info and click on Resetform Noreset button
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
When User able to give personal profile information
And User able to click on reset form personal profile 
Then User able to select no option for reset the details

@profile @profile04 @validcredentials @regression @sanity @all
Scenario Outline: T04_User must be able to provide personal profile information
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
When User able to give personal profile information
And User able to click on update personal profile 
Then User able to select no option for saving deatils

@profile @profile05 @validcredentials @regression @sanity @all
Scenario Outline: T05_User must be able to provide personal profile information
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
When User able to give personal profile information
Then IQAMA is required error message get displayed successfully

@profile @profile06 @validcredentials @regression @sanity @all
Scenario Outline: T06_To verify the error message 'Location is Required' displayed or not
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
And User able to give personal profile information
Then User Updated the profile details successfully as"<successMessage>"
  Examples:
      | successMessage                   |
      | Success Personal profile updated | 

