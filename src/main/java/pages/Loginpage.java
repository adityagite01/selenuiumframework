package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import dataprovider.Exelutility;
import helper.Utility;

public class Loginpage {

	WebDriver driver;
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;
	}
	
	By email=By.id("email1");
	By password=By.id("password1");
	By loginbutton=By.xpath("//button[contains(text(),'Sign')]");
	By wellcometext=By.xpath("//h4[contains(text(),'Welcome')]");
	
	
	
	
	public Dashboardpage logintosite(String user, String pass ) {
		
		Utility.typeOnElement(driver, email, user);
		Utility.typeOnElement(driver, password, pass);
		Utility.clickElement(driver, loginbutton);
		
		
		Dashboardpage Dashboard = new Dashboardpage(driver);
		
		return Dashboard;
		
		
		
		
		
		 
		 

		
	}
	
	
	 }

