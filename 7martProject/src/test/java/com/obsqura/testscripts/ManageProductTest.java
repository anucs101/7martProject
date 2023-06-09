package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.obsqura.pages.ManageProductPage;
import com.obsqura.pages.SelectMenu;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.UtilityFile;

public class ManageProductTest extends Base
{
Login login;
ManageProductPage manageproductpage;
SelectMenu selectmenu;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyColorChangeofStockUnlimitedButtontoLimited() 
	{
		String colorOfUnlimitedButton = ExcelUtility.getString(2, 1, UtilityFile.excelPath, "ManageProduct");
		String colorOflimitedButton = ExcelUtility.getString(5, 1, UtilityFile.excelPath, "ManageProduct");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		manageproductpage = new ManageProductPage(driver);
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(1, 0, UtilityFile.excelPath, "SelectMenu"));
		assertTrue(colorOfUnlimitedButton.equals(manageproductpage.colorOfUnlimitedButton()),"color of unlimited is not red");
		manageproductpage.clickUnlimitedButton();
		assertTrue(colorOflimitedButton.equals(manageproductpage.colorOflimitedButton()),"color of unlimited is not red");
		
	}

	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyManageProductPageIsAvailableWhenClickintoManageProductfromleftPane() 
	{
		String expectedUrl = ExcelUtility.getString(7, 1, UtilityFile.excelPath, "ManageProduct");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(1, 0, UtilityFile.excelPath, "SelectMenu"));
		manageproductpage = new ManageProductPage(driver);
		assertEquals(expectedUrl,manageproductpage.ManageproductPageUrl(),"Cannot be navigated to Manage product page");
	}
	
	
	
	

}
