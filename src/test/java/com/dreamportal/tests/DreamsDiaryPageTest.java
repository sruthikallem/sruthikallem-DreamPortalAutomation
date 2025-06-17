package com.dreamportal.tests;

import com.dreamportal.pages.DreamsDiaryPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class DreamsDiaryPageTest {
    WebDriver driver;
    DreamsDiaryPage diaryPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://arjitnigam.github.io/myDreams/dreams-diary.html");
        diaryPage = new DreamsDiaryPage(driver);
    }

    @Test
    public void verifyDreamEntriesCount() {
        List<WebElement> rows = diaryPage.getAllDreamRows();
        Assert.assertEquals(rows.size(), 10, "There should be exactly 10 dream entries.");
    }

    @Test
    public void verifyAllDreamTypesValid() {
        List<WebElement> dreamTypes = diaryPage.getDreamTypes();
        for (WebElement type : dreamTypes) {
            String text = type.getText();
            Assert.assertTrue(text.equals("Good") || text.equals("Bad"),
                    "Dream type should be either 'Good' or 'Bad'. Found: " + text);
        }
    }

    @Test
    public void verifyAllRowsHaveData() {
        Assert.assertTrue(diaryPage.areAllRowsComplete(), "Not all rows have complete data.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
