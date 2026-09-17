package com.learn.practice.Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Locators {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }

    @Test
    public void testLocators() {
        driver.get("https://skillector.com/pages/locators.html");
        //By id
        WebElement element = driver.findElement(By.id("loc-id-target"));
        element.click();
        //By name
        WebElement name = driver.findElement(By.name("locator_name_target"));
        name.click();
        //By className
        (driver.findElement(By.className("locator-class-target"))).click();
        //Tag name

        //find the unique block with a locator then a tag name
        (driver.findElement(By.id("tag-zone-basic")).findElement(By.tagName("button"))).click();
        //link text
        (driver.findElement(By.linkText("Open Selenium Locator Resource"))).click();
        //partial link text
        (driver.findElement(By.partialLinkText("Practice Guide"))).click();

        //x-path (only text() is with =),rest with function(@attr,valur);
        //xpath = tag[@Attr="value"]
        driver.findElement(By.xpath("//button[text()='Checkout Now']")).click();

        //contains
        driver.findElement(By.xpath("//button[contains(@data-order,'qa-contains-btn-42')]")).click();

        //starts-with
        driver.findElement(By.xpath("//button[starts-with(@id,'start-node-778')]")).click();

        //using parentheses: () index:
        driver.findElement(By.xpath("(//button[@class='grp-btn'])[2]")).click();

        //using Combination of functions: contains(text()) + starts-with(@id)
        driver.findElement(By.xpath("//button[contains(text(),'Run Combo Validation') and starts-with(@id,'combo-node-19')]")).click();

        //using mutiple attribute in xpath predicate
        driver.findElement(By.xpath("//button[normalize-space(text())='Pay Gold' and @data-tier='gold']")).click();

         //Axes : child-> syntax : xpath/child::tag
        driver.findElement(By.xpath("//div[@id='axis-child-root']/child::button")).click();

        //Axes : parent-> syntax: xpath/parent::tag/tag of parent
        driver.findElement(By.xpath("//span[@id='axis-parent-anchor']/parent::div/button")).click();

    }
}
