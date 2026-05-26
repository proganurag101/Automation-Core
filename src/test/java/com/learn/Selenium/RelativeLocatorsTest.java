package com.learn.Selenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RelativeLocatorsTest extends BaseTest {
    String url1 = "https://bonigarcia.dev/selenium-webdriver-java/login-form.html";
    String url2 = "https://demo.guru99.com/V4/index.php";

    @Test
    public void testRelativeLocatorAbove(){
        driver.get(url1);
        //identify password  using that identify login
        WebElement password = driver.findElement(By.id("password"));
        WebElement username = driver.findElement(RelativeLocator.with(By.tagName("input")).above(password));
        username.sendKeys("jack101");
        assertThat(username.getDomAttribute("name")).isEqualTo("username");

    }

    @Test
    public void testRelativeLocatorBelow(){
        driver.get(url1);
        //identify username using that find password
        WebElement userN = driver.findElement(By.id("username"));
        WebElement pass = driver.findElement(RelativeLocator.with(By.tagName("input")).below(userN));
        pass.sendKeys("pass123");
        assertThat(pass.getDomAttribute("name")).isEqualTo("password");
    }

    @Test
    public void testRelativeLocatorToleft(){
        driver.get(url2);
        //identify reset then on its left find login
        WebElement reset = driver.findElement(By.xpath("//input[@Type=\"reset\"]"));
        // also you can use: By.name("btnReset");


        //finding login with help of reset tag.
        WebElement login = driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(reset));

        assertThat(reset.isEnabled()).isTrue();
        assertThat(login.getDomAttribute("name")).isEqualTo("btnLogin");

    }

    @Test
    public void testRelativelocatorToRight(){
        driver.get(url2);

        //identify login then with that,identify reset on its right
        WebElement login = driver.findElement(By.name("btnLogin"));

        //identifying reset with login
        WebElement reset = driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(login));

        assertThat(reset.isEnabled()).isTrue();
        assertThat(reset.getDomAttribute("name")).isEqualTo("btnReset");


    }


}
