package rahuleshettyExtentReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

public class Test1 extends base {
	
static ExtentReports extent;
	
	static WebDriver driver;
		
	@Test
	public static void initialdemo() {
	
		driver = initializedriver();
		driver.get("https://rahulshettyacademy.com");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		driver.close();
	
	}

}
