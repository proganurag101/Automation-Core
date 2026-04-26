package com.learn.maven;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;

public class BeforeAfterSuiteTest {
    @BeforeSuite
    public void beforeSuite1(){
        System.out.println("I will run first,i am before Suite!");
    }

    @Test
    public void testMethod1(){
        System.out.println("I ran after before Suite!");
    }

    @Test
    public void testMethod2(){
        System.out.println("I run after 1st test Method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I run in the last,i am after SUite!");
    }
}
