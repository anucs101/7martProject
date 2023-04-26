package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;

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

public class ManageOfferCodeTest extends Base

{
	ManageOfferCodePage manageoffercodepage;
	Login login;
	DashboardPageSelector dashboardpageselector;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyNewFunctinalityinOfferCodesListAndOffercodeUpdatedSuccessfully() throws IOException
	{
		String expectedAlert = ExcelUtility.getString(2, 0,System.getProperty("user.dir")+constants.Constants.EXCELFILE,"ManageOffercode");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		manageoffercodepage = new ManageOfferCodePage(driver);
		dashboardpageselector =new DashboardPageSelector(driver);
		dashboardpageselector.navigateToPageFromDashboard(ExcelUtility.getString(2, 1,System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Dashboard"));
		manageoffercodepage.clicknewButton().enterTextInofferCodeTextField().selectfirstOrderUserRadioButtonYes().enterTextInpercentageTextField().enterTextInamountTextField().enterTextIndescriptionTextField().uploadImage();
		assertEquals(expectedAlert,manageoffercodepage.alertElementText(),"New offercode cannot be created");
	}
	
	
	
	
	

}
