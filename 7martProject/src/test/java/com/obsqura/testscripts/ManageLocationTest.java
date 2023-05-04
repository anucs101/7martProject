package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManageDeliveryBoyPage;
import com.obsqura.pages.ManageLocationPage;
import com.obsqura.pages.SelectMenu;

import utilities.ExcelUtility;
import utilities.UtilityFile;

public class ManageLocationTest extends Base
{
	Login login;
	ManageLocationPage managelocationpage;
	SelectMenu selectmenu;
	
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyAddLocationInformations() 
	{
		String expectedAlert = ExcelUtility.getString(7, 0, UtilityFile.excelPath, "ManageLocation");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		managelocationpage= new ManageLocationPage(driver);
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(9, 0, UtilityFile.excelPath, "SelectMenu"));
		managelocationpage.clickNewButton().selectCountry().selectState().enterLocation().enterDeliveryCharge().clickSaveButton();
		assertEquals(expectedAlert,managelocationpage.alertElementText(),"location cannot be created");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyEditFunctionality() 
	{
		String expectedAlert = ExcelUtility.getString(9, 0, UtilityFile.excelPath, "ManageLocation");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		managelocationpage= new ManageLocationPage(driver);
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(9, 0, UtilityFile.excelPath, "SelectMenu"));
		managelocationpage.clickEditButton().editSelectState().editLocation().editDeliveryCharge().clickUpdateButton();
		System.out.println(managelocationpage.alertElementText());
		assertEquals(expectedAlert,managelocationpage.alertElementText(),"location cannot be updated");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifySearchusingCountryAndState() 
	{
		String searchElement = ExcelUtility.getString(1, 1, UtilityFile.excelPath, "ManageLocation");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		managelocationpage= new ManageLocationPage(driver);
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(9, 0, UtilityFile.excelPath, "SelectMenu"));
		managelocationpage.clickSearchButton().selectCountry().selectState().clickSearchButtonInSearchList();
		assertTrue(managelocationpage.SearchResults().contains(searchElement),"Search function is not working");
	}

}
