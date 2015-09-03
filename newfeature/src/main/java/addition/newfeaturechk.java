package addition;

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

public class newfeaturechk {
	WebDriver g;
	// login to the application
	@BeforeTest
	public void start(){
		g = new FirefoxDriver();
		g.get("http://apps.vedasemantics.com/discovery");
		g.manage().window().maximize();
		g.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		g.findElement(By.id("userId")).sendKeys("ananth137@123.com");
		g.findElement(By.id("password")).sendKeys("12345");
		g.findElement(By.cssSelector("input.btn-button.width100")).click();
	}
	//Performing the new feature check
	@Test
	public void testbegin()
	{
		int ty = g.findElements(By.xpath("/html/body/div[2]/div[2]/ul/li")).size();
		System.out.println("Total No of Projects in the login :" + ty);
		for(int i=1;i<=ty;i++)
		{
			g.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li["+i+"]/h3/span[1]/a[1]")).click();
			String va = g.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[3]/a/span")).getText();
		System.out.println(va);
		if(va =="Share Of Voice Analysis")
		{
			System.out.println("Share Of Voice Analysis is displayed");
		}
		g.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/ul/li[2]/a")).click();
		if(!(va == "Share Of Voice Analysis"))
		{
			
		// writing the result in the Excel
	try
	{
	FileInputStream file = new FileInputStream(new File("D:\\HPDdrive\\Veda - Test cases\\Discovery Release\\Release R2.23.1 status.xlsx"));
	XSSFWorkbook b = new XSSFWorkbook(file);
	XSSFSheet s = b.getSheetAt(0);
	Cell c = null;
	
	// updating the value of cell
	c = s.getRow(2).getCell(4);
	if (c == null)
	{
		c = s.getRow(2).createCell(4);
		}
	c.setCellValue("Passed");
	file.close();
	FileOutputStream f1 = new FileOutputStream("D:\\HPDdrive\\Veda - Test cases\\Discovery Release\\Release R2.23.1 status.xlsx");
	b.write(f1);
	f1.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		}
		else
		{
			try
			{
			FileInputStream file = new FileInputStream(new File("D:\\HPDdrive\\Veda - Test cases\\Discovery Release\\Release R2.23.1 status.xlsx"));
			XSSFWorkbook b = new XSSFWorkbook(file);
			XSSFSheet s = b.getSheetAt(0);
			Cell c = null;
			
			// updating the value of cell
			c = s.getRow(5).getCell(4);
			if (c == null)
			{
				c = s.getRow(5).createCell(4);
				}
			c.setCellValue("Failed");
			file.close();
			FileOutputStream f1 = new FileOutputStream("D:\\HPDdrive\\Veda - Test cases\\Discovery Release\\Release R2.23.1 status.xlsx");
			b.write(f1);
			f1.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		}
	}
		//Close the page operation
		@AfterTest
		public void close()
		{
			g.quit();
		}
	}


