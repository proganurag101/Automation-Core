package com.learn.Selenium.JSExecutor;

import com.learn.Selenium.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JavaScriptExecutorTest extends BaseTest {
    @Test
    public void testScrollBy() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
        driver.manage().window().maximize();

        //JS executor initialisation
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //scrolling code
        //remember in selenium axis reference is top left corner (x,y)axis in pixels
        //down is +(ve) for y
        String script = "window.scrollBy(0,1000);";
        jse.executeScript(script);
        //add debugger to check till where we've scrolled
        System.out.println("Waiting for page state");
    }

    @Test
    public void testScrollIntoView()   {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
        driver.manage().window().maximize();

        //JS executor initialisation
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //code for scrolling to particular element
        //here we're using js script with the WebElement
        WebElement lastParagraphElement = driver.findElement(By.cssSelector("p:last-child"));
        String script = "arguments[0].scrollIntoView();";
        jse.executeScript(script, lastParagraphElement);


        //add debugger to check till where we've scrolled
        System.out.println("Waiting for page state");
    }

    @Test
    public void infiniteScrollTest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html");
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By tagName = By.tagName("p");

        List<WebElement> paragraphs = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tagName, 0));
        int initParagraphs = paragraphs.size(); //20
        assertThat(initParagraphs).isEqualTo(20);

        WebElement lastParagraph = driver.findElement(By.xpath(String.format("//p[%d]", initParagraphs)));
        String script = "arguments[0].scrollIntoView();";
        jse.executeScript(script, lastParagraph);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tagName, initParagraphs)); //40

    }

    //change color by updating DOM:
    @Test
    public void testColorPicker() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement colorPicker = driver.findElement(By.name("my-colors"));
        String initialColor = colorPicker.getDomProperty("value");
        Color redColor = new Color(255, 0, 0, 1);
        String script = String.format("arguments[0].setAttribute('value','%s')",redColor.asHex());
        jse.executeScript(script, colorPicker);

        String updatedColor = colorPicker.getDomProperty("value");
        System.out.println(updatedColor);
        //hexa with hexa comparison
        assertThat(updatedColor).isNotEqualTo(initialColor);
        //rgb vs rgb
        assertThat(Color.fromString(updatedColor)).isEqualTo(redColor);
    }

    @Test
    public void testeEnablingHiddenElement() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;


        //identify
        WebElement hiddenElement = driver.findElement(By.name("my-hidden"));
        assertThat(hiddenElement.isDisplayed()).isFalse();
        //script
        String script = "arguments[0].removeAttribute('type')";
        jse.executeScript(script, hiddenElement);

        assertThat(hiddenElement.isDisplayed()).isTrue();
        hiddenElement.sendKeys("random");
        assertThat(hiddenElement.getDomProperty("value")).isEqualTo("random");
    }

    @Test
    public void testAsyncJS(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        Duration pause = Duration.ofSeconds(2);
        String script = "const callback = arguments[arguments.length - 1];" +
                "window.setTimeout(callback," + pause.toMillis() + ");";

        //records current time
        long initMilliSeconds = System.currentTimeMillis();

        jse.executeAsyncScript(script);

        Duration elapsedTime = Duration.ofMillis(System.currentTimeMillis()- initMilliSeconds);
        System.out.println("The script took "+ elapsedTime.toMillis() + " to be executed");
        assertThat(elapsedTime).isGreaterThanOrEqualTo(pause);




    }

}
