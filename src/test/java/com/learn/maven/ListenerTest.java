package com.learn.maven;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ExecutionListener.class})  //This connectes this class to our custom listerners.
public class ListenerTest {
    @Test
    public void testMethod1(){
        System.out.println("This is the actual test Method!");
        Assert.assertEquals(1,1);

    }

    @Test
    public void testMethod2(){
        System.out.println("This the 2nd method!");
        Assert.assertEquals(4,5);
    }

}
