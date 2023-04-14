package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.obsqura.pages.LoginPage;

import utilities.ExcelUtility;

public class Login extends Base
{
	Login(WebDriver driver)
	{
		this.driver = driver;
	}
	LoginPage loginpage;
	public void verifyLoginwithValidcredentials() throws IOException
	{
		String titleofDashboard = ExcelUtility.getString(10, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "loginPage");
		String username = ExcelUtility.getString(3, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "loginPage");
		String password = ExcelUtility.getString(4, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "loginPage");
		loginpage = new LoginPage(driver);
		loginpage.enterTextinUsernameField(username);
		loginpage.enterTextinpasswordField(password);
		loginpage.clickSigninButton();
		System.out.println(loginpage.getTitleOfDashBoard());
		assertEquals(titleofDashboard,loginpage.getTitleOfDashBoard(),"Invalid Username/Password");
	}

}
