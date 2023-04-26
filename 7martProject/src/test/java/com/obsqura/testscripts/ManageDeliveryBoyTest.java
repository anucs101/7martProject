package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManageDeliveryBoyPage;
import com.obsqura.pages.SelectMenu;

import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base
{
	Login login;
	ManageDeliveryBoyPage managedeliveryboypage;
	SelectMenu selectmenu;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyTitleListDeliveryBoyWhenNavigatetoTheManageDeliveryBoyPage() throws IOException
	{
		String titleExpectedinDeliveryBoyPage = ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ManageDeliveryBoy");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		managedeliveryboypage= new ManageDeliveryBoyPage(driver);
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(2, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "SelectMenu"));
		assertEquals(titleExpectedinDeliveryBoyPage,managedeliveryboypage.titleofDeliveryBoyPage(),"title of manage delivery boy is not as expected");
	}
	@Test
	public void verifythatWhenaddingNewDeliveryBoyduplicateUserNameisNotAllowed() throws IOException
	{
		String expectedAlert = ExcelUtility.getString(5, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ManageDeliveryBoy");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		managedeliveryboypage= new ManageDeliveryBoyPage(driver);
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(2, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "SelectMenu"));
		managedeliveryboypage.clickNewButton().enterName().enterEmailID().enterPhoneNumber().enterAddress().enterUserName().enterPassword().clickSaveButton();
		managedeliveryboypage.WarningAlertText(); 
		assertEquals(expectedAlert,managedeliveryboypage.WarningAlertText(),"duplicate username allowed");
	}
	@Test
	public void verifynewDeliveryBoyDetailsUpdated() throws IOException
	{
		String expectedelement = ExcelUtility.getString(8, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ManageDeliveryBoy");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		managedeliveryboypage= new ManageDeliveryBoyPage(driver);
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(2, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "SelectMenu"));
		managedeliveryboypage.clickNewButton().enterNamewithoutfaker().enterEmailID().enterPhoneNumber().enterAddress().enterUserNameWithfaker().enterPassword().clickSaveButton();
		assertTrue(managedeliveryboypage.rowListupdated().contains(expectedelement),"information cannot be updated");
	}
	
	

}
