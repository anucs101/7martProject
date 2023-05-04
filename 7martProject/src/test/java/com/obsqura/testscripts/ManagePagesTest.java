package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.DashboardPageSelector;
import com.obsqura.pages.ManagePages;

import utilities.ExcelUtility;
import utilities.UtilityFile;

public class ManagePagesTest extends Base
{
	ManagePages managepages;
	Login login;
	DashboardPageSelector dashboardpageselector;
	
	@Test (groups = { "smoke", "regression" },retryAnalyzer = generaltests.Retry.class)
	public void verifyBackgroundColorOfNewButton() 
	{
		String expectedBackGroundColorofNewButton = ExcelUtility.getString(1, 1,UtilityFile.excelPath,"ManagePage");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		dashboardpageselector = new DashboardPageSelector(driver);
		dashboardpageselector.navigateToPageFromDashboard(ExcelUtility.getString(1, 1,UtilityFile.excelPath,"Dashboard"));
		managepages = new ManagePages(driver);
		assertEquals(expectedBackGroundColorofNewButton, managepages.backgroundColorOfNewButton(),"BackgroundColor does not match with the expected");
	}
	@Test(groups = { "smoke", },retryAnalyzer = generaltests.Retry.class)
	public void verifySearchfunctinality() 
	{
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		dashboardpageselector = new DashboardPageSelector(driver);
		dashboardpageselector.navigateToPageFromDashboard(ExcelUtility.getString(1, 1,UtilityFile.excelPath,"Dashboard"));
		managepages = new ManagePages(driver);
		managepages.clickSearchButton().enterTextinTitleFieldForSearch().clickSearchButtoninSearchListPages();
		assertTrue(managepages.listOfValuesinTableAfterSearch().contains(ExcelUtility.getString(4, 1,UtilityFile.excelPath,"ManagePage")),"Result not found");
	}
	
	

}
