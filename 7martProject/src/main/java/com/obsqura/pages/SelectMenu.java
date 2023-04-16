package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class SelectMenu 

{
	WebDriver driver;
	public SelectMenu(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//li[contains(@class,'nav-item')]//p")
	List<WebElement> pages;
	
	public void navigateToPage(String pageText)
	{
	for(WebElement page : pages)
	{
		if(PageUtility.getElementText(page).equals(pageText))
				{
				PageUtility.clickOnElement(page);
				break;
				}
	}
	}

}
