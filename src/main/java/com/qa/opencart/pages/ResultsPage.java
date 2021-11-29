package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class ResultsPage {
	
	private WebDriver driver;
	private ElementUtil ele;
	private By searchHeader=By.xpath("//div[@id='content']//h1");
	private By selectProduct=By.xpath("//div[@class='caption']//a");
	
	public ResultsPage(WebDriver driver) {
		this.driver=driver;
		ele=new ElementUtil(driver);
	}
	
	public String getSearchHeader() {
		return ele.waitForGetText(searchHeader, Constants.TIME_OUT_THREE);
	}
	
	public int getSizeOfProductList() {
		return ele.getElements(selectProduct).size();
	}
	public ProductPage doSelectProduct(String productName) {
		List<WebElement> productList=ele.getElements(selectProduct);
		for(WebElement ele : productList) {
			
			if(ele.getText().trim().equals(productName)) {
				ele.click();
				break;
			}
			
		}
		
		return new ProductPage(driver);
		
	}

}
