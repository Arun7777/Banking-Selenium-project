package testClasses;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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
import pages.Homepage;
import pages.LoginPage;

public class Logintest extends Base{


	private LoginPage loginpage;
	private Homepage homepage;
	private Logger log = LogManager.getLogger(Logintest.class.getName());

	@BeforeClass
	public void setup() throws IOException{
		initializing_driver();
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
		loginpage.setPassword("hksdhnk");
		log.info("Entered Password");
		log.debug("Clicked the button");
		homepage = loginpage.clickLoginButton();
		String actual = homepage.validateTitle();
		String expected = "Guru99 Bank Manager HomePage";
		assertEquals(actual, expected);

	}





	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
