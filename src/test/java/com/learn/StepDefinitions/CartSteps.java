package com.learn.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {
    @Given("the product price is {int}")
    public void the_product_price_is(Integer int1) {
        System.out.println("The price of the product: "+ int1);
    }
    @When("a discount of {double}% is applied")
    public void a_discount_of_is_applied(Double double1) {
        System.out.println("Discount given: " + double1);
    }
    @Then("the final price should be {double}")
    public void the_final_price_should_be(double double2) {
        System.out.println("Final price:  "+double2);
    }
}
