package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User is provided");
		
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("Providing customer details.....");
		
		addcust.custName("");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(3000);
		addcust.custaddress("USA");
		addcust.custcity("Sewickley");
		addcust.custstate("PA");
		addcust.custpinno("15143");
		addcust.custtelephoneno("4127369222");
		String email=randomstring()+"gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation is started .....");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("addcustomer testcase is passed");
		}
		else {
			logger.info("addcustomer testcase is failed");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			
		}
		
	}
	
	public String randomstring() {
		
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		
		return generatedstring;
	}

}
