Feature: User Login
Registered user should be able to login to access the al-arabia features

@confirmaccount
Scenario Outline: Confirm account for newly register user
When User enters valid email address
And Enter valid password
And Click password field eye icon
And Clicks on Sign in button
Then User should login successfully
Then Al-Arabia dashboard should display successfully




