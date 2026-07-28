package com.learn.StepDefinitions;

import com.learn.hooks.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import javax.swing.*;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SeleniumSteps {

    //added hooks so this before after hook run just for selenium scenario
    WebDriver driver;
    @Before("@Selenium")
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After("@Selenium")
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();


    }
    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
    @Then("the user is redirected to the dashboard")
    public void the_user_is_redirected_to_the_dashboard() {
       WebElement element = driver.findElement(By.xpath("//div[@class='app_logo']"));
       String title = element.getText();
        Assert.assertEquals("Swag Labs",title);

    }
}
