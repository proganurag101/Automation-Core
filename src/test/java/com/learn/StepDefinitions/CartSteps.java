package com.learn.StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class CartSteps {

    //DATA TYPE EXAMPLE STEP DEF.
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

    //CART STEP DEF.
    @Given("The user add {string} in the cart")
    public void the_user_add_in_the_cart(String item) {
        System.out.println("Item added: " + item);
    }

    @When("The user proceed for checkout")
    public void the_user_proceed_for_checkout() {
        System.out.println("Redirecting to checkout");
    }

    @Then("The {string} should be present in cart with {int}")
    public void the_should_be_present_in_cart_with(String item, int price) {
        System.out.println("Product in cart: " + item + "with price: " + price);
    }
    //Advanced Parameterisation
    @Given("the user adds the following items to the cart:")
    public void the_user_adds_the_following_items_to_the_cart(DataTable dataTable) {
        List<Map<String, String>> items = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> item : items) {
            //code to add each item to the cart
            String itemName = item.get("item");
            String itemPrice = item.get("price");
            System.out.println("Item Name: " + itemName);
            System.out.println("Item Price: " + itemPrice);
        }


    }
    @Then("the total price should be {int}")
    public void the_total_price_should_be(int price){
        System.out.println("Total price: "+ price);
    }


}
