package com.learn.maven;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BeforeAfterSuiteTest {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite: Initializing test suite setup.");
    }

    @Test
    public void testMethod1(){
        System.out.println("Test Method 1: Executed after BeforeSuite.");
    }

    @Test
    public void testMethod2(){
        System.out.println("Test Method 2: Executed after Test Method 1.");
    }

    @AfterSuite
    public void afterSuite(){ // Corrected typo in message
        System.out.println("AfterSuite: Cleaning up test suite resources.");
    }
}
