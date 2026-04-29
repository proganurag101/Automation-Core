package com.learn.maven;

import org.testng.annotations.Test;

public class GroupingPriorityExample {
    @Test(groups = {"smoke"},priority = 1)
    public void smokeTest(){
        System.out.println("Smoke test 1");
    }

    @Test(groups = {"regression"},priority = 2)
    public void regressionTest(){
        System.out.println("Regression test 1");
    }

    @Test(groups = {"smoke","regression"},priority = 0)
    public void smokeRegressionTest(){
        System.out.println("Smoke and Regresion Test");
    }
}
