
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

public class ManageUsersPage
{
	WebDriver driver;
	public ManageUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//a[@title='Show Details']")
	WebElement passwordButton;
	
	@FindBy(xpath ="//tr[@class='detail-row open']")
	WebElement passwordField;
	
	
	@FindBy(xpath ="//div[contains(@class,'alert')]")
	WebElement alertElement;
	
	@FindBy(xpath ="//span[text()='Active']")
	WebElement activeButton;
	
	@FindBy(xpath ="//a[@onclick='click_button(2)']")
	WebElement searchButton;
	
	@FindBy(xpath ="//input[@placeholder='Name']")
	WebElement NameField;
	
	@FindBy(xpath ="//button[@name='Search']")
	WebElement searchButtoninSearchList;
	
	@FindBy(xpath="//table[contains(@class,'table')]//tbody//tr//td")
	List<WebElement> listAfterSearch;
	
	
	public void clickPasswordButton()
	{
		passwordButton.click();
	}
	
	public boolean passwordFieldisPresent()
	{
		return PageUtility.isElementDisplayed(passwordField);
	}
	
	public String backgroundColorOfAlert() 
	{
		String propertyName = ExcelUtility.getString(0, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "Manageuser");
		return PageUtility.getCssValueofElement(alertElement,propertyName);
	}
	
	public void clickActiveButton()
	{
		activeButton.click();
	}
	
	public ManageUsersPage clickSearchButton()
	{
		searchButton.click();
		return this;
	}
	
	public void enterName(String element)
	{
		NameField.sendKeys(element);
	}
	
	public void clickSearchButtonInSearchList()
	{
		searchButtoninSearchList.click();
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
