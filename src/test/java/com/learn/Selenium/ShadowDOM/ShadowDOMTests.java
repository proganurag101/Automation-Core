package com.learn.Selenium.ShadowDOM;

import com.learn.Selenium.BaseTest;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ShadowDOMTests extends BaseTest {

    @Test
    public void shadowDOMTest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
        driver.manage().window().maximize();

        //testing without shadowroot method,hence this fails
        //as textElement is inside Shadow DOM
        WebElement textElement = driver.findElement(By.cssSelector("p"));
        assertThat(textElement.getText()).isEqualTo("Hello Shadow DOM");
    }

    @Test
    public void orginalShadowDOMTest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
        driver.manage().window().maximize();

        //here we identify shadowHost and shadowRoot,
        //then we dig in shadowRoot,hence this works.
        WebElement content = driver.findElement(By.id("content"));
        SearchContext shadowRoot = content.getShadowRoot();

        WebElement textElement = shadowRoot.findElement(By.cssSelector("p"));
        assertThat(textElement.getText()).isEqualTo("Hello Shadow DOM");

    }

    @Test
    public void testShadowWithJSE() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
        driver.manage().window().maximize();
        WebElement content = driver.findElement(By.id("content"));

        //below 2 are the differentiating lines for finding shadowRoot
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        SearchContext shadowRoot = (SearchContext)jse.executeScript("return arguments[0].shadowRoot", content);

        WebElement textElement = shadowRoot.findElement(By.cssSelector("p"));
        assertThat(textElement.getText()).isEqualTo("Hello Shadow DOM");
    }
}
