package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.obsqura.pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;


public class LoginPageTest extends Base
{
	
	
	LoginPage loginpage;
	@Test(dataProvider="loginProvider")
	public void verifylogin(String username,String password) throws IOException
	{
		String titleofDashboard = ExcelUtility.getString(10, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "loginPage");
		loginpage = new LoginPage(driver);
		assertTrue(loginpage.isUsernameFieldDisplayed(),"username field is not present");
		loginpage.enterTextinUsernameField(username);
		assertTrue(loginpage.isPasswordFieldDisplayed(),"password field is not present");
		loginpage.enterTextinpasswordField(password);
		assertTrue(loginpage.isSigninButtonEnabled(),"Sign in button is not enabled");
		loginpage.clickSigninButton();
		assertEquals(titleofDashboard,loginpage.getTitleOfDashBoard(),"Invalid Username/Password");
		
	}
	@Test
	public void verifyAlertMessageWithInvalidUsernameAndValidPassword() throws IOException
	{
		String expectedAlertMessage = ExcelUtility.getString(12, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "loginPage");
		String username = FakerUtility.firstName();
		String password = ExcelUtility.getString(4, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "loginPage");
		loginpage = new LoginPage(driver);
		loginpage.enterTextinUsernameField(username);
		loginpage.enterTextinpasswordField(password);
		assertTrue(loginpage.isSigninButtonEnabled(),"Sign in button is not enabled");
		loginpage.clickSigninButton();
		loginpage.alertMessage();
		assertEquals(expectedAlertMessage,loginpage.alertMessage(),"Proper alert is not shown");
		
	}
	@Test
	public void verifyLoginwithValidUsernameAndPassword() throws IOException
	{
		String titleofDashboard = ExcelUtility.getString(10, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "loginPage");
		String username = ExcelUtility.getString(3, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "loginPage");
		String password = ExcelUtility.getString(4, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "loginPage");
		loginpage = new LoginPage(driver);
		loginpage.enterTextinUsernameField(username);
		loginpage.enterTextinpasswordField(password);
		loginpage.clickSigninButton();
		assertEquals(titleofDashboard,loginpage.getTitleOfDashBoard(),"Invalid Username/Password");
	}
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataprovider()
	{
	    return new Object[][] 
	    	{
	            {"user","ad43" },
	            { "Anu","admin"},
	            {"admin","rev" },	
	            { "admin","admin"}
	    	};
	}
	
}
