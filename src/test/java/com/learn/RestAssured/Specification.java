package com.learn.RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.IsEqual.equalTo;

//1->RequestSpecification/ResponseSpecification reqSpec/respSpec = new RequestSpecBuilder()/ResponseBuilder()
//2->Write expected default spec,
//3->Do .build()
//4->Do given.spec(reqSpec)/then().spec(respSpec)

public class Specification {
    RequestSpecification reqSpec = new RequestSpecBuilder()
            .setBaseUri("http://api.zippopotam.us")
            .setContentType("application/json")
            .build();

    ResponseSpecification respSpec = new ResponseSpecBuilder()
            .expectContentType("application/json")
            .expectStatusCode(200)
            .expectResponseTime(lessThan(2000L))
            .build();

    ResponseSpecification respSpecError = new ResponseSpecBuilder()
            .expectContentType("application/json")
            .expectStatusCode(404)
            .build();


    @Test
    public void testGet() {
        given().spec(reqSpec)
                .when().get("us/90210")
                .then().spec(respSpec);
    }

    @Test
    public void testCountryDetails() {
        given().spec(reqSpec)
                .when().get("us/90210")
                .then().spec(respSpec)
                .body("country", equalTo("United States"))
                //Note: For keys with spaces,we keep them in single quote inside a double quote.
                .body("'country abbreviation'", equalTo("US"));

    }

    @Test
    public void VerifyPlacesDetails() {
        given().spec(reqSpec)
                .when().get("us/90210")
                .then().spec(respSpec)
                .body("places[0].state", equalTo("California"))
                .body("places[0].'place name'", equalTo("Beverly Hills"))
                .body("places[0].longitude", equalTo("-118.4065"));
    }

    @Test
    public void verifyNegativeTest() {
        given().spec(reqSpec)
                .when().get("us/22881")
                .then().spec(respSpecError);
    }

    @Test
    public void validateResponseType() {
        given().spec(reqSpec)
                .when().get("us/90210")
                .then().spec(respSpec);
    }
}
