package testClasses;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;

public class Tc_login_001 extends Base{
	
	public Tc_login_001() throws IOException {
		super();
	}
	
	public WebDriver driver;
	LoginPage loginpage;
	Logger log = LogManager.getLogger(Tc_login_001.class.getName());

	@BeforeClass
	public void setup() throws IOException{
		driver = initilize_driver();
		loginpage = new LoginPage(driver);	 
	}

	@Test()
	public void validateTitle() {
		log.info("validating Title");
		String actual = loginpage.validateTitle();
		String expected = "Guru99 Bank Home Page";
		if(actual.equals(expected)) {
			log.info("Title is valid");
			assertTrue(true);
			
		}else {
			log.error("Invalid title");
			assertTrue(false);
		}
	}


	@Test()
	public void login() {
		loginpage.setUserId(prop.getProperty("userid"));
			log.info("Entered user id");
		loginpage.setPassword(prop.getProperty("password"));
			log.info("Entered Password");
			log.debug("Clicked the button");
		loginpage.clickLoginButton();
		String actual = driver.getTitle();
		String expectd = "Guru99 Bank Manager HomePage";
		assertEquals(actual, expectd);
			log.error("Login failed");
	}





	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
