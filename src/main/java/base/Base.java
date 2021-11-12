package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver ;
	public Properties prop;
	
	public Base() throws IOException {		
		prop = new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\\\utils\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop.load(file);
	}
	


	public WebDriver initilize_driver() throws IOException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arun\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver  = new ChromeDriver();
		driver.get(prop.getProperty("url"));
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
