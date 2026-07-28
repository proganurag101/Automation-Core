package com.learn.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class ApiSteps {

    Response response;

    @Given("the API endpoint is available")
    public void the_api_endpoint_is_available() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }

    @When("a GET request is sent to {string}")
    public void a_get_request_is_sent_to(String userId) {
       response = RestAssured.get("/users/"+ userId);
    }

    @Then("the response code should be {int}")
    public void the_response_code_should_be(Integer expectedStausCode) {
     response.then().statusCode(expectedStausCode);
    }

    @Then("the response body should contain the username {string}")
    public void the_response_body_should_contain_the_username(String expectedUsername) {
        response.then().body("username",equalTo(expectedUsername));
    }

}
