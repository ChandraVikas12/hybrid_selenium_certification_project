package util;

import static org.testng.Assert.assertTrue;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Reporter;

import pom.Home;
import pom.Product;
import pom.Search;



public class Keyword {
	private WebDriver driver;
	
	
	

	public Keyword(WebDriver driver){
		this.driver = driver;
	}


	public String getCurrentPageTitle() {
		return driver.getTitle();
	}

	public void pageRefresh() {
		driver.navigate().refresh();
		
	}
	
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}

	public String captureScreen() {
	    String path;
	    try {
	        WebDriver augmentedDriver = new Augmenter().augment(driver);
	        File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
	        path = "./test-output/screenshots/" + source.getName();
	        FileUtils.copyFile(source, new File(path)); 
	    }
	    catch(IOException e) {
	        path = "Failed to capture screenshot: " + e.getMessage();
	    }
	    return path;
	}
	
	
	public void takeScreenShotMethod(){
	    try{
	        Thread.sleep(10000);
	        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	        ImageIO.write(image, "jpg", new File("./test-output/robot-class/screenshot.jpg"));
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
	}
	public void closeTab() {
		driver.close();
		
		
	}

 	public void compareStrings(String expectedString, String actualString, String failureMessage) {
		Reporter.log("Expected String = " + expectedString);
		Reporter.log("Actual String = " + actualString);

		assertTrue(actualString.equals(expectedString), failureMessage + ",");
		
 	}
 	
 	public void allowNotification() throws InterruptedException {
 		Home home = new Home(driver);
 		home.clickAllow();
 		Thread.sleep(2000);
 	}
 	
 	
 	public void searchItemList(String item) throws InterruptedException {
 		Home home = new Home(driver);
 		Search search = new Search(driver);
 		Thread.sleep(2000);
 		home.searchText(item);
 		Thread.sleep(5000);
 		java.util.List<WebElement> elements = driver.findElements(By.className("search_blocks")); 
 		int total = elements.size();
 		String n = String.valueOf(total) ;
		
		Reporter.log("Total number of hotels in result is"+n);
 		
 		
 		
 		
 	}
 	
 	public void searchItem(String item) throws InterruptedException {
 		
 		Home home = new Home(driver);
 		Search search = new Search(driver);
 		Product product =new Product(driver);
 		Thread.sleep(2000);
 		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 		
		
 		home.searchText(item);
 		Thread.sleep(2000);
 		search.clickFirstSearch();
 		Thread.sleep(5000);
 		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
 		String winHandleBefore = driver.getWindowHandle();
		driver.switchTo().window(tabs.get(1));
		String title = product.itemTitle();
		String price = product.itemPrice();
		Thread.sleep(2000);		
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.close();	
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(2000);
		Reporter.log("The first product from the search for "+item+ " is"+ title + " and its price is " + price);
		
		
		
 		
 		
 	}
}