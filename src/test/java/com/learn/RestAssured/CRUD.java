package com.learn.RestAssured;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;
//32:20
public class CRUD {
    String id;
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath= "/v2";
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
        System.out.println("New pet Created: "+id);

    }
    //depends on method makes sure,prev. method is ran successfully.
    @Test(dependsOnMethods = "testPost")
    public void testGet(){
        given().when().get("/pet/"+id).then() //or just do RestAssured.get("/pet/"+id).then()
                .statusCode(200)
                .log().body();
    }

    @Test(dependsOnMethods = "testGet")
    public void testDelete(){
        RestAssured.delete("/pet/"+id).then()
                .statusCode(200)
                .log().body();
    }


}
