package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	private OptionsManager options;
	public static String highLight;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();

	/**
	 * This method is used to initilize the driver
	 * @param browserName
	 * @return
	 */
	public WebDriver initDriver(Properties prop) {

		String browserName=prop.getProperty("browser");
		options=new OptionsManager(prop);
		
		highLight=prop.getProperty("highlight");
		System.out.println("browser name is :" + browserName);

	switch(browserName) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(options.getChromeOptions());
	        tlDriver.set(new ChromeDriver(options.getChromeOptions()));
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options.getFirefoxOptions());
			tlDriver.set(driver);
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			tlDriver.set(driver);
			break;

		default:
			System.out.println("please pass the right browserName");
			break;
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();

	}
	
	public WebDriver getDriver() {
		
		return tlDriver.get();
	}
	
	/**
	 * This method is used to initilize the properties on the basis of given environment
	 * @return
	 */
	
	public Properties intiProperties() {
		 
		Properties prop=null;
		String env=System.getProperty("env");
		System.out.println("application running on "+env);
		FileInputStream fis=null;
		try {
			switch(env) {
			         
			case "qa":
				fis=new FileInputStream("./src/test/resources/config/qa.config.properties");
				break;
				
			case "dev":
				fis=new FileInputStream("./src/test/resources/config/dev.config.properties");
				 break;
				 
			case "stage":
				fis=new FileInputStream("./src/test/resources/config/stage.config.properties");
				 break;
			case "prod":
				fis=new FileInputStream("./src/test/resources/config/config.properties");
				 break;
			
			default:
				System.out.println("please enter valid environment name");
				break;
			}
			
			 prop=new Properties();
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
	public String getScreenshot() {
		TakesScreenshot ts=(TakesScreenshot)getDriver();
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File destination=new File(path);
		
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return path;
	}

}
