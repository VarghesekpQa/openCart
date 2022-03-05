package com.opencart.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pages.loginPage;
import com.opencart.utilities.xlUtils;

public class tc_002_login_dtd extends baseClass {
	
	
	@Test(dataProvider="loginData")
	public void loginDtd(String em,String ps,String exp) throws InterruptedException {
		
		driver.get(baseUrl);
		
		loginPage lp = new loginPage(driver);
		
		lp.clickLogin();
		
		lp.setEmail(em);
		lp.setPassword(ps);
		Thread.sleep(3000);
		
		lp.clickLoginButton();
		
		if(exp.equals("valid")) {
			
			if(driver.getTitle().equals("My Account")) {
		
				Assert.assertTrue(true);
				Thread.sleep(3000);
				
				lp.clickOnMyAccount();
				lp.clickLogoutButton();
				lp.clickLogoutContinueButton();
				
			}else {
				//captureScreenshot("login");
				Assert.assertTrue(false);
			}	
		} else if(exp.equals("invalid")) {
			if(driver.getPageSource().contains("Warning: No match for E-Mail Address and/or Password.")) {
				
				Assert.assertTrue(true);
		
			}else {
				//captureScreenshot("login");
				Assert.assertTrue(false);
				lp.clickLogoutButton();
				lp.clickLogoutContinueButton();
			}
		}	
	}
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException {
	
		/*
		String loginData[][] = {
				{"zxccxz@gmail.com","1234567890","valid"},
				{"jsgdjhsz@gmail.com","12345js67890","invalid"},
				{"jhsdhjsccxz@gmail.com","1234567jhcjhs890","invalid"},
				};
		
		*/
		String path = System.getProperty("user.dir")+"/testData/loginDatas.xlsx";
		
		int row = xlUtils.getRowNum(path, "Sheet1");
		int cell = xlUtils.getCellNum(path, "Sheet1", 1);
		
		String loginData[][] = new String [row][cell];
		
		for(int r=1;r<=row;r++) {
			
			for(int c=0;c<cell;c++) {
				
				loginData[r-1][c] = xlUtils.getCellData(path, "Sheet1", r, c);
			}
			
		}
		
		return loginData;
	}
}
