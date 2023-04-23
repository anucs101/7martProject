package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageOfferCodePage 
{
	WebDriver driver;
	public ManageOfferCodePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	
	@FindBy(xpath ="//a[@onclick='click_button(1)']")
	WebElement newButton;
	
	@FindBy(xpath ="//input[@id='offer_code']")
	WebElement offerCodeTextField;
	
	@FindBy(xpath ="//input[@value='yes']")
	WebElement firstOrderUserRadioButtonYes;
	
	@FindBy(xpath ="//input[@id='offer_per']")
	WebElement percentageTextField;
	
	@FindBy(xpath ="//input[@id='offer_price']")
	WebElement amountTextField;
	
	@FindBy(xpath ="//div[@role='textbox']")
	WebElement descriptionTextField;
	
	@FindBy(xpath ="//button[@type='submit']")
	WebElement saveButton;
	
	@FindBy(xpath ="//div[contains(@class,'alert')]")
	WebElement alertElement;
	
	
	
	public void clicknewButton()
	{
		WaitUtility.waitForElement(driver, newButton);
		newButton.click();
	}
	
	public void enterTextInofferCodeTextField()
	{
		WaitUtility.waitForElement(driver, offerCodeTextField);
		offerCodeTextField.sendKeys(FakerUtility.firstName());
	}
	
	public void selectfirstOrderUserRadioButtonYes()
	{
		firstOrderUserRadioButtonYes.click();
	}
	
	public void enterTextInpercentageTextField()
	{
		percentageTextField.sendKeys(FakerUtility.percentage());
	}
	
	public void enterTextInamountTextField()
	{
		amountTextField.sendKeys(FakerUtility.amount());
	}
	
	public void enterTextIndescriptionTextField()
	{
		descriptionTextField.sendKeys(FakerUtility.firstName());
	}
	
	public void clickSaveButton()
	{
		PageUtility.ScrollBy(driver);
		saveButton.click();
	}
	
	public String alertElementText()
	{
		return alertElement.getText();
	}
	
	
	

}
