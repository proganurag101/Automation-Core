package com.learn.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {
    @Before
    public void setUp(){
        System.out.println("1st @BeforeHook:Running before cucumber scenario");
    }

    @After
    public void tearDown(){
        System.out.println("@AfterHook: Running after a scenario is executed");
    }

//    @Before(order = 1)
//    public void setUp() {
//        System.out.println("1st @BeforeHook:Running before cucumber scenario");
//    }
//
//    @Before(order = 2)
//    public void setUp2() {
//        System.out.println("2nd @BeforeHook:Running before cucumber scenario");
//    }
//
////    @After(order = 1)
////    public void tearDown() {
////        System.out.println("1st @AfterHook: Running after a scenario is executed");
////    }
////
////    @After(order = 2)
////    public void tearDown2() {
////        System.out.println("2nd @AfterHook: Running after a scenario is executed");
////    }
//
//
//    //@Before hooks run in ascending order (lower order value runs first).
//    //@After hooks run in descending order (higher order value runs first).
//
//    @Before("@SmokeHooks")
//    public void setUp2() {
//        System.out.println("@BeforeHook:Running before cucumber scenario");
//    }
//
//    @After("@RegressionHooks")
//    public void tearDown() {
//        System.out.println("@AfterHook: Running after a scenario is executed");
//    }
//
//    @BeforeStep
//    public void setUp3(){
//        System.out.println("@BeforeStep: I am running before a step ");
//    }
//
//
//    @AfterStep
//    public void tearDown3(){
//        System.out.println("@AfterStep: I am running after a step");
//    }
//


}
