package functional;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Fullcycle {
	// Initializing the object
	WebDriver r;
	int count,count1;
	int x,y,z;
	String c,c1;
	//Browser setup and login
	@BeforeTest
	public void login()
	{
		//System.setProperty("webdriver.chrome.driver","C://Users//20112//Downloads//chromedriver.exe");
		//r = new ChromeDriver();
		r = new FirefoxDriver();
		r.manage().window().maximize();
		r.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		r.get("http://apps.vedasemantics.com/discovery");
		// going to fetch data from an excel
		try
		{
			FileInputStream f = new FileInputStream(new File("C:\\Users\\20112\\Desktop\\Excel data1.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(f);
			XSSFSheet s = wb.getSheetAt(0);
			y = s.getLastRowNum();
			System.out.println(y);
			for(int w = 1;w<=y;w++)
			{
				XSSFCell cell1 = s.getRow(w).getCell(0);
				XSSFCell cell2 = s.getRow(w).getCell(1);
				x = cell1.getCellType();
				z = cell2.getCellType();
			if (x!= XSSFCell.CELL_TYPE_BLANK && x!= XSSFCell.CELL_TYPE_ERROR)
			{
				if(x == XSSFCell.CELL_TYPE_STRING)
				{
					c = cell1.getStringCellValue();
				} 
				else if(x == XSSFCell.CELL_TYPE_NUMERIC)
				{
					c = String.valueOf(Math.round(cell1.getNumericCellValue()));
				}
			}
				if (z!= XSSFCell.CELL_TYPE_BLANK && z!= XSSFCell.CELL_TYPE_ERROR)
				{
					if(z == XSSFCell.CELL_TYPE_STRING)
					{
						c1 = cell2.getStringCellValue();
					} 
					else if(z == XSSFCell.CELL_TYPE_NUMERIC)
					{
						c1 = String.valueOf(Math.round(cell2.getNumericCellValue()));
					}
				}
				r.findElement(By.id("userId")).sendKeys(c);
				r.findElement(By.id("password")).sendKeys(c1);
				r.findElement(By.cssSelector("input.btn-button.width100")).click();
			
			}}
			
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		
		}

	// checking the functionality
	@Test (priority = 1)
	public void test() throws InterruptedException
	{
		count = r.findElements(By.xpath("/html/body/div[2]/div[2]/ul/li")).size();
		System.out.println("Total No of Projects in the Login:"+count);
		//checking all the Projects
		/*for(int i=1;i<=count;i++)
		{
			String dd = r.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li["+i+"]/h3/span[1]/a[1]")).getText();
			System.out.println("Project Name :" + dd);
			r.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li["+i+"]/h3/span[1]/a[1]")).click();
			boolean alert = r.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/a")).isDisplayed();
			if(!alert == true)
			{
				System.out.println("Alert Icon is not found");
			}else
			{
				System.out.println("Alert Icon is Present");
			}
			int count1 = r.findElements(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li")).size();
			System.out.println(count1);
			r.findElement(By.xpath("//*[@id='sentiment_analysis']/a/span")).click();
			Thread.sleep(1000);
			WebElement sm = r.findElement(By.xpath("//*[@id='sentiment_analysis']/a/span"));
			Actions a = new Actions(r);
			a.moveToElement(sm).build().perform();

			r.findElement(By.xpath("//*[@id='sentiment_analysis']/ul/li[1]/a/span")).click();
			System.out.println("done");
			Thread.sleep(5000);
			boolean t = r.findElement(By.xpath("//*[@id='timeSeriesChart']")).isDisplayed();
			System.out.println("Is Time Series Chart displayed? " + t);
			r.findElement(By.xpath("//*[@id='timeSeriesChart']/div[1]/a[5]")).click();
			boolean t1 = r.findElement(By.xpath("//*[@id='timeSeriesChart']")).isDisplayed();
			System.out.println("Is Time Series Chart - Hour of day displayed? " + t1);
			r.findElement(By.xpath("//*[@id='projectsTab']")).click();
		}
	}
	@Test (priority = 2)
	public void Feature() throws InterruptedException
	{
		for(int k=1;k<=count;k++)
		{
			r.findElement(By.xpath("//*[@id='hideTitle_"+k+"']/a[1]")).click();
			WebElement sm1 = r.findElement(By.xpath("//*[@id='feature_analysis']/a/span"));
			Actions a1 = new Actions(r);
			a1.moveToElement(sm1).build().perform();
			Thread.sleep(2000);
			r.findElement(By.cssSelector("#feature_analysis > ul > li:nth-child(1) > a > span")).click();
			boolean sa = false;
			try
			{
			sa = r.findElement(By.cssSelector("#dataSvg > g > g > circle:nth-child(1)")).isDisplayed();
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			if(!sa == true)
			{
				System.out.println("Bubble chart is empty");
			}else
			{
				System.out.println("Bubble Chart is displayed with bubbles");
			}
			//System.out.println(sa);
			r.findElement(By.xpath("//*[@id='projectsTab']")).click();
	}
	}
	@Test (priority = 3)
	public void share()
	{
		for(int k=1;k<=count;k++)
		{
			r.findElement(By.xpath("//*[@id='hideTitle_"+k+"']/a[1]")).click();
			r.findElement(By.xpath("//*[@id='shareofvoice']/a/span")).click();
			boolean sam = r.findElement(By.cssSelector("#piechart > g > g > g.nv-pieWrap.nvd3-svg > g > g > g.nv-pie > g > path")).isDisplayed();
			int pm = r.findElements(By.xpath("//*[@class='nv-series']")).size();
			System.out.println("Pie chart legend count : " + pm);
			boolean sam1 = r.findElement(By.cssSelector("#piechart > g > g > g.nv-legendWrap.nvd3-svg > g > g > g > circle")).isDisplayed();
			if (sam == false && sam1 == false)
			{
				System.out.println("Share of voice Analysis chart not found");
			}else
			{
				System.out.println("Share of voice chart & legends are displayed");
			}
			boolean kl = r.findElement(By.xpath("//a[contains(text(),'Mark for Deletion')]")).isDisplayed();
			System.out.println(kl);
			if (kl == true)
			{
				System.out.println("Mark for Deletion Link is present");
			}
			else{
				System.out.println("Mark for Deletion is not found");
			}
			r.findElement(By.xpath("//*[@id='projectsTab']")).click();
	}
	}
	@Test(priority = 4)
	public void influencer() throws InterruptedException
	{
		for(int k=1;k<=count;k++)
		{
			
			String title = r.findElement(By.xpath("//*[@id='hideTitle_"+k+"']/a[1]")).getText();
			System.out.println("Project:  " +title);
			r.findElement(By.xpath("//*[@id='hideTitle_"+k+"']/a[1]")).click();
			r.findElement(By.xpath("//*[@id='influencer']/a/span")).click();
			int a = 0;
			int b = 0;
			boolean e = true;
			while(e)
			{
				b= r.findElements(By.xpath("//*[@id='table_div']/table/tbody/tr")).size();
				a = a+b;
				List<WebElement> tt = r.findElements(By.xpath("//*[@id='table_div']/table/tbody/tr/td/a"));
				Random ren = new Random();
				WebElement tk = tt.get(ren.nextInt(tt.size()));
				String ee = tk.getText();
				System.out.println(ee);
				tk.click();
				String gg = r.findElement(By.className("msg-details")).findElement(By.className("author")).getText();
				if (ee.equals(gg))
				{
					System.out.println("Influencer and conversations are matched");
				}else
				{
					System.out.println("Influencer and conversations are different");
				}
				
				Thread.sleep(2000);
				boolean ms = !r.findElement(By.xpath("//*[@id='nextBtn-inf']")).getAttribute("onclick").isEmpty();
				if (ms == true)
				{
					r.findElement(By.xpath("//*[@id='nextBtn-inf']")).click();
					Thread.sleep(5000);
				}else
				{
					break;
				}
			}
			System.out.println("No of Influencers are: " +a);
			r.findElement(By.xpath("//*[@id='projectsTab']")).click();
			
		}
	}
	
	@Test(priority = 5)
	public void location() throws InterruptedException
	{
		for(int k=1;k<=count;k++)
		{
		r.findElement(By.xpath("//*[@id='hideTitle_"+k+"']/a[1]")).click();
		r.findElement(By.xpath("//*[@id='location_analysis']/a/span")).click();
		Thread.sleep(3000);
		boolean la = false,la1 = false;
		try
		{
		
			la = r.findElement(By.cssSelector("html body div.main-container div.dashboard-box.row div.db-left-col ul#dragWidgets.wdg-list li.wdg-content div.wdg-box div#contentTab1 div div div svg g rect")).isDisplayed();
		
		}catch (NoSuchElementException e)
		
		{
			System.out.println("Word Map is not displayed");
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
		
			la1 = r.findElement(By.className("actual-msg")).findElement(By.className("chatbox")).isDisplayed();
		
		}catch (NoSuchElementException e)
		{
			System.out.println("Conversations are displayed");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		if(la == true && la1 == true)
		{
			System.out.println("Word Map & conversations is displayed");
		}
		else if(la == false && la1 == true)
		{
			System.out.println("Word Map is not displayed but conversations are displayed");
		}
		else if(la == true && la1 == false)
		{
			System.out.println("Word Map is displayed but conversations are not displayed");
		}
		else 
		{
			System.out.println("World Map & conversations is not displayed");
		}
		r.findElement(By.xpath("//*[@id='projectsTab']")).click();
		
		}*/
		}
	@Test( priority = 6)
	public void trendanalysis() throws InterruptedException
	{
		for(int k=1;k<=count;k++)
		{
		r.findElement(By.xpath("//*[@id='hideTitle_"+k+"']/a[1]")).click();
		WebElement ta = r.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[7]/a/span"));
		Actions ac = new Actions(r);
		ac.moveToElement(ta).build().perform();
		r.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[7]/ul/li[1]/a/span")).click();
		int cc = r.findElement(By.id("category-tree")).findElements(By.className("jstree-ocl")).size();
		System.out.println(cc);
		WebElement ta1 = r.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[7]/a/span"));
		Actions ac1 = new Actions(r);
		ac1.moveToElement(ta1).build().perform();
		r.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[7]/ul/li[2]/a/span")).click();
		int ms = r.findElement(By.id("word_cloud")).findElements(By.cssSelector("text")).size();
		//int ms = r.findElements(By.xpath("//*[@id='word_cloud']/svg/g/text")).size();
		System.out.println("Total No of Word clouds are: " +ms);
		List<WebElement> tl = r.findElement(By.id("word_cloud")).findElements(By.cssSelector("text"));
		Random rk = new Random();
		WebElement tk1 = tl.get(rk.nextInt(tl.size()));
		String mk = tk1.getText();
		System.out.println("The Word cloud name is:" +mk);
		tk1.click();
		Thread.sleep(3000);
		r.findElement(By.xpath("//*[@id='projectsTab']")).click();
	}
		r.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/a/b")).click();
		Thread.sleep(1000);
		r.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/ul/li[3]/a")).click();
	}
		
	//Function for closing the application
	
	@AfterTest
	public void close()
	{
		r.quit();
	}
}