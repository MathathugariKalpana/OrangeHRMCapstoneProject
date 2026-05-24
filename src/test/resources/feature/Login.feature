Feature: Login User Functionality
Scenario: Successful user login
Given User launches the application
When User enters valid username and valid password
And clicks on login button
Then user login should be successful


Scenario:   Login With Invalid UserName
Given User launches the application
When User enters invalid username and valid password
And clicks on login button
Then User should see invalid username error

Scenario:   Login With Invalid Password
Given User launches the application
When User enters valid username and invalid password
And clicks on login button
Then User should see invalid password error

Scenario: Login with blank credentials
Given User is on login page
When User leaves username and password blank
And Clicks on login button
Then User should see mandatory field error

Scenario: Verify all UI elements on Login page
Given User is on login page
Then Verify username textbox is displayed
And Verify password textbox is displayed
And Verify login button is displayed

Scenario: Verify error message for invalid login
Given User is on login page
When User enters invalid credentials
And Clicks on login button
Then Verify error message is displayed

Scenario: Verify forgot password link navigation
  Given User is on login page
  When User clicks on Forgot Password link
  Then User should navigate to reset password page

#Scenario: Reset password with valid username
#Given User is on reset password page
#When User enters valid username for reset
#And User clicks on reset password button
#Then Verify success message after reset

Scenario: Reset password with invalid username
Given User is on reset password page
When User enters invalid username for reset
And User clicks on reset password button
Then Verify reset password error message
