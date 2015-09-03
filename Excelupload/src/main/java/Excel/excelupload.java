package Excel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class excelupload {

	WebDriver ys;
	@BeforeTest
	public void start(){
		ys = new FirefoxDriver();
		ys.manage().window().maximize();
		ys.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 0)
	public void uploadstart(){
		ys.get("http://apps.vedasemantics.com/discovery");
		ys.findElement(By.id("userId")).sendKeys("ananth128@123.com");
		ys.findElement(By.id("password")).sendKeys("12345");
		ys.findElement(By.cssSelector("input.btn-button.width100")).click();
		}
	@Test (priority = 1)
	public void project(){
		int k = ys.findElements(By.xpath("/html/body/div[2]/div[2]/ul/li")).size();
		System.out.println(k);
		for(int i =1;i<=k;i++){
			ys.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li["+i+"]/div[4]/a[5]/span")).click();
			Select se = new Select(ys.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[4]/div[1]/div/div[1]/form/div[2]/select[1]")));
			se.selectByVisibleText("Messages");
			ys.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[4]/div[1]/div/div[1]/form/div[2]/span[3]/div/input")).sendKeys("D:\\HPDdrive\\Veda - Test cases\\Discovery upload data\\200 messages.xlsx");
			ys.findElement(By.cssSelector("html body div.main-container div.manage-project div.ptab-left div.tab-panes.br-radius div#pcontentDiv5.tab-content div.tab-box div.upload-box.p-relative div.process-action form#fileUploadForm div.action-box input#fileUploadSubmit.btn-button")).click();
			Alert as = ys.switchTo().alert();
			as.accept();
			Select ss = new Select(ys.findElement(By.id("popbox-content")).findElement(By.xpath("/html/body/div[8]/div/div[9]/div/div/div/form/table/tbody/tr[1]/td[2]/select")));
			ss.selectByVisibleText("Date(date)");
			Select ss1 = new Select(ys.findElement(By.id("popbox-content")).findElement(By.xpath("/html/body/div[8]/div/div[9]/div/div/div/form/table/tbody/tr[2]/td[2]/select")));
			ss1.selectByVisibleText("Author(text)");
			Select ss2 = new Select(ys.findElement(By.id("popbox-content")).findElement(By.xpath("/html/body/div[8]/div/div[9]/div/div/div/form/table/tbody/tr[3]/td[2]/select")));
			ss2.selectByVisibleText("Messages(text)");
			Select ss3 = new Select(ys.findElement(By.id("popbox-content")).findElement(By.xpath("/html/body/div[8]/div/div[9]/div/div/div/form/table/tbody/tr[4]/td[2]/select")));
			ss3.selectByVisibleText("Date(date)");
		}}
		@AfterTest
		public void uploadend(){
			
		ys.quit();
		
}}
