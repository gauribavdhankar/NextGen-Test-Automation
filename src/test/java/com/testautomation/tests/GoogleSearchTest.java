package com.testautomation.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.Status;
import com.testautomation.utils.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Method;

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(Method method) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Start Extent test for this method
        ExtentTestManager.startTest(method.getName(), "Google Search Test");
    }

    @Test
    public void searchGoogle() {
        driver.get("https://www.google.com");
        ExtentTestManager.getTest().log(Status.INFO, "Navigated to Google");

        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.searchFor("Selenium");
        ExtentTestManager.getTest().log(Status.PASS, "Search completed successfully");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
