package competitordashboards;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class competitordbs {
	WebDriver ty;
	@BeforeTest
	public void start(){
		ty = new FirefoxDriver();
		ty.manage().window().maximize();
		ty.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 0)
	public void teststart(){
		ty.get("http://apps.vedasemantics.com/discovery");
		ty.findElement(By.id("userId")).sendKeys("ananth128@123.com");
		ty.findElement(By.id("password")).sendKeys("12345");
		ty.findElement(By.cssSelector("input.btn-button.width100")).click();
		}
	@Test (priority = 1)
	public void test() throws InterruptedException
	{
		Thread.sleep(3000);
		String e = ty.findElement(By.xpath("/html/body/div[2]/div[2]")).getText();
		System.out.println("Notification:" +e);
		String r;
	if(e.contains("Subscription Expired")){
		r="3";
	} else{
		r="2";
	}
		int sm = ty.findElements(By.xpath("/html/body/div[2]/div["+r+"]/ul/li")).size();
		System.out.println("Total No of Projects in the Login :" +sm);
		for(int i=1;i<=sm;i++)
		{
		 ty.findElement(By.xpath("/html/body/div[2]/div["+r+"]/ul/li["+i+"]/h3/span[1]/a[1]")).click();
		 int d;
		 d= ty.findElements(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li")).size();
		System.out.println("No of Analysis Menu available: "+d);
		//Sentiment Analysis DashBoard check
		WebElement ms = ty.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[2]/a/span"));
		Actions a = new Actions(ty);
		a.moveToElement(ms).build().perform();
		ty.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[2]/ul/li[1]/a/span")).click();
		boolean pm = ty.findElement(By.id("timeSeriesChart")).isDisplayed();
		boolean pm1 = ty.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div[2]/div[1]/div/ul/li")).isDisplayed();
		if(pm == true && pm1==true){
			System.out.println("Time Series Chart & Conversations are displayed");
		}else if(pm == true && pm1 == false){
			System.out.println("Time Series Chart alone displayed");
			}else if(pm == false && pm1 == true){
				System.out.println("Conversations are alone displayed");
			}else {System.out.println("No Chart & Conversations were displayed");}
		WebElement ms1 = ty.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[2]/a/span"));
		//Actions a1 = new Actions(ty);
		a.moveToElement(ms1).build().perform();
		ty.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[2]/ul/li[2]/a/span")).click();
		boolean pm2 = ty.findElement(By.id("sunburstChart")).isDisplayed();
		boolean pm3 = ty.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div[2]/div[1]/div/ul/li")).isDisplayed();
		if(pm2 == true && pm3==true){
			System.out.println("Sunburst Chart & Conversations are displayed");
		}else if(pm2 == true && pm3 == false){
			System.out.println("Sunburst Chart alone displayed");
			}else if(pm2 == false && pm3 == true){
				System.out.println("Conversations are alone displayed");
			}else {System.out.println("No Chart & Conversations were displayed");}
		// Feature Analysis DashBoard test
		
		WebElement ms2 = ty.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[3]/a/span"));
		//Actions a2 = new Actions(ty);
		a.moveToElement(ms2).build().perform();
		ty.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[3]/ul/li[1]/a/span")).click();
		boolean pm4 = ty.findElement(By.cssSelector("html body div.main-container div.dashboard-box.row div.db-left-col ul#dragWidgets.wdg-list li#bubble.wdg-content.active.closest-class div.wdg-box div.tab-box svg")).isDisplayed();
		boolean pm5 = ty.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div[2]/div[1]/div/ul/li")).isDisplayed();
		if(pm4 == true && pm5==true){
			System.out.println("Feature Analysis Chart & Conversations are displayed");
		}else if(pm4 == true && pm5 == false){
			System.out.println("Feature Analysis Chart alone displayed");
			}else if(pm4 == false && pm5 == true){
				System.out.println("Conversations are alone displayed");
			}else {System.out.println("No Chart & Conversations were displayed");}
		// Sentiment Tags testing
		WebElement ms3 = ty.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[3]/a/span"));
		a.moveToElement(ms3).build().perform();
		ty.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[3]/ul/li[2]/a/span")).click();
		boolean pm6 = ty.findElement(By.id("positive-tags")).isDisplayed();
		boolean pm7 = ty.findElement(By.id("negative-tags")).isDisplayed();
		boolean pm8 = ty.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div[2]/div[1]/div/ul/li")).isDisplayed();
		if(pm6 == true && pm7 == true && pm8==true){
			System.out.println("Sentiment Tags & Conversations are displayed");
		}else if(pm6 == true && pm7 == true && pm8 == false){
			System.out.println("Sentiment Tags alone displayed");
			}else if(pm6 == true && pm7 == true && pm8 == true){
				System.out.println("Conversations are alone displayed");
			}else {System.out.println("No Sentiment Tags & Conversations were displayed");}

		ty.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/ul/li[1]/a")).click();
		 Thread.sleep(5000);
		}}
		@Test(priority = 2)
		public void writeexcel()
		{
		try{
			FileInputStream fsip = new FileInputStream(new File("D:\\HPDdrive\\Veda - Test cases\\Disc TC\\Updated Discovery_TC (Autosaved).xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fsip);
			HSSFSheet worksheet = wb.getSheetAt(3);
			Cell cell = null;
			worksheet.getRow(9).createCell(8);
			cell = worksheet.getRow(9).getCell(8);
			System.out.println(cell);
			cell.setCellValue("Testcase Passed");
			fsip.close();
			FileOutputStream output_file = new FileOutputStream(new File("D:\\HPDdrive\\Veda - Test cases\\Disc TC\\Updated Discovery_TC (Autosaved).xls"));
			wb.write(output_file);
			output_file.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		}
	//System.out.println(l1);
		/*ty.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li[1]/h3/span[1]/a[1]")).click();
		WebElement l = ty.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[2]/a/span"));
		Actions a = new Actions(ty);
		a.moveToElement(l).build().perform();
		ty.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[2]/ul/li[2]/a/span")).click();
		ty.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/a")).click();
*/

	@AfterTest
	public void close(){
		ty.quit();
	}
	}

