package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManagePages 
{
	
	WebDriver driver;
	public ManagePages(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//a[@onclick='click_button(1)']")
	WebElement newButton;
	
	
	
	public String backgroundColorOfNewButton()
	{
		WaitUtility.waitForElementIsPresent(driver, newButton);
		return PageUtility.getCssValueofElement(newButton, "background-color");
	}
	
	
	public void listOfCategoriesinDashboard(String selectPage)
	{
			
		List<WebElement> Categories = driver.findElements(By.xpath("//ul[@class='nav nav-treeview']//p"));
		for(WebElement category:Categories)
		{
			if(category.getText().equals(selectPage))
			{
				category.click();
				break;
			}
				
		}
	}
	
	public void selectManagePage()
	{
		listOfCategoriesinDashboard("Manage Pages");
	}
	

}
