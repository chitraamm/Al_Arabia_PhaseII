Feature: Forgot password functionality
User should be able to change the password if user forgot his/her password

Background: Given User navigates to Login page

@forgotpassword @forgotpassword01 @validcredentials @smoke @regression @sanity @all
Scenario Outline: Reset password on forgetting it
When User clicks forgot password option
And User enters forgot password valid email address
And User clicks Send Reset link button
Then Proper confirmation email message should receive to user mail

@forgotpassword @forgotpassword02 @invalidemail @smoke @regression @all
Scenario Outline: Forgot password with invalid email address
When User clicks forgot password option
And User enters forgot password invalid email address
Then User should get a invalid email address error message in forgotpassword page

@forgotpassword @forgotpassword03 @invalidemail @smoke @regression @all
Scenario Outline: Forgot password without email address
When User clicks forgot password option
And User enters forgot password invalid email address and delete
Then User should get a email address or phone number is required error message

