package mavenproject.packages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingMultibrowser {

	public static WebDriver driver;
	
	@BeforeClass
	public static void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatesh\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/trains");
	}
	
	@Test(priority = 0)
	public static void status()
	{
		driver.findElement(By.xpath("//a[contains(@title,'Check PNR Status')]")).click();
		driver.findElement(By.xpath("//a[contains(@title,'Cancel trains')]")).click();
	}
	
	@Test (priority = 1)
	public static void windowhanlde() throws InterruptedException
	{
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> itr = wh.iterator();
		String mainwindow = itr.next();
		String cancelwindow = itr.next();
		String pnrwindow = itr.next();
		
		Thread.sleep(3000);
		driver.switchTo().window(mainwindow);
		System.out.println(mainwindow);
		System.out.println("Mainwindow Title is:" +driver.getTitle());
		Thread.sleep(3000);
		driver.switchTo().window(pnrwindow);
		System.out.println(pnrwindow);
		System.out.println("PNR window title is:" +driver.getTitle());
		Thread.sleep(3000);
		driver.switchTo().window(cancelwindow);
		System.out.println(cancelwindow);
		System.out.println("Cancel window Title is:" +driver.getTitle());
		Thread.sleep(3000);
		driver.switchTo().window(pnrwindow);
		driver.findElement(By.name("pnr")).sendKeys("837458398");
		driver.findElement(By.name("commit")).click();
	}
	
	@AfterClass
	public static void teardown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
}
