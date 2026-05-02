package com.learn.maven;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    @Test
    @Parameters({"username","password"})
    public void testLogin(String username,String pass){
        System.out.println("Your Username: "+username);
        System.out.println("Your Pass: "+pass);
    }
}
