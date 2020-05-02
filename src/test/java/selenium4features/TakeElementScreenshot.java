package selenium4features;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class TakeElementScreenshot {

	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatesh\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://app.hubspot.com/login");
		
		WebElement email = driver.findElement(By.id("username"));
		WebElement pwd = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("loginBtn"));
		
	//File src = email.getScreenshotAs(OutputType.FILE);
	//Files.copy(src, new File("D:\\Selenium Testing\\MindQ\\mavenproject\\target\\screenshot\\email.png"));
	//FileUtils.copyFile(src, new File("D:\\Selenium Testing\\MindQ\\mavenproject\\target\\email.png"));
		
		email.sendKeys("venki07i12@gmail.com");
		pwd.sendKeys("venki@34");
		
		takelementscreenshot(email, "emailelement");
		takelementscreenshot(pwd, "passwordElement");
		takelementscreenshot(login, "LoginElement");
		
		driver.quit();
		
	}
		public static void takelementscreenshot(WebElement element, String filename)
		{
			File src = element.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File("D:\\Selenium Testing\\MindQ\\mavenproject\\target\\screenshot\\"+filename+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	

}
