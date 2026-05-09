package com.learn.maven;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAfterTest {
    @BeforeTest
    public void setup(){
        System.out.println("BeforeTest: I run before a testMethod");
    }

    @Test
    public void testMethod1(){
        System.out.println("I run after BeforeTest has Ran:TestMethod-1");
    }

    @Test
    public void testMethod2(){
        System.out.println("I run after TestMethod-1 and TestMethod-2");
    }

    @AfterTest
    public void tearDown(){
        System.out.println("AfterTest: I run after all testMethods have ran!");
    }


}
