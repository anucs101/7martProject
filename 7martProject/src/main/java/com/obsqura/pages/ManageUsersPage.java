
package com.obsqura.pages;

import java.io.IOException;

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
	
	
	public void clickPasswordButton()
	{
		passwordButton.click();
	}
	
	public boolean passwordFieldisPresent()
	{
		return PageUtility.isElementDisplayed(passwordField);
	}
	
	public String backgroundColorOfAlert() throws IOException
	{
		String propertyName = ExcelUtility.getString(0, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "Manageuser");
		return PageUtility.getCssValueofElement(alertElement,propertyName);
	}
	
	public void clickActiveButton()
	{
		activeButton.click();
	}
	
	
	

}
