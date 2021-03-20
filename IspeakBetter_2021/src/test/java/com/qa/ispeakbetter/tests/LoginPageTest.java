package com.qa.ispeakbetter.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.LoginPage;
import com.qa.ispeakbetter.util.Constants;
import com.qa.ispeakbetter.util.Credentials;

public class LoginPageTest extends BasePage {

	// Fields
	WebDriver driver;
	Properties properties;
	Credentials credentials1, credentials2, credentials3, credentials4;
	BasePage basePage;
	LoginPage loginPage;
	
	@BeforeMethod(alwaysRun=true)
	public void setUp(){
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(properties);
		loginPage = new LoginPage(driver);
		credentials1 = new Credentials(properties.getProperty("username"),
				properties.getProperty("password"));
		credentials2 = new Credentials(properties.getProperty("incorrectuser"),
				properties.getProperty("password"));
		credentials3 = new Credentials(properties.getProperty("username"),
				properties.getProperty("incorrectpass"));
		credentials4 = new Credentials(properties.getProperty("incorrectuser"),
				properties.getProperty("incorrectpass"));
	}
	
	@Test(priority = 1, groups = {"smoke", "regression"}, description = "Login Page Title Test")
	public void verifyLoginPageTitle() {
		String title = loginPage.getPageTitle();
		System.out.println("Login page title : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "Page title is in-correct");
	}
	
	@Test(priority = 2, groups = {"smoke", "regression"}, description = "Login Page URL Test")
	public void verifyLoginPageURL() {
		String urlLogin = loginPage.getPageURL();
		System.out.println("Login page url : " + urlLogin);
		Assert.assertEquals(urlLogin, properties.getProperty("url"));
	}
	
	@Test(priority = 3, groups = {"smoke", "regression"}, description = "Click Test for Logo Image")
	public void clickTestForLogo() {
		loginPage.clickOnLogoImage();
	}
	
	@Test(priority = 4, groups = {"smoke", "regression"}, description = "Display Test for See Our Courses Button")
	public void isDisplayedTestForSeeCourses() {
		boolean displayed = loginPage.isDisplayedSeeOurCourses();
		Assert.assertTrue(displayed);
	}
	
	@Test(priority = 5, groups = {"smoke", "regression"}, description = "Enable Test for Language Down Row")
	public void isEnabledTestForDownRow() {
		boolean enabled = loginPage.isEnabledDownRow();
		Assert.assertTrue(enabled);
	}

	@Test(priority = 6, groups = {"sanity", "regression"}, description = "Selected Test for Duration")
	public void isSelectedTestForDuration() {
		boolean selected = loginPage.isSelectedDuration();
		Assert.assertFalse(selected);
	}
	
	@Test(priority = 7, groups = {"sanity", "regression"}, description = "Login Test 1 : correct username and correct password.")
	public void loginTest1() {
		loginPage.doLogin(credentials1.getUsername(), credentials1.getPassword());
	}
	
	@Test(priority = 8, groups = {"sanity", "regression"}, description = "Login Test 2 : in-correct username and correct password.")
	public void loginTest2() {
		loginPage.doLogin(credentials2.getUsername(), credentials2.getPassword());
	}
	
	@Test(priority = 9, groups = {"sanity", "regression"}, description = "Login Test 3 : correct username and in-correct password.")
	public void loginTest3() {
		loginPage.doLogin(credentials3.getUsername(), credentials3.getPassword());
	}
	
	@Test(priority = 10, groups = {"sanity", "regression"}, description = "Login Test 4 : in-correct username and in-correct password.")
	public void loginTest4() {
		loginPage.doLogin(credentials4.getUsername(), credentials4.getPassword());
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		basePage.quitBrowser();
	}
	
}





















