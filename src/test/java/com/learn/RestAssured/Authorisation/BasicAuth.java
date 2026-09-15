package com.learn.RestAssured.Authorisation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BasicAuth {
    //basic Auth

    @Test
    public void testBasicAuth() {
        given().auth()
                .basic("postman", "password")
                .baseUri("https://postman-echo.com").when()
                .get("/basic-auth")
                .then().statusCode(200);
    }
    //negativeTest:
    @Test
    public void testBasicAuthNegative(){
        given().baseUri("https://postman-echo.com")
                .when().get("/basic-auth")
                .then().statusCode(401);

    }
}



