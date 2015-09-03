package Registration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Register {
	WebDriver d;
	String c,c1;
	@Test
	public void exceltest() throws InterruptedException
	{
		d = new FirefoxDriver();
		d.get("http://apps.vedasemantics.com/discovery");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.findElement(By.xpath("/html/body/div/form/div/div[2]/h3/a/input")).click();
		Thread.sleep(2000);
		String aa = d.findElement(By.id("recaptcha_challenge_image")).getAttribute("src");
		System.out.println("-->"+aa+"<--");
		System.out.println("Hi");
	}
	@AfterTest
	public void close()
	{
		d.quit();
	}
	
}
