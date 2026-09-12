package com.learn.RestAssured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;

public class CRUD {
    String id;

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType("application/json")
                .build();
    }

    @Test
    public void testPost() {

        String requestBody = "{\"category\":{\"id\":0,\"name\":\"Jack102\"},\"name\":\"doggie\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":2,\"name\":\"string\"}],\"status\":\"available\"}";

        Response response = given().body(requestBody).
                when().post("/pet");
        //Takes id value from response and convert it to string like id:211
        //then makes it:  id = "211"
        id = response.path("id").toString();
        System.out.println("New pet Created: " + id);

    }

    //depends on method makes sure,prev. method is ran successfully.
    @Test(dependsOnMethods = "testPost")
    public void testGet() {
        given().when().get("/pet/" + id).then() //or just do RestAssured.get("/pet/"+id).then()
                .statusCode(200)
                .log().body();
        System.out.println("Get call Done!");
    }

    @Test(dependsOnMethods = "testGet")
    public void testPut() {
        String requestBody = "{\"id\":"+id+",\"category\":{\"id\":0,\"name\":\"string\"},\"name\":\"doggie\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":0,\"name\":\"string\"}],\"status\":\"string\"}";
        given().body(requestBody)
                .when().put("/pet")
                .then().statusCode(200)
                .log().body();
        System.out.println("Put method executed!");
    }


    @Test(dependsOnMethods = "testPut")
    public void testDelete() {
        given().pathParam("id", id)
                .when().delete("/pet/{id}").then()
                .statusCode(200)
                .log().body();
    }
    @Test(dependsOnMethods = "testDelete")
    public void testGetVerify() {
        given().when().get("/pet/" + id).then() //or just do RestAssured.get("/pet/"+id).then()
                .statusCode(404)
                .log().body();
        System.out.println("Get call Verification Done!");
    }


}
