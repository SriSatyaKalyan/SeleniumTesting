#Each feature file contains one feature
#Feature files use Gherkin language - Business language
Feature: Test the LOGIN functionality of "SDET University"

#A feature file may have given different specific scenarios
#Scenarios use Given-When-Then structure

Scenario: The user should be able to login when he uses correct username and password
Given User is on the Login page
When  User enters correct username and correct password
Then  User gets confirmation

Scenario Outline:The USer should be able to login
Given user is on the login page
When user enters email<username>
And user enters password<password>
Then user gets confirmation

Examples:
| username | password |
| tim@testemail.com | trpass |
| rw@testemail.com | rwpass |
| jv@testemail.com | jvpass |

