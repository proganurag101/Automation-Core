package com.learn.maven;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class AssertionExampleTest {

    @Test
    public void testEquals(){
        Assert.assertEquals(5,5,"Both are not equal!");
    }

    @Test
    public void testNotEquals(){
        Assert.assertNotEquals(3,5,"Both are equal!");

    }

    @Test
    public void testTrue(){
        Assert.assertTrue(5>4,"The condition is true!");
    }

}
