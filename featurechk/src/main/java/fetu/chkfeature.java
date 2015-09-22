package fetu;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import prochk.login;
import prochk.projectslist;

public class chkfeature {
	
@Test
public void featureverify() throws InterruptedException
{
	projectslist s = new projectslist();
	try
	{
		s.proj();
		s.getlist();
	
}catch(Exception e)
{
	e.printStackTrace();
	
}	
	List<WebElement> projects = login.s.findElements(By.xpath("/html/body/div/section/div/div[2]/div/div/div[1]/h4/a[1]"));
	Random r = new Random();
	WebElement li = projects.get(r.nextInt(projects.size()));
	String tt = li.getText();
	li.click();
	System.out.println("Project name: " + tt);
	login.s.findElement(By.xpath("/html/body/div[1]/aside[1]/div/nav/ul/li[4]/a/span")).click();
	System.out.println("Feature analysis Loading");
	Thread.sleep(3000);
	WebElement ll = login.s.findElement(By.cssSelector("html.js.flexbox.flexboxlegacy.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.csstransforms3d.csstransitions.fontface.generatedcontent.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body div.wrapper section div.content-wrapper.pb0 div.row div.col-lg-6 div.panel.panel-default div#feature.panel-body.bubble div.slimScrollDiv div#dataSvgDiv svg#dataSvg g g.journal text#category_name.label"));
	ll.click();
	WebElement dd = login.s.findElement(By.cssSelector("html.js.flexbox.flexboxlegacy.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.csstransforms3d.csstransitions.fontface.generatedcontent.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body div.wrapper section div.content-wrapper.pb0 div.row div.col-lg-6 div.panel.panel-default div#feature.panel-body.bubble div.slimScrollDiv div#dataSvgDiv svg#dataSvg"));
	boolean cc = dd.isDisplayed();
	do
	{
	System.out.println("Sub-Categories are displayed");
	Thread.sleep(2000);
	try
	{
	WebElement dd1 = login.s.findElement(By.cssSelector("html.js.flexbox.flexboxlegacy.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.csstransforms3d.csstransitions.fontface.generatedcontent.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body div.wrapper section div.content-wrapper.pb0 div.row div.col-lg-6 div.panel.panel-default div#feature.panel-body.bubble div.slimScrollDiv div#dataSvgDiv svg#dataSvg g g.journal text#category_name.label"));
	dd1.click();
	Thread.sleep(3000);
	String kl = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/div/ul/li/a")).getText();
	System.out.println("Positive Tags : " +kl);
	String kl1 = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/div/ul/li/a")).getText();
	System.out.println("Negative Tags : " +kl1);
	 String mm = login.s.findElement(By.className("sentitags")).getText();
	 String mm1 = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/div/ul/li/span")).getText();
	System.out.println("Sentiment tags displayed are: \n"  + "Positive :" + mm + "\n"+ "Negative :" + mm1);
	}catch(NoSuchElementException e)
	{
		cc = false;
	}
	}while(cc == true);
	System.out.println("No Sub-Categories are displayed or No subcategories available");
	String red = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[3]/div/div/div[1]/div[1]")).getText();
	String green = login.s.findElement(By.xpath("/html/body/div[1]/section/div/div[3]/div/div/div[1]/div[2]")).getText();
	System.out.println("Total positive messages :" + green + "\n" +"Total negative messages :" + red);
	String total = login.s.findElement(By.cssSelector("html.js.flexbox.flexboxlegacy.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.csstransforms3d.csstransitions.fontface.generatedcontent.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body div.wrapper section div.content-wrapper.pb0 div.row div.col-lg-12 div.panel.panel-default div.panel-heading div.panel-title span.count.text-muted")).getText();
	System.out.println("Total messages :" + total);
}
// check for total no of messages available



@AfterTest
public void end()
{
	login.s.quit();
}
}