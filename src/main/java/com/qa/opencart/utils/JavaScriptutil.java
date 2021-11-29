package com.qa.opencart.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptutil {
	
	private WebDriver driver;
	private JavascriptExecutor js;
	
	public JavaScriptutil(WebDriver driver) {
		this.driver=driver;
		js=(JavascriptExecutor)driver;
	}
	
	public void refreshBrowserByJS() {
		js.executeScript("history.go(0)");
	}
	
	public String getTitleByJS() {
		return js.executeScript("return document.title;").toString();
	}

	public String getPageInnerTextByJS() {
		return js.executeScript("return document.documentElement.innerText").toString();
	}
	
	public void getAlertOnPageByJS(String message) {
		
		 js.executeScript("alert('"+message+"')");
		
	}
	
	public void clickElementByJS(WebElement ele) {
		js.executeScript("arguments[0].click();",ele);
	}
	
	public void sendKeysByJS(String id,String value) {
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}
	
	public void scrollPageUp() {
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	
	}

	public void scrollPageDown() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	
	}
	
	public void scrollPageDown(String height) {
		js.executeScript("window.scrollTo(0,'"+height+"')");
	
	}
	
	public void scrollIntoView(WebElement element) {
	
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void drawBorder(WebElement element) {
		
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");//purple
		for (int i = 0; i < 50; i++) {
			changeColor("rgb(0,200,0)", element);// green
			changeColor(bgcolor, element);// purple
		}
	}

	private void changeColor(String color, WebElement element) {
		
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

}
