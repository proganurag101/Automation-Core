package com.learn.practice.Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WindowsTab {
     WebDriver driver;
     @BeforeClass
    public void setUp(){
         driver = new ChromeDriver();
         driver.get("https://skillector.com/pages/windows.html");
     }

     @Test
    public void testWindowsTabs(){
         //Browser window already opened store window location.
         String mainWindow = driver.getWindowHandle();
         //open the 2nd window by clicking button
         driver.findElement(By.id("open-w1")).click();


         //we'll wait until 2 windows are opened up
         WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
         wait.until(ExpectedConditions.numberOfWindowsToBe(2));


         //we'll get address of the 2nd opened window.
         for(String windowHandle : driver.getWindowHandles()){
             if(!mainWindow.contentEquals(windowHandle)){
                 //switching to 2nd window.
                 driver.switchTo().window(windowHandle);
                 break;
             }
         }
         //perform action on 2nd window
         driver.findElement(By.id("child-complete")).click();
         driver.close();
         //switch back to 2nd window.
         driver.switchTo().window(mainWindow);

         //2n window:
         driver.findElement(By.id("open-w2")).click();
         wait.until(ExpectedConditions.numberOfWindowsToBe(2));

         for(String windowHandle : driver.getWindowHandles()){
             if(!mainWindow.contentEquals(windowHandle)){
                 driver.switchTo().window(windowHandle);
                 break;
             }
         }

         driver.findElement(By.id("child-complete")).click();
         driver.close();
         driver.switchTo().window(mainWindow);

//         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  : Not required.


         WebElement success = driver.findElement(By.id("window-status"));
         assertThat(success.getText()).isEqualTo("Passed: both child windows completed.");








     }
}
