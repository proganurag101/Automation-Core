package com.learn.Selenium.CrossBrowserHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CrossBrowserTestNgXml {
    //Below code is specifically to run Test for each browser parallely
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //Get the current thread's Webdriver instance
    private WebDriver getDriver(){
        return driver.get();
    }

// TestNGxml->testTitle() ->initializeDriver
    @Test
    @Parameters("browser")   //testNg Parameter fetcher
    public void testTitle(String browser) {
        System.out.println("The thread ID for "+browser+ " is "+ Thread.currentThread().getId());
        // Initializes the WebDriver for the specified browser
        this.initliazeDriver(browser);
        getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertThat(getDriver().getTitle()).contains("Selenium WebDriver");
    }

    public void initliazeDriver(String browser) {
        WebDriver localDriver;
        if (browser.equalsIgnoreCase("chrome")) {
            localDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            localDriver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            localDriver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("unsupportedBrowser: " + browser);
        }
        localDriver.manage().window().maximize();
        driver.set(localDriver); //set webdriver for current thread
    }


    @AfterMethod
    public void tearDown() {
        if(getDriver()!=null){
            getDriver().quit();
            driver.remove();
        }

    }
}
