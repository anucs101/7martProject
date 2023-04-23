package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageSliderPage 
{
	WebDriver driver;
	public ManageSliderPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//a[contains(@class,'primary btncss')]")
	WebElement editButtoninList;
	
	@FindBy(xpath ="//a[contains(@class,'danger btncss')]")
	WebElement DeleteButtoninList;
	
	public int xAxisLocationofEditButton()
	{
		return PageUtility.location(editButtoninList).getX();
	}
	
	public int xAxisLocationOfDeleteButton()
	{
		return PageUtility.location(DeleteButtoninList).getX();
	}

}
