package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.RegisterationSuccessPage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Errors;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String title = login.getLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, Errors.TITLE_ERROR_MESSAGE);
	}

	@Test(priority = 2)
	public void LoginPageHeaderTest() {
		String header = login.getPageHeaderText();
		Assert.assertEquals(header, Constants.LOGIN_PAGE_HEADER, Errors.HEADER_ERROR_MESSAGE);
	}

	@Test(priority = 3)
	public void forgotPasswordLinkTest() {

		Assert.assertTrue(login.isForgotPwdLinkExist());

	}

	@Test(priority = 12)
	public void loginTest() {

		AccountPage accPage=login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutExist());
	}

	@Test(priority = 4)
	public void headersLinkTest() {
		Assert.assertTrue(login.isHeadersLink());
	}

	@Test(priority = 5)
	public void tanbletsLinkTest() {
		Assert.assertTrue(login.isTabletsLink());
	}

	@Test(priority = 6)
	public void laptopLinkTest() {
		Assert.assertTrue(login.isLaptopsLink());
	}

	@Test(priority = 7)
	public void camerasLinkTest() {
		Assert.assertTrue(login.isCamerasLink());
	}

	@Test(priority = 8)
	public void componentsLinkTest() {
		Assert.assertTrue(login.isComponentsLink());
	}

	@Test(priority = 9)
	public void phonesLinkTest() {
		Assert.assertTrue(login.isPhonesLink());
	}

	@Test(priority = 10)
	public void softwareLinkTest() {
		Assert.assertTrue(login.isSoftwareLink());
	}

	@Test(priority = 11)
	public void playersLinkTest() {
		Assert.assertTrue(login.isPlayersLink());
	}
	
	
	@DataProvider
	public Object[][] testDataForRegisterPage() {
		Object[][] obj={{"ooo","uuu","","a@bc123","a@bc123","yes"},
				{"rrr","ttt","8888777789","abc@123","abc@123","yes"},
				{"qqq","www","8888777789","abcd@123","abcd@123","yes"}};
		return obj;
	}
	
	@Test(dataProvider="testDataForRegisterPage")
	public void RegisterPageTest(String fName,String lName,
			String phoneNo,String pwd,String cPwd,String subscribe) {
		registerPage=login.navigateRigisterPage();
		 successPage=registerPage.fillRegisterForm(fName, lName, registerPage.getRandomEmail(), phoneNo, pwd, cPwd, subscribe);
		Assert.assertEquals(successPage.getPageHeader(),Constants.RIGISTER_SUCCESS_PAGE_HEADER);
		successPage.logout();
	}
}
