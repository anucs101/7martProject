package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManageProductPage;
import com.obsqura.pages.PushNotificationsPage;
import com.obsqura.pages.SelectMenu;

import utilities.ExcelUtility;
import utilities.UtilityFile;

public class PushNotificationsTest extends Base

{
	Login login;
	PushNotificationsPage pushnotificationspage;
	SelectMenu selectmenu;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verfyNotificationSentSuccessfully() 
	{
		String expectedAlertMessage = ExcelUtility.getString(0, 1, UtilityFile.excelPath, "PushNotification");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(3, 0, UtilityFile.excelPath, "SelectMenu"));
		pushnotificationspage = new PushNotificationsPage(driver);
		pushnotificationspage.enterTextIntitleField().enterTextInDescriptionField().clickSendButton();
		assertEquals(expectedAlertMessage,pushnotificationspage.alertMessage());
	}
}
