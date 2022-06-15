package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencare.util.Elementutil;
import com.qa.opencart.constants.constants;

import bsh.org.objectweb.asm.Constants;

public class SearchResultsPage {
	private WebDriver driver;
	private Elementutil eleUtil;
	private By searchresults=By.cssSelector("div.product-layout.product-grid");
	
	
		public int getSearchResultsCount() {
			return eleUtil.waitForElementsVisible(searchresults, constants.DEFAULT_ELEMENT_TIME_OUT).size();
		}
		
		public Productinfo selectProduct(String productName)
		{
			By ProductnameLink=By.linkText(productName);
			eleUtil.doClick(ProductnameLink);
			return new Productinfo(driver);
		}
		
		
		
	}
	

