package mavenproject.packages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Handling_Movement_Mwindows_Alert {
	
public static WebDriver driver;
	
	@BeforeMethod
	public static void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatesh\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.epfindia.gov.in/site_en/index.php");
	}
	
	@Test
	public static void handlingbrow() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'×')])[2]")).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@title='Our Services' and @class='menu__link']"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Principal Employers')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'TRRN Query Search')]")).click();
		Set <String> wh = driver.getWindowHandles();
		Iterator<String> itr = wh.iterator();
		String epf = itr.next();
		String TRRN = itr.next();
		String CAIU = itr.next();
		Thread.sleep(3000);
		driver.switchTo().window(epf);
		System.out.println(epf);
		System.out.println("Main window Title is: " +driver.getTitle());
		Thread.sleep(3000);
		driver.switchTo().window(TRRN);
		System.out.println(TRRN);	
		System.out.println("TRRN window Title is: " +driver.getTitle());
		Thread.sleep(3000);
		driver.switchTo().window(CAIU);
		System.out.println(CAIU);
		System.out.println("CAIU window Title is: " +driver.getTitle());
		Thread.sleep(3000);
		driver.switchTo().window(TRRN);
		driver.findElement(By.id("txtTrrn")).sendKeys("8673486864");
		driver.findElement(By.xpath("//button[@id='btnFilter']")).click();
		Thread.sleep(2000);
		Alert alt = driver.switchTo().alert();
		alt.accept();
		Thread.sleep(3000);
		driver.switchTo().window(epf);
		System.out.println(epf);
		
	}
	
	@AfterMethod
	public static void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
}


