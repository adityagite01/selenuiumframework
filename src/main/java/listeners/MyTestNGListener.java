package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;

import base.Starter;
import factory.Browserfactory;
import helper.Utility;

public class MyTestNGListener extends Starter implements ITestListener{
	
	public void onTestSuccess(ITestResult result) {
		
		ChainTestListener.log("Log:PASS  - Test Passed "+result.getMethod().getMethodName());
	}
	
	public void onTestFailure(ITestResult result) {
		
		ChainTestListener.log("Log:FAIL  - Test Failed "+result.getMethod().getMethodName()+" "+result.getThrowable().getMessage());
		String ScreenShoot =Utility.captureScreenshot(Browserfactory.getDriver());
		ChainTestListener.embed(ScreenShoot, "image/png");
	    
	  }
	
	public void onTestSkipped(ITestResult result) {
		ChainTestListener.log("Log:SKIPPED  - Test Skipped "+result.getMethod().getMethodName());
	  }

}
