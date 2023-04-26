package com.obsqura.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.PageUtility;

public class AdminUsersPage
{
	WebDriver driver;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement HomeLinkElement;
	
	@FindBy(xpath="//li[text()='Dashboard']")
	WebElement ExpectedElementInDashboardPage;
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")
	WebElement newButton;
	
	@FindBy(xpath="//select[@id='user_type']")
	WebElement userTypeMenu;
	
	@FindBy(xpath="//a[contains(@class,'danger btncss')]")
	WebElement deleteButton;
	
	@FindBy(xpath="//div[contains(@class,'alert')]")
	WebElement alertElement;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement usernameField;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordField;
	
	
	@FindBy(xpath="//button[@name='Create']")
	WebElement SaveButton;
	
	
	
	
	public void clickHomeLinkElement()
	{
		HomeLinkElement.click();
	}
	
	public boolean expectedElementIsPresent()
	{
		return PageUtility.isElementDisplayed(ExpectedElementInDashboardPage);
	}
	
	public AdminUsersPage clickNewButton()
	{
		newButton.click();
		return this;
	}
	
	public List<String> dropdownMenuOptionsList()
	{
		List<String> dropdownMenuOptions = new ArrayList<String>();
		for(WebElement option:PageUtility.selectOptionsList(userTypeMenu))
		{
			dropdownMenuOptions.add(option.getText());
		}
		return dropdownMenuOptions;
	}
	
	public AdminUsersPage clickDeleteButton()
	{
		deleteButton.click();
		return this;
	}
	
	public AdminUsersPage clickOktoPopupWindow()
	{
		driver.switchTo().alert().accept();
		return this;
	}
	
	public String alertElementText()
	{
		return PageUtility.getElementText(alertElement);
	}
	
	public AdminUsersPage enterUserName()
	{
		PageUtility.enterText(usernameField, FakerUtility.firstName());
		return this;
	}
	
	public AdminUsersPage enterPassword()
	{
		PageUtility.enterText(passwordField, FakerUtility.firstName());
		return this;
	}
	public AdminUsersPage selectAdmin()
	{
		PageUtility.selectDropdownbyIndex(userTypeMenu, 2);
		return this;
	}
	
	public AdminUsersPage clickSaveButton()
	{
		SaveButton.click();
		return this;
	}
}
