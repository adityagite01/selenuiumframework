package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import base.Starter;
import dataprovider.Exelutility;
import pages.Dashboardpage;
import pages.Loginpage;


@Listeners(ChainTestListener.class)
public class Testcase extends Starter{

	
	@Test(dataProvider="logininfo")
	public void login(String user , String pass){
		
		Loginpage login=new Loginpage(driver);
		Dashboardpage Dashboard =login.logintosite(user,pass);
		
		Assert.assertTrue(driver.findElement(By.xpath("//h4[contains(text(),'Welcome')]")).isDisplayed(), "The submit button is not visible on the page.");
		
		
	}
	
	@Test
	public void logout() {
		
	}
	
	@DataProvider(name="logininfo")
	 public Object[][] getdata()
	 {
		Object arr[][]=Exelutility.getdata("test1");
		
		return arr;
		 
}
}
