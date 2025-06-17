package com.dreamportal.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DreamsTotalPage {
    WebDriver driver;

    public DreamsTotalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getGoodDreamsCount() {
        return driver.findElement(By.xpath("//td[text()='Good Dreams']/following-sibling::td")).getText();
    }

    public String getBadDreamsCount() {
        return driver.findElement(By.xpath("//td[text()='Bad Dreams']/following-sibling::td")).getText();
    }

    public String getTotalDreamsCount() {
        return driver.findElement(By.xpath("//td[text()='Total Dreams']/following-sibling::td")).getText();
    }

    public String getRecurringDreamsCount() {
        return driver.findElement(By.xpath("//td[text()='Recurring Dreams']/following-sibling::td")).getText();
    }


    public boolean isRecurringDreamPresent(String dreamName) {
        return driver.getPageSource().contains(dreamName);
    }
}
