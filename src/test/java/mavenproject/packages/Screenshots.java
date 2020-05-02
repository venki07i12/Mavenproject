package mavenproject.packages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Screenshots {

	public static WebDriver driver;
	
	@Test
	public static void setup() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatesh\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.id("login1")).sendKeys("venki07i12");
		driver.findElement(By.id("password")).sendKeys("venki@34");
		driver.findElement(By.name("proceed")).click();
		try {
		
		WebElement we = driver.findElement(By.xpath("//a[@class='rd_logout']"));
		if(we.isDisplayed()) 
		System.out.println("Login successfull");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Login Failed");
			File src = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		  //File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(src, new File("D:\\Selenium Testing/testing6.jpg"));
		}
			
	}
	
	
}
