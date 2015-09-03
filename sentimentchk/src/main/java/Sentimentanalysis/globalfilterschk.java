package Sentimentanalysis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class globalfilterschk {
	WebDriver r;
	@BeforeTest
	public void start(){
		r = new FirefoxDriver();
		r.manage().window().maximize();
		r.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 0)
	public void teststart(){
		r.get("http://apps.vedasemantics.com/discovery");
		r.findElement(By.id("userId")).sendKeys("ananth126@123.com");
		r.findElement(By.id("password")).sendKeys("12345");
		r.findElement(By.cssSelector("input.btn-button.width100")).click();
	}
	@Test (priority = 1)
	public void test() throws InterruptedException{
		r.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li[1]/h3/span[1]/a[1]")).click();
		WebElement l = r.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[2]/a/span"));
		Actions a = new Actions(r);
		a.moveToElement(l).build().perform();
		r.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul[2]/li[2]/ul/li[2]/a/span")).click();
		r.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/a")).click();
		r.findElement(By.cssSelector("html body div.header div.header-content div.header-right div.gfilter-section div.span-line.search-box div.dropdown-group.dropdown-right.open div.dropdown-menu.advance-box.br-radius.advanced-menu-width-fix div.drop-content.br-radius div.date-control input#date_start.textbox.hasDatepicker")).click();
		r.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[1]/td[7]/a")).click();
		r.findElement(By.cssSelector("html body div.header div.header-content div.header-right div.gfilter-section div.span-line.search-box div.dropdown-group.dropdown-right.open div.dropdown-menu.advance-box.br-radius.advanced-menu-width-fix div.drop-content.br-radius div.date-control input#date_end.textbox.hasDatepicker")).click();
		r.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[5]/td[5]/a")).click();
		r.findElement(By.cssSelector("html body div.header div.header-content div.header-right div.gfilter-section div.span-line.search-box div.dropdown-group.dropdown-right.open div.dropdown-menu.advance-box.br-radius.advanced-menu-width-fix div.drop-content.br-radius div.side-tab div.slimScrollDiv ul#filterTab.nav-tab li a#gender.ft-link")).click();
	try{
		boolean k = r.findElement(By.cssSelector("html body div.header div.header-content div.header-right div.gfilter-section div.span-line.search-box div.dropdown-group.dropdown-right.open div.dropdown-menu.advance-box.br-radius.advanced-menu-width-fix div.drop-content.br-radius div.filter-panel div.slimScrollDiv div#filter-panel div#gender.ft-wp.content-0 ul li input")).isDisplayed();
		if(k == true){
			r.findElement(By.cssSelector("html body div.header div.header-content div.header-right div.gfilter-section div.span-line.search-box div.dropdown-group.dropdown-right.open div.dropdown-menu.advance-box.br-radius.advanced-menu-width-fix div.drop-content.br-radius div.filter-panel div.slimScrollDiv div#filter-panel div#gender.ft-wp.content-0 ul li input")).click();
		}else{
			System.out.println("No filters available under" +r.findElement(By.cssSelector("html body div.header div.header-content div.header-right div.gfilter-section div.span-line.search-box div.dropdown-group.dropdown-right.open div.dropdown-menu.advance-box.br-radius.advanced-menu-width-fix div.drop-content.br-radius div.side-tab div.slimScrollDiv ul#filterTab.nav-tab li a#gender.ft-link")).getText());
		}}catch(Exception e){
			e.printStackTrace();
		}try{
		r.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div/div[2]/div[4]/div/ul/li[2]/a")).click();
		boolean f = r.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div/div[2]/div[5]/div/div[1]/div[2]/ul/li/input")).isDisplayed();
		if(f == true){
			r.findElement(By.cssSelector("html body div.header div.header-content div.header-right div.gfilter-section div.span-line.search-box div.dropdown-group.dropdown-right.open div.dropdown-menu.advance-box.br-radius.advanced-menu-width-fix div.drop-content.br-radius div.filter-panel div.slimScrollDiv div#filter-panel div#source.ft-wp.content-1 ul li input")).click();
		}else{
			System.out.println("No filters available under" +r.findElement(By.cssSelector("html body div.header div.header-content div.header-right div.gfilter-section div.span-line.search-box div.dropdown-group.dropdown-right.open div.dropdown-menu.advance-box.br-radius.advanced-menu-width-fix div.drop-content.br-radius div.side-tab div.slimScrollDiv ul#filterTab.nav-tab li a#source.ft-link.active")).getText());
		}}catch(Exception e){
			e.printStackTrace();
		}try{
		r.findElement(By.cssSelector("html body div.header div.header-content div.header-right div.gfilter-section div.span-line.search-box div.dropdown-group.dropdown-right.open div.dropdown-menu.advance-box.br-radius.advanced-menu-width-fix div.drop-content.br-radius div.date-control input.btn-submit")).click();
		boolean m = r.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div[2]/div[1]/div/ul/li[1]/div[1]/div[4]")).isDisplayed();
		if(m == true){
			System.out.println("Conversations are filtered & displayed");}
		else{
			System.out.println("No conversations were found. Test case failed");
		}}catch(Exception e){
			e.printStackTrace();
		}
	}
	@AfterTest
	public void close(){
		r.quit();
	}
		
	}

