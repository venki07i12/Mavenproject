package rahuleshettyExtentReports;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	
	static WebDriver driver;
	public static WebDriver initializedriver() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatesh\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		
		return driver;
		
	}

	public static String getScreenshotpath(String Testcasename) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\ExtentReports\\"+Testcasename+".png"; 
		File file = new File(path);
		FileUtils.copyFile(src, file);
		return path;
	}
	
}
