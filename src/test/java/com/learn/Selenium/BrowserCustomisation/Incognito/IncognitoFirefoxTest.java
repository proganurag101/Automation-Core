package com.learn.Selenium.BrowserCustomisation.Incognito;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IncognitoFirefoxTest {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--private");
        driver = new FirefoxDriver(options);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void firefoxHeadLessTest(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement element = driver.findElement(By.id("my-text-id"));
        element.sendKeys("RandomVal");
        assertThat(element.getDomProperty("value")).isEqualTo("RandomVal");
    }

}
