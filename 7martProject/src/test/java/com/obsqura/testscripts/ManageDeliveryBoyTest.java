package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import com.obsqura.pages.ManageDeliveryBoyPage;

import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base
{
	ManageDeliveryBoyPage managedeliveryboypage;
	public void verifyTitleListDeliveryBoy() throws IOException
	{
		String titleExpectedinDeliveryBoyPage = ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ManageDeliveryBoy");
		managedeliveryboypage= new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickManageDeliveryBoy();
		assertEquals(titleExpectedinDeliveryBoyPage,managedeliveryboypage.titleofDeliveryBoyPage(),"title of manage delivery boy is not as expected");
		
	}

}
