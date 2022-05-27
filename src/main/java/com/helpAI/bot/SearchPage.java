package com.helpAI.bot;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.helpAI.baseclass.BaseClass;

public class SearchPage extends BaseClass
{
	@FindBy(xpath="//div[@class='search-input-box-home']//input")
	WebElement searchBox;
	
	@FindBy(xpath="//div[@class='list_box']//div//a[2]")
	WebElement article;
	
	public SearchPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchOpt() throws Exception
	{
		searchBox.click();
		Thread.sleep(2000);
		searchBox.sendKeys("4041",Keys.ENTER);
	}
	
	public void selectArticle() throws Exception
	{
		Thread.sleep(2000);
		article.click();
	}
	public ChatBot scrollDown() throws AWTException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,5000);");
		return new ChatBot();
	}
}
