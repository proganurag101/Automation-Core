package com.learn.RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

// specification + dataDrivenTest
public class DataDrivenTest {

    RequestSpecification reqSpec = new RequestSpecBuilder()
            .setBaseUri("http://api.zippopotam.us")
            .setContentType("application/json")
            .build();

    ResponseSpecification respSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType("application/json")
            .expectResponseTime(lessThan(3000L))
            .build();


    //Manual Data Driven test
    @Test
    public void testPlaces() {
        given().spec(reqSpec)
                .when().get("us/90210")
                .then().spec(respSpec)
                .body("places[0].state", equalTo("California"));
    }

    @Test
    public void testPlaces2() {
        given().spec(reqSpec)
                .when().get("us/12345")
                .then().spec(respSpec)
                .body("places[0].state", equalTo("New York"));

    }

    @Test
    public void testPlaces3() {
        given().spec(reqSpec)
                .when().get("us/24848")
                .then().spec(respSpec)
                .body("places[0].state", equalTo("West Virginia"));

    }

    @Test
    public void testPlaces4() {
        given().spec(reqSpec)
                .when().get("in/228001")
                .then().spec(respSpec)
                .body("places[0].state", equalTo("Uttar Pradesh"));

    }

    //TestNg Based
    @Test(dataProvider = "zipCodeData")
    public void verifyStates(String countryCode, String zipCode, String State) {
        given().spec(reqSpec)
                .when().get("/" + countryCode + "/" + zipCode)
                .then().spec(respSpec)
                .body("places[0].state", equalTo(State));
    }
    //or

    //TestNg Based
    @Test(dataProvider = "zipCodeData")
    public void verifyStatesParam(String countryCode, String zipCode, String State) {
        given().spec(reqSpec)
                .pathParam("countryCode", countryCode)
                .pathParam("zipCode", zipCode)
                .when().get("/{countryCode}/{zipCode}")
                .then().spec(respSpec)
                .body("places[0].state", equalTo(State));
    }

    @DataProvider(name = "zipCodeData")
    public Object[][] getZipCodes() {
        return new Object[][]{
                {"us", "90210", "California"},
                {"us", "12345", "New York"},
                {"us", "24848", "West Virginia"},
                {"in", "228001", "Uttar Pradesh"},

        };
    }
}
