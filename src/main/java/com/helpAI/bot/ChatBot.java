package com.helpAI.bot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helpAI.baseclass.BaseClass;

public class ChatBot extends BaseClass
{
	@FindBy(xpath="//a[@id='helpBotChat']")
	WebElement chatBot;
	
	public ChatBot() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public HelpAIWindowPage clickOnChatBot() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='helpBotChat']")));
		chatBot.click();
		return new HelpAIWindowPage();
	}	
}
