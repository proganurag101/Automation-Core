package com.learn.Selenium.screenshots;

import com.learn.Selenium.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Screenshot extends BaseTest {

   @Test
   public void testScreenShotPNG() throws IOException {
      driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
      driver.manage().window().maximize();

      // Casts the WebDriver instance to TakesScreenshot to enable screenshot functionality.
      TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
      // Captures the screenshot as a temporary File object.
      File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
      // Defines the desired path and filename for the saved screenshot.
      Path destination = Paths.get("screenshot.png");
      // Moves the temporary screenshot file to the specified destination, replacing if it exists.
      Files.move(screenshot.toPath(),destination,REPLACE_EXISTING);
      // Asserts that the destination Path object was successfully created.
      assertThat(destination).isNotNull();

   }
   @Test
   public void testScreenshotBase64(){
      driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
      driver.manage().window().maximize();

      TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
      String screenshot = takeScreenshot.getScreenshotAs(OutputType.BASE64);
      System.out.println("Screenshot in Base64 format: data:image/png;base64,"+screenshot);
      assertThat(screenshot).isNotEmpty();
   }

   @Test
   public void testWebElementScreenShot() throws IOException {
      driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

      WebElement element = driver.findElement(By.name("my-file"));
      File screenshot = element.getScreenshotAs(OutputType.FILE);
      Path destination = Paths.get("elementSS.png");
      System.out.println(destination);
      Files.move(screenshot.toPath(),destination,REPLACE_EXISTING);
      assertThat(destination).isNotNull();




   }


}