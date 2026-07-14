Feature: User Login
  As a registered User
  I want to login to my account
  So that i can access my personalized dashboard


  @SmokeHooks
  Scenario: Successful login with valid credentials-1
    Given the user in on the login pages
    When the user enters valid credential
    Then the user should be redirectes to the dashboard

  @RegressionHooks
  Scenario: Successful login with In-valid credentials-2
    Given the user in on the login pages
    When the user enters valid credential
    Then the user should be redirectes to the dashboard

  Scenario: Successful login with valid credentials-3
    Given the user in on the login pages
    When the user enters valid credential
    Then the user should be redirectes to the dashboard