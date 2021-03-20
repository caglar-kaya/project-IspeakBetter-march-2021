package com.qa.ispeakbetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.util.ElementUtil;

public class LoginPage extends BasePage {

	// Fields
	WebDriver driver;
	ElementUtil elementUtil;
	
	// Locators 
	By loginLink = By.id("cmdSiginLink");
	By email = By.id("_email");
	By password = By.id("_password");
	By loginBtn = By.id("cmdSignin");
	By logoImage = By.xpath("//img[@src='img/isb-logo-white.png']");
	By seeOurCourses = By.xpath("//a[@data-text='See our courses']");
	By languageDownRow = By.xpath("//i[@class='fa fa-caret-down']");
	By duration = By.id("select2-class_duration-container");
	
	// Constructors
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// Page Actions : 
	
	// 1. Action :
	public String getPageTitle() {
		return elementUtil.doGetPageTitle();
	}
	
	// 2. Action :
	public String getPageURL() {
		return elementUtil.doGetPageUrl();
	}
	
	// 3. Action : 
	public void clickOnLogoImage() {
		elementUtil.doClick(logoImage);
	}
	
	// 4. Action :
	public boolean isDisplayedSeeOurCourses() {
		return elementUtil.doIsDisplayed(seeOurCourses);
	}
	
	// 5. Action :
	public boolean isEnabledDownRow() {
		return elementUtil.doIsEnabled(languageDownRow);
	}
	
	// 6. Action :
	public boolean isSelectedDuration() {
		return elementUtil.doIsSelected(duration);
	}
	
	// 7. Action :	
	public HomePage doLogin(String username, String pwd) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtil.doClick(loginLink);
		elementUtil.doSendKeys(email, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new HomePage(driver);
	}
}
