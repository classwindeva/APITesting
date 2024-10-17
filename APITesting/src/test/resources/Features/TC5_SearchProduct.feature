@SearchProduct
Feature: SearchProduct Module API automation

  Scenario Outline: Get User SearchProduct through api
    Given User add Headers for to SearchProduct
    When User add request body for search product "<searchProduct>"
    When User send "POST" request for SearchProduct endpoint
    Then User should verify the statuscode is 200
    And User should verify the SearchProduct response message matches "OK"

    Examples: 
      | searchProduct |
      | nuts          |
