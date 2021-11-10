package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver ;
	
	public WebDriver initilize_driver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arun\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver  = new ChromeDriver();
		driver.get("http://demo.guru99.com/V4/");
		driver.manage().window().maximize();
		return driver;
	}
	
	public String takeScreenShot(String testMethodName, WebDriver driver) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\screenshot\\"+testMethodName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		System.out.println("captured screenshot");
		return destinationFile;
	}
}
