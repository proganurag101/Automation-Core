package com.learn.Selenium.Waits;

import com.learn.Selenium.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WaitingMechanismTests extends BaseTest {

    //without waits
    @Test
    public void testWithoutWaitSite(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");
        driver.manage().window().maximize();

        WebElement compass = driver.findElement(By.xpath("//img[@src='img/compass.png']"));
        assertThat(compass.getDomProperty("src")).contains("img/compass.png");
    }

    @Test
    public void testWithtWaitSite(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        driver.manage().window().maximize();

        WebElement compass = driver.findElement(By.xpath("//img[@src='img/compass.png']"));
        assertThat(compass.getDomProperty("src")).contains("img/compass.png");
    }



}
