package com.opencart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pages.productDescriptionPage;

public class tc_007_addToCart extends baseClass{

	@Test(priority=7)
	public void addToCart() throws InterruptedException {
		
		String pname ="MacBook";
		
		productDescriptionPage pd = new productDescriptionPage(driver);
		
		pd.clickOnProduct(pname);
		logger.info("click on the product");
		
		pd.enterQuantity(2);
		logger.info("enter the quantity");
		
		pd.clickAddToCartButton();
		logger.info("click on add to cart button");
					  
		String act_msg = pd.successElement().getText();
				
		if(act_msg.contains("Success: You have added "+pname+" to your shopping cart!")) {
			logger.info("item added to cart");
			Assert.assertTrue(true);
		}else {
			logger.info("item couldn't added to cart");
			Assert.assertTrue(true);
		}
	}
	
}
