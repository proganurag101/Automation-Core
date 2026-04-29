package com.learn.maven;

import org.testng.annotations.Test;

public class GroupingTest {
    @Test(groups ={"smoke"})
    public void smokeTest(){
        System.out.println("Smoke Test 1");
    }
    @Test(groups = {"regression"})
    public void regressionTest(){
        System.out.println("Regression Test 1");
    }
    @Test(groups = {"smoke","regression"})
    public void smokeRegression(){
        System.out.println(" smoke and regression Test");
    }

}
