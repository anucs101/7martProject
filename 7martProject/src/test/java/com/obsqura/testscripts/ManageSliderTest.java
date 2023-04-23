package com.obsqura.testscripts;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManageSliderPage;
import com.obsqura.pages.SelectMenu;

import utilities.ExcelUtility;

public class ManageSliderTest extends Base
{
	Login login;
	ManageSliderPage managesliderpage;
	SelectMenu selectmenu;
	@Test
	public void verifyeditbuttonAllignedBeforeDeleteButton() throws IOException
	{
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(4, 0,System.getProperty("user.dir")+constants.Constants.EXCELFILE,"SelectMenu"));
		managesliderpage = new ManageSliderPage(driver);
		assertTrue(managesliderpage.xAxisLocationofEditButton()<managesliderpage.xAxisLocationOfDeleteButton(),"allignments are not correct");
		
	}

}
