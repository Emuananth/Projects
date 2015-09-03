package response;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RAtest {
	WebDriver j;
	@BeforeTest
	public void initialsetup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Documents and Settings\\20112\\Desktop\\Statment\\chromedriver\\chromedriver.exe");
		j = new ChromeDriver();
		j.manage().window().maximize();
		j.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	@Test (priority = 0)
	public void logintest(){
		j.get("http://apps.vedasemantics.com/discovery");
		j.findElement(By.id("userId")).sendKeys("ananth131@123.com");
		j.findElement(By.id("password")).sendKeys("12345");
		j.findElement(By.cssSelector("input.btn-button.width100")).click();	}
	@Test (priority = 1)
	public void responsedb(){
		try{
			int ty = j.findElements(By.xpath("/html/body/div[2]/div[2]/ul/li")).size();
			System.out.println(ty);
		for(int i=1;i<=ty;i++){
			String kl = j.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li["+i+"]/h3/span[1]/a[1]")).getText();
			System.out.println("Project Name :" +kl);
		j.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li["+i+"]/h3/span[1]/a[1]")).click();
		j.findElement(By.linkText("Response Analysis")).click();
		boolean pl = j.findElement(By.className("tblmessage")).isDisplayed();
		boolean pl1 = j.findElement(By.xpath("/html/body/div[2]/div/div[5]/div/div[2]/div[1]/div/ul/li[1]")).isDisplayed();
		int ms = j.findElements(By.xpath("/html/body/div[2]/div/div[5]/div/div[2]/div[1]/div/ul/li")).size();
		int ms2=0; boolean mas = false;
		do{
			mas = j.findElement(By.id("nextBtn")).isEnabled();
			System.out.println(mas);
			if(mas == true){
			j.findElement(By.id("nextBtn")).click();
			int ms1 = j.findElements(By.xpath("/html/body/div[2]/div/div[5]/div/div[2]/div[1]/div/ul/li")).size();
			ms2 = ms+ms1;
			ms =ms2;
			}else{
				mas = false;
			}
		}while(mas == true);
		System.out.println("Total no of messages: " +ms2);
		if(pl == true && pl1 == true){
			System.out.println("Response table & conversations are displayed");
		}else if (pl== false && pl1 == true){
			System.out.println("No Response table found but conversations are displayed");
		}else if (pl == true && pl1 == false){
			System.out.println("Response table is displayed but no conversations found");
		}else{
			System.out.println("No Response table & conversations were displayed");
		}
		j.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/ul/li[1]/a")).click();
		}
}catch(Exception e){
	e.printStackTrace();}
}
	@AfterTest
	public void close(){
	j.quit();	
	}
}
