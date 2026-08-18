package com.learn.RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class BasicTest {

    @Test
    public void testGet(){
        given()
                .baseUri("http://api.zippopotam.us")
                .when().get("/us/90210")
                .then().statusCode(200)
                .body("country",equalTo("United States"));
    }
}
