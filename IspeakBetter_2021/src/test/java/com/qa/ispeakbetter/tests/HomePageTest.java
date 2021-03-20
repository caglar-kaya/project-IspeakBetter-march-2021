package com.qa.ispeakbetter.tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.HomePage;
import com.qa.ispeakbetter.pages.LoginPage;
import com.qa.ispeakbetter.util.ElementUtil;

public class HomePageTest {

	WebDriver driver;
	Properties properties;
	ElementUtil elementUtil;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	
	By curriculumLink = By.cssSelector("a[href='onlinestudent.php?job=content']");
	By searchBtn = By.id("dialogbox-btn-0");
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(properties);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		elementUtil = new ElementUtil(driver);
	}
	
	@Test(priority = 1, description = "Launch Pad Click Test")
	public void clickOnLaunchPadTest() {
		homePage.clickOnLaunchPad();
		boolean curriculum = elementUtil.doIsDisplayed(curriculumLink);
		Assert.assertTrue(curriculum);
	}

	@Test(priority = 2, description = "Dictionary Link Click Test")
	public void clickOnDictionaryTest() {
		homePage.clickOnDictionary();
		boolean search = elementUtil.doIsEnabled(searchBtn);
		Assert.assertTrue(search);
	}
	
	@Test(priority = 3, description = "Purchase Button Text Test")
	public void getTextPurchaseBtnTest() {
		String actualText = homePage.getTextPurchaseBtn();
		String expectedText = "Purchase Package";
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test(priority = 4, description = "Show Vocabulary Basket Button Click Test")
	public void clickOnShowBasketTest() {
		homePage.clickOnShowBasket();
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://onlinestudent.ispeakbetter.com/onlinestudent.php?job=vocabulary";
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(priority = 5, description = "Chat Text Displayed Test")
	public void isDisplayedChatTextTest() {
		boolean chatText = homePage.isDisplayedChatText();
		Assert.assertTrue(chatText);
	}
	
	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		basePage.quitBrowser();
	}
}
