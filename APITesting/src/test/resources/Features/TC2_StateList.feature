@State
Feature: State Module API automation

  Scenario: Get User Get statelist through api
    Given User add Headers for to statelist
    When User send "GET" request for Statelist endpoint
    Then User should verify the statuscode is 200
    And User should verify the statelist response message matches "Tamil Nadu" and saved stateid
