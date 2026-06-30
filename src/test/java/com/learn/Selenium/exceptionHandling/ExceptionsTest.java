package com.learn.Selenium.exceptionHandling;

import com.learn.Selenium.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExceptionsTest extends BaseTest {
    @Test
    public void noSuchElementExceptionTest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
//        //incorrect id
//        WebElement element = driver.findElement(By.id("my-text-if"));

        //we fix the locator,incase of NSE Exception
        WebElement element = driver.findElement(By.id("my-text-id"));
        element.sendKeys("Random value");

    }


    @Test
    public void noSuchElementExceptionTest2() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement landscape = driver.findElement(By.id("landscape"));
        //above element doesn't load immidiately and cause issue
        //Fix: Add implicit/explicit waits
        assertThat(landscape.getDomProperty("src")).containsIgnoringCase("landscape");

    }

    @Test
    public void testElementNotInteractableException() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.xpath("//input[@type='hidden']"));

        try {
            element.click();
        } catch (ElementNotInteractableException exception) {
            System.out.println("Unable to click on the element");
            //Handle such alert by try catch
            //add rest of the steps to fix such error
            //ex removing type='hidden' for handling hidden element
        }


    }
    @Test
    public void testNoAlertPresentException(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");

//        driver.findElement(By.id("my-alert")).click();
        Alert alert = driver.switchTo().alert();
        assertThat(alert.getText()).isEqualTo("Hello world!");
        alert.accept();

        //Fix: By adding proper locator to reach the alert,and click the alert.
        //Here we didn't identify the alert tab
    }

    @Test
    public void testNoSuchSessionException(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.manage().window().maximize();
        driver.quit();

        WebElement textInput = driver.findElement(By.id("my-text-id"));
        textInput.sendKeys("randomWord");

        //we've already closed the browser,no this exception,
        //Fix: Cross checked the code,if somewhere the driver is closing
    }

    @Test
    public void testInvalidSelectorsException(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.xpath("#my-text-id"));
        element.sendKeys("random");

        //Fix: here we've given selector as xpath for cssSelector syntax of id: #my-text-id"
    }

    @Test
    public void testStaleElementReference(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.manage().window().maximize();

        WebElement returnToIndex = driver.findElement(By.linkText("Return to index"));
        returnToIndex.click();

        String currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).contains("index.html");

        driver.findElement(By.xpath("//a[normalize-space()='Navigation']"));
        returnToIndex.click();
        //this above returnToIndex.click() is cause staleElement exception has webForms page is no more.
        //particularly return to index link.

        //stale means: outdated/not accurate/not fresh.


    }






}
