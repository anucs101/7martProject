package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import com.obsqura.pages.ManageDeliveryBoyPage;
import com.obsqura.pages.SelectMenu;

import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base
{
	Login login;
	ManageDeliveryBoyPage managedeliveryboypage;
	SelectMenu selectmenu;
	public void verifyTitleListDeliveryBoyWhenNavigatetoTheManageDeliveryBoyPage() throws IOException
	{
		String titleExpectedinDeliveryBoyPage = ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ManageDeliveryBoy");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		managedeliveryboypage= new ManageDeliveryBoyPage(driver);
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(2, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "SelectMenu"));
		assertEquals(titleExpectedinDeliveryBoyPage,managedeliveryboypage.titleofDeliveryBoyPage(),"title of manage delivery boy is not as expected");
	}

}
