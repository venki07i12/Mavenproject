package rahuleshettyExtentReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

public class Test3 extends base {
	
static ExtentReports extent;
	
	static WebDriver driver;
		
	@Test
	public static void ediboxvalidation() {
	
		driver = initializedriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("Testing");
		System.out.println(driver.getTitle());
		Assert.assertTrue(false);
		driver.close();
		
	}

}
