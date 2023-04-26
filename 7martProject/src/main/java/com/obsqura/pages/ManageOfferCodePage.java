package com.obsqura.pages;

import java.io.IOException;
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
	
	@FindBy(xpath ="//input[@name='main_img']")
	WebElement chooseFile;
	
	public ManageOfferCodePage clicknewButton()
	{
		WaitUtility.waitForElement(driver, newButton);
		newButton.click();
		return this;
	}
	
	public ManageOfferCodePage enterTextInofferCodeTextField()
	{
		WaitUtility.waitForElement(driver, offerCodeTextField);
		offerCodeTextField.sendKeys(FakerUtility.firstName());
		return this;
	}
	
	public ManageOfferCodePage selectfirstOrderUserRadioButtonYes()
	{
		firstOrderUserRadioButtonYes.click();
		return this;
	}
	
	public ManageOfferCodePage enterTextInpercentageTextField()
	{
		percentageTextField.sendKeys(FakerUtility.percentage());
		return this;
	}
	
	public ManageOfferCodePage enterTextInamountTextField()
	{
		amountTextField.sendKeys(FakerUtility.amount());
		return this;
	}
	
	public ManageOfferCodePage enterTextIndescriptionTextField()
	{
		descriptionTextField.sendKeys(FakerUtility.firstName());
		return this;
	}
	
	public ManageOfferCodePage clickSaveButton()
	{
		PageUtility.ScrollBy(driver);
		saveButton.click();
		return this;
	}
	
	public String alertElementText()
	{
		return alertElement.getText();
	}
	
	
	public ManageOfferCodePage uploadImage() throws IOException
	{
		PageUtility.ScrollBy(driver);
		chooseFile.sendKeys("D:\\product.jpg");
		chooseFile.submit();
		return this;
	}
	
	
	

}
