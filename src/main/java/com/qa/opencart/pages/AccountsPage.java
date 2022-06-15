package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencare.util.Elementutil;
import com.qa.opencart.constants.constants;

import bsh.org.objectweb.asm.Constants;

public class AccountsPage {
	private By header = By.cssSelector("div#logo a");
	private By logoutLink = By.linkText("Logout");
	private By sectionsHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	private WebDriver driver;
	private static Elementutil eleUtil;
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new Elementutil(this.driver);
	}
	public String getAccountsPageTitle() {
		return eleUtil.waitForTitleIs(constants.ACCOUNTS_PAGE_TITLE, constants.DEFAULT_TIME_OUT);
	}
	public static String getAccountsPageURL() {
		return eleUtil.waitForUrlContains(constants.ACCOUNTS_PAGE_URL_FRACTION, constants.DEFAULT_TIME_OUT);
	}

	public String getAccPageHeader() {
		return eleUtil.doGetText(header);
	}
	public List<String> getAccountsPageSectionsList() {
		List<WebElement> secList = eleUtil.getElements(sectionsHeaders);
		List<String> secValList = new ArrayList<String>();
		for (WebElement e : secList) {
			String text = e.getText();
			secValList.add(text);
		}
		return secValList;
	}
	public boolean isLogoutLinkExist() {
		return eleUtil.waitForElementVisible(logoutLink, constants.DEFAULT_ELEMENT_TIME_OUT).isDisplayed();
	}
	public boolean isSearchExist() {
		return eleUtil.waitForElementVisible(search, constants.DEFAULT_ELEMENT_TIME_OUT).isDisplayed();
	}
	
	public SearchResultsPage doSearch(String searchKey) {
		if(isSearchExist())
		{
			if(isSearchExist()) {
				eleUtil.doSendKeys(search, searchKey);
				eleUtil.doClick(searchIcon);
				return new SearchResultsPage(driver);
			}
			
		}
		return null;
	}
	public Object clickOnLogout() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}



