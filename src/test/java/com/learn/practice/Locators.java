package com.learn.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Locators {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testLocators() {
        driver.get("https://skillector.com/pages/locators.html");
        WebElement element = driver.findElement(By.id("loc-id-target"));
        element.click();
        WebElement name = driver.findElement(By.name("locator_name_target"));
        name.click();
        (driver.findElement(By.className("locator-class-target"))).click();
        //find the unique block with a locator then a tag name
        (driver.findElement(By.id("tag-zone-basic")).findElement(By.tagName("button"))).click();
        (driver.findElement(By.linkText("Open Selenium Locator Resource"))).click();
        (driver.findElement(By.partialLinkText("Practice Guide"))).click();

    }
}
