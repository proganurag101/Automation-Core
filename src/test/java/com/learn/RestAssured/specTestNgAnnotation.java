package com.learn.RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.Request;
import org.testng.annotations.BeforeClass;

public class specTestNgAnnotation {

    @BeforeClass
    public void setUp(){
        RequestSpecification resSpec = new RequestSpecBuilder()
                .setBaseUri("https://www.google.com")
                .setContentType("application/json")
                .build();
    }
}
