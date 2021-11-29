package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest{
	
	@BeforeClass
	public void productPageSetup() {
		accPage=login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Test
	public void PageImagesListTest() {
		
		resultsPage =accPage.doSearch("MacBook");
		product=resultsPage.doSelectProduct("MacBook");
		Assert.assertEquals(product.getPageImagesList(),5);
		
	}
	
	@Test
	public void productInfoTest() {
		
		resultsPage =accPage.doSearch("MacBook");
		product=resultsPage.doSelectProduct("MacBook");
		Map<String,String> accProductMap=product.getProductMetaData();
		Assert.assertEquals(accProductMap.get("name"),"MacBook");
		Assert.assertEquals(accProductMap.get("Product Code"),"Product 16");
		Assert.assertEquals(accProductMap.get("Reward Points"),"600");
		Assert.assertEquals(accProductMap.get("Availability"),"Out Of Stock");
		Assert.assertEquals(accProductMap.get("price"),"$500.00");
		Assert.assertEquals(accProductMap.get("exTaxPrice"),"Ex Tax: $500.00");
		
	}
	
	
}
