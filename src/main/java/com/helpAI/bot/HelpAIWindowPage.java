package com.helpAI.bot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helpAI.baseclass.BaseClass;

public class HelpAIWindowPage extends BaseClass
{
	
	@FindBy(xpath="//div[@id='ocs_help_bot']//div[4]//button[2]")
	WebElement clickOnCantSignin;
	
	@FindBy(xpath="//div[@class='ohb-conv hoverSource']")
	WebElement timeStamp;
	
	
	public HelpAIWindowPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void cannotSignin() throws Exception
	{
		WebDriverWait wait =new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='ocs_help_bot']//div[4]//button[2]")));
<<<<<<< HEAD
=======
		//wait.until(ExpectedConditions.elementToBeClickable(clickOnCantSignin));
>>>>>>> c166089 (new changes added)
		clickOnCantSignin.click();
	}
	
	public TextAreaPage verifyTimeStamp() throws Exception
	{
		Thread.sleep(2000);
		boolean timeSta=timeStamp.isDisplayed();
		System.out.println(timeSta);
		return new TextAreaPage();
		
	}
	
}
