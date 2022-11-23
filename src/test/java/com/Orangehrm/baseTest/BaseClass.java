package com.Orangehrm.baseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.externalconfig.model.Config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Properties prop; // prop is created to use entities from config.properties file.
	public Logger logger = LogManager.getLogger(this.getClass()); // get value for Logger from org.apache.logging.log4j

	
	@BeforeMethod
	@Parameters("edge")
	public void setup(@Optional("edge")String br) throws IOException {

		// Code for properties file
		// Create reference of Properties class
		// add fileinput stream and as argument pass
		// location(.\\resourses\\config.properties) of config.properties file
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\resourses\\config.properties");
		prop.load(fis);

		// Below code can be run only from Testng.xml file cause browser details are
		// mentioned in tesng.xml
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome browser is launched"); // this is replacement of printline and it gives logs in log file
			// System.out.println("Chrome browser is launched");
		} else if (br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge browser is launched");

		} else if (br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Edge browser is launched");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url")); // here we are getting application url from config.properties file
		logger.info("Application is launched.");
		// System.out.println("Application is launched.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
		logger.info("Application  Closed successfully");
		// System.out.println("Closed Application successfully");

	}

}
