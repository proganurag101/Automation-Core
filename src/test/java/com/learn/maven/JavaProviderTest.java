package com.learn.maven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JavaProviderTest {
    @Test(dataProvider = "getData") //method where reference for dataProvider Class.
    public void testLogin(String Username,String Password){
        System.out.println("======START=====");
        System.out.println("Username is: "+Username+"Password is: "+Password);
        System.out.println("======END=======");
    }

    @DataProvider
    public Object[][] getData(){   //Object is java inbuilt class
        return new Object[][]{     //return with same data type
                {"User1 ", "Password1"},
                {"User2 ", "Password2"},
                {"User3 ", "Password3"},
                {"User4 ", "Password4"}
        };
    }
}
