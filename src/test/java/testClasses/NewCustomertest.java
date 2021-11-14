package testClasses;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pages.Homepage;
import pages.LoginPage;
import pages.NewCustomer;

public class NewCustomertest extends Base {

	public WebDriver driver;
	Homepage homepage;
	Properties prop = propertyFile();

	@BeforeClass
	public void setup() throws IOException {
		driver = initilize_driver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUserId(prop.getProperty("userid"));
		loginpage.setPassword(prop.getProperty("password"));
		homepage = loginpage.clickLoginButton();
		homepage.clickNewCustomer();
	}

	@Test
	public void addNewCustomer() throws InterruptedException {
		NewCustomer customer = new NewCustomer(driver);

		customer.setCustomerName("Ar");
		customer.setGender("male");
		customer.setDay("22");
		customer.setMonth("02");
		customer.setYear("1980");
		customer.SetcustomerAddress("hyderabad");
		customer.setCity("hyd");
		customer.setState("tel");
		customer.setPIN("500001");
		customer.setMobileNumber("987654322");
		customer.setEmail("mo@gnail.com");
		customer.setPassword("arrrrrrrr");
		customer.clickSubmit(); 	 
		if( customer.isSuccessfull()) {
			assertTrue(true);
		}else { 
			assertTrue(false);
		}
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
