
Feature: Admin Module Functionality
Background:
#Given User is logged into the application
Scenario: Verify Admin page access after login
Given User is logged into the application
When User clicks on Admin tab
Then Admin page should be displayed

Scenario: Search user by username
Given User is on Admin page
When User enters username in search box
And Clicks on search button
Then User should be displayed in search results

Scenario: Add a new user with valid details
Given User is on Admin page
When User clicks on Add button
And User enters valid user details
And Clicks on Save button
Then New user should be created successfully

Scenario: Edit existing user details
Given User is on Admin page
When User searches existing user
And User clicks on Edit button
And User updates user details
And Clicks on Save button

Scenario: Delete an existing user
Given user is on Admin page
When User searches existing user
And user clicks delete button
Then user should be deleted successfully