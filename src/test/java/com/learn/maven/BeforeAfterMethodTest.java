package com.learn.maven;
import org.testng.*;
import org.testng.annotations.*;

public class BeforeAfterMethodTest {

    @BeforeMethod
    public void setup(){
        System.out.println("I am executed before @Test");
    }

    @Test
    public void testMethod(){
        System.out.println("I am the actual testMethod");
    }

    @Test
    public void testMethod2(){
        System.out.println("I am the actual testMethod2");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("I will be executed afterTestMethod");
    }


}
