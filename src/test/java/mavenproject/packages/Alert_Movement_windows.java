package mavenproject.packages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Alert_Movement_windows {

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
	public static void windowhandle() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='close1 img_col']")).click();
		//Actions act = new Actions(driver);
		List<WebElement> list =driver.findElements(By.xpath("//ul[@class='menu img_col']//li/descendant::a[@class='menu__link']"));
		System.out.println(list.size());
		for(int i =0; i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals("Our Services "))
			{
				list.get(i).click();
			}
		}
		Actions act = new Actions(driver);
		WebElement trg = driver.findElement(By.xpath("//a[contains(text(),'Status Of Establishments')]"));
		act.moveToElement(trg).build().perform();
		
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'EPFO Corner')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Principal Employers')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'eKYC Portal')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'TRRN Query')]")).click();
		Set<String> we = driver.getWindowHandles();
		Iterator<String> itr = we.iterator();
		String mainwindow = itr.next();
		String CAIUwindow = itr.next();
		String KYCwindow = itr.next();
		String TRRNwindow = itr.next();
		driver.switchTo().window(mainwindow);
		Thread.sleep(2000);
		driver.switchTo().window(TRRNwindow);
		Thread.sleep(2000);
		driver.switchTo().window(KYCwindow);	
		Thread.sleep(2000);
		driver.switchTo().window(CAIUwindow);
		Thread.sleep(2000);
		driver.findElement(By.id("txtTrrn")).sendKeys("67894576");
		driver.findElement(By.id("btnFilter")).click();
		Alert alt = driver.switchTo().alert();
		Thread.sleep(2000);
		alt.accept();
	}
	
	@AfterMethod
	public static void teardwown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
}
