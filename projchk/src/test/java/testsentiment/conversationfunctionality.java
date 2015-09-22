package testsentiment;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import prochk.login;
import prochk.logincredentials;

public class conversationfunctionality {

	public prochk.logincredentials p = null;
	@BeforeTest
	public void conv()
	{
		p = new prochk.logincredentials();
		p.inherit();
		try
		{
		p.entercredentials();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	@Test
	public void conversationchk() throws InterruptedException
	{
		int count = login.s.findElements(By.xpath("/html/body/div/section/div/div[2]/div/div/div[1]/h4/a[1]")).size();
		for (int i =2;i<=count;i++)
		{
			String v = login.s.findElement(By.xpath("/html/body/div/section/div/div[2]/div["+i+"]/div/div[1]/h4/a[1]")).getText();
			System.out.println("Project Name :" +v);
			login.s.findElement(By.xpath("/html/body/div/section/div/div[2]/div["+i+"]/div/div[1]/h4/a[1]")).click();
			Thread.sleep(3000);
		login.s.findElement(By.xpath("/html/body/div[1]/aside[1]/div/nav/ul/li[3]/a/span")).click();
		Thread.sleep(3000);
		for(int j =2;j<=11;j++)
		{
			System.out.println("J is" +j);
			login.s.findElement(By.id("addConvWidget")).click();
			System.out.println("clicked");
			Thread.sleep(3000);
			try
			{
				System.out.println("inside try");
			boolean msg =login.s.findElement(By.xpath("/html/body/div[12]/div")).isDisplayed(); 
			System.out.println("found alert");
			if(msg == true)
			{
				System.out.println("true");
				System.out.println("Maximum widget limit of 10 is reached");
			} else {
				System.out.println("else");
			}
			}catch(NoSuchElementException e)
			{
				System.out.println("catch");
				//e.printStackTrace();
				System.out.println("Widget no-" + j + " added");
			} catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("add widget completed");
		}
		login.s.findElement(By.xpath("/html/body/div[1]/header/nav/div[2]/ul[1]/li[3]/a")).click();
		Thread.sleep(3000);
		}
	}
	@AfterTest
	public void convclose()
	{
		login.s.quit();
	}
	
}
