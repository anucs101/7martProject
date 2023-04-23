package com.obsqura.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManagePages 
{
	
	WebDriver driver;
	public ManagePages(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//a[@onclick='click_button(1)']")
	WebElement newButton;
	
	@FindBy(xpath ="//a[@onclick='click_button(2)']")
	WebElement searchButton;
	
	@FindBy(xpath ="//input[@type='text']")
	WebElement titleFieldforSearch;
	
	@FindBy(xpath ="//button[@name='Search']")
	WebElement searchButtoninSearchListPages;
	
	@FindBy(xpath ="//table[contains(@class,'table')]//tr//td")
	List<WebElement> listtableElements;
	
	@FindBy(xpath ="//table[contains(@class,'table')]//tr//td")
	List<WebElement> listAfterSearch;
	
	
	
	public String backgroundColorOfNewButton()
	{
		WaitUtility.waitForElementIsPresent(driver, newButton);
		return PageUtility.getCssValueofElement(newButton, "background-color");
	}
	
	public void clickSearchButton()
	{
		searchButton.click();
	}
	
	public void enterTextinTitleFieldForSearch() throws IOException
	{
		PageUtility.enterText(titleFieldforSearch, ExcelUtility.getString(4, 1,System.getProperty("user.dir")+constants.Constants.EXCELFILE,"ManagePage"));
	}
	
	public void clickSearchButtoninSearchListPages()
	{
		searchButtoninSearchListPages.click();
	}
	
	public List<String> listOfValuesinTable()
	{
		List<String> listTableValues = new ArrayList<String>();
		for(WebElement value:listtableElements)
		{
			listTableValues.add(value.getText());
		}
		return listTableValues;
	}
	
	public List<String> listOfValuesinTableAfterSearch()
	{
		List<String> listTableValuesAfterSerach = new ArrayList<String>();
		for(WebElement value:listAfterSearch)
		{
			listTableValuesAfterSerach.add(value.getText());
		}
		return listTableValuesAfterSerach;
	}
	
	
	

}
