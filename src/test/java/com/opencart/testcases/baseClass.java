package com.opencart.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.opencart.utilities.readConfig;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class baseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	
	readConfig rc = new readConfig();
	String baseUrl=rc.getUrl();
	String email = rc.getEmail();
	String pass = rc.getPassword();
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br) throws IOException {
		
		logger = Logger.getLogger("openCart");
		
		PropertyConfigurator.configure("./log4j.properties");
		
		if(br.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", rc.getChrome());
			driver = new ChromeDriver();
			logger.info("chrome browser is starting...");
			
		}
		else if(br.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", rc.getFirefox());
			driver = new FirefoxDriver();
			logger.info("firefox browser is starting...");
			
		}else if(br.equals("ie")) {
			
			System.setProperty("webdriver.ie.driver", rc.getIe());
			driver = new InternetExplorerDriver();	
			logger.info("ie browser is starting...");
			
		}
	
		driver.manage().window().maximize();
		driver.get(baseUrl);
		logger.info("url opened...");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.info("clossing the browser...");
	}
	
}
