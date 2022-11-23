package com.Orangehrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Orangehrm.baseTest.BaseClass;

public class LoginPage extends BaseClass {
	public WebDriver driver;

	/*
	 * we are using this keyword to incorporate the globle variable (driver) to
	 * local veriable (driver)
	 */

	// Creating constructor for login page
	public LoginPage(WebDriver driver) {

		this.driver = driver; // assigning the driver passed from test case to local Webdriver driver defined
								// in this class

		// PageFactory.initElements(factory, page);
		PageFactory.initElements(driver, this); // We are using PageFactory Concepts where we are initializing for
												// driver and this page

	

	}
	// Locators
	//Locator for username field
	@FindBy(name = "username") // driver.findElement(By.name("username"))
	WebElement txtUname;

	//Locator for password field
	@FindBy(name = "password")
	WebElement txtPwd;

	//Locator for login button 
	@FindBy(tagName = "button")
	WebElement lgnBtn;
	
	//Locator for forgot your password? link
	@FindBy(xpath=".//p[text() = 'Forgot your password? ']")
	WebElement forgotyourPwdLnk;
	
	// Methods for username,password and loginbutton
	public void setUsername(String uname) {
		txtUname.clear();
		// txtUname.sendKeys("admin"); value passed in send key can be entered from
		// Testcases
		txtUname.sendKeys(uname);
		String val = txtUname.getAttribute("value"); // getting value which is entered by user for uname and storing
														// into string
		logger.info("UserName - " + val + " is Entered.");
		//System.out.println("UserName - " + val + " is Entered.");

	}

	public void setPassword(String pwd) {
		txtPwd.clear();
		txtPwd.sendKeys(pwd);
		String val = txtPwd.getAttribute("value");
		logger.info("Password - " + val + " is Entered.");
		//System.out.println("Password - " + val + " is Entered.");

	}
	public void clicklgnButton() {
		lgnBtn.click();
		logger.info("Clicked on Login button.");
		//System.out.println("Clicked on Login button.");
	}
	
	public boolean forgotYourPasswordLinkStatus() {
		boolean status = forgotyourPwdLnk.isDisplayed();
		return status;
	}

}
