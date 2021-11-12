package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	public WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this );
	}
	
//	######################variables##############################
	
	@FindBy(linkText = "New Customer")
	WebElement newCustomer;
	
	@FindBy(linkText = "New Account")
	WebElement newAccount;
//	########################actions##############################
	
	public NewCustomer clickNewCustomer() {
		newCustomer.click();
		return new NewCustomer(driver);
	}
	
	public void ClickNewAccount() {
		newAccount.click();	
	}
	
//	#######################validations##############################
	
	public String validateTitle() {
		return driver.getTitle();
	}
	public boolean validatePage() {
		return driver.getPageSource().contains("Welcome To Manager's Page of Guru99 Bank");
	}
}
