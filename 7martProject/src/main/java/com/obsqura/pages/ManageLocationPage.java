package com.obsqura.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.UtilityFile;
import utilities.WaitUtility;

public class ManageLocationPage 
{
	WebDriver driver;
	public ManageLocationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")
	WebElement newButton;
	
	
	@FindBy(xpath="//select[@name='country_id']")
	WebElement selectCountryField;
	
	@FindBy(xpath="//select[@name='state_id']")
	WebElement selectStateField;
	
	@FindBy(xpath="//input[@id='location']")
	WebElement locationField;
	
	@FindBy(xpath="//input[@name='delivery']")
	WebElement deliveryChargeField;
	
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	
	@FindBy(xpath="//a[contains(@class,'primary btncss')]")
	WebElement editButton;
	
	@FindBy(xpath="//button[@name='update']")
	WebElement updateButton;
	
	@FindBy(xpath ="//div[contains(@class,'alert')]")
	WebElement alertElement;
	
	@FindBy(xpath ="//a[@onclick='click_button(2)']")
	WebElement searchButton;
	
	@FindBy(xpath ="//button[@name='Search']")
	WebElement searchButtoninSearchList;
	
	@FindBy(xpath="//table[contains(@class,'table')]//tbody//tr//td")
	List<WebElement> listAfterSearch;
	
	public ManageLocationPage  clickNewButton()
	{
		newButton.click();
		return this;
	}
	
	public ManageLocationPage selectCountry() 
	{
		String selectbytext = ExcelUtility.getString(1, 0, UtilityFile.excelPath, "ManageLocation");
		 PageUtility.selectDropdownbyText(selectCountryField, selectbytext);
		 return this;
	}
	
	public ManageLocationPage selectState() 
	{
		String selectbytext = ExcelUtility.getString(1, 1, UtilityFile.excelPath, "ManageLocation");
		 PageUtility.selectDropdownbyText(selectStateField, selectbytext);
		 return this;
	}
	
	public ManageLocationPage enterLocation() 
	{
		String location =  ExcelUtility.getString(1, 2, UtilityFile.excelPath, "ManageLocation");
		locationField.sendKeys(location);
		 return this;
	}
	
	public ManageLocationPage enterDeliveryCharge() 
	{
		int charge =  ExcelUtility.getNumericValue(1, 3, UtilityFile.excelPath, "ManageLocation");
		deliveryChargeField.sendKeys(String.valueOf(charge));
		 return this;
	}
	
	public ManageLocationPage clickSaveButton()
	{
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementClickable(driver, saveButton);
		saveButton.submit();
		return this;
	}
	
	public ManageLocationPage  clickEditButton()
	{
		editButton.click();
		return this;
	}
	
	public ManageLocationPage editSelectState() 
	{
		String selectbytext = ExcelUtility.getString(4, 1, UtilityFile.excelPath, "ManageLocation");
		 PageUtility.selectDropdownbyText(selectStateField, selectbytext);
		 return this;
	}
	
	public ManageLocationPage clickUpdateButton()
	{
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementClickable(driver, updateButton);
		updateButton.submit();
		return this;
	}
	
	public String alertElementText()
	{
		return alertElement.getText();
	}
	
	public ManageLocationPage editSelectCountry() 
	{
		String selectbytext = ExcelUtility.getString(1, 0, UtilityFile.excelPath, "ManageLocation");
		 PageUtility.selectDropdownbyText(selectCountryField, selectbytext);
		 return this;
	}
	
	public ManageLocationPage editLocation() 
	{
		String location =  ExcelUtility.getString(4, 2, UtilityFile.excelPath, "ManageLocation");
		locationField.clear();
		locationField.sendKeys(location);
		 return this;
	}
	
	public ManageLocationPage editDeliveryCharge() 
	{
		int charge =  ExcelUtility.getNumericValue(4, 3, UtilityFile.excelPath, "ManageLocation");
		deliveryChargeField.clear();
		deliveryChargeField.sendKeys(String.valueOf(charge));
		 return this;
	}
	
	public ManageLocationPage clickSearchButton()
	{
		searchButton.click();
		return this;
	}
	
	public ManageLocationPage clickSearchButtonInSearchList()
	{
		searchButtoninSearchList.click();
		return this;
	}
	
	public List<String> SearchResults()
	{
		List<String> listofValuesAfterSearch = new ArrayList<String>();
		for(WebElement value : listAfterSearch)
		{
			listofValuesAfterSearch.add(PageUtility.getElementText(value));
		}
		return listofValuesAfterSearch;
	}
	
	

}
