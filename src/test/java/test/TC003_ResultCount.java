package test;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.Keyword;

public class TC003_ResultCount extends base {
	
	Keyword kw;
	
	
	@BeforeClass
	public void beforeClass() {
	 kw = new Keyword(driver);
		
	}
	@Parameters({"item4"})
	@Test
	
	public void searchItem(String item4) throws InterruptedException {
		
		Thread.sleep(5000);
		kw.allowNotification();
		//driver.switchTo().alert().accept();
		Thread.sleep(2000);
		kw.searchItemList(item4);	
		
		
	}
}
	
	