package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencare.util.Elementutil;
import com.qa.opencart.constants.constants;

import bsh.org.objectweb.asm.Constants;

public class Createoffer {
	private WebDriver driver;
	private Elementutil eleutil;
	private By CandidateName=By.id("employee_name");
	private By logoutlink=By.xpath("//a[@ng-click='logout()']");
	
public Createoffer(WebDriver driver)
{
	this.driver=driver;
	eleutil=new Elementutil(this.driver);
}

public String getOffersPageTitle()
{
	return eleutil.waitForTitleIs(constants.CREATE_OFFER_TITLE,constants.DEFAULT_TIME_OUT);
}
public String getOffersPageUrl()
{
	return eleutil.waitForUrlContains(constants.CREATE_OFFER_PAGE_URL,constants.DEFAULT_TIME_OUT);	
}
public boolean isLogoutLinkExist()
{
	return eleutil.waitForElementVisible(logoutlink,constants.DEFAULT_ELEMENT_TIME_OUT).isDisplayed();
}
public void clickOnLogin()
{
	if(isLogoutLinkExist())
	eleutil.doClick(logoutlink);
		
	}
}
