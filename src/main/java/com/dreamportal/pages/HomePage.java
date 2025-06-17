package com.dreamportal.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(id = "loader")
    WebElement loader;

    @FindBy(id="dreamButton")
    WebElement myDreamsButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaderDisplayed() {
        return loader.isDisplayed();
    }

    public boolean isMyDreamsButtonDisplayed() {
        return myDreamsButton.isDisplayed();
    }

    public void clickMyDreamsButton() {
        myDreamsButton.click();
    }
}
