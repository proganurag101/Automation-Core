package com.learn.Selenium.Iframes;

import com.learn.Selenium.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IFramesTest extends BaseTest {
    @Test
    public void testIFrame(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/iframes.html");
        driver.manage().window().maximize();

        //to reach the IFrame section
        WebElement parentIframeElement = driver.findElement(By.id("my-iframe"));
        //switching to that IFrame.
        driver.switchTo().frame(parentIframeElement);
        //validating iframe
        WebElement iframeElement = driver.findElement(By.xpath("//p[@class='lead'][1]"));
        assertThat(iframeElement.getText()).contains("nascetur suspendisse");

        //switching back to parent Webpage
        //without below code main webpage is not accessible.
        driver.switchTo().defaultContent();
        WebElement headerText = driver.findElement(By.xpath("//h1[text()='IFrame']"));
        assertThat(headerText.getText()).isEqualTo("IFrame");
    }

    @Test
    public void testIframeEfficiently(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/iframes.html");
        driver.manage().window().maximize();

        //to add expicitWait as frame doesn't load fully
        //we tried 4th para it didn't load in above method

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("my-iframe"));

        By pTagName = By.tagName("p");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pTagName,0));//20 tags are there
        List<WebElement> paragraphs = driver.findElements(pTagName);
        assertThat(paragraphs).hasSize(20); //size is 20

        driver.switchTo().defaultContent();
        assertThat(driver.findElement(By.xpath("//h5")));



    }


}
