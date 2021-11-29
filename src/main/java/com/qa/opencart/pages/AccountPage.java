package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {
	
	private WebDriver driver;
	private ElementUtil ele;
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		ele=new ElementUtil(driver);
		
	}

	private By headers=By.xpath("//div[@id='content']//h2");
	private By accPagemainHeader=By.xpath("//div[@id='logo']//h1//a[text()='Your Store']");
	private By logout=By.xpath("//div[@class='list-group']//a[text()='Logout']");
	private By search=By.name("search");
	private By searchBtn=By.xpath("//div[@id='search']//span//button");
	
	
	public List<String> getAccountSectionList() {
		List<String> list=ele.listOfTextMessages(headers);
		//Collections.sort(list);
		return list;
			
		}
	
	public String getAccountPageTitle() {
		return ele.waitForTitle(Constants.ACCOUNT_PAGE_TITLE, Constants.TIME_OUT_THREE);
	}
	
	public String getAccountPageHeader() {
		return ele.waitForGetText(accPagemainHeader,Constants.TIME_OUT_THREE);
	}
	
	public boolean isLogoutExist() {
		return ele.doIsDisplayed(logout);
	}
	
	public boolean isSearchBtnExist() {
		return ele.doIsDisplayed(searchBtn);
	}
	
	public boolean isSearchExist() {
		return ele.doIsDisplayed(search);
	}
	
	public String getAccPageUrl() {
		return ele.AccPageUrl();
	}
	
	public ResultsPage doSearch(String productName) {
		ele.doClear(search);
		ele.doSendkeys(search, productName);
		ele.doclick(searchBtn);
		//ele.doClear(search);
		return new ResultsPage(driver);
	}
	
	
}
