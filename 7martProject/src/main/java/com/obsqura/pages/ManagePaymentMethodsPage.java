package com.obsqura.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManagePaymentMethodsPage 
{
	WebDriver driver;
	public ManagePaymentMethodsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='card ']//th")
	List<WebElement> tableHeaders;
	
	@FindBy(xpath="//a[contains(@class,'primary btncss')]")
	WebElement editButton;
	
	@FindBy(xpath="//input[@id='limit']")
	WebElement payLimitTextField;
	
	@FindBy(xpath="//button[@name='Update']")
	WebElement updateButton;
	
	@FindBy(xpath="//table[contains(@class,'table')]//td")
	List<WebElement> tableList;
	
	public List<String> tableHeadersList()
	{
		List<String> tableheaderList = new ArrayList<String>();
		for(WebElement tableHeader : tableHeaders)
		{
			tableheaderList.add(PageUtility.getElementText(tableHeader));
		}
		return tableheaderList;
	}
	
	public ManagePaymentMethodsPage  clickEditButton()
	{
		editButton.click();
		return this;
	}
	
	public ManagePaymentMethodsPage  enterValueinPayLimitTextField(String paylimitValue) throws IOException
	{
		payLimitTextField.sendKeys(paylimitValue);
		return this;
	}
	
	public ManagePaymentMethodsPage  clickUpdateButton()
	{
		updateButton.click();
		return this;
	}
	
	public List<String> tableListupdated()
	{
		List<String> tableListTextsUpdated = new ArrayList<String>();
		for(WebElement tablevalue : tableList)
		{
			tableListTextsUpdated.add(PageUtility.getElementText(tablevalue));
		}
		return tableListTextsUpdated;
	}
	
	public ManagePaymentMethodsPage  clearPayLimitTextField()
	{
		payLimitTextField.clear();
		return this;
	}
	
	//List<String> texts = Arrays.asList(null)
	
	
}
