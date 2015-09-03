package newui;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Completetest {
	
	// INitializing objects
	WebDriver wd;
	
	// Login with credentials
	@BeforeTest
	public void login(){
		
		wd = new FirefoxDriver();
		wd.get("http://apps.vedasemantics.com/discoverybeta");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		                // Login credentials
		wd.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/form/div[1]/input")).sendKeys("ananth144@123.com");
		wd.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/form/div[2]/input")).sendKeys("welcome");
		wd.findElement(By.cssSelector("body > div > div > div > div.panel.panel-dark.panel-flat > div.panel-body > form > button")).click();
	}
	@Test
	public void mainloop() throws InterruptedException
	{
		boolean ab = wd.findElement(By.xpath("/html/body/div/section/div/div[1]/div[1]/div")).isDisplayed();
		System.out.println("Messages count is displayed:" +ab);
		Thread.sleep(5000);
		 int c = wd.findElements(By.xpath("/html/body/div/section/div/div[2]/div")).size();
		System.out.println("Total Number of Projects in the Login :" + c);
		Thread.sleep(3000);
		for (int i = 2;i<=c;i++)
		{
		List <WebElement> v = wd.findElements(By.xpath("/html/body/div/section/div/div[2]/div/div/div[1]/h4/a[1]"));
		Random rm = new Random();
		WebElement v1 = v.get(rm.nextInt(v.size()));
		String m = v1.getText(); 
		System.out.println("Name of the Project selected :" + m);
		v1.click();
		int d = wd.findElements(By.xpath("/html/body/div[1]/aside[1]/div/nav/ul/li/a/span")).size();
		System.out.println("Total Links in the project:" + d);
		Thread.sleep(2000);
		for(int j=2;j<=d;j++)
		{
			List<WebElement> tt = wd.findElements(By.xpath("/html/body/div[1]/aside[1]/div/nav/ul/li/a/span"));
			Random rd = new Random();
			WebElement v2 = tt.get(rd.nextInt(tt.size()));
			String m1 = v2.getText();
			System.out.println(m1 + " is present and clickable");
			v2.click();
			Thread.sleep(3000);
		}
		
		wd.findElement(By.linkText("Projects")).click();
		
		}
	}
	@AfterTest
	public void end()
	{
		wd.quit();
	}

}
