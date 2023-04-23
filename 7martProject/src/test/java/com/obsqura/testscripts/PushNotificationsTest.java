package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManageProductPage;
import com.obsqura.pages.PushNotificationsPage;
import com.obsqura.pages.SelectMenu;

import utilities.ExcelUtility;

public class PushNotificationsTest extends Base

{
	Login login;
	PushNotificationsPage pushnotificationspage;
	SelectMenu selectmenu;
	@Test
	public void verfyNotificationSentSuccessfully() throws IOException
	{
		String expectedAlertMessage = ExcelUtility.getString(0, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "PushNotification");
		login = new Login(driver);
		login.verifyLoginwithValidcredentials();
		selectmenu = new SelectMenu(driver);
		selectmenu.navigateToPage(ExcelUtility.getString(3, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "SelectMenu"));
		pushnotificationspage = new PushNotificationsPage(driver);
		assertTrue(pushnotificationspage.istitleFieldDisplayed(),"TitleField is not displayed");
		pushnotificationspage.enterTextIntitleField();
		assertTrue(pushnotificationspage.isDescriptionFieldDisplayed(),"DescriptionField is not displayed");
		pushnotificationspage.enterTextInDescriptionField();
		assertTrue(pushnotificationspage.isSendButtonEnabled(),"Send button is not disabled");
		pushnotificationspage.clickSendButton();
		assertEquals(expectedAlertMessage,pushnotificationspage.alertMessage());
	}
}
