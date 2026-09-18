package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browserfactory {
	static WebDriver driver;
	public static WebDriver getDriver() {
		return driver;
	}

 
	public static WebDriver Startbrowser(String browser ,String url){
		
		if(browser.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		
		}
		else if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		
		else if (browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		return driver;
		}
		
	}

