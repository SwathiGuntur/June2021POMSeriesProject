package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class ProductPage {
	
	private WebDriver driver;
	private By searchedProduct=By.xpath("//div[@id='content']//h1");
	private By imagesList=By.xpath("//ul[@class='thumbnails']//img");
	private By productMetaData=By.xpath("//div[@id='content']//ul[@class='list-unstyled'][position()=1]//li");
	private By priceProduct=By.xpath("//div[@id='content']//ul[@class='list-unstyled'][last()]//li");
	private  Map<String,String> mapList=null;
	
	private ElementUtil ele;
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		ele=new ElementUtil(driver);
		
		}
	
	public String getSearchedProduct() {
		return ele.waitForGetText(searchedProduct, Constants.TIME_OUT_FIVE);
	}
	
	public int getPageImagesList() {
		return ele.getElements(imagesList).size();
	}
	
	public Map<String,String> getProductMetaData() {
		List<WebElement> list=ele.getElements(productMetaData);
		
		mapList=new HashMap<String,String>();
		mapList.put("name", getSearchedProduct());
		
		for(WebElement element : list) {
			
			String[] array=element.getText().split(":");
			mapList.put(array[0].trim(),array[1].trim());
			
		}
		
		List<WebElement> priceList=ele.getElements(priceProduct);
		String price=priceList.get(0).getText().trim();
		String exTaxPrice=priceList.get(1).getText().trim();
		mapList.put("price",price);
		mapList.put("exTaxPrice", exTaxPrice);
		
		return mapList;
		
	}
	

}
