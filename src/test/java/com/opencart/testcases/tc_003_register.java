package com.opencart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pages.loginPage;
import com.opencart.pages.registerPage;
import com.opencart.utilities.helper;

public class tc_003_register extends baseClass {
	
	@Test(priority=2)
	public void register() {
		
		driver.get(baseUrl);
		
		registerPage reg = new registerPage(driver);
		
		reg.clickOnRegisterLink();
		logger.info("click on register link");
		
		reg.setFirstname("kkl");
		logger.info("enter firstname");
		
		reg.setLastname("jdgjd");
		logger.info("enter lastname");
		
		reg.setEmail(""+helper.randomStringUtils()+"@gmail.com");
		logger.info("enter email");
		
		reg.setTelephone(332244);
		logger.info("enter telephone number");
		
		reg.setPassword("1234567890");
		logger.info("enter password");
		
		reg.setConfirmPassword("1234567890");
		logger.info("confirm password");
		
		reg.clickPrivacyPolicy();
		logger.info("click on privacy policy");
		
		reg.clickOnContinueButton();
		logger.info("click on continue button");
		
		if(driver.getPageSource().contains("Congratulations! Your new account has been successfully created!")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}	
	}
}
