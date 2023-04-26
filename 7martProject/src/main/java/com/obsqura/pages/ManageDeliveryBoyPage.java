package com.obsqura.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

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
	
	@FindBy(xpath="//input[@type='email']")
	WebElement emailFiled;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement phoneNoFiled;
	
	@FindBy(xpath="//textarea[@id='address']")
	WebElement addressFiled;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement userNameFiled;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement passwordFiled;
	
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	
	@FindBy(xpath="//div[contains(@class,'alert')]")
	WebElement alertElement;
	
	@FindBy(xpath="//table[contains(@class,'table')]//tbody//tr//td")
	List<WebElement> row;
	
	public String titleofDeliveryBoyPage()
	{
		return PageUtility.getElementText(TitleFieldOfManageDeliveryBoyPage);
	}
	
	public ManageDeliveryBoyPage clickNewButton()
	{
		newButton.click();
		return this;
	}
	
	public ManageDeliveryBoyPage enterName()
	{
		PageUtility.enterText(nameFiled, FakerUtility.firstName());
		return this;
	}
	
	public ManageDeliveryBoyPage enterEmailID()
	{
		PageUtility.enterText(emailFiled, FakerUtility.emailID());
		return this;
	}
	
	public ManageDeliveryBoyPage enterPhoneNumber()
	{
		PageUtility.enterText(phoneNoFiled, FakerUtility.phoneNumber());
		return this;
	}
	
	public ManageDeliveryBoyPage enterAddress()
	{
		PageUtility.enterText(addressFiled, FakerUtility.lastName());
		return this;
	}
	
	public ManageDeliveryBoyPage enterUserName() throws IOException
	{
		String username = ExcelUtility.getString(3, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ManageDeliveryBoy");
		PageUtility.enterText(userNameFiled, username);
		return this;
	}
	
	public ManageDeliveryBoyPage enterPassword()
	{
		PageUtility.enterText(passwordFiled, FakerUtility.lastName());
		WaitUtility.waitForElementIsPresent(driver, saveButton);
		return this;
	}
	
	public ManageDeliveryBoyPage clickSaveButton()
	{
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementClickable(driver, saveButton);
		saveButton.submit();
		return this;
	}
	
	public String WarningAlertText()
	{
		return PageUtility.getElementText(alertElement);
	}
	
	public ManageDeliveryBoyPage enterNamewithoutfaker() throws IOException
	{
		String name = ExcelUtility.getString(8, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ManageDeliveryBoy");
		PageUtility.enterText(nameFiled,name);
		return this;
	}
	
	public ManageDeliveryBoyPage enterUserNameWithfaker() throws IOException
	{
		PageUtility.enterText(userNameFiled,FakerUtility.firstName());
		return this;
	}
	
	public List<String> rowListupdated()
	{
		List<String> rowListTextsUpdated = new ArrayList<String>();
		for(WebElement tablevalue : row)
		{
			rowListTextsUpdated.add(PageUtility.getElementText(tablevalue));
		}
		return rowListTextsUpdated;
	}
	
	
	

}
