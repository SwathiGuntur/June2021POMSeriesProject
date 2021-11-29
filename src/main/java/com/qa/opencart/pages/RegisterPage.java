package com.qa.opencart.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil ele;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		ele = new ElementUtil(driver);
	}
	
	private By firstName=By.id("input-firstname");
	private By lastName=By.id("input-lastname");
	private By email=By.id("input-email");
	private By telePhone=By.id("input-telephone");
	private By password=By.id("input-password");
	private By confirmPassword=By.id("input-confirm");
	private By subscriobeYes=By.xpath("(//input[@name='newsletter'])[position()=1]");
	private By subscriobeNo=By.xpath("(//input[@name='newsletter'])[last()]");
	private By agreeCheckBox=By.name("agree");
	private By continueBtn=By.xpath("//input[@value='Continue' and @type='submit']");
	
	public RegisterationSuccessPage fillRegisterForm(String fName,String lName,String emailId,
			String phoneNo,String pwd,String cPwd,String subscribe) {
		
		ele.doSendkeys(firstName, fName);
		ele.doSendkeys(lastName, lName);
		ele.doSendkeys(email, emailId);
		ele.doSendkeys(telePhone, phoneNo);
		ele.doSendkeys(password, pwd);
		ele.doSendkeys(confirmPassword, cPwd);
		
		if(subscribe.equalsIgnoreCase("yes")) {
			ele.doclick(subscriobeYes);
		}
		else {
			ele.doclick(subscriobeNo);
		}
		 ele.doclick(agreeCheckBox);
		 ele.doclick(continueBtn);
		 
		 return new RegisterationSuccessPage(driver);
		
		
	}
	
	public String getRandomEmail() {
		Random random=new Random();
		String email="automationtest"+random.nextInt(5000)+"@gmail.com";
		return email;
	}

}
