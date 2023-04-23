package com.obsqura.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void clickHomeLinkElement()
	{
		HomeLinkElement.click();
	}
	
	public boolean expectedElementIsPresent()
	{
		return PageUtility.isElementDisplayed(ExpectedElementInDashboardPage);
	}
	
	public void clickNewButton()
	{
		newButton.click();
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
	
	public void clickDeleteButton()
	{
		deleteButton.click();
	}
	
	public void clickOktoPopupWindow()
	{
		driver.switchTo().alert().accept();
	}
	
	public String alertElementText()
	{
		return PageUtility.getElementText(alertElement);
	}
}
