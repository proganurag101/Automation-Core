package com.learn.practice.Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AdvanceAction {

    //Drag and drop,hover,scrolling,Keyboard clicks using Actions class.


    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://skillector.com/pages/actions.html");
        driver.manage().window().maximize();
    }

    @Test
    public void testDragAndDrop(){
        WebElement source = driver.findElement(By.id("drag-item"));
        WebElement target = driver.findElement(By.id("drop-zone"));

        //Create actions class object
        Actions action = new Actions(driver);

        //In modern Selenium, .perform() automatically calls .build(), so .build().perform() can be shortened to .perform().
        //we'll be using only .perform now.
        action.dragAndDrop(source,target).build().perform();
    }

    @Test
    public void testHovering(){
        WebElement element = driver.findElement(By.id("hover-area"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        driver.findElement(By.id("hover-secret")).click();
    }

    @Test
    public void testKeyboardButton(){
        WebElement textArea = driver.findElement(By.xpath("//input[@id ='kbd-input']"));
        textArea.click();
        Actions action = new Actions(driver);


        //always make sure to add .build.perform
        //always release the keyDown
        action.keyDown(Keys.CONTROL).sendKeys(textArea,"Q").keyUp(Keys.CONTROL).release().perform();

        //success text
        WebElement successText = driver.findElement(By.cssSelector("#kbd-status"));
        assertThat(successText.getText()).isEqualTo("Passed: keyboard shortcut completed.");

    }

    @Test
    public void testSendText(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement textInput = driver.findElement(By.id("click-send-input"));

        textInput.click();
        textInput.sendKeys("ActionClickSend");

        driver.findElement(By.id("click-send-validate")).click();

        WebElement postSuccess = driver.findElement(By.id("click-send-status"));
        assertThat(postSuccess.getText()).isEqualTo("Passed: click and send completed.");

    }

    @Test
    //imp best example.
    public void testChaining(){
        WebElement element = driver.findElement(By.id("chain-first"));


        Actions action = new Actions(driver);
        //.sendKeys(Keys.TAB)   : clicks the button and done,keyDown keeps the button pressed.
        //.pause(Duration.ofMiilis) : pauses the action for the given duration
        action.click(element).sendKeys("ChainStart").sendKeys(Keys.TAB).pause(Duration.ofMillis(500)).sendKeys("ChainEnd").perform();

        driver.findElement(By.id("chain-validate")).click();

        WebElement checkStatus = driver.findElement(By.id("chain-status"));
        assertThat(checkStatus.getText()).isEqualTo("Passed: method chaining flow completed.");
    }

    @Test
    public void testRightClick(){
        WebElement element = driver.findElement(By.id("right-click-target"));
        Actions action = new Actions(driver);
        action.contextClick(element).perform();

        WebElement element2 =  driver.findElement(By.id("right-click-status"));
        assertThat(element2.getText()).isEqualTo("Passed: right click detected.");

    }

    @Test
    public void testPageUpDown(){
        WebElement element = driver.findElement(By.id("page-scroll-zone"));
        Actions action = new Actions(driver);
        action.click(element).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_DOWN).perform();
    }

    @Test
    public void testCmdEndCmdHome(){
        WebElement element = driver.findElement(By.id("command-scroll-zone"));
        Actions action = new Actions(driver);
        action.click(element).keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL).sendKeys(Keys.HOME).keyUp(Keys.CONTROL).release().perform();
    }

    @Test
    public void testScrolling(){
        WebElement target = driver.findElement(By.id("scroll-move-target"));
        Actions action = new Actions(driver);
        action.scrollToElement(target).click(target).perform();

    }

    @Test
    public void testKeyWithPause(){
       WebElement textInput =  driver.findElement(By.id("pause-keys-input"));
        Actions action = new Actions(driver);
        action.click(textInput).sendKeys("Hello").pause(Duration.ofSeconds(5)).sendKeys("World").perform();

       WebElement validate = driver.findElement(By.id("pause-keys-validate"));
       validate.click();
       WebElement success = driver.findElement(By.id("pause-keys-status"));
       assertThat(success.getText()).isEqualTo("Passed: send keys with pause completed.");
    }

    @Test
    public void clickElement(){
        driver.findElement(By.id("level1-area")).click();
        WebElement level2 = driver.findElement(By.id("level2-target"));
        WebElement level3 = driver.findElement(By.id("level3-target"));
        Actions action = new Actions(driver);
        action.moveToElement(level2).click(level2).moveToElement(level3).click(level3).perform();
    }




}
