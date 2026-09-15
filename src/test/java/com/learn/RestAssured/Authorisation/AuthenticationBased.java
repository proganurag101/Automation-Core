package com.learn.RestAssured.Authorisation;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AuthenticationBased {
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "https://www.football-data.org/";
        RestAssured.basePath = "/v4";
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType("application/json")
                .addHeader("X-Auth-Token","1d6840f7fcc64464a235910a30c32714")
                .build();
    }

    @Test
    public void testCase1(){
        RestAssured.get("/teams").then().statusCode(200);
    }
}
