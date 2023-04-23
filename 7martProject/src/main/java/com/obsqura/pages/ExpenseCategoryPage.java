package com.obsqura.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.PageUtility;

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
	
	
	
	public void clickExpenseCategory()
	{
		expenseCategory.click();
	}
	
	public int numberOfRows()
	{
		return Rows.size();
	}
	
	public String widthOfActionColumn() throws IOException
	{
		String propertyname = ExcelUtility.getString(2, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ExpenseCategory");
		return PageUtility.getCssValueofElement(Action, propertyname);
	}
	

}
