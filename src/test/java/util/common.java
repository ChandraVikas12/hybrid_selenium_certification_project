package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class common {
	private WebDriver driver;
	

	public void setupBrowser(String browser, String url) {

		String currDir = System.getProperty("user.dir");
		String fs = System.getProperty("file.separator");

		String driverDir = currDir + fs + "driver" + fs;

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverDir + "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverDir + "geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}

		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", driverDir + "msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}

		else {
			System.out.println("Valid browser was not provided, hence quitting the automation");
			System.exit(0);
		}

		if (url != "") {

			driver.get(url);
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
		}

		else
			driver.get("about:blank");

	}
	public WebDriver getDriver() {
		return driver;
	}
	public void closeTab() {
		driver.close();
	}
	public void quitBrowser() {
		driver.quit();
	}
	
	
	
	
}
