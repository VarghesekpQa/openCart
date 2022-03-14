package com.opencart.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.opencart.pages.loginPage;

public class tc_001_login extends baseClass {

	@Test(priority=0)
	public void login() throws InterruptedException, IOException {
		
		driver.get(baseUrl);
		
		loginPage lp = new loginPage(driver);
		
		lp.clickLogin();
		logger.info("login link clicked...");
		
		lp.setEmail(email);
		logger.info("email entered...");
		
		lp.setPassword(pass);
		logger.info("password entered...");
		Thread.sleep(3000);
		
		lp.clickLoginButton();
		logger.info("login button clicked...");
		
		if(driver.getTitle().equals("My Account")) {
			
			Assert.assertTrue(true);
			logger.info("testcase passed...");
			Thread.sleep(3000);
			
		}else {
			
			Assert.assertTrue(false);
			logger.info("testcase failed...");
		}	
	}
}
