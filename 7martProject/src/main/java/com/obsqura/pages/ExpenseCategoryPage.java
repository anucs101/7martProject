package com.obsqura.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ExpenseCategoryPage 
{
	WebDriver driver;
	public ExpenseCategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//table[contains(@class,'table')]//tr")
	List<WebElement> Rows;
	
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	WebElement expenseCategory;
	
	@FindBy(xpath ="//th[text()='Action']")
	WebElement Action;
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")
	WebElement newButton;
	
	
	@FindBy(xpath="//input[@id='name']")
	WebElement titleField;
	
	@FindBy(xpath="//button[@name='Create']")
	WebElement SaveButton;
	
	@FindBy(xpath="//div[contains(@class,'alert')]")
	WebElement alertElement;
	
	@FindBy(xpath="//p[text()='Expense Category']")
	WebElement expenseCategoryPage;
	
	
	
	
	public int numberOfRows()
	{
		WaitUtility.waitForvisibilityOfAllElements(driver, Rows);
		return Rows.size();
	}
	
	public String widthOfActionColumn() 
	{
		String propertyname = ExcelUtility.getString(2, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ExpenseCategory");
		WaitUtility.waitForElementIsPresent(driver, Action);
		return PageUtility.getCssValueofElement(Action, propertyname);
	}
	
	public ExpenseCategoryPage  clickNewButton()
	{
		WaitUtility.waitForElementIsPresent(driver, newButton);
		newButton.click();
		return this;
	}
	
	public ExpenseCategoryPage  enterTitle() 
	{
		String titletext = ExcelUtility.getString(4, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ExpenseCategory");
		PageUtility.enterText(titleField, titletext);
		return this;
	}
	
	public ExpenseCategoryPage clickSaveButton()
	{
		SaveButton.click();
		return this;
	}
	
	public String alertElementText()
	{
		return PageUtility.getElementText(alertElement);
	}
	
	public void clickExpenseCategory()
	{
		WaitUtility.waitForElementClickable(driver, expenseCategoryPage);
		expenseCategoryPage.click();
	}
	

}
