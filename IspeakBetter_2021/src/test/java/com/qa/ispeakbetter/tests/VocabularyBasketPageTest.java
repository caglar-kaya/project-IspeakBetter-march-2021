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
import com.qa.ispeakbetter.pages.VocabularyBasketPage;
import com.qa.ispeakbetter.util.ElementUtil;

public class VocabularyBasketPageTest {

	WebDriver driver;
	Properties properties;
	ElementUtil elementUtil;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	VocabularyBasketPage vocabularyBasketPage;
	
	By composeBtn = By.xpath("//a[@class='btn btn-primary btn-sm']");
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(properties);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		vocabularyBasketPage = homePage.clickOnShowBasket();
		elementUtil = new ElementUtil(driver);
	}
	
	@Test(priority = 1, description = "Messages Link Click Test")
	public void clickOnMessagesLinkTest() {
		vocabularyBasketPage.clickOnMessagesLink();
		boolean compose = elementUtil.doIsDisplayed(composeBtn);
		Assert.assertTrue(compose);
	}
	
	@Test(priority = 2, description = "Search Button Click Test")
	public void clickOnSearchButtonTest() {
		vocabularyBasketPage.clickOnSearchButton();
		String actualURL = "https://onlinestudent.ispeakbetter.com/onlinestudent.php?word=&job=vocabularysearch";
		String expectedURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(priority = 3, description = "Version Test")
	public void getTextVersionTest() {
		String actualText = vocabularyBasketPage.getTextVersion();
		String expectedText = "v7.0 BETA";
		Assert.assertEquals(actualText, expectedText);
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
