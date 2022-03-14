package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.utilities.helper;

public class productDescriptionPage {
	
	WebDriver ldriver;
	
	
	public productDescriptionPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement quantity;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;
	
	public void enterQuantity(int qt) {
		quantity.clear();
		quantity.sendKeys(String.valueOf(qt));;
	}
	
	public void clickAddToCartButton() {
		addButton.click();
	}
	
	public WebElement successElement() {
		return successAlert;
	}
	
	public void clickOnProduct(String pname) throws InterruptedException {
		
		WebElement product = helper.productXpathBuilder(ldriver,pname);
		product.click();
		Thread.sleep(5000);
		
		
	}
}
