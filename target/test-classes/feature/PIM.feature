Feature: Employee Management Functionality
Background:
#Given User is logged into the application
Scenario: Add a new employee
Given User is on PIM page
When User clicks on Add Employee button
And User enters employee details
And User clicks Save button
Then Employee should be added successfully

Scenario: Search employee by ID
Given User is on Employee List page
When User enters employee ID
And User clicks Search button
Then Employee details should be displayed

Scenario: Edit employee details
Given User searches an employee
When User clicks Edit employee button
And User updates employee details
And User clicks Save button after edit
Then Employee details should be updated successfully

Scenario: Upload employee profile picture
Given User is on Add Employee page
When User uploads employee profile picture
And User clicks Save button
Then Profile picture should be uploaded successfully

Scenario: Delete employee record
Given User searches employee for delete
When User clicks Delete employee button
And User confirms employee deletion
Then Employee record should be deleted successfully