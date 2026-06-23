package com.learn.Selenium.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LoginPageTests {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }

    @Test
    public void testLoginNormalApproach(){
        WebElement login = driver.findElement(By.id("username"));
        login.sendKeys("user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("user");

        WebElement submit = driver.findElement(By.cssSelector("button"));
        submit.click();

        WebElement success = driver.findElement(By.id("success"));
        assertThat(success.getText()).isEqualTo("Login successful");
    }

    @Test
    public void testValidLoginWithPageObjectApproach(){
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user","user");
        assertThat(loginPage.isLoginSuccessful()).isTrue();
    }

    @Test
    public void testInValidLoginWithPageObjectApproach(){
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user23","user");
        assertThat(loginPage.isErrorDisplayed()).isTrue();
    }

    @Test
    public void testValidLoginWithPageFactoryApproach(){
        driver.manage().window().maximize();
        LoginPageWithPageFactory loginPage = new LoginPageWithPageFactory(driver);
        loginPage.login("user","user");
        assertThat(loginPage.isLoginSuccessful()).isTrue();
    }

    @Test
    public void testInvalidLoginWithPageFactoryApproach(){
        driver.manage().window().maximize();
        LoginPageWithPageFactory loginPage = new LoginPageWithPageFactory(driver);
        loginPage.login("user","user");
        assertThat(loginPage.isLoginSuccessful()).isTrue();
    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
