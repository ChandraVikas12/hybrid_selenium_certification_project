package test;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.Keyword;

public class TC000_Basic extends base {
	
	Keyword kw;
	
	@BeforeClass
	public void beforeClass() {
		kw = new Keyword(driver);
		
	}
	
  
  @Test (priority = 20)
  public void titleValidation() {
	  
	  String expectedTitle = "Online Shopping Site India - Shop Online for men, women and kids fashion, home, kitchen, health, sports and more products at ShopClues";
	  String actualTitle = kw.getCurrentPageTitle();
	  Reporter.log("Expected Title = " + expectedTitle);
	  Reporter.log("Actual Title =" + actualTitle);
	  assertTrue(actualTitle.equals(expectedTitle),"Title Validation Failed"); 
			  }
  @Test (priority =30)
  public void urlValidation() {
	  String expectedURL = "https://www.shopclues.com/";
	  String actualURL = kw.getCurrentPageUrl();
	  Reporter.log("Expected URL = " + expectedURL);
	  Reporter.log("Actual URL =" + actualURL);
	  assertTrue(actualURL.equals(expectedURL),"URL Validation Failed");  
			  }
}
