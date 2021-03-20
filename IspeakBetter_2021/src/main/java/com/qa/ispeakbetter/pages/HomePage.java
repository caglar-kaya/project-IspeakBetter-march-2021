package com.qa.ispeakbetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.util.ElementUtil;


public class HomePage extends BasePage {

	// Fields
	WebDriver driver;
	ElementUtil elementUtil;
	
	// Locators
	By launchPad = By.xpath("//a[normalize-space()='Launch Pad']");
	By dictionary = By.xpath("//a[normalize-space()='Dictionary']");
	By purchaseBtn = By.xpath("//a[contains(@onclick, 'show_renew')]");
	By showBasket = By.xpath("//center//a[@class='btn btn2 small turkuaz']");
	By chatText = By.id("titlediv");
	
	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// Action 1 :
	public void clickOnLaunchPad() {
		elementUtil.doClick(launchPad);
	}
	
	// Action 2 :
	public void clickOnDictionary() {
		elementUtil.doClick(dictionary);
	}
	
	// Action 3 :
	public String getTextPurchaseBtn() {
		return elementUtil.doGetText(purchaseBtn).trim();
	}
	
	// Action 4 :
	public VocabularyBasketPage clickOnShowBasket() {
		elementUtil.doClick(showBasket);
		return new VocabularyBasketPage(driver);
	}
	
	// Action 5 :
	public boolean isDisplayedChatText() {
		return elementUtil.doIsDisplayed(chatText);
	}
	
}
