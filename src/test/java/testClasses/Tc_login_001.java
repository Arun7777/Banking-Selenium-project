package testClasses;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
	public WebDriver driver;
	LoginPage loginpage;
	Logger log = LogManager.getLogger(Tc_login_001.class.getName());

	@BeforeClass

	public void setup() {
		driver = initilize_driver();
		loginpage = new LoginPage(driver);
		
		 
	}

	@Test()
	public void validateTitle() {
		log.info("validating Title");
		String actual = loginpage.validateTitle();
		String expected = "Guru99 Bank Home Pag";
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
		loginpage.setUserId("mngr363047");
			log.info("Entered user id");
		loginpage.setPassword("yrAtAg");
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
