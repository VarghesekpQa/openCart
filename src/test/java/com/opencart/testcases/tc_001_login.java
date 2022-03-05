package com.opencart.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.opencart.pages.loginPage;
import com.opencart.utilities.helper;

public class tc_001_login extends baseClass {

	@Test
	public void login() throws InterruptedException, IOException {
		
		driver.get(baseUrl);
		
		loginPage lp = new loginPage(driver);
		
		lp.clickLogin();
		
		lp.setEmail(email);
		lp.setPassword(pass);
		Thread.sleep(3000);
		
		lp.clickLoginButton();
		
		if(driver.getTitle().equals("My Accounttt")) {
			
			Assert.assertTrue(true);
			Thread.sleep(3000);
			
		}else {
			//captureScreenshot("login");
			Assert.assertTrue(false);
		}	
	}
	
	@Test
	public void login2() throws InterruptedException {
		
		throw new SkipException("Skipping this exception");
	}
	
	
	
}
