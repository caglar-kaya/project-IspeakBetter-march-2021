package com.qa.ispeakbetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.util.ElementUtil;

public class VocabularyBasketPage extends BasePage {

	// Fields
	WebDriver driver;
	ElementUtil elementUtil;
	
	// Locators
	By messagesLink = By.xpath("//a[normalize-space()='Messages']");
	By searchBtn = By.xpath("//button[@name='job']");
	By version = By.xpath("//strong[normalize-space()='v7.0 BETA']");
	
	// Constructor
	public VocabularyBasketPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// Action 1 :
	public void clickOnMessagesLink() {
		elementUtil.doClick(messagesLink);
	}
	
	// Action 2 :
	public void clickOnSearchButton() {
		elementUtil.doClick(searchBtn);
	}
	
	// Action 3 :
	public String getTextVersion() {
		return elementUtil.doGetText(version).trim();
	}
	
}
