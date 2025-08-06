package com.testautomation.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.testautomation.pages.GoogleHomePage;
import com.testautomation.utils.ExcelReader;
import org.testng.annotations.DataProvider;

public class GoogleSearchTest extends BaseTest {

	@Test
	public void googleSearchTest() {
	    test = extent.createTest("Google Search Test");
	    GoogleHomePage google = new GoogleHomePage(driver);
	    google.open();
	    google.search("Selenium WebDriver");
	    test.pass("Searched for Selenium WebDriver");
	    test.info("Page title: " + driver.getTitle());
	}
	    @DataProvider(name = "searchData")
	    public Object[][] searchData() {
	        return ExcelReader.getData(
	            System.getProperty("user.dir") + "/src/test/resources/SearchData.xlsx",
	            "Sheet1"
	        );
	    }

	    @Test(dataProvider = "searchData")
	    public void googleSearchTest(String keyword) {
	        test = extent.createTest("Search Test - " + keyword);
	        GoogleHomePage google = new GoogleHomePage(driver);
	        google.open();
	        google.search(keyword);
	        test.pass("Searched for: " + keyword);
    }
}
