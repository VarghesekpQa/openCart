package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.helper;

public class productSearchPage {

	WebDriver ldriver;
	
	public productSearchPage(WebDriver driver){
		ldriver = driver;
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath="//input[@name=\"search\"]")
	WebElement search;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement searchButton;
	
	public void enterProduct(String pname) {
		search.clear();
		search.sendKeys(pname);
	}
	
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	public void clickOnProduct(String pname) {
		
		WebElement product = helper.productXpathBuilder(ldriver,pname);
		product.click();
	}
	
}
