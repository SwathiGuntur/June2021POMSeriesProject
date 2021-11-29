package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.factory.DriverFactory;

public class ElementUtil {
	
	private WebDriver driver;
	private  JavaScriptutil js;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
		js=new JavaScriptutil(driver);
	}
	
	public String waitForTitle(String fullTitle,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		if(wait.until(ExpectedConditions.titleIs(fullTitle))) {
			return driver.getTitle();
		}
		
		return null;
	}
	
	public String waitForGetText(By locator,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
		
	}
	
	public boolean waitForLinkExist(By locator,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
	}
	

	
	public WebElement getElement(By locator) {
		
		WebElement ele=driver.findElement(locator);
		
		if(Boolean.parseBoolean(DriverFactory.highLight.trim())) {
		   js.flash(ele);
		}
		return ele;
	}
		

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isEnabled();
	}

	

	public void waitForClickLoginBtn(By emailId,By password,By login,int timeout,String userName, String pwd) {
		
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(emailId)).sendKeys(userName);
		wait.until(ExpectedConditions.presenceOfElementLocated(password)).sendKeys(pwd);
		//wait.until(ExpectedConditions.presenceOfElementLocated(login)).click();
		
	}
	
	public void doSendkeys(By locator,String value) {
		getElement(locator).sendKeys(value);
		//getElement(locator).clear();
		
	}
	
	public void doclick(By locator) {
		
		getElement(locator).click();
		
		
	}
	
	public void doClear(By locator) {
		getElement(locator).clear();
	}
	
	public List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public List<String> listOfTextMessages(By locator) {
		
		
		List<String> list=new ArrayList<String>();
		for(WebElement element: getElements(locator)) {
			list.add(element.getText());
	}
		return list;
	}
	
	public String AccPageUrl() {
		return driver.getCurrentUrl();
	}
}
