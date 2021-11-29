package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.pages.ResultsPage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class AccountPageTest extends BaseTest{

	@BeforeClass
	public void accPageSetup() {
		accPage=login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void accountPageHeaderTest() {
		
		Assert.assertEquals(accPage.getAccountPageHeader(), Constants.ACCOUNT_PAGE_HEADER);
		
	}
	
	@Test(priority=2)
	public void accountPageTitleTest() {
		
		Assert.assertEquals(accPage.getAccountPageTitle(),Constants.ACCOUNT_PAGE_TITLE);
		
	}
	
	@Test(priority=3)
	public void logoutExistTest() {
		Assert.assertTrue(accPage.isLogoutExist());
	}
	
	@Test(priority=4)
	public void SearchBtnExistTest() {
		Assert.assertTrue(accPage.isSearchBtnExist());
	}
	
	@Test(priority=5)
	public void searchExistTest() {
		Assert.assertTrue(accPage.isSearchExist());
	}
	
	
	/*
	 * @DataProvider public Object[][] getDataTest() {
	 * 
	 * Object[][] obj= {{"macbook"},{"macbook pro"},{"apple"}}; return obj; }
	 */
	
	@DataProvider
	public Object[][] getDataTest() {
		return ExcelUtil.getTestData(Constants.SEARCH_PRODUCT_TEST_DATA);
	}
	
	
	@Test(priority=7, dataProvider="getDataTest")
	public void searchBoxTest(String productName) {
		ResultsPage page=accPage.doSearch(productName);
		Assert.assertTrue(page.getSearchHeader().contains(productName));
		
	}
	
	@Test(priority=6)
	public void AccountSectionListTest() {
		List<String> list=accPage.getAccountSectionList();
		Assert.assertEquals(list,Constants.LIST_DATA);
	}
	
	/*
	 * @DataProvider public Object[][] productTestData() { Object[][] obj=
	 * {{"MacBook","MacBook"}, {"MacBook","MacBook Air"},{"MacBook","MacBook Pro"},{
	 * "Apple","Apple Cinema 30\""}}; return obj;
	 * 
	 * }
	 */
	
	@DataProvider
	public Object[][] productTestData() {

       return ExcelUtil.getTestData(Constants.SELECT_PRODUCT_TEST_DATA);
	
	}
	
	@Test(priority=7,dataProvider="productTestData")
	public void selectedProductTest(String productName,String mainProduct) {
		ResultsPage page=accPage.doSearch(productName);
		 product =page.doSelectProduct(mainProduct);
		String pro=product.getSearchedProduct();
		 System.out.println(pro);
		 Assert.assertEquals(pro, mainProduct);
	}
	
	
	
	 
	
	
	
}
