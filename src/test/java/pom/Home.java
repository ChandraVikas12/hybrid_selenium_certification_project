package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	private WebDriver driver;
	
	@CacheLookup
	@FindBy(xpath = "//input[@placeholder ='What is on your mind today?']")
	WebElement searchBox;
	
	
	@FindBy(xpath = "//*[contains(text(),'Allow')]")
	WebElement allowNotification;
	
	public Home(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void searchText(String searchItem) throws InterruptedException {
		searchBox.clear();
		searchBox.sendKeys(searchItem);
		Thread.sleep(2000);
		searchBox.sendKeys(Keys.RETURN );
		
		
	}
	
	public void clickAllow() {
		allowNotification.click();
		
	}
	
	
	

}
