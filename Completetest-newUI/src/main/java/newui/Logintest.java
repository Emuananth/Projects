package newui;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import newui.Logincheck;
public class Logintest {

public Logincheck e = null;
@BeforeTest
	public void logincall()
	{
	    e = new Logincheck();
	}
	@Test
	public void main()
	{
		new Logintest().logincall();
		Logincheck.f.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/form/div[1]/input")).sendKeys("ananth144@123.com");
		Logincheck.f.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/form/div[2]/input")).sendKeys("welcome");
		Logincheck.f.findElement(By.cssSelector("body > div > div > div > div.panel.panel-dark.panel-flat > div.panel-body > form > button")).click();
		//e.f.findElement(By.xpath("/html/body/div/header/nav/div[2]/ul[2]/li[1]/a")).click();
		//e.f.findElement(By.xpath("/html/body/div/header/nav/div[2]/ul[2]/li[1]/ul/li[2]/div/a[6]/div/div[2]")).click();
	}
	@AfterTest
	public void end()
	{
		Logincheck.f.quit();
	}
}
