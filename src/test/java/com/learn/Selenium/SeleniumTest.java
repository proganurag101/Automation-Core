package com.learn.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class SeleniumTest {

    @Test
    public void seleniumTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com/browse");
        String title = driver.getTitle();
        System.out.println("Your Title is : "+ title);
        Assert.assertEquals("Netflix",title,"Title is incorrect!");
        driver.close();
    }

}
