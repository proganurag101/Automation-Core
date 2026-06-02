package com.learn.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.ArrayList.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionsTest extends BaseTest {
    @Test
    public void testDoubleClick(){
        String url = "https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html";
        driver.get(url);
        driver.manage().window().maximize();


        Actions actions = new Actions(driver);


        WebElement dropdown2 = driver.findElement(By.id("my-dropdown-2"));
        actions.contextClick(dropdown2).build().perform(); //contextClick is used for right clicking.

        WebElement contextMenu = driver.findElement(By.id("context-menu-2"));
        assertThat(contextMenu.isDisplayed()).isTrue();

        WebElement dropdown3 = driver.findElement(By.id("my-dropdown-3"));
        actions.doubleClick(dropdown3).build().perform();
        //this is double right click with specific element


        WebElement contextMenu2 = driver.findElement(By.id("context-menu-3"));
        assertThat(contextMenu2.isDisplayed()).isTrue();

    }

    @Test
    public void testMouseHover(){
        String url = "https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html";
        driver.get(url);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        List<String> imageList = Arrays.asList("Compass","Calendar","Award","Landscape");
        for (String imageName : imageList){
            String locator = String.format("//img[@src='img/%s.png']",imageName.toLowerCase());
            //format(template,inputValue)-> imageName is made lowerCase then placed at %s place
            WebElement image = driver.findElement(By.xpath(locator));
            actions.moveToElement(image).build().perform();

            WebElement caption = driver.findElement(RelativeLocator.with(By.tagName("p")).near(image));
            assertThat(caption.getText()).isEqualTo(imageName);
        }
    }

    @Test
    public void testDragAndDrop(){
        //26:41
    }



}
