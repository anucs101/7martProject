package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement usernameField;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement signinButton;
	
	@FindBy(xpath="//div[contains(@class,'alert')]")
	WebElement alertmessageElement;
	
	public void enterTextinUsernameField(String username)
	{
		PageUtility.enterText(usernameField, username);
	}
	
	public void enterTextinpasswordField(String password)
	{
		PageUtility.enterText(passwordField, password);
	}
	
	public void clickSigninButton()
	{
		
		PageUtility.clickOnElement(signinButton);
	
	}
	
	public String getUrlOfDashboard()
	{
		return driver.getCurrentUrl();
	}
	
	public String textofAlertMessage()
	{
		return driver.switchTo().alert().getText();
	}
	
	public String getTitleOfDashBoard()
	{
		return driver.getTitle();
	}
	
	public boolean isUsernameFieldDisplayed()
	{
		return PageUtility.isElementDisplayed(usernameField);
	}
	
	public boolean isPasswordFieldDisplayed()
	{
		return PageUtility.isElementDisplayed(passwordField);
	}
	public boolean isSigninButtonEnabled()
	{
		return PageUtility.isElementDisplayed(passwordField);
	}
	
	public String alertMessage()
	{
		WaitUtility.waitForElement(driver, alertmessageElement);
		return PageUtility.getElementText(alertmessageElement);
	}
	
	
	

}
