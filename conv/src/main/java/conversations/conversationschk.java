package conversations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class conversationschk {
	WebDriver z;
	@BeforeTest
	public void start(){
		z = new FirefoxDriver();
		z.manage().window().maximize();
		z.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 1)
	public void teststart(){
		z.get("http://apps.vedasemantics.com/discovery");
		z.findElement(By.id("userId")).sendKeys("ananth126@123.com");
		z.findElement(By.id("password")).sendKeys("12345");
		z.findElement(By.cssSelector("input.btn-button.width100")).click();
	}
	@Test (priority = 2)
	public void test() throws InterruptedException{
		z.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li[1]/h3/span[1]/a[1]")).click();
		WebElement l = z.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[6]/a/span"));
		Actions a = new Actions(z);
		a.moveToElement(l).build().perform();
		z.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[6]/ul/li[2]/a/span")).click();
		Select s = new Select(z.findElement(By.xpath("/html/body/div[2]/div/div[3]/ul/li[2]/div/div[1]/select")));
		s.selectByVisibleText("Sentiments");
		try{
		boolean m = z.findElement(By.cssSelector("html body div.main-container div.dashboard-box.row div.db-left-col ul#dragWidgets.wdg-list li#wordcloud.wdg-content.active div.wdg-box div#word_cloud svg g text")).isDisplayed();
		
		if(m == true){
			System.out.println("Sentiment Keywords are displayed");
			z.findElement(By.cssSelector("html body div.main-container div.dashboard-box.row div.db-left-col ul#dragWidgets.wdg-list li#wordcloud.wdg-content.active div.wdg-box div#word_cloud svg g text")).click();
			boolean h = z.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div[2]/div[1]/div/ul/li/div[1]/div[3]")).isDisplayed();
			if(h == true){
				System.out.println("Conversation is displayed");
			z.findElement(By.cssSelector("html body div.main-container div.dashboard-box.row div.db-right-col div#conversationsDiv.message-box div.slimScrollDiv div.tblmessage.b-radius div#messagesDiv ul li div#message_div_552e45fbe32a6963cbf67384 div.actual-msg a#readmore.readmore")).click();
			z.findElement(By.className("fancybox-outer")).click();
			//z.findElement(By.cssSelector("html body.fancybox-lock div.fancybox-overlay.fancybox-overlay-fixed div.fancybox-wrap.fancybox-desktop.fancybox-type-inline.fancybox-opened div.fancybox-skin div.fancybox-outer div.fancybox-inner div#showDiv1_1429767801000.showReadMoreDiv div.inner-content p")).click();
			JavascriptExecutor j = (JavascriptExecutor)z;
			j.executeScript("window.scrollBy(0,450)", "");
			Thread.sleep(5000);
			z.findElement(By.cssSelector("html body.fancybox-lock div.fancybox-overlay.fancybox-overlay-fixed div.fancybox-wrap.fancybox-desktop.fancybox-type-inline.fancybox-opened div.fancybox-skin a.fancybox-item.fancybox-close")).click();
			}else{
					System.out.println("No conversations were displayed");
			}
			}else{
			System.out.println("No sentiment words displayed in word cloud");
		}}catch(Exception e){
			e.printStackTrace();
		}
	}
	@AfterTest
	public void close(){
		z.quit();
	}
}
