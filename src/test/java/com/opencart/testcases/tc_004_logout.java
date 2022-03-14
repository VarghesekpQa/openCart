package com.opencart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pages.loginPage;

public class tc_004_logout extends baseClass {
	
	
	@Test(priority=3)			
	public void logOut() throws InterruptedException {
		
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
		
		lp.clickMyaccount();
		logger.info("click on myaccount link");
		
		lp.clickLogoutButton();
		logger.info("logout link clicked");
		
		
		if(driver.getPageSource().contains("You have been logged off your account. It is now safe to leave the computer.")) {
			logger.info("successfully logged out");
			Assert.assertTrue(true);
			
		}else{
			logger.info("logout unsuccessfull");
			Assert.assertTrue(false);	
		}
	}
	

}
