package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.obsqura.pages.DashboardPageSelector;
import com.obsqura.pages.ManageOfferCodePage;


import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.UtilityFile;

public class ManageOfferCodeTest extends Base

{
	ManageOfferCodePage manageoffercodepage;
	Login login;
	DashboardPageSelector dashboardpageselector;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyNewFunctinalityinOfferCodesListAndOffercodeUpdatedSuccessfully() 
	{
		String expectedAlert = ExcelUtility.getString(2, 0,UtilityFile.excelPath,"ManageOffercode");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		manageoffercodepage = new ManageOfferCodePage(driver);
		dashboardpageselector =new DashboardPageSelector(driver);
		dashboardpageselector.navigateToPageFromDashboard(ExcelUtility.getString(2, 1,UtilityFile.excelPath,"Dashboard"));
		manageoffercodepage.clicknewButton().enterTextInofferCodeTextField().selectfirstOrderUserRadioButtonYes().enterTextInpercentageTextField().enterTextInamountTextField().enterTextIndescriptionTextField().uploadImage();
		assertEquals(expectedAlert,manageoffercodepage.alertElementText(),"New offercode cannot be created");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyDeleteFunctionality() 
	{
		
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		manageoffercodepage = new ManageOfferCodePage(driver);
		dashboardpageselector =new DashboardPageSelector(driver);
		dashboardpageselector.navigateToPageFromDashboard(ExcelUtility.getString(2, 1,UtilityFile.excelPath,"Dashboard"));
		int rowcountbeforeDelete = manageoffercodepage.numberOfRows();
		manageoffercodepage.clickDeleteButton();
		manageoffercodepage.numberOfRows();
		assertTrue(manageoffercodepage.numberOfRows()==(rowcountbeforeDelete-1));
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifySearchIfElementisNotPresent() 
	{
		String searchElement = ExcelUtility.getString(5, 1,UtilityFile.excelPath,"ManageOffercode");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		manageoffercodepage = new ManageOfferCodePage(driver);
		dashboardpageselector =new DashboardPageSelector(driver);
		dashboardpageselector.navigateToPageFromDashboard(ExcelUtility.getString(2, 1,UtilityFile.excelPath,"Dashboard"));
		manageoffercodepage.clickSearchButton();
		manageoffercodepage.enterOffercodeinSearch(searchElement);
		manageoffercodepage.clickSearchButtonInSearchList();
		assertFalse(manageoffercodepage.SearchResults().contains(searchElement),"Search function is not working");
	}
	
	
	
	
	

}
