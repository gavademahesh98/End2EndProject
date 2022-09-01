package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitleTest extends Base {
	LandingPage lap;
	public WebDriver driver;
	private static Logger	log=LogManager.getLogger( ValidateTitleTest.class);
	@BeforeTest
	public void initilizeandlaunch() throws IOException {
		driver=initilizeDriver();
		log.info("driver is initialize");
		driver.get(prop.getProperty("url"));
		log.info("Hit the url sucessfull");
		 lap=new LandingPage(driver);
	JavascriptExecutor	js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", lap.getcancel());
		
	}
     @Test
     public void getTitleTxt() throws IOException {

	 lap=new LandingPage(driver);
	Assert.assertEquals(lap.gettxt().getText(), "FEATURED COURSES123");
	log.info("succesfully validate get the text of featured cources");
	Assert.assertTrue(lap.getnavigation().isDisplayed());
	log.info("navigation bar is dispalyed");
     }
     @Test
     public void validateHeader() {
    	 Assert.assertEquals(lap.getheader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
    	 log.info("successfully validate header");
     }
     
     
 	@AfterTest
 	public void TeardownEnv() {
 		driver.close();
 		log.info("succesfully close the website");
 	}
}