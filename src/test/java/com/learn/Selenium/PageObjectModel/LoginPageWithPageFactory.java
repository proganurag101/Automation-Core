package com.learn.Selenium.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactory {

    private WebDriver driver;

    //locators
    //below By is an object and variables are its instances.
    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(css = "button")
    WebElement submitButton;

    @FindBy(id = "success")
    WebElement successMessage;

    @FindBy(id = "invalid")
    WebElement errorMessage;

    //constructor
    public LoginPageWithPageFactory (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public void login(String userName,String password){
        this.enterUsername(userName);
        this.enterPassword(password);
        this.clickLogin();
    }
    public boolean isLoginSuccessful(){
        return successMessage.isDisplayed();
    }
    public boolean isErrorDisplayed(){
        return errorMessage.isDisplayed();
    }
    private void enterUsername(String userName){
         usernameInput.sendKeys(userName);
    }

    private void enterPassword(String password){
         passwordInput.sendKeys(password);
    }

    private void clickLogin(){
        submitButton.click();
    }




}
