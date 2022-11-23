package com.Orangehrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	public WebDriver driver;

	public DashboardPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Locators for Dashboard text
	@FindBy(xpath =".//span[text() = 'Dashboard']")
	WebElement lnkDashboard;
	
	//Method for Dashboard Link
	public boolean linkDashboardDisplayedStatus() {
		
	boolean lnkstatus= lnkDashboard.isDisplayed();
		return lnkstatus;
	}
}
