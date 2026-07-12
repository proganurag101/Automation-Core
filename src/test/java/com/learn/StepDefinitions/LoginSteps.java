package com.learn.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    @Given("the user in on the login pages")
    public void the_user_in_on_the_login_pages() {
        System.out.println("the user in on the login pages");

    }
    @When("the user enters valid credential")
    public void the_user_enters_valid_credential() {
        System.out.println("the user enters valid credential");

    }
    @Then("the user should be redirectes to the dashboard")
    public void the_user_should_be_redirectes_to_the_dashboard() {
        System.out.println("the user should be redirectes to the dashboard");
//        Assert.assertEquals(1,2);

    }

    @Given("the user enters {string} as the username and {string} as password")
    public void userEntersCredentials(String username,String password) {
        System.out.println("username: "+username+" Password: "+password );
    }

    @When("the user clicks login button")
    public void userClicksLoginButton(){
        System.out.println("the user clicks login button");
    }




}
