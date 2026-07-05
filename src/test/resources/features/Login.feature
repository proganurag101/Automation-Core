Feature: User Login
  As a registered User
  I want to login to my account
  So that i can access my personalized dashboard

  Scenario: Successful login with valid credentials
    Given the user in on the login page
    When the user enters valid credential
    Then the user should be redirectes to the dashboard