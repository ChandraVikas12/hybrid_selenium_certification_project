package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import util.common;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class base {
	static WebDriver driver;
	util.common common;
	
	@Parameters({"browser","url"})
	@BeforeClass (alwaysRun = true)
	public void beforeClass(String browser, String url) {
		common = new common();
		common.setupBrowser(browser, url);
		driver = common.getDriver();
				}


	@AfterClass(alwaysRun = true)
		public void afterClasst() {
		common.quitBrowser();
		}


}
