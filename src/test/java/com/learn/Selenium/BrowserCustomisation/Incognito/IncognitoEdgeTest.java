package com.learn.Selenium.BrowserCustomisation.Incognito;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IncognitoEdgeTest {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        driver = new EdgeDriver(options);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testHeadlessEdge(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement element = driver.findElement(By.id("my-text-id"));
        element.sendKeys("RandomVal");
        assertThat(element.getDomProperty("value")).isEqualTo("RandomVal");
    }

}
