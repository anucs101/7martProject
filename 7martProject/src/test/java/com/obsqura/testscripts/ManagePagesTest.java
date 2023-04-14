package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManagePages;

import utilities.ExcelUtility;

public class ManagePagesTest extends Base
{
	ManagePages managepages;
	Login login;
	
	@Test (groups = { "smoke", "regression" })
	public void verifyBackgroundColorOfNewButton() throws IOException
	{
		String expectedBackGroundColorofNewButton = ExcelUtility.getString(1, 1,System.getProperty("user.dir")+constants.Constants.EXCELFILE,"ManagePage");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		managepages = new ManagePages(driver);
		managepages.selectManagePage();
		assertEquals(expectedBackGroundColorofNewButton, managepages.backgroundColorOfNewButton(),"BackgroundColor does not match with the expected");
		
		
	}
	
	

}
