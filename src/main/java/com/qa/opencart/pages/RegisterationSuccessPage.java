package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterationSuccessPage {
	
	private WebDriver driver;
	private ElementUtil ele;
	private By successMsg=By.xpath("//div[@id='content']//h1");
	private By Logout=By.xpath("(//a[text()='Logout'])[last()]");
	
	public  RegisterationSuccessPage(WebDriver driver) {
		this.driver=driver;
		ele=new ElementUtil(driver);
		
	}
	
	public String getPageHeader() {
		return ele.waitForGetText(successMsg, 10);
		
	}
	
	public void logout() {
		ele.doclick(Logout);
	}

}
