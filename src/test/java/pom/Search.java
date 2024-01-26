package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {
	
	
	private WebDriver driver;
	
	@CacheLookup
	@FindBy(xpath = "//h2")
	WebElement firstItem;
	

	
	
	
	public Search(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFirstSearch() {
		firstItem.click();
		
	}
	
	public Object countResults() {
		return results.size();
		
	}

}
