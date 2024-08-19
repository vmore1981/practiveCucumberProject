
@regression @login_tests
Feature: 	Sause Demo Functionalities
					This is a automate sauce demo functionalities


# go to website
# type username and password
# click signin
# verify logged in succcessfully


# this is an example of a test case denied as a user step

Background:
Given user is on the login page



  
@smoke_tests @valid_login @ES-425
Scenario: Sauce demo valid login
#  Given user is on the login page
  When user enters a valid username and valid password
  And user clicks on the signin button
  Then user is logged successfully

Scenario: Sauce demo invalid login
#  Given user is on the login page 
  When user enters invalid username and valid password
  And user clicks on the signin button
  Then user should not be logged in


Scenario: Sauce demo valid user with invalid password
#  Given user is on the login page 
  When user enters valid username and invalid password
  And user clicks on the signin button
  Then user should not be logged in


@outline
Scenario Outline: Invalid login tests
Given user is on the login page
When user enters username "<username>" and password "<password>"
And user clicks on the signin button
Then user should not be logged in

Examples:
|    username     |    password    |
|    hellohello   |  secret_sauce  |
|  standard_user  | failespassword |
|  standard_user  |                |
|                 |  secret_sauce  |
|                 |                |


# New day in Cucumber Scenario Paramertisation Classes


@invalid_login_param

Scenario: Sauce demo invalid username login
	When user enters invalid username "invalidUsername" and invalid password "invalidPassword"
	And user clicks on the signin button	
	Then user should not be logged in with an error message as "Epic sadface: Username and password do not match any user in this service"
		 

#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

#@tag
#Feature: Title of your feature
#  I want to use this template for my feature file
#
#  @tag1
#  Scenario: Title of your scenario
#    Given I want to write a step with precondition
#    And some other precondition
#    When I complete action
#    And some other action
#    And yet another action
#    Then I validate the outcomes
#    And check more outcomes

#  @tag2
#  Scenario Outline: Title of your scenario outline
#    Given I want to write a step with <name>
#    When I check for the <value> in step
#    Then I verify the <status> in step

#    Examples: 
#      | name  | value | status  |
#      | name1 |     5 | success |
#      | name2 |     7 | Fail    |



