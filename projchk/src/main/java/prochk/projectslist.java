package prochk;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class projectslist {

	public logincredentials p = null;
	@BeforeTest
	public void proj()
	{
		p = new logincredentials();
	// calling the method from Login credentials class
		p.inherit();
	// try catch loop given to handle the thread - interrupted exception	
		try
		{
		p.entercredentials();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void getlist() throws InterruptedException
	{
		int count = login.s.findElements(By.xpath("/html/body/div/section/div/div[2]/div/div/div[1]/h4/a[1]")).size();
		System.out.println("No of projects in the login: "+count);
		for (int i =2;i<=count;i++)
		{
			login.s.findElement(By.xpath("/html/body/div/section/div/div[2]/div["+i+"]/div/div[1]/h4/a[1]")).click();
			Thread.sleep(3000);
			//String v = login.s.findElement(By.className("ph")).getText();
			//System.out.println("No of Messages :" +v);
			boolean chart = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[3]/div/div")).isDisplayed();
			System.out.println("Is Volume chart displayed by default:" + chart);
			boolean radio = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[3]/div/div/div[1]/div[3]/label[2]/span")).isSelected();
			System.out.println("Is Volume Radio button selected:" +radio);
			boolean rolling = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[3]/div/div/div[1]/div[3]/label[1]/span")).isSelected();
			System.out.println("Is Rolling Sentiment Radio button selected by default:" + rolling);
			login.s.findElement(By.xpath("/html/body/div[1]/header/nav/div[2]/ul[1]/li[3]/a")).click();
			Thread.sleep(3000);
		}
	}
	@AfterTest
	public void end1()
	{
		login.s.quit();
	}
}
