package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.obsqura.pages.ManagePaymentMethodsPage;
import com.obsqura.pages.ManageProductPage;
import com.obsqura.pages.SelectMenu;

import utilities.ExcelUtility;
import utilities.UtilityFile;

public class ManagePaymentMethodsTest extends Base
{
	Login login;
	ManagePaymentMethodsPage managepaymentmethodspage;
	SelectMenu selectmenu;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifytableheadersofManagePaymentMethods() 
	{
		ArrayList<String> expectedTableHeaders = ExcelUtility.getRow(UtilityFile.excelPath, "ManagePaymentMethods", 3);
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(5, 0,UtilityFile.excelPath,"SelectMenu"));
		managepaymentmethodspage = new ManagePaymentMethodsPage(driver);
		assertTrue(expectedTableHeaders.equals(managepaymentmethodspage.tableHeadersList()),"Table headers are not matching as expected");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifythatEditchangesInPaylimitUpdatedInManagePaymentMethodsTable() 
	{
		String payLimitValue = ExcelUtility.getNumeric(0, 1,UtilityFile.excelPath,"ManagePaymentMethods");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(5, 0,UtilityFile.excelPath,"SelectMenu"));
		managepaymentmethodspage = new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.clickEditButton().clearPayLimitTextField().enterValueinPayLimitTextField(payLimitValue).clickUpdateButton();
		assertTrue(managepaymentmethodspage.tableListupdated().contains(payLimitValue),"pay limit value is not updated");
		
	}

}
