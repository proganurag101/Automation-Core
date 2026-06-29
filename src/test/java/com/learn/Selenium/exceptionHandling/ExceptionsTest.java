package com.learn.Selenium.exceptionHandling;

import com.learn.Selenium.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExceptionsTest extends BaseTest {
    @Test
    public void noSuchElementExceptionTest(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
//        //incorrect id
//        WebElement element = driver.findElement(By.id("my-text-if"));

        //we fix the locator,incase of NSE Exception
        WebElement element = driver.findElement(By.id("my-text-id"));
        element.sendKeys("Random value");

    }


    @Test
    public void noSuchElementExceptionTest2(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        driver.manage().window().maximize();

        //added implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement landscape = driver.findElement(By.id("landscape"));
        //above element doesn't load immidiately and cause issue
        //so we add explicit/implicit.
        assertThat(landscape.getDomProperty("src")).containsIgnoringCase("landscape");



    }

    @Test
    public void testElementNotInteractableException(){

    }



}
