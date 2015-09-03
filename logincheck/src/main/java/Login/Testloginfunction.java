package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testloginfunction {

	WebDriver d;
	@BeforeTest
	public void login()
	{
		d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
		@Test
		public void testlogin() throws InterruptedException
		{
		d.get("http://apps.vedasemantics.com/discovery");
		d.findElement(By.id("userId")).sendKeys("ananth128@123.com");
		d.findElement(By.id("password")).sendKeys("12345");
		d.findElement(By.cssSelector("input.btn-button.width100")).click();
		Thread.sleep(3000);
		d.findElement(By.className("dropdown-toggle")).click();
		d.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/ul/li[3]/a")).click();
	}
	@AfterTest
	public void close() throws InterruptedException
	{
		Thread.sleep(5000);
		if(d.findElement(By.xpath("//*[@id='loginform']/div/div[2]/h3/a/input")).isDisplayed())
		{
			System.out.println("Test Case is Passed");
		}else{
			System.out.println("Test Case is Failed");
		}
		d.quit();
	}
}
