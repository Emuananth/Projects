package testsentiment;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import prochk.login;
import prochk.projectslist;


public class sentimentfunctionality {

	public prochk.projectslist l = null;
	@BeforeTest
	public void link()
	{
		l = new prochk.projectslist();
		l.proj();
		try
		{
		l.getlist();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	@Test
	public void sentiment() throws InterruptedException
	{
		int count = login.s.findElements(By.xpath("/html/body/div/section/div/div[2]/div/div/div[1]/h4/a[1]")).size();
		for (int i =2;i<=count;i++)
		{
			String v = login.s.findElement(By.xpath("/html/body/div/section/div/div[2]/div["+i+"]/div/div[1]/h4/a[1]")).getText();
			System.out.println("Project Name :" +v);
			login.s.findElement(By.xpath("/html/body/div/section/div/div[2]/div["+i+"]/div/div[1]/h4/a[1]")).click();
			Thread.sleep(3000);
		boolean refresh = login.s.findElement(By.className("fa-toggle-on")).isEnabled();
		System.out.println("Auto Refresh option is enabled : " +refresh);
		login.s.findElement(By.xpath("/html/body/div[1]/header/nav/div[2]/ul[1]/li[3]/a")).click();
		Thread.sleep(3000);
	}
	}
	@AfterTest
	public void close()
	{
		login.s.quit();
	}
	
}
