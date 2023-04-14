package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageDeliveryBoyPage 
{
	WebDriver driver;
	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//p[text()='Manage Delivery Boy']")
	WebElement ManageDeliveryBoy;
	
	@FindBy(xpath="//h1[text()='List Delivery Boy']")
	WebElement TitleFieldOfManageDeliveryBoyPage;
	
	public void clickManageDeliveryBoy()
	{
		PageUtility.clickOnElement(ManageDeliveryBoy);
	}
	
	public String titleofDeliveryBoyPage()
	{
		return PageUtility.getElementText(TitleFieldOfManageDeliveryBoyPage);
	}
	
	

}
