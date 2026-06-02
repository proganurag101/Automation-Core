package com.learn.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InteractionsTest extends BaseTest{
    public static final String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
    @Test
    public void testSendKeys(){
        driver.get(url);
        WebElement textInput = driver.findElement(By.name("my-text"));
        String textValue = "AnuragYo!";
        textInput.sendKeys(textValue);
        assertThat(textInput.getDomProperty("value")).isEqualTo(textValue);

        textInput.clear();  //clear the contents of textbox
        assertThat(textInput.getDomProperty("value")).isEqualTo(textValue);
    }

    @Test
    public void testClickButton(){
        driver.get(url);

        //identify the button to be clicked by xpath.
        WebElement SubmitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        //perform click operation
        SubmitButton.click();

        //after click happened,validate result page,identifying the header
        WebElement confirmationHeader = driver.findElement(By.xpath("//h1[normalize-space()='Form submitted']"));
        //assert after identifying the resulting page header
        assertThat(confirmationHeader.getText()).isEqualTo("Form submitted");

    }

    @Test
    public void testClicklink(){
        driver.get(url);
        WebElement link = driver.findElement(By.linkText("Return to index"));
        link.click(); //performs leftClick

        //1st assertion:
        String currentUrl = driver.getCurrentUrl();  //gets the current url of page
        assertThat(currentUrl).contains("index.html");

        //2nd assertion:
        WebElement ConfirmationHeader = driver.findElement(By.xpath("//p[@class='lead']"));
        assertThat(ConfirmationHeader.getText()).contains("This site contains a collection of sample web pages to be tested with");
    }

    @Test
    public void testCheckBoxes(){
        driver.get(url);
        WebElement Checkbox = driver.findElement(By.cssSelector("[type=\"checkbox\"]:checked"));
        assertThat(Checkbox.getDomAttribute("id")).isEqualTo("my-check-1");
        assertThat(Checkbox.isSelected()).isTrue(); //is selected is used on radiobutton and check box

        //unchecked box
        WebElement uncheckedBox = driver.findElement(By.cssSelector("[type=\"checkbox\"]:not(:checked)"));
        assertThat(uncheckedBox.getDomAttribute("id")).isEqualTo("my-check-2");
        assertThat(uncheckedBox.isSelected()).isFalse();

        //for checkBox already selected:
        Checkbox.click(); //got unselected afterClick
        assertThat(Checkbox.isSelected()).isFalse();

        //for uncheckedBox after click
        uncheckedBox.click();
        assertThat(uncheckedBox.isSelected()).isTrue();

    }

    @Test
    public void testRadioButton(){
        driver.get(url);
        WebElement radioButton1 = driver.findElement(By.xpath("//input[@type=\"radio\"  and @checked]"));
        assertThat(radioButton1.getDomAttribute("id")).isEqualTo("my-radio-1");
        //is already checked by default
        assertThat(radioButton1.isSelected()).isTrue();

        WebElement radioButton2 = driver.findElement(By.xpath("//input[@type=\"radio\"  and not(@checked)]"));
        assertThat(radioButton2.getDomAttribute("id")).isEqualTo("my-radio-2");
        assertThat(radioButton2.isSelected()).isFalse();

        //after click radioButton2 is selected and 1 is auto unselected
        radioButton2.click();
        assertThat(radioButton1.isSelected()).isFalse();
        assertThat(radioButton2.isSelected()).isTrue();
    }

    @Test
    public void testDropDowns(){
        driver.get(url);
        WebElement listBox = driver.findElement(By.name("my-select"));

        //exclusive class for select
        Select select = new Select(listBox); //new object- select,for the listbox
        List<WebElement> options =  select.getOptions();

        for (WebElement option : options){
            System.out.println(option.getText());
        }
        //select on of the visible text from dropdown like one,two,three present there
        String optionValue = "Three";
        select.selectByVisibleText(optionValue); // we selected three
        assertThat(select.getFirstSelectedOption().getText()).isEqualTo(optionValue);
        // as 3 was selected earlier so our expected value matches


    }

    @Test
    public void testDataList(){
        driver.get(url);
        WebElement dataList = driver.findElement(By.name("my-datalist"));
        assertThat(dataList.getDomAttribute("list")).isEqualTo("my-options");
        dataList.click();

        WebElement option = driver.findElement(By.xpath("//datalist/option[2]")); //returns new york
        String optionValue = option.getDomAttribute("Value");  //fetching new york from option
        dataList.sendKeys(optionValue);

        assertThat(optionValue).isEqualTo("New York");










    }



}
