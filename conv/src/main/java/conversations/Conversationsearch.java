package conversations;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Conversationsearch {

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
		b.findElement(By.id("userId")).sendKeys("ananth126@123.com");
		b.findElement(By.id("password")).sendKeys("12345");
		b.findElement(By.cssSelector("input.btn-button.width100")).click();
	}
		@Test(priority = 1)
		public void t2() throws InterruptedException{
		b.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li[3]/h3/span[1]/a[1]")).click();
		b.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[4]/a/span")).click();
		String h = b.findElement(By.xpath("/html/body/div[2]/div/div[4]/ul/li[1]/div[2]/div/div/div[1]/table/tbody/tr[2]/td[1]/a")).getText();
		b.findElement(By.xpath("/html/body/div[2]/div/div[5]/div/div[1]/div/div/a")).click();
		Thread.sleep(3000);
		b.findElement(By.xpath("/html/body/div[2]/div/div[5]/div/div[1]/div/div/div/div[2]/div[6]/div[2]/input")).sendKeys(h);
		b.findElement(By.cssSelector("html body div.main-container div.dashboard-box.row div.db-right-col div.message-box div.msg-filter input.btn-button")).click();
		String d = b.findElement(By.xpath("/html/body/div[2]/div/div[5]/div/div[2]/div[1]/div/ul/li/div/div[3]/span[1]")).getText();
		if(d.equals(h)){
			System.out.println("Author name Matches");
			}else{
				System.out.println("Author name mismatch");
			}
		}
		@AfterTest
		public void signout()
		{
			b.quit();
		}
}
