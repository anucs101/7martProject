package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.obsqura.pages.ManagePaymentMethodsPage;
import com.obsqura.pages.ManageProductPage;
import com.obsqura.pages.SelectMenu;

import utilities.ExcelUtility;

public class ManagePaymentMethodsTest extends Base
{
	Login login;
	ManagePaymentMethodsPage managepaymentmethodspage;
	SelectMenu selectmenu;
	@Test
	public void verifytableheadersofManagePaymentMethods() throws IOException
	{
		ArrayList<String> expectedTableHeaders = ExcelUtility.getRow(System.getProperty("user.dir")+constants.Constants.EXCELFILE, "ManagePaymentMethods", 3);
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(5, 0,System.getProperty("user.dir")+constants.Constants.EXCELFILE,"SelectMenu"));
		managepaymentmethodspage = new ManagePaymentMethodsPage(driver);
		assertTrue(expectedTableHeaders.equals(managepaymentmethodspage.tableHeadersList()),"Table headers are not matching as expected");
	}
	@Test
	public void verifythatEditchangesInPaylimitUpdatedInManagePaymentMethodsTable() throws IOException
	{
		String payLimitValue = ExcelUtility.getNumeric(0, 1,System.getProperty("user.dir")+constants.Constants.EXCELFILE,"ManagePaymentMethods");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(5, 0,System.getProperty("user.dir")+constants.Constants.EXCELFILE,"SelectMenu"));
		managepaymentmethodspage = new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.clickEditButton();
		managepaymentmethodspage.clearPayLimitTextField();
		managepaymentmethodspage.enterValueinPayLimitTextField(payLimitValue);
		managepaymentmethodspage.clickUpdateButton();
		System.out.println(managepaymentmethodspage.tableListupdated());
		assertTrue(managepaymentmethodspage.tableListupdated().contains(payLimitValue),"pay limit value is not updated");
		
	}

}
