package com.learn.practice.Selenium4;

import groovy.lang.DelegatesTo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class IFrames {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://skillector.com/pages/frames.html");
    }

    //Normal frame in and out basics
    @Test
    public void testiFrame(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

         //first switchTo Frame
        driver.switchTo().frame("simple-frame");

         //access element inside frame
         driver.findElement(By.id("simple-frame-btn")).click();

         //switch back to outside default-content
         driver.switchTo().defaultContent();

         //access outer elements
        driver.findElement(By.id("simple-default-verify")).click();

    }


    //parentFrame() usage
    @Test
    public void testNestedFrame(){
        //outer frame
        driver.switchTo().frame("nested-frame-outer");

        //nested inner frame
        driver.switchTo().frame("nested-frame-inner");
        driver.findElement(By.id("nested-inner-btn")).click();

        //switching back to parent frame
        driver.switchTo().parentFrame();
        driver.findElement(By.id("nested-outer-btn")).click();

        //switch to outermost html:
        driver.switchTo().defaultContent();
        driver.findElement(By.id("nested-default-verify")).click();

    }

    @Test
    public void testNestedSequence(){
        //outer frame
        driver.switchTo().frame("app-iframe");
        driver.findElement(By.id("app-iframe-btn")).click();

        //inner frame
        driver.switchTo().frame("app-iframe-inner");
        driver.findElement(By.id("app-inner-btn")).click();

        //outermostFrame directly
        driver.switchTo().defaultContent();
        driver.findElement(By.id("iframe-default-verify")).click();
    }
}
