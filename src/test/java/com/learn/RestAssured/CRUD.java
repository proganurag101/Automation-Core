package com.learn.RestAssured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeClass;


public class CRUD {
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath= "/v2";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType("application/json").build();
    }


}
