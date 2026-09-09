package com.learn.RestAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class LogTest {

    @Test
    public void testAllLog() {
        given().baseUri("http://api.zippopotam.us").log().all()
                .when().get("us/90210")
                .then().statusCode(200).log().all();
    }
    @Test
    public void testSpecificLog(){
        given().baseUri("http://api.zippopotam.us")
                .log().method().and()
                .log().uri().and()
                .log().headers()

                .when().get("us/90210")
                .then()
                .log().body().and()
                .log().headers().and()
                .log().status().and()
                .statusCode(200);
    }
}
