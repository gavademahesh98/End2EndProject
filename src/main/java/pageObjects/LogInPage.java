package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	public WebDriver driver;

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		
	}

	private By email = By.xpath("//input[@type='email']");
	private By pass = By.xpath("//input[@type='password']");
	private By loginbtn=By.cssSelector("input[type='submit']");

	public WebElement getEmail() {
		return driver.findElement(email);

	}
     public WebElement getPassword() {
    	 return driver.findElement(pass);
     }
     public WebElement getLogINBTN() {
    	 return driver.findElement(loginbtn);
     }
}
