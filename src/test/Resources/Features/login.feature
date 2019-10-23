Feature: login valid and invalid scenario

  Background:
    Given user is on login page

    @login
    Scenario Outline: user enters valid details for login so user should be able to login successfully
      and when enters invalid details user should get error message

      When user enters valid "<username>" and "<password>"
      And click on login button
      Then user should able to login successfully
      And when enters invalid details user should get error message


      @valid&invaliddetails
      Examples:
      | username   |   password  |
      |   Admin    |   admin123  |
      |  admin12   |  admin      |