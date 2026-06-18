package com.learn.Selenium.windows;

import com.learn.Selenium.BaseTest;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WindowHandlingTest extends BaseTest {
    @Test
    public void testNewTab(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        driver.manage().window().maximize();
        String initialHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertThat(driver.getWindowHandles()).hasSize(2);

        driver.switchTo().window(initialHandle);
        driver.close();
        assertThat(driver.getWindowHandles()).hasSize(1);
    }
    @Test
    public void testNewWindow(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        driver.manage().window().maximize();
        String initialHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertThat(driver.getWindowHandles()).hasSize(2);

        driver.switchTo().window(initialHandle);
        driver.close();
        assertThat(driver.getWindowHandles()).hasSize(1);
    }

}
