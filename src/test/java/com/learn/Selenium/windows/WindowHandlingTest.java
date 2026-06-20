package com.learn.Selenium.windows;

import com.learn.Selenium.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class WindowHandlingTest extends BaseTest {
    @Test
    public void testNewTab(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        driver.manage().window().maximize();

        //gets the address of current window
        String initialHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertThat(driver.getWindowHandles()).hasSize(2);

        //make sure driver back to old window
        driver.switchTo().window(initialHandle);
        //close initial window
        driver.close();
        assertThat(driver.getWindowHandles()).hasSize(1);
    }

    @Test
    public void testNewWindow(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        driver.manage().window().maximize();
        String initialHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW); //only difference
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertThat(driver.getWindowHandles()).hasSize(2);

        driver.switchTo().window(initialHandle);
        driver.close();
        assertThat(driver.getWindowHandles()).hasSize(1);
    }

    @Test
    public void testContentInNewTab(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        driver.manage().window().maximize();
        String initialHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[contains(@href,'random-calculator')]")).click();
        //now there are 2 handles open
        Set<String> windowHandles = driver.getWindowHandles();
        assertThat(windowHandles).hasSize(1);


        //driver switch to the address of pointer which has the new window(not equal to initial handle)
        for(String handle : windowHandles){
            if(!handle.equals(initialHandle)){
                driver.switchTo().window(handle);
                break;
            }
        }

        //after switching verify something on new window
        assertThat(driver.findElement(By.xpath("//h1[text()='Random calculator']")).getText()).isEqualTo("Random calculator");
        driver.close(); //close the current new window
        driver.switchTo().window(initialHandle); //switchback to first
        assertThat(windowHandles).hasSize(1);// recheck size






    }

}
