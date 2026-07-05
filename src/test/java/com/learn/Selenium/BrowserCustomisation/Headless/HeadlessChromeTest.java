package com.learn.Selenium.BrowserCustomisation.Headless;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HeadlessChromeTest {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        //below 2 are imp. lines for custom features
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void testHeadless(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement element = driver.findElement(By.id("my-text-id"));
        element.sendKeys("RandomVal");
        assertThat(element.getDomProperty("value")).isEqualTo("RandomVal");
    }
}
