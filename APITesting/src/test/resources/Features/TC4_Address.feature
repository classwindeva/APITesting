@Address
Feature: Address Module API Automation

  Scenario Outline: Verify User add user address to the application through api
    Given User add header and bearer authorization for accessing address endpoints
    When User add request body for add new address "<fist_name>","<last_name>","<mobile>","<apartment>", <state> , <city>, <country> ,"<zipcode>","<address>","<addressType>"
    And User send "POST" request for addUserAddress endpoint
    Then User should verify the statuscode is 200
    And User should verify the addUserAddress response message macthes "Address added successfully"

    Examples: 
      | fist_name | last_name | mobile     | apartment | state | city | country | zipcode | address | addressType |
      | Classwin  | Deva      | 9003332131 | Swara     |    10 | 0010 |     101 |  600028 | B303    | Home        |

  Scenario Outline: Verify User update user address to the application through api
    Given User add header and bearer authorization for accessing address endpoints
    When User add request body for update new address "<address_Id>","<fist_name>","<last_name>","<mobile>","<apartment>", <state> , <city> , <country> ,"<zipcode>","<address>","<addressType>"
    And User send "PUT" request for update addUserAddress endpoint
    Then User should verify the statuscode is 200
    And User should verify the update addUserAddress response message macthes "Address updated successfully"

    Examples: 
      | address_Id | fist_name | last_name | mobile     | apartment | state | city | country | zipcode | address | addressType |
      | address_Id | Classwin  | Deva      | 9003332131 | Swara     |    10 | 0010 |     101 |  600028 | B303    | Home        |

  Scenario Outline: Verify User update user address to the application through api
    Given User add header and bearer authorization for accessing address endpoints
    When User send "GET" request for get allUserAddress endpoint
    Then User should verify the statuscode is 200
    And User should verify the get all userAddress response message macthes "OK"

  Scenario Outline: Verify User update user address to the application through api
    Given User add header and bearer authorization for accessing address endpoints
    When User add request body for add new address "<address_Id>"
    When User send "DELETE" request for delete UserAddress endpoint
    Then User should verify the statuscode is 200
    And User should verify the delete UserAddress response message macthes "Address deleted successfully"

