package com.learn.RestAssured;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;

public class CRUD {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath= "/v2";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType("application/json").build();
    }

    @Test
    public void testPost() {
        String requestBody = "{\"id\":7772,\"category\":{\"id\":0,\"name\":\"Jack102\"},\"name\":\"doggie\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":2,\"name\":\"string\"}],\"status\":\"available\"}";

        Response response = given().body(requestBody).
                when().post("/pet");
        String id = response.path("id").toString();
        System.out.println("New pet Created"+id);

    }
    @Test
    public void testGet(){
        RestAssured.get("/pet/7772").then()
                .statusCode(200)
                .log().body();
    }

    @Test
    public void testDelete(){
        RestAssured.delete("/pet/7772").then()
                .statusCode(200)
                .log().body();
    }


}
