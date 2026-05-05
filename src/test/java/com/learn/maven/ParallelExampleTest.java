package com.learn.maven;

import org.testng.annotations.Test;

public class ParallelExampleTest {
    @Test
    public void method1(){
        System.out.println("I am the method1");
        this.getThreadDetails();
    }
    @Test
    public void method2(){
        System.out.println("I am the method2");
        this.getThreadDetails();
    }
    @Test
    public void method3(){
        System.out.println("I am the method3");
        this.getThreadDetails();
    }
    @Test
    public void method4(){
        System.out.println("I am the method4");
        this.getThreadDetails();
    }

    public void getThreadDetails(){
        Thread currentThread = Thread.currentThread();
        //print thread details
        System.out.println("current Thread: " + currentThread);
        System.out.println("Thread Name" + currentThread.getName() );
    }


}
