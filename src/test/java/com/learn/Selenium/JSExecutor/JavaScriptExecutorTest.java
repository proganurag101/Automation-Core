package com.learn.Selenium.JSExecutor;

import com.learn.Selenium.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends BaseTest {
    @Test
    public void testScrollBy() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
        driver.manage().window().maximize();

        //JS executor initialisation
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //scrolling code
        String script = "window.scrollBy(0,1000);";
        jse.executeScript(script);
        //add debugger to check till where we've scrolled
        System.out.println("Waiting for page state");
    }

    @Test
    public void testScrollIntoView() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
        driver.manage().window().maximize();

        //JS executor initialisation
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //code for scrolling to a particular element
        WebElement lastParagraphElement = driver.findElement(By.cssSelector("p:last-child"));
        String script = "arguments[0].scrollIntoView();";
        jse.executeScript(script, lastParagraphElement);


        //add debugger to check till where we've scrolled
        System.out.println("Waiting for page state");
    }

}
