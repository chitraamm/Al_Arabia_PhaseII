Feature: Profile
User should be able to complete the personal profile

@profile @profile01 @validcredentials @regression @sanity @all
Scenario Outline: To verify personal profile page   
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
Then Personal profile page displayed successfully 

@profile @profile02 @validcredentials @regression @sanity @all
Scenario Outline: User must be able to provide personal profile information
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
And User able to give personal profile information
And User able to click on update personal profile 
And User able to select yes option for saving deatils 
Then User Updated the profile details successfully as "<successMessage1>" or "<successMessage2>"
        Examples:
      | successMessage1       | successMessage2                 |
      | LOADING...            | Success  Company profile updated| 

@profile @profile03 @validcredentials @regression @sanity @all
Scenario Outline: User must be able to provide personal info and click on Reset form
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
And User able to give personal profile information
And User able to click on reset form personal profile 
Then User able to select yes option for reset the details

@profile @profile04 @validcredentials @regression @sanity @all
Scenario Outline: User must be able to provide personal info and click on Resetform Noreset button
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
When User able to give personal profile information
And User able to click on reset form personal profile 
Then User able to select no option for reset the details

@profile @profile05 @validcredentials @regression @sanity @all
Scenario Outline: User must be able to provide personal profile information
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
When User able to give personal profile information
And User able to click on update personal profile 
Then User able to select no option for saving deatils

@profile @profile06 @validcredentials @regression @sanity @all
Scenario Outline: User must be able to provide personal profile information
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
When User able to give personal profile information
Then IQAMA is required error message get displayed successfully

@profile @profile07 @validcredentials @regression @sanity @all
Scenario Outline: To verify the error message 'Phone number required' displayed or not 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
And User able to give personal profile information without Phone number  
Then Phone number is required error message get displayed successfully

@profile @profile08 @validcredentials @regression @sanity @all
Scenario Outline: To verify the error message 'Name is required' displayed or not 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
And Admin or User delete the member name
Then Name is required error message get displayed successfully

@profile @profile09 @validcredentials @regression @sanity @all
Scenario Outline: To verify the Vehicle Information Update 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile
And Admin or User update the members vehicle info profile page
Then Particular members profile get updated successfully as "<successMessage>"
 Examples:
      | successMessage                        |
      | Success Vehicle information updated   |
      
@profile @profile10 @validcredentials @regression @sanity @all
Scenario Outline: To verify the error message 'Licence plate number is required' displayed or not in the Vehicle Information 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile 
And Admin or User delete the licence number
Then Licence plate number is required error message get displayed successfully  

@profile @profile11 @validcredentials @regression @sanity @all
Scenario Outline: To verify the History Activities of the User 
Given Admin logged in with valid credentials
When Al-Arabia overall dashboard should display
And User able to click on profile
And User able to click on personal profile 
And User click on the History  
Then History page displayed successfully for the User   

