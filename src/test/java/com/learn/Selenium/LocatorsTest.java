package com.learn.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class LocatorsTest extends BaseTest {
    public static final String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";


    @Test
    public void testByHtmlAttributes(){
        driver.get(url);

        //By Id
        WebElement textById = driver.findElement(By.id("my-text-id"));   //we fetch the the input tag where id is given as mentioned.
        assertThat(textById.getDomAttribute("type")).isEqualTo("text");
        assertThat(textById.getDomAttribute("myprop")).isEqualTo("myvalue");

        /// WebElement wali line se html ke us line pr ajao fir uske andar ke specific tags AsserThat ke andar ke domAtttrubute ko use krke validat kro
        // i.e WebElement->AsserThat->LocatorType->getDomAttribute->key to be checked->value to be validated.


        //by Name
        WebElement textByName = driver.findElement(By.name("my-date"));
        assertThat(textByName.getDomAttribute("class")).isEqualTo("form-control");
        assertThat(textByName.getDomAttribute("type")).isEqualTo("text");
    }
}
