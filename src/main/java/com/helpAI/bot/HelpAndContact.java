package com.helpAI.bot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.helpAI.baseclass.BaseClass;

public class HelpAndContact extends BaseClass
{
	@FindBy(xpath="//a[text()=' Help & Contact']")
	WebElement helpContact;
	
	
	public HelpAndContact()
	{
		PageFactory.initElements(driver, this);
	}
	
	public SearchPage clickOn() throws InterruptedException
	{
		helpContact.click();
		String expectedTitle="eBay Customer Service";
		Thread.sleep(2000);
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		return new SearchPage();
	}
}
