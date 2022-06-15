package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencare.util.Elementutil;
import com.qa.opencart.constants.constants;

public class Productinfo {
	private WebDriver driver;
	private static Elementutil eleUtil;
	private By productHeader=By.cssSelector("div#content h1");
	
	public  Productinfo(WebDriver driver) {
		this.driver=driver;
		eleUtil=new Elementutil(this.driver) ;
	}
	public String getProductHeaderName1()
	{
		return eleUtil.waitForElementVisible(productHeader, constants.DEFAULT_ELEMENT_TIME_OUT).getText();
	}
		
		
		
		
		
		
	}

	private String getProductHeaderName() {
		// TODO Auto-generated method stub
		
	}
	
	
}
