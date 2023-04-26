package com.obsqura.testscripts;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManageSliderPage;
import com.obsqura.pages.SelectMenu;

import utilities.ExcelUtility;
import utilities.UtilityFile;

public class ManageSliderTest extends Base
{
	Login login;
	ManageSliderPage managesliderpage;
	SelectMenu selectmenu;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyeditbuttonAllignedBeforeDeleteButton() throws IOException
	{
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(4, 0,UtilityFile.excelPath,"SelectMenu"));
		managesliderpage = new ManageSliderPage(driver);
		assertTrue(managesliderpage.xAxisLocationofEditButton()<managesliderpage.xAxisLocationOfDeleteButton(),"allignments are not correct");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyImageUploadedSuccesfully() throws IOException
	{
		String expectedAlert = ExcelUtility.getString(3, 1, UtilityFile.excelPath, "ManageSlider");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(4, 0,UtilityFile.excelPath,"SelectMenu"));
		managesliderpage = new ManageSliderPage(driver);
		managesliderpage.clicknewButton().uploadImage().enterLink().clickSaveButton();
		managesliderpage.AlertText();
		assertEquals(expectedAlert,managesliderpage.AlertText(),"file cannot be uploaded");
		
	}

}
