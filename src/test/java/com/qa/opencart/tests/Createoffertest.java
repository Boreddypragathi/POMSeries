package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.constants.constants;
import com.qa.opencart.pages.Createoffer;

public class Createoffertest extends BaseTest{
@BeforeClass
public void creteofferSetUp()
{
	createoff=loginpage.doLogin(prop.getProperty("id").trim(),prop.getProperty("password").trim());
	
	
}
@Test
public void  getOffersPageTitleTest() {
	String offtitle=createoff.getOffersPageTitle();
	System.out.println("offers page title is"+offtitle);
	Assert.assertEquals(offtitle,constants.CREATE_OFFER_TITLE);
}
@	Test
public void getOffersPageUrlTest()
{
	String offurl=createoff.getOffersPageUrl();
	System.out.println("offers page url is"+offurl);
	Assert.assertEquals(offurl,constants.CREATE_OFFER_URL);
}
}

