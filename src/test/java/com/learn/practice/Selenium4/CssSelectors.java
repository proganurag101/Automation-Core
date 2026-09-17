package com.learn.practice.Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CssSelectors {
    WebDriver driver;

    // faster than xpaths:

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void TestCssSelector() {
        driver.get("https://skillector.com/pages/locators.html");
        // by id : #
        driver.findElement(By.cssSelector("#css-id-target")).click();

        // By className: .
        driver.findElement(By.cssSelector(".css-class-target")).click();

        // by mutiple classes: each dot represents a seperate class joined which was in
        // attribute.
        driver.findElement(By.cssSelector(".chip-btn.alpha.beta.locator-hit")).click();

        //by tag name scope (it has descendant selector as well)
        driver.findElement((By.cssSelector("div.target button[data-task-target='css-tag']"))).click();

        //mutiple css attributes
        driver.findElement(By.cssSelector("button[data-app='qa'][data-task-target='css-multi-attr']")).click();

    }
}
