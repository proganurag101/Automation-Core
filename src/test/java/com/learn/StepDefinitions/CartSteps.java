package com.learn.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {
    @Given("the product price is {int}")
    public void the_product_price_is(Integer int1) {
        System.out.println("The price of the product: " + int1);
    }

    @When("a discount of {double}% is applied")
    public void a_discount_of_is_applied(Double double1) {
        System.out.println("Discount given: " + double1);
    }

    @Then("the final price should be {double}")
    public void the_final_price_should_be(double double2) {
        System.out.println("Final price:  " + double2);
    }

    @Given("The user add {string} in the cart")
    public void the_user_add_in_the_cart(String item) {
        System.out.println("Item added: "+item);
    }

    @When("The user proceed for checkout")
    public void the_user_proceed_for_checkout() {
        System.out.println("Redirecting to checkout");
    }

    @Then("The {string} should be present in cart with {int}")
    public void the_should_be_present_in_cart_with(String item, int price) {
        System.out.println("Product in cart: "+item +"with price: "+ price);
    }
}
