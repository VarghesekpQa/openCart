package com.opencart.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pages.productSearchPage;
import com.opencart.utilities.helper;

public class tc_006_productDescription extends baseClass {

	@Test(priority=6)
	public void productDecription() {
		
		productSearchPage ps = new productSearchPage(driver);
		
		String pname = "Apple Cinema 30\"";
		
		ps.enterProduct(pname);
		logger.info("enter product name");
		
		ps.clickOnSearchButton();
		logger.info("click on search button");
		
		ps.clickOnProduct(pname);
		logger.info("click on search product");
		
		if(driver.getTitle().equals("Apple Cinema 30")) {
			logger.info("product description found");
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}	
	}	
}
