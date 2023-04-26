package com.obsqura.testscripts;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ExpenseCategoryPage;
import com.obsqura.pages.ManageUsersPage;
import com.obsqura.pages.SelectMenu;

import utilities.ExcelUtility;

public class ManageUsersTest extends Base
{
	Login login;
	SelectMenu selectmenu;
	ManageUsersPage manageuserspage;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifythatWhenclickingPaaswordButtonPasswordIsShownInBelowRow() throws IOException
	{
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		manageuserspage= new ManageUsersPage(driver);
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(8, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "SelectMenu"));
		manageuserspage.clickPasswordButton();
		assertTrue(manageuserspage.passwordFieldisPresent(),"Could not open password field when clicking password button");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyBackGroundColorOfAlert() throws IOException
	{
		String expectedBackgroundColorOfAlert = ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "Manageuser");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		manageuserspage= new ManageUsersPage(driver);
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(8, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "SelectMenu"));
		manageuserspage.clickActiveButton();
		assertEquals(expectedBackgroundColorOfAlert,manageuserspage.backgroundColorOfAlert(),"Background color of alert is not green");
		
	
	}

}
