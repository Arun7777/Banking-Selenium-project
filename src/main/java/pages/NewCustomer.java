package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	WebDriver driver;
	public NewCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement CustomerName;
	
	@FindBy(name = "rad1")
	WebElement gender;
	
	@FindBy(xpath = "//input[@id='dob']")
	WebElement DOB;
	
	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement CustomerAddress;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath = "//input[@name='pinno']")
	WebElement PIN;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement mobile;
	
	@FindBy(xpath = "//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@name='sub']")
	WebElement submit;
	
	@FindBy(xpath = "//input[@name='res']")
	WebElement reset;
	
	@FindBy(xpath = "//tbody/tr[4]/td[2]")
	WebElement customerId;
	
//	###############################################
	
	public void setCustomerName(String cusName) {
		CustomerName.sendKeys(cusName);
	}
	public void setGender(String Gender) {
		gender.click();
	}
	
	public void setDay(String dd) {
		DOB.sendKeys(dd);
	}
	
	public void setMonth(String mm) {
		DOB.sendKeys(mm);
	}
	
	public void setYear(String yyyy) {
		DOB.sendKeys(yyyy);
	}
	
	public void SetcustomerAddress(String add) {
		CustomerAddress.sendKeys(add);
	}
	public void setCity(String arg) {
		city.sendKeys(arg);
	}
	
	public void setState(String arg) {
		state.sendKeys(arg);
	}
	
	public void setPIN(String arg) {
		PIN.sendKeys(arg);
	}
	
	public void setMobileNumber(String arg) {
		mobile.sendKeys(arg);
	}
	
	public void setPassword(String arg) {
		password.sendKeys(arg);
	}
	
	public void setEmail(String arg) {
		email.sendKeys(arg);
	}
	
	public void clickSubmit() {
		submit.click();
	}
	public void reset() {
		reset.click();
	}
	
//	#####################Confirmation############################
	
	public boolean isSuccessfull() {
		return driver.getPageSource().contains("Customer Registered Successfully!!!");
	}
	
	public String getCustermerID() {
		return customerId.getText();
	}
	
}
