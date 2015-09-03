package addproj;
import newui.Logincheck;
import newui.Logintest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class addproject {

	Logintest r = new Logintest();
	@BeforeTest
	public void addpro() throws InterruptedException
	{
		/* Calling the Method which has login credentials*/
		//r.logincall();
		r.main();
	}
	@Test
	public void addproj() throws InterruptedException
	{
		/* Check for Add project - Stream*/
		//new addproject().addpro();
		Logincheck.f.findElement(By.xpath("/html/body/div/section/div/div[1]/div[2]/button")).click();
		Logincheck.f.findElement(By.id("project_title")).sendKeys("Test");
		Logincheck.f.findElement(By.id("brand_name")).sendKeys("test1");
		Logincheck.f.findElement(By.id("brand_synonym")).sendKeys("simple");
		Select s = new Select(Logincheck.f.findElement(By.id("domain_list")));
		s.selectByVisibleText("Cameras");
		Select s1 = new Select(Logincheck.f.findElement(By.id("ontology_list")));
		s1.selectByVisibleText("CamerasCategoriesV0");
		Logincheck.f.findElement(By.id("add_project")).click();
		int a = Logincheck.f.findElements(By.xpath("/html/body/div[1]/section/div/div/div/div/div/div[1]/ul/li/a")).size();
		System.out.println(" Total No of data pulling options: " + a);
		for(int i=2; i<=a;i++)
		{
			Logincheck.f.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div/div[1]/ul/li["+i+"]/a")).click();
		Thread.sleep(3000);
			boolean w = Logincheck.f.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div/div[2]/section[2]/div/div/div[1]/div/div[1]/div[1]/span[2]")).isDisplayed();
		//System.out.println(w);
		if(w==true)
		{
			System.out.println("Setup Data Query is displayed");
		}else
		{
			System.out.println("Setup Data Query not found");
		}
		}
		Logincheck.f.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div/div[1]/ul/li[2]/a")).click();
		Logincheck.f.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div/div[2]/section[2]/div/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div[3]/a[1]")).click();
		Logincheck.f.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div/div[2]/section[2]/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/div[2]/div/div/div/a[1]")).click();
		Thread.sleep(2000);
		Logincheck.f.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div/div[2]/section[2]/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/div[3]/div/div[1]/div/div[2]/div/input")).sendKeys("sachin tendulkar, narendra modi");
		Logincheck.f.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div/div[2]/section[2]/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div[3]/a[1]")).click();
		Thread.sleep(2000);
		Logincheck.f.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div/div[2]/section[2]/div/div/div[1]/div/div[1]/div[2]/div/div/div[3]/div/a")).click();
		Logincheck.f.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div/div[2]/section[2]/div/div/div[1]/div/div[1]/div[5]/div/button")).click();
		Thread.sleep(5000);
		//Logincheck.f.switchTo().alert();
		Logincheck.f.findElement(By.id("startStreamModalAdv")).findElement(By.id("startStreamOkBtn")).click();
		Thread.sleep(2000);
		System.out.println("Data stream is started");
		Logincheck.f.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div/div[2]/section[2]/div/div/div[1]/div/div[1]/div[5]/div/button")).click();
		Logincheck.f.findElement(By.id("stopStreamModalAdv")).findElement(By.id("stopStreamOkBtn")).click();
		System.out.println("Data stream stopped");
	}
	@AfterTest
	public void end()
	{
		Logincheck.f.quit();
	}
}
