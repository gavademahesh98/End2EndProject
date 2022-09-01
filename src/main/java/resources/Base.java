package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
    public Properties prop;
	public  WebDriver initilizeDriver() throws IOException 
	{
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\MAHESH\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//String browsername=System.getProperty("browser");
	String browsername=prop.getProperty("browser");
	if(browsername.contains("chrome"))
	{
		WebDriverManager.chromedriver().setup();
	ChromeOptions	options=new ChromeOptions();
	if(browsername.contains("headless")) 
	{
	options.addArguments("--headless");
	}
	WebDriver driver =new ChromeDriver(options);
	}
	else if(browsername.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else if(browsername.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
	}
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	return driver;
	}
public String getscreenshotpath(String testcaseName,WebDriver driver) throws IOException {
        TakesScreenshot ss=(TakesScreenshot)driver;
       File source=ss.getScreenshotAs(OutputType.FILE);
       String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
      FileUtils.copyFile(source, new File(destinationFile));
	return destinationFile;
}

}
