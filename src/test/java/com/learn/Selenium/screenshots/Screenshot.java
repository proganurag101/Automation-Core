package com.learn.Selenium.screenshots;

import com.learn.Selenium.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
      TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

      File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
      Path destination = Paths.get("screenshot.png");
      Files.move(screenshot.toPath(),destination,REPLACE_EXISTING);
      assertThat(destination).isNotNull();

   }


}
