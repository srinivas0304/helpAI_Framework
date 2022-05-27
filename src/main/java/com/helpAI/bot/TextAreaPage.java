package com.helpAI.bot;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helpAI.baseclass.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextAreaPage extends BaseClass
{
	@FindBy(xpath="//textarea[@id='ohb_ft_input']")
	WebElement typInTextArea;
	
	@FindBy(xpath="//button[@id='ohb_ft_send_btn']")
	WebElement clickOnSendBtn;
	
	@FindBy(xpath="(//div[@class='hoverSource'])[6]")
	WebElement text;
	
	public TextAreaPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void textArea()
	{
		WebDriverWait wait =new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//textarea[@id='ohb_ft_input']")));
		typInTextArea.sendKeys("return");
	}
	
	public void sendBtn()
	{
		clickOnSendBtn.click();	
	}
	public void content() throws Exception
	{
		File src=new File("C:\\Users\\addla\\Maven_Project\\HelpAI\\src\\main\\resources\\TestData\\Return.xlsx");
		FileInputStream fs=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		
		int rowCount=sheet.getLastRowNum();
		
		System.out.println("The number of rows: "+rowCount);
		
		for(int i=0;i<rowCount;i++)
		{
			text.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			
		WebElement ele=	driver.findElement(By.xpath("(//div[@class='hoverSource'])[8]"));
		XSSFCell cell2 = sheet.getRow(i).createCell(2);

		if (ele.isDisplayed()) 
		{
			cell2.setCellValue("Pass");
		} else 
		{
			cell2.setCellValue("Fail");
		}
		}
	}
}
