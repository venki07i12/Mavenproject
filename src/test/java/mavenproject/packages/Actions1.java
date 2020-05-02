package mavenproject.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Actions1 {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public static void setup()
	{
	//setup browser defaults
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatesh\\Downloads\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://jqueryui.com/droppable/");
	}
	
	@Test (priority=0)
	public static void dragable()
	{
		WebElement we = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(we);
		WebElement src = driver.findElement(By.xpath("//div[@id='draggable']"));
		new Actions(driver).dragAndDropBy(src, 150, 220).build().perform();
		WebElement trg = driver.findElement(By.xpath("//div[@id='droppable']"));
		new Actions(driver).dragAndDrop(src, trg).build().perform();
				
	}
	
	@Test(priority=1)
	public static void mousemovement1() throws InterruptedException
	{
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(driver.findElement(By.linkText("Contribute"))).build().perform();
	
	}
	
	@Test(priority=2)
	public static void mousemovement2() throws InterruptedException
	{
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.linkText("Contribute"))).build().perform();
		driver.findElement(By.linkText("Code")).click();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.linkText("Support"))).build().perform();
	
	}
	
	
	@AfterMethod
	public static void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
}
