package com.learn.practice.Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Waits {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
         driver = new ChromeDriver();
         driver.get("https://skillector.com/pages/waits-dynamic.html");
    }

    @Test
    public void testDelayedElement(){
        driver.findElement(By.id("start-delay")).click();

        // Element is dynamically added to DOM; visibilityOfElementLocated waits for presence & display.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamic-target")));
        element.click();

        WebElement status = driver.findElement(By.id("delay-status"));
        assertThat(status.getText()).isEqualTo("Passed: dynamic target clicked.");
    }
    @Test
    public void testTemporaryDisabled(){
        // Element is already visible on load but disabled; elementToBeClickable waits until enabled=true.
        // Using 15s timeout to safely cover the 10,000ms JS timer without edge-case timeouts.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement disableElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("flaky-btn")));
        disableElement.click();

        WebElement status = driver.findElement(By.id("flaky-status"));
        assertThat(status.getText()).isEqualTo("Passed: flaky action completed.");
    }

    @Test
    public void testVisibilityClickability(){
        driver.findElement(By.id("explicit-start")).click();

        // Element appears after 4s delay; elementToBeClickable waits for rendering & interactability.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("explicit-target")));
        element2.click();

        WebElement status = driver.findElement(By.id("explicit-status"));
        assertThat(status.getText()).isEqualTo("Passed: explicit wait target clicked.");
    }
    // Polling with FluentWait
    @Test
    public void testPollingFluenWait(){
        driver.manage().window().maximize();
        driver.findElement(By.id("fluent-start")).click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Element renders first as disabled, then becomes enabled later.
        // elementToBeClickable ensures FluentWait polls until disabled attribute is removed.
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("fluent-target")));
        element.click();

        WebElement element3 = driver.findElement(By.id("fluent-status"));
        assertThat(element3.getText()).isEqualTo("Passed: fluent wait target clicked.");
    }

    @Test
    public void testExpectedConditions(){
        driver.findElement(By.id("ec-start")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // #ec-confirm is visible on page load but disabled.
        // ExpectedConditions.and(...) combines waiting for message text update AND button clickability.
        wait.until(ExpectedConditions.and(
                ExpectedConditions.textToBePresentInElementLocated(By.id("ec-message"), "Ready for confirmation"),
                ExpectedConditions.elementToBeClickable(By.id("ec-confirm"))
        ));
        
        WebElement expectedElement = driver.findElement(By.id("ec-confirm"));
        expectedElement.click();

        WebElement ecStatus = driver.findElement(By.id("ec-status"));
        assertThat(ecStatus.getText()).isEqualTo("Passed: expected conditions validated.");
    }
}
