package Sentimentanalysis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class cddchartchk {
	WebDriver b;
	@BeforeTest
	public void BT()
	{
		b= new FirefoxDriver();
		b.get("http://apps.vedasemantics.com/discovery");
		b.manage().window().maximize();
		b.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	}
	@Test(priority = 0)
	public void signin()
	{
		b.findElement(By.id("userId")).sendKeys("ananth128@123.com");
		b.findElement(By.id("password")).sendKeys("12345");
		b.findElement(By.cssSelector("input.btn-button.width100")).click();
	}
		@Test(priority = 1)
		public void t2() throws InterruptedException{
		b.findElement(By.xpath("//*[@id='hideTitle_1']/a[1]")).click();
		WebElement sg1 = b.findElement(By.xpath("//*[@id='sentiment_analysis']/a/span"));
		Actions d1 = new Actions(b);
		d1.moveToElement(sg1).build().perform();
		b.findElement(By.cssSelector("#sentiment_analysis > ul > li:nth-child(2) > a > span")).click();
		b.findElement(By.cssSelector("#container > path:nth-child(38)")).click();
		/*WebElement sg = b.findElement(By.cssSelector("#container > path:nth-child(38)"));
		Actions d = new Actions(b);
		d.doubleClick(sg).build().perform();
		System.out.println("Alert");*/
		JavascriptExecutor js = (JavascriptExecutor)b;
		js.executeScript("window.scrollBy(0,450)", "");
		
		b.findElement(By.xpath("//*[@id='commentOnChart1429681539000']")).sendKeys("Test comments");
		b.findElement(By.cssSelector("#saveCommentId1429676004000")).click();
	}
		@AfterTest
		public void close()
		{
			b.quit();
		}
}

