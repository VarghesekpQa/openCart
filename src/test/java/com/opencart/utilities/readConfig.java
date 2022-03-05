package com.opencart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readConfig {
	
	Properties pro;
	
	public readConfig(){
		
		try {
			
		File fs = new File("./configuration/config.properties");
		FileInputStream fi = new FileInputStream(fs);
		
		pro = new Properties();
		pro.load(fi);
		
		}catch (Exception e) {
			
			System.out.println(e.getMessage());	
		}	
	}
	
	public String getUrl() {
		String url = pro.getProperty("app_url");
		return url;	
	}
	
	public String getChrome() {
		String chrome = pro.getProperty("chrome_path");
		return chrome;
	}
	
	public String getFirefox() {
		String firefox = pro.getProperty("firefox_path");
		return firefox;
	}
	
	public String getIe() {
		String ie = pro.getProperty("ie_path");
		return ie;
	}
	
	public String getEmail() {
		String email = pro.getProperty("email");
		return email;
	}
	
	public String getPassword() {
		String pass = pro.getProperty("password");
		return pass;
	}
}
