@Login
Feature: Login Module API automation

  Scenario: Get User logtoken from login endPoint
    Given User add Header
    When User add basic authentication for login
    And User send "POST" request for Login endpoint
    Then User should verify the statuscode is 200
    And User should verify the login response body firstname present as "Classwin" and get the logtoken saved
