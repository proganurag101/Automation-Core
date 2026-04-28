package com.learn.maven;
import org.testng.annotations.*;
public class BeforeAfterAllAnnotationsTest {
    @BeforeSuite
    public void setUp() {
        System.out.println("BeforeSuite: This method will be executed first in the suite,before any method");
    }
    @BeforeTest
    public void setUpTest(){
        System.out.println("BeforeTest: This method will be executed first before any test method in the entire Suite");
    }
    @BeforeClass
    public void setUpClass(){
        System.out.println("BeforeClass: This method will run before any test method execution in a class");
    }
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("BeforeMethod: This method will run before each test method!");
    }
    @Test
    public void testMethod1(){
        System.out.println("TestMethod1: This id the actual testMethod1");
    }
    @Test
    public void testMethod2(){
        System.out.println("TestMethod2: This is the actual testMethod2");
    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("AfterMethod: This method will be executed after each testMethod");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("AfterClass: This method will be executed after all testMethod in the class");
    }
    @AfterTest
    public void tearDownTest(){
        System.out.println("AfterTest: This method will be executed after all testMethods are executed in each Test Section of testNG.xml");
    }
    @AfterSuite
    public void tearDownSuite(){
        System.out.println("AfterSuite: This method will be executed after all test method execution is completed in the whole suite!");
    }























}
