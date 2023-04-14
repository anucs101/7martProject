package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManageProductPage;

import utilities.ExcelUtility;

public class ManageProductTest extends Base
{

ManageProductPage manageproductpage;
	@Test
	public void verifyColorChangeofStockUnlimitedButtontoLimited() throws IOException
	{
		String colorOfUnlimitedButton = ExcelUtility.getString(2, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ManageProduct");
		String colorOflimitedButton = ExcelUtility.getString(5, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ManageProduct");
		manageproductpage = new ManageProductPage(driver);
		manageproductpage.clickManageProduct();
		assertTrue(manageproductpage.isUnlimitedButtonEnabled(),"unlimited Button is disabled");
		assertTrue(colorOfUnlimitedButton.equals(manageproductpage.colorOfUnlimitedButton()),"color of unlimited is not red");
		manageproductpage.clickUnlimitedButton();
		assertTrue(colorOflimitedButton.equals(manageproductpage.colorOflimitedButton()),"color of unlimited is not red");
		
	}

}
