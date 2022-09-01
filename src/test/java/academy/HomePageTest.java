package academy;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.Base;

public class HomePageTest extends Base {
	public WebDriver driver;
	private static Logger	log=LogManager.getLogger( HomePageTest.class);
	@BeforeTest
	public void initilizeandlaunch() throws IOException {
		driver=initilizeDriver();
		log.info("driver is initialize");

	}
	@Test(dataProvider="getdata")
	public void basepagenavigation(String emailid,String Password) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Navigate to HomePage");
		
		LandingPage lap=new LandingPage(driver);
	JavascriptExecutor	js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lap.getlogin());
		log.info(" succesfully Clicked on link of login");
		
		
		LogInPage	logpg=new LogInPage(driver);
		logpg.getEmail().sendKeys(emailid);
		log.info("succesfully send EmailId");
		logpg.getPassword().sendKeys(Password);
		log.info("succesfully send Password");
		logpg.getLogINBTN().click();
		log.info("succesfully clicked login button");

	}
	@DataProvider
	public Object[][] getdata() {
	Object[][]	data=new Object[2][2];
	data[0][0]="abc@gmail.com";
	data[0][1]="ABC@123";
	data[1][0]="mahesh@gmail.com";
	data[1][1]="Mahesh@8798";
	return data;
	}
	@AfterTest
	public void TeardownEnv() {
		driver.close();
		log.info("succesfully close the website");
	}

}
