package com.helpAI.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.helpAI.baseclass.BaseClass;
import com.helpAI.bot.HelpAndContact;

public class HelpAndContactTest extends BaseClass
{
	HelpAndContact help;
	
	@BeforeMethod
	public void load()
	{
		launchBrowser();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void clickOnHelpAnContact() throws Exception
	{
		help=new HelpAndContact();
		help.clickOn();
	}
}
