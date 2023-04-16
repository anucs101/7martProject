package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManageProductPage;
import com.obsqura.pages.SelectMenu;

import utilities.ExcelUtility;

public class ManageProductTest extends Base
{
	Login login;
ManageProductPage manageproductpage;
SelectMenu selectmenu;
	@Test
	public void verifyColorChangeofStockUnlimitedButtontoLimited() throws IOException
	{
		String colorOfUnlimitedButton = ExcelUtility.getString(2, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ManageProduct");
		String colorOflimitedButton = ExcelUtility.getString(5, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ManageProduct");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		manageproductpage = new ManageProductPage(driver);
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "SelectMenu"));
		assertTrue(manageproductpage.isUnlimitedButtonEnabled(),"unlimited Button is disabled");
		assertTrue(colorOfUnlimitedButton.equals(manageproductpage.colorOfUnlimitedButton()),"color of unlimited is not red");
		manageproductpage.clickUnlimitedButton();
		assertTrue(colorOflimitedButton.equals(manageproductpage.colorOflimitedButton()),"color of unlimited is not red");
		
	}
	

}
