Feature: User Login
  As a registered User
  I want to login to my account
  So that i can access my personalized dashboard


  @Smoke
  Scenario: Successful login with valid credentials
    Given the user in on the login pages
    When the user enters valid credential
    Then the user should be redirectes to the dashboard

  @Regression
  Scenario: Successful login with In-valid credentials
    Given the user in on the login pages
    When the user enters valid credential
    Then the user should be redirectes to the dashboard


  @LoginParameter
  Scenario: Login with admin credentials
    Given the user enters "admin" as the username and "admin123" as password
    When the user clicks login button
    Then the user should be redirectes to the dashboard
  @LoginParameter
  Scenario: Login with user credentials
    Given the user enters "user" as the username and "user123" as password
    When the user clicks login button
    Then the user should be redirectes to the dashboard