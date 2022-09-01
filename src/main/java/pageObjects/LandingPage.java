package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	private By signIn=By.cssSelector("a[href*='sign_in']");
	private By text=By.cssSelector(".text-center h2");
	private By navigbar=By.cssSelector(".nav.navbar-nav.navbar-right");
	private By cancel=By.cssSelector("div[class*='sumome-react-sv']");
	private By header=By.cssSelector("div[class*='video-banner'] h3");
	 
	
	public WebElement getlogin() {
		return driver.findElement(signIn);
	}
	
	public WebElement gettxt() {
		return driver.findElement(text);
	}
	
	public WebElement getnavigation() {
		return driver.findElement(navigbar);
	}
	public WebElement getcancel() {
		return driver.findElement(cancel);
	}
	public WebElement getheader() {
		return driver.findElement(header);
	}

}
