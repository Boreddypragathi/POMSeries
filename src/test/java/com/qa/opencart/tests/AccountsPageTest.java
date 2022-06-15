package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.constants.constants;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

import bsh.org.objectweb.asm.Constants;

public class AccountsPageTest extends BaseTest {

		@BeforeClass
		public void accSetup() {
			 accpage = LoginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
			//accPage = new AccountsPage(driver);
		}

		@Test
		public void accPageTitleTest() {
			String actTitle = accpage.getAccountsPageTitle();
			System.out.println("Acc page title: " + actTitle);
			Assert.assertEquals(actTitle, constants.ACCOUNTS_PAGE_TITLE);
		}

		@Test
		public void accPageURLTest() {
			String actURL = AccountsPage.getAccountsPageURL();
			System.out.println("Acc page URL: " + actURL);
			Assert.assertTrue(actURL.contains(constants.ACCOUNTS_PAGE_URL_FRACTION));
		}

		@Test
		public void accPageHeaderTest() {
			Assert.assertEquals(accpage.getAccPageHeader(), constants.ACCOUNTS_PAGE_HEADER);
		}

		@Test
		public void accPageSectionsTest() {
			List<String> actAccSecList = accpage.getAccountsPageSectionsList();
			System.out.println("Act Accounts Section list: " + actAccSecList);
			Assert.assertEquals(actAccSecList, constants.EXPECTED_ACCOUNTS_SECTION_LIST);
		}

		@Test
		public void logoutLinkTest() {
			Assert.assertTrue(accpage.isLogoutLinkExist());
		}

		@Test
		public void SearchExistTest() {
			Assert.assertTrue(accpage.isSearchExist());
		}

		@Test
		public void logoutTest() {
			Assert.assertEquals(accpage.clickOnLogout().getLogoutSuccessMessg(), constants.LOGOUT_SUCCESS_MESSG);
		}
		
		@DataProvider
		public Object[][] getSearchKey() {
			return new Object[][] { { "Macbook" }, { "iMac" }, { "Apple" }, { "Samsung" } };
		}
		
@Test(dataProvider = "getSearchKey")
public void searchTest(String searchKey) {
	searchResPage = accpage.doSearch(searchKey);
	Assert.assertTrue(searchResPage.getSearchResultsCount() > 0);
}
@Test(dataProvider = "getProductName")
public void selectProductTest(String searchKey, String productName) {
	searchResPage = accpage.doSearch(searchKey);
	productinfopage = searchResPage.selectProduct(productName);
	String productHeader = productinfopage.getProductHeaderName();
	System.out.println("product header: " + productHeader);
	Assert.assertEquals(productHeader, productName);
	//@dataprovider
}
}
