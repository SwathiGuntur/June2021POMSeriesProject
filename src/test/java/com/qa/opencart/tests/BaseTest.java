package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.RegisterationSuccessPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {
	
	WebDriver driver;
	DriverFactory df;
	Properties prop;
	LoginPage login;
	AccountPage accPage;
	ResultsPage resultsPage;
	ProductPage product;
	RegisterPage registerPage;
	RegisterationSuccessPage successPage;
	@BeforeTest
	public void setup() {
		
		df=new DriverFactory();
		prop=df.intiProperties();
		driver=df.initDriver(prop);
		login=new LoginPage(driver);
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
}

}
