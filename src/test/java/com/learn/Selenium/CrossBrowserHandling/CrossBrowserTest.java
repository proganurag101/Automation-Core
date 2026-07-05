package com.learn.Selenium.CrossBrowserHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CrossBrowserTest {
    private WebDriver driver;

    @Test(dataProvider = "getBrowserData")
    public void testTitle(String browser) {
        // Initializes the WebDriver for the specified browser
        this.initliazeDriver(browser);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }
    
    public void initliazeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("unsupportedBrowser: " + browser);
        }
        driver.manage().window().maximize();
    }

    // Marks this method as a TestNG Data Provider
    @DataProvider
    public Object[][] getBrowserData(){
        // Returns a 2D array of browser names for test execution
        return new Object[][]{
                {"Chrome"},
                {"Edge"},
                {"firefox"}
        };
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}