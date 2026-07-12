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

  @DataDrivenCartTest
  Scenario Outline: Adding different item to the cart
    Given The user add "<item>" in the cart
    When The user proceed for checkout
    Then The "<item>" should be present in cart with <price>

    Examples:
      | item     | price |
      | Laptop   | 100   |
      | Keyboard | 5     |
      | Monitor  | 15    |

  @cartDataTableTest
  Scenario: Multiple items added to the cart
    Given the user adds the following items to the cart:
      | item       | price |
      | Laptop     | 100   |
      | Keyboard   | 5     |
      | Monitor    | 15    |
      | Mouse      | 2     |
      | HeadPhones | 15    |
    Then the total price should be 137


