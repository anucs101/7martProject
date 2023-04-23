package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class DashboardPageSelector 
{
	WebDriver driver;
	public DashboardPageSelector(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='More info ']")
	List<WebElement> pages;
	
	public void navigateToPageFromDashboard(String pageLink)
	{
	for(WebElement page : pages)
	{
		if(PageUtility.getAttributeOfhref(page).equals(pageLink))
		{
		PageUtility.clickOnElement(page);
		break;
		}
	}
	}
}
