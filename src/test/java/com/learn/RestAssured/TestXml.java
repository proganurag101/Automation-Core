package com.learn.RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestXml {
    @Test
    public void testJsonData() {
        given().baseUri("https://petstore.swagger.io/v2")
                .when().get("pet/9223372036854775807")
                .then().statusCode(200)
                .log().body();
    }

    @Test
    public void testxmlData() {
        //changed header as accept: application/xml
        given().baseUri("https://petstore.swagger.io/v2").accept("application/xml")
                .when().get("pet/9223372036854775807")
                .then().statusCode(200)
                .log().body().body("Pet.name",equalTo("doggie"));

    }

}
