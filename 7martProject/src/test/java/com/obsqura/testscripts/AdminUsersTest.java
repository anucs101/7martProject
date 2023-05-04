package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.obsqura.pages.AdminUsersPage;
import com.obsqura.pages.DashboardPageSelector;
import com.obsqura.pages.SelectMenu;

import utilities.ExcelUtility;
import utilities.UtilityFile;


public class AdminUsersTest extends Base
{
	AdminUsersPage adminuserspage;
	Login login;
	SelectMenu selectmenu;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyWhenClickingHomeinAdminUsersPageitgoestoDashBoardPage() 
	{
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(6, 0,UtilityFile.excelPath,"SelectMenu"));
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickHomeLinkElement();
		assertTrue(adminuserspage.expectedElementIsPresent(),"cannot navigate to dashboard");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifydropdownMenuWhenAddingUsersInformation() 
	{
		ArrayList<String> expectedDropdownMenuOptions = ExcelUtility.getRow(System.getProperty("user.dir")+constants.Constants.EXCELFILE, "Adminusers", 3);
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(6, 0,UtilityFile.excelPath,"SelectMenu"));
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickNewButton();
		assertTrue(expectedDropdownMenuOptions.equals(adminuserspage.dropdownMenuOptionsList()));
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyDeleteFunctionalityAndCheckAlert() 
	{
		String expectedAlert = ExcelUtility.getString(7, 0,UtilityFile.excelPath,"Adminusers");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(6, 0,UtilityFile.excelPath,"SelectMenu"));
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickDeleteButton().clickOktoPopupWindow();
		assertEquals(expectedAlert,adminuserspage.alertElementText(),"value cannot be deleted");
		
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyAddingUsersInformations() 
	{
		String expectedAlert = ExcelUtility.getString(10, 1,UtilityFile.excelPath,"Adminusers");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(6, 0,UtilityFile.excelPath,"SelectMenu"));
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickNewButton().enterUserName().enterPassword().selectAdmin().clickSaveButton();
		assertEquals(expectedAlert,adminuserspage.alertElementText(),"could not add new user");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyUnlockButtonChangesStatusofUserbyCheckingBackgroundColor() 
	{
		String expectedBackgroundColor = ExcelUtility.getString(13, 1,UtilityFile.excelPath,"Adminusers");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(6, 0,UtilityFile.excelPath,"SelectMenu"));
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickUnloackButton();
		assertTrue(adminuserspage.backgroundColorOfStatusButton().equals(expectedBackgroundColor),"status cannot be changed with unlock button");
	}

}
