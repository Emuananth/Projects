package prochk;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class logincredentials {

	public login l = null;
	@BeforeTest
	public void inherit()
	{
		l = new login();
		l.start();
		}
	@Test
	public void entercredentials() throws InterruptedException
	{
		new logincredentials().inherit();
		login.s.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/form/div[1]/input")).sendKeys("ananth144@123.com");
		login.s.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/form/div[2]/input")).sendKeys("welcome");
		login.s.findElement(By.cssSelector("html.js.flexbox.flexboxlegacy.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.csstransforms3d.csstransitions.fontface.generatedcontent.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body.layout-h div.wrapper div.wrapper.login-block div.block-center.mt-xl.wd-xl div.panel.panel-dark.panel-flat div.panel-body form.mb-lg button.btn.btn-block.btn-primary.mt-lg")).click();
		Thread.sleep(5000);
		String verify = login.s.findElement(By.xpath("/html/body/div/section/div/div[2]/div[2]/div/div[1]/h4/a[1]")).getText();
		if(verify.contentEquals("Narendra Modi"))
		{
			System.out.println("Logged in successfully and 1st project name is "+verify);
		}
		else
		{
			System.out.println("Login unsuccessful");
		}
	}
	/*@AfterTest
	public void end()
	{
		login.s.quit();
	}*/
}
