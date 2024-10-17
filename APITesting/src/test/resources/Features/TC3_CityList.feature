@City
Feature: City Module API automation

  Scenario: Get User Get Citylist through api
    Given User add Headers for to Citylist
    When User add request body state id for get city list
    When User send "POST" request for Citylist endpoint
    Then User should verify the statuscode is 200
    And User should verify the Citylist response message matches "Chennai" and saved Cityid
