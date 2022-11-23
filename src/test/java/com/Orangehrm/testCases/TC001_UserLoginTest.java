package com.Orangehrm.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Orangehrm.baseTest.BaseClass;
import com.Orangehrm.pageObjects.DashboardPage;
import com.Orangehrm.pageObjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_UserLoginTest extends BaseClass {

	@Test
	public void LoginTest() {
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = new DashboardPage(driver);
		lp.setUsername(prop.getProperty("appusername"));
		lp.setPassword(prop.getProperty("apppassword"));
		lp.clicklgnButton();
		
		boolean status = dp.linkDashboardDisplayedStatus();
		Assert.assertEquals(status, true,"user did not logged in successfully");
		logger.info("User logged into application successfully");
		//System.out.println("User logged into application successfully");
		
		
	}

}
