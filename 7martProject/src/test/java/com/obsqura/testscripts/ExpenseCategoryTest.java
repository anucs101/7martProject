package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.testng.annotations.Test;
import com.obsqura.pages.ExpenseCategoryPage;
import com.obsqura.pages.SelectMenu;
import utilities.ExcelUtility;
import utilities.UtilityFile;

public class ExpenseCategoryTest extends Base

{
	Login login;
	SelectMenu selectmenu;
	ExpenseCategoryPage expensecategorypage;
	
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyRowCountofExpenseCategoryTable() throws IOException
	{
		int expectedNumberOfRows = ExcelUtility.getNumericValue(7, 1, UtilityFile.excelPath, "ExpenseCategory");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		expensecategorypage= new ExpenseCategoryPage(driver);
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(7, 0, UtilityFile.excelPath, "SelectMenu"));
		selectmenu.navigateToPage(ExcelUtility.getString(7, 1, UtilityFile.excelPath, "SelectMenu"));
		assertEquals(expectedNumberOfRows,expensecategorypage.numberOfRows(),"Number of Rows are Wrong in a page");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyWidthOfActionColumn() throws IOException
	{
		String expectedWidthofActionColumn = ExcelUtility.getString(2, 2, UtilityFile.excelPath, "ExpenseCategory");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		expensecategorypage= new ExpenseCategoryPage(driver);
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(7, 0, UtilityFile.excelPath, "SelectMenu"));
		selectmenu.navigateToPage(ExcelUtility.getString(7, 1, UtilityFile.excelPath, "SelectMenu"));
		assertEquals(expectedWidthofActionColumn,expensecategorypage.widthOfActionColumn(),"Width of action column is wrong");
		}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyAddingExpenseCategoryInformationswithDuplicateTitle() throws IOException
	{
		String expectedAlert = ExcelUtility.getString(6, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ExpenseCategory");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		expensecategorypage= new ExpenseCategoryPage(driver);
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(7, 0, UtilityFile.excelPath, "SelectMenu"));
		selectmenu.navigateToPage(ExcelUtility.getString(7, 1, UtilityFile.excelPath, "SelectMenu"));
		expensecategorypage.clickNewButton().enterTitle().clickSaveButton();
		assertEquals(expectedAlert,expensecategorypage.alertElementText(),"duplicate username exist");
	}
	

}
