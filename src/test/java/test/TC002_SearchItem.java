package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.Keyword;

public class TC002_SearchItem extends base {
	
	Keyword kw;
	
	
	@BeforeClass
	public void beforeClass() {
	 kw = new Keyword(driver);
		
	}
	@Parameters({"item"})
	@Test
	
	public void searchItem(String item) throws InterruptedException {
		
		Thread.sleep(5000);
		kw.allowNotification();
		//driver.switchTo().alert().accept();
		Thread.sleep(2000);
		kw.searchItem(item);	
	}
	
	
	@Parameters({"item2"})
	@Test(dependsOnMethods = {"searchItem"})
	
	public void searchItem2(String item2) throws InterruptedException {
		Thread.sleep(5000);
		kw.searchItem(item2);	
	}
	
	@Parameters({"item3"})
	@Test(dependsOnMethods = {"searchItem2"})
	
	public void searchItem3(String item3) throws InterruptedException {
		Thread.sleep(5000);
		kw.searchItem(item3);	
	}
	


}
