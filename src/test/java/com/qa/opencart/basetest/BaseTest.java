package com.qa.opencart.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.Createoffer;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.Productinfo;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {
	public DriverFactory df;
	public WebDriver driver;
	protected LoginPage loginpage;
	protected Createoffer createoff;
	protected AccountsPage accpage;
	public Properties prop;
	protected Productinfo productinfopage; 
	protected SearchResultsPage searchResPage;
	

@BeforeTest

public void setup()
{
	df=new DriverFactory();
	driver=df.init_driver(prop);
	loginpage=new LoginPage(driver);
	
}

@AfterTest
public void teardown()
{
	driver.quit();
}
}
