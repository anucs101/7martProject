package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageProductPage 

{
	WebDriver driver;
	public ManageProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//p[text()='Manage Product']")
	WebElement ManageProduct;
	
	@FindBy(xpath="//table[contains(@class,'table table-bordered')]//tbody")
	WebElement table;
	
	@FindBy(xpath="//table[contains(@class,'table table-bordered')]//tbody//td//span[text()='Unlimited']")
	WebElement unlimitedButton;
	
	@FindBy(xpath="//table[contains(@class,'table table-bordered')]//tbody//td//span[text()='Limited']")
	WebElement limitedButton;
	
	public void clickManageProduct()
	{
		WaitUtility.waitForElementIsPresent(driver, ManageProduct);
		PageUtility.clickOnElement(ManageProduct);
	}
	
	public boolean isUnlimitedButtonEnabled()
	{
		return PageUtility.isElementEnabled(unlimitedButton);
	}
	
	public void clickUnlimitedButton()
	{
		WaitUtility.waitForElementClickable(driver, unlimitedButton);
		PageUtility.clickOnElement(unlimitedButton);
		
	}
	
	public String colorOfUnlimitedButton()
	{
		return PageUtility.getCssValueofElement(unlimitedButton, "background-color");
	}
	public String colorOflimitedButton()
	{
		return PageUtility.getCssValueofElement(limitedButton, "background-color");
	}
	
	public String ManageproductPageUrl()
	{
		return driver.getCurrentUrl();
	}

}
