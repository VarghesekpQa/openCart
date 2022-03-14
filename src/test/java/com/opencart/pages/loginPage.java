package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class loginPage {
	
	WebDriver ldriver;
	
	public loginPage(WebDriver driver) {
		
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-user']")
	WebElement myAccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement login;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement logoutButton;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement logoutContinueButton;

	public void clickMyaccount() {
		myAccount.click();
	}
	
	public void clickLogin() {	
		myAccount.click();
		login.click();
	}
	
	public void setEmail(String em) {
		email.sendKeys(em);
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickLogoutButton() {
		logoutButton.click();
	}	

	public void clickLogoutContinueButton() {
		logoutContinueButton.click();
	}	
	
	public void clickOnMyAccount() {
		myAccount.click();
	}	
	
}
