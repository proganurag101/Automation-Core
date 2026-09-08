package com.learn.RestAssured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.IsEqual.equalTo;

public class specTestNgAnnotation {

    //note below ones are different from normal specification declared without object.
    @BeforeClass
    public void setUp() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://api.zippopotam.us")
                .setContentType("application/json")
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(200)
                .expectResponseTime(lessThan(3000L))
                //whenever using builder class use .build
                .build();
    }

    //here RestAssured is going to add specification and do validation of response at runTime.
    @Test
    public void testStatusCode() {
        RestAssured.get("/us/90210");
    }

    @Test
    public void testCountryDetails() {
        RestAssured.get("/us/90210")
                .then()
                .body("country", equalTo("United States"))
                //Note: For keys with spaces,we keep them in single quote inside a double quote.
                .body("'country abbreviation'", equalTo("US"));

    }


    @Test
    public void VerifyPlacesDetails() {
        RestAssured.get("/us/90210")
                .then()
                .body("places[0].state", equalTo("California"))
                .body("places[0].'place name'", equalTo("Beverly Hills"))
                .body("places[0].longitude", equalTo("-118.4065"));
    }

    //Note when defined in BeforeClass,response spec part will always be considered,so below one fails.
    @Test
    public void ValidateNegativeCode() {
        RestAssured.get("users/228121").then().statusCode(404);
    }

}
