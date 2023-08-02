package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

import jdk.internal.net.http.common.Log;

public class TC_LoginTest_001 extends BaseClass{
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		
		 //driver.get(baseURL);
		 logger.info("URL is opened");
		 
		 LoginPage lp = new LoginPage(driver);
		 
		 driver.manage().window().maximize();
		 
		 Thread.sleep(3000);
		 lp.setUserName(username);
		 logger.info("Entered username");
		 
		 lp.setPassword(password);
		 logger.info("Entered password");
		 
		 lp.clickSubmit();
		 logger.info("Clicked Login button");
		 		 
		 if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			 
			 System.out.println("The actual title name is: " + driver.getTitle());
			 
			 Assert.assertTrue(true);
			 logger.info("Login page is tested successfully");
		 }
		 else {
			 
			 captureScreen(driver,"loginTest");
			 Assert.assertTrue(false);
			 logger.info("Login page is failed");
		 }
	
			
	}
	
	
}
