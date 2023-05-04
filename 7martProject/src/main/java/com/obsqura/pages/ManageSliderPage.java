package com.obsqura.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.UtilityFile;
import utilities.WaitUtility;

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
	
	@FindBy(xpath ="//input[@name='main_img']")
	WebElement chooseFile;
	
	@FindBy(xpath ="//a[@onclick='click_button(1)']")
	WebElement newButton;
	
	@FindBy(xpath ="//input[@id='link']")
	WebElement linkTextField;
	
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	
	@FindBy(xpath="//div[contains(@class,'alert')]")
	WebElement alertElement;
	
	public int xAxisLocationofEditButton()
	{
		return PageUtility.location(editButtoninList).getX();
	}
	
	public int xAxisLocationOfDeleteButton()
	{
		return PageUtility.location(DeleteButtoninList).getX();
	}
	
	public ManageSliderPage clicknewButton()
	{
		WaitUtility.waitForElement(driver, newButton);
		newButton.click();
		return this;
	}
	
	public ManageSliderPage uploadImage() 
	{
		chooseFile.sendKeys(ExcelUtility.getString(6, 1,UtilityFile.excelPath,"ManageSlider"));
		return this;
	}
	
	public ManageSliderPage enterLink() 
	{
		linkTextField.sendKeys(ExcelUtility.getString(1, 1,UtilityFile.excelPath,"ManageSlider"));
		return this;
	}
	
	public ManageSliderPage clickSaveButton()
	{
	
		//WaitUtility.waitForElementClickable(driver, saveButton);
		saveButton.submit();
		return this;
	}
	
	public String AlertText()
	{
		return PageUtility.getElementText(alertElement);
	}

}
