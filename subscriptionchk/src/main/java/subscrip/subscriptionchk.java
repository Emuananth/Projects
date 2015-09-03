package subscrip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class subscriptionchk {

	WebDriver r;
	@BeforeTest
	public void login()
	{
		r = new FirefoxDriver();
		r.manage().window().maximize();
		r.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void test() throws InterruptedException
	{
		r.get("http://apps.vedasemantics.com/discovery");
		r.findElement(By.id("userId")).sendKeys("ananth137@123.com");
		r.findElement(By.id("password")).sendKeys("12345");
		r.findElement(By.cssSelector("input.btn-button.width100")).click();
		Thread.sleep(3000);
		r.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/a")).click();
		r.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/ul/li[1]/a")).click();
	}
	@AfterTest
	public void title()
	{
		String p = r.findElement(By.xpath("//*[@id='planTable']/div/div/table/tbody/tr/td[1]")).getText();
		System.out.println("The Content of P is: " +p);
		if(p.equalsIgnoreCase("Basic"))
		{
			try
			{
				//Writing in the Existing xlsx file
				FileInputStream  s = new FileInputStream(new File("D:\\HPDdrive\\Veda - Test cases\\Discovery Release\\Release R2.23.1 status.xlsx"));
				XSSFWorkbook w = new XSSFWorkbook(s);
				XSSFSheet k = w.getSheetAt(0);
				Cell c = null;
				c = k.getRow(3).getCell(5);
				if (c == null)
				{
					c= k.getRow(3).createCell(5);
				}
				c.setCellValue("Account Type is Basic");
				s.close();
				FileOutputStream o = new FileOutputStream(new File("D:\\HPDdrive\\Veda - Test cases\\Discovery Release\\Release R2.23.1 status.xlsx"));
				w.write(o);
				o.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("Testcase Passed");
		}else if(p.equalsIgnoreCase("Advanced"))
		{
			try
			{
				//Writing in the Existing xlsx file
				FileInputStream  s = new FileInputStream(new File("D:\\HPDdrive\\Veda - Test cases\\Discovery Release\\Release R2.23.1 status.xlsx"));
				XSSFWorkbook w = new XSSFWorkbook(s);
				XSSFSheet k = w.getSheetAt(0);
				Cell c = null;
				c = k.getRow(3).getCell(5);
				if (c == null)
				{
					c= k.getRow(3).createCell(5);
				}
				c.setCellValue("Account Type is Advanced");
				s.close();
				FileOutputStream o = new FileOutputStream(new File("D:\\HPDdrive\\Veda - Test cases\\Discovery Release\\Release R2.23.1 status.xlsx"));
				w.write(o);
				o.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("Testcase Passed");
		}else{
		System.out.println("Testcase Failed");
		}
		r.quit();
	}
}
