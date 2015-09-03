package dataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovidertest {
	WebDriver d;
	@DataProvider(name = "Authentication")
	public static Object[][] credentials(){
		return new Object[][] {{"ananth128@123.com","12345"},{"ananth127@123.com","12345"}};
	}
	
	@Test(dataProvider = "Authentication")
	public void test(String UN, String PS) throws InterruptedException{
		d = new FirefoxDriver();
		d.get("http://apps.vedasemantics.com/discovery");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.findElement(By.id("userId")).sendKeys(UN);
		d.findElement(By.id("password")).sendKeys(PS);
		d.findElement(By.cssSelector("input.btn-button.width100")).click();
		d.findElement(By.className("dropdown-toggle")).click();
		Thread.sleep(2000);
		d.findElement(By.cssSelector("html body div.header div.header-content div.header-right div.top-link div.dropdown-group.dropdown-right.open div.dropdown-menu.br-radius ul li a")).click();
		d.quit();
	}
}
