Feature: API validation

  @api
  Scenario: Get user details by id
    Given the API endpoint is available
    When  a GET request is sent to "1"
    Then the response code should be 200
    And the response body should contain the username "Bret"
