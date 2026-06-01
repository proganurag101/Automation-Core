package com.learn.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InteractionsTest extends BaseTest{
    public static final String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
    @Test
    public void testSendKeys(){
        driver.get(url);
        WebElement textInput = driver.findElement(By.name("my-text"));
        String textValue = "AnuragYo!";
        textInput.sendKeys(textValue);
        assertThat(textInput.getDomProperty("value")).isEqualTo(textValue);

        textInput.clear();  //clear the contents of textbox
        assertThat(textInput.getDomProperty("value")).isEqualTo(textValue);
    }

    @Test
    public void testClickButton(){
        driver.get(url);

        //identify the button to be clicked by xpath.
        WebElement SubmitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        //perform click operation
        SubmitButton.click();

        //after click happened,validate result page,identifying the header
        WebElement confirmationHeader = driver.findElement(By.xpath("//h1[normalize-space()='Form submitted']"));
        //assert after identifying the resulting page header
        assertThat(confirmationHeader.getText()).isEqualTo("Form submitted");

    }

    @Test
    public void testClicklink(){
        driver.get(url);
        WebElement link = driver.findElement(By.linkText("Return to index"));
        link.click(); //performs leftClick

        //1st assertion:
        String currentUrl = driver.getCurrentUrl();  //gets the current url of page
        assertThat(currentUrl).contains("index.html");

        //2nd assertion:
        WebElement ConfirmationHeader = driver.findElement(By.xpath("//p[@class='lead']"));
        assertThat(ConfirmationHeader.getText()).contains("This site contains a collection of sample web pages to be tested with");
    }


}
