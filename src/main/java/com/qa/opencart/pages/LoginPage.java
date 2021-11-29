package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil ele;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.ele=new ElementUtil(driver);
		
	}
	// private By locators

	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By login = By.xpath("//input[@value='Login' and @type='submit']");
	private By forgotPassword = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
	private By header = By.xpath("//div[@id='logo']//h1//a[text()='Your Store']");
	private By headersLink = By.xpath("//a[text()='Desktops']");
	private By laptopsLink = By.xpath("//a[text()='Laptops & Notebooks']");
	private By componentsLink = By.xpath("//a[text()='Components']");
	private By tabletsLink = By.xpath("//a[text()='Tablets']");
	private By softwareLink = By.xpath("//a[text()='Software']");
	private By phonesLink = By.xpath("//a[text()='Phones & PDAs']");
	private By camerasLink = By.xpath("//a[text()='Cameras']");
	private By playersLink = By.xpath("//a[text()='MP3 Players']");
	private By rigisterLink=By.linkText("Register");
	

	public String getLoginPageTitle() {
		return ele.waitForTitle(Constants.LOGIN_PAGE_TITLE, Constants.TIME_OUT_ONE);
	}

	public String getPageHeaderText() {
		return ele.waitForGetText(header,Constants.TIME_OUT_THREE);

	}

	public boolean isForgotPwdLinkExist() {
		return ele.waitForLinkExist(forgotPassword, Constants.TIME_OUT_TWO);
	}

	public AccountPage doLogin(String userName, String pwd) {
		//ele.waitForClickLoginBtn(emailId, password, login, Constants.TIME_OUT_TWO, userName, pwd);
		ele.doSendkeys(emailId, userName);
		ele.doSendkeys(password, pwd);
		ele.doclick(login);
		return new AccountPage(driver);
	}

	public boolean isHeadersLink() {
		return ele.doIsDisplayed(headersLink);
	}

	public boolean isLaptopsLink() {
		return ele.doIsDisplayed(laptopsLink);
	}

	public boolean isComponentsLink() {
		return ele.doIsDisplayed(componentsLink);
	}

	public boolean isTabletsLink() {
		return ele.doIsDisplayed(tabletsLink);
	}

	public boolean isSoftwareLink() {
		return ele.doIsDisplayed(softwareLink);
	}

	public boolean isPhonesLink() {
		return ele.doIsDisplayed(phonesLink);
	}

	public boolean isCamerasLink() {
		return ele.doIsDisplayed(camerasLink);
	}

	public boolean isPlayersLink() {
		return ele.doIsDisplayed(playersLink);
	}
	
	public RegisterPage navigateRigisterPage() {
		ele.doclick(rigisterLink);
		return new RegisterPage(driver);
	}

}
