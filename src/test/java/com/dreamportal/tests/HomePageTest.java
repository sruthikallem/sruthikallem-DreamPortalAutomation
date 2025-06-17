package com.dreamportal.tests;

import com.dreamportal.pages.HomePage;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://arjitnigam.github.io/myDreams/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testLoaderAndButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainContent")));

      
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dreamButton")));

    
        Assert.assertTrue(homePage.isMyDreamsButtonDisplayed(), "'My Dreams' button is not displayed!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
