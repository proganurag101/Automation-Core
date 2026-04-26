package com.learn.maven;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgTest {
    @Test(enabled = true,description = "My first Test")
    public void testAddPositive(){
        Assert.assertEquals(Main.calculator(4,5),9);
    }

    @Test
    public void testAddNegative(){
        Assert.assertEquals(Main.calculator(7,10),9);
    }
}
