package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	public WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this );
	}
}