Feature: Cart related functionality


  @Cart
  Scenario: Applying discount on a product1
    Given the product price is 100
    When a discount of 10.5% is applied
    Then the final price should be 89.5

  @Cart
  Scenario: Applying discount on a product2
    Given the product price is 100
    When a discount of 10% is applied
    Then the final price should be 90