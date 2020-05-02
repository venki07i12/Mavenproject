package mavenproject.packages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Autoitex {

	public static WebDriver driver;
	
	@BeforeClass
	public static void setupI()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatesh\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.ilovepdf.com/word_to_pdf");
	}
	
	@Test
	public static void uploadfile() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//span[contains(text(),'Select WORD files')]")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("F:\\Autoit001.exe");
	}
	
	@AfterClass
	public static void teardown()
	{
		//driver.close();
	}
	
}
