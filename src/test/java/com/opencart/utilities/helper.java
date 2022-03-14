package com.opencart.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencart.testcases.baseClass;

public class helper {
	
	public static String captureScreenshot(WebDriver driver,String tname) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String dest = System.getProperty("user.dir")+"\\screenshots\\"+tname+""+timeStamp+".png";
		
		File file = new File (dest);
		
		FileUtils.copyFile(src, file);
				
		System.out.println("screenshot captured...!");
	
		return dest;
	}
	
	
	public static String randomStringUtils() {
		
		String radomString = RandomStringUtils.randomAlphabetic(12).toLowerCase();
		return radomString;
	}
	
	public static WebElement productXpathBuilder(WebDriver driver, String pname) {
		
	
		WebElement product = driver.findElement(By.xpath("//img[@title='"+pname+"']"));
		
		return product;
	}
}



