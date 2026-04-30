package com.learn.maven;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertEqualExample {

    @Test
    public void assertEqualTest(){
        int actual =2;
        int expected=2;
        Assert.assertEquals(actual,expected,"values are not equal");
    }
}
