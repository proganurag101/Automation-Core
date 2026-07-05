package com.learn.Selenium.BrowserCustomisation.Insecure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color; // Import Selenium's Color class
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InsecureChromeTest {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        //same for edge and firefox
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testInsecure(){
        driver.get("https://self-signed.badssl.com/");
        String bgColor = driver.findElement(By.tagName("Body")).getCssValue("background-color");
       Color red = new Color(255,0,0,1);

        // CORRECTED LINE: Parse CSS color string using Selenium's Color class and convert to AWT Color
        assertThat(Color.fromString(bgColor)).isEqualTo(red);
    }
}