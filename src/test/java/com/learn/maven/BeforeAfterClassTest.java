package com.learn.maven;
import org.testng.annotations.*;
public class BeforeAfterClassTest {
    @BeforeClass
    public void BeforeClassTest(){
        System.out.println("I will be executed first in any class,before any method");
    }

    @Test
    public void testMethod(){
        System.out.println("I am being executed after any BeforeClass");
    }

    @AfterClass
    public void afterClassTest(){
        System.out.println("I am being executed after all the methods in classes are executed");
    }
}
