package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {
	
	
	private WebDriver driver;
	
	@CacheLookup
	@FindBy(xpath = "//h1")
	WebElement itemTitle;
	
	@FindBy(className = "f_price")
	WebElement itemPrice;
	
	public Product(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String itemTitle() {
		return itemTitle.getText();
		
	}
	
	public String itemPrice() {
		return itemPrice.getText();
		
		
	}

}
