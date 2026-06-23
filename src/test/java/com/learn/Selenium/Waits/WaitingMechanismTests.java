package com.learn.Selenium.Waits;

import com.learn.Selenium.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class WaitingMechanismTests extends BaseTest {

    //without waits
    @Test
    public void testWithoutWaitSite(){ //passed when images are static
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");
        driver.manage().window().maximize();

        WebElement compass = driver.findElement(By.xpath("//img[@src='img/compass.png']"));
        assertThat(compass.getDomProperty("src")).contains("img/compass.png");
    }

    @Test
    public void testWithtWaitSite(){ //fails without wait code
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        driver.manage().window().maximize();

        WebElement compass = driver.findElement(By.xpath("//img[@src='img/compass.png']"));
        assertThat(compass.getDomProperty("src")).contains("img/compass.png");


    }

    @Test
    public void testWithtWaitSiteCompass(){ //fails without wait code
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        driver.manage().window().maximize();
        //added wait for same code
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement compass = driver.findElement(By.xpath("//img[@src='img/compass.png']"));
        assertThat(compass.getDomProperty("src")).contains("img/compass.png");
    }

    @Test
    public void testWithtWaitSiteAward(){ //fails without wait code
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        driver.manage().window().maximize();
        //added wait for same code
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement compass = driver.findElement(By.xpath("//img[@src='img/award.png']"));
        assertThat(compass.getDomProperty("src")).contains("img/award.png");
    }

    //ExplicitWait

    @Test
    public void implicitWaitTest(){ //fails without wait code
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        driver.manage().window().maximize();
       //implicit wait code:
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement award = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("award")));
        assertThat(award.getDomProperty("src")).contains("img/award.png");
    }


}
