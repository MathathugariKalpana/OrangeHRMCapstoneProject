Feature: Logout Functionality

Scenario: Verify logout functionality
Given User is logged into the application
When User clicks on profile dropdown
And User clicks on Logout button
Then User should be logged out successfully

Scenario: Verify session termination after logout
Given User logs out from application
When User clicks browser back button
Then User should not access application pages