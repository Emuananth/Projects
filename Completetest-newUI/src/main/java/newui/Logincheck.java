package newui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;


public class Logincheck {

public static WebDriver f;
	public Logincheck()
	{
		if(f == null) {
			f = new FirefoxDriver();
			f.get("http://apps.vedasemantics.com/discoverybeta");
			f.manage().window().maximize();
			f.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);			
		}
				
	}
	
}
