package excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class exceldata {
	
	WebDriver d;
	String c,c1;
	@Test
	public void exceltest()
	{
		d = new FirefoxDriver();
		d.get("http://apps.vedasemantics.com/discovery");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		try
		{
			FileInputStream f = new FileInputStream(new File("C:\\Users\\20112\\Desktop\\Excel data.xlsx"));
			XSSFWorkbook w = new XSSFWorkbook(f);
			XSSFSheet s = w.getSheetAt(0);
			int d1 = s.getLastRowNum();
			
			for(int i =1; i<=d1;i++)
			{
				XSSFCell cell1 = s.getRow(i).getCell(0);
				XSSFCell cell2 = s.getRow(i).getCell(1);
				int k = cell1.getCellType();
				int l = cell2.getCellType();
				if(k!=XSSFCell.CELL_TYPE_BLANK && k!= XSSFCell.CELL_TYPE_ERROR)
				{
				if(k== XSSFCell.CELL_TYPE_STRING)
				{
					c =cell1.getStringCellValue();
				}else if(k== XSSFCell.CELL_TYPE_NUMERIC)
				{
					c = String.valueOf(Math.round(cell1.getNumericCellValue()));
				}
				}
				if(l!=XSSFCell.CELL_TYPE_BLANK && l!= XSSFCell.CELL_TYPE_ERROR)
				{
				if(l== XSSFCell.CELL_TYPE_STRING)
				{
					c1 =cell2.getStringCellValue();
				}else if(l== XSSFCell.CELL_TYPE_NUMERIC)
				{
					c1 = String.valueOf(Math.round(cell2.getNumericCellValue()));
				}
				
				d.findElement(By.id("userId")).sendKeys(c);
				d.findElement(By.id("password")).sendKeys(c1);
				d.findElement(By.cssSelector("input.btn-button.width100")).click();
				d.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/a/b")).click();
				Thread.sleep(1000);
				d.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/ul/li[3]/a")).click();
			}
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

@AfterTest
public void end()
{
	d.quit();
	}

}
