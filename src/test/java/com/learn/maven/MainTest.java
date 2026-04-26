package com.learn.maven;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.security.PublicKey;

import org.testng.*;
public class MainTest
{
    @Test
    public static void checkSumPositive()
    {
        System.out.println("Ran Positive Case!");
       int res = Main.calculator(4,5);
       if(res==9){
           System.out.println("TestCase Passed");
       }else{
           System.out.println("Failed");
       }
    }

    @Test
    public static void checkSumNegative(){
        System.out.println("Ran Negative Case!");
        int res = Main.calculator(7,10);
        if (res==9){
            System.out.println("Testcase Passed");
        }else {
            System.out.println("failed "+"Expected:5"+"Actual: "+res);
        }
}

    
}
