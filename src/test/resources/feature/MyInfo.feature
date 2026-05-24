Feature: My Info Functionality
Background:
#Given User is logged into the application
Scenario: Verify My Info page access
Given User is logged into application
When User clicks on My Info tab
Then My Info page should be displayed

Scenario: Update personal details
Given User is on My Info page
When User updates personal details
And User clicks save button for personal details
Then Personal details should be updated successfully

Scenario: Update contact details
Given User is on Contact Details page
When User updates contact details
And User clicks save button for contact details
Then Contact details should be updated successfully

Scenario: Save and verify updated information
Given User updates employee information
When User saves updated information
Then Updated information should be verified