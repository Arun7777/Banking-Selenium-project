package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	WebElement userId;

	@FindBy(name = "password")
	WebElement  password;

	@FindBy(name = "btnLogin")
	WebElement loginButton;

	@FindBy(name = "btnReset")
	WebElement resetButton;


	public void setUserId(String userid) {
		userId.sendKeys(userid);
	}

	public void setPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickLoginButton() {
		loginButton.click();
	}
	public void clickResetButton() {
		resetButton.click();
	}
	
	public String validateTitle() {
		return driver.getTitle();
	}


}
