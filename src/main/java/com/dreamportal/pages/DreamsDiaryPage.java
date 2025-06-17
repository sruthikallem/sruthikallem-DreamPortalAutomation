package com.dreamportal.pages;

import java.util.List;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DreamsDiaryPage {
    WebDriver driver;

    public DreamsDiaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    public List<WebElement> getAllDreamRows() {
        return driver.findElements(By.xpath("//table[@id='dreamsDiary']/tbody/tr"));
    }

    
    public List<WebElement> getDreamTypes() {
        return driver.findElements(By.xpath("//table[@id='dreamsDiary']/tbody/tr/td[3]"));
    }

    public boolean areAllRowsComplete() {
        List<WebElement> rows = getAllDreamRows();
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                if (cell.getText().trim().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}
