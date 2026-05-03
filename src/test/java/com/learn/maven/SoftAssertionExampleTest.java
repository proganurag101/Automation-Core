package com.learn.maven;

import org.junit.jupiter.params.provider.ArgumentsSource;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExampleTest {
    @Test
    public void testSoftAssertions(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(5,5);
        softAssert.assertNotEquals(5,5,"Values are Equal!");
        softAssert.assertNull(null,"Object is not null!");
        softAssert.assertAll();
    }
    public void testHardAssertion(){

    }
    @Test
    public void testHardAssertions(){
        Assert.assertEquals(5,5,"both are not equal");
        Assert.assertTrue(8>7,"Condition not true!");
        Assert.assertNotEquals(6,5,"Both are equal!");    }


}






