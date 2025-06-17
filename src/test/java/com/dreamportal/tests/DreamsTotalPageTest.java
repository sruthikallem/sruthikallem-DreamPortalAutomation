package com.dreamportal.tests;

import com.dreamportal.pages.DreamsTotalPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DreamsTotalPageTest {
    WebDriver driver;
    DreamsTotalPage totalPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://arjitnigam.github.io/myDreams/dreams-total.html");
        totalPage = new DreamsTotalPage(driver);
    }

    
    @Test
    public void verifyDreamStats() {
        Assert.assertEquals(totalPage.getGoodDreamsCount(), "6", "Good dreams count mismatch.");
        Assert.assertEquals(totalPage.getBadDreamsCount(), "4", "Bad dreams count mismatch.");
        Assert.assertEquals(totalPage.getTotalDreamsCount(), "10", "Total dreams count mismatch.");
        Assert.assertEquals(totalPage.getRecurringDreamsCount(), "2", "Recurring dreams count mismatch.");
    }


    @Test
    public void verifyRecurringDreamsPresent() {
        Assert.assertTrue(totalPage.isRecurringDreamPresent("Flying over mountains"),
                "'Flying over mountains' should be listed as recurring.");
        Assert.assertTrue(totalPage.isRecurringDreamPresent("Lost in maze"),
                "'Lost in maze' should be listed as recurring.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
