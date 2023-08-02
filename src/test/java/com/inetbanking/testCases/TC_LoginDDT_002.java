package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	 @Test(dataProvider="LoginData")
	 public void loginDDT(String user, String pwd) throws InterruptedException {
		 
		 LoginPage lp = new LoginPage(driver);
		 lp.setUserName(user);
		 logger.info("user name provided");
		 
		 lp.setPassword(pwd);
		 logger.info("password provided");
		 
		 lp.clickSubmit();
		 logger.info("clicked on Login button");
		 
		 Thread.sleep(3000);
		 
		 if(isAlertPresent()==true) 
		 {
			 driver.switchTo().alert().accept();//close alert window
			 driver.switchTo().defaultContent();
			 Assert.assertTrue(false);
			 logger.warn("Login Failed");
		 }
		 else 
		 {
		 	 Assert.assertTrue(true);
			 logger.info("Login Passed");
		 	 lp.clickLogout();
		 	 driver.switchTo().alert().accept(); //close logout alert
		 	 driver.switchTo().defaultContent();
		 }
	 }
	 
	 
	 public boolean isAlertPresent() // user defined method created to check whether alert is present or not 
	 {
		 try 
		 {
			 driver.switchTo().alert();
			 return true;
		 }
		 catch(Exception e) {
			 return false;
		 }
		 
	 }
	 
	 @DataProvider(name="LoginData")
	 String [][] getData() throws IOException
	 {
		 
		 String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		 int rownum  = XLUtils.getRowCount(path, "Sheet1");
		 int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		 String logindata[][] = new String [rownum][colcount];
		 
		 for(int i=1;i<rownum;i++) {
			 
			 
			 for(int j=0;j<colcount;j++) 
			 {
				 logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
				 
			 }
			  
		 }
		 return logindata; 
		 	 
	 }
	 
	
}
