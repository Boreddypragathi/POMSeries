package com.qa.opencart.tests;

import org.bouncycastle.crypto.CryptoServicesRegistrar.Property;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.constants.constants;
import com.qa.opencart.pages.LoginPage;

public class Loginpagetest extends BaseTest {
	@Test(priority=1)
	public void getLoginPageTitle() {
		String acttitle = loginpage.getLoginPageTitle();
		System.out.println("login page title is" + acttitle);
		Assert.assertEquals(acttitle, constants.LOGIN_PAGE_TITLE);

	}

	@Test(priority=2)
	public void loginPageURLTest() {
		String acturl = loginpage.getloginPageUrl();
		System.out.println("login page title is" + acturl);
		Assert.assertTrue(acturl.contains(constants.LOGIN_PAGE_URL_FRACTION));

	}

//	@Test
//	public void forgotPWDLinkExistsTest() {
//		Assert.assertTrue(loginpage.isPwdLinkExist());
//	}
//
//	@Test
//	public void registerExistTest() {
//		Assert.assertTrue(loginpage.isRegisterLinkExist());
//	}

	@Test(priority=3)
	public void loginTest() {
		Assert.assertTrue(loginpage
		.doLogin(prop.getProperty("id").trim(),prop.getProperty("password").trim());
		  .isLooutLinkExist());
		
	}

private void isLooutLinkExist() {
	// TODO Auto-generated method stub
	
}

}
