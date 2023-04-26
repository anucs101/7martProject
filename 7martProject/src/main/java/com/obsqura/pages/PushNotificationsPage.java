package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.PageUtility;

public class PushNotificationsPage
{
	WebDriver driver;
	public PushNotificationsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@placeholder='Enter Title']")
	WebElement titleField;
	
	@FindBy(xpath="//input[@placeholder='Enter Description']")
	WebElement descriptionField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement sendButton;
	
	@FindBy(xpath="//div[contains(@class,'alert')]")
	WebElement alertMessageElement;
	
	public boolean istitleFieldDisplayed()
	{
		return PageUtility.isElementDisplayed(titleField);
	}
	
	public boolean isDescriptionFieldDisplayed()
	{
		return PageUtility.isElementDisplayed(descriptionField);
	}
	
	public PushNotificationsPage enterTextIntitleField()
	{
		PageUtility.enterText(titleField, FakerUtility.firstName());
		return this;
	}
	
	public PushNotificationsPage enterTextInDescriptionField()
	{
		PageUtility.enterText(descriptionField, FakerUtility.lastName());
		return this;
	}
	
	public boolean isSendButtonEnabled()
	{
		return PageUtility.isElementEnabled(sendButton);
	}
	
	public PushNotificationsPage clickSendButton()
	{
		PageUtility.clickOnElement(sendButton);
		return this;
	}
	
	public String alertMessage()
	{
		return PageUtility.getElementText(alertMessageElement);
	}
}
