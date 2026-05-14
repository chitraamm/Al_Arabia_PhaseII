Feature: Posters
Admin, Manager and Supervisor can able to access the Posters feature, if they are get the roles access only

@Posters @Posters01 @smoke @regression @all
Scenario Outline: To verify projects listing page
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Posters  
Then Posters Page should display successfully 

@Posters @Posters02 @smoke @regression @all
Scenario Outline: To verify Search a Poster 
Given Admin logged in with valid credentials and selects static Project
When Al-Arabia overall dashboard should display
And User able to click on profile
And Admin or user clicks the Master from the Profile
And User clicks the Posters   
And User search a Poster     
Then Searched Poster details get displayed successfully  

