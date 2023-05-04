package com.obsqura.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.RandomDataUtility;
import utilities.PageUtility;
import utilities.UtilityFile;
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
	
	@FindBy(xpath ="//i[@class='fas fa-trash-alt']")
	WebElement deleteButton;
	
	@FindBy(xpath ="//a[contains(@class,'btn-danger')]")
	List<WebElement> rows;
	
	@FindBy(xpath ="//a[@onclick='click_button(2)']")
	WebElement searchButton;
	
	@FindBy(xpath ="//input[@placeholder='Offer Code']")
	WebElement searchOffercode;
	
	@FindBy(xpath ="//button[@name='Search']")
	WebElement searchButtoninSearchList;
	
	@FindBy(xpath="//table[contains(@class,'table')]//tbody//tr//td")
	List<WebElement> listAfterSearch;
	
	public ManageOfferCodePage clicknewButton()
	{
		WaitUtility.waitForElement(driver, newButton);
		newButton.click();
		return this;
	}
	
	public ManageOfferCodePage enterTextInofferCodeTextField()
	{
		WaitUtility.waitForElement(driver, offerCodeTextField);
		offerCodeTextField.sendKeys(RandomDataUtility.firstName());
		return this;
	}
	
	public ManageOfferCodePage selectfirstOrderUserRadioButtonYes()
	{
		firstOrderUserRadioButtonYes.click();
		return this;
	}
	
	public ManageOfferCodePage enterTextInpercentageTextField()
	{
		percentageTextField.sendKeys(RandomDataUtility.percentage());
		return this;
	}
	
	public ManageOfferCodePage enterTextInamountTextField()
	{
		amountTextField.sendKeys(RandomDataUtility.amount());
		return this;
	}
	
	public ManageOfferCodePage enterTextIndescriptionTextField()
	{
		descriptionTextField.sendKeys(RandomDataUtility.firstName());
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
	
	
	public ManageOfferCodePage uploadImage() 
	{
		PageUtility.ScrollBy(driver);
		chooseFile.sendKeys(ExcelUtility.getString(7, 0,UtilityFile.excelPath,"ManageOffercode"));
		chooseFile.submit();
		return this;
	}
	
	public void clickDeleteButton()
	{
		deleteButton.click();
		driver.switchTo().alert().accept();
	}
	
	public int numberOfRows()
	{
		return rows.size();
	}
	
	public void clickSearchButton()
	{
		searchButton.click();
	
	}
	
	public void enterOffercodeinSearch(String element)
	{
		searchOffercode.sendKeys(element);
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
