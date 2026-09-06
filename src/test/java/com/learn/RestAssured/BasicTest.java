package com.learn.RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class BasicTest {

    @Test
    public void testGet() {
        given().baseUri("http://api.zippopotam.us")
                .when().get("us/90210")
                .then().statusCode(200);
    }

    @Test
    public void testCountryDetails() {
        given().baseUri("http://api.zippopotam.us")
                .when().get("us/90210")
                .then().statusCode(200)
                .body("country", equalTo("United States"))
                //Note: For keys with spaces,we keep them in single quote inside a double quote.
                .body("'country abbreviation'", equalTo("US"));

    }

    @Test
    public void VerifyPlacesDetails() {
        given().baseUri("http://api.zippopotam.us")
                .when().get("us/90210")
                .then().statusCode(200)
                .body("places[0].state", equalTo("California"))
                .body("places[0].'place name'", equalTo("Beverly Hills"))
                .body("places[0].longitude", equalTo("-118.4065"));
    }

    @Test
    public void verifyNegativeTest() {
        given().baseUri("http://api.zippopotam.us")
                .when().get("us/22881")
                .then().statusCode(404);
    }

    @Test
    public void validateResponseType() {
        given().baseUri("http://api.zippopotam.us")
                .when().get("us/90210")
                .then().statusCode(200)
                //use equalTo to avoid false positives
                .contentType(equalTo("application/json"));
    }

}