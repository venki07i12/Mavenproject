package mavenproject.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Laucnch {
	
	public static WebDriver driver;
	//setup()
	
	@BeforeMethod
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatesh\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.licindia.in/");
	}
	@Test
	public static void search()
	{
		driver.findElement(By.id("p_lt_ctl03_SmartSearchBox_txtWord")).sendKeys("policy");
		driver.findElement(By.id("p_lt_ctl03_SmartSearchBox_btnImageButton")).click();
	}
	
	@AfterMethod
	public static void teardown()
	{
		//driver.close();
	}
}
