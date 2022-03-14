package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerPage {

	WebDriver ldriver;
	
	public registerPage(WebDriver driver) {
		
		ldriver = driver ;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement registerLink;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lname;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	

	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
	WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;
	
	
	
	public void clickOnRegisterLink() {
		myAccount.click();
		registerLink.click();
	}
	
	public void setFirstname(String firstname) {
		fname.sendKeys(firstname);
	}
	
	public void setLastname(String lastname) {
		lname.sendKeys(lastname);
	}
	
	public void setEmail(String em) {
		email.sendKeys(em);
	}
	
	public void setTelephone(int phone) {
		telephone.sendKeys(String.valueOf(phone));
	}
	
	public void setPassword(String pw) {
		password.sendKeys(pw);
	}
	
	public void setConfirmPassword(String cpw) {
		confirmPassword.sendKeys(cpw);
	}
	
	public void clickPrivacyPolicy() {
		privacyPolicy.click();
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
	
}
