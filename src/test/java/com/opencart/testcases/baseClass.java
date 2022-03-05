package com.opencart.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.opencart.utilities.helper;
import com.opencart.utilities.readConfig;

public class baseClass {
	
	public static WebDriver driver;
	
	readConfig rc = new readConfig();
	
	String baseUrl=rc.getUrl();
	String email = rc.getEmail();
	String pass = rc.getPassword();
	
	
	@SuppressWarnings("deprecation")
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br) {
		
		if(br.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", rc.getChrome());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", rc.getFirefox());
			driver = new FirefoxDriver();
		}else if(br.equals("ie")) {
			
			System.setProperty("webdriver.ie.driver", rc.getIe());
			driver = new InternetExplorerDriver();	
			
		}
	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
