package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import dataprovider.ConfigUtility;
import factory.Browserfactory;

public class Starter {
	
	public WebDriver driver;
@BeforeClass
public void setup() {
	driver=Browserfactory.Startbrowser(ConfigUtility.readProperty("browser"),
			ConfigUtility.readProperty("qaurl"));
}



@AfterClass
public void  closebrowser() {
	
	driver.quit();
}

}
