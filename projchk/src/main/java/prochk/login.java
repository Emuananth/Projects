package prochk;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class login {
	
public static WebDriver s;
public void start()
{
	if(s == null)
	{
	s = new FirefoxDriver();
	s.get("http://apps.vedasemantics.com/discoverybeta");
	s.manage().window().maximize();
	s.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	s.getTitle();
}
}
}
