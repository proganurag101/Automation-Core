package com.learn.Selenium.Alerts;
import com.learn.Selenium.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class AlertsTest extends BaseTest {

    @Test
    public void testSimpleAlert(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        driver.manage().window().maximize();

        WebElement simpleAlert = driver.findElement(By.id("my-alert"));
        simpleAlert.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: "+ alert.getText());
        assertThat(alert.getText()).isEqualTo("Hello world!");
        alert.accept(); //click Okay button
    }

    @Test
    public void testConfirmationAlert(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        driver.manage().window().maximize();

        WebElement confirmationAlert = driver.findElement(By.id("my-confirm"));
        confirmationAlert.click();
        Alert alert = driver.switchTo().alert(); //mandatory step
        System.out.println("Alert Text: "+ alert.getText());
        assertThat(alert.getText()).isEqualTo("Is this correct?");

        //choosing cancel
        alert.dismiss(); //click Okay button //40:00
        WebElement dismiss = driver.findElement(By.xpath("//p[text()='You chose: false']"));
        assertThat(dismiss.getText()).isEqualTo("You chose: false");


        //choosing okay
        confirmationAlert.click();
        alert.accept();
        assertThat(driver.findElement(By.id("confirm-text")).getText()).isEqualTo("You chose: true");

    }

    @Test
    public void testPromptAlert(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        driver.manage().window().maximize();

        WebElement promptAlert = driver.findElement(By.id("my-prompt"));
        promptAlert.click();
        Alert alert = driver.switchTo().alert();
        String text = "Random text";
        alert.sendKeys(text);
        alert.accept();
        assertThat(driver.findElement(By.id("prompt-text")).getText()).isEqualTo("You typed: "+text);

    }

    @Test
    public void testModal(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        driver.manage().window().maximize();

        WebElement modal = driver.findElement(By.id("my-modal"));
        modal.click();

        //here the page is not loading before we're executing below code.
//        WebElement modalText = driver.findElement(By.cssSelector(".modal-body"));
//        assertThat(modalText.getText()).isEqualTo("This is the modal body");


        WebElement closeButton =  driver.findElement(By.xpath("//button[text()='Close']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Corrected declaration
        wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        closeButton.click();
        assertThat(driver.findElement(By.id("modal-text")).getText()).isEqualTo("You chose: Close");

    }




}