package com.learn.maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait; // Import this
import org.openqa.selenium.support.ui.ExpectedConditions; // Import this
import java.time.Duration; // Import this for WebDriverWait

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTestNgTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();

    }

    @Test
    public void testTile() {
        driver.get("https://www.google.com/");

        String title = driver.getTitle();
        System.out.println("Title of the page is: " + title);
        Assert.assertEquals(title, "Google");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
