package com.helpAI.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContentCheck
{
	@Test
	public void content() throws Exception
	{
		File src=new File("C:\\Srinivas\\TestDate1.xlsx");
		FileInputStream fs=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		
		int rowCount=sheet.getLastRowNum();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://mat.aima.in/feb22/register-online");
		
		System.out.println("The number of rows: "+rowCount);
		WebElement text=driver.findElement(By.xpath("(//div[@class='hoverSource'])[6]"));
		
		for(int i=0;i<rowCount;i++)
		{
			text.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
		}
	}
	
}
