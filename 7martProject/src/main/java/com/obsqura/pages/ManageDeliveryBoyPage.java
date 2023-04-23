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
	
	
	@FindBy(xpath="//h1[text()='List Delivery Boy']")
	WebElement TitleFieldOfManageDeliveryBoyPage;
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")
	WebElement newButton;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement nameFiled;
	
	public String titleofDeliveryBoyPage()
	{
		return PageUtility.getElementText(TitleFieldOfManageDeliveryBoyPage);
	}
	
	

}
