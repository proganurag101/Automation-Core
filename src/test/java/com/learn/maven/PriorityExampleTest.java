package com.learn.maven;

import org.testng.annotations.Test;

public class PriorityExampleTest {
    @Test(priority = 2)
    public void a(){
        System.out.println("Method Priority: 2");
    }
    @Test(priority = 0)         // if we don't write any priority it is considered 0 only!
    public void b(){
        System.out.println("Method Priority: 0");
    }

    @Test(priority = 1)
    public void c(){
        System.out.println("Method Priority: 1");
    }
}
