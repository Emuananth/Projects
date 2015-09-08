package prochk;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
			String v = login.s.findElement(By.xpath("/html/body/div/section/div/div[2]/div["+i+"]/div/div[1]/h4/a[1]")).getText();
			System.out.println("Project Name :" +v);
			login.s.findElement(By.xpath("/html/body/div/section/div/div[2]/div["+i+"]/div/div[1]/h4/a[1]")).click();
			Thread.sleep(3000);
			//String v = login.s.findElement(By.className("ph")).getText();
			boolean chart = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[3]/div/div")).isDisplayed();
			System.out.println("Is Volume chart displayed by default:" + chart);
			boolean radio = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[3]/div/div/div[1]/div[3]/label[2]/span")).isSelected();
			System.out.println("Is Volume Radio button selected:" +radio);
			boolean rolling = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[3]/div/div/div[1]/div[3]/label[1]/span")).isSelected();
			System.out.println("Is Rolling Sentiment Radio button selected by default:" + rolling);
			WebElement h = login.s.findElement(By.cssSelector("html.js.flexbox.flexboxlegacy.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.csstransforms3d.csstransitions.fontface.generatedcontent.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body div.wrapper section div.content-wrapper.pb0 div.row div.col-lg-8 div.panel.panel-default div#sunburst.panel-body.sunburst div.chart.row svg")); 
			boolean deep = h.isDisplayed();
			//boolean cdd = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[4]/div[1]/div/div[2]/div[2]/svg")).isDisplayed();
			System.out.println("Is CDD displayed:" +deep);
			// check for drop down check boxes selected under CDD
			login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[4]/div[1]/div/div[2]/div[1]/div[2]/div/button")).click();
			Thread.sleep(3000);
			boolean cdd1 = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[4]/div[1]/div/div[2]/div[1]/div[2]/div/ul/li[3]/a/input")).isSelected();
			boolean cdd2 = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[4]/div[1]/div/div[2]/div[1]/div[2]/div/ul/li[4]/a/input")).isSelected();
			boolean cdd3 = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[4]/div[1]/div/div[2]/div[1]/div[2]/div/ul/li[5]/a/input")).isSelected();
			System.out.println("Is Sentiment checkbox selected by default? = " + cdd1 + "\n" + "Is Source checkbox selected by default? = " + cdd2 + "\n" + "Is Gender checkbox selected by default? = " + cdd3);
			boolean meters = login.s.findElement(By.id("positive")).isDisplayed();
			boolean meters1 = login.s.findElement(By.id("negative")).isDisplayed();
			if(meters == true && meters1 == true)
			{
			System.out.println( "+VE Sentiment meters & -VE Sentiment meters are displayed");
			}
			else if(meters == true && meters1 == false)
			{
				System.out.println("+VE Sentiment meters is displayed but -VE Sentiment meters not displayed");
			}else if (meters == true && meters1 == false)
			{
				System.out.println("+VE Sentiment meters not displayed but -VE Sentiment meters is displayed");
			}else if(meters == false && meters1 == false)
			{
				System.out.println("Both the Sentiment meters were not displayed");
			}
			
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
