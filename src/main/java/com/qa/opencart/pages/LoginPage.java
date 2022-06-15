package com.qa.opencart.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.qa.opencare.util.Elementutil;
import com.qa.opencart.constants.constants;

public class LoginPage {
	private WebDriver driver;
	private Elementutil eleutil;
//1.private by locator we need to maintain
	//no other class can access them we need to access them by using public class
	private By id=By.id("username");
	private By password=By.id("password");
	private By loginBtn=By.xpath("//button[@text='Login']");
	//private By forgotPwdLink=By.linkText("Forgotten Password");
	//private By registerLink=By.linkText("register");
	
	//page constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		eleutil=new Elementutil(driver);
	}
	
	
	//page actions
	public String  getLoginPageTitle()
	{
	return eleutil.waitForTitleIs(constants.LOGIN_PAGE_TITLE,constants.DEFAULT_ELEMENT_TIME_OUT);
	}
	public  String getloginPageUrl()
	{
		return eleutil.waitForUrlIs(constants.LOGIN_PAGE_URL_FRACTION,constants.DEFAULT_ELEMENT_TIME_OUT);
	}
	public  Createoffer doLogin(String un, String pwd)
	{
		System.out.println("login credentials are:"+ un +":"+pwd );
		eleutil.waitForElementVisible(id,constants.DEFAULT_TIME_OUT).sendKeys(un);
		eleutil.doSendKeys(password,pwd);
		eleutil.doClick(loginBtn);
		return new Createoffer(driver);
		
	}
//	public boolean isPwdLinkExist()
//	{
//		return eleutil.doIsDisplayed(forgotPwdLink);
//	}
//	public boolean isRegisterLinkExist()
//	{
//	return eleutil.doIsDisplayed(registerLink);
//	}
}