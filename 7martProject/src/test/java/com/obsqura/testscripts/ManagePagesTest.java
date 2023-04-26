package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.DashboardPageSelector;
import com.obsqura.pages.ManagePages;

import utilities.ExcelUtility;

public class ManagePagesTest extends Base
{
	ManagePages managepages;
	Login login;
	DashboardPageSelector dashboardpageselector;
	
	@Test (groups = { "smoke", "regression" })
	public void verifyBackgroundColorOfNewButton() throws IOException
	{
		String expectedBackGroundColorofNewButton = ExcelUtility.getString(1, 1,System.getProperty("user.dir")+constants.Constants.EXCELFILE,"ManagePage");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		dashboardpageselector = new DashboardPageSelector(driver);
		dashboardpageselector.navigateToPageFromDashboard(ExcelUtility.getString(1, 1,System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Dashboard"));
		managepages = new ManagePages(driver);
		assertEquals(expectedBackGroundColorofNewButton, managepages.backgroundColorOfNewButton(),"BackgroundColor does not match with the expected");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifySearchfunctinality() throws IOException
	{
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		dashboardpageselector = new DashboardPageSelector(driver);
		dashboardpageselector.navigateToPageFromDashboard(ExcelUtility.getString(1, 1,System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Dashboard"));
		managepages = new ManagePages(driver);
		managepages.clickSearchButton().enterTextinTitleFieldForSearch().clickSearchButtoninSearchListPages();
		assertTrue(managepages.listOfValuesinTableAfterSearch().contains(ExcelUtility.getString(4, 1,System.getProperty("user.dir")+constants.Constants.EXCELFILE,"ManagePage")),"Result not found");
	}
	
	

}
