package com.learn.RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestUserApi {
//Given: BaseUrl/uri
//When: HTTP Method: Get,Post,Put,Delete with endpoint
//Then: reponse match i.e status code, body ,headers
    @Test
    public void testFirstApi() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .when()
                .get("users/1")
                .then()
                .statusCode(200)
                .body("username",equalTo("Bret"));
    }


}
