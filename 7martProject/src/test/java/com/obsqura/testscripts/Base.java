package com.obsqura.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;

public class Base
{
	public WebDriver driver;
	public ScreenShotUtility scrshot;
	public Properties prop,prop1;
	FileInputStream fs,fs1;
	
	@BeforeMethod(alwaysRun =true)
	@Parameters({"browser"})
	public  void initializeBrowser(String browser) throws Exception
	{
		
		prop=new Properties();
		try {
			fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.CONFIGfILE);

		} catch (Exception e) {
			
		}
		try {
			prop.load(fs);
		} catch (Exception e) {
			
		}
		prop1=new Properties();

		try {
			fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.TESTDATAFILE);


		} catch (Exception e) {
			
		}
		try {

			prop1.load(fs);
		} catch (Exception e) {
			
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver = WebDriverManager.firefoxdriver().create();
		
		}
			
		else if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().create();
			driver = new ChromeDriver(chromeOptions);
			
		}
			
		else if(browser.equalsIgnoreCase("Edge"))
		{
			
			
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--remote-allow-origins=*");
			WebDriverManager.edgedriver().create();
			driver = new EdgeDriver(edgeOptions);
			
		}
		else
		{
			throw new Exception("Browser is not correct");
		}
		
		driver.get(prop.getProperty("url"));
		WaitUtility.implicitWait(driver);
		driver.manage().window().maximize();
		WaitUtility.pageLoadWait(driver);
	}
	
	@AfterMethod(alwaysRun=true)
	public void browserQuit(ITestResult iTestResult) throws IOException 
	{
		if (iTestResult.getStatus() == ITestResult.FAILURE) 
		{
			scrshot = new ScreenShotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}
		
		driver.quit();
	}
	

}
