Feature: User Login
  As a registered User
  I want to login to my account
  So that i can access my personalized dashboard


  Background:
    Given the user in on the login pages
    And the user enters valid credential

  @backgroundTest
  Scenario: Successful login
    When the user clicks "login" button
    Then the user should be redirected to the "home"

  @backgroundTest
  Scenario: Logout functionality
    Given  the user is logged in
    When  the user clicks "logout" button
    Then  the user should be redirected to the "login"