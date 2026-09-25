package com.learn.practice.Selenium4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Alerts {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://skillector.com/pages/alerts.html");
    }

    @Test
    public void testSimpleAlert() {
        //step-1: find and alert triggering button and click
        driver.findElement(By.id("alert-btn")).click();
        //step-2: switch to the alert,
        Alert simpleAlert = driver.switchTo().alert();
        //step-3: accept or dismiss.
        simpleAlert.accept();
    }

    @Test
    public void testPromptAlert(){

        driver.findElement(By.id("prompt-btn")).click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("AutomationRocks");
        promptAlert.accept();

    }

    @Test
    public void testNegativeConfirmationAlert(){

        driver.findElement(By.id("confirm-btn")).click();
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.dismiss();

    }

    @Test
    public void testPositiveConfirmationAlert(){

        driver.findElement(By.id("confirm-accept-btn")).click();
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.accept();

    }


}
