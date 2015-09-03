package Sentimentanalysis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sentimentmenuchk {
	WebDriver s;
	@BeforeTest
	public void login()
	{
		s = new FirefoxDriver();
		s.manage().window().maximize();
		s.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void test() throws InterruptedException
	{
		s.get("http://apps.vedasemantics.com/discovery");
		s.findElement(By.id("userId")).sendKeys("ananth128@123.com");
		s.findElement(By.id("password")).sendKeys("12345");
		s.findElement(By.cssSelector("input.btn-button.width100")).click();
		Thread.sleep(3000);
		s.findElement(By.xpath("//*[@id='hideTitle_1']/a[1]")).click();
		s.findElement(By.id("make-small-nav")).click();
		Thread.sleep(3000);
		s.findElement(By.className("vd-ico1")).click();
		if(s.findElement(By.id("timeSeriesChart")).isDisplayed())
		{
			System.out.println("Timeseries Chart is Displayed");
		}else
		{
			System.out.println("No chart is found");
		}
		s.findElement(By.id("projectsTab")).click();
		String h = s.findElement(By.xpath("//*[@id='inactive_NarendraModi_$3']/div[2]/div[1]/span[2]")).getText();
		System.out.println("Total no of Messages displayed in Dashboard:" +h);
		s.findElement(By.xpath("//*[@id='hideTitle_1']/a[1]")).click();
		String k = s.findElement(By.xpath("//*[@id='total_conversation_count']")).getText();
		System.out.println("Total No of Messages: " +k);
		if(!h.equals(k))
		{
			System.out.println("There is difference in No of Messages");
			int we = s.findElements(By.xpath("//*[@id='messagesDiv']/ul/li")).size();
			System.out.println("Total no of messages are:" +we);
			Select as = new Select(s.findElement(By.xpath("//*[@id='displayLimit']")));
			as.selectByValue("50");
			Thread.sleep(3000);
			int we1 = s.findElements(By.xpath("//*[@id='messagesDiv']/ul/li")).size();
			System.out.println("No of messages:" +we1);
			if(we1>=50){
				s.findElement(By.xpath("//*[@id='nextBtn']")).click();
				int we2 = s.findElements(By.xpath("//*[@id='messagesDiv']/ul/li")).size();
				System.out.println("No of messages:" +we2);
			}
		}
		else{
			System.out.println("No Difference found in no of messages");
		}
		//WebElement svg = s.findElement(By.xpath("//*[@id='timeSeriesChart']/svg/g[3]/path[1]"));
		WebElement svg = s.findElement(By.cssSelector("#timeSeriesChart > svg > g:nth-child(3) > path.area"));
		Actions b = new Actions(s);
		b.doubleClick(svg).build().perform();
		Thread.sleep(2000);
		s.findElement(By.xpath("//*[@id='commentOnChart1429615518000']")).sendKeys("Test Comments");
		s.findElement(By.cssSelector("#saveCommentId1429615518000")).click();
		
	}
	@AfterTest
	public void close()
	{
		
		s.close();
	}
}
