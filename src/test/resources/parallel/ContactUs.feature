@Contact
Feature: Contact Us Feature

@Smoke @Skip
Scenario Outline: Contact Us scenario with different set of data
Given user navigates to contact us page
When user fills the form from given sheetname "<sheetname>" and rownumber <RowNumber>
And user clicks on send button
Then it shows a successful message "Your message has been successfully sent to our team."



Examples:

|sheetname|RowNumber|
|contactus|0|
|contactus|1|