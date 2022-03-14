package com.opencart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pages.productSearchPage;

public class tc_005_searchProduct extends baseClass {

	@Test(priority=4)
	public void searchProductWithValidName() {
		
		productSearchPage ps = new productSearchPage(driver);
		
		ps.enterProduct("iphone");
		logger.info("enter product name");
		
		ps.clickOnSearchButton();
		logger.info("click on search button");
		
		if(driver.getPageSource().contains("iphone")) {
			logger.info("search product found");
			Assert.assertTrue(true);
		}else {
			logger.info("search product not found");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(priority=5)
	public void searchProductWithInvalidName() {
		
		productSearchPage ps = new productSearchPage(driver);
		
		ps.enterProduct("iphoneee");
		logger.info("enter product name");
		
		ps.clickOnSearchButton();
		logger.info("click on search button");
		
		if(driver.getPageSource().contains("There is no product that matches the search criteria.")) {
			logger.info("no product listed");
			Assert.assertTrue(true);
		}else {
		
			Assert.assertTrue(false);
		}
	}
	
}
