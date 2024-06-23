@appointment
Feature: This feature is to book healthcare appointment
Scenario Outline: This test is to verify whether appointment is booking or not
Given the user is on the homepage
And the user clicks on the make appointment button
And the user logins using the username and password 
And the user selects the facility as "1" from the dropdown using "index"
And the user checks the checkbox of readmission
And the user selects radiobutton of Medicaid Healthcare program
And the user selects the Tenth date of next month
And the user adds necesssary comments as "<comment>"
And the user clicks on book appointment button
Then the user should see the title as "<title>" 
And the user should see the facility as "<facility>"
And the user should see the readmission status as "<status>"
And the user should see the program as "<program>"
And the user should see the date as "<date>"
And the user should see the comment as "<comment>"

Examples:
|title|comment|facility|status|program|date|
|Appointment Confirmation|For knee pain|Seoul CURA Healthcare Center|Yes|Medicaid|10/07/2024|


